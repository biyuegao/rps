package com.xp.smarthome;

public class Bulb9000 {
    static boolean turnOn() {
        return Swithch9000.isOn(true);
    }
    static boolean turnOff() {
        return Swithch9000.isOn(false);
    }
}
