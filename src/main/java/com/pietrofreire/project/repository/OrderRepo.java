package com.pietrofreire.project.repository;

import com.pietrofreire.project.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
