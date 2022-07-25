package ch.timonhueppi.etg.dmx_gateway;

import ch.timonhueppi.etg.dmx_gateway.ArtnetHandler;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spotlight")
public class SpotlightController {

    private byte brightness = 0;

    @GetMapping("/brightness")
    public byte getBrightness() {
        return brightness;
    }

    @PostMapping("/brightness/{brightness}")
    public void setBrightness(@PathVariable byte brightness) {
        this.brightness = brightness;
        ArtnetHandler.sendDMX(1, brightness);
    }



}
