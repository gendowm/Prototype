package com.rg.prototype;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.rg.prototype.entities.Entity;
import com.rg.prototype.states.PlayState;
import com.rg.prototype.states.State;

import java.util.ArrayList;

public final class Application extends ApplicationAdapter {
	private final World world = new World(new Vector2(0, 0), true);
	public static final float SECONDS_PER_FRAME = 1/60f;
	public static final int PIXELS_PER_METER = 15;
	private SpriteBatch spriteBatch;
	private OrthographicCamera camera;
	private final ArrayList<State> states = new ArrayList<State>();
	private State currentState;
	private float accumulatedTime;
	private Box2DDebugRenderer box2DDebugRenderer;
	@Override
	public void create() {
		spriteBatch = new SpriteBatch();
		camera = new OrthographicCamera(Gdx.graphics.getWidth() / 16, Gdx.graphics.getHeight() / 16);
		states.add(new PlayState(this));
		currentState = states.get(0);
		box2DDebugRenderer = new Box2DDebugRenderer();
	}
	@Override
	public void render() {
		updateState();
		updateGraphics();
	}
	private void updateState() {
		accumulatedTime += Gdx.graphics.getDeltaTime();
		while (accumulatedTime >= SECONDS_PER_FRAME) {
			world.step(SECONDS_PER_FRAME, 8, 3);
			currentState.update();
			accumulatedTime -= SECONDS_PER_FRAME;
		}
		if (accumulatedTime > 0) {
			currentState.interpolate(accumulatedTime / SECONDS_PER_FRAME);
		}
	}
	private void updateGraphics() {
		camera.update();
		spriteBatch.setProjectionMatrix(camera.combined);
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		spriteBatch.begin();
		for (Entity entity : currentState.getEntities()) {
			final Sprite sprite = entity.getEntityGraphics().getCurrentSprite();
			spriteBatch.draw(new TextureRegion(sprite.getTexture()), sprite.getX(), sprite.getY(), sprite.getOriginX(), sprite.getOriginY(), sprite.getWidth(), sprite.getHeight(), sprite.getScaleX(), sprite.getScaleY(), sprite.getRotation());
		}
		spriteBatch.end();
		box2DDebugRenderer.render(world, camera.combined);
	}
	public World getWorld() {
		return world;
	}
}