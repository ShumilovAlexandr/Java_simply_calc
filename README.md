<h1 align="center">Привет, меня зовут<target="_blank"> Александр</a> 
<img src="https://github.com/blackcater/blackcater/raw/main/images/Hi.gif" height="32"/></h1>

# Приложение Java_simply_calc

## Описание:
Это простое консольное приложение “Калькулятор”. 
Приложение читает приведенные в консоли пользователем строки, числа, арифметические операции проводимые между ними и выводит в консоль результат их выполнения.

Приложение соответствует следующим условиям:
1. Калькулятор умеет выполнять операции сложения, вычитания, умножения и деления с двумя числами: a + b, a - b, a * b, a / b. 
2. Данные передаются в одну строку.
3. Калькулятор умеет работать как с арабскими (1,2,3,4,5…), так и с римскими (I,II,III,IV,V…) числами.
4. Калькулятор принимает на вход числа от 1 до 10 включительно, не более. На выходе числа не ограничиваются по величине и могут быть любыми.
5. Калькулятор умеет работать только с целыми числами.
6. Калькулятор умеет работать только с арабскими или римскими цифрами одновременно, при вводе пользователем строки вроде 3 + II калькулятор выбрасывает исключение и прекращает свою работу.
7. При вводе римских чисел, ответ возвращается римскими цифрами, соответственно, при вводе арабских - ответ возвращается арабскими.
8. При вводе пользователем неподходящих чисел приложение выбрасывает исключение и завершает свою работу.
9. При вводе пользователем строки, не соответствующей одной из вышеописанных арифметических операций, приложение выбрасывает исключение и завершает свою работу.
10. Результатом операции деления является целое число, остаток отбрасывается. 
11. Результатом работы калькулятора с арабскими числами могут быть отрицательные числа и ноль. 
12. Результатом работы калькулятора с римскими числами могут быть только положительные числа, так как в римской системе отсутствуют отрицательные числа.

### Пример работы программы:
Input:
1 + 2</br>
Output:
**3**

Input:
VI / III</br>
Output:
**II**

Input:
I - II</br>
Output:
**throws Exception //т.к. в римской системе нет отрицательных чисел**

Input:
I + 1</br>
Output:
**throws Exception //т.к. используются одновременно разные системы счисления**

Input:
1</br>
Output:
**throws Exception //т.к. строка не является математической операцией**

Input:
1 + 2 + 3</br>
Output:
**throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)***
