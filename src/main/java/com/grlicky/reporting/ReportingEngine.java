package com.grlicky.reporting;

import java.io.InputStream;

/** @author Vladimir Grlicky */
public interface ReportingEngine {

    InputStream getReportInputStream(Report report);
}