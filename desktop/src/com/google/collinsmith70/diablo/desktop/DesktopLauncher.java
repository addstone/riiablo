package com.google.collinsmith70.diablo.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.google.collinsmith70.diablo.Client;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.resizable = false;
		config.foregroundFPS = 0;
		config.backgroundFPS = 10;
		config.allowSoftwareMode = true;
		config.addIcon("ic_launcher_128.png", Files.FileType.Internal);
		config.addIcon("ic_launcher_32.png", Files.FileType.Internal);
		config.addIcon("ic_launcher_16.png", Files.FileType.Internal);
		new LwjglApplication(new Client(1280, 720), config);
	}
}
