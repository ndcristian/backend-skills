package com.etixapp.design.patterns.creational.design.patterns.prototype;

public class RectangleP extends ShapeP {

	public RectangleP(int width, int height) {
		super(width, height);
	}

	@Override
	public void draw() {
		System.out.println("Rectangle width " + width +  "and height " + height );
	}

	@Override
	public ShapeP cloneObject() {
		// this is the prototype
		return new RectangleP(width, height);
	}
}