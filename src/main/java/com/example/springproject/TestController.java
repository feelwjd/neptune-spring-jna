package com.example.springproject;
import com.sun.jna.*;
import com.sun.jna.ptr.IntByReference;
import lombok.EqualsAndHashCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/")
    public String test() {
        String test = org.springframework.core.SpringVersion.getVersion();
        logger.info(test);
        CMath lib = Native.load(Platform.isWindows()?"msvcrt":"c",CMath.class);
        double result = lib.cosh(30);
        logger.info(Double.toString(result));

        IPCLibrary ipc = Native.load("c",IPCLibrary.class);
        int shmid = ipc.shmget(3836,1440,IPCLibrary.IPC_CREAT);
        if (shmid == -1 ){
            logger.info("shmget failed");
        }

        Pointer shared_memory = ipc.shmat(shmid,Pointer.NULL,IPCLibrary.IPC_CREAT);
        IntByReference minus = new IntByReference(-1);
        if(shared_memory==minus.getPointer()){
            logger.info("shmat attach is failed");
        }
        CStuc stuc = new CStuc();
        String resume = stuc.getStr_ip();
        logger.info(resume);
        return resume;
    }

}
