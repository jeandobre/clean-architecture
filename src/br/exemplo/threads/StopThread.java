package br.exemplo.threads;

import java.util.concurrent.TimeUnit;

/**
 * Finalização da thread em colaboração com a sincronização adequada
 */
public class StopThread {
    private static boolean stopRequested;

    private static synchronized void requestStop(){
        stopRequested = true;
    }

    private static synchronized boolean stopRequested(){
        return stopRequested;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while(!stopRequested())
                i++;
            System.out.println(i);
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }
}
