package com.example.springproject;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.Pointer;

public interface CLibrary extends Library {
    CLibrary INSTANCE = Native.load(Platform.isLinux()?"libc" : "so", CLibrary.class);

    String shmat(int shmid, Pointer shmaddr, int shmflg);
}
