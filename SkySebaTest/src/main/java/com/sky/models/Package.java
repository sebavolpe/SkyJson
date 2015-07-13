package com.sky.models;

import java.util.ArrayList;

public class Package {
	private ArrayList<Subscription> subscriptions;

	public ArrayList<Subscription> getSubscriptions() {
		return this.subscriptions;
	}

	public void setSubscriptions(ArrayList<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
	}

	private double total;

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

}
