package com.rg.prototype.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.rg.prototype.Application;

public final class DesktopLauncher {
	private DesktopLauncher() {
	}
	public static void main(String[] args) {
		final LwjglApplicationConfiguration configuration = new LwjglApplicationConfiguration();
		configuration.width = 960;
		configuration.height = 600;
		configuration.resizable = false;
		new LwjglApplication(new Application(), configuration);
	}
}