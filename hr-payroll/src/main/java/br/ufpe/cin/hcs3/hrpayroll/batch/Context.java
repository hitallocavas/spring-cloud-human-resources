package br.ufpe.cin.hcs3.hrpayroll.batch;

import java.util.HashMap;
import java.util.Map;

public class Context {

    Map<String, Object> context;

    public Context(){
        this.context = new HashMap<>();
    }

    public void add(String key, Object value){
        this.context.put(key, value);
    }

    public Object get(String key){
       return this.context.get(key);
    }

    public void remove(String key){
        this.context.remove(key);
    }

    public void clear(){
        this.context.clear();
    }

}
