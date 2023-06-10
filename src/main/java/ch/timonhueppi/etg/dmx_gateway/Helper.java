package ch.timonhueppi.etg.dmx_gateway;

import ch.bildspur.artnet.ArtNetClient;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Helper {
/*
    public static byte[] dmxData = new byte[512];*/
    public static int[] dmxDataInt = new int[512];
    public static int[] dmxDataIntTemp = new int[512];
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

        int duration = 2000;
        String ip = "192.168.188.24";

        for (int j = 1; j <= (duration/50); j++){
            for (int k = 0; k < 512; k++) {
                float diff = (float) newDmxData[k] - dmxDataInt[k];
                float increment = diff / (duration/50) * j;


                dmxDataIntTemp[k] = dmxDataInt[k] + (int) increment;

            }

            byte[] dmxDataByte = new byte[512];
            for (int i = 0; i < 512; i++){
                dmxDataByte[i] = (byte) dmxDataIntTemp[i];
            }

            // send data to dmx controller
            artnet.unicastDmx(ip, 0, 0, dmxDataByte);

            try {
                TimeUnit.MILLISECONDS.sleep(50);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        // set data
        dmxDataInt = newDmxData;

        artnet.stop();
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
