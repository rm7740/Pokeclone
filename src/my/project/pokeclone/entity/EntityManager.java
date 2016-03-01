package my.project.pokeclone.entity;

import my.project.pokeclone.Handler;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

public class EntityManager {

    private Handler handler;
    private ArrayList<Entity> entities;
    private Comparator<Entity> sortRenderOrder;

    public EntityManager(Handler handler) {
        this.handler = handler;
        entities = new ArrayList<>();
        sortRenderOrder = (o1, o2) -> {
            if(o1.getY() + o1.getHeight() < o2.getY() + o2.getHeight()){
                return -1;
            }
            return 1;
        };
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void update(){
        for(int i = 0; i < entities.size(); i++){
            Entity entity = entities.get(i);
            entity.update();
        }
    }

    public void render(Graphics graphics){
        entities.stream()
                .sorted(sortRenderOrder)
                .forEach(e -> e.render(graphics));
    }
}
