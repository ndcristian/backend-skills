package com.etixapp.java.base.basics;

public class Wraper {

	int number = 4;
	Integer refTyeNumber = 5;

	// all this tye casting are made internally by java

	public Integer boxing(int num) {
		// this is called @++BOXING when assing a primitive tye to its own wrapper class
		Integer referenceTyeNumber = num;
		return referenceTyeNumber;
	}

	public int unBoxing(Integer num) {
		// this is called @++UN-BOXING when assing a referenceType  to its own primitive type
		int rimitiveTyeNumber = num;
		return rimitiveTyeNumber;
	}
}
