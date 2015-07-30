package com.rg.prototype.states;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.MathUtils;
import com.rg.prototype.Application;
import com.rg.prototype.entities.Entity;

import java.util.ArrayList;

public abstract class State {
	private final Application application;
	private final ArrayList<Entity> entities = new ArrayList<Entity>();
	public State(Application application) {
		this.application = application;
	}
	public void update() {
		for (Entity entity : entities) {
			entity.update(Application.SECONDS_PER_FRAME);
			final Sprite sprite = entity.getEntityGraphics().getCurrentSprite();
			sprite.setX(entity.getEntityPhysics().getBody().getPosition().x);
			sprite.setY(entity.getEntityPhysics().getBody().getPosition().y);
			sprite.setRotation(entity.getEntityPhysics().getBody().getAngle() * MathUtils.radiansToDegrees);
			System.out.println(entity.getEntityPhysics().getBody().getPosition().x);
			System.out.println(sprite.getX());
		}
	}
	public void interpolate(float alpha) {
		for (Entity entity : entities) {
			final Sprite sprite = entity.getEntityGraphics().getCurrentSprite();
			sprite.setX(sprite.getX() + (entity.getEntityPhysics().getBody().getPosition().x - sprite.getX()) * alpha);
			sprite.setY(sprite.getY() + (entity.getEntityPhysics().getBody().getPosition().y - sprite.getY()) * alpha);
			sprite.setRotation(sprite.getRotation() + (entity.getEntityPhysics().getBody().getAngle() * MathUtils.radiansToDegrees - sprite.getRotation()) * alpha);
		}
	}
	Application getApplication() {
		return application;
	}
	public ArrayList<Entity> getEntities() {
		return entities;
	}
}