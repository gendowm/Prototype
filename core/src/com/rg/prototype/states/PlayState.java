package com.rg.prototype.states;

import com.rg.prototype.entities.Human;

public final class PlayState extends State {
	private final Human human = new Human();
	public PlayState() {
		getEntities().add(human);
	}
	@Override
	public void update() {
		human.getEntityGraphics().getCurrentSprite().setX(human.getEntityGraphics().getCurrentSprite().getX() + 1);
	}
}