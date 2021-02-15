package HW080221;

import java.io.*;

public class Methods {
  public void serializeObject (Employee employee) throws IOException {
      FileOutputStream fileOutputStream = new FileOutputStream("E:\test\\hwtest.txt");

      Employee employee1 = new Employee("Yurii","qw123",2000);

      ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
      objectOutputStream.writeObject(employee1);
      objectOutputStream.close();
      System.out.println("Employee was serialized.");



      }
      public Employee deserializeObject() throws IOException, ClassNotFoundException {
      FileInputStream fileInputStream = new FileInputStream("E:\\test\\hwtest.txt");
      ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

      Employee employee1 = (Employee) objectInputStream.readObject();
      objectInputStream.close();
      fileInputStream.close();
          System.out.println("Employee was deserialized.");

          return employee1;
      }
  }

