package br.exemplo.threads;

import java.util.concurrent.TimeUnit;

/**
 * Finalização da thread em colaboração com o campo volatile
 */
public class StopThreadVolatile {
    private static volatile boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while(!stopRequested)
                i++;
            System.out.println(i);
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
