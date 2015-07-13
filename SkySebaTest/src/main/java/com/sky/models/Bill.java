package com.sky.models;

public class Bill {
	private Statement statement;

	public Statement getStatement() {
		return this.statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	private double total;

	public double getTotal() {
		return this.total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	private Package jpackage;

	public Package getPackage() {
		return this.jpackage;
	}

	public void setPackage(Package jpackage) {
		this.jpackage = jpackage;
	}

	private CallCharges callCharges;

	public CallCharges getCallCharges() {
		return this.callCharges;
	}

	public void setCallCharges(CallCharges callCharges) {
		this.callCharges = callCharges;
	}

	private SkyStore skyStore;

	public SkyStore getSkyStore() {
		return this.skyStore;
	}

	public void setSkyStore(SkyStore skyStore) {
		this.skyStore = skyStore;
	}

}
