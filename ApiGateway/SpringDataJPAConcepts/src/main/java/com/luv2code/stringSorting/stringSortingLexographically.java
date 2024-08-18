package com.luv2code.stringSorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class stringSortingLexographically {

	public static void main(String[] args) {
		
		List<String> names = Arrays.asList("abc" ,   "abb" , "bbc" , "zza");
		Collections.sort(names , (name1 , name2) -> - name1.compareTo(name2)  );
		names.forEach(System.out::println);
		
	}
}
