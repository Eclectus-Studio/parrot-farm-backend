package org.minetrio1256.parrot_farm_backend;

import org.minetrio1256.parrot_farm_backend.console.ConsoleCommandListener;
import org.minetrio1256.parrot_farm_backend.console.RegisterCommands;
import org.minetrio1256.parrot_farm_backend.console.commands.ExitCommand;
import org.minetrio1256.parrot_farm_backend.filesystem.CopyGameFiles;
import org.minetrio1256.parrot_farm_backend.world.api.world.ObjectList;
import org.minetrio1256.parrot_farm_backend.world.api.world.SoilsList;
import org.minetrio1256.parrot_farm_backend.world.layer1.Grass;
import org.minetrio1256.parrot_farm_backend.world.layer1.Water;
import org.minetrio1256.parrot_farm_backend.world.layer2.Wheat;
import org.minetrio1256.parrot_farm_backend.world.layer2.WheatSeed;
import org.minetrio1256.parrot_farm_backend.world.loader.LoadLevel1;
import org.minetrio1256.parrot_farm_backend.world.ticker.Ticker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ParrotFarmBackendApplication {

	public static void main(String[] args) {
		//Register The Command
		RegisterCommands.registerCommand(new ExitCommand());

		// Copy the game files first
		CopyGameFiles.copyResourceFolder("world", "world");

		// Create instances of Grass and Water (Soil types)
		Grass grass = new Grass();
		Water water = new Water();

		// Create SoilsList
		SoilsList soilsList = new SoilsList();

		//Register Object Variable
		Wheat wheat = new Wheat();
		WheatSeed wheatSeed = new WheatSeed();

		//Register the Objects
		ObjectList.registerObject(wheat, wheat.getName());
		ObjectList.registerObject(wheatSeed, wheatSeed.getName());

		// Register soils
		soilsList.registerSoil(grass, grass.getName());
		soilsList.registerSoil(water, water.getName());

		// Load level data from JSON or other source
		LoadLevel1 loadLevel1 = new LoadLevel1();
		loadLevel1.loadLevel1();  // Ensure this is done after the soils are registered

		// Start the Spring Boot application
		SpringApplication.run(ParrotFarmBackendApplication.class, args);

		Scanner scanner = new Scanner(System.in);
		System.out.println("You can now enter commands via /(command) (args)");
		ConsoleCommandListener listener = new ConsoleCommandListener();
		listener.startListening();

		//Start ticker
		Ticker ticker = new Ticker();
		ticker.startTicker();
	}
}
