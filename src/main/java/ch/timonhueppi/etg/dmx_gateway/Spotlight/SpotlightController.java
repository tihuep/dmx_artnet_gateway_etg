package ch.timonhueppi.etg.dmx_gateway.Spotlight;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spotlight")
public class SpotlightController {

    SpotlightService spotlightService = new SpotlightService();


    private byte brightness = 0;

    @GetMapping("/brightness")
    public byte getBrightness() {
        return brightness;
    }

    @PostMapping("/brightness/{brightness}")
    public void setBrightness(@PathVariable byte brightness) {
        this.brightness = brightness;
        spotlightService.setBrightness(brightness);
    }


    private byte temperature = 0;

    @GetMapping("/temp")
    public byte getTemperature() {
        return brightness;
    }

    @PostMapping("/temp/{temp}")
    public void setTemperature(@PathVariable byte temp) {
        this.temperature = temp;
        spotlightService.setTemperature(temp);
    }



}
