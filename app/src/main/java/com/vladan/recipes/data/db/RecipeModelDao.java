package com.vladan.recipes.data.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;


@Dao
public interface RecipeModelDao {


    @Query("select * from RecipeModel where recipeId = :id")
    RecipeModel getRecipeModel(int id);

    //return new recipes
    @Query("select * from RecipeModel where recipeNew = 1")
    LiveData<List<RecipeModel>> getNewRecipes();

    //return fav recipes
    @Query("select * from RecipeModel where favouriteRecipes= 1")
    LiveData<List<RecipeModel>> getFavouriteRecipes();

    //return recipes by category
    @Query("select * from RecipeModel where recipeCategory =:category")
    LiveData<List<RecipeModel>> getRecipeByCategory(int category);

    //for trivial adding data
    @Insert (onConflict = REPLACE)
    void addList(List<RecipeModel> list);

    @Insert (onConflict = REPLACE)
    void addRecipe(RecipeModel recipeModel);

    @Update
    void updateRecipe(RecipeModel recipeModel);
}
