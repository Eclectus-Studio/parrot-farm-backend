package org.minetrio1256.parrot_farm_backend.console;

import java.util.List;

public abstract class Command {
    private String name;

    public Command(){
    }

    protected abstract void run(List<String> args);

    public abstract String getName();
}
