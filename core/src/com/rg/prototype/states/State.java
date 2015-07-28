package com.rg.prototype.states;

import com.rg.prototype.entities.Entity;

import java.util.ArrayList;

public abstract class State {
	private final ArrayList<Entity> entities = new ArrayList<Entity>();
	public void update() {
	}
	public ArrayList<Entity> getEntities() {
		return entities;
	}
}