package services;

import java.util.List;

public class CalculationServices {

	//método estático: não precisa ser instanciado
	public static <T extends Comparable<T>> T max(List<T> list) {
		if (list.isEmpty()) {//para evitar que a lista seja vazia 
			throw new IllegalStateException("List can't be empty");
		} 
		T max = list.get(0);//encontrar o maior valor da lista 
		for (T item : list) {//se cada valor da lista for maior que o máx...
			if (item.compareTo(max) > 0) {//comparar os objetos
				max = item;
			}
		}
		return max;
	}
}