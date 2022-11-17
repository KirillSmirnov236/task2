package task2;

import java.util.Arrays;

public class main {
	public static void main(String[] args)
	{
		double [] data = new double[args.length];
		for (int i = 0; i < args.length;i++) {
			data[i] = Double.valueOf(args[i]);
		}
		//1
		System.out.println("1) " + repeat(args[0], Double.valueOf(args[1])));
		//2
		System.out.println("2) "+differenceMaxMin(data));
		//3
		System.out.println("3) "+isAvgWhole(data));
		//4
		System.out.println("4) "+Arrays.toString(cumulativeSum(data)));
		//5
		System.out.println("5) "+getDecimalPlaces(args[0]));
		//6
		System.out.println("6) "+fibonacci(Integer.valueOf(args[0])));
		//7
		System.out.println("7) "+isValid(args[0]));
		//8
		System.out.println("8) "+isStrangePair(args[0], args[1]));
		//9
		System.out.println("9) "+isPrefix(args[0],args[1]));
		System.out.println("9.2) "+isSuffix(args[0],args[1]));
		//10
		System.out.println("10) "+boxSeq(Double.valueOf(args[0])));
		
	}
	//1 a function that repeats each character in a string n times.
	public static String repeat(String word, double count ) {
		String result = "";
		for (int i = 0 ; i < word.length();i++) {
			for (int j = 0 ; j < count;j++) {
				result += word.toCharArray()[i];
			}
		}
		return result;
	}
	//2 a function that takes an array and returns the difference between
	//the largest and smallest numbers.
	public static double differenceMaxMin(double[] data) {
		double max= data[0];
		double min= data[0];
		for (int i = 0 ;i < data.length;i++) {
			if (max < data[i]) {
				max = data[i];
			}
			if (min > data[i]) {
				min = data[i];
			}
		}
		return (max-min);
	}
	//3 a function that takes an array as an argument and returns
	//true or false, depending on whether the average value of all
	//array elements is an integer or not.
	public static boolean isAvgWhole(double[] data) {
		int avg = 0;
		for (int i = 0; i< data.length;i++) {
			avg+=data[i];
		}
		return (avg % data.length == 0);
			
	}
	//4 Create a method that takes an array of integers and returns an array in
	//which each integer is the sum of itself + all the previous
	//numbers in the array.
	public static double[] cumulativeSum(double[] data) {
		for (int i = 1 ; i< data.length;i++){
			data[i] = data[i -1] + data[i];
		}
		return data;
	}
	//5 a function that returns the number of decimal places that has
	//a number (given as a string). Any zeros after the decimal point
	//are counted towards the number of decimal places.
	public static int getDecimalPlaces(String s) {
		boolean point = false;
		int count = 0;
		for(int i = 0 ; i < s.length()-1;i++) {
			if (s.charAt(i) == '.') {
				point = true;
			}
			if (point) {
				count++;
			}
		}
		return count;
	}
	//6 a function that returns the corresponding
	//Fibonacci number for a given number.
	public static int fibonacci(int n) {
		int[] arr = new int[n+1];
		arr[0] = 1;
		arr[1] = 1;
		for (int i = 2 ; i <= n;i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		return arr[n];
	}
	//7a function to determine if the input is a valid
	//mail code.
	public static boolean isValid(String code) {
		if (code.length() != 5) {
			return false;
		}
		for (int i =0; i < code.length();i++) {
			char b = code.charAt(i);
			if (!Character.isDigit(b)) {
				return false;
			}
		}
		return true;
	}
	//8 a function that returns true if a pair of strings is a
	//strange pair, and false otherwise.
	public static boolean isStrangePair(String a , String b) {
		if (a == "" && b == "") {
			return true;
		}
		return (a.charAt(0) == b.charAt(b.length()-1) && (a.charAt(a.length()-1) == b.charAt(0)));
	}
	//9 Create two functions: isPrefix(word, prefix-) and isSuffix (word, -suffix).
	//– isPrefix should return true if it starts with a prefix argument.
	//	– isSuffix should return true if it ends with a suffix argument.
	//– Otherwise, return false.
	public static boolean isPrefix(String word,String prefix) {
		if (prefix.charAt(0) == '-') {
			return false;
		}
		for (int i = 0; i < prefix.length()-1;i++) {
			if (word.charAt(i) != prefix.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	public static boolean isSuffix(String word,String suffix) {
		if (suffix.charAt(suffix.length()-1) == '-') {
			return false;
		}
		for (int i = 0; i < suffix.length()-1;i++) {
			if (word.charAt(word.length()-i-1) != suffix.charAt(suffix.length()-1-i)) {
				return false;
			}
		}
		return true;
	}
	//10
	public static int boxSeq(double step) {
		int result = 0;
		if (step == 0) {
			return result;
		}
		result = 1;
		for (int i = 0 ; i <= step;i++) {
			if (i % 2 == 1) {
				result+=3;
			}
			if (i % 2 == 0) {
				result-=1;
			}
		}
		return result;
		
	}
}
