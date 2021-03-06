package com.example.springproject.Controller;
import com.example.springproject.Library.CMath;
import com.example.springproject.Library.IPCLibrary;
import com.example.springproject.Model.CStuc;
import com.sun.jna.*;
import com.sun.jna.ptr.IntByReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RestController
@Slf4j
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping("/")
    public List test() {
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
        logger.info("step 1 : shmget success");
        Pointer shared_memory = ipc.shmat(shmid,Pointer.NULL,IPCLibrary.IPC_CREAT);
        IntByReference minus = new IntByReference(-1);
        if(shared_memory==minus.getPointer()){
            logger.info("shmat attach is failed");
        }
        logger.info("step 2 : shmat success");

        CStuc stuc = new CStuc();
        logger.info("step 3 : create structure");

        CStuc.ByValue value = ipc.getStuc();
        logger.info(String.valueOf(value));
        //logger.info("step 4 : shared_memory access");
        //logger.info(String.valueOf(stuc));
        return (List) value;
    }

}
