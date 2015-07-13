package com.sky.models;

import java.util.ArrayList;

public class SkyStore {
	private ArrayList<Rental> rentals;

	public ArrayList<Rental> getRentals() {
		return this.rentals;
	}

	public void setRentals(ArrayList<Rental> rentals) {
		this.rentals = rentals;
	}

	private ArrayList<BuyAndKeep> buyAndKeep;

	public ArrayList<BuyAndKeep> getBuyAndKeep() {
		return this.buyAndKeep;
	}

	public void setBuyAndKeep(ArrayList<BuyAndKeep> buyAndKeep) {
		this.buyAndKeep = buyAndKeep;
	}

	private double total;

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
