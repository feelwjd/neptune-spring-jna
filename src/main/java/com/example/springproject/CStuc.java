package com.example.springproject;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;
@Structure.FieldOrder({"str_ip","int_ip","int_id"})
public class CStuc extends Structure {
    public String str_ip;
    public int int_ip;
    public int int_id;

    @Override
    protected List getFieldOrder() {
        return Arrays.asList(new String[]{"str_id","int_ip","int_id"});
    }

    @Override
    public void useMemory(Pointer m, int offset){
        super.useMemory(m, offset);
        super.read();
    }

    @Override
    public void useMemory(Pointer m){
        super.useMemory(m);
        super.read();
    }
}