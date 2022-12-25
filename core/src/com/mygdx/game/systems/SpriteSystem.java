package com.mygdx.game.systems;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.ashley.core.ComponentMapper;
import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Img;
import com.mygdx.game.components.PositionComponent;
import com.mygdx.game.components.SpriteComponent;

public class SpriteSystem extends EntitySystem {
    // System properties
    private ComponentMapper<SpriteComponent> spriteMapper = ComponentMapper.getFor(SpriteComponent.class);
    private ComponentMapper<PositionComponent> positionMapper = ComponentMapper.getFor(PositionComponent.class);
    private ImmutableArray<Entity> entities;

    // Sprite properties
	private SpriteBatch batch;
    private Map<SpriteName, Img> spritesMap;

    public enum SpriteName { Skull }
    
    @Override
    public void addedToEngine(Engine engine) {
        batch = new SpriteBatch();
        spritesMap = new HashMap<SpriteName, Img>();
        spritesMap.put(SpriteName.Skull, new Img("skullboy.png", 4, 8));
        entities = engine.getEntitiesFor(Family.all(SpriteComponent.class, PositionComponent.class).get());
    }

    @Override
    public void removedFromEngine(Engine engine) {
        batch.dispose();
        for (Img img: spritesMap.values()) {
            img.dispose();
        }
    }

    @Override
    public void update(float deltaTime) {
		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		{
            for (Entity entity: entities) {
                SpriteComponent sprite = spriteMapper.get(entity);
                PositionComponent position = positionMapper.get(entity);
                Img img = spritesMap.get(sprite.spriteName);
                img.draw(batch, position.position);
            }
        }
		batch.end();
    }
}
