package com.example.dictionary.Models;

import java.util.List;

public class API_Response {
    String word = "";
    List<Phonetics> phonetics = null;
    List<Meanings> meanings = null;

    String origin = "";

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<Phonetics> getPhonetics() {
        return phonetics;
    }

    public void setPhonetics(List<Phonetics> phonetics) {
        this.phonetics = phonetics;
    }

    public List<Meanings> getMeanings() {
        return meanings;
    }

    public void setMeanings(List<Meanings> meanings) {
        this.meanings = meanings;
    }
}