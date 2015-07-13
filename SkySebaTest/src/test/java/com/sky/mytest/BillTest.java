package com.sky.mytest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import junit.framework.Assert;
import org.junit.Test;
import Util.Util;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sky.models.Bill;
import com.sky.models.BuyAndKeep;
import com.sky.models.Call;
import com.sky.models.CallCharges;
import com.sky.models.Package;
import com.sky.models.Period;
import com.sky.models.Rental;
import com.sky.models.SkyStore;
import com.sky.models.Statement;
import com.sky.models.Subscription;

public class BillTest {
	
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
	
	private String jsonString = Util.callURL("http://safe-plains-5453.herokuapp.com/bill.json");

	@Test
	public void skyBillTest() throws Exception {
		
		Assert.assertTrue( !jsonString.isEmpty());
		
		ObjectMapper mapper = new ObjectMapper();
		Bill bill = mapper.readValue(jsonString, Bill.class);
		
		Assert.assertNotNull(bill);
		Assert.assertEquals(59,64, bill.getTotal());
		
		Assert.assertTrue(isValidStatemt(bill)); 	// Statemt
		Assert.assertTrue(isValidPeriod(bill));		// Period
		Assert.assertTrue(isValidPackage(bill));	// Package
		Assert.assertTrue(isValidStore(bill));		// Store
	}

	private boolean isValidStore(Bill bill) {
		SkyStore skyStore = bill.getSkyStore();
		Assert.assertNotNull(skyStore);
		
		ArrayList<BuyAndKeep> buyAndKeep = skyStore.getBuyAndKeep();
		boolean buk= buyAndKeep.size() > 0;
		Assert.assertTrue(buk);
		
		Assert.assertEquals("That's what she said", buyAndKeep.get(0).getTitle());
		Assert.assertEquals(9.99,  buyAndKeep.get(0).getCost());
		
		ArrayList<Rental> rentals = skyStore.getRentals();
		boolean rent= rentals.size() > 0;
		Assert.assertTrue(rent);
		
		Assert.assertEquals("50 Shades of Grey", rentals.get(0).getTitle());
		Assert.assertEquals(4.99,  rentals.get(0).getCost());
		
		Assert.assertEquals(59,64, skyStore.getTotal());
		return true;
	}


	private boolean isValidPackage(Bill bill) {
		Package package1 = bill.getPackage();
		
		Assert.assertNotNull(package1);
		ArrayList<Subscription> subscriptions = package1.getSubscriptions();
		
		Assert.assertNotNull(subscriptions);
		
		boolean subscriptionNotEmty = subscriptions.size() > 0;
		Assert.assertTrue(subscriptionNotEmty);
		
		Assert.assertEquals("Variety with Movies HD", subscriptions.get(0).getName());
		Assert.assertEquals("tv", subscriptions.get(0).getType());
		Assert.assertEquals(50.0, subscriptions.get(0).getCost());
		
		Assert.assertEquals(71,04, package1.getTotal());
		
		CallCharges callCharges = bill.getCallCharges();
		Assert.assertNotNull(callCharges);
		
		ArrayList<Call> calls = callCharges.getCalls();
		boolean bcalls = subscriptions.size() > 0;
		Assert.assertTrue(bcalls);
		
		Assert.assertEquals("07716393769",calls.get(0).getCalled());
		Assert.assertEquals("00:23:03", calls.get(0).getDuration());
		Assert.assertEquals(2.13, calls.get(0).getCost());
		
		Assert.assertEquals(59,64, callCharges.getTotal());
		return true;
	}


	private boolean isValidPeriod(Bill bill) {
		Period period = bill.getStatement().getPeriod();
		Assert.assertNotNull(period);
		
		//validate is date format
		LocalDate from = LocalDate.parse(period.getFrom(), formatter);
		LocalDate to = LocalDate.parse(period.getTo(), formatter);
		Assert.assertEquals("2015-01-26", from.toString());
		Assert.assertEquals("2015-02-25", to.toString());
		return true;
	}


	private boolean isValidStatemt(Bill bill) {
		Statement statement = bill.getStatement();
		Assert.assertNotNull(statement);
		
		//validate is date format
		LocalDate generated = LocalDate.parse(statement.getGenerated(), formatter);
		LocalDate due = LocalDate.parse(statement.getDue(), formatter);
		Assert.assertEquals("2015-01-11",generated.toString());
		Assert.assertEquals("2015-01-25",due.toString());
		return true;
	}

}
