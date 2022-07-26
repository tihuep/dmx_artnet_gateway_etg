package ch.timonhueppi.etg.dmx_gateway.Spotlight;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spotlight")
public class SpotlightController {

    private byte brightness = 0;
    SpotlightService spotlightService = new SpotlightService();

    @GetMapping("/brightness")
    public byte getBrightness() {
        return brightness;
    }

    @PostMapping("/brightness/{brightness}")
    public void setBrightness(@PathVariable byte brightness) {
        this.brightness = brightness;
        spotlightService.setBrightness(brightness);
    }



}
