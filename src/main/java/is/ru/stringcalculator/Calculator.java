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

	private static boolean multipleDelimiters(String text) {

		return text.startsWith("//[");
	}

	private static String[] splitNumbers(String numbers) {

		String split = "[,\n]";

		if(givenDelimiter(numbers)) {
			if(multipleDelimiters(numbers)) {
				String delimiter1 = Character.toString(numbers.charAt(3));
				String delimiter2 = Character.toString(numbers.charAt(6));
				split = "[\n" + delimiter1 + delimiter2 + "]";
				numbers = numbers.substring(9);

			}
			else {
				String delimiter = Character.toString(numbers.charAt(2));
				split = "[\n" + delimiter + "]";
				numbers = numbers.substring(4);
			}


		}
		return numbers.split(split);
	}
      
    private static int sum(String[] numbers){
 	    int total = 0;

        for(String number : numbers){
        	int num = toInt(number);
        	if(num <= 1000) {
        		total += num;
        	}
		 }		
		return total;
    }





}