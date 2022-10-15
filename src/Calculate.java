import java.io.IOException;
import java.util.Scanner;

public class Calculate {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.calc();
    }
}

class Main {

    public static String calc() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите математическое выражение: ");
        String str = scanner.nextLine();
        int num1 = Integer.parseInt(String.valueOf(str.charAt(0)));
        int num2 = Integer.parseInt(String.valueOf(str.charAt(4)));
        int result;
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
        if(num1 <= 0 || num1 > 10){
            throw new IOException("Операнд 1 не может быть меньше или равен 0");
        } else if(num2 <= 0 || num2 > 10){
            throw new IOException("Операнд 2 не может быть меньше или равен 0");
        }




        System.out.println(result);
        scanner.close();
        return str;
    }
}
