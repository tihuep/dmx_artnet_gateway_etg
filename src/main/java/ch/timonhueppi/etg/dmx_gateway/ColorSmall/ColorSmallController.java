package ch.timonhueppi.etg.dmx_gateway.ColorSmall;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/colorsmall")
public class ColorSmallController {

    ColorSmallService colorSmallService = new ColorSmallService();


    private byte brightness = 0;

    @GetMapping("/brightness")
    public byte getBrightness() {
        return brightness;
    }

    @PostMapping("/brightness/{brightness}")
    public void setBrightness(@PathVariable byte brightness){
        this.brightness = brightness;
        colorSmallService.setBrightness(brightness);
    }

    private byte red = 0;

    @GetMapping("/brightness")
    public byte getRed() {
        return red;
    }

    @PostMapping("/red/{red}")
    public void setRed(@PathVariable byte red){
        this.red = red;
        colorSmallService.setRed(red);
    }

    private byte green = 0;

    @GetMapping("/green")
    public byte getGreen() {
        return green;
    }

    @PostMapping("/green/{green}")
    public void setGreen(@PathVariable byte green){
        this.green = green;
        colorSmallService.setGreen(green);
    }

    private byte blue = 0;

    @GetMapping("/blue")
    public byte getBlue() {
        return blue;
    }

    @PostMapping("/blue/{blue}")
    public void setBlue(@PathVariable byte blue){
        this.blue = blue;
        colorSmallService.setBlue(blue);
    }

    private byte white = 0;

    @GetMapping("/white")
    public byte getWhite() {
        return white;
    }

    @PostMapping("/white/{white}")
    public void setWhite(@PathVariable byte white){
        this.white = white;
        colorSmallService.setWhite(white);
    }

}
