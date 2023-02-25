package org.lankheet.domiot.utils;

import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Utility to test whether ports are open
 *
 */
public class TcpPortUtil {
    /**
     * Test the port availability on a host
     * 
     * @param ip The hostname
     * @param port The port to test
     * @param timeout number of milliseconds to try
     * @return true Port is open, false otherwise
     */
    public static boolean isPortOpen(String ip, int port, int timeout) {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(ip, port), timeout);
            socket.close();
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
