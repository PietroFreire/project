package com.pietrofreire.project.model;

import com.google.gson.Gson;
import com.pietrofreire.project.repository.OrderRepo;
import com.pietrofreire.project.repository.TradeRepo;
import com.pietrofreire.project.repository.TraderRepo;
import com.pietrofreire.project.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import com.opencsv.CSVWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

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
            createCSV();
            return "File generated successfully";
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Could not generate CSV file.";
    }

    public void createCSV() throws IOException {
        String[] header = {"TraderCode", "TraderName", "OrderID", "Ticker", "Qty", "AVGPrice"};

        List<String[]> line = new ArrayList<>();
        line.add(new String[]{"JDO", "John Doe", "123456", "PETR4", "1000", "25.123456"});

        Writer writer = Files.newBufferedWriter(Paths.get("C:\\Users\\Pietro Freire\\Documents\\GitHub\\project\\src\\main\\java\\com\\pietrofreire\\project\\output","trades.csv"));
        CSVWriter csvWriter = new CSVWriter(writer);

        csvWriter.writeNext(header);
        csvWriter.writeAll(line);

        csvWriter.flush();
        writer.close();
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