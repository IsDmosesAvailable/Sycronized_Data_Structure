package org.sla;

public class Objects {
    // Fields
    Object[] gjallarhorn;
    int putLocation;
    int getLocation;

    int spaceUsed;

    // Constructor
    Objects() {
        gjallarhorn = new Object[100];
        putLocation = 0;
        getLocation = 0;
        spaceUsed = 0;
    }


    // Methods
    synchronized boolean put(Object objs) {
        if (spaceUsed > 100) {
            System.out.println("put failed. please get() some");
            return false;
        }

        gjallarhorn[putLocation] = objs;
        putLocation = putLocation + 1;
        spaceUsed = spaceUsed + 1;

        if (putLocation > 100) {
            putLocation = 0;
        }
        return true;
    }

    synchronized Object get() {
        if (spaceUsed < 1) {
            System.out.println("get failed. please put() some");
            return null;
        }

            int originalLocation = getLocation;
            getLocation = getLocation + 1;

            if (getLocation > 100) {
                System.out.print("Whoops too much space lets go back!");
                getLocation = 0;
            }
        spaceUsed = spaceUsed - 1;
            return gjallarhorn[originalLocation];
        }


}