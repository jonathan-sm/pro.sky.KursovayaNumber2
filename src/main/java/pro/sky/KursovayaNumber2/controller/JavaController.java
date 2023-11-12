package pro.sky.KursovayaNumber2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.KursovayaNumber2.Service.QuestionService;
import pro.sky.KursovayaNumber2.dto.Question;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaController {
    private final QuestionService questionService;

    public JavaController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {

        return questionService.add(question, answer);
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam("question") String question,
                                   @RequestParam("answer") String answer) {
        Question getQuestion = new Question(question, answer);

        return questionService.remove(getQuestion);
    }

    @GetMapping()
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }
}

