package com.rg.prototype.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Human extends Entity {
	public Human() {
		super(new EntityGraphics(new TextureRegion(new Texture(Gdx.files.internal("human.png")))));
	}
}