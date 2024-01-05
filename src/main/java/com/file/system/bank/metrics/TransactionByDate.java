package com.file.system.bank.metrics;

import com.file.system.bank.model.BankTransaction;
import com.file.system.utils.DateUtils;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionByDate implements MetricsCollector {
    public void collect(List<BankTransaction> transactions, int startYear, int endYear) {
         List<BankTransaction> yearGroups = transactions.stream()
                .collect(Collectors.groupingBy(transaction -> isWithRange(transaction.getCustomerDob(), startYear,endYear));

        yearGroups.forEach((year, transactionList) -> {
            System.out.println("Transactions in year " + year + ": " + transactionList.size());
        });
    }
    private boolean isWithRange(Date date , int startYear, int endYear)
    {
        if( date.getYear()>= startYear && date.getYear()<=endYear)
        {
            return true;
        }
        return false;
    }

}
