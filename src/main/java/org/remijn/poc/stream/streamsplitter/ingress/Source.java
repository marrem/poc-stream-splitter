package org.remijn.poc.stream.streamsplitter.ingress;

import org.springframework.stereotype.Component;

@Component
public class Source implements Runnable {


    @Override
    public void run() {

        int i = 0;
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            i ++;
        }



    }
}
