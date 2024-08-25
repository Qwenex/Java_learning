package exceptions;

/**
 * Класс ошибки "Деление на ноль"
 */
public class DivisionByZero extends RuntimeException {

    public DivisionByZero() {
        super("Деление на ноль не поддерживается");
    }

    public DivisionByZero(String s) {
        super(s);
    }
}