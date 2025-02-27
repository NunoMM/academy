package com.ctw.workstation.rack.entity;

import java.sql.Timestamp;

public record RackRequestDTO(String serialNumber, Status status, String defaultLocation, String assembledAt) {
}