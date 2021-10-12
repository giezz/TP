package giezz.fruits;

public class Apple extends Fruit{
    public Apple(int weight, String type) {
        super(weight, type);
    }

    public void slice(int pieces) {
        System.out.println("apple was slices into " + pieces + " parts");
    }
}
