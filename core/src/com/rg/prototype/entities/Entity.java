package com.rg.prototype.entities;

public abstract class Entity {
	private final EntityGraphics entityGraphics;
	public Entity(EntityGraphics entityGraphics) {
		this.entityGraphics = entityGraphics;
	}
	public void update(float delta) {
	}
	public EntityGraphics getEntityGraphics() {
		return entityGraphics;
	}
}