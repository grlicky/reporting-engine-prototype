package com.grlicky.reporting;

/** @author Vladimir Grlicky */
public class ReportingEngineException
    extends RuntimeException {

    public ReportingEngineException(Throwable cause) {
        super(cause);
    }

    public ReportingEngineException(String message, Throwable cause) {
        super(message, cause);
    }
}