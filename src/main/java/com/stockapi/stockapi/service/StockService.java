package com.stockapi.stockapi.service;

import java.io.IOException;
import java.util.List;

import com.stockapi.stockapi.entity.Stock;
import com.stockapi.stockapi.helper.CSVHelper;
import com.stockapi.stockapi.repository.StockRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public void bulkInsert(MultipartFile file) {
        try {
            List<Stock> stocks = CSVHelper.csvToStocks(file.getInputStream());
            stockRepository.saveAll(stocks);
        } catch (IOException e) {
            throw new RuntimeException("fail to store csv data: " + e.getMessage());
        }
    }

    public void add(Stock stock){
        stockRepository.save(stock);
    }

    public List<Stock> fetchStocks(String name) {
        return stockRepository.findByStock(name);
    }
}
