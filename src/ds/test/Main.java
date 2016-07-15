package ds.test;

import java.io.StringReader;
import java.util.List;
import java.util.Scanner;

import ds.sort.Sorter;


public class Main {
	private static final int ERROR = -1;
	private static final int ADD = 0;
	private static final int REMOVE = 1;
	private static final int SORT = 2;
	private static final int TOP = 3;

	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		Sorter sorter = new Sorter();
		
		while(scanner.hasNext()){
			String line = scanner.nextLine();
			Scanner i_scanner = new Scanner(new StringReader(line));
			String cmd = i_scanner.next(); //cmd: 명령 add/remove/sort/top
			int value = 0;
			int k = 0;
			String type = null;
			
			switch(getCommandNum(cmd)){
			case ADD:
				value = i_scanner.nextInt();
				sorter.add(value);
				System.out.println("ADD: "+value);
				System.out.println(sorter.toString());
				break;
			case REMOVE:
				value = i_scanner.nextInt();
				boolean returnvalue = sorter.remove(value);
				if (returnvalue==false){
					System.out.println("The value does not exist");					
				}else{
					System.out.println("REMOVE: "+value);
				}	
				System.out.println(sorter.toString());
				
				break;
			case SORT:
				type = i_scanner.next();
				if((type.equals("ascend") == true)||(type.equals("descend") == true)){
					List<Integer> intArray = sorter.sort(type);				
					System.out.print("SORT: ");
					
					
					if((type.equals("ascend"))){
						for(int i=0; i<intArray.size(); i++){
							System.out.print(intArray.get(i)+" ");						
						}
					}else if((type.equals("descend"))){
							for(int i=0; i<intArray.size(); i++){
								System.out.print(intArray.get(intArray.size()-i-1)+" ");		
						}
					}	
				}else{
					System.out.println("INVALID COMMAND");
				}
				System.out.println(sorter.toString());
				break;
				
			case TOP:
				
				k = i_scanner.nextInt();
				type = i_scanner.next();
				
				if((type.equals("largest") == true)||(type.equals("smallest") == true)){
					int[] intArray = sorter.top(k, type);
					
					System.out.print("TOP: ");
					for(int i=0; i<k; i++){
						System.out.print(intArray[i]+" ");
					}	
					System.out.println();
				}else{
					System.out.println("INVALID COMMAND");
				}						
				break;
			
			}
			i_scanner.close();
		}
		
		scanner.close();
	}
	
	private static int getCommandNum(String cmd){
		if(cmd.equals("add"))
			return ADD;
		if(cmd.equals("remove"))
			return REMOVE;
		else if(cmd.equals("sort"))
			return SORT;
		else if(cmd.equals("top"))
			return TOP;
		else 
			return ERROR;
	}

}
