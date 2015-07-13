package com.sky.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import Util.Util;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sky.models.Bill;
import com.sky.models.BuyAndKeep;
import com.sky.models.Call;
import com.sky.models.Rental;
import com.sky.models.Subscription;

@Controller
public class SkyJsonController {
	@RequestMapping("homeSky.html")
	public ModelAndView rediractions() throws Exception {
		Bill bill = EndpointJsonSky();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("homeSky");
		mv.addObject("Statement", bill.getStatement());
		mv.addObject("CallCharges", bill.getCallCharges());
		List<Call> listCalls = bill.getCallCharges().getCalls();
		mv.addObject("ListCalls", listCalls);
		mv.addObject("Package", bill.getPackage());
		List<Subscription> listSubscriptions = bill.getPackage().getSubscriptions();
		mv.addObject("ListSubscriptions", listSubscriptions);
		mv.addObject("Store", bill.getSkyStore());
		List<BuyAndKeep> buyAndKeep = bill.getSkyStore().getBuyAndKeep();
		mv.addObject("ListBuyAndKeep", buyAndKeep);		
		ArrayList<Rental> arListRentals = bill.getSkyStore().getRentals();
		mv.addObject("ARentals", arListRentals);
		mv.addObject("Bill", bill);		
		return mv;
	
	
	}

	private Bill EndpointJsonSky() throws Exception {
		String jsonString = Util.callURL("http://safe-plains-5453.herokuapp.com/bill.json");		
		System.out.println("Result " + jsonString);
		ObjectMapper mapper = new ObjectMapper();
		Bill bill = mapper.readValue(jsonString, Bill.class);		
		return bill;
	}

}
