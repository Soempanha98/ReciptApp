package com.nha.reciptapp.Listener;

import com.nha.reciptapp.Models.SimilarRecipeResponse;

import java.util.List;

public interface SimilarRecipesListener {
    void didFetch(List<SimilarRecipeResponse> responses, String message);
    void didError(String message);
}
