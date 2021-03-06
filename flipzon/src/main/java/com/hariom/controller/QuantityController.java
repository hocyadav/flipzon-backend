package com.hariom.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hariom.entity.ApiStatus;
import com.hariom.entity.Quantity;
import com.hariom.service.QuantityService;
import com.hariom.util.Status;
/**
 * 
 * @author Hariom Yadav | 01-Apr-2020
 *
 */

@RestController
@RequestMapping("/quantity")
public class QuantityController {

	@Autowired
	private QuantityService quantityService;
	
	/**
	 * Get all Quantity
	 * @return list of Quantity
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Collection<Quantity> getAllQuantity(){
        return this.quantityService.getAllQuantity();
    }
	
	/**
	 * Get Quantity by quantity id
	 * @param id
	 * @return Quantity
	 */
	@RequestMapping(value = "/{id}", 
					method = RequestMethod.GET)
	public Quantity getQuantityById(@PathVariable("id") int id){
        return this.quantityService.getQuantityById(id); 
    }
	
	/**
	 * update old Quantity
	 * @param quan
	 */
	@RequestMapping(method = RequestMethod.PUT,
					consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiStatus> updateQuantity(@RequestBody Quantity quan) {
		this.quantityService.updateQuantity(quan);
		return new ResponseEntity<ApiStatus>(new ApiStatus("updateQuantity", Status.SUCCESS), 
											HttpStatus.OK);
	}
	
	//api Commented : add new Quantity - we cant add quantity directly(automatic added when new item added into db), 
	
//	@RequestMapping(method = RequestMethod.POST,
//					consumes = MediaType.APPLICATION_JSON_VALUE)
//	public void insertQuantity(@RequestBody Quantity quan) {
//		this.quantityService.insertQuantity(quan);
//	}
	
}
