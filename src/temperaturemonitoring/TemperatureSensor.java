package temperaturemonitoring;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import networktools.Transceiver;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author krc
 */
public class TemperatureSensor extends Thread {

    private Node owner;
    private static final Logger logger = Logger.getLogger(TemperatureSensor.class.getName());
    private long period = 0;


    public TemperatureSensor(Node n) {
        this.owner = n;
    }

    @Override
    public void run() {
        try {
            this.owner.addMeasurement(new Temperature(period));
        } catch (RemoteException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        this.period++;
    }
}
