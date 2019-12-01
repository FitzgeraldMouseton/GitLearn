package strategy;

public class RubberDuck extends Duck {

    public RubberDuck() {
        flyBehavior = new NoFly();
        quackBehavior = new MuteQuack();
    }
}
