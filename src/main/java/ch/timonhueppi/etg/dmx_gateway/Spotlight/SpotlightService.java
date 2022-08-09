package ch.timonhueppi.etg.dmx_gateway.Spotlight;

import ch.timonhueppi.etg.dmx_gateway.Helper;

public class SpotlightService {

    public void setBrightness(byte brightness){
        int numberOfFixtures = Integer.valueOf(Helper.getProperty("spotlight.number.left")) + Integer.valueOf(Helper.getProperty("spotlight.number.right"));
        int startChannel = Integer.valueOf(Helper.getProperty("spotlight.channel.start"));
        byte[] dmxData = Helper.dmxData;
        for (int i = 0; i < numberOfFixtures; i++){
            dmxData[(startChannel + i*2) - 1] = brightness;
        }
        Helper.sendDMX(dmxData);
    }

    public void setTemperature(byte temp){
        temp = temp < 6 ? 6 : temp;
        int numberOfFixtures = Integer.valueOf(Helper.getProperty("spotlight.number.left")) + Integer.valueOf(Helper.getProperty("spotlight.number.right"));
        int startChannel = Integer.valueOf(Helper.getProperty("spotlight.channel.start"));
        byte[] dmxData = Helper.dmxData;
        for (int i = 0; i < numberOfFixtures; i++){
            dmxData[startChannel + i*2] = temp;
        }
        Helper.sendDMX(dmxData);
    }

}
