package com.file.system.bank.metrics;

import com.file.system.bank.model.BankTransaction;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionByGenderMetrics implements MetricsCollector{
    public void collect(List<BankTransaction> transactions) {
        Map<Character ,List<BankTransaction>>genderGroups =transactions.stream().collect(Collectors.groupingBy(BankTransaction:: getGender));
        System.out.println("Transaction done by Male: "+genderGroups.get('M').size());
        System.out.println("Transaction done by Female: "+genderGroups.get('F').size());
    }
}
