package mypack.services;

public class DecimalToRomanConverter {
	
	public String convert(String input) {
		if(input == null || input.isEmpty())
            return "";
		
		String output = "";
		int inputInt = Integer.parseInt(input);
		
		if(inputInt<=3) {
			for(int i=1; i<=inputInt; i++) {
				if(i == 1) {
	                output += "I";
	            }
	            else if(i == 2) {
	                output += "I";
	            }
	            else if(i == 3) {
	                output += "I";
	            }
	            
			}
		}
		
		
		if(inputInt==4) {
			output = "IV";
		}
		if(inputInt==4) {
			output = "V";
		}
		//6 to 8: VIII
		//IX, X
		
		return output;
		
	}
}
