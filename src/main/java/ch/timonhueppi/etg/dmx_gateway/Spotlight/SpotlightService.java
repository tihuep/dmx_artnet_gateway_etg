package ch.timonhueppi.etg.dmx_gateway.Spotlight;

import ch.timonhueppi.etg.dmx_gateway.Helper;

public class SpotlightService {

    public void setBrightness(byte brightness){
        int numberOfChannels = (Integer.valueOf(Helper.getProperty("spotlight.number.left")) + Integer.valueOf(Helper.getProperty("spotlight.number.right"))) * 2;
        int startChannel = Integer.valueOf(Helper.getProperty("spotlight.channel.start"));
        byte[] dmxData = Helper.dmxData;
        for (int i = 0; i < numberOfChannels; i++){
            dmxData[startChannel + i*2] = brightness;
        }
        Helper.sendDMX(dmxData);
    }

}
