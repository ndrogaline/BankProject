package mypacktest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import mypack.services.Add;

public class AddTest {

	@Test
	void add_success() {
		Add addObj1 = new Add();
		int num1 = 1;
		int num2 = 2;
		
		int expectedResult = 3;
		int actualResult = addObj1.add(num1, num2);
		
		assertEquals(actualResult, expectedResult);
	}
}
