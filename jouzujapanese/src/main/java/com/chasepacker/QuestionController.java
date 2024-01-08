package com.chasepacker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.HashMap;


@RestController
public class QuestionController {

    /**
     * API endpoint for React application to get a verb conjugation question
     * 
     * @param options All boolean : {includeRuVerbs, includeUVerbs, includeIrregularVerbs, 
     * includeCasualForm, includeFormalForm, includePresentTense, includePastTense, 
     * includeAffirmativeForm, includeNegativeForm, includePotentialForm, includePassiveForm, 
     * includeCausativeForm, includeVolitionalForm, includeTeForm}
     * @return
     */
    @GetMapping("/api/verbConjugation")
    public Map<String, String> getVerbConjugation(@RequestParam boolean[] options) {
        
        String[] result = VerbConjugationPractice.generateQuestion(options);

        Map<String, String> response = new HashMap<>();

        response.put("answer", result[0]);
        response.put("hiragana", result[1]);
        response.put("conjugation", result[2]);

        return response;
        
    }

    /**
     * API endpoint for React application to get an adjective conjugation question
     * 
     * @param options All boolean : {includeIAdjectives, includeNaAdjectives, includeCasual, 
     * includeFormal, includePresent, includePast, includeAffirmative, includeNegative}
     * @return
     */
    @GetMapping("/api/adjectiveConjugation")
    public Map<String, String> getAdjectiveConjugation(@RequestParam boolean[] options) {
        

        String[] result = AdjectiveConjugationPractice.generateQuestion(options);

        Map<String, String> response = new HashMap<>();

        response.put("answer", result[0]);
        response.put("hiragana", result[1]);
        response.put("conjugation", result[2]);

        return response;
        
    }

    /**
     * API endpoint for React application to get a hiragana question
     * 
     * @param options All boolean : {kanaToRomanji, romanjiToKana, dakuten, extendedKana}
     * @return
     */
    @GetMapping("/api/hiragana")
    public Map<String, String> getHiragana(@RequestParam boolean[] options) {
        

        String[] result = HiraganaPractice.generateQuestion(options);

        Map<String, String> response = new HashMap<>();

        response.put("question", result[0]);
        response.put("answer", result[1]);
        response.put("type", result[2]);

        return response;
        
    }

    /**
     * API endpoint for React application to get a katakana question
     * 
     * @param options All boolean : {kanaToRomanji, romanjiToKana, dakuten, extendedKana}
     * @return
     */
    @GetMapping("/api/katakana")
    public Map<String, String> getKatakana(@RequestParam boolean[] options) {
        

        String[] result = KatakanaPractice.generateQuestion(options);

        Map<String, String> response = new HashMap<>();

        response.put("question", result[0]);
        response.put("answer", result[1]);
        response.put("type", result[2]);

        return response;
        
    }


    
}
