package ch.timonhueppi.etg.dmx_gateway.Direct;

import ch.timonhueppi.etg.dmx_gateway.Helper;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/dmx")
public class DirectController {

    @GetMapping("/")
    public String getDMX() {
        Gson gson = new Gson();
        String output = gson.toJson(Helper.dmxDataInt);
        return output;
    }

    @PostMapping("/")
    public boolean setDMX(@RequestBody String dmxDataStr) {
        Gson gson = new Gson();
        int[] dmxData = gson.fromJson(dmxDataStr, int[].class);
        Helper.sendDMX(dmxData);
        return true;
    }

    @PutMapping("/")
    public boolean setDMXValue(@RequestBody String dmxDataStr){
        int[] dmxData = new int[512];

        for (int i = 0; i < 512; i++){
            dmxData[i] = Helper.dmxDataInt[i];
        }

        Gson gson = new Gson();
        Map<String, Double> map = gson.fromJson(dmxDataStr, Map.class);

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            int value = entry.getValue().intValue();
            dmxData[Integer.parseInt(entry.getKey()) - 1] = value;
        }

        Helper.sendDMX(dmxData);
        return true;
    }
}
