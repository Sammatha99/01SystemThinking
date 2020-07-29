package Animal.Animal1;

import Animal.Animal;

public abstract class Feline extends Animal {

    public Feline(String food, boolean hunger, String name) {
        super(food, hunger, name);
    }

    @Override
    protected void roam() {
        System.out.println("roam : khong di theo bay");
    }
}
