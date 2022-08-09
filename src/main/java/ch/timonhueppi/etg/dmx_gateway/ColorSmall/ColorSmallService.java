package ch.timonhueppi.etg.dmx_gateway.ColorSmall;

import ch.timonhueppi.etg.dmx_gateway.Helper;

public class ColorSmallService {

    public void setBrightness(byte brightness){
        handleSetter(brightness, -1);
    }

    public void setRed(byte red){
        handleSetter(red, 0);
    }

    public void setGreen(byte green){
        handleSetter(green, 1);
    }

    public void setBlue(byte blue){
        handleSetter(blue, 2);
    }

    public void setWhite(byte white){
        handleSetter(white, 3);
    }

    private void handleSetter(byte value, int offset){
        int numberOfFixtures = Integer.valueOf(Helper.getProperty("colorsmall.number"));
        int startChannel = Integer.valueOf(Helper.getProperty("colorsmall.channel.start"));
        byte[] dmxData = Helper.dmxData;
        for (int i = 0; i < numberOfFixtures; i++){
            dmxData[(startChannel + i*6) + offset] = value;
        }
        Helper.sendDMX(dmxData);
    }
}
