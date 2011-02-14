package com.grlicky.reporting;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** @author Vladimir Grlicky */
public class ReportManager {

    private static final Logger logger = LoggerFactory.getLogger(ReportManager.class);

    private static final ReportManager INSTANCE = new ReportManager();

    private final ReportManagerConfiguration configuration;
    private final Map<String, ReportingEngine> engines = new HashMap<String, ReportingEngine>();

    private ReportManager() {
        configuration = new ReportManagerConfiguration();
    }

    public static ReportManager getInstance() {
        return INSTANCE;
    }

    /* ************************************************** */

    public void register(String engineId, ReportingEngine engine) {
        engines.put(engineId, engine);
    }

    /* ************************************************** */

    public InputStream getReportInputStream(Report report) {
        return getReportInputStreamInternally(report, report.getEngineId());
    }

    public InputStream getReportInputStream(Report report, String engineId) {
        return getReportInputStreamInternally(report, engineId);
    }

    private InputStream getReportInputStreamInternally(Report report, String engineId) {
        assert report != null && engineId != null;
        
        ReportingEngine engine = engines.get(engineId);
        return engine.getReportInputStream(report);
    }

    /* ************************************************** */

    public void saveReportToFile(Report report, String fileName) {
        saveReportToFileInternally(report, fileName, report.getEngineId());
    }

    public void saveReportToFile(Report report, String fileName, String engineId) {
        saveReportToFileInternally(report, fileName, engineId);
    }

    private void saveReportToFileInternally(Report report, String fileName, String engineId) {
        assert report != null && fileName != null && engineId != null;

        InputStream in = null;
        OutputStream out = null;
        try {
            out = new FileOutputStream(new File(fileName));
            in = getReportInputStreamInternally(report, engineId);

            int bytesRead;
            byte[] buffer = new byte[configuration.getInputStreamBufferLegth()];

            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        } catch (Exception e) {
            throw new ReportingEngineException(e);
        } finally {
            closeSilently(in, out);
        }
    }

    /* ************************************************** */
    
    private static void closeSilently(Closeable... closeables) {
        for (Closeable closeable : closeables) {
            if (closeable != null) {
                try {
                    closeable.close();
                    
                } catch (IOException ioe) {
                    logger.error("", ioe);
                }
            }
        }
    }
}