package strategy;

public class Main {

    public static void main(String[] args) {

        MallardDuck mallardDuck = new MallardDuck();
        RubberDuck rubberDuck = new RubberDuck();

        mallardDuck.performFly();
        mallardDuck.quack();
        System.out.println("==========");
        rubberDuck.performFly();
        rubberDuck.quack();
        rubberDuck.setFlyBehavior(new FlyWithWings());
        rubberDuck.performFly();
    }
}
