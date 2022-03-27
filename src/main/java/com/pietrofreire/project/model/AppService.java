package com.pietrofreire.project.model;

import com.google.gson.Gson;
import com.pietrofreire.project.repository.OrderRepo;
import com.pietrofreire.project.repository.TradeRepo;
import com.pietrofreire.project.repository.TraderRepo;
import com.pietrofreire.project.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.opencsv.CSVWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Service
public class AppService {
    private Trader trader;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private TradeRepo tradeRepo;

    @Autowired
    private TraderRepo traderRepo;

    @Autowired
    private UserRepo userRepo;

    public String getCSV() {

        try {

            List<Trader> traders = traderRepo.findAll();
            List<Order> orders = orderRepo.findAll();
            List<Trade> trades = tradeRepo.findAll();

            String[] header = {"TraderCode", "TraderName", "OrderID", "Ticker", "Qty", "AVGPrice"};
            List<String[]> line = new ArrayList<>();

            for(Order order: orders){
                double precoTotal = 0;
                int qntTotal = 0;

                for(Trade trade : trades){
                    if (order.getId() == trade.getOrder().getId()){
                        precoTotal += trade.total();
                        qntTotal += trade.getQuantity();
                    }
                }
                line.add(new String[]{
                        order.getTrader().getCode(),
                        order.getTrader().getName(),
                        String.valueOf(order.getId()),
                        order.getTicker(),
                        String.valueOf(qntTotal),
                        String.valueOf(precoTotal/qntTotal)});
            }

            Writer writer = Files.newBufferedWriter(Paths.get("C:\\Users\\Pietro Freire\\Documents\\GitHub\\project\\src\\main\\java\\com\\pietrofreire\\project\\output","trades.csv"));
            CSVWriter csvWriter = new CSVWriter(writer);

            csvWriter.writeNext(header);
            csvWriter.writeAll(line);

            csvWriter.flush();
            writer.close();
            return "File generated successfully.";
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Could not generate CSV file.";
    }

    public String getJSON(){

        try{
            ArrayList<String> lista = new ArrayList<String>();
            lista.add("victormenegusso@gmail.com");
            lista.add("teste@teste.com");
            lista.add("javeiro@php.com");

            Gson gson = new Gson();
            String json = gson.toJson( lista );
            return json;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "Could not create JSON";
    }

}