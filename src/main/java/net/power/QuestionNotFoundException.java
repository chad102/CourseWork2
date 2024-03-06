package net.power;

public class QuestionNotFoundException extends RuntimeException {
    public QuestionNotFoundException() {
        super("Вопрос не найден");
    }
}
