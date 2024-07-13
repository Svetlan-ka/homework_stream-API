import java.util.function.*;

public class Calculator {
    static Supplier<Calculator> instance = Calculator::new;

    Calculator() { }

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    BinaryOperator<Integer> devide = (x, y) -> y != 0 ? x / y : checkingDivision(x, y);

    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;
    Consumer<Integer> println = System.out::println;

    private static Integer checkingDivision(Integer x, Integer y) {
        int answer = 0;
        try {
            answer = x / y;
        } catch (ArithmeticException e) {
            System.out.println("Zero division");
        }
        return answer;
    }








}
