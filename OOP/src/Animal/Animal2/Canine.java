package Animal.Animal2;

import Animal.Animal;

public abstract class Canine extends Animal {
    public Canine(String food, boolean hunger, String name) {
        super(food, hunger, name);
    }

    @Override
    public void roam() {
        System.out.println("roam : di theo bay");
    }
}
