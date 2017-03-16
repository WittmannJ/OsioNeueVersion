package de.android.shendron.osio;

/**
 * Created by jackl on 28.02.2017.
 */

public class QuizKarte {

    public static int ANZAHL_ANTWORTEN = 3;
    // wie heißt der bruder von mario
    private String frage;
    // Array von Fragen
    // a: Luigi, b: Bowser, c: Waluigi
    // Standard-groesse von Array ist 3
    private Antwort[] antwort;


    public String getFrage() {
        return frage;
    }

    public void setFrage(String frage) {
        this.frage = frage;
    }

    public Antwort[] getAntwort() {
        return antwort;
    }

    public void setAntwort(Antwort[] antwort) {
        this.antwort = antwort;
    }

    public QuizKarte (String frage, Antwort[] antwort){
        this.frage = frage;
        this.antwort = antwort;

        }
    }

