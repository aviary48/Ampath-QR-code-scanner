package com.morgan.barcodescannerapp.scanner.service.connection;

import com.morgan.barcodescannerapp.scanner.service.Service;

/**
 * Created by Eugene Kamadi on 7/21/2014.
 */

/**
 * define connection to the local database/file
 * define connection to a remote server
 * return connection object in case connection is available
 *
 */
public class ConnectionService implements Service {

    private final static String SERVICE_NAME = "ConnectionService" ;

    public String getServiceName() {
        return SERVICE_NAME;
    }
}
