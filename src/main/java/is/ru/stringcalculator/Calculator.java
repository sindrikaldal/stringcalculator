package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",")){
			return sum(splitNumbers(text));
		}
		
		else if(givenDelimiter(text)) {
			return sum(splitNumbersDelimiter(text));
		}
		
		return toInt(text);
		
			
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split("[,\n]");

	}

	private static boolean givenDelimiter(String text) {
		if(text.length() > 2) {
			if(text.substring(0,2).equals("//")) {
				return true;
			}
			return false;
		}

		return false;
	}

	private static String[] splitNumbersDelimiter(String numbers) {

		String delimiter = Character.toString(numbers.charAt(2));
		String split = "[\n";
		split = split + delimiter + "]";
		
		return numbers.substring(4).split(split);
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }





}