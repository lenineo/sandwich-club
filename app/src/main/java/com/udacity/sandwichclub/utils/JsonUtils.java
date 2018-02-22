package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        String mainName = null;
        List<String> alsoKnownAs = null;
        String placeOfOrigin = null;
        String description = null;
        String image = null;
        List<String> ingredients = null;
        Sandwich sandwich = null;

        if(json != null && json.length() > 0) {
            try {
                JSONObject jsonObject = new JSONObject(json);
                JSONObject name = jsonObject.getJSONObject("name");
                mainName = name.getString("mainName");

                JSONArray alsoKnownAsJson = name.getJSONArray("alsoKnownAs");
                alsoKnownAs = new ArrayList<>();
                for (int i = 0; i < alsoKnownAsJson.length(); i++) {
                    String alsoName = alsoKnownAsJson.getString(i);
                    alsoKnownAs.add(alsoName);
                }
//                alsoKnownAs = Arrays.asList(jsonObject.get("alsoKnownAs"));

                placeOfOrigin = jsonObject.getString("placeOfOrigin");
                description = jsonObject.getString("description");
                image = jsonObject.getString("image");

                JSONArray ingredientsJson = jsonObject.getJSONArray("ingredients");
                ingredients = new ArrayList<>();
                for (int i = 0; i < ingredientsJson.length(); i++) {
                    String ingredient = ingredientsJson.getString(i);
                    ingredients.add(ingredient);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            sandwich = new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
            return sandwich;

        }
        return null;
    }
}
