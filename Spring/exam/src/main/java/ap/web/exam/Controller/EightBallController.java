package ap.web.exam.Controller;

import ap.web.exam.DTO.EightballDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@ComponentScan({"eightball.mvc.service", "eightball.mvc.model"})
class EightballController {

    @Autowired
    private EightballDTO ballDTO;

    @GetMapping(value="/eightball/Question")
    public String questionForm(Model model) {
        ArrayList<String> questions = new ArrayList<String>();
        for(String a : this.service.keys("Question:*")) {
            questions.add(this.service.getKey(a));
        }
        model.addAttribute("Question",ballDTO);
        return "Question";
    }

    @GetMapping(value="/eightball/Answer/{questionId}")
    public String answerSubmit(@ModelAttribute EightballDTO ballDTO, @PathVariable("questionId") int questionid, Model model) {
        ArrayList<String> Answers = new ArrayList<String>();
        for(String a : this.service.keys("answer:" + questionid + ":*")) {
            Answers.add(this.service.getKey(a));
        }
        String author = this.service.getKey(this.service.keys("author:*:" + questionid).iterator().next());

        model.addAttribute("Questions", questions);
        model.addAttribute("Answer", Answers);
        return "Answer";
    }
}