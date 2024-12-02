package com.etixapp.design.patterns.creational.design.patterns.builder;

public class PersonB {
	private String name;
	private String email;
	private String address;
	private int age;

	public PersonB (Builder builder){
		this.name = builder.name;
		this.email = builder.email;
		this.address = builder.address;
		this.age = builder.age;
	}

	public static class Builder {
		private final String name; // declaring as FINAL means we have to declare them in constructor and we make them mandatory
		private final String email;
		private String address;
		private int age;

		public Builder(String name, String email) {
			this.name = name;
			this.email = email;
		}

		public Builder setAddress(String address) {
			this.address = address;
			return this; // return the Builder class himself
		}

		public Builder setAge(int age) {
			this.age = age;
			return this;
		}

		public PersonB build() {
			return new PersonB(this);//
		}

	}

}
