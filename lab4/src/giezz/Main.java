package giezz;

import giezz.fruits.Apple;
import giezz.fruits.Fruit;
import giezz.fruits.Orange;

public class Main {

    public static void main(String[] args) {
        Fruit[] fruits = new Fruit[] {
                new Apple(12, "apple"),
                new Orange(10, "jucie")
        };

        Apple apple1 = new Apple(1, "apple");

        System.out.println(fruits[0].getWeight());

    }
}
