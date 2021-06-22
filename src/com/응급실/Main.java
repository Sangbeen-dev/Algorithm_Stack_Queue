package com.응급실;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person{
	int id;
	int priority;
	public Person(int id, int priority) {
		this.id = id;
		this.priority = priority;
	}	
}

public class Main {
	public int solution(int n, int m, int[] arr) {
		int answer=0;
		Queue<Person> Q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			Q.offer(new Person(i, arr[i]));
		}
		while(!Q.isEmpty()) {
			Person tmp = Q.poll();
			for (Person p : Q) {
				if(p.priority > tmp.priority) {
					Q.offer(tmp);
					tmp = null;
					break;
				}
			}
			if(tmp!=null) {
				answer ++;
				if(tmp.id==m) return answer;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		Main t = new Main();
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int m = kb.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		
		System.out.println(t.solution(n, m, arr));
		kb.close();
	}
}
