package com.example.springboot_doit.question;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/question")
@Controller
@AllArgsConstructor
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/list")
//    @ResponseBody
    public String list(Model model) {
        List<Question> questionData = questionService.getList();
        model.addAttribute("questionList", questionData);
        return "question_list";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/question/list";
    }

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Question questionData = questionService.getQuestion(id);
        model.addAttribute("questionList", questionData);
        return "question_detail";
    }

}
