package com.mygdx.game.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;

public class PositionComponent implements Component {
    public int speed;
    public Vector2 position;

    public PositionComponent(int speed, Vector2 position) {
        this.speed = speed;
        this.position = position;
    }
}
