package Animal.Animal1.Animal3;

import Animal.Animal1.Feline;

public class Lion extends Feline {

    public Lion(String food, boolean hunger, String name) {
        super(food, hunger, name);
    }


    @Override
    public void eat(){
        System.out.println("eat : an het moi loai ");
    }

    @Override
    public void makeNoise(){
        System.out.println("speak : gam gu , gam gu !");
    }

    @Override
    public void printAll() {
        eat();
        makeNoise();
        roam();
    }
}
