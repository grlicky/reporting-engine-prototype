package com.grlicky.reporting.engines;

import java.net.HttpURLConnection;
import java.net.URL;
import java.io.IOException;
import java.io.InputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.grlicky.reporting.Report;
import com.grlicky.reporting.ReportingEngine;
import com.grlicky.reporting.ReportingEngineException;

/** @author Vladimir Grlicky */
public abstract class AbstractUrlBasedReportingEngine
    implements ReportingEngine {

    private static final Logger logger = LoggerFactory.getLogger(AbstractUrlBasedReportingEngine.class);

    public InputStream getReportInputStream(Report report) {
        try {
            String reportLocation = buildReportLocation(report);
            logger.debug("Report location: " + reportLocation);

            return getHttpConnection(reportLocation).getInputStream();

        } catch (IOException ioe) {
            throw new ReportingEngineException(ioe);
        }
    }

    protected HttpURLConnection getHttpConnection(String location)
        throws IOException {
        URL url = new URL(location);
        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
        httpConnection.setUseCaches(false);
        return httpConnection;
    }

    protected abstract String buildReportLocation(Report report);
}