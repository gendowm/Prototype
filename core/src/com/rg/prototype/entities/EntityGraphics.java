package com.rg.prototype.entities;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.rg.prototype.Application;

public class EntityGraphics {
	private final Sprite currentSprite;
	public EntityGraphics(TextureRegion textureRegion) {
		currentSprite = new Sprite(textureRegion);
		currentSprite.setOriginCenter();
		currentSprite.setScale(1f / Application.PIXELS_PER_METER);
	}
	public Sprite getCurrentSprite() {
		return currentSprite;
	}
}