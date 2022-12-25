package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.game_scene.GameScene;
import com.mygdx.game.game_scene.Skull;

public class MyGdxGame extends Game {
    Vector2 pos;
	Sprites sprites;
	Skull skull;
	
	@Override
	public void create () {
        pos = new Vector2();
		sprites = new Sprites();
		skull = new Skull(sprites);
		this.setScreen(new GameScene(sprites));
	}

	@Override
	public void render () {
		super.render();
	}

	@Override
	public void dispose () {
		sprites.dispose();
	}
}
