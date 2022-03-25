package com.pietrofreire.project.repository;

import com.pietrofreire.project.model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeRepo extends JpaRepository<Trade, Long> {
}
