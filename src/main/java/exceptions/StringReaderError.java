package exceptions;

/**
 * Класс ошибки чтения строки
 */
public class StringReaderError extends RuntimeException {

    public StringReaderError() {
        super("При чтении строки произошла ошибка.");
    }

    public StringReaderError(String str) {
        super(String.format("При чтении строки {%s} произошла ошибка.", str));
    }
}