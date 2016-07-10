package com.example.rajan.e_commarce.vertical;

import com.bignerdranch.expandablerecyclerview.Model.ParentListItem;

import java.util.List;

public class Recipe implements ParentListItem {

    private String mName;
    private List<String> mIngredients;

    public Recipe(String name, List<String> ingredients) {
        mName = name;
        mIngredients = ingredients;
    }

    public String getName() {
        return mName;
    }

    @Override
    public List<?> getChildItemList() {
        return mIngredients;
    }

    @Override
    public boolean isInitiallyExpanded() {
        return false;
    }
}
