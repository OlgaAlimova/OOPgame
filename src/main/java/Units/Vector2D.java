package Units;

import java.util.ArrayList;

public class Vector2D {

    protected int x, y;

    public Vector2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static int distance(Unit u1, Unit u2){
        return (int) Math.sqrt((u1.pos.x - u2.pos.x)^2 + (u1.pos.y - u2.pos.y)^2);
    };


}