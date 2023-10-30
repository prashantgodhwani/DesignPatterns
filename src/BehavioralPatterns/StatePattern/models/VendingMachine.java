package BehavioralPatterns.StatePattern.models;

import BehavioralPatterns.StatePattern.state.State;
import BehavioralPatterns.StatePattern.state.impl.IdleState;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private Inventory inventory;

    private State vendingMachineState;

    private List<Money> moneyList;

    public VendingMachine() {
        this.inventory = new Inventory(16);
        this.vendingMachineState = new IdleState();
        this.moneyList = new ArrayList<>();
    }

    public State getVendingMachineState() {
        return vendingMachineState;
    }

    public void setVendingMachineState(State vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

}
