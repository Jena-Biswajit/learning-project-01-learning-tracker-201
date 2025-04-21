package com.example.singleton.factorypattern;

import com.example.factorydesignpattern.Transport;
import com.example.factorydesignpattern.TransportFactory;
import org.junit.jupiter.api.Test;

public class FactoryPatternTest {

    @Test
    public void testTruckDelivery() {
        Transport transport = TransportFactory.getTransport("truck");
        transport.deliver();
    }

    @Test
    public void testShipDelivery() {
        Transport transport = TransportFactory.getTransport("ship");
        transport.deliver();
    }
}