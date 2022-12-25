package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends ApplicationAdapter {
    Vector2 pos;
	Sprites sprites;
	Skull skull;
	
	@Override
	public void create () {
        pos = new Vector2();
		sprites = new Sprites();
		skull = new Skull(sprites);
	}

	@Override
	public void render () {
		update();
		draw();
	}

    private void update() {
        float delta = Gdx.graphics.getDeltaTime();
		skull.update(delta);
    }

	private void draw() {
		ScreenUtils.clear(0, 0, 0, 1);
		sprites.batch.begin();
		{
			skull.draw();
		}
		sprites.batch.end();
	}
	
	@Override
	public void dispose () {
		sprites.dispose();
	}
}
