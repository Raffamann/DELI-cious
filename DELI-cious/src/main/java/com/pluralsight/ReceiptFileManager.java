package com.pluralsight;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class ReceiptFileManager {
    private Order order;
    public ReceiptFileManager(Order order){
        this.order = order;
    }
    private String getDateTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd-hhmmss");
        LocalDateTime localDateTime = LocalDateTime.now();

        return localDateTime.format(formatter);
    }
    public void saveReceipt() {
        try {
            String filename = getDateTime()+".txt";
            String filepath = "Receipts";

            File file = new File(filepath, filename);

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(order.toString());

            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
