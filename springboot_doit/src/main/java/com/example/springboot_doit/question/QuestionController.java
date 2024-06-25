package com.example.springboot_doit.question;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class QuestionController {
    private QuestionRepository questionRepository;

    @GetMapping("/question/list")
//    @ResponseBody
    public String list(Model model) {
        List<Question> questionData = questionRepository.findAll();
        model.addAttribute("questionList", questionData);
        return "question_list";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/question/list";
    }

}
