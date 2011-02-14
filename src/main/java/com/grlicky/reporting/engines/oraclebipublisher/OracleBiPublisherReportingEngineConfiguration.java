package com.grlicky.reporting.engines.oraclebipublisher;

import com.grlicky.reporting.engines.UrlBasedReportingEngineConfiguration;

/** @author Vladimir Grlicky */
public class OracleBiPublisherReportingEngineConfiguration
    extends UrlBasedReportingEngineConfiguration {

    public OracleBiPublisherReportingEngineConfiguration(String serverUrl, String loginName, String password) {
        super(serverUrl, loginName, password);
    }
}