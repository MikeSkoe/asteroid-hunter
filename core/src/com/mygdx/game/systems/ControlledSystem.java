package com.mygdx.game.systems;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.systems.IteratingSystem;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.components.ControlledComponent;
import com.mygdx.game.components.PositionComponent;

public class ControlledSystem extends IteratingSystem {
    private ComponentMapper<PositionComponent> positionMapper = ComponentMapper.getFor(PositionComponent.class);
    private ComponentMapper<ControlledComponent> controlledMapper = ComponentMapper.getFor(ControlledComponent.class);

    public ControlledSystem() {
        super(Family.all(PositionComponent.class, ControlledComponent.class).get());
    }

    @Override
    protected void processEntity(Entity entity, float deltaTime) {
        PositionComponent position = positionMapper.get(entity);
        ControlledComponent controlled = controlledMapper.get(entity);

        float step = deltaTime * controlled.speed;
        Vector2 shift = new Vector2();

        if (Gdx.input.isKeyPressed(Keys.LEFT)) shift.x -= step;
        if (Gdx.input.isKeyPressed(Keys.RIGHT)) shift.x += step;
        if (Gdx.input.isKeyPressed(Keys.DOWN)) shift.y -= step;
        if (Gdx.input.isKeyPressed(Keys.UP)) shift.y += step;

        position.velocity.add(shift.isZero() ? shift : shift.scl(step));
        position.velocity.scl(controlled.dumping);
    }
}
