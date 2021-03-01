package core_test;

import HW240221.People;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException, NoSuchSerialException {


        Scanner scanner = new Scanner(System.in);

        try (InputStream inputStream = new FileInputStream("F:\\Task\\deviceInfo.txt");

        ) {


            String str = "";
            while (inputStream.available() > 0) {
                str += (char) inputStream.read();
            }

            //System.out.println(str);
            String[] words = str.split("\n");
            //for (int i = 0, wordsLength = words.length; i < wordsLength; i++) {
                //String word = words[i];
                //System.out.println(word);
            //}
            List<String> ss = Files.lines(Path.of("F:\\Task\\deviceInfo.txt")).collect(Collectors.toList());
            //System.out.println(ss);
            List<Device> devices = new ArrayList<>();

            for (int i = 0; i < ss.size(); i++) {

                String[] parse = ss.get(i).split(", ");
                devices.add(new Device(Long.parseLong(parse[0]), parse[1], parse[2], Integer.parseInt(parse[3])));
                System.out.println(devices.get(i));
            }

            List<Device> sortedDevices = devices.stream()
                    .filter(elemen -> elemen.getPrice() > 100 && elemen.getPrice() <= 800 && "Apple".equals(elemen.getBrand()))
                    .collect(Collectors.toList());
            //System.out.println("Sorted : " + sortedDevices);



            System.out.println("___________");
            while (true) {
                System.out.println("" +
                        "\n1 - Вивести весь список на екран." +
                        "\n2 - Шукати Device за серійним номером " +
                        "\n3 - Вивести посортований список за назвою бренду." +
                        "\n4 - Вивести лише ті Device у яких ціна більша ніж 400." +
                        "\n5 - Вивести лише ті Device у яких в серійному номері є нуль(0) і ціна менша за 800." +
                        "\n6 - Вивести найдорожчий товар." +
                        "\n0 - Вихід з програми.");
                String select = scanner.next();
                switch (select) {
                    case "1": {
                        devices.forEach(System.out::println);
                        break;
                    }
                    case "2": {
                        System.out.println("Ведіть серійний номер");
                        long serial =scanner.nextLong();
                        List<Device> snumbersList = devices.stream()
                                .filter(elemen ->elemen.getSerialNumber()==serial)
                                .collect(Collectors.toList());
                        System.out.println(snumbersList);

                        break;
                    }
                    case "3": {
                        List<Device> sortedByBrand = devices.stream()
                                .sorted(Comparator.comparing(Device::getBrand))
                                        .collect(Collectors.toList());
                        System.out.println("Sorted by brand" + sortedByBrand);
                        break;
                    }
                    case "4": {
                        List<Device> moreThen = devices.stream()
                                .filter(elemen -> elemen.getPrice() > 400 )
                                .collect(Collectors.toList());
                        System.out.println("More then 400 USD : " + moreThen);

                        break;
                    }
                    case "5": {
                        List<Device> zeroPlusPrice800 = devices.stream()
                                .filter(elemen -> String.valueOf(elemen.getSerialNumber()).contains("0"))
                                .collect(Collectors.toList());
                        System.out.println("Less then 800 USD : " + zeroPlusPrice800);

                        break;
                    }
                    case "6": {
                        List<Device> theMostExpensive = devices.stream().max(Comparator.comparing(Device::getPrice)).stream().collect(Collectors.toList());
                        System.out.println("The most expensive device : " + theMostExpensive);

                        break;
                    }

                    default: {
                        System.exit(0);
                    }

                }
            }

            }

    }
    }
