package com.etixapp.design.patterns.creational.design.patterns.singleton;

public class DatabaseConnectorMultiThreads {

	private static DatabaseConnectorMultiThreads INSTANCE;

	private DatabaseConnectorMultiThreads() {

	}

	public static DatabaseConnectorMultiThreads getInstance() {
		if (INSTANCE == null) {
			synchronized (DatabaseConnectorMultiThreads.class) {
				INSTANCE = new DatabaseConnectorMultiThreads();
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
