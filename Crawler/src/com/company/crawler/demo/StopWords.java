package com.company.crawler.demo;

import java.util.HashSet;

/**
 * Created by bingzhang on 7/2/17.
 */
public class StopWords {

    private String[] stopWordsArray = new String[]{"a", "an", "and", "are", "as", "at", "be", "but", "by", "for", "if", "in", "into", "is", "it", "no", "not", "of", "on", "or", "such", "that", "the", "their", "then", "there", "these", "they", "this", "to", "was", "will", "with"};
    private HashSet<String> stopWords = new HashSet<>();

    public StopWords(){
        for (int i = 0; i < stopWordsArray.length; i++){
            stopWords.add(stopWordsArray[i]);
        }
    }


    public boolean containsWord(String word){
        return stopWords.contains(word);
    }
}