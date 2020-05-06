package com.nopaldev.artesanos.core.services.dtos;

import java.util.Map;

public class BaseEmailContext {
    private String to;
    private String from;
    private Map<String, String> parameters;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }
}
