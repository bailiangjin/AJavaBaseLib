package com.kevin.javabaselib.instance.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 白良锦 bailiangjin@gmail.com
 *
 * @version 创建时间：2015年7月28日 上午11:50:55 
 *
 */
public abstract class Citizen {
    
    List pols;
    
    String help = "normal";
    
    public void setHelp(String help) {
        this.help = help;
    }
    
    public String getHelp() {
        return this.help;
    }
    
    abstract void sendMessage(String help);
    public void setPolicemen() {
        this.pols = new ArrayList();
    }
    
    public void register(Policeman pol) {
        this.pols.add(pol);
    }
    public void unRegister(Policeman pol) {
        this.pols.remove(pol);
    }
}