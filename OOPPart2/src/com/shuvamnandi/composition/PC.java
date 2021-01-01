package com.shuvamnandi.composition;

public class PC {
    private Case theCase;
    private Motherboard motherboard;
    private Monitor monitor;

    public PC(Case theCase, Motherboard motherboard, Monitor monitor) {
        this.theCase = theCase;
        this.motherboard = motherboard;
        this.monitor = monitor;
    }

    public void powerUp() {
        this.getCase().pressPowerButton();
        this.drawLogo();
    }

    private void drawLogo() {
        // Fancy graphics
        this.monitor.drawPixelAt(1200, 500, "yellow");
    }

    private Case getCase() {
        return this.theCase;
    }

    private Motherboard getMotherboard() {
        return this.motherboard;
    }

    private Monitor getMonitor() {
        return this.monitor;
    }
}
