package com.file.system.bank.metrics;

import com.file.system.bank.model.BankTransaction;
import com.file.system.utils.DateUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionByDate implements MetricsCollector {
    public void collect(List<BankTransaction> transactions, int startYear, int endYear) {
        List<BankTransaction> transactionList = new ArrayList<>();
        for (BankTransaction transaction : transactions) {
            if (isWithRange(transaction.getCustomerDob(), startYear, endYear)) {
                transactionList.add(transaction);
            }
        }

//        public void collect(List<BankTransaction> transactions, int startYear, int endYear) {
//            List<BankTransaction> transactionList = transactions.stream()
//                    .filter(transaction -> isWithRange(transaction.getCustomerDob(), startYear,endYear)).collect(Collectors.toList());

            System.out.println("Year between 1960 to 1970 transaction count is: "+ transactionList.size());
    }
    private boolean isWithRange(Date date , int startYear, int endYear)
    {
        System.out.println(date.getYear());
        if( date.getYear()>= startYear && date.getYear()<=endYear)
        {
            return true;
        }
        return false;
    }

    @Override
    public void collect(List<BankTransaction> transactions) {

    }


}
