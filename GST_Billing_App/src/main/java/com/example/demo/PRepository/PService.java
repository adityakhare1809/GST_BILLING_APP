package com.example.demo.PRepository;

import java.io.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.MysqlModel.product_info;

@Service
public class PService {
	@Autowired
	private ProductRepository rep;
	
	public void save(product_info p)
	{
		rep.save(p);
	}
	
	public List<product_info> listAll()
	{
		return (List<product_info>) rep.findAll();
	}
	
	public product_info get(Long id) {
		return rep.findById(id).get();
	}
	
	public void delete(Long id) {
		rep.deleteById(id);
	}
	
	

}
