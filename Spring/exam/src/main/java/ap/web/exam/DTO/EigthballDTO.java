package ap.web.exam.DTO;

import org.springframework.stereotype.Component;

@Component
public class EigthballDTO {
    private String question;
    private String answer;

    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public String getAnswer() {
        if (answer == null){
            setAnswer("Er is geen antwoord");
        }
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
