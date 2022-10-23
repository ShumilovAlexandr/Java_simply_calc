import java.util.Map;
import java.util.Scanner;
import java.util.List;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;


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
        final String ArabicNumbers = "[1-9]|10";
        final String RomanNumbers = "I|II|III|IV|V|VI|VII|VIII|IX|X";
        final String Operator = "[-+*/]";
        final String OR = "|";

        // Создаем объект типа Scanner
        // и вводим математическое выражение
        var scanner = new Scanner(System.in);
        System.out.print("Введите математическое выражение: ");

        //src равен одной из римских, или одной из арабских цифр
        var src = scanner.next(RomanNumbers + OR + ArabicNumbers);
        var operator = scanner.next(Operator);

        //Проверяем содержит ли в себе строка значения из регулярного выражения RomanNumbers
        var numbersIsRoman = src.matches(RomanNumbers);

        //Если содержит, то значение condition включает в себя элементы из (RomanNumbers), и наоборот
        var condition = scanner.next(numbersIsRoman ? RomanNumbers : ArabicNumbers);

        // Приводит результат функции romanToArabic к значению Integer, распарсивает его
        ToIntFunction<String> toInt = numbersIsRoman ? Main::romanToArabic : Integer::parseInt;
        IntFunction<String> toString = numbersIsRoman ? Main::arabicToRoman : Integer::toString;

        // Соответствующий оператор выполняет работу над операндами, переданными с помощью applyAsInt (src, condition)
        // Получаем результат и сохраняем в переменной result.
        // Результат возвращается в системе арабских цифр.
        int result = calculator.get(operator).applyAsInt(toInt.applyAsInt(src), toInt.applyAsInt(condition));

        // Выводим результат выполнения работы калькулятора
        System.out.println(toString.apply(result));
        return toString.apply(result);
    }

    //Логика калькулятора
    public static final Map<String, IntBinaryOperator> calculator = Map.of(
            //используем лямбда выражения
            "-", (num1, num2) -> num1 - num2,
            "+", Integer::sum,
            "*", (num1, num2) -> num1 * num2,
            "/", (num1, num2) -> num1 / num2);

    //Конвертируем римские в арабские, по индексу цифры, 1 - потому что нумерация с 0 начинается
    static int romanToArabic(String number){
        return 1 + List.of("I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X").indexOf(number);
    }

    //Конвертируем арабские цифры в римские, с помощью остатка от деления
    static String arabicToRoman(int number){
        return String.join("",
                number == 100 ? "C" : "",
                new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}[number % 100 / 10],
                new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}[number % 10]
        );
    }
}

