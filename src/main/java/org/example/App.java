package org.example;

import org.example.job.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App
{
    public static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        Job[] jobTitle = {
          new Doctor(),
          new Cook(),
          new Engineer(),
          new Loader()
        };

        for (int i = 0; i < jobTitle.length; i++) {
            logger.info(jobTitle[i].toString());
        }
    }
}