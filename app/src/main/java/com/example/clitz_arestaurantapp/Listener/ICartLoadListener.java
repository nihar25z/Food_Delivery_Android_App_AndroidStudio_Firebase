package com.example.clitz_arestaurantapp.Listener;




import com.example.clitz_arestaurantapp.Model.CartModel;
import com.example.clitz_arestaurantapp.Model.DrinkModel;

import java.util.List;

public interface ICartLoadListener {

    void onDrinkLoadSuccess(List<DrinkModel> drinkModelList);

    void onDrinkLoadFailed(String message);

    void onCartLoadSuccess(List<CartModel> cartModelList);
    void onCartLoadFailed(String message);

}
