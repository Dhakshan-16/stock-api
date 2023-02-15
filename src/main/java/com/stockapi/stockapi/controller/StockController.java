package com.stockapi.stockapi.controller;

import java.util.List;

import com.stockapi.stockapi.entity.Stock;
import com.stockapi.stockapi.service.StockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/api/stock-data")
public class StockController {

    @Autowired
    StockService stockService;
    @PostMapping("/bulk-insert")
    public ResponseEntity<String> bulkInsert(@RequestParam("file") MultipartFile file){
        stockService.bulkInsert(file);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully Inserted!");
    }
    @PutMapping("/")
    public ResponseEntity<String> add(@RequestBody Stock stock){
        stockService.add(stock);
        return ResponseEntity.status(HttpStatus.OK).body("Successfully inserted a stock record!");
    }
    @GetMapping("/{stock}")
    public ResponseEntity<List<Stock>> fetchStocks(@PathVariable("stock") String name ){
        List<Stock> stocks = stockService.fetchStocks(name);
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }
}

