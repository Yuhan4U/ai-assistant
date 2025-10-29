package com.yuhan.test.web.demoweb.pojo;

public class MessageRequest {
    private String message;
    private String language;

    public MessageRequest() {}

    public MessageRequest(String message, String language) {
        this.message = message;
        this.language = language;
    }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }
}
