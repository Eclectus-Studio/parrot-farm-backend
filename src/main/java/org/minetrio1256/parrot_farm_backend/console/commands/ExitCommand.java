package org.minetrio1256.parrot_farm_backend.console.commands;

import org.minetrio1256.parrot_farm_backend.console.Command;
import org.minetrio1256.parrot_farm_backend.world.save.SaveLevel1;

import java.util.List;

public class ExitCommand extends Command {
    private String name;

    public ExitCommand() {
        name = "exit";
    }

    @Override
    protected void run(List<String> args){
        System.out.println("in exit command");
        SaveLevel1.saveLevel1();
        System.exit(1);
    }

    @Override
    public String getName() {
        return name;
    }
}
