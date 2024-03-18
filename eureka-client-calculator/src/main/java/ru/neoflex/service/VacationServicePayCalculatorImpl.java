package ru.neoflex.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.neoflex.dto.VacationPayAmountResponse;

import java.math.BigDecimal;
import java.math.RoundingMode;

@RequiredArgsConstructor
@Service
@Slf4j
public class VacationServicePayCalculatorImpl implements VacationPayCalculator {

    /**
     * Среднее количество дней в месяце
     */
    private static final double AVERAGE_NUMBER_DAYS_IN_MOUNT = 29.3;
    /**
     * Процент НДФЛ
     */
    private static final double NDFL_PERCENT = 0.13;

    /**
     * Метод вычисляет сумму отпускных, которые придут сотруднику
     *
     * @param averageSalaryPerYear - средняя зарплата в рублях за 12 месяцев
     * @param vacationDays         - количество дней отпуска
     * @return возвращает сумму отпускных
     */
    @Override
    public VacationPayAmountResponse getCalculateAmountVacationPay(BigDecimal averageSalaryPerYear, Integer vacationDays) {
        BigDecimal averageEarningsPerDay = averageSalaryPerYear.divide(BigDecimal.valueOf(AVERAGE_NUMBER_DAYS_IN_MOUNT), RoundingMode.HALF_EVEN);
        log.info("Средний заработок за день={}", averageEarningsPerDay);

        BigDecimal totalPayWithoutNDFL = averageEarningsPerDay.multiply(BigDecimal.valueOf(vacationDays));
        log.info("Заработная плата без процентов НДФЛ={}", totalPayWithoutNDFL);

        BigDecimal amountNDFL = totalPayWithoutNDFL.multiply(BigDecimal.valueOf(NDFL_PERCENT)).setScale(0, RoundingMode.UP);
        log.info("Сумма НДФЛ={}", amountNDFL);

        BigDecimal totalPay = totalPayWithoutNDFL.subtract(amountNDFL);
        log.info("Сумма отпускных в рублях с вычетом НДФЛ={}", totalPay);

        return new VacationPayAmountResponse("Сумма отпускных в рублях с вычетом НДФЛ.", totalPay);
    }

}
