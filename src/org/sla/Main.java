package org.sla;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Objects objs = new Objects();

        ObjectPutter objectPutter1 = new ObjectPutter(objs);
        ObjectGetter objectGetter1 = new ObjectGetter(objs);

        Thread putThread = new Thread(objectPutter1);
        putThread.start();

        Thread getThread = new Thread(objectGetter1);
        getThread.start();
    }
}