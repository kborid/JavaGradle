package com.kborid.jav.entity;

import java.util.Comparator;

public class Pizza implements Comparable<Pizza>, Comparator<Pizza> {

    private PizzaStatus status;

    public void setStatus(PizzaStatus status) {
        this.status = status;
    }

    public PizzaStatus getStatus() {
        return status;
    }

    @Override
    public int compareTo(Pizza o) {
        return 0;
    }

    @Override
    public int compare(Pizza o1, Pizza o2) {
        return 0;
    }

    public enum PizzaStatus {
        ORDERED(5) {
            @Override
            public boolean isOrdered() {
                return true;
            }
        },
        READY(2) {
            @Override
            public boolean isReady() {
                return true;
            }
        },
        DELIVERED(0) {
            @Override
            public boolean isDelivered() {
                return true;
            }
        };

        private int timeToDelivery;

        public boolean isOrdered() {
            return false;
        }

        public boolean isReady() {
            return false;
        }

        public boolean isDelivered() {
            return false;
        }

        public int getTimeToDelivery() {
            return timeToDelivery;
        }

        PizzaStatus(int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }
    }

    public boolean isDeliverable() {
        return this.status.isReady();
    }

    public void printTimeToDeliver() {
        System.out.println("Time to delivery is " +
                this.status.getTimeToDelivery());
    }

    // Methods that set and get the status variable.
}