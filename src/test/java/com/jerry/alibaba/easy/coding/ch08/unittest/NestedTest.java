package com.jerry.alibaba.easy.coding.ch08.unittest;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("交易服务测试")
public class NestedTest {

    @Nested
    @DisplayName("用户交易测试")
    class UserTransactionTest {
        @Nested
        @DisplayName("正向测试用例")
        class PositiveCase{
            @Test
            @DisplayName("交易检查应通过")
            public void shouldPassCheckWhenParameterValid(){
                System.out.println("shouldPassCheckWhenParameterValid");
            }
        }
        @Nested
        @DisplayName("负向测试用例")
        class NegativeCase{
            @Test
            @DisplayName("负向测试")
            public void negativeTest(){
                System.out.println("shouldPassCheckWhenParameterValid");
            }
        }
    }

    @Nested
    @DisplayName("商家交易测试")
    class CompanyTransactionTest {
        @Test
        @DisplayName("just a test")
        public void test(){
            System.out.println("CompanyTransactionTest");
        }
    }
}
