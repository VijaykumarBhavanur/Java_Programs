package com.bridgelabz.TestingPrograms;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReadFile {

	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner( new File("/home/admin1/Desktop/number.txt") );
		
		scanner.useDelimiter(",");
		while(scanner.hasNext())
			System.out.println(scanner.next());
		
	}

}
