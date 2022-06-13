import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.lang.System.out;

class VirtualThreads {

    public static void main(String[] args) throws Exception {
       new VirtualThreads().virtualThreads();
    }

    void virtualThreads() throws InterruptedException {
        // Virtual Threads Factory
        ThreadFactory factory = Thread.ofVirtual().factory();
        ExecutorService executor = Executors.newFixedThreadPool(1000000, factory);
        IntStream.range(0, 1000000).forEach((num) -> {
            executor.submit(() -> {
                try {
                    out.println(num);
                    // Thread.sleep sends only the virtual thread to sleep here
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