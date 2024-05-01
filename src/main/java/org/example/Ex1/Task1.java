package org.example.Ex1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* Напишите программу просчета количества всех простых в диапазоне до 1 000 000.
Просчет выполняйте в 4 потоках, которые создаются с помощью Callable.
Получите результаты подсчета из каждого потока и напечатайте общий результат. */

public class Task1 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Integer> task1 = () -> {
            int count = 0;
            for (int i = 2; i < 250000; i++) {
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
        };

        Callable<Integer> task2 = () -> {
            int count = 0;
            for (int i = 250001; i < 500000; i++) {
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
        };

        Callable<Integer> task3 = () -> {
            int count = 0;
            for (int i = 500001; i < 750000; i++) {
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

        };

        Callable<Integer> task4 = () -> {
            int count = 0;
            for (int i = 750001; i < 1000000; i++) {
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
        };


        FutureTask<Integer> future1 = new FutureTask<>(task1);
        new Thread(future1).start();
        System.out.println("Результат первого потока: " + future1.get());

        FutureTask<Integer> future2 = new FutureTask<>(task2);
        new Thread(future2).start();
        System.out.println("Результат второго потока: " + future2.get());

        FutureTask<Integer> future3 = new FutureTask<>(task3);
        new Thread(future3).start();
        System.out.println("Результат третьего потока: " + future3.get());

        FutureTask<Integer> future4 = new FutureTask<>(task4);
        new Thread(future4).start();
        System.out.println("Результат четвёртого потока: " + future4.get());

        int result = future1.get() + future2.get() + future3.get() + future4.get();
        System.out.println("Общее количество чисел со всех потоков: " + result);
    }
}
