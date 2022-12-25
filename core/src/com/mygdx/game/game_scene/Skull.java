package com.mygdx.game.game_scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Sprites;

public class Skull {
    Vector2 pos;
    Sprites sprites;

    public Skull(Sprites sprites) {
        this.sprites = sprites;
        this.pos = new Vector2();
    }

    public void update(float delta) {
        float speed = delta * 200;

        if (Gdx.input.isKeyPressed(Keys.RIGHT)) pos.x += speed;
        if (Gdx.input.isKeyPressed(Keys.LEFT)) pos.x -= speed;
        if (Gdx.input.isKeyPressed(Keys.UP)) pos.y += speed;
        if (Gdx.input.isKeyPressed(Keys.DOWN)) pos.y -= speed;
    }

    public void draw() {
        sprites.skull.draw(sprites.batch, pos);
    }
}

