package my.project.pokeclone.entity;

import my.project.pokeclone.Handler;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {

    private Handler handler;
    private ArrayList<Entity> entities;

    public EntityManager(Handler handler) {
        this.handler = handler;
        entities = new ArrayList<Entity>();
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void update(){
        for(int i = 0; i < entities.size(); i++){
            Entity entity = entities.get(i);
            entity.update();
        }
    }

    public void render(Graphics graphics){
        for(Entity entity: entities){
            entity.render(graphics);
        }
    }
}
