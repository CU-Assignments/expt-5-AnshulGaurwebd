//22bcs13276_Anshul Gaur

import java.io.*;
import java.util.*;

class Student implements Serializable {
    private int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", GPA: " + gpa;
    }
}

public class Main {
    public static void main(String[] args) {
        List<String> numbers = Arrays.asList("10", "20", "30", "40", "50");
        List<Integer> intList = new ArrayList<>();
        for (String num : numbers) {
            intList.add(Integer.parseInt(num));
        }
        int sum = 0;
        for (Integer num : intList) {
            sum += num;
        }
        System.out.println("Sum: " + sum);
        
        Student student = new Student(1, "Evelyn", 3.9);
        String filename = "student.ser";
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(student);
            System.out.println("Serialization Successful");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e);
        }
        
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Student deserializedStudent = (Student) in.readObject();
            System.out.println("Deserialized Student: " + deserializedStudent);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e);
        } catch (IOException e) {
            System.out.println("Error during deserialization: " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e);
        }
    }
}
