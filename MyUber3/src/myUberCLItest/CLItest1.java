package myUberCLItest;

public class CLItest1 {

	public static void main(String[] args) {
		
		int sum=0;
		for (String s : args) {
			int i=Integer.parseInt(s);
			sum=sum+i;
			System.out.println("The sum is "+sum);
		}
	}

}
