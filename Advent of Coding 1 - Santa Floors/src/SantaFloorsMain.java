import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

//import org.apache.commons.lang3.ArrayUtils;

public class SantaFloorsMain {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		String textInput = null;
		char[] charFromString;
		int reader;
		int santaFloor = 0;
		String firstInput;
		String fileName;
		String fileDirectory;
		System.out.println("What is the name of the file?");
		fileName = input.nextLine();
		System.out.println("Please input file directory.");
		fileDirectory = input.nextLine() + "\\" + fileName;
		System.out.println("What is the first cahracter?");
		firstInput = input.nextLine();

		try {
			fis = new FileInputStream(new File(fileDirectory));
			isr = new InputStreamReader(fis, "UTF-8");
			br = new BufferedReader(isr);

		} catch (IOException ioE) {
			System.out.println("Please check your file name and file directory.");
			ioE.printStackTrace();
		}
		;
		
		try {
			while((reader = br.read()) != -1){
				
				textInput =  br.readLine();
				System.out.println(textInput);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			input.close();
		}
		charFromString =textInput.toCharArray();
		System.out.println("Starting santa floor: 0");
		if(firstInput.contentEquals(")")){
			santaFloor--;
		}else if(firstInput.contentEquals("(")){
			santaFloor++;
		}
		System.out.println("After first move:" + santaFloor);
		
		for(char c: charFromString){
			if(c == 40){
				santaFloor++;
				System.out.println("Santa moved up!");
			}else if(c == 41){
				santaFloor--;
				System.out.println("Santa moved down!");
			}else{
				System.out.println("Santa didn't move!");
			}
			
		}
		//System.out.println("The amount of characters in the character array is " + charFromString.length);
		System.out.println("The array is " + Arrays.toString(charFromString));
		System.out.println("the floor Santa is on is: " + santaFloor);

	}

}
