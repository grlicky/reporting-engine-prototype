package com.grlicky.reporting;

/** @author vgr */
public class ReportManagerConfiguration {

    private static final int DEFAULT_REPORT_INPUT_STREAM_BUFFER_LENGTH = 1024;

    private int reportInputStreamBufferLegth;

    public ReportManagerConfiguration() {
        reportInputStreamBufferLegth = DEFAULT_REPORT_INPUT_STREAM_BUFFER_LENGTH;
    }

    public int getInputStreamBufferLegth() {
        return reportInputStreamBufferLegth;
    }

    public void setReportInputStreamBufferLegth(int reportInputStreamBufferLegth) {
        this.reportInputStreamBufferLegth = reportInputStreamBufferLegth;
    }
}