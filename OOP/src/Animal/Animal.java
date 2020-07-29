package Animal;

public abstract class Animal {
    private String food;
    private boolean hunger;
    private String name;

    public Animal(String food, boolean hunger, String name) {
        this.food = food;
        this.hunger = hunger;
        this.name = name;
    }

    public String getFood() {
        return food;
    }

    public boolean isHunger() {
        return hunger;
    }

    public String getName() {
        return name;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public void setHunger(boolean hunger) {
        this.hunger = hunger;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String sleep(){
        return "sleep : ngu nhieu !!!";
    }

    protected abstract void eat();
    protected abstract void makeNoise();
    protected abstract void roam();
    protected abstract void printAll();
}

