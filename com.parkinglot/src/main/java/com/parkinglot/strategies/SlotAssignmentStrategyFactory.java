package com.parkinglot.strategies;

import com.parkinglot.entities.SlotAssignmentStrategyType;

public class SlotAssignmentStrategyFactory {

    public static SlotAssignmentStrategy getStrategy(SlotAssignmentStrategyType type){
        switch(type){
            case RANDOM -> {
                return new RandomSlotAssignmentStrategy();
            }

        }
        return null;
    }
}
