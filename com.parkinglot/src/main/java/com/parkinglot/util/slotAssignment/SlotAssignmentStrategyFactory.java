package com.parkinglot.util.slotAssignment;

import com.parkinglot.entities.SlotAssignmentStrategyType;

public class SlotAssignmentStrategyFactory {
    public static SlotAssignmentStrategy getSlotAssignmentStrategy(SlotAssignmentStrategyType type){
        switch (type){
            case RANDOM -> {
                return new RandomSlotAssignmentStrategy();
            }
            case NEAREST -> {
                return new NearestSlotAssignmentStrategy();
            }
            case FARTHEST -> {
                return new FarthestSlotAssignmentStrategy();
            }
        }
        return null;
    }
}
