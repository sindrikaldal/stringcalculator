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

	private static boolean multipleDelimiters(String text) {

		return text.startsWith("//[");
	}

	private static String[] splitNumbers(String numbers) {

		String split = "[,\n]";

		if(givenDelimiter(numbers)) {
			if(multipleDelimiters(numbers)) {
				ArrayList<String> delimiters = getDelimiters(numbers);
				split = "[\n";
				for(int i = 0; i < delimiters.size() ; i++) {
					split += delimiters.get(i);
				}

				split += "]";
				int index = numbers.indexOf("\n") + 1;

				numbers = numbers.substring(index);
			}
			else {
				String delimiter = Character.toString(numbers.charAt(2));
				split = "[\n" + delimiter + "]";
				numbers = numbers.substring(4);
			}


		}
		
		return numbers.split(split);
	}

	private static ArrayList<String> getDelimiters(String numbers) {

		ArrayList<String> list = new ArrayList<String>();

		int indexof = 0;
		while(indexof != -1) {
			indexof = numbers.indexOf("[", indexof + 1);
			if(indexof != -1) {
				list.add(Character.toString(numbers.charAt(indexof + 1)));
			}
		}

		return list;
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