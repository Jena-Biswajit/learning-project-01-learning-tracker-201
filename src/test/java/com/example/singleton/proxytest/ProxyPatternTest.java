package com.example.singleton.proxytest;

import com.example.proxydesignpattern.Folder;
import com.example.proxydesignpattern.ProxyFolder;
import org.junit.jupiter.api.Test;

public class ProxyPatternTest {

    @Test
    public void testAdminAccess() {
        Folder adminFolder = new ProxyFolder("Admin");
        adminFolder.access();  // should print: Accessing the real folder...
    }

    @Test
    public void testGuestAccess() {
        Folder guestFolder = new ProxyFolder("Guest");
        guestFolder.access();  // should print: Access Denied
    }
}
