package com.xp.smarthome;

import org.springframework.web.bind.annotation.GetMapping;

public class SmartHomeController {
    @GetMapping("/turnOn")
    public boolean turnOnBulb() {
        return Bulb9000.turnOn();
    }

    @GetMapping("/turnOff")
    public boolean turnOffBulb() {
        return Bulb9000.turnOff();
    }
}
