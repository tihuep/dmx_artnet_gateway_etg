/*package ch.timonhueppi.etg.dmx_gateway.Wash;

import ch.timonhueppi.etg.dmx_gateway.Helper;

public class WashService {

    public void setCW(byte cw){
        handleSetter(cw, -1);
    }

    public void setWW(byte ww){
        handleSetter(ww, 0);
    }

    private void handleSetter(byte value, int offset){
        int numberOfFixtures = Integer.valueOf(Helper.getProperty("washl.left.number")) + Integer.valueOf(Helper.getProperty("wash.number.right"));
        int startChannel = Integer.valueOf(Helper.getProperty("wash.channel.start"));
        byte[] dmxData = Helper.dmxData;
        for (int i = 0; i < numberOfFixtures; i++){
            dmxData[(startChannel + i*2) + offset] = value;
        }
        Helper.sendDMX(dmxData);
    }
}
*/