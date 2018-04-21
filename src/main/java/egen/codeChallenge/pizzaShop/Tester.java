package egen.codeChallenge.pizzaShop;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Tester {
	public static void main(String[] ar) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter source file location:");
		String srcFileName = sc.nextLine();
		
		System.out.println("Enter destination file location:");
		String destFileName = sc.nextLine();
		
		Orders order = context.getBean(Orders.class);
		order.sortOrder(srcFileName, destFileName);
		
		sc.close();
		context.close();
		
	}
}
