/*
 * Copyright (c) 2018. This code has been developed by Fabio Ciravegna, The University of Sheffield. All rights reserved. No part of this code can be used without the explicit written permission by the author
 */

package oak.shef.ac.uk.myapplication;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.Random;

class MyRepository extends ViewModel {
    MutableLiveData<String> newString;
    public MyRepository(Application application) {
        newString= new MutableLiveData();
    }

    /**
     * it returns the value of the live data
     * @return
     */
    public LiveData<String> getStringToDisplay() {
        if (newString.getValue()=="")
            generateNewNumber();
        return newString;
    }


    /**
     * called by the UI to request the generation of a new random number
     */
    public void generateNewNumber() {
        Random r = new Random();
        int i1 = r.nextInt(10000 - 1) + 1;
        String nv= i1+"";
        newString.setValue(nv);
    }
}
