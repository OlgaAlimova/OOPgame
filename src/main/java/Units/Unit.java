package Units;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Основная боевая еденица
 */
public abstract class Unit implements GameInterface {
    protected String name;
    protected int hp;
    protected int speed, attack;
    protected int maxHp, def, damegeMin, damegeMax;


    public Vector2D pos;

    public Unit(String name, int speed, int maxHp, int def, int damegeMin, int damegeMax, int x, int y, int attack) {
        this.name = name;
        this.speed = speed;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.def = def;
        this.damegeMin = damegeMin;
        this.damegeMax = damegeMax;
        pos = new Vector2D(x, y);
        this.attack = attack;
    }

    public static String getName(){ // Дать случайное имя
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length-1)]);
    }

    public static ClassesUnits setClass(){ // Получаем случайного персонажа
        return ClassesUnits.values()[new Random().nextInt(ClassesUnits.values().length -1)];
    }

    public static void createArreyUnit1(ArrayList<Unit> arrayList, ClassesUnits classesUnits , int i){ // Для создания Команды 1 (Список, setClass())
        switch (classesUnits){
            case Sniper -> arrayList.add(new Sniper(getName(), i, 1));
            case Mag -> arrayList.add(new Mag (getName(), i, 1));
            case Monk -> arrayList.add(new Mag(getName(), i, 1));
            case Fermer -> arrayList.add(new Fermer(getName(), i, 1));
            case Outlaw -> arrayList.add(new Outlaw(getName(), i, 1));
            case Spearman -> arrayList.add(new Sniper(getName(), i, 1));
            case Crossbowman -> arrayList.add(new Outlaw(getName(), i, 1));

        }
    }

    public static void createArreyUnit2(ArrayList<Unit> arrayList, ClassesUnits classesUnits, int i){ // Для создания Команды 2 (Список, setClass())
        switch (classesUnits){
            case Monk -> arrayList.add(new Monk(getName(), i, 10));
            case Mag -> arrayList.add(new Monk(getName(), i, 10));
            case Fermer -> arrayList.add(new Fermer(getName(), i, 10));
            case Spearman -> arrayList.add(new Spearman(getName(), i, 10));
            case Outlaw -> arrayList.add(new Crossbowman(getName(), i, 10));
            case Crossbowman -> arrayList.add(new Crossbowman(getName(), i, 10));
            case Sniper -> arrayList.add(new Spearman(getName(), i, 10));
        }
    }


    @Override
    public String toString() {
        return String.format("Имя: %3s | HP: %2d  |  Speed: %d,  | Def: %d,  | (X,Y): (%d,%d)\n", this.name, this.hp, this.speed, this.def, this.pos.x, this.pos.y);
    }



    @Override
    public String getInfo() {
        return "Я человек!" + "HP: " + this.hp;
    }


    public int getSpeed() {
        return speed;
    }

    public int getHp() {
        return hp;
    }

    @Override
    public void step(ArrayList<Unit> t1, ArrayList<Unit> t2) {
        GameInterface.super.step(t1, t2);
    }


    public void foo(){
        System.out.println(this);
    }
}