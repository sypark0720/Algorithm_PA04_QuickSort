package ds.sort;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Sorter{
	
	private List<Integer> intArray;
	public Sorter(){
		this.intArray = new LinkedList<Integer>();
	}
	
	public void add(int value){//internal sort
		intArray.add(value);
	}
	
	public boolean remove(Integer value){
		boolean returnvalue =false;	
		if(intArray.contains(value)){
		intArray.remove(value);
		returnvalue = true;
		}
		return returnvalue;
	}
	
	public List<Integer> sort(String type){
		qsort(intArray, 0, intArray.size()-1 );
		return intArray;
	}
	
	public void qsort(List<Integer> A, int i, int j){ //i가 맨 앞, j가 맨 뒷값
		int pivotindex = findpivot(A, i, j);
		swap(A,pivotindex, j); //pivotindex의 값을 맨 뒤로 보낸다.
		int k = partition(A, i-1, j, A.get(j)); 
		swap(A, k, j); //pivot을 자리에 다시 넣어준다.
		if((k-i) > 1) qsort(A, i, k-1);
		if((j-k) > 1) qsort(A, k+1, j);	
	}
	
	public int[] top(int k, String type){
		sort("ascend");
		int[] resultArray = new int[k];
		if(type.equals("largest") == true){
			for(int i=0; i<k; i++){
				resultArray[i] = intArray.get(intArray.size()-i-1); 
			}
			
		}else if(type.equals("smallest") == true){
			for(int i=0; i<k; i++){
				resultArray[i] = intArray.get(i); 
			}		
		}
		return resultArray;
	}

	private int findpivot(List<Integer> A, int i, int j){
		Random generator = new Random();
		int pivotindex = generator.nextInt(j-i+1)+i;		
		return pivotindex;
	}
	
	private int partition(List<Integer> A, int l, int r, int pivot){
		do{
			while(A.get(++l)<pivot);
			while((r!=0)&&(A.get(--r)>pivot));
			swap(A, l, r);					
		}while(l<r);
		swap(A, l, r);
		return l;
	}

	private List<Integer> swap(List<Integer> A, int i, int j){
		int temp = A.get(i);
		A.set(i, A.get(j));
		A.set(j, temp);
		return A;
	}

	@Override
	public String toString() {
		return "Sorter [intArray=" + intArray + "]";
	}
	
}


