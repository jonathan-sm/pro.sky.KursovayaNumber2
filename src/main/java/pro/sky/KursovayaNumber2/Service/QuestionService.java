package pro.sky.KursovayaNumber2.Service;

import pro.sky.KursovayaNumber2.dto.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
