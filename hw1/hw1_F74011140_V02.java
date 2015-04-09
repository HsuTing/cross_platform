package hw1_F74011140_V02;

import java.util.StringTokenizer;
import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.Vector;

public class hw1_F74011140_V02 {
	private int [] elements;
	
	public hw1_F74011140_V02(){
		elements = new int[0];
	};
	
	public hw1_F74011140_V02(String input){
		StringTokenizer temp = new StringTokenizer(input, ",");
		int count = 0;
		
		while(temp.hasMoreTokens()){
			count++;
			temp.nextToken();
		}
		
		StringTokenizer temp_elements = new StringTokenizer(input, ",");
		elements = new int[count];
		int i = 0;
		
		while(temp_elements.hasMoreTokens()){
			elements[i] = Integer.parseInt(temp_elements.nextToken());
			i++;
		}
		
		return;
	};
	
	public int size(){
		return elements.length;
	};
	
	public boolean isEmpty(){
		if(size() == 0)
			return true;
		else
			return false;
	};
	
	public boolean isPnumber(){ 
		for(int i = 0; i < elements.length; i++){
			if(elements[i] == 0)
				return false;
			for(int j = 1; j * j <= elements[i]; j++){
				if(elements[i] % j == 0)
					return false;
			}
		}
		return true;
	};
	
	public boolean isEvennumber(){
		for(int i = 0; i < elements.length; i++){
			if(elements[i] % 2 != 0)
				return false;
		}
		return true;
	};
	
	public int getMaximalElement(){
		int temp = 0;
		for(int i = 0; i < elements.length; i++){
			if(temp < elements[i])
				temp = elements[i];
		}
		return temp;
	};
	
	public void reverse(){
		for(int i = elements.length - 1; i >= 0; i--){
			System.out.printf("%d", elements[i]);
		}
		System.out.println();
	}
	
	public void showDistinctElements(){
		Set<Integer> intSet = new HashSet<Integer>();
		for(int element : elements){
			intSet.add(element);
		}
		int nonDuplicateArray[] = new int[intSet.size()];
		
		Object[] tempArray = intSet.toArray();
		for(int i = 0; i < tempArray.length; i++){
			nonDuplicateArray[i] = (Integer) tempArray[i];
		}
		for(int element : nonDuplicateArray){
			System.out.printf("%d", element);
		}
		System.out.println();
		
		return;
	}
	
	public boolean equals(hw1_F74011140_V02 s){
		if(elements.length != s.elements.length)
			return false;
		int [] temp_A = new int[elements.length];
		int [] temp_B = new int[s.elements.length];
		for(int i = 0; i < elements.length; i++){
			temp_A[i] = elements[i];
		}
		for(int i = 0; i < elements.length; i++){
			temp_B[i] = s.elements[i];
		}
		
		Arrays.sort(temp_A);
		Arrays.sort(temp_B);
		
		for(int i = 0; i < elements.length; i++){
			if(temp_A[i] != temp_B[i])
				return false;
		}
		
		return true;
	};
	
	public int count(int number, int temp[]){
		int count = 0;
		
		for(int i = 0; i < temp.length; i++){
			if(temp[i] == number)
				count++;
		}
		
		return count;
	}
	
	public int postion(int number, int order, int temp[]){
		for(int i = 0; i < temp.length; i++){
			if(temp[i] == number)
				order--;
			if(order == 0)
				return i;
		}
		return -1;
	}
	
	public boolean compare(int number, int temp_A[][], int temp_B[][]){
		for(int i = 0; i < temp_B.length; i++){
			if(temp_B[i][0] == temp_A[number][0]){
				if(temp_B[i][1] >= temp_A[number][1])
					return true;
				else
					return false;
			}
		}
		return false;
	}
	
	public boolean subSet(hw1_F74011140_V02 s){
		if(s.elements.length < elements.length)
			return false;
		
		int [][] temp_A = new int[elements.length][2];
		int [][] temp_B = new int[s.elements.length][2];
		
		for(int i = 0; i < elements.length; i++){
			temp_A[i][0] = elements[i];
			temp_A[i][1] = count(elements[i], elements);
		}
		for(int i = 0; i < s.elements.length; i++){
			temp_B[i][0] = s.elements[i];
			temp_B[i][1] = count(s.elements[i], s.elements);
		}
		
		for(int i = 0; i < elements.length; i++){
			for(int j = 0; j < s.elements.length; j++){
				if(temp_B[j][0] == temp_A[i][0]){
					if(temp_B[j][1] < temp_A[i][1])
						return false;
				}
			}
		}
		
		return true;
	}
	
