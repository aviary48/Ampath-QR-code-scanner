package com.morgan.barcodescannerapp.scanner.service.authentication;

import com.morgan.barcodescannerapp.scanner.service.Device.DeviceService;
import com.morgan.barcodescannerapp.scanner.service.RemoteServer.RemoteServer;
import com.morgan.barcodescannerapp.scanner.service.Service;
import com.morgan.barcodescannerapp.scanner.service.connection.ConnectionService;

import org.apache.http.HttpClientConnection;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/**
 * Created by Eugene Kamadi on 7/21/2014.
 */
public class AuthenticationService implements Service {

    private final static String SERVICE_NAME = "AuthenticationService"  ;
    private RemoteServer remoteServer = null ;
    private ConnectionService connectionService = null ;
    private DeviceService deviceService = null ;

    public AuthenticationService () {

    }

    public String getServiceName() {
        return this.SERVICE_NAME ;
    }


    public boolean authenticate(String username, String password) {
        if(isRemoteServerAvailable()) {
            return authenticateRemote(username, password) ;
        } else {
            return authenticateDevice(username,  password) ;
        }
    }

    private boolean isRemoteServerAvailable() {
        return new HttpClientConnection(remoteServer.getAddress()).isResponseAvailable();
    }

    private boolean authenticateRemote(String username, String password) {
        boolean authenticated = false ;
        if(remoteServer != null) {
            authenticated = connectionService.authenticate(username, password) ;
        }

        return authenticated ;
    }

    private boolean authenticateDevice(String username, String password) {
        boolean authenticated = false ;
        if(deviceService != null) {
            authenticated = deviceService.authenticate(username, password) ;
        }

        return authenticated ;
    }

    private RemoteServer createRemoteServerConnection() {
        remoteServer = new RemoteServer(ConnectionService.getConfig().getRemoteServer()) ;
        return remoteServer ;
    }

    //device service
    private DeviceService createDeviceService() {
        if(deviceService != null) {
            deviceService = new DeviceService() ;
        }
        return deviceService ;
    }

                Authenticator.setDefault(new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        PasswordAuthentication pa= new PasswordAuthentication( username, password.toCharArray());
                        System.out.println(pa.getUserName()+ ":" + new String(pa.getPassword()));
                    return pa;
                    }
                });

}
