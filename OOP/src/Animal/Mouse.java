package Animal;

public class Mouse extends Animal {
    public Mouse(String food, boolean hunger, String name) {
        super(food, hunger, name);
    }

    @Override
    public void eat() {
        System.out.println("eat : an tap");
    }

    @Override
    public void makeNoise() {
        System.out.println("speak : chip chip chip");
    }

    @Override
    public void roam() {
        System.out.println("roam : di voi nguoi yeu");
    }

    @Override
    public void printAll() {
        eat();
        makeNoise();
        roam();
    }
}
