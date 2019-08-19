package com.harnest.inventory.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harnest.inventory.ws.entity.BuyerInfo;

@Repository
public interface BuyerRepo extends JpaRepository<BuyerInfo, Integer>{

}
