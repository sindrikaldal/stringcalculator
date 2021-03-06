package is.ru.stringcalculator;
import java.util.ArrayList;


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

	private static boolean multipleDelimitersOrAnyLength(String text) {

		return text.startsWith("//[");
	}

	private static String[] splitNumbers(String numbers) {

		String split = "[,\n]";

		if(givenDelimiter(numbers)) {
			int index = numbers.indexOf("\n") + 1;
			if(multipleDelimitersOrAnyLength(numbers)) {

				split = "[\n" + getDelimiters(numbers, split) + "]+";				
			}
			else {
				String delimiter = Character.toString(numbers.charAt(2));
				split = "[\n" + delimiter + "]";
			}
			numbers = numbers.substring(index);
		}
		return numbers.split(split);
	}

	private static String getDelimiters(String numbers, String split) {

		int indexof = 0, next = 0;

		 	do{
				indexof = numbers.indexOf("[", indexof + 1);
				next = numbers.indexOf("]", indexof);
				if(indexof != -1) {
					split += numbers.substring(indexof + 1, next);
				}			
			}while(indexof != -1);	
		
		return split;
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;

        for(String number : numbers){
        	int num = toInt(number);
        	if(num < 0) {
        		String message = ExceptionMessage(numbers);
        		throw new IllegalArgumentException(message);
        	}
        	if(num <= 1000) {
        		total += num;
        	}
		 }		
		return total;
    }

    private static String ExceptionMessage(String[] numbers) {

    	String message = "Negatives not allowed: ";
       	for(String number : numbers) {
    		if(toInt(number) < 0) {
    			message += number + ",";
    		}
    	}
    	return message;
    }
}