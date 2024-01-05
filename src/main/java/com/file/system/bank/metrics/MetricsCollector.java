package com.file.system.bank.metrics;

import com.file.system.bank.model.BankTransaction;

import java.util.List;

public interface MetricsCollector {
    void collect(List<BankTransaction>transactions);
}
