package org.minetrio1256.parrot_farm_backend.console.commands;

import org.minetrio1256.parrot_farm_backend.console.Command;
import org.minetrio1256.parrot_farm_backend.world.save.SaveLevel1;
import org.minetrio1256.parrot_farm_backend.world.save.SaveLevel2;
import org.minetrio1256.parrot_farm_backend.world.ticker.Ticker;

import java.util.List;

public class ExitCommand extends Command {
    private String name;

    public ExitCommand() {
        name = "exit";
    }

    @Override
    protected void run(List<String> args){
        System.out.println("in exit command");
        Ticker.stopTicker();
        SaveLevel1.saveLevel1();
        SaveLevel2.saveLevel2();
        System.exit(1);
    }

    @Override
    public String getName() {
        return name;
    }
}
