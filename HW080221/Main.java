package HW080221;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String filename = "E:\\test\\hwtest.txt";
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Andrei", "QW234", 3000));
        list.add(new Employee("Petr", "QW456", 4000));
        list.add(new Employee("Alexandr", "QW789", 5000));

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            Salary s  = new Salary("UAH");
            objectOutputStream.writeObject(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Salary> newSalary = new ArrayList<>();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            newSalary = ((ArrayList<Salary>)objectInputStream.readObject());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            Employee e = new Employee("Ivan", "QW098", 1500);
            objectOutputStream.writeObject(e);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            Employee e = (Employee) objectInputStream.readObject();
            System.out.println(e.getName());
            System.out.println(e.getId());
            System.out.println(e.getSalary());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(list);
            System.out.println("File has been written.");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Employee> newEmployee = new ArrayList<>();
        try ( ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            newEmployee=((ArrayList<Employee>)objectInputStream.readObject());


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

            for (Employee f : newEmployee) {
                System.out.println(f.getName());
                System.out.println(f.getId());
                System.out.println(f.getSalary());
            }
        }
    }
}