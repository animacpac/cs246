package prove02;

import java.awt.*;

/*
* Zombies attack nearby animals, and only move in one direction
 */

public class Zombie extends Creature implements Movable, Aggressor {

    public Zombie() {
        _health = 1;
    }
    public Boolean isAlive() {
        return _health > 0;
    }

    public Shape getShape() { return Shape.Square; }

    public Color getColor() {
        return new Color(00, 00, 255);
    }

    public void attack(Creature target) {
        // Zombies eat everything but plants
        if(target instanceof Animal) {
            target.takeDamage(10);
        }
    }

    public void move() {
        _location.x++;
    }
}
