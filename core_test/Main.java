package core_test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {


        try (InputStream inputStream = new FileInputStream("F:\\Task\\deviceInfo.txt");

        ) {


            String str = ", ";
            while (inputStream.available() > 0) {
                str += (char) inputStream.read();
            }

            System.out.println(str);
            String[] words = str.split("/n");
            for (int i = 0, wordsLength = words.length; i < wordsLength; i++) {
                String word = words[i];
                System.out.println(word);
            }
            Device device  = new Device(Long.parseLong(words[0]), words[1], words[2], Integer.parseInt(words[3]));
    //Device device1 = new Device(Long.parseLong(words[4]),words[5], words[6], Integer.parseInt(words[7]));
    //Device device2 = new Device(Long.parseLong(words[8]),words[9], words[10], Integer.parseInt(words[11]));
    //Device device3 = new Device(Long.parseLong(words[12]),words[13], words[14], Integer.parseInt(words[15]));


            //byte[] bytesArr = device.toString().getBytes(StandardCharsets.UTF_8);

            ///List<Device> devices = Arrays.asList(device,device1,device2,device3);

            //System.out.println("Devices : " + devices);
            System.out.println("___________");

            //1. Вивести весь список на екран.

            //2. Шукати Device за серійним номером (Якщо такого Device немає кидати помилку, яку створите самостійно).

            //3. Вивести посортований список за назвою бренду.

            //4. Вивести лише ті Device у яких ціна більша ніж 400.

            //5. Вивести лише ті Device у яких в серійному номері є нуль(0) і ціна менша за 800.

            //6. Вивести найдорожчий товар.

        } catch (IOException e) {
            e.printStackTrace();

        }

    }
}