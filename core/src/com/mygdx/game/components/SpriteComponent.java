package com.mygdx.game.components;

import com.badlogic.ashley.core.Component;
import com.mygdx.game.systems.SpriteSystem.SpriteName;

public class SpriteComponent implements Component {
    public SpriteName spriteName;

    public SpriteComponent(SpriteName spriteName) {
        this.spriteName = spriteName;
    }
}
