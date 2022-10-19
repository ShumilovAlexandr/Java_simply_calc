import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeMap;

public class Calculate {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.homeGreeting();
        main.calc();
    }
}


class Main {

    //Стартовое приветствие
    public static void homeGreeting() {
        System.out.println("Добро пожаловать в калькулятор римских и арабских цифр!");
        System.out.println("Функционал калькулятора довольно прост - он может складывать, вычитать, умножать и делить");
        System.out.println("между собой арабские и римские цифры,");
        System.out.println("но только римские с римскими - а арабские с арабскими.");
    }

    //Реализация калькулятора
    public static String calc() throws IOException {
        // Создаем объект типа Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите математическое выражение: ");

        //Вводим строку с математическим выражением
        String str = scanner.nextLine();
        String[] operator = {"+", "-", "/", "*"};
        String[] regex = {"\\+", "-", "/", "\\*"};

        //Проверка длины передаваемой строки
        if (str.length() < 2) {
            throw new IOException("Формат математической операции не удовлетворяет заданию - задано " +
                    "неправильное количество операндов");
        }

        //Убираем пробелы в вводимой строке
        String exp = str.replaceAll(" ", "");

        //определяем оператор
        int actionOperator = -1;
        for (var i = 0; i < operator.length; i++) {
            if (exp.contains(operator[i])) {
                actionOperator = i;
                break;
            }
        }

        //и приводим к массиву цифр, c которым уже можно обращаться по индексу
        String[] data = exp.split(regex[actionOperator]);

        //Ниже осуществляется проверка на длину вводимой строки, для избежания
        // введения лишних операндов и операторов
        if (data.length > 2) {
            throw new IOException("Формат математической операции не удовлетворяет заданию - задано " +
                    "неправильное количество операндов");
        }

        //Парсим цифры по индексу элементов из строки которую получили выше
        int num1 = Integer.parseInt(data[0]);
        int num2 = Integer.parseInt(data[1]);
        int result;


        //Осуществляем проверку оператора и выполняем между операндами соответствующую операцию
        switch (operator[actionOperator]) {
            case "/":
                result = num1 / num2 ;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            default:
                result = num1 + num2;
       }

        //Организуем проверку на максимальное значение вводимых операндов (в арабских цифах)
        if (num1 <= 0 || num1 > 10) {
            throw new IOException("Операнд 1 не может быть меньше или равен 0 и не может быть больше 10");
        } else if (num2 <= 0 || num2 > 10) {
            throw new IOException("Операнд 2 не может быть меньше или равен 0 и не может быть больше 10");
        }

        // Выводим результат осуществленной операции
        System.out.println(result);
        scanner.close();
        return str;
    }

    //Сравниваем передаваемые цифры в римском и арабском форматах
    private static int romanNumber(String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Операнд не может быть меньше или равен 0 и не" +
                    "может быть больше 10");
        }
        return 0;
    }

    // Заводим массив римских чисел
    private static String convertArabicToRoman (int numArabian){
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII",
                "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI",
                "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII",
                "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX",
                "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII",
                "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV",
                "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
                "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI",
                "XCVII", "XCVIII", "XCIX", "C"
        };
        final String string = roman[numArabian];
        return string;
    }

}









//class Main {
//
//    //Стартовое приветствие
//    public static void homeGreeting(){
//        System.out.println("Добро пожаловать в калькулятор римских и арабских цифр!");
//        System.out.println("Функционал калькулятора довольно прост - он может складывать, вычитать, умножать и делить");
//        System.out.println("между собой арабские и римские цифры,");
//        System.out.println("но только римские с римскими - а арабские с арабскими.");
//    }
//
//    //Реализация калькулятора
//    public static String calc() throws IOException {
//        // Создаем объект типа Scanner
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Введите математическое выражение: ");
//
//        //Вводим строку с математическим выражением
//        String str = scanner.nextLine();
//        String[] operator = {"+", "-", "/", "*"};
//        String[] regex = {"\\+", "-", "/", "\\*"};
//
//        //Убираем пробелы в вводимой строке
//        String exp = str.replaceAll(" ", "");
//
//
//        //определяем оператор
//        int actionOperator = -1;
//        for (var i = 0; i < operator.length; i++){
//            if(exp.contains(operator[i])){
//                actionOperator = i;
//                break;
//            }
//        }
//
//        //и приводим к массиву цифр, c которым уже можно обращаться по индексу
//        String[] data = exp.split(regex[actionOperator]);
//
//        //Парсим цифры по индексу элементов из строки которую получили выше
//        int num1 = Integer.parseInt(data[0]);
//        int num2 = Integer.parseInt(data[1]);
//        int result;
//
//        //Ниже осуществляется проверка на длину вводимой строки, для избежания
//        // введения лишних операндов и операторов
//        if(data.length > 2){
//            throw new IOException("Формат математической операции не удовлетворяет заданию - задано " +
//                    "больше 2 операндов и 1 оператора");
//        }
//
//        //Осуществляем проверку оператора и выполняем между операндами соответствующую операцию
//        switch (operator[actionOperator]){
//            case "/":
//                result = num1 / num2;
//                break;
//            case  "-":
//                result = num1 - num2;
//                break;
//            case  "*":
//                result = num1 * num2;
//                break;
//            default:
//                result = num1 + num2;
//        }
//
//        //Организуем проверку на максимальное значение вводимых операндов (в арабских цифах)
//        if(num1 <= 0 || num1 > 10){
//            throw new IOException("Операнд 1 не может быть меньше или равен 0 и не может быть больше 10");
//        } else if(num2 <= 0 || num2 > 10){
//            throw new IOException("Операнд 2 не может быть меньше или равен 0 и не может быть больше 10");
//        }
//
//        // Выводим результат осуществленной операции
//        System.out.println(result);
//        scanner.close();
//        return str;
//    }
//}