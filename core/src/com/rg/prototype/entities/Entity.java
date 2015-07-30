package com.rg.prototype.entities;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.World;
import com.rg.prototype.Application;

public abstract class Entity {
	private final EntityGraphics entityGraphics;
	private final EntityPhysics entityPhysics;
	public Entity(float x, float y, EntityGraphics entityGraphics, World world) {
		this.entityGraphics = entityGraphics;
		entityGraphics.getCurrentSprite().setPosition(x, y);
		entityPhysics = new EntityPhysics(entityGraphics.getCurrentSprite().getWidth() / Application.PIXELS_PER_METER, entityGraphics.getCurrentSprite().getHeight() / Application.PIXELS_PER_METER, world);
		entityPhysics.getBody().setTransform(x, y, entityGraphics.getCurrentSprite().getRotation() * MathUtils.degreesToRadians);
	}
	public void update(float delta) {
	}
	public EntityGraphics getEntityGraphics() {
		return entityGraphics;
	}
	public EntityPhysics getEntityPhysics() {
		return entityPhysics;
	}
}