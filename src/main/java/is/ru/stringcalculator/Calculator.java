package is.ru.stringcalculator;

public class Calculator {

	public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		else if(text.contains(",") || text.contains("\n")){
			return sum(splitNumbers(text));
		}
				
		return toInt(text);
			
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static boolean givenDelimiter(String text) {

		return text.startsWith("//");
	}

	private static String[] splitNumbers(String numbers) {

		String split = "[,\n]";

		if(givenDelimiter(numbers)) {

			String delimiter = Character.toString(numbers.charAt(2));
			split = "[\n" + delimiter + "]";
			numbers = numbers.substring(4);

		}
		return numbers.split(split);
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }





}