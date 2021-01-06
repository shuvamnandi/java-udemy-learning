package com.shuvamnandi.livelocks;

public class SharedResource {
    private PoliteWorker owner;

    public SharedResource(PoliteWorker owner) {
        this.owner = owner;
    }

    public PoliteWorker getOwner() {
        return owner;
    }

    public void setOwner(PoliteWorker owner) {
        this.owner = owner;
    }
}
