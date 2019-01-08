package com.jerry.alibaba.easy.coding.ch08.unittest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.time.LocalTime;
import java.util.stream.Stream;

@DisplayName("售票器类型测试")
public class TestFactoryTest {

    @TestFactory
    @DisplayName("时间售票检查")
    Stream<DynamicTest> oddNumberDynamicTestWithStream() {
        //ticketSeller.setCloseTime(LocalTime.of(12,20,25,0));
//        return Stream.of(
//                Lists.list("提前购票", LocalTime.of(12, 20, 24, 0), true);
//                Lists.list("准点购买", LocalTime.of(12, 20, 25, 0), true);
//                Lists.list("晚点购买", LocalTime.of(12, 20, 26, 0), false);
//        ).map(data -> DynamicTest.dynamicTest((String)data.get(0)),
//                () -> assertThat(ticketSeller.cloudSellAt(data.get(1)))
//                .isEqualTo(data.get(2))));

        return null;
    }
}
