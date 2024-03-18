package ru.neoflex.controller;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.dto.VacationPayAmountResponse;
import ru.neoflex.service.VacationPayCalculator;

import java.math.BigDecimal;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class VacationCalculatorController {

    private final VacationPayCalculator vacationService;

    @GetMapping("/calculate")
    public VacationPayAmountResponse getVacationPay(
            @RequestParam("averageSalary") BigDecimal averageSalaryPerYear,
            @RequestParam("vacationDays") int vacationDays
    ) {
        return vacationService.getCalculateAmountVacationPay(averageSalaryPerYear, vacationDays);
    }

}
