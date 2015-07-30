package com.rg.prototype.entities;

import com.badlogic.gdx.physics.box2d.*;

public final class EntityPhysics {
	private final Body body;
	public EntityPhysics(float width, float height, World world) {
		final BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		body = world.createBody(bodyDef);
		addRectangularFixture(width, height);
	}
	public void addRectangularFixture(float width, float height) {
		final FixtureDef fixtureDef = new FixtureDef();
		final PolygonShape polygonShape = new PolygonShape();
		polygonShape.setAsBox(width / 2, height / 2);
		fixtureDef.density = 1;
		fixtureDef.friction = 0;
		fixtureDef.shape = polygonShape;
		body.createFixture(fixtureDef);
	}
	public Body getBody() {
		return body;
	}
}