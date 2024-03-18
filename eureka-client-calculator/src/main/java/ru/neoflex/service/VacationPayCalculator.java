package ru.neoflex.service;

import ru.neoflex.dto.VacationPayAmountResponse;

import java.math.BigDecimal;

public interface VacationPayCalculator {
    VacationPayAmountResponse getCalculateAmountVacationPay(BigDecimal averageSalaryPerYear, Integer vacationDays);

}
