package Units;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Arreys extends Unit{



    int shoot; // выстрелы

    public Arreys(String name, int speed, int maxHp, int def, int damegeMin, int damegeMax, int x, int y, int attack, int shoot) {
        super(name, speed, maxHp, def, damegeMin, damegeMax, x, y, attack);
        this.shoot = shoot;
    }


    @Override
    public void step(ArrayList<Unit> t1, ArrayList<Unit> t2) {
        if (this.hp >= 0 || this.shoot == 0) { // Если жизнь равна нулю или стрел нет, завершить отработку.
            Random rnd = new Random();
            if (t1.contains(this)) { // Проверка если он находиться в 1 команде
                int min = 20;
                int tmp;
                int index = 0;
                for (int i = 0; i < t2.size(); i++) { // Пробегаемся по второй команде находим дистанцию
                    tmp = Vector2D.distance(this, (Unit) t2.get(i)); // Находит расстояние до врага
                    if (min > tmp) {
                        min = tmp; // Записываем минимальную дистанцию врага
                        index = i; // Запрминаем индекс ближайшего врага
                    }
                }
                System.out.println(this.toString());
                System.out.println(t2.get(index));
                System.out.printf("%s стреляет в %s\n", this.name, t2.get(index).name);
                t2.get(index).hp = t2.get(index).hp - rnd.nextInt(this.damegeMin, this.damegeMax); // Выстрел в персонажа
                if (searchFermer(t1)) this.shoot--;
                System.out.println(this.toString());
                System.out.println(t2.get(index));



            } else { // Он будет находиться во 2й команде
                int min = 0;
                int tmp;
                int index = 0;
                for (int i = 0; i < t1.size(); i++) { // Пробегаемся по команде 1 находим дистанцию
                    tmp = Vector2D.distance(this, (Unit) t1.get(i)); // Находит расстояние до врага
                    if (min > tmp) {
                        min = tmp; // Записываем минимальную дистанцию врага
                        index = i; // Запрминаем индекс ближайшего врага
                    }
                }
                System.out.println(t1.get(index));
                System.out.printf("%s стреляет в %s\n", this.name, t2.get(index).name);
                System.out.println(this.toString());
                t1.get(index).hp = t1.get(index).hp - rnd.nextInt(this.damegeMin, this.damegeMax); // Выстрел в персонажа
                if (searchFermer(t2)) this.shoot--; // Если Фермера нет ты выстрелы -1
                System.out.println(this.toString());
                System.out.println(t1.get(index));


            }
        }
    }

    boolean searchFermer(ArrayList<Unit> team){ // Метод нахождения Фермера в команде
        boolean search = true;

        for (int i = 0; i < team.size(); i++) { // Ищем фермера в своей команде
            if (team.get(i) instanceof Fermer){
                search = false;
            }
        }
        return search;
    }


}
