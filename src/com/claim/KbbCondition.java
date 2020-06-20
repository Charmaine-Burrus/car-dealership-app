package com.claim;

public enum KbbCondition {
	EXCELLENT("Excellent"), GOOD("Good"), FAIR("Fair"), POOR("Poor");
	
	private String kbbCondition;
	
	private KbbCondition(String kbbCondition) {
		this.kbbCondition = kbbCondition;
	}
	
	public String toString() {
		return this.kbbCondition;
	}

}
