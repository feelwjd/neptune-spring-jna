package com.example.springproject;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Pointer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sun.jna.Native;
import com.sun.jna.Platform;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/")
    public double test() {
        String test = org.springframework.core.SpringVersion.getVersion();
        logger.info(test);
        CMath lib = Native.load(Platform.isWindows()?"msvcrt":"c",CMath.class);
        double result = lib.cosh(30);
        logger.info(Double.toString(result));
        long peer = 1111;
        Pointer s = new Pointer(peer);
        String p = CLibrary.INSTANCE.shmat(3836,s,0);
        return result;
    }

}
