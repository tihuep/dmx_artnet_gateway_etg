package ch.timonhueppi.etg.dmx_gateway.Wash;

import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/wash")
public class WashController {

    WashService washService = new WashService();


    private byte cw = 0;

    @GetMapping("/cw")
    public byte getCW() {
        return cw;
    }

    @PostMapping("/cw/{cw}")
    public void setCW(@PathVariable byte cw){
        this.cw = cw;
        washService.setCW(cw);
    }

    private byte ww = 0;

    @GetMapping("/ww")
    public byte getWW() {
        return ww;
    }

    @PostMapping("/ww/{ww}")
    public void setWW(@PathVariable byte ww){
        this.ww = ww;
        washService.setWW(ww);
    }

}
