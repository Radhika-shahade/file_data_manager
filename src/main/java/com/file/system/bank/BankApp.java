package com.file.system.bank;

import com.file.system.bank.metrics.TransactionByDate;
import com.file.system.bank.metrics.TransactionByGenderMetrics;
import com.file.system.bank.model.BankTransaction;
import com.file.system.bank.reader.TransactionFileReader;

import java.util.List;

public class BankApp {
    public static void main(String[] args) {
        TransactionFileReader fileReader= new TransactionFileReader();
        List<BankTransaction> bankTransactionList=fileReader.read("src/main/resources/bank_transactions.csv");
//        TransactionByGenderMetrics metrics = new TransactionByGenderMetrics();
//        metrics.collect(bankTransactionList);
//        TransactionByDate date = new TransactionByDate();
//        date.collect(bankTransactionList);
        TransactionByDate date = new TransactionByDate();
        date.collect(bankTransactionList,60, 70);
    }
}
