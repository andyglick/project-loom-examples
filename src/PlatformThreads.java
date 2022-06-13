import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.lang.System.out;

class PlatformThreads {

    public static void main(String[] args) throws Exception {
        new PlatformThreads().platformThreads();
    }

    // Attention, can freeze computer...
    void platformThreads() throws InterruptedException {
        ThreadFactory factory = Thread.ofPlatform().factory();
        ExecutorService executor = Executors.newFixedThreadPool(10000, factory);
        IntStream.range(0, 10000).forEach((num) -> {
            executor.submit(() -> {
                try {
                    out.println(num);
                    // We wait a bit, so that the threads really all
                    // run simultaneously
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });
        executor.shutdown();
        executor.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);
    }
}