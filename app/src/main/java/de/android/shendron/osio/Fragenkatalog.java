package de.android.shendron.osio;

import java.util.ArrayList;

/**
 * Created by Eddy on 20.02.2017.
 */

public class Fragenkatalog {

   /* private String mFragenkatalog [] = {
            "Wie heißt der Onkel von Tick,Trick und Track?","Wie heißt der Hund von Mickey Mouse?","Wer schießt schneller als sein Schatten?","Wie heißt der beste Freund von Spongebob Schwammkopf"
    };

    private String mChoices [][] = {
            {"Donald","Dagobert","Mickey Mouse"},
            {"Goofy","Donald","Pluto"},
            {"Die Daltons","Lucky Luke","Spongebob"},
            {"Thaddeus","Patrick Star","Mr. Krebs"}
    };

    private String mCorrectAnswer [] = {"Donald" , "Pluto" , "Lucky Luke" , "Patrick Star"};


    public String getQuestion (int a){
        String question = mFragenkatalog[a];
        return question;
    };
    public String getChoice1 (int a){
        String choice0 = mChoices[a][0];
        return choice0;
    };
    public String getChoice2 (int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    };
    public String getChoice3 (int a){
        String choice2 = mChoices[a][2];
        return choice2;
    };
    public String getCorrectAnswer (int a){
        String answer = mCorrectAnswer[a];
        return answer;
    };*/

    private ArrayList<QuizKarte> fragenKatalog = new ArrayList<>();

    public Fragenkatalog fuegeNeueKarteHinzu(QuizKarte quizKarte) {

        this.fragenKatalog.add(quizKarte);

        return this;
    }

    public String getQuestion(int a) {
        String question = fragenKatalog.get(a).getFrage();
        return question;
    }

    public String getChoice1(int a) {
        String choice0 = fragenKatalog.get(a).getAntwort()[0].getmAntwort();
        return choice0;

    }

    public String getChoice2(int a) {
        String choice1 = fragenKatalog.get(a).getAntwort()[1].getmAntwort();
        return choice1;

    }

    public String getChoice3(int a) {
        String choice2 = fragenKatalog.get(a).getAntwort()[2].getmAntwort();
        return choice2;

    }

    public String getCorrectAnswer (int a){
        QuizKarte quizKarte = fragenKatalog.get(a);
        Antwort[] sucheRichtigeAntwort = quizKarte.getAntwort();
        for(int i = 0; i < sucheRichtigeAntwort.length; i++){
            if(sucheRichtigeAntwort[i].isrAntwort()){
                return sucheRichtigeAntwort[i].getmAntwort();

            }
        }

        return null;
    }



}
