package com.sky.models;

public class Statement {
	private String generated;

	public String getGenerated() {
		return this.generated;
	}

	public void setGenerated(String generated) {
		this.generated = generated;
	}

	private String due;

	public String getDue() {
		return this.due;
	}

	public void setDue(String due) {
		this.due = due;
	}

	private Period period;

	public Period getPeriod() {
		return this.period;
	}

	public void setPeriod(Period period) {
		this.period = period;
	}
}
