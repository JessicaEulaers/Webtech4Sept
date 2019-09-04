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
    public String getQuestionForm(Model model) {

        ArrayList<String> questions = new ArrayList<String>();
        for(String a : this.service.keys("question:*")) {
            authors.add(this.service.getKey(a));
        }
        model.addAttribute("question", questions);

        return "Question";
    }

    @PostMapping("/quote")
    public String addQuote(@RequestParam("question") String question
                           ) {


        if(this.service.exists("questioncount")) {
            this.service.incr("questioncount");
        }
        else {
            this.service.setKey("questioncount", "1");
        }

        this.service.setKey("question: " + question+ ":" + this.service.getKey("questioncount"), question);

        return "redirect:Answer/" + authorKey.split(":")[2];
    }

    @GetMapping(value="/eightball/Answer/{questionId}")
    public String answerSubmit(@ModelAttribute EightballDTO ballDTO, @PathVariable("questionId") int questionid, Model model) {
        ArrayList<String> Answers = new ArrayList<String>();
            Answers.add("It is certain.");
            Answers.add("Without a doubt");
        Answers.add("It is decidedly so.");
        Answers.add("Yes - definitely.");
        Answers.add("You may rely on it");
        Answers.add("As I see it, yes.");
        Answers.add("Most likely.");
        Answers.add("Outlook good.");
        Answers.add(" Yes.");
        Answers.add("Signs point to yes.");
        Answers.add("Reply hazy, try again.");
        Answers.add("Ask again later.");
        Answers.add("Better not tell you now.");
        Answers.add(" Cannot predict now.");
        Answers.add("Concentrate and ask again.");
        Answers.add("Don't count on it.");
        Answers.add("My reply is no.");
        Answers.add("My sources say no.");
        Answers.add("Outlook not so good.");
        Answers.add("Very doubtful.");


        for(String a : this.service.keys("answer:" + questionid + ":*")) {
            Answers.add(this.service.getKey(a));
        }
        String questions = this.service.getKey(this.service.keys("author:*:" + questionid).iterator().next());

        model.addAttribute("Questions", questions);
        model.addAttribute("Answer", Answers);
        return "Answer";
    }
}