	public hw1_F74011140_V02 union(hw1_F74011140_V02 s){		
		int [][] temp_A = new int[elements.length][2];
		int [][] temp_B = new int[s.elements.length][2];
		int [][] temp = new int[elements.length][2];
		
		for(int i = 0; i < elements.length; i++){
			temp_A[i][0] = elements[i];
			temp_A[i][1] = count(elements[i], elements);
		}
		for(int i = 0; i < s.elements.length; i++){
			temp_B[i][0] = s.elements[i];
			temp_B[i][1] = count(s.elements[i], s.elements);
		}
		for(int i = 0; i < elements.length; i++){
			temp[i][0] = -1;
			temp[i][1] = -1;
		}
		
		int count = 0;
		for(int i = 0; i < elements.length; i++){
			for(int j = 0; j < s.elements.length; j++){
				if(temp_A[i][0] == temp_B[j][0]){
					if(temp_A[i][1] > temp_B[j][1]){
						temp[i][0] = temp_A[i][0];
						temp[i][1] = temp_A[i][1];
						count = count + temp[i][1];
					}
					else if(temp_A[i][1] <= temp_B[j][1]){
						temp[i][0] = temp_A[i][0];
						temp[i][1] = temp_B[j][1];
						count = count + temp[i][1];
					}
				}
			}
		}
		
		int [] temp_temp = new int[elements.length];
		for(int i = 0; i < elements.length; i++){
			temp_temp[i] = temp[i][0];
		}
		for(int i = 0; i < elements.length; i++){
			if(count(temp_temp[i],temp_temp) != 1){
				for(int j = 2; j <= count(temp_temp[i],temp_temp); j++){
					int number = postion(temp_temp[i], j, temp_temp);
					temp[number][0] = -1; 
				}
			}
		}
		
		for(int i = 0; i < elements.length; i++){
			for(int j = 0; j < elements.length; j++){
				if(temp_A[i][0] == temp[j][0]){
					if(temp_A[i][1] <= temp[j][1]){
						temp_A[i][0] = -1;
					}
				}
			}
		}
		for(int i = 0; i < s.elements.length; i++){
			for(int j = 0; j < elements.length; j++){
				if(temp_B[i][0] == temp[j][0]){
					if(temp_B[i][1] <= temp[j][1]){
						temp_B[i][0] = -1;
					}
				}
			}
		}
		
		String temp_s = "-1";
		for(int i = 0; i < elements.length + s.elements.length + count; i++){
			temp_s = temp_s + ",-1";
		}
		hw1_F74011140_V02 c = new hw1_F74011140_V02(temp_s);
		
		for(int i = 0; i < elements.length; i++){
			c.elements[i] = temp_A[i][0];		
		}
		for(int i = elements.length, j = 0; i < elements.length + s.elements.length; i++, j++){
			c.elements[i] = temp_B[j][0];		
		}
		for(int i = elements.length + s.elements.length, j = 0; j < elements.length; j++){
			for(int k = 0; k < temp[j][1]; k++){
				c.elements[i] = temp[j][0];
				i++;
			}
		}

		return c;
	}
	
	public hw1_F74011140_V02 intersection(hw1_F74011140_V02 s){
		int [][] temp_A = new int[elements.length][2];
		int [][] temp_B = new int[s.elements.length][2];
		int [][] temp = new int[elements.length][2];
		
		for(int i = 0; i < elements.length; i++){
			temp_A[i][0] = elements[i];
			temp_A[i][1] = count(elements[i], elements);
		}
		for(int i = 0; i < s.elements.length; i++){
			temp_B[i][0] = s.elements[i];
			temp_B[i][1] = count(s.elements[i], s.elements);
		}
		for(int i = 0; i < elements.length; i++){
			temp[i][0] = -1;
			temp[i][1] = -1;
		}
		
		int count = 0;
		for(int i = 0; i < elements.length; i++){
			for(int j = 0; j < s.elements.length; j++){
				if(temp_A[i][0] == temp_B[j][0]){
					if(temp_A[i][1] <= temp_B[j][1]){
						temp[i][0] = temp_A[i][0];
						temp[i][1] = temp_A[i][1];
						count = count + temp[i][1];
					}
					else if(temp_A[i][1] > temp_B[j][1]){
						temp[i][0] = temp_A[i][0];
						temp[i][1] = temp_B[j][1];
						count = count + temp[i][1];
					}
				}
			}
		}
		
		int [] temp_temp = new int[elements.length];
		for(int i = 0; i < elements.length; i++){
			temp_temp[i] = temp[i][0];
		}
		for(int i = 0; i < elements.length; i++){
			if(count(temp_temp[i],temp_temp) != 1){
				for(int j = 2; j <= count(temp_temp[i],temp_temp); j++){
					int number = postion(temp_temp[i], j, temp_temp);
					temp[number][0] = -1; 
				}
			}
		}
		
		String temp_s = "-1";
		for(int i = 0; i < count; i++){
			temp_s = temp_s + ",-1";
		}
		hw1_F74011140_V02 c = new hw1_F74011140_V02(temp_s);
		
		for(int i = 0, j = 0; j < elements.length; j++){
			for(int k = 0; k < temp[j][1]; k++){
				c.elements[i] = temp[j][0];
				i++;
			}
		}

		return c;
	}
	
	public static void main(String[] args) {
		hw1_F74011140_V02 a = new hw1_F74011140_V02(args[0]);
		hw1_F74011140_V02 b = new hw1_F74011140_V02(args[1]);
		System.out.println("第一個數字集合長度:"+a.size());
		System.out.println("第一個數字集合是否為空集合:"+a.isEmpty());
		System.out.println("第一個數字集合是否為都為質數:"+a.isPnumber());
		System.out.println("第一個數字集合是否為都為偶數:"+a.isEvennumber());
		System.out.println("第一個數字集合中最大的數字:"+a.getMaximalElement());
		System.out.printf("第一個數字集合顛倒輸出:");
		a.reverse();
		System.out.printf("第一個數字集合的distinct結果:");
		a.showDistinctElements();
		System.out.println("第一個數字集合與第二個數字集合是否相同:"+a.equals(b));
		System.out.println("第一個數字集合是否為第二個數字集合的子集合:"+a.subSet(b));
		System.out.printf("第一個數字集合連集第二個數字集合:");
		hw1_F74011140_V02 c = a.union(b);
		for(int i = 0; i < c.elements.length; i++){
			if(c.elements[i] == -1)
				continue;
			System.out.printf("%d,",c.elements[i]);
		}
		System.out.println();
		hw1_F74011140_V02 d = a.intersection(b);
		System.out.printf("第一個數字集合交集第二個數字集合:");
		for(int i = 0; i < d.elements.length; i++){
			if(d.elements[i] == -1)
				continue;
			System.out.printf("%d,",d.elements[i]);
		}
	}
}