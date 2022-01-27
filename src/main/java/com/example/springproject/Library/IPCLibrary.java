package com.example.springproject.Library;

import com.sun.jna.*;

public interface IPCLibrary extends Library {
    static int IPC_CREAT = 0666;

    Pointer shmat(int shmid, Pointer shmaddr, int shmflg);
    void shmctl(int shmid, int ipcRmid, shmid_ds buf);
    int shmget(int key,int size,int shmflg);
    int shmdt(Pointer shmaddr);

}
