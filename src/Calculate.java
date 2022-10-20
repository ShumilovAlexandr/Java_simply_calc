import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Calculate {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.homeGreeting();
        main.calc();
    }
}


class Main {

    //Стартовое приветствие
    public static void homeGreeting(){
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

        //Убираем пробелы во вводимой строке
        String exp = str.replaceAll(" ", "");

        //определяем оператор
        int actionOperator = 0;
        for (var i = 0; i < operator.length; i++){
            if(exp.contains(operator[i])){
                actionOperator = i;
                break;
            }
        }

        //и приводим к массиву цифр, c которым уже можно обращаться по индексу
        String[] data = exp.split(regex[actionOperator]);

        //Ниже осуществляется проверка на длину вводимой строки, для избежания
        // введения лишних операндов и операторов
        if(data.length != 2){
            throw new IOException("Формат математической операции не удовлетворяет заданию - задано " +
                    "неверное количество операторов и операндов");
        }

        //Результат для римских чисел
        String n1 = data[0];
        String n2 = data[1];

        int result;
        int number1 = arabicToRoman(n1);
        int number2 = arabicToRoman(n2);

        //Организуем проверку на максимальное значение вводимых операндов
        if (number1 <= 0 || number2 <= 0 && number1 > 10 || number2 > 10){
            result = 0;
        }else {
            result = calculated(number1, number2, operator[actionOperator]);
            if(result <= 0){
                throw new IOException("В римской системе нет отрицательных чисел");
            }
            String resultNumbers = romanNumbers(result);
            System.out.println(resultNumbers);
            System.exit(result);
        }

        //Парсим цифры по индексу элементов из строки которую получили выше
        int num1 = Integer.parseInt(n1);
        int num2 = Integer.parseInt(n2);
        if(num1 <= 0 || num1 > 10){
            throw new IOException("Операнды не могут быть более 10 и меньше или равны 0");
        } else if (num2 <=0 || num2 >10){
            throw new IOException("Операнды не могут быть более 10 и меньше или равны 0");
        }
        // Результат для арабских чисел
        result = calculated(num1, num2, operator[actionOperator]);
        System.out.println(result);

        scanner.close();
        return str;
    }

    //Собственно метод калькулятор
    public static int calculated(int num1, int num2, String op){
        int result = switch (op) {
            case "/" -> num1 / num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            default -> num1 + num2;
        };
        //Осуществляем проверку оператора и выполняем между операндами соответствующую операцию
        return result;
    }

    //Определяем массив римских цифр
    private static String romanNumbers (int numArabian) {
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

    //Для конвертации чисел из Римского стиля в Арабские
    private static int arabicToRoman (String roman) {
        switch (roman) {
            case "I":
                return 1;
            case "II":
                return 2;
            case "III":
                return 3;
            case "IV":
                return 4;
            case "V":
                return 5;
            case "VI":
                return 6;
            case "VII":
                return 7;
            case "VIII":
                return 8;
            case "IX":
                return 9;
            case "X":
                return 10;
            }
        return 0;
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
//        //Организуем проверку на максимальное значение вводимых операндов
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