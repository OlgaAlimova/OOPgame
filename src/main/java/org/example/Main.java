package org.example;

import Units.*;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {

    static void createSniper(ArrayList<Unit> arrayList, ClassesUnits classesUnits , int i){ // Это для проверки степа на снайпера
        arrayList.add(new Sniper(Unit.getName(), i, 1));
    }

    public static void main(String[] args) {


        Monk monk = new Monk(Unit.getName(),11, 11);
        System.out.println(monk.getInfo());

        ArrayList<Unit> arrayList1 = new ArrayList<>();
        arrayList1.sort(new Comparator<Unit>() {
            @Override
            public int compare(Unit o1, Unit o2) {
                return o1.getSpeed() - o2.getSpeed();
            }
        });

        for (int i = 0; i < 10; i++) { // Создаем 10 случайных персонажей команды 1
//            Unit.createArreyUnit1(arrayList1, Unit.setClass(), i);
            createSniper(arrayList1, Unit.setClass(), i); // Для создания команды снайперов
        }

        System.out.println("Команда 1:");

        for (int i = 0; i < arrayList1.size(); i++) {

            System.out.print(arrayList1.get(i).getInfo());
        }

        ArrayList<Unit> arrayList2 = new ArrayList<>();

        for (int i = 0; i < 10; i++) { // Создаем 10 случайных персонажей команды 2
            Unit.createArreyUnit2(arrayList2, Unit.setClass(), i);
        }
        System.out.println();
        System.out.println("Команда 2:");


        for (int i = 0; i < arrayList2.size(); i++) {
            System.out.print(arrayList2.get(i).getInfo());
        }

        ArrayList arreyAll = new ArrayList<>(arrayList1); // Список со всеми персонажами




        for (int i = 0; i < arrayList2.size(); i++) {
            arreyAll.add(arrayList2.get(i));
        }

        arreyAll.sort(new Comparator<Unit>() { // Сортируем весь список
            @Override
            public int compare(Unit o1, Unit o2) {
                if (o2.getSpeed() == o1.getSpeed()) {
                    return o1.getHp() - o2.getHp();
                }
                return o2.getSpeed() - o1.getSpeed();
            }
        });

        System.out.println();
        System.out.println(arreyAll);

//        arrayList1.get(3).foo();
        System.out.println(arrayList1.get(0).getInfo());
        arrayList1.get(0).step(arrayList1, arrayList2);


    }
}
//крестьянин
//          Имя;
//          здоровье;
//          спать;
//          Ходить;
/*          Бегать
//        Возделывание полей;
//        Питание;
//          Выносливость;
//          под
//
//разбойник
//          Имя;
//          здоровье;
//          спать;
//          Ходить;
/*          Бегать
//        жестокость;
//        разбой;
//          Выносливость;
//
//
//
//снайпер
//          Имя;
//          здоровье;
//          спать;
//          Ходить;
//          Выносливость;
//         Боеприпасы
//          Бегать;
меткость;
маскировка;
замирание;
 */

//колдун
//          Имя;
//          здоровье;
//          спать;
//          Ходить;
/*          Бегать;
            мана
            артифакты
//          Выносливость;
 */
//копейщик
//          Имя;
//          здоровье;
//          спать;
//          Ходить;
/*          Бегать;
//          Выносливость;
//          владение копьем
//          умение держать строй
//арбалетчик
////          Имя;
////          здоровье;
////          спать;
////          Ходить;
///*          Бегать;
////          Выносливость;
//            меткость
//            боеприпасы
 */