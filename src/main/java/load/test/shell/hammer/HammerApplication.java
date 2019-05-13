package load.test.shell.hammer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HammerApplication {
	public static void main(String[] args) {
		System.out.println("======= hammer ddos tool =======");
		System.out.println("Java based dDos tool");
		System.out.println("developed to overwhelming endpoints as performance tests. ** be conscious while using it **");
		System.out.println();
		System.out.println("ir Supports GET and POST (json based) requests");
		SpringApplication.run(HammerApplication.class, args);
	}

}
