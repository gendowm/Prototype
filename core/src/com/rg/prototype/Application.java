package com.rg.prototype;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.rg.prototype.entities.Entity;
import com.rg.prototype.states.PlayState;
import com.rg.prototype.states.State;

import java.util.ArrayList;

public final class Application extends ApplicationAdapter {
	private SpriteBatch spriteBatch;
	private final ArrayList<State> states = new ArrayList<State>();
	private State currentState;
	@Override
	public void create() {
		spriteBatch = new SpriteBatch();
		states.add(new PlayState());
		currentState = states.get(0);
	}
	@Override
	public void render() {
		currentState.update();
		updateGraphics();
	}
	private void updateGraphics() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		spriteBatch.begin();
		for (Entity entity : currentState.getEntities()) {
			final Sprite sprite = entity.getEntityGraphics().getCurrentSprite();
			spriteBatch.draw(new TextureRegion(sprite.getTexture()), sprite.getX(), sprite.getY(), sprite.getOriginX(), sprite.getOriginY(), sprite.getWidth(), sprite.getHeight(), sprite.getScaleX(), sprite.getScaleY(), sprite.getRotation());
		}
		spriteBatch.end();
	}
}