package com.example.achintya.martialartsclub;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;

import com.example.achintya.martialartsclub.Model.MartialArts;

/**
 * Created by Achintya on 7/7/2017.
 */

public class MartialArtButton extends AppCompatButton {

    private MartialArts martialArtsObject;

    public MartialArtButton(Context context, MartialArts martialArts){

        super(context);

        martialArtsObject = martialArts;

    }

    public String getMartialArtColor(){

        return martialArtsObject.getMartialArtColor();

    }

    public double getMatialArtPrice(){

        return martialArtsObject.getMartialArtPrice();

    }

}
