package Animal.Animal2.Animal3;

import Animal.Animal2.Canine;


public class Dog extends Canine {
    public Dog(String food, boolean hunger, String name) {
        super(food, hunger, name);
    }

    @Override
    public void eat() {
        System.out.println("eat : an tap");
    }

    @Override
    public void makeNoise() {
        System.out.println("speak : gau gau gau");
    }

    @Override
    public void printAll() {
        eat();
        makeNoise();
        roam();
        chaseCat();
    }

    public static void chaseCat(){
        System.out.println("special : di theo con meo ");
    }

}
