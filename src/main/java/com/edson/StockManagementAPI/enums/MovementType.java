package com.edson.StockManagementAPI.enums;

public enum MovementType {
 IN("INCOMING"),OUT("OUTGOING");

  private final String displayName;

    MovementType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static MovementType fromDisplayName(String displayName) {
        for (MovementType type : MovementType.values()) {
            if (type.getDisplayName().equalsIgnoreCase(displayName)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid MovementType: " + displayName);
    }
}