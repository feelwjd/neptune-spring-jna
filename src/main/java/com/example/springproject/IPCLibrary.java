package com.example.springproject;

import com.sun.jna.*;

public interface IPCLibrary extends Library {
    IPCLibrary INSTANCE = (IPCLibrary)
            Native.loadLibrary("c",IPCLibrary.class);

}
