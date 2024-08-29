package com.etixapp.design.patterns.creational.design.patterns.builder.singleton;


// use enums for multithreads because enums are compiled time constants
public enum Database {
	// acquiring the INSTANCE is thread safe
	// is thread safe by default
	INSTANCE;
	public void connect(){
		System.out.println("Connecting to database...");
	}
	public void disconnect(){
		System.out.println("Disconnecting the database...");
	}
}
