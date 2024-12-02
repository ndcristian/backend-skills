package com.etixapp.design.patterns.creational.design.patterns.prototype;

public abstract class ShapeP {

	protected  int width;
	protected int height;

	public ShapeP(int width, int height){
		this.width=width;
		this.height= height;
	}

	public abstract void draw();
	public  abstract ShapeP cloneObject();

}
