package com.jerry.alibaba.easy.coding.ch08.unittest;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

@DisplayName("售票器类型测试")
public class TestWithTag {

    @Test
    @Tag("fast")
    @DisplayName("售票后余票应减少")
    public void shouldReduceInventoryWhenTicketSoldOut(){

    }

    @Test
    @Tag("slow")
    @DisplayName("一次性购买 20 张车票")
    public void shouldSuccessWhenBuy20TicketOnce(){

    }
}

// 通过标签选择执行的用例类型，在 Maven 中可以通过配置 maven-surefire-plugin 插件来实现：
// <build>
//    <plugins>
//        <plugin>
//            <artifactid>maven- surefire-plugin</artifactid>
//            <version>2.22 .0</version>
//            <configuration>
//                <properties>
//                    <includeTags>fast </includeTags> <excludeTags>s low</excludeTags>
//                </properties>
//            </configuration>
//        </plugin>
//    </plugins>
// </build>

// 在 Gradle 中可以通过 JUnit 专用的 junitPlatform 配置来实现：
//junitPlatform {
//    filters {
//        engines{
//            include 'junit-jupiter', 'junit-vintage'
//        }
//        tags{
//            include 'fast'
//            exclude 'slow'
//        }
//    }
//}


