package com.codestates.helper;

import com.codestates.order.entity.Order;
import com.codestates.order.entity.OrderCoffee;

import java.util.List;

public class StampCalculatorTestWithoutJUnit {
    public static void main(String[] args) {
        calculateStampCountTest(); //1번매서드
        calculateEarnedStampCountTest(); //2번매서드
    }

    private static void calculateStampCountTest() { //1번
        //given
        int nowCount = 5;
        int earned = 3;

        //when
        int actual = StampCalculator.calculateStampCount(nowCount, earned);

        int expected = 8;

        //then
        System.out.println(expected == actual);
    }

    private static void calculateEarnedStampCountTest() { //2번
        //given
        Order order = new Order();

        OrderCoffee orderCoffee1 = new OrderCoffee();
        orderCoffee1.setQuantity(3);

        OrderCoffee orderCoffee2 = new OrderCoffee();
        orderCoffee2.setQuantity(5);

        order.setOrderCoffees(List.of(orderCoffee1, orderCoffee2));

        int expected = orderCoffee1.getQuantity() + orderCoffee2.getQuantity();

        //when
        int actual = StampCalculator.calculateEarnedStampCount(order);

        //then
        System.out.println(expected == actual);
    }
}

// JUnit이 없는 단위 테스트
// 이미 애플리케이션의 엔트리포인트(Entrypoint)로서 main() 메서드가 사용이 되는데도 불구하고 main() 메서드를 또 작성한다는것 역시 어색.
// given - when - then이라는 용어는 BDD(Behavior Driven Development)라는 테스트 방식에서 사용하는 용어

//StampCalculator 클래스에 JUnit을 적용해서 단위 테스트를 진행하는 것은
//여러분이 직접 실습을 통해서 해볼 수 있도록 단위 테스트 실습 과제