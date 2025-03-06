package org.minetrio1256.parrot_farm_backend.world.ticker;

import org.minetrio1256.parrot_farm_backend.world.api.Object;
import org.minetrio1256.parrot_farm_backend.world.api.world.Coordinate;
import org.minetrio1256.parrot_farm_backend.world.levels.Level2;

public class Ticker implements Runnable {
    private static boolean running = true; // Make running static

    public static void stopTicker() {
        running = false; // No need for 'this' since running is now static
    }

    public void startTicker() {
        Thread thread = new Thread(this);
        thread.start(); // Start the Ticker in a new thread
    }

    @Override
    public void run() {
        while (running) {
            ticker();
        }
    }

    private void ticker() {
        for (Coordinate coord : Level2.getLevel2Map().keySet()) {
            Object currentObject = Level2.getObjectAt(coord);
            currentObject.tick();
        }
    }
}
