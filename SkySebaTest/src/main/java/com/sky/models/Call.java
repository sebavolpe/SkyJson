package com.sky.models;

public class Call {
	private String called;

	public String getCalled() {
		return this.called;
	}

	public void setCalled(String called) {
		this.called = called;
	}

	private String duration;

	public String getDuration() {
		return this.duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	private double cost;

	public double getCost() {
		return this.cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
}
