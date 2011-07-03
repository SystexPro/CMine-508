package org.cmine;

import java.io.File;

import org.cmine.util.config.Configuration;

import Bulby.util.Misc;

public class CMine implements Runnable {
	
	public String serverName = "server";
	public int maxPlayers = 10;

	public void run() {
		Misc.println("Starting CMine server version Beta 508");
		Misc.println("Loading properties");
		Misc.println("This server is running " + getName() + " Build: " + getBuild());
		loadConfigFile();

	}

	public void loadConfigFile() {
		Configuration configFile = new Configuration(new File("cmine.yml"));
		configFile.load();
		configFile.getString("Server-Name", serverName);
		configFile.getInt("Max Players", maxPlayers);
		
		
		configFile.save();
	}


	public String getName() {
		return "CMine";
	}

	public String getBuild() {
		return "#600";
	}
}
