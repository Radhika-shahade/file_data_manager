package com.file.system.utils;

import com.google.common.collect.Lists;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.List;

public class FileSplit {
    public static void split(String inputPath, int partitionCount ,String outputPath)
    {
       try{
           CSVReader csvReader= new CSVReader(new FileReader(inputPath));
           List<String[]> data = csvReader.readAll();
           List<List<String[]>> partitionData = Lists.partition(data, partitionCount);
           int count=0;
            for(List<String[]>sublist:partitionData)
            {
                CSVWriter csvWriter = new CSVWriter(new FileWriter(outputPath+"/"+ Instant.now().getNano() +".csv"));
                csvWriter.writeAll(sublist);
                System.out.println(++count);
            }
       }
       catch(IOException e)
       {
           e.printStackTrace();
       }
    }

    public static void main(String[] args) {
        FileSplit newFile= new FileSplit();
        split("src/main/resources/bank_transactions.csv", 50000,"src/main/resources/bank_sub_files" );
    }
}
