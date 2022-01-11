package com.example.springproject;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;
import com.sun.jna.platform.linux.LibC;

public interface CLibrary extends Library {
    CLibrary INSTANCE = Native.load("c", CLibrary.class);
}
