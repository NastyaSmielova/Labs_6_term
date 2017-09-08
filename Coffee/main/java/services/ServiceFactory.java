/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

/**
 *
 * @author pc
 */
public class ServiceFactory {
    private static final ServiceBuy serviceBuy = new ServiceBuy();
    private static final ServiceReceive serviceReceive = new ServiceReceive();
    private static final ServiceUser serviceUser = new ServiceUser();
    private static final ServiceShow serviceShow = new ServiceShow();


    public static ServiceBuy getServiceBuy() {
        return serviceBuy;
    }

    public static ServiceReceive getServiceReceive() {
        return serviceReceive;
    }

    public static ServiceUser getServiceUser() {
        return serviceUser;
    }
    public static ServiceShow getServiceShow() {
        return serviceShow;
    }
    
}
