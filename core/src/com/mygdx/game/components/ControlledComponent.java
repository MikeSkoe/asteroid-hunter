package com.mygdx.game.components;

import com.badlogic.ashley.core.Component;

public class ControlledComponent implements Component {
    public int speed;
    public float dumping;

    public ControlledComponent(int speed, float dumping) {
        this.speed = speed;
        this.dumping = dumping;
    }
}
