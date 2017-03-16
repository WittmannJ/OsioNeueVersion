package de.android.shendron.osio;

/**
 * Created by jackl on 28.02.2017.
 */

public class Antwort {
    private String mAntwort;
    private boolean rAntwort;

    public Antwort(){
        mAntwort = null;
        rAntwort = false;
    }

    public Antwort(String mAntwort, boolean rAntwort){
        this.mAntwort = mAntwort;
        this.rAntwort = rAntwort;
    }

    public boolean isrAntwort() {
        return rAntwort;
    }

    public void setrAntwort(boolean rAntwort) {
        this.rAntwort = rAntwort;
    }

    public String getmAntwort() {

        return mAntwort;
    }

    public void setmAntwort(String mAntwort) {
        this.mAntwort = mAntwort;
    }

}
