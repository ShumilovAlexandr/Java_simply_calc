import java.io.IOException;
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
        String[] operator = {"+", "-", "*", "/"};
        //Тут осуществляется проверка на длину вводимой строки, для избежания
        // введения лишних операндов и операторов
        if(str.length() > 7) {
            throw new IOException("Формат математической операции не удовлетворяет заданию - задано " +
                    "больше 2 операндов и 1 оператора");
        }

        //Убираем лишние пробелы в строке
        String exp = str.replaceAll("\\p{Space}", "");
        //и приводим к массиву цифр, к которым уже можно обращаться по идексу
        //TODO


        System.out.println(exp);


        //Парсим цифры по индексу элементов в строке
        int num1 = Integer.parseInt(String.valueOf(str.charAt(0)));
        int num2 = Integer.parseInt(String.valueOf(str.charAt(4)));
        int result;

        //Осуществляем проверку оператора и выполняем между операндами соответствующую операцию
        switch (String.valueOf(str.charAt(2))){
            case "/":
                result = num1 / num2;
                break;
            case  "-":
                result = num1 - num2;
                break;
            case  "*":
                result = num1 * num2;
                break;
            default:
                result = num1 + num2;
        }

        //Организуем проверку на максимальное значение вводимых операндов (в арабских цифах)
        if(num1 <= 0 || num1 > 10){
            throw new IOException("Операнд 1 не может быть меньше или равен 0");
        } else if(num2 <= 0 || num2 > 10){
            throw new IOException("Операнд 2 не может быть меньше или равен 0");
        }


        // Выводим результат осуществленной операции
 //       System.out.println(result);
        scanner.close();
        return str;
    }
}
