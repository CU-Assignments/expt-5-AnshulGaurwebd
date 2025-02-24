//22bcs13276_Anshul Gaur

import java.io.*;

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
        String filename = "student.ser";
        Student student = new Student(1, "Evelyn", 3.9);
        serializeStudent(student, filename);
        deserializeStudent(filename);
    }

    private static void serializeStudent(Student student, String filename) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeObject(student);
            System.out.println("Serialization Successful");
        } catch (IOException e) {
            System.out.println("Error during serialization: " + e);
        }
    }

    private static void deserializeStudent(String filename) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Student student = (Student) in.readObject();
            System.out.println("Deserialized Student: " + student);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e);
        } catch (IOException e) {
            System.out.println("Error during deserialization: " + e);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e);
        }
    }
}
