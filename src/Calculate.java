//import java.io.IOException;
//import java.util.Scanner;
//
//
//public class Calculate {
//    public static void main(String[] args) throws IOException {
//        Main main = new Main();
//        main.homeGreeting();
//        main.calc();
//    }
//}
//
//
//class Main {
//
//    //Стартовое приветствие
//    public static void homeGreeting(){
//        System.out.println("Добро пожаловать в калькулятор римских и арабских цифр!");
//        System.out.println("Функционал калькулятора довольно прост - он может складывать, ");
//        System.out.println("вычитать, умножать и делить между собой арабские и римские цифры,");
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
//        //Убираем пробелы во вводимой строке
//        String exp = str.replaceAll(" ", "");
//
//        //определяем оператор
//        int actionOperator = 0;
//        for (var i = 0; i < operator.length; i++){
//            if(exp.contains(operator[i])){
//                actionOperator = i;
//                break;
//            }
//        }
//
//        //и приводим к массиву цифр, с которым уже можно обращаться по индексу
//        String[] data = exp.split(regex[actionOperator]);
//
//        //Ниже осуществляется проверка на длину вводимой строки, для избежания
//        // введения лишних операндов и операторов
//        if(data.length != 2){
//            throw new IOException("Формат математической операции не удовлетворяет заданию - задано " +
//                    "неверное количество операторов и операндов");
//        }
//
//        //Результат для римских чисел
//        String n1 = data[0];
//        String n2 = data[1];
//
//        int result;
//        int number1 = arabicToRoman(n1);
//        int number2 = arabicToRoman(n2);
//
//        //Организуем проверку на максимальное значение вводимых операндов
//        if(number1 > 0 && number2 > 0 || number1 <= 10 && number2 <= 10){
//            result = calculated(number1, number2, operator[actionOperator]);
//            if(result < 0){
//                throw new IOException("В римской системе нет отрицательных чисел");
//            }
//            String resultNumbers = romanNumbers(result);
//            System.out.println(resultNumbers);
//            System.exit(result);
//        }
//
//        //Парсим цифры по индексу элементов из строки которую получили выше
//       int num1 = Integer.parseInt(n1);
//       int num2 = Integer.parseInt(n2);
//       if(num1 < 0 || num1 > 10 && num2 < 0 || num2 >10){
//           throw new IOException("Операнды не могут быть более 10 и меньше или равны 0");
//       }
//       // Результат для арабских чисел
//       result = calculated(num1, num2, operator[actionOperator]);
//       System.out.println(result);
//
//        scanner.close();
//        return str;
//    }
//
//    //Собственно метод калькулятор
//    public static int calculated(int num1, int num2, String op){
//        int result = switch (op) {
//            case "/" -> num1 / num2;
//            case "-" -> num1 - num2;
//            case "*" -> num1 * num2;
//            default -> num1 + num2;
//        };
//        return result;
//    }
//
//    //Определяем массив римских цифр
//    private static String romanNumbers (int numArabian) {
//        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII",
//                "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI",
//                "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII",
//                "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX",
//                "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII",
//                "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV",
//                "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
//                "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI",
//                "XCVII", "XCVIII", "XCIX", "C"
//        };
//        final String string = roman[numArabian];
//        return string;
//    }
//
//    //Для конвертации чисел из Римского стиля в Арабские
//    public static int arabicToRoman (String roman) throws IOException {
//        int oper = switch (roman) {
//            case "I" -> 1;
//            case "II" -> 2;
//            case "III"-> 3;
//            case "IV"-> 4;
//            case "V"-> 5;
//            case "VI"-> 6;
//            case "VII"-> 7;
//            case "VIII"-> 8;
//            case "IX"-> 9;
//            case "X"-> 10;
//            default -> throw new IOException("В римской системе допустимо использование только цифр от I до X. " +
//                    "Только арабских цифр с арабскими, римских с римскими");
//            };
//            return oper;
//    }
//
//}









import java.util.Map;
import java.util.Scanner;
import java.util.List;
import java.util.function.IntBinaryOperator;

public class Calculate {
    public static void main(String[] args) {
        Main main = new Main();
        Main.homeGreeting();
        main.calc();
    }
}

class Main {

    //Стартовое приветствие
    public static void homeGreeting() {
        System.out.println("Добро пожаловать в калькулятор римских и арабских цифр!");
        System.out.println("Функционал калькулятора довольно прост - он может складывать, ");
        System.out.println("вычитать, умножать и делить между собой арабские и римские цифры,");
        System.out.println("но только римские с римскими - а арабские с арабскими.");
    }

    //Реализация калькулятора
    public static String calc(){
        // Создаем объект типа Scanner
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите математическое выражение: ");

        //Вводим строку с математическим выражением
        String str = scanner.nextLine();

       return str;
    }

    public static final Map<String, IntBinaryOperator> calculator = Map.of(
            "-", (num1, num2) -> num1 - num2,
            "+", (num1, num2) -> num1 + num2,
            "*", (num1, num2) -> num1 * num2,
            "/", (num1, num2) -> num1 / num2);


    public static void main() {
        final String ArabicNumbers = "[1-9]|10";
        final String Roman = "[I-IX]|X";
        final String Operator = "[+-*/]";
    }

    static int romanToArabic(final String number){
        return List.of("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X").indexOf(number);
    }


}

