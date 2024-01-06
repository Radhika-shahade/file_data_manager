package com.file.system.bank.metrics;

import com.file.system.bank.model.BankTransaction;
import com.file.system.bank.reader.TransactionFileReader;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionByCity  {

    public void collect(List<BankTransaction> transactions, String cityName) {

        Map<String, List<BankTransaction>> cityGroups = transactions.stream().collect(Collectors.groupingBy(BankTransaction::getLocation));
//         cityGroups.forEach((k,v)->{
//             System.out.println("city:"+k +"Transaction count: "+ v.size());
//
//        });

        List<BankTransaction> mumbai = transactions.stream().filter(city -> city.getLocation().equalsIgnoreCase(cityName


        )).collect(Collectors.toList());
        System.out.println("Mumbai: "+ mumbai.size());
    }

    public static void main(String[] args) {
        TransactionFileReader fileReader= new TransactionFileReader();
        List<BankTransaction> bankTransactionList=fileReader.read("src/main/resources/bank_sub_files/19016800.csv");
        TransactionByCity obj = new TransactionByCity();
        obj.collect(bankTransactionList,"mumbai");
    }


}
