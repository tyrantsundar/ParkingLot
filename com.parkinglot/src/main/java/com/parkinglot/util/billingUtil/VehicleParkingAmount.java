package com.parkinglot.util.billingUtil;

import com.parkinglot.entities.VehicleType;

public class VehicleParkingAmount {
    public static double getParkingAmount(VehicleType vehicleType){
        switch (vehicleType){
            case TWO_WHEELER -> {
                return 20;
            }
            case THREE_WHEELER -> {
                return 30;
            }
            case FOUR_WHEELER_SEMI -> {
                return 40;
            }
            case FOUR_WHEELER_BIG -> {
                return 50;
            }
        }
        return 0;
    }
}
