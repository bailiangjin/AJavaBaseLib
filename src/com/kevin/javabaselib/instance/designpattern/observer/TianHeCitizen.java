package com.kevin.javabaselib.instance.designpattern.observer;
/**
 * @author 白良锦 bailiangjin@gmail.com
 *
 * @version 创建时间：2015年7月28日 上午11:53:15 
 *
 */
public class TianHeCitizen extends Citizen {
    public TianHeCitizen(Policeman pol) {
        setPolicemen();
        register(pol);
    }
    
    public void sendMessage(String help) {
        setHelp(help);
        for (int i = 0; i < pols.size(); i++) {
            Policeman pol = (Policeman) pols.get(i);
            //通知警察行动
            pol.action(this);
        }
    }
}
