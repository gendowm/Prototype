package com.rg.prototype.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.physics.box2d.World;

public final class Human extends Entity {
	public Human(float x, float y, World world) {
		super(x, y, new EntityGraphics(new TextureRegion(new Texture(Gdx.files.internal("human.png")))), world);
		getEntityPhysics().getBody().setLinearVelocity(5, 5);
	}
}