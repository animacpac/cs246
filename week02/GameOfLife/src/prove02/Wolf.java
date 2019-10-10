package prove02;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Wolf extends Creature implements Aware, Aggressor, Movable, Spawner {
    private int currentDirection;
    private int preferredDirection;
    private boolean spawnable;
    public Wolf() {
        _health = 1;
        preferredDirection = 1; // 0 = up, 1 = right, 2 = down, 3 = left
        currentDirection = 0;
        spawnable = false;
    }

    public void attack(Creature target) {
        if (target instanceof Animal) {
            target.takeDamage(5);
            spawnable = true;
        }
    }

    public void senseNeighbors(Creature above, Creature below, Creature left, Creature right) {
        // Insert creatures into a list
        List<Creature> creatures = new ArrayList<Creature>();
        creatures.add(above); //[0]
        creatures.add(right); //[1]
        creatures.add(below); //[2]
        creatures.add(left);  //[3]

        // Check in the current direction first
        if (creatures.get(currentDirection) instanceof Animal) {
            preferredDirection = currentDirection;
            return;
        }

        // Check in a clockwise direction, starting with the top
        for (int i = 0; i < 4; i++) {
            if (creatures.get(i) instanceof Animal) {
                preferredDirection = i;
                return;
            }
        }
    }

    Shape getShape() {
        return Shape.Square;
    }

    Color getColor() {
        return Color.gray;
    }

    Boolean isAlive() {
        return _health > 0;
    }

    public void move() {
        switch(preferredDirection) {
            case 0:
                _location.y--;
                break;
            case 1:
                _location.x++;
                break;
            case 2:
                _location.y++;
                break;
            case 3:
                _location.x--;
                break;
        }
        currentDirection = preferredDirection;
    }

    public Boolean canSpawn() {
        if (spawnable) {
            spawnable = false;
            return true;
        }
        return false;
    }

    public Creature spawnNewCreature() {
        Wolf newWolf = new Wolf();
        newWolf.setLocation(new Point(this._location.x - 1, this._location.y));
        return newWolf;
    }
}
