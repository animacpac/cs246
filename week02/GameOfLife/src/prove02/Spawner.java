package prove02;

/*
* Some creatures are able to reproduce, but some conditions must be met.
 */
public interface Spawner {
    public Creature spawnNewCreature();
    public Boolean canSpawn();
}
