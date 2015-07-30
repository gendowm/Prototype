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
		configuration.foregroundFPS = Math.round(1 / Application.SECONDS_PER_FRAME);
		configuration.backgroundFPS = configuration.foregroundFPS;
		new LwjglApplication(new Application(), configuration);
	}
}