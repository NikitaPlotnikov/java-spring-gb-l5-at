package com.example.javaspringgbl5at.servise;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WordsCounterService {

    public Map<String,Long> countWordsInLine(String text){
        List<String> listOfWordsAfterST = new ArrayList<>();

        String lowerCaseInputText = text.toLowerCase();

        StringTokenizer st = new StringTokenizer(lowerCaseInputText, " \t\n\r\f,.?!:;|\"(){}[]*+\\@$%&#_=/'");

        while(st.hasMoreElements()){
            listOfWordsAfterST.add(st.nextToken());
        }

        HashMap<String, Long> hashMapOfWords = new HashMap<>();

        for(String i : listOfWordsAfterST) {
            Long j = hashMapOfWords.get(i);
            hashMapOfWords.put(i, (j == null) ? 1 : j + 1);
        }

        return hashMapOfWords;
    }
}
