package com.etixapp.design.patterns.behavioral.design.pattern.strategy;

public class Addition implements  Strategy{
	@Override
	public void execute(int num1, int num2) {
		System.out.println(num2 + num1);
	}
}
