package com.example.demo.PRepository;

import org.springframework.data.repository.CrudRepository;


import com.example.demo.MysqlModel.product_info;

public interface ProductRepository extends CrudRepository<product_info,Long> {
	
}
