import java.io.IOException;
import java.util.Arrays;
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

        //Ниже осуществляется проверка на длину вводимой строки, для избежания
        // введения лишних операндов и операторов
        if(str.length() > 7) {
            throw new IOException("Формат математической операции не удовлетворяет заданию - задано " +
                    "больше 2 операндов и 1 оператора");
        }

        //Убираем пробелы в вводимой строке
        String exp = str.replaceAll(" ", "");

        //определяем оператор
        int actionOperator = -1;
        for (var i = 0; i < operator.length; i++){
            if(exp.contains(operator[i])){
                actionOperator = i;
                break;
            }
        }

        //и приводим к массиву цифр, c которым уже можно обращаться по индексу
        String[] data = exp.split(regex[actionOperator]);

        //Парсим цифры по индексу элементов из строки которую получили выше
        int num1 = Integer.parseInt(data[0]);
        int num2 = Integer.parseInt(data[1]);
        int result;

        //Осуществляем проверку оператора и выполняем между операндами соответствующую операцию
        switch (operator[actionOperator]){
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
            throw new IOException("Операнд 1 не может быть меньше или равен 0 и не может быть больше 10");
        } else if(num2 <= 0 || num2 > 10){
            throw new IOException("Операнд 2 не может быть меньше или равен 0 и не может быть больше 10");
        }

        // Выводим результат осуществленной операции
        System.out.println(result);
        scanner.close();
        return str;
    }
}


class ArabicNumerals{

}
