package ch.timonhueppi.etg.dmx_gateway;

import ch.bildspur.artnet.ArtNetClient;

import java.io.InputStream;
import java.util.Properties;

public class ArtnetHandler {

    public static byte[] dmxData = new byte[512];

    public static void sendDMX(int channel, byte value){
        ArtNetClient artnet = new ArtNetClient();
        artnet.start();

        // set data
        dmxData[channel - 1] = value;

        // send data to localhost
        artnet.unicastDmx(getIP(), 0, 0, dmxData);

        artnet.stop();
    }

    private static String getIP(){
        try (InputStream input = ArtnetHandler.class.getClassLoader().getResourceAsStream("application.properties")) {

            Properties prop = new Properties();

            if (input == null) {
                throw null;
            }

            //load a properties file from class path, inside static method
            prop.load(input);

            //get the property value and print it out
            return prop.getProperty("artnet_ip");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "172.0.0.1";
    }

}
