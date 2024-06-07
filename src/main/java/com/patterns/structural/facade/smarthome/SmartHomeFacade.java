package com.patterns.structural.facade.smarthome;


class Lighting {
    public void turnOn() {
        System.out.println("Lighting is turned on");
    }

    public void turnOff() {
        System.out.println("Lighting is turned off");
    }
}


class AirConditioning {
    public void setTemperature(int t) {
        System.out.println("Temperature set to " + t + " degrees");
    }
}


class MusicSystem {
    public void play() {
        System.out.println("Music system is turned on");
    }

    public void stop() {
        System.out.println("Music system is turned off");
    }
}


class SmartHomeFacade {

    private Lighting lighting;
    private AirConditioning airConditioning;
    private MusicSystem musicSystem;


    public SmartHomeFacade(Lighting lighting, AirConditioning airConditioning, MusicSystem musicSystem) {
        this.lighting = lighting;
        this.airConditioning = airConditioning;
        this.musicSystem = musicSystem;
    }

    public void startEveningRoutine() {
        lighting.turnOn();
        airConditioning.setTemperature(25);
        musicSystem.play();
    }

    public void offEveningRoutine() {
        lighting.turnOff();
        airConditioning.setTemperature(0);
        musicSystem.stop();
    }

    public static void main(String[] args) {
        Lighting lighting = new Lighting();
        AirConditioning airConditioning = new AirConditioning();
        MusicSystem musicSystem = new MusicSystem();

        SmartHomeFacade smartHomeFacade = new SmartHomeFacade(lighting, airConditioning, musicSystem);
        smartHomeFacade.startEveningRoutine();
        smartHomeFacade.offEveningRoutine();
    }
}
