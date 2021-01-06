package com.shuvamnandi.livelocks;

public class PoliteWorker {
    private String name;
    private boolean active;

    public PoliteWorker(String name, boolean active) {
        this.name = name;
        this.active = active;
    }

    public synchronized void work(SharedResource sharedResource, PoliteWorker otherWorker) {
        while (active) {
            if (sharedResource.getOwner() != this) {
                try {
                    wait(10);
                } catch (InterruptedException e) {

                }
                continue;
            }
            if (otherWorker.isActive()) {
                System.out.println(getName() + " : gives the resource to the worker " + otherWorker.getName() + ". The resource is currently owned by: " + sharedResource.getOwner().getName());
                sharedResource.setOwner(otherWorker);
                continue;
            }

            System.out.println(getName() + " : working on the common resource");
            active = false;
            sharedResource.setOwner(otherWorker);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
