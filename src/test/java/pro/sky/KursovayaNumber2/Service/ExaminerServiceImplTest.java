package pro.sky.KursovayaNumber2.Service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.KursovayaNumber2.dto.Question;
import pro.sky.KursovayaNumber2.exception.ExceededTheNumberOfQuestions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    JavaQuestionService javaQuestionService;
    @InjectMocks
    ExaminerServiceImpl underTest;
    Question question = new Question(
            "Q1", "Q2" + " Q3");
    Question question2 = new Question("Q4", "Q5" + "Q6 ");
    Collection<Question> allQuestion = new ArrayList<>(List.of(question, question2));



    @Test
    void getQuestionstheNumberOfDesiredQuestionsExceedsTheSizeOfTheQuestions_thrownMaxSizeAmountQuestion() {
        when(javaQuestionService.getAll()).thenReturn(Collections.emptySet());
        ExceededTheNumberOfQuestions exc = assertThrows(
                ExceededTheNumberOfQuestions.class,
                () -> underTest.getQuestions(3));
        assertEquals("У нас нет столько вопросов.", exc.getMessage());
    }
    @Test
    void getQuestions_checkQuestionGetQuestionsInCollection_returnedGetQuestions() {
        when(javaQuestionService.getRandomQuestion()).thenReturn(question,question2);
        when(javaQuestionService.getAll()).thenReturn(allQuestion);
        Collection<Question> result = underTest.getQuestions(2);
        assertEquals(2,result.size());
    }

}