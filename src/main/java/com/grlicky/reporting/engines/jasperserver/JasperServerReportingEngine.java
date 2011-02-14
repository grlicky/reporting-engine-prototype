package com.grlicky.reporting.engines.jasperserver;

import com.grlicky.reporting.Report;
import com.grlicky.reporting.engines.AbstractUrlBasedReportingEngine;

/** @author Vladimir Grlicky */
public class JasperServerReportingEngine
    extends AbstractUrlBasedReportingEngine {

    private final JasperServerReportingEngineConfiguration configuration;

    private JasperServerReportingEngine(JasperServerReportingEngineConfiguration configuration) {
        this.configuration = configuration;
    }

    public static JasperServerReportingEngine newInstance(JasperServerReportingEngineConfiguration configuration) {
        return new JasperServerReportingEngine(configuration);
    }

    protected String buildReportLocation(Report report) {
        StringBuilder sb = new StringBuilder(configuration.getServerUrl());
        sb.append("&output=pdf&reportUnit=").append(report.getName());
        if (!report.getParameters().isEmpty()) {
            sb.append("&").append(report.getParameters().asUrlString());
        }
        sb.append("&j_username=").append(configuration.getUserName());
        sb.append("&j_password=").append(configuration.getPassword());
        return sb.toString();
    }
}