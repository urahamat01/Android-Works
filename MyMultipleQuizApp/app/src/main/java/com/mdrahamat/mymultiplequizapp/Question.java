package com.mdrahamat.mymultiplequizapp;

public class Question {
    private String question;
    private String question1;
    private String question2;
    private String question3;
    private int answerNr;

    public Question() {
    }

    public Question(String question, String question1, String question2, String question3, int answerNr) {
        this.question = question;
        this.question1 = question1;
        this.question2 = question2;
        this.question3 = question3;
        this.answerNr = answerNr;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getQuestion2() {
        return question2;
    }

    public void setQuestion2(String question2) {
        this.question2 = question2;
    }

    public String getQuestion3() {
        return question3;
    }

    public void setQuestion3(String question3) {
        this.question3 = question3;
    }

    public int getAnswerNr() {
        return answerNr;
    }

    public void setAnswerNr(int answerNr) {
        this.answerNr = answerNr;
    }
}
