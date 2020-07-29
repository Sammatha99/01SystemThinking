package Animal;

import Animal.Animal1.Animal3.Cat;
import Animal.Animal1.Animal3.Lion;
import Animal.Animal1.Feline;
import Animal.Animal2.Animal3.Dog;
import Animal.Animal2.Animal3.Wolf;

public class main {
    public static void main(String[] args) throws Exception{
        Wolf wolf = new Wolf("an thit", true,"wolf wo");
        Dog dog = new Dog("an tap", false , "dog muc");
        Lion lion =new Lion("an thit", true, "lion simba");
        Cat cat = new Cat("an thit", false,"cat na");
        Mouse mouse = new Mouse("an tap", true, "mouse manuel");

        System.out.println("\t" + wolf.getName());
        wolf.printAll();

        System.out.println("\t" + dog.getName());
        dog.printAll();

        System.out.println("\t" + lion.getName());
        lion.printAll();

        System.out.println("\t" + cat.getName());
        cat.printAll();
        cat.slapCanine((Dog)dog);
        cat.slapCanine((Wolf)wolf);

        System.out.println("\t" + mouse.getName());
        mouse.printAll();


    }

}
