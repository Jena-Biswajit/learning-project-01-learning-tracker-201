package com.VendingMachine;

import com.example.statedesignpattern.DispensingState;
import com.example.statedesignpattern.HasCoinState;
import com.example.statedesignpattern.IdleState;
import com.example.statedesignpattern.VendingMachine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VendingMachineTest {

    private VendingMachine machine;

    @BeforeEach
    void setUp() {
        machine = new VendingMachine();
    }

    @Test
    void testIdleState() {
        machine.setState(new IdleState());
        assertEquals("Machine is idle. Insert a coin.", machine.performAction());
    }

    @Test
    void testHasCoinState() {
        machine.setState(new HasCoinState());
        assertEquals("Coin inserted. Please make a selection.", machine.performAction());
    }

    @Test
    void testDispensingState() {
        machine.setState(new DispensingState());
        assertEquals("Dispensing item... Please wait.", machine.performAction());
    }
}