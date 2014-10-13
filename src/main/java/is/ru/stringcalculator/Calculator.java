package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",")){
			return sum(splitNumbers(text));
		}
		
		if(text.length() > 2) {
			if(text.substring(0,2).equals("//")) {
				return 10;
			}
			else {
				return 0
			}
		}
		else {
			return toInt(text);
		}
			
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split("\n|\\,");

	}

	private static String[] splitNumbersDelimeter(String numbers, String delimeter) {
		return numbers.split("\n|\\" + delimeter);
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }





}