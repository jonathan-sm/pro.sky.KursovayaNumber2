package pro.sky.KursovayaNumber2.Service;

import org.junit.jupiter.api.Test;
import pro.sky.KursovayaNumber2.dto.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class JavaQuestionServiceTest {
    JavaQuestionService undetTest = new JavaQuestionService();
    Question question = new Question("q1", "Q2" + "Q3");
    Question question2 = new Question("Q4", "Q5" + "Q6");
    Collection<Question> allQuestion = new HashSet<>(List.of(question, question2));

    @Test
     void add_checkAdditionalAnQuestion_returnedQuestion() {
        Question result = undetTest.add(question);
        assertEquals(question, result);
    }

        @Test
        void remove_checkRemovedQuestion_questionRemovedAndReturned () {
            Question result = undetTest.remove(question);
            assertEquals(question, result);
        }

        @Test
        void getAll_checkGetAllInCollection_returnedGetAll () {
            undetTest.add(question);
            undetTest.add(question2);
            Collection<Question> result = undetTest.getAll();
            assertTrue(result.containsAll(allQuestion));
        }
    }
