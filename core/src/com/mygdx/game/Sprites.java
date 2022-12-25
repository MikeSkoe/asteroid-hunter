package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Sprites {
	public SpriteBatch batch;
	public Img skull;

    public Sprites() {
        batch = new SpriteBatch();
        skull = new Img("skullboy.png", 4, 8);
    }

    public void dispose() {
        batch.dispose();
        skull.dispose();
    }
}
