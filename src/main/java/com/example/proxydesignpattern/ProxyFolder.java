package com.example.proxydesignpattern;

public class ProxyFolder implements Folder {
    private RealFolder realFolder;
    private String userRole;

    public ProxyFolder(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public void access() {
        if ("Admin".equalsIgnoreCase(userRole)) {
            realFolder = new RealFolder();
            realFolder.access();
        } else {
            System.out.println("Access Denied. Only Admin can access the folder.");
        }
    }
}
