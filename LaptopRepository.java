package com.example.laptopcustomer2tables;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Long>{
	
	@Query("FROM Laptop WHERE brand.name = :name")
	List<Laptop> getLaptopsByBrand(String name);
	@Query(value = "SELECT name as newname,price as newprice FROM tbl_laptops,tbl_brand WHERE brand_id=tbl_brand.id and tbl_brand.brand= :name",
            nativeQuery=true
    )
	<LaptopProjection> List<LaptopProjection> findLaptopsByBrand(@Param("name") String name);
	@Query(value = "SELECT name as newname,price as newprice,brand_id as brandid FROM tbl_laptops,tbl_brand WHERE brand_id=tbl_brand.id and tbl_brand.brand= :name",
            nativeQuery=true
    )
	<LaptopProjection> List<LaptopProjection> findLaptopDetailsByBrand(@Param("name") String name);
	
}
