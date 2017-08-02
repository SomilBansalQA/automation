package com.coach.qa.automation.dsl.api;

import com.mashape.unirest.http.Unirest;

import com.qait.automation.DSL;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.coach.qa.automation.dsl.templates.Category;
import com.coach.qa.automation.dsl.templates.Product;

import com.mashape.unirest.http.exceptions.UnirestException;

/**
 *
 * @author Ramandeep <RamandeepsSingh@QAInfoTech.com>
 */
public class SearchSuggestion extends Resource{
    
    public SearchSuggestion(DSL session){
        super(session, "search_suggestion");
    }
    
    public List<String> suggestionsFor(String term) throws UnirestException{
        List<String> suggestions = new ArrayList();
        Map<String,String> params = new HashMap();
        params.put("q", term);
        JSONObject response = get(params);
        System.out.println(params);
        return suggestions;
    }
}
