package JavaAssessment;

import java.util.PriorityQueue;
import java.util.Scanner;

class Student {
    String name;
    double cgpa;
    int id;

    public Student(String name, double cgpa, int id) {
        this.name = name;
        this.cgpa = cgpa;
        this.id = id;
    }
}
public class Question2 {

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in);

	        PriorityQueue<Student> pq = new PriorityQueue<>(
	                (s1, s2) -> {
	                    if (Double.compare(s2.cgpa, s1.cgpa) != 0) {
	                        return Double.compare(s2.cgpa, s1.cgpa); 
	                    } else if (!s1.name.equals(s2.name)) {
	                        return s1.name.compareTo(s2.name); 
	                    } else {
	                        return Integer.compare(s1.id, s2.id); 
	                    }
	                }
	        );

	        System.out.print("Enter number of events: ");
	        int N = sc.nextInt();
	        sc.nextLine();

	        System.out.println("Enter events:");

	        for (int i = 0; i < N; i++) {
	            String line = sc.nextLine();
	            String[] parts = line.split(" ");

	            if (parts[0].equalsIgnoreCase("ENTER")) {
	                String name = parts[1];
	                double cgpa = Double.parseDouble(parts[2]);
	                int id = Integer.parseInt(parts[3]);

	                pq.add(new Student(name, cgpa, id));
	            } 
	            else if (parts[0].equalsIgnoreCase("SERVED")) {
	                if (!pq.isEmpty()) {
	                    pq.poll(); 
	                }
	            }
	        }

	        if (pq.isEmpty()) {
	            System.out.println("EMPTY");
	        } else {
	            System.out.println("\nStudents yet to be served:");
	            while (!pq.isEmpty()) {
	                System.out.println(pq.poll().name);
	            }
	        }

	        sc.close();
	    }
	}
