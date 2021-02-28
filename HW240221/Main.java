package HW240221;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        People people = new People("Ivan",18,"male");
        People people1 = new People("Yurii",28,"male");
        People people2 = new People("Anna",56,"female");
        People people3 = new People("Sergei",61,"male");
        People people4 = new People("Yana",40,"female");

        List<People> everyone = Arrays.asList(people,people1,people2,people3,people4);

        System.out.println("People : " + everyone);
        System.out.println("___________");

    //Вибрати чоловіків-військовозобов'язаних (від 18 до 27 років)

        List<People> armyReady = everyone.stream()
                .filter(elem -> elem.getAge() >=18 && elem.getAge() <=27 && elem.getSex() == "male")
                .collect(Collectors.toList());
        System.out.println("Ready for army's service : " + armyReady);

    //Знайти середній вік серед чоловіків

        int sum = everyone.stream().filter(elem -> elem.getSex() == "male").mapToInt(elem -> elem.getAge()).sum();
        System.out.println("Mean of men's age : " + sum/3);
        System.out.println("___________");


        //Знайти кількість потенційно працездатних людей у вибірці (тобто від 18 років і з огляду на що жінки виходять в 55 років, а чоловік в 60)

        List<People> ableBodiedMen =everyone.stream()
                .filter(elem -> elem.getAge() >=18 && elem.getAge() <=60 && elem.getSex() == "male")
                .collect(Collectors.toList());
        System.out.println("Able-bodied men : " + ableBodiedMen);
        System.out.println("___________");

        List<People> ableBodiedWomen =everyone.stream()
                .filter(elem -> elem.getAge() >=18 && elem.getAge() <=55 && elem.getSex() == "female")
                .collect(Collectors.toList());
        System.out.println("Able-bodied women : " + ableBodiedWomen);
        System.out.println("___________");

        //Відсортувати колекцію людей за ім'ям в зворотному алфавітному порядку

        List<People> sortedByName = everyone.stream().sorted(Comparator.comparing(People::getName).reversed()).collect(Collectors.toList());
        System.out.println("Names from Z to A :" + sortedByName);
        System.out.println("___________");

        //Відсортувати колекцію людей спочатку за ім’ям, а потім за віком

        List<People> sortedByNameAndAge = everyone.stream().sorted(Comparator.comparing(People::getName).thenComparing(People::getAge)).collect(Collectors.toList());
        System.out.println("Sorted by name and age : " + sortedByNameAndAge);
        System.out.println("___________");

        //Знайти найстаршу людину

        List<People> theOldestOne = everyone.stream().max(Comparator.comparing(People::getAge)).stream().collect(Collectors.toList());
        System.out.println("The oldest one : " + theOldestOne);
        System.out.println("___________");

        //Знайти наймолодшу людину

        List<People> theYoungestOne = everyone.stream().min(Comparator.comparing(People::getAge)).stream().collect(Collectors.toList());
        System.out.println("The youngest one : " + theYoungestOne);
        System.out.println("___________");

        //Вивести скільки є чоловіків

        long countMale = everyone.stream().filter(elem -> elem.getSex() == "male").count();
        System.out.println("Number of men : " + countMale);
        System.out.println("___________");
        //Вивести скільки є жінок

        long countFemale = everyone.stream().filter(elem -> elem.getSex() == "female").count();
        System.out.println("Number of women : " + countFemale);
        System.out.println("___________");

        //Вивеcти всіх жінок в яких ім’я починається на “A”

        List<People> nameStartsWithA = everyone.stream()
                .filter(elem -> elem.getName().startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("Names start with letter A : " + nameStartsWithA);
        System.out.println("___________");


    }
}
