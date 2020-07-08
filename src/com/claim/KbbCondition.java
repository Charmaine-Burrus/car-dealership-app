package com.claim;

/**
 * based on Kelley Blue Book Vehicle Condition Standards
 *
 */

public enum KbbCondition {
	EXCELLENT("EXCELLENT"), GOOD("GOOD"), FAIR("FAIR"), POOR("POOR");
	
	private String kbbCondition;
	
	private KbbCondition(String kbbCondition) {
		this.kbbCondition = kbbCondition;
	}
	
	public String toString() {
		return this.kbbCondition;
	}

}
