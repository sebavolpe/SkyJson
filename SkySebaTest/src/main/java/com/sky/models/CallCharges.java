package com.sky.models;

import java.util.ArrayList;

public class CallCharges {
	private ArrayList<Call> calls;

	public ArrayList<Call> getCalls() {
		return this.calls;
	}

	public void setCalls(ArrayList<Call> calls) {
		this.calls = calls;
	}

	private double total;

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
