package com.rajeshkawali;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

//@SpringBootTest
class SpringbootApplicationTests {

	@Test
	public void contextLoads() {

		try {
			String jsonString = "[\n"
					+ "	{\n"
					+ "		\"english\": \"sport\",\n"
					+ "		\"hindi\": \"खेल\",\n"
					+ "		\"grammar\": \"noun\",\n"
					+ "		\"categories\": [\n"
					+ "			\"sports\"\n"
					+ "		]\n"
					+ "	},\n"
					+ "	{\n"
					+ "		\"english\": \"football\",\n"
					+ "		\"hindi\": \"फुटबॉल\",\n"
					+ "		\"grammar\": \"noun\",\n"
					+ "		\"categories\": [\n"
					+ "			\"sports\"\n"
					+ "		]\n"
					+ "	},\n"
					+ "	{\n"
					+ "		\"english\": \"cricket\",\n"
					+ "		\"hindi\": \"क्रिकेट\",\n"
					+ "		\"grammar\": \"noun\",\n"
					+ "		\"categories\": [\n"
					+ "			\"sports\"\n"
					+ "		]\n"
					+ "	},\n"
					+ "	{\n"
					+ "		\"english\" :  \" cricket\",\n"
					+ "		\"hindi\": \"क्रिकेट\",\n"
					+ "		\"grammar\": \"noun\",\n"
					+ "		\"categories\": [\n"
					+ "			\"sports\"\n"
					+ "		]\n"
					+ "	}\n"
					+ "]";
			//String jsonPattern = "\\[\\s*\\{\\s*\"english\"\\s*:\\s*\"[^\"]+\"\\s*,\\s*\"hindi\"\\s*:\\s*\"[^\"]+\"\\s*,\\s*\"grammar\"\\s*:\\s*\"[^\"]+\"\\s*,\\s*\"categories\"\\s*:\\s*\\[\\s*\"[^\"]+\"\\s*\\]\\s*\\}\\s*(,\\s*\\{\\s*\"english\"\\s*:\\s*\"[^\"]+\"\\s*,\\s*\"hindi\"\\s*:\\s*\"[^\"]+\"\\s*,\\s*\"grammar\"\\s*:\\s*\"[^\"]+\"\\s*,\\s*\"categories\"\\s*:\\s*\\[\\s*\"[^\"]+\"\\s*\\]\\s*\\}\\s*)*\\s*\\]";
			String jsonPattern = "\\[\\s*\\{\\s*\"english\"\\s*:\\s*\"[^\"]+\"\\s*,\\s*\"hindi\"\\s*:\\s*\"[^\"]+\"\\s*,\\s*\"grammar\"\\s*:\\s*\"[^\"]+\"\\s*,\\s*\"categories\"\\s*:\\s*\\[\\s*\"[^\"]+\"\\s*\\]\\s*\\}\\s*(,\\s*\\{\\s*\"english\"\\s*:\\s*\"[^\"]+\"\\s*,\\s*\"hindi\"\\s*:\\s*\"[^\"]+\"\\s*,\\s*\"grammar\"\\s*:\\s*\"[^\"]+\"\\s*,\\s*\"categories\"\\s*:\\s*\\[\\s*\"[^\"]+\"\\s*\\]\\s*\\})*\\s*\\]";

			Pattern pattern = Pattern.compile(jsonPattern);
			Matcher matcher = pattern.matcher(jsonString);

			if (matcher.matches()) {
			    System.out.println("Matched ------------");
			} else {
				 System.out.println("Not Match ------------");
			}
		} catch (Exception e) {
		    e.printStackTrace();
		}
	}

	
	


	

}
