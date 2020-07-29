package Animal.Animal2.Animal3;

import Animal.Animal2.Canine;

public class Wolf extends Canine {
    public Wolf(String food, boolean hunger, String name) {
        super(food, hunger, name);
    }

    @Override
    public void eat() {
        System.out.println("eat : an tap");
    }

    @Override
    public void makeNoise() {
        System.out.println("speak : hu hu hu");
    }

    @Override
    public void printAll() {
        eat();
        makeNoise();
        roam();
    }
}
