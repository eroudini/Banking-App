package com.eroudini.banking.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

public interface StatisticsServices {

    Map<LocalDate, BigDecimal> findSumTransactionsByDate(LocalDate startDate, LocalDate endDate, Integer userId);

    BigDecimal getAccountBalance(Integer userId);

    BigDecimal highestTransfert(Integer userId);

    BigDecimal highestDeposit(Integer userId);

}
