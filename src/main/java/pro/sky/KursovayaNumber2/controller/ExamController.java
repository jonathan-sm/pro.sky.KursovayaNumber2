package pro.sky.KursovayaNumber2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.KursovayaNumber2.Service.ExaminerService;
import pro.sky.KursovayaNumber2.dto.Question;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController{
    private final ExaminerService examinerService;


    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable int amount) {
        return examinerService.getQuestions(amount);
    }
}

