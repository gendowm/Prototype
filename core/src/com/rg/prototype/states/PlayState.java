package com.rg.prototype.states;

import com.rg.prototype.Application;
import com.rg.prototype.entities.Human;

public final class PlayState extends State {
	private final Human human = new Human(-10, -10, getApplication().getWorld());
	public PlayState(Application application) {
		super(application);
		getEntities().add(human);
	}
}