package br.exemplo.threads;

import java.lang.reflect.Field;
import java.util.concurrent.*;

public class Item80 {

    //Framework simples para cronometrar a execução concorrente
    public static long time(Executor executor, int concurrency,
                            Runnable action) throws InterruptedException{
        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(concurrency);

        for(int i = 0; i < concurrency; i++){
            executor.execute(() -> {
                ready.countDown(); // informa ao temporizador que estamos prontos
                try{
                    start.await(); //espera até que os pares estejam prontos
                    action.run();
                } catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                } finally {
                    done.countDown(); // Informa ao temporizador que terminamos
                }
            });
        }

        ready.await(); // Aguarda até todas as threads de trabalho ficarem prontas
        long startNanos = System.nanoTime();
        start.countDown(); //Contagem regressiva!
        done.await();
        return System.nanoTime() - startNanos;

    }

    public static void main(String[] args){

    }

    // Prática de uso double-check para a inicialização preguiçosa nos campos da instâncias
    private volatile Field field;

    private Field getFieldVerificaoDupla(){
        Field result = field;
        if(result == null) // primeira verificação (sem bloqueio)
            synchronized (this) {
                if(field == null)  //segunda verificação (com bloqueio)
                    field = result = computedFieldValue();
            }
        return result;
    }

    private Field getFieldVerificaoUnica(){
        Field result = field;
        if(result == null) // primeira verificação (sem bloqueio)
            field = result = computedFieldValue();

        return result;
    }

    private Field computedFieldValue(){
        return null;
    }
}
