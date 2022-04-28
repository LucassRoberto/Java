package application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {

	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(3, 4, 5, 10, 7, 30);
		
		//stream para modificar os valores da lista
		Stream<Integer> stream = list.stream().map(x -> x * 10); //map: operação intermediária para modificar os valores da lista. Para cada valor x faça isso...

		System.out.println(Arrays.toString(stream.toArray())); //toArray: operação terminal que irá processar a stream
	
		List<Integer> newList = list.stream()//convertendo para stream
				.filter(x -> x % 2 ==0) //filtrando números pares
				.map(x -> x * 10) //multiplicando por 10
				.collect(Collectors.toList()); //convertendo para lista novamente
			System.out.println(Arrays.toString(newList.toArray()));
	
	}

}
