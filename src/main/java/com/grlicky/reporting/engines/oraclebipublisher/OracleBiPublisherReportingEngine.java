package com.grlicky.reporting.engines.oraclebipublisher;

import com.grlicky.reporting.Report;
import com.grlicky.reporting.engines.AbstractUrlBasedReportingEngine;

/** @author Vladimir Grlicky */
public class OracleBiPublisherReportingEngine
    extends AbstractUrlBasedReportingEngine {

    private final OracleBiPublisherReportingEngineConfiguration configuration;

    private OracleBiPublisherReportingEngine(OracleBiPublisherReportingEngineConfiguration configuration) {
        this.configuration = configuration;
    }

    public static
    OracleBiPublisherReportingEngine newInstance(OracleBiPublisherReportingEngineConfiguration configuration) {
        return new OracleBiPublisherReportingEngine(configuration);
    }

    protected String buildReportLocation(Report report) {
        StringBuilder sb = new StringBuilder(configuration.getServerUrl());
        sb.append(report.getName());  // the report document to render
        sb.append("?_xpf=");
        sb.append("&_xpt=1");  // render just the report document
        sb.append("&_xf=pdf");  // output format of the report document (pdf)
        sb.append("&id=").append(configuration.getUserName());
        sb.append("&passwd=").append(configuration.getPassword());
        return sb.toString();
    }
}