package org.example.Ex2;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* У вас есть задача проверять какой-то сайт, с целью проверки опубликования
на нем новой информации, но если мы будем слишком часто проверять этот сайт,
то нас могут "забанить" за спам. Чтобы избежать этого, вы должны слать свои запросы
не чаще чем один раз в минуту.
Ваша задача должна работать параллельно основной функциональности и не занимать ресурсы
главного потока.
Подумайте, какой механизм Java вы могли бы использовать для автоматизации данной задачи.
Как реализацию работы с сайтом, просто выведите сообщение о том, что соединение
установлено и выведите текущее время. */

public class Task2 {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        executorService.scheduleAtFixedRate(new Task(), 0, 5, TimeUnit.SECONDS);
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            System.out.println("Соединение установлено " + LocalTime.now());
        }
    }
}