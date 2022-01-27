package com.example.springproject.Model;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.List;

@Structure.FieldOrder({"str_ip","int_ip","int_id"})
public class CStuc extends Structure {
    public String str_ip;
    public int int_ip;
    public int int_id;


    @Override
    public void useMemory(Pointer m, int offset){
        super.useMemory(m, offset);
        super.read();
    }

    @Override
    public void useMemory(Pointer m){
        super.allocateMemory();
        super.useMemory(m);
        super.read();
    }

    @Override
    public Pointer getPointer() {
        return super.getPointer();
    }

    public String getStr_ip() {
        return str_ip;
    }

    public void setStr_ip(String str_ip) {
        this.str_ip = str_ip;
    }

    public int getInt_ip() {
        return int_ip;
    }

    public void setInt_ip(int int_ip) {
        this.int_ip = int_ip;
    }

    public int getInt_id() {
        return int_id;
    }

    public void setInt_id(int int_id) {
        this.int_id = int_id;
    }
}
