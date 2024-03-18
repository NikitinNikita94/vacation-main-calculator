package ru.neoflex.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.neoflex.dto.VacationPayAmountResponse;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class VacationPayCalculatorImplTest {

    private VacationServicePayCalculatorImpl servicePayCalculator;

    private final BigDecimal averageSalary = new BigDecimal("70500.00");
    private final int vacationDays = 28;

    @BeforeEach
    void setUp() {
        servicePayCalculator = new VacationServicePayCalculatorImpl();
    }

    @Test
    void getCalculateAmountVacationPayTest() {
        BigDecimal expectedTotalVacationPay = new BigDecimal("58612.92");
        VacationPayAmountResponse actualTotal = servicePayCalculator.getCalculateAmountVacationPay(averageSalary, vacationDays);

        assertNotNull(actualTotal);
        assertEquals(expectedTotalVacationPay, expectedTotalVacationPay);
    }

}