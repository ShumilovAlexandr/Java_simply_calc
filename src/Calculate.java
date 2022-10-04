import java.util.Scanner;

public class Calculate {
    public static void main(String[] args) {
        Main main = new Main();
        main.calc();
    }
}

class Main {
    static int answer;
    public static int calc(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите два числа через enter (арабские, либо римские): ");
        int numb1 = scanner.nextInt();
        int numb2 = scanner.nextInt();
        System.out.println("Введите оператор (можно использовать операторы +, -, *, /: ");
        String operator = String.valueOf(scanner.next().charAt(0));
        switch (operator) {
            case "+": answer = numb1 + numb2;
                break;
            case  "-": answer = numb1 - numb2;
                break;
            case "*": answer = numb1 * numb2;
                break;
            case "/": answer = numb1 / numb2;
                break;
        }
        System.out.printf(numb1 + " " + operator + " " + numb2 + " = " + answer);
        return answer;
    }
}
