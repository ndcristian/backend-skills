package com.etixapp.design.patterns.creational.design.patterns.prototype;

public class SquareP extends ShapeP {

	public SquareP(int width, int height) {
		super(width, height);
	}

	@Override
	public void draw() {
		System.out.println("Square width " + width +  "and height " + height );
	}

	@Override
	public ShapeP cloneObject() {
		// this is the prototype
		return new SquareP(width, height);
	}
}
