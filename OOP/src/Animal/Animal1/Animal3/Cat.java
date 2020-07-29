package Animal.Animal1.Animal3;

import Animal.Animal;
import Animal.Animal1.Feline;
import Animal.Animal2.Animal3.Dog;
import Animal.Animal2.Animal3.Wolf;
import Animal.Mouse;

public class Cat extends Feline {
    public Cat(String food, boolean hunger, String name) {
        super(food, hunger, name);
    }

    @Override
    protected void eat() {
        System.out.println("eat : an thit ");
    }

    @Override
    public void makeNoise(){
        System.out.println("speak : meo meo");
    }

    public void slapCanine(Dog x){
        System.out.println("special : danh cho ");
    }

    public void slapCanine(Wolf x){
        System.out.println("Special : so soi ");
    }

    @Override
    public void printAll() {
        eat();
        makeNoise();
        roam();
    }

}
