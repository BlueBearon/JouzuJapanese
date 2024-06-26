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
     * @param options
     * @return
     */
    @GetMapping("/api/verbConjugation")
    public Map<String, String> getVerbConjugation(@RequestParam Map<String, String> allParams) {

        System.out.println("Received request for verb conjugation question");
        try
        {
            boolean[] options = new boolean[15];

            options[0] = Boolean.parseBoolean(allParams.getOrDefault("includeRuVerbs", "true"));
            options[1] = Boolean.parseBoolean(allParams.getOrDefault("includeUVerbs", "true"));
            options[2] = Boolean.parseBoolean(allParams.getOrDefault("includeIrregularVerbs", "true"));
            options[3] = Boolean.parseBoolean(allParams.getOrDefault("includeCasualForm", "true"));
            options[4] = Boolean.parseBoolean(allParams.getOrDefault("includeFormalForm", "true"));
            options[5] = Boolean.parseBoolean(allParams.getOrDefault("includePresentTense", "true"));
            options[6] = Boolean.parseBoolean(allParams.getOrDefault("includePastTense", "true"));
            options[7] = Boolean.parseBoolean(allParams.getOrDefault("includeAffirmativeForm", "true"));
            options[8] = Boolean.parseBoolean(allParams.getOrDefault("includeNegativeForm", "true"));
            options[9] = Boolean.parseBoolean(allParams.getOrDefault("includeRegularForm", "true"));
            options[10] = Boolean.parseBoolean(allParams.getOrDefault("includePotentialForm", "true"));
            options[11] = Boolean.parseBoolean(allParams.getOrDefault("includePassiveForm", "true"));
            options[12] = Boolean.parseBoolean(allParams.getOrDefault("includeCausativeForm", "true"));
            options[13] = Boolean.parseBoolean(allParams.getOrDefault("includeVoliationalForm", "true"));
            options[14] = Boolean.parseBoolean(allParams.getOrDefault("includeTeForm", "true"));

            String[] result = VerbConjugationPractice.generateQuestion(options);

            Map<String, String> response = new HashMap<>();

            response.put("answer", result[0]);
            response.put("hiragana", result[1]);
            response.put("conjugation", result[2]);

            return response;
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("Invalid Parameters for Verb Conjugation");
        }
        
        
    }

    @GetMapping("/api/verbConjugation/checkString")
    public Map<String, String> getVerbConjugation(@RequestParam String str)
    {
        System.out.println(str);

        return getVerbConjugation();
    }

    /**
     * API endpoint for React application to get a verb conjugation question.
     * This endpoint is used when the frontend does not send any parameters.
     * @return
     */
    @GetMapping("/api/verbConjugation/optionsFailed")
    public Map<String, String> getVerbConjugation() {


        boolean[] options = {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};

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
    public Map<String, String> getAdjectiveConjugation(@RequestParam Map<String, String> allParams) {
        
        System.out.println("Received request for adjective conjugation question");

        try
        {
            boolean[] options = new boolean[8];

            options[0] = Boolean.parseBoolean(allParams.getOrDefault("includeIAdjectives", "true"));
            options[1] = Boolean.parseBoolean(allParams.getOrDefault("includeNaAdjectives", "true"));
            options[2] = Boolean.parseBoolean(allParams.getOrDefault("includeCasualForm", "true"));
            options[3] = Boolean.parseBoolean(allParams.getOrDefault("includeFormalForm", "true"));
            options[4] = Boolean.parseBoolean(allParams.getOrDefault("includePresentTense", "true"));
            options[5] = Boolean.parseBoolean(allParams.getOrDefault("includePastTense", "true"));
            options[6] = Boolean.parseBoolean(allParams.getOrDefault("includeAffirmativeForm", "true"));
            options[7] = Boolean.parseBoolean(allParams.getOrDefault("includeNegativeForm", "true"));

            
            String[] result = AdjectiveConjugationPractice.generateQuestion(options);

            Map<String, String> response = new HashMap<>();

            response.put("answer", result[0]);
            response.put("hiragana", result[1]);
            response.put("conjugation", result[2]);

            return response;
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("Invalid Parameters for Verb Conjugation");
        }
        
        
    }

    /**
     * API endpoint for React application to get an adjective conjugation question.
     * This endpoint is used when the frontend does not send any parameters.
     * @return
     */
    @GetMapping("/api/adjectiveConjugation/optionsFailed")
    public Map<String, String> getAdjectiveConjugation()
    {
        boolean[] options = {true, true, true, true, true, true, true, true};

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
     * @param options All boolean : {kanaToRomanji, romanjiToKana, dakuten, extended}
     * @return
     */
    @GetMapping("/api/hiragana")
    public Map<String, String> getHiragana(@RequestParam Map<String, String> allParams) {

        try
        {
            boolean[] options = new boolean[4];

            options[0] = Boolean.parseBoolean(allParams.getOrDefault("kanaToRomanji", "true"));
            options[1] = Boolean.parseBoolean(allParams.getOrDefault("romanjiToKana", "true"));
            options[2] = Boolean.parseBoolean(allParams.getOrDefault("dakutenhandakuten", "true"));
            options[3] = Boolean.parseBoolean(allParams.getOrDefault("extended", "true"));

            String[] result = HiraganaPractice.generateQuestion(options);

            Map<String, String> response = new HashMap<>();

            response.put("question", result[0]);
            response.put("answer", result[1]);
            response.put("type", result[2]);

        return response;
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("Invalid Parameters for Verb Conjugation");
        }
        
        
    }

    /**
     * API endpoint for React application to get a hiragana question.
     * This endpoint is used when the frontend does not send any parameters.
     * @return
     */
    @GetMapping("/api/hiragana/optionsFailed")
    public Map<String, String> getHiragana() {
        

        boolean[] options = {true, true, true, true};

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
     * @param options All boolean : {kanaToRomanji, romanjiToKana, dakuten, extended}
     * @return
     */
    @GetMapping("/api/katakana")
    public Map<String, String> getKatakana(@RequestParam Map<String, String> allParams) {
        

        boolean[] options = new boolean[4];

        options[0] = Boolean.parseBoolean(allParams.getOrDefault("kanaToRomanji", "true"));
        options[1] = Boolean.parseBoolean(allParams.getOrDefault("romanjiToKana", "true"));
        options[2] = Boolean.parseBoolean(allParams.getOrDefault("dakutenhandakuten", "true"));
        options[3] = Boolean.parseBoolean(allParams.getOrDefault("extended", "true"));

        String[] result = KatakanaPractice.generateQuestion(options);

        Map<String, String> response = new HashMap<>();

        response.put("question", result[0]);
        response.put("answer", result[1]);
        response.put("type", result[2]);

        return response; 
    }

    /**
     * API endpoint for React application to get a katakana question.
     * This endpoint is used when the frontend does not send any parameters.
     * @return
     */
    @GetMapping("/api/katakana/optionsFailed")
    public Map<String, String> getKatakana() {
        

        boolean[] options = {true, true, true, true};

        String[] result = KatakanaPractice.generateQuestion(options);

        Map<String, String> response = new HashMap<>();

        response.put("question", result[0]);
        response.put("answer", result[1]);
        response.put("type", result[2]);

        return response;
        
    }


    /**
     * API endpoint for React application to retrieve diary entry from SQL database
     * @return
     */
    @GetMapping("/api/retrieveDiary")
    public Map<String, String> retrieveDiary(@RequestParam Map<String, String> allParams) {
        
        String user = allParams.get("user");
        String date = allParams.get("date");

        String content = SQLInterface.retrieveDiaryEntry(user, date);

        Map<String, String> response = new HashMap<>();

        response.put("content", content);

        return response;
    }

    /**
     * API endpoint for React application to create a new diary entry in the SQL database
     * @return
     */
    @GetMapping("/api/createDiary")
    public void createDiary(@RequestParam Map<String, String> allParams) {
        
        String user = allParams.get("user");
        String date = allParams.get("date");
        String content = allParams.get("content");

        SQLInterface.createDiaryEntry(user, date, content);

        return;
    }

    /**
     * API endpoint for React application to update a diary entry in the SQL database
     * @return
     */
    @GetMapping("/api/updateDiary")
    public void updateDiary(@RequestParam Map<String, String> allParams) {

        String user = allParams.get("user");
        String date = allParams.get("date");
        String content = allParams.get("content");

        SQLInterface.updateDiaryEntry(user, date, content);

        return;
    }

    /**
     * API endpoint for React application to delete a diary entry in the SQL database 
     * @return
     */
    @GetMapping("/api/deleteDiary")
    public void deleteDiary(@RequestParam Map<String, String> allParams) {

        String user = allParams.get("user");
        String date = allParams.get("date");

        SQLInterface.deleteDiaryEntry(user, date);

        return;
    }

    /**
     * API endpoint for React application to retrieve a list of all dates with diary entries
     * for a requested user and month
     * @return
     */
    @GetMapping("/api/retrieveDiaryDates")
    public Map<String, String> retrieveDiaryDates(@RequestParam Map<String, String> allParams) {

        String user = allParams.get("user");
        String startDate = allParams.get("startDate");
        String endDate = allParams.get("endDate");

        String[] dates = SQLInterface.retrieveDiaryDates(user, startDate, endDate);

        Map<String, String> response = new HashMap<>();

        //React app will recieve a list of dates in one object
        response.put("dates", String.join(",", dates));
        
        return null;
    }



    @GetMapping("/api/test")
    public String test() {
        return "Hello World";
    }


    
}
