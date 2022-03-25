package com.pietrofreire.project.repository;

import com.pietrofreire.project.model.Trader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TraderRepo extends JpaRepository<Trader, Long> {
}
