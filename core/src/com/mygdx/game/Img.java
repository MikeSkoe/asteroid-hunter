package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Img {
    final Texture texture;
    final Sprite sprite;
    final int columns;
    final int rows;

    public Img(
        final String fileName,
        final int columns,
        final int rows
    ) {
        this.texture = new Texture(fileName);
        this.sprite = new Sprite(texture, texture.getWidth() / columns, texture.getHeight() / rows);
        this.columns = columns;
        this.rows = rows;
        sprite.setX(100);
    }

    public void draw(SpriteBatch batch, Vector2 pos) {
        sprite.setPosition((int)pos.x, (int)pos.y);
        sprite.draw(batch);
    }

    public void dispose() {
        this.texture.dispose();
    }
}
