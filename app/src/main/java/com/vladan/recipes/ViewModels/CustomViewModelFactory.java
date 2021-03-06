package com.vladan.recipes.ViewModels;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.vladan.recipes.Collections.CollectionViewModel;
import com.vladan.recipes.DetailRecipe.DetailRecipeViewModel;
import com.vladan.recipes.data.RecipeRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by Vladan on 10/8/2017.
 */

@Singleton
public class CustomViewModelFactory implements ViewModelProvider.Factory{

    private RecipeRepository repository;

    @Inject
    public CustomViewModelFactory(RecipeRepository repository) {
        this.repository = repository;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if(modelClass.isAssignableFrom(CollectionViewModel.class))
            return (T) new CollectionViewModel(repository);
        else if(modelClass.isAssignableFrom(DetailRecipeViewModel.class))
            return (T) new DetailRecipeViewModel(repository);
        else {
            throw new IllegalArgumentException("ViewModel not found");
        }
    }
}
