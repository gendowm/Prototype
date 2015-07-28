package com.rg.prototype.entities;

public abstract class Entity {
	private final EntityGraphics entityGraphics;
	public Entity(EntityGraphics entityGraphics) {
		this.entityGraphics = entityGraphics;
	}
	public EntityGraphics getEntityGraphics() {
		return entityGraphics;
	}
}