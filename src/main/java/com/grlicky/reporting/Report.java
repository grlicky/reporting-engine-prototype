package com.grlicky.reporting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/** @author Vladimir Grlicky */
public class Report {

    private final String name;
    private final Parameters parameters;
    
    private final String engineId;

    public Report(String name, String engineId) {
        this.name = name;
        this.parameters = Parameters.EMPTY;
        this.engineId = engineId;
    }

    public Report(String name, Parameters parameters, String engineId) {
        this.name = name;
        this.parameters = parameters;
        this.engineId = engineId;
    }

    public String getName() {
        return name;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public String getEngineId() {
        return engineId;
    }

    /* ************************************************** */

    public static final class Parameters {

        public static final Parameters EMPTY = new Parameters();

        private final List<Parameter> parameters;
        
        private Parameters() {
            this.parameters = Collections.emptyList();
        }

        private Parameters(Collection<Parameter> parameters) {
            this.parameters = new ArrayList<Parameter>(parameters);
        }

        public static Parameters create(Collection<Parameter> parameters) {
            return parameters.isEmpty() ? EMPTY : new Parameters(parameters);
        }

        public static Parameters create(Parameter... parameters) {
            return parameters.length == 0 ? EMPTY : new Parameters(Arrays.asList(parameters));
        }

        public boolean isEmpty() {
            return parameters.isEmpty();
        }

        public int size() {
            return parameters.size();
        }

        public String asUrlString() {
            StringBuilder sb = new StringBuilder();
            boolean firstTime = true;
            for (Parameter parameter : parameters) {
                if (firstTime) { firstTime = false; }
                else { sb.append("&"); }
                sb.append(parameter.asUrlString()); 
            }
            return sb.toString();
        }
    }

    /* ************************************************** */

    public static final class Parameter {

        private final String name;

        private final String value;

        private Parameter(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public static Parameter create(String name, String value) {
            return new Parameter(name, value);
        }

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }

        public String asUrlString() {
            return name + "=" + value;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) { return true; }
            if (object == null || getClass() != object.getClass()) { return false; }

            final Parameter parameter = (Parameter) object;

            if (!name.equals(parameter.name)) { return false; }
            if (value != null ? !value.equals(parameter.value) : parameter.value != null) { return false; }

            return true;
        }

        @Override
        public int hashCode() {
            int result = name.hashCode();
            result = 31 * result + (value != null ? value.hashCode() : 0);
            return result;
        }

        public String toString() {
            String valueStr = value != null ? "'" + value + "'" : "<null>";
            return "Parameter(name='" + name + "',value=" + valueStr + ")";
        }
    }
}