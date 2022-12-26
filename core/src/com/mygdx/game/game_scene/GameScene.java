package com.mygdx.game.game_scene;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.components.ControlledComponent;
import com.mygdx.game.components.PositionComponent;
import com.mygdx.game.components.SpriteComponent;
import com.mygdx.game.systems.ControlledSystem;
import com.mygdx.game.systems.SpriteSystem;
import com.mygdx.game.systems.TransitionSystem;
import com.mygdx.game.systems.SpriteSystem.SpriteName;

public class GameScene implements Screen {
    Engine engine;

    public GameScene() {
        engine = new Engine();

        // add systems
        engine.addSystem(new TransitionSystem());
        engine.addSystem(new SpriteSystem());
        engine.addSystem(new ControlledSystem());

        // add entities
        engine.addEntity(createSkull());
    }

    private Entity createSkull() {
        return new Entity()
            .add(new PositionComponent(new Vector2(100, 100), new Vector2(10, 0)))
            .add(new SpriteComponent(SpriteName.Skull))
            .add(new ControlledComponent(25, 0.9f));
    }

    @Override
    public void show() { }

    @Override
    public void render(float delta) {
        engine.update(delta);
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
    public void dispose() {
        engine.removeAllSystems();
        engine.removeAllEntities();
    }
}