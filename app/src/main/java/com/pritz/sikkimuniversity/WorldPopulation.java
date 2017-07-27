package com.pritz.sikkimuniversity;

/**
 * Created by robin on 25/7/17.
 */


    public class WorldPopulation {
        private String number;
        private String name;

        public WorldPopulation(String name, String number) {
            this.name = name;
            this.number = number;
        }

        public String getName() {
            return this.name;
        }

        public String getNumber() {
            return this.number;
        }
    }

