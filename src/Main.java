import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        calc();
    }
    private static void calc() {
        Scanner scanner = new Scanner(System.in);
        String[] act = {"+", "-", "/", "*"}; //здесь я сделал операторов для свитча
        String[] act2 = {"\\+", "-", "/", "\\*"}; //регулярное выражения
        String value = scanner.nextLine(); //вводим нашу строку
        String s = null; //нужно для exception
        int result = 0; //по умолчанию 0

        int index=-1; // здесь мы проверяем оператора, начинаем с -1, т.к он бы не проверял +
        for (int i = 0; i < act.length; i++) {
            if(value.contains(act[i])){
                index = i;
                break;
            }
        }

        if(index==-1){ //здесь если ничего не находит
            System.out.println("Некорректное выражение");
            return;
        }
        String[] data = value.split(act2[index]); //здесь преобразуем нашу строку в числа
        int a,b;
        a = Integer.parseInt(data[0]);
        b = Integer.parseInt(data[1]);

        switch (act[index]) { //оператор свитч, проверка по оператору
            case "+": result = a + b;
                break;

            case "-": result = a - b;
                break;

            case "/":
                try {
                    result = a / b;// деление на 0
                } catch (ArithmeticException e) {
                    s = "На ноль делить нельзя";
                }
                break;
            case "*": result = a * b;
                break;
            default:
                System.out.println("Некорректное выражение");
                break;
        }
        if (b == 0) {
            System.out.println(s);
        } else {
            System.out.println(result);
        }
    }
}
