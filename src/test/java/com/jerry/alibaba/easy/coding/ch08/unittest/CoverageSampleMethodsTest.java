package com.jerry.alibaba.easy.coding.ch08.unittest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class CoverageSampleMethodsTest {

    @Test
    @DisplayName("line coverage sample test")
    void testMethod() {
        CoverageSampleMethods coverageSampleMethods = new CoverageSampleMethods();
        Assertions.assertTrue(coverageSampleMethods.testMethod(1, 2, 0));
    }

    @ParameterizedTest
    @DisplayName("Condition Decision coverage sample test result true")
    @CsvSource({
            "0, 2, 3",
            "1, 0, 3",
    })
    void testConditionDecisionCoverageTrue(int a, int b, int c){
        CoverageSampleMethods coverageSampleMethods = new CoverageSampleMethods();
        Assertions.assertTrue(coverageSampleMethods.testMethod(a, b, c));
    }

    @Test
    @DisplayName("Condition Decision coverage sample test result false")
    void testConditionDecisionCoverageFalse() {
        CoverageSampleMethods coverageSampleMethods = new CoverageSampleMethods();
        Assertions.assertFalse(coverageSampleMethods.testMethod(0, 0, 0));
    }

    @ParameterizedTest
    @DisplayName("Multiple Condition Coverage sample test result true")
    @CsvSource({
            "1, 2, 3",
            "1, 2, 0",
            "1, 0, 3",
            "0, 2, 3",
            "0, 0, 3",
    })
    void testMultipleConditionCoverageSampleTrue(int a, int b, int c) {
        CoverageSampleMethods coverageSampleMethods = new CoverageSampleMethods();
        Assertions.assertTrue(coverageSampleMethods.testMethod(a, b, c));
    }

    @ParameterizedTest
    @DisplayName("Multiple Condition Coverage sample test result false")
    @CsvSource({
            "1, 0, 0",
            "0, 0, 0",
            "0, 2, 0"
    })
    void testMultipleConditionCoverageSampleFalse(int a, int b, int c) {
        CoverageSampleMethods coverageSampleMethods = new CoverageSampleMethods();
        Assertions.assertFalse(coverageSampleMethods.testMethod(a, b, c));
    }

    @ParameterizedTest
    @DisplayName("Path coverage sample test result true")
    @CsvSource({
            "1,2,0",
            "1,0,3",
            "0,0,3",
    })
    void testPathCoverageSampleTrue(int a, int b, int c){
        CoverageSampleMethods coverageSampleMethods = new CoverageSampleMethods();
        Assertions.assertTrue(coverageSampleMethods.testMethod(a, b, c));
    }

    @ParameterizedTest
    @DisplayName("Path coverage sample test result false")
    @CsvSource({
            "1, 0, 0",
            "0, 0, 0",
    })
    void testPathCoverageSampleFalse(int a, int b, int c){
        CoverageSampleMethods coverageSampleMethods = new CoverageSampleMethods();
        Assertions.assertFalse(coverageSampleMethods.testMethod(a, b, c));
    }
}