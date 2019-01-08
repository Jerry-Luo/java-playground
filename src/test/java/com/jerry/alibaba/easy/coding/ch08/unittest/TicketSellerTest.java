package com.jerry.alibaba.easy.coding.ch08.unittest;

import org.junit.jupiter.api.*;

//定义一个测试用例并指定用例在测试报告中的展示名称
@DisplayName("售票类型测试")
public class TicketSellerTest {

    // 定义测试类的实例
    private TicketSeller ticketSeller;

    // 定义在整个测试类开始前执行的操作
    // 通常包括全局和外部资源（包括测试桩）的创建和初始化
    @BeforeAll
    public static void init(){
        System.out.println("BeforeAll");
    }

    // 定义在整个测试类完成后执行的操作
    // 通常包括全局和外部资源的释放和销毁
    @AfterAll
    public static void cleanup() {
        System.out.println("AfterAll");
    }

    // 定义在每个测试用例开始前执行的操作
    // 通常包括基础数据和运行环境的准备
    @BeforeEach
    public void create() {
        this.ticketSeller = new TicketSeller();
        System.out.println("BeforeEach");
    }

    // 定义在每个测试用例完成后执行的操作
    // 通常包括运行环境的清理
    @AfterEach
    public void destory() {
        System.out.println("AfterEach");
    }

    // 测试用例，当车票售出后余票应减少
    @Test
    @DisplayName("售票后余票应减少")
    public void shouldReduceInventoryWhenTicketSoldOut(){
        ticketSeller.setInventory(10);
        ticketSeller.sell(1);
        Assertions.assertEquals(ticketSeller.getInventory(), 9);
    }

    // 测试用例，当余票不足时应该报错
    @Test
    @DisplayName("余票不足应报错")
    public void shouldThrowExceptionWhenNoEnoughInventory(){
//        ticketSeller.setInventory(0);
//        assertThatExceptionOfType(TicketException.class)
//                .isThrownBy(()->{ticketSeller.sell(1);})
//                .withMessageContaining("all ticket sold out")
//                .withNoCause();
    }

    @Disabled
    @Test
    @DisplayName("有退票时余票应增加")
    public void shouldIncreaseInventoryWhenTicketRefund(){
        ticketSeller.setInventory(10);
        ticketSeller.refund(1);
//        assertThat(ticketSeller.getInventory()).isEqualTo(11);
    }

}

class TicketSeller{
    private int inventory;

    public void sell(int num){
        this.inventory = this.inventory - num;
    }

    public void refund(int num){
        this.inventory = this.inventory + num;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }
}
