package designpatterns;

import org.junit.jupiter.api.Test;

import com.etixapp.design.patterns.creational.design.patterns.prototype.ShapeP;
import com.etixapp.design.patterns.creational.design.patterns.prototype.SquareP;

public class PrototypeTest {


	@Test
	public void runTest(){
		ShapeP square  = new SquareP(10, 20);
		square.draw();

		ShapeP clonedSquare = square.cloneObject();
		clonedSquare.draw();
	}

}
