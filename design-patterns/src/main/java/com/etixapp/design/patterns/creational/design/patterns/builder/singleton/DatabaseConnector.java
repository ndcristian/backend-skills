package com.etixapp.design.patterns.creational.design.patterns.builder.singleton;

public class DatabaseConnector {
	// ***EAGER IMPLEMENTATION****
	// one way is to expose the instance by making it public
	//	public static DatabaseConnector INSTANCE = new DatabaseConnector();

	//OR:
	private static DatabaseConnector INSTANCE = new DatabaseConnector();

	// ***LAZY IMPLEMENTATION****
	//	we instantiate the class only if needed
	private static DatabaseConnector LAZY_INSTANCE;

	// make constructor private
	private DatabaseConnector() {

	}

	// expose this method to return the instance
	public static DatabaseConnector getInstance() {
		// only for lazy implementation
		if (INSTANCE == null) {
			// but what if we have MULTIPLE THREADS ???
			// -> we can use synchronized() but assume that synchronized code is 100x slower than asynchronized code
			synchronized(DatabaseConnector.class){
				INSTANCE = new DatabaseConnector();
			}
		}
		return INSTANCE;
	}

	void connect() {
		System.out.println("Connecting to the database");
	}

	void disconnect() {
		System.out.println("Disconnecting the database");
	}
}
