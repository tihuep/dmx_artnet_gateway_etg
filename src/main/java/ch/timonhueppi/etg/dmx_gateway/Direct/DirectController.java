package ch.timonhueppi.etg.dmx_gateway.Direct;

import ch.timonhueppi.etg.dmx_gateway.Helper;
import com.google.gson.Gson;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/dmx")
public class DirectController {

    @GetMapping("/")
    public String getDMX() {
        Gson gson = new Gson();
        return gson.toJson(Helper.dmxData);
    }

    @PostMapping("/")
    public boolean setDMX(@RequestBody String dmxDataStr) {
        Gson gson = new Gson();
        byte[] dmxData = gson.fromJson(dmxDataStr, byte[].class);
        Helper.sendDMX(dmxData);
        return true;
    }
}
