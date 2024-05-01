package org.example.Ex1;

import java.util.List;
import java.util.concurrent.*;

public class Task1_new {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Task task1 = new Task(2, 250000);
        Task task2 = new Task(250001, 500000);
        Task task3 = new Task(500001, 750000);
        Task task4 = new Task(750001, 1000000);

        List<Task> list = List.of(task1, task2, task3, task4);
        executorService.invokeAll(list);

        List<Future<Integer>> futures = executorService.invokeAll(list);

        int result = 0;
        for (Future<Integer> future : futures) {
            result = result + future.get();
        }

        executorService.shutdown();

        System.out.println("Общее количество чисел со всех потоков " + result);
    }

    static class Task implements Callable<Integer> {
        int start;
        int end;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public Integer call() throws Exception {
            int count = 0;
            for (int i = start; i < end; i++) {
                boolean isPrime = true;
                for
                (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime)
                    count++;
            }
            return count;
        }
    }
}
