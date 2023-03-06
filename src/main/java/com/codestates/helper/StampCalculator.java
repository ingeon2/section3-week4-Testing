package com.codestates.helper;

import com.codestates.order.entity.Order;

public class StampCalculator {
    public static int calculateStampCount(int nowCount, int earned) {
        return nowCount + earned;
    }

    public static int calculateEarnedStampCount(Order order) { //회원이 주문한 주문 정보에서 얻게되는 스탬프 개수를 계산하는 기능
        return order.getOrderCoffees().stream()
                .map(orderCoffee -> orderCoffee.getQuantity())
                .mapToInt(quantity -> quantity)
                .sum();
    }

}
