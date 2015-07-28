package com.rg.prototype.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class EntityGraphics {
	private final Sprite currentSprite;
	public EntityGraphics(TextureRegion textureRegion) {
		currentSprite = new Sprite(textureRegion);
		currentSprite.setOriginCenter();
	}
	public Sprite getCurrentSprite() {
		return currentSprite;
	}
}