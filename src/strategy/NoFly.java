package strategy;

public class NoFly implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("Fuck you, asshole...");
    }
}
