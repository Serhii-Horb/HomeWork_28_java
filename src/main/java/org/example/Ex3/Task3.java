package org.example.Ex3;
/* В одном из предыдущего ДЗ у вас была задача:
У вас в магазине распродажа. К вам набежало 10 000 клиентов и вы пытаетесь корректно всех обслужить с
учетом того, что одновременно у вас внутри магазина может находиться не более 10 покупателей(согласно
карантинным нормам) и время обслуживания одного покупателя занимает 30 секунд.
Сымитируйте данный процесс работы и подсчитайте за какой период времени вы сможете обслужить данный
объем покупателей?
Отдельный покупатель - отдельный поток.
Можно было бы реализовать данную задачу не используя семафор? */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task3 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 10_000; i++) {
            executorService.execute(new Client(i));
        }
        executorService.shutdown();
    }
}

class Client implements Runnable {
    int clientNumber;

    public Client(int clientNumber) {
        this.clientNumber = clientNumber;
    }

    @Override
    public void run() {
        System.out.println("Клиент " + clientNumber + " пришёл в магазин и обслужен потоком " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}