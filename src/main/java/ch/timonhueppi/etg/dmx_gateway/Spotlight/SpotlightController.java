package ch.timonhueppi.etg.dmx_gateway.Spotlight;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spotlight")
public class SpotlightController {

    SpotlightService spotlightService = new SpotlightService();


    private byte brightness = 0;

    @CrossOrigin(origins = "*")
    @GetMapping("/brightness")
    public byte getBrightness() {
        return brightness;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/brightness/{brightness}")
    public void setBrightness(@PathVariable byte brightness) {
        this.brightness = brightness;
        spotlightService.setBrightness(brightness);
        System.out.println("brightness: " + brightness);
    }


    private byte temperature = 0;

    @CrossOrigin(origins = "*")
    @GetMapping("/temp")
    public byte getTemperature() {
        return temperature;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/temp/{temp}")
    public void setTemperature(@PathVariable byte temp) {
        this.temperature = temp;
        spotlightService.setTemperature(temp);
        System.out.println("temp: " + temp);
    }
}
