package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.game_scene.GameScene;

public class MyGdxGame extends Game {
	@Override
	public void create () {
		this.setScreen(new GameScene());
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose () {
	}
}
