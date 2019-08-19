package com.harnest.inventory.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harnest.inventory.ws.entity.ProductDemandMST;

@Repository
public interface ProductDemandRepo extends JpaRepository<ProductDemandMST, Integer>{

}
