package org.remijn.poc.stream.streamsplitter.ingress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class Source implements Runnable {

    Logger logger = LoggerFactory.getLogger(Source.class);

    BlockingQueue<Integer> queue;

    public Source(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        int i = 0;
        while (true) {

            try {
                Thread.sleep(1000);
                queue.add(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (IllegalStateException e) {
                logger.info("Queue full");
            }
            i++;
        }

    }

    public Queue<Integer> getQueue() {
        return queue;
    }


}
