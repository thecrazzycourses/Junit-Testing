package com.crazzy.junit.service.impl;

import com.crazzy.junit.service.SomeDataService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


class CalculatorServiceImplTest {

    @InjectMocks // For which we are writing the Test Cases
    CalculatorServiceImpl service = new CalculatorServiceImpl();

    @Mock // Dependent Class
    SomeDataService mock = mock(SomeDataService.class);

    // Without Mokito
    @Test
    void calculateSumSuccess() {

        int actualResult = service.calculateSum(new int[]{1, 2, 3});
        int expectedResult = 6;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateSumEmpty() {

        int actualResult = service.calculateSum(new int[]{});
        int expectedResult = 0;
        assertEquals(expectedResult, actualResult);
    }

    // With No Arg & Dependent on other Service
    // Using Mockito
    @Test
    void calculateSumWithoutArg() {

        // When & Then
        when(mock.retrieveAllData()).thenReturn(new int[] {1,2,3});

        // Use Mock Class instead of Actual
        service.setSomeDataService(mock);

        // Actual Result
        int actualResult = service.calculateSumWithoutArg();

        // Expected Result
        int expectedResult = 6;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateSumWithoutArgEmpty() {

        // When & Then
        when(mock.retrieveAllData()).thenReturn(new int[] {});

        // Use Mock Class instead of Actual
        service.setSomeDataService(mock);

        // Actual Result
        int actualResult = service.calculateSumWithoutArg();

        // Expected Result
        int expectedResult = 0;

        assertEquals(expectedResult, actualResult);
    }

    @Test
    void calculateSumWithoutArgSingle() {

        // When & Then
        when(mock.retrieveAllData()).thenReturn(new int[] {5});

        // Use Mock Class instead of Actual
        service.setSomeDataService(mock);

        // Actual Result
        int actualResult = service.calculateSumWithoutArg();

        // Expected Result
        int expectedResult = 5;

        assertEquals(expectedResult, actualResult);
    }
}