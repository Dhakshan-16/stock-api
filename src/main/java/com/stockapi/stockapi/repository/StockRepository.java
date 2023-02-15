package com.stockapi.stockapi.repository;

import java.util.List;

import com.stockapi.stockapi.entity.Stock;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{

    List<Stock> findByStock(String name);
    


}
