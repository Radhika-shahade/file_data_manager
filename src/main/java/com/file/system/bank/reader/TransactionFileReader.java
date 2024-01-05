package com.file.system.bank.reader;

import com.file.system.bank.model.BankTransaction;
import com.file.system.utils.DateUtils;
import com.opencsv.CSVReader;
import org.apache.commons.lang3.StringUtils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TransactionFileReader {
    public List read(String filePath)
    {
      try{
          CSVReader csvReader= new CSVReader(new FileReader(filePath));
          List<String[]> data =csvReader.readAll();
            List<BankTransaction> bankTransactions = convert(data);
          return bankTransactions;
      }
      catch (IOException e)
      {
          e.printStackTrace();
      }
      return Collections.emptyList();
    }
    private List<BankTransaction> convert(List<String[]>data)
    {
        return data.stream().map(row -> {
            try{
                return buildTransaction(row);
            }catch (Exception ex){
                System.err.println(ex.getMessage() + " while processing : row: " + row);
                return null;
            }
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }

    private BankTransaction buildTransaction(String[] row)throws Exception {
       return  BankTransaction.builder()
               .transactionId(row[0])
               .customerId(row[1])
               .customerDob(DateUtils.convertToDate(row[2]))
               .gender(StringUtils.isEmpty(row[3]) ? 'N' : row[3].charAt(0))
               .location(row[4])
               .accountBalance(StringUtils.isEmpty(row[5]) ? 0 : Double.valueOf(row[5]))
               .transactionDate(DateUtils.convertToDate(row[6]))
               .transactionTime(StringUtils.isEmpty(row[7]) ? 0 : Long.valueOf(row[7]))
               .amountInr(StringUtils.isEmpty(row[8]) ? 0 : Double.valueOf(row[8]))
               .build();
    }
}
