package com.example.bookstudy.headfirst.designpatterns;

import com.example.bookstudy.headfirst.designpatterns.strategy.*;
import org.junit.jupiter.api.Test;

public class StrategyPatternTests {

    @Test
    void duckTest() {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();

        Duck model = new ModelDuck();
        model.performFly();
        // 전략 패턴을 통해 새로운 행동을 정의 (실무에선 setter 지양)
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }

    @Test
    void duckTest2() {
        MallardDuck mallard = new MallardDuck();
        // 익명 함수를 통해 새로운 fly() 메서드 정의
        FlyBehavior cantFly = () -> System.out.println("I can't fly");
        QuackBehavior squeak = () -> System.out.println("Squeak");

        RubberDuck rubberDuckie = new RubberDuck(cantFly, squeak);
        DecoyDuck decoy = new DecoyDuck();

        Duck model = new ModelDuck();

        mallard.performQuack();
        rubberDuckie.performQuack();
        decoy.performQuack();

        model.performFly();
        model.setFlyBehavior(new FlyRocketPowered());
        model.performFly();
    }
}
