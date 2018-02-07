package plopik.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

    public static void main(String[] args) {
//        String[] langs = new String[4]; //массив строк типа Стринг с 4 элементами
//        langs[0] = "Java";
//        langs[1] = "C#";
//        langs[2] = "PHP";
//        langs[3] = "JavaScript";
        String[] langs = {"Java", "C#", "PHP", "JavaScript"}; //эквивалетное заполнение массива
        for ( int i = 0; i < langs.length; i++){
            System.out.println("Я хочу выучить " + langs[i]);
        }

        for (String l: langs){ // для массивов
            System.out.println("Я хочу выучить l " + l);
        }

//        List<String> languages = new ArrayList<String>(); //интерфейс лист реализация ArrayList
//        languages.add("Java"); //реализация заполнения списка
//        languages.add("C#");
//        languages.add("JavaScript");

        List<String> languages = Arrays.asList("Java", "C#", "PHP", "JavaScript"); //преобразование массива в списки (объект    )

        for (String l: languages){ // для списка 1 реализация
            System.out.println("Я хочу выучить " + l);
        }

        for (int i = 0; i < languages.size(); i++){ // для списка 2 реализация
            System.out.println("Я хочу выучить " + languages.get(i));
        }


    }
}
