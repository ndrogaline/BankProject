package mypacktest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import mypack.services.DecimalToRomanConverter;



public class DecimalToRomanConverterTest {
	
	@Test
	void test1_success_1() {
		DecimalToRomanConverter converter = new DecimalToRomanConverter();
		
		String input = "1";

		String actualResult = converter.convert(input);
		String expectedResult = "I";
		
		assertEquals(expectedResult, actualResult);

	}
	
	@Test
	void test2_success_2() {
		DecimalToRomanConverter converter = new DecimalToRomanConverter();
		
		String input = "2";

		String actualResult = converter.convert(input);
		String expectedResult = "II";
		
		assertEquals(expectedResult, actualResult);

	}
		
		

    
	
	
	
}
