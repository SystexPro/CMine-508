package org.cmine;

import java.io.File;
import org.cmine.util.config.Configuration;
import Bulby.util.Misc;

public class CMine implements Runnable {
	
	public String serverName = "server";
	public int maxPlayers = 10;
	public File pluginDir = new File(getPluginDir());
	public boolean usemysql = false;

	public void run() {
		Misc.println("Starting CMine server version Beta 508");
		Misc.println("Loading properties");
		Misc.println("This server is running " + getName() + " Build: " + getBuild());
		loadConfigFile();
		if(!pluginDir.exists()) {
			pluginDir.mkdir();
			Misc.println("Plugin folder not found. Creating folder");
		}
	}

	public void loadConfigFile() {
		Configuration configFile = new Configuration(new File(getDataFolder() + "cmine.yml"));
		configFile.load();
		configFile.getString("Server-Name", serverName);
		configFile.getInt("Max Players", maxPlayers);
		configFile.getBoolean("Use MySQL", usemysql);
		configFile.save();
	}


	public String getName() {
		return "CMine";
	}

	/**
	 * Returns Build Version
	 * @return
	 */
	public String getBuild() {
		return "#600";
	}
	
	/**
	 * Plugin Folder
	 * @return
	 */
	public String getPluginDir() {
		return "./plugins/";
	}
	
	/**
	 * Data Folder
	 * @return
	 */
	public String getDataFolder() {
		return "./data/";
	}
}
