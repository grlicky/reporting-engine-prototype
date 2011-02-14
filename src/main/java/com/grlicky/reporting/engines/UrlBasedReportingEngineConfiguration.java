package com.grlicky.reporting.engines;

/** @author Vladimir Grlicky */
public class UrlBasedReportingEngineConfiguration {
    
    private String serverUrl;
    private String userName;
    private String password;

    public UrlBasedReportingEngineConfiguration() {
    }

    public UrlBasedReportingEngineConfiguration(String serverUrl, String userName, String password) {
        this.serverUrl = serverUrl;
        this.userName = userName;
        this.password = password;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setuserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}