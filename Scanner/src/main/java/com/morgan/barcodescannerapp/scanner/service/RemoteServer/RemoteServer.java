package com.morgan.barcodescannerapp.scanner.service.RemoteServer;

import com.morgan.barcodescannerapp.scanner.service.Service;

/**
 * Created by Eugene Kamadi on 7/21/2014.
 */
public class RemoteServer implements Service {

    private final static String SERVICE_NAME = "Device service";

    public String getServiceName(){
        return SERVICE_NAME;

    }
}
