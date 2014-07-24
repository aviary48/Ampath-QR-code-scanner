package com.morgan.barcodescannerapp.scanner.service.Device;

import com.morgan.barcodescannerapp.scanner.service.Service;

/**
 * Created by Eugene Kamadi on 7/21/2014.
 */
public class DeviceService implements Service {
    private final static String SERVICE_NAME = "Device service";

    public String getServiceName(){
        return SERVICE_NAME;
    }


    private DeviceService createDeviceService(){

    }

}
