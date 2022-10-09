package ch.timonhueppi.etg.dmx_gateway;

import ch.bildspur.artnet.ArtNetClient;

import java.io.InputStream;
import java.util.Properties;

public class Helper {
/*
    public static byte[] dmxData = new byte[512];*/
    public static int[] dmxDataInt = new int[512];
/*
    public static void sendDMX(int channel, byte value){
        ArtNetClient artnet = new ArtNetClient();
        artnet.start();

        // set data
        dmxData[channel - 1] = value;

        // send data to localhost
        artnet.unicastDmx(getIP(), 0, 0, dmxData);

        artnet.stop();
    }

    public static void sendDMX(byte[] newDmxData){
        ArtNetClient artnet = new ArtNetClient();
        artnet.start();

        // set data
        dmxData = newDmxData;

        // send data to dmx controller
        artnet.unicastDmx(getIP(), 0, 0, dmxData);

        artnet.stop();
    }
*/
    public static void sendDMX(int[] newDmxData){
        ArtNetClient artnet = new ArtNetClient();
        artnet.start();

        // set data
        dmxDataInt = newDmxData;

        byte[] dmxDataByte = new byte[512];
        for (int i = 0; i < 512; i++){
            dmxDataByte[i] = (byte) newDmxData[i];
        }

        //dmxData = dmxDataByte;

        // send data to dmx controller
        artnet.unicastDmx("192.168.188.24", 0, 0, dmxDataByte);

        artnet.stop();
    }

    private static String getIP(){
        String ip = getProperty("artnet_ip");
        return ip != null ? ip : "127.0.0.1";
    }

    public static String getProperty(String key){
        try (InputStream input = Helper.class.getClassLoader().getResourceAsStream("application.properties")) {

            Properties prop = new Properties();

            if (input == null) {
                throw null;
            }

            //load a properties file from class path, inside static method
            prop.load(input);

            //get the property value and print it out
            return prop.getProperty(key);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

}
