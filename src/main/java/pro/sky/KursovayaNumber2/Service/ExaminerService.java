package pro.sky.KursovayaNumber2.Service;

import pro.sky.KursovayaNumber2.dto.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}

