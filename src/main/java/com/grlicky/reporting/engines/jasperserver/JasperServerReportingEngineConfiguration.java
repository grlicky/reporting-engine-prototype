package com.grlicky.reporting.engines.jasperserver;

import com.grlicky.reporting.engines.UrlBasedReportingEngineConfiguration;

/** @author Vladimir Grlicky */
public class JasperServerReportingEngineConfiguration
    extends UrlBasedReportingEngineConfiguration {

    public JasperServerReportingEngineConfiguration(String serverUrl, String userName, String password) {
        super(serverUrl, userName, password);
    }
}