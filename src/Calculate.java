import java.util.Scanner;

public class Calculate {
    public static void main(String[] args) {
        Main main = new Main();
        main.calc();
    }
}

class Main {

    public static String calc(){
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
        System.out.println(result);
        scanner.close();
        return str;
    }
}
