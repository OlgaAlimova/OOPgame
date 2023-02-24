package Units;

import java.util.ArrayList;
import java.util.List;

/**
 * Кпоейщики
 */
public class Spearman extends Unit{


    public Spearman(String name, int x, int y) {
        super(name, 4, 10, 5, 1, 3, x, y, 4);
    }


    @Override
    public void step(ArrayList<Unit> t1, ArrayList<Unit> t2) {

    }

    @Override
    public String getInfo() {
        return "Я копейщик";
    }

    @Override
    public String toString() {
        return String.format("Копейщик: %1s  |  HP: %d  |  Speed: %d  |  ATK: %d-%d  |  DEF: %d  |  (X,Y): (%d,%d)\n", this.name, this.hp, this.speed, this.damegeMin, this.damegeMax, this.def, this.pos.x, this.pos.y);
    }
}