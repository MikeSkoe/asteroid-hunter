package com.mygdx.game.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

public class PositionComponent implements Component {
    public Vector2 position;
    public Vector2 velocity;

    public PositionComponent(
        Vector2 position,
        Vector2 velocity
    ) {
        this.position = position;
        this.velocity = velocity;
    }
}
