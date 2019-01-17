package org.sla;

public class ObjectGetter implements Runnable {

    Objects sharedObjects;


    ObjectGetter(Objects objs) {
        sharedObjects = objs;
    }

    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {

            Object obj = sharedObjects.get();
            while (obj == null) {
                Thread.currentThread().yield();
                obj = sharedObjects.get();
            }
            System.out.println(obj);


        }
    }

}