package egen.codeChallenge.pizzaShop.services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import egen.codeChallenge.pizzaShop.processOrder;

@Component
public class sortFile implements processOrder{

	@Override
	public void sortOrder(String srcFileName, String destFileName){
		
		List<String> orderList = new ArrayList<String>(); //list to store and sort data lexographically
		
		try(BufferedReader br = Files.newBufferedReader(Paths.get(srcFileName))){
			String line = br.readLine();
			while((line = br.readLine())!=null) {
				orderList.add(line.toLowerCase());
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		Collections.sort(orderList); //sort the list lexographically
		
		System.out.println("sorted order list");
		for(String order: orderList) {
			System.out.println(order);
		}
		
		
		//store the sorted orders into filename_sorted.txt file
		try(BufferedWriter bw = Files.newBufferedWriter(Paths.get(destFileName), StandardCharsets.UTF_8)){
			for(String order: orderList) {
				bw.append(order);
				bw.newLine();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
