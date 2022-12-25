package com.mygdx.game.game_scene;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Sprites;

public class GameScene implements Screen {
    Sprites sprites;
    Skull skull;

    public GameScene(Sprites sprites) {
        this.sprites = sprites;
        this.skull = new Skull(this.sprites);
    }

    @Override
    public void show() { }

    @Override
    public void render(float delta) {
        update(delta);
        draw();
    }

    private void update(float delta) {
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
    public void resize(int width, int height) { }

    @Override
    public void pause() { }

    @Override
    public void resume() { }

    @Override
    public void hide() { }

    @Override
    public void dispose() { }
}