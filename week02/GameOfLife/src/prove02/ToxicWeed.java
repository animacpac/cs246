package prove02;

import java.awt.*;

/*
* These plants are toxic. Any living creature that touches them dies instantly. A new toxic weed
* spawns when a creature dies from this plant. They are represented by red circles.
* @author Caleb Georgeson
 */
public class ToxicWeed extends Creature implements Spawner, Aggressor {
    private boolean spawnable;

    public ToxicWeed() {
        _health = 1;
        spawnable = false;
    }

    Shape getShape() {
        return Shape.Circle;
    }

    Color getColor() {
        return new Color(255, 0 ,0);
    }

    Boolean isAlive() {
        return _health > 0;
    }

    public void attack(Creature target) {
        if (target instanceof Animal || target instanceof Wolf) {
            target.takeDamage(5);
            spawnable = true;
        }
    }

    public Boolean canSpawn() {
        if (spawnable) {
            spawnable = false;
            return true;
        }
        return false;
    }
    public Creature spawnNewCreature() {
        ToxicWeed newWeed = new ToxicWeed();
        int x = (int)(Math.random() * 3) - 1;
        int y = (int)(Math.random() * 3) - 1;
        newWeed.setLocation(new Point(this._location.x + x, this._location.y + y));
        return newWeed;
    }
}
