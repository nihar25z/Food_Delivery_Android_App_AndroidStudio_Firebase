package com.example.clitz_arestaurantapp.Listener;





import com.example.clitz_arestaurantapp.Model.DrinkModel;

import java.util.List;

public interface IDrinkLoadListener {

    void onDrinkLoadSuccess(List<DrinkModel> drinkModelList);
    void onDrinkLoadFailed(String message);
}
