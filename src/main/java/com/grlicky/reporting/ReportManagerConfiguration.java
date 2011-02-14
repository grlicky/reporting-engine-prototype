package com.grlicky.reporting;

/** @author Vladimir Grlicky */
public class ReportManagerConfiguration {

    private static final int DEFAULT_REPORT_INPUT_STREAM_BUFFER_LENGTH = 1024;

    private int reportInputStreamBufferLength;

    public ReportManagerConfiguration() {
        reportInputStreamBufferLength = DEFAULT_REPORT_INPUT_STREAM_BUFFER_LENGTH;
    }

    public int getInputStreamBufferLength() {
        return reportInputStreamBufferLength;
    }

    public void setReportInputStreamBufferLength(int reportInputStreamBufferLength) {
        this.reportInputStreamBufferLength = reportInputStreamBufferLength;
    }
}