package org.sla;

public class ObjectPutter implements Runnable {
    Objects sharedObjects;

    ObjectPutter(Objects objs){ sharedObjects = objs; }

    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            boolean putHappened = sharedObjects.put(i);
            while (!putHappened) {
                Thread.currentThread().yield();
                putHappened = sharedObjects.put(i);
            }
        }
    }


}