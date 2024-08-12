package org.generalUtility;

import java.util.Random;

public class JavaUtility {

    public int getRandomNumber(){
       return new Random().nextInt(5000);
    }
}
