package mx.itesm.util;
import java.util.List;
import java.util.Collections;
import java.util.LinkedList;

public class SortingAlgorithms {
	public static <T extends Comparable<T>> List<T> insertionsort(List<T> unorderedList) {
		
		List<T> unorderedSection = new LinkedList<T>(unorderedList);
		List<T> orderedSection = new LinkedList<T>();
		
		while (!unorderedSection.isEmpty()) {
			T element = unorderedSection.remove(0);
			int index = 0;
			while (index < orderedSection.size() &&
					element.compareTo(orderedSection.get(index)) >= 0) {
				index++;
			}
			orderedSection.add(index, element);
		}
		return orderedSection;
	}
	
	public static <T extends Comparable<T>> List<T> selectionsort(List<T> unorderedList) {
		List<T> unorderedSection = new LinkedList<T>(unorderedList);
		List<T> orderedSection = new LinkedList<T>();
		
		while (!unorderedSection.isEmpty()) {
			int minIndex = 0;
			for (int i = 1; i < unorderedSection.size(); i++) {
				if (unorderedSection.get(minIndex).compareTo(unorderedSection.get(i)) > 0) {
					minIndex = i;
				}
			}
			
			orderedSection.add(unorderedSection.remove(minIndex));
		}
		
		return orderedSection;
	}
	
	public static List<Integer> bucketsort(List<Integer> unorderedList) {
		List<List<Integer>> buckets = new LinkedList<List<Integer>>();
		for (int i = 0; i < 10; i++) {
			buckets.add(new LinkedList<Integer>());
		}
		
		for (int i = 0; i < unorderedList.size(); i++) {
			int element = unorderedList.get(i);
			int bucketId = element / 10;
			buckets.get(bucketId).add(element);
		}
		
		for (int i = 0; i < buckets.size(); i++) {
			Collections.sort(buckets.get(i));
		}
		
		List<Integer> result = new LinkedList<Integer>();
		
		for (int i = 0; i < buckets.size(); i++) {
			for (int j = 0; j < buckets.get(i).size(); j++) {
				result.add(buckets.get(i).get(j));
			}
		}
		
		return result;
	}
	
	public static <T extends Comparable<T>> List<T> bogosort(List<T> unorderedList) {
		List<T> copiedList = new LinkedList<T>(unorderedList);
		
		boolean isSorted = false;
		
		while(!isSorted) {
			isSorted = true;
			for (int i = 1; i < copiedList.size(); i++) {
				if (copiedList.get(i).compareTo(copiedList.get(i - 1)) < 0) {
					isSorted = false;
					break;
				}
			}
			
			if (!isSorted) {
				Collections.shuffle(copiedList);
			}
		}
		
		return copiedList;
	}
	
	public static <T extends Comparable<T>> List<T> quicksort(List<T> unorderedList) {
		if (unorderedList.size() <= 0) {
			return unorderedList;
		}
		
		T pivotValue = unorderedList.get(0);
		
		List<T> before = new LinkedList<T>();
		List<T> after = new LinkedList<T>();
		
		for (int i = 1; i < unorderedList.size(); i++) {
			T element = unorderedList.get(i);
			if (element.compareTo(pivotValue) < 0) {
				before.add(element);
			} else {
				after.add(element);
			}
		}
		
		before = quicksort(before);
		after = quicksort(after);
		
		List<T> resultList = new LinkedList<T>(before);
		resultList.add(pivotValue);
		resultList.addAll(after);
		
		return resultList;
	}
}