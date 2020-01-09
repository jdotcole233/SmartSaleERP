package com.smartsaleerp.smartsale.Models;

public class MessageModel {
    private String message, time, sendername;

    public MessageModel(String message, String time, String sendername) {
        this.message = message;
        this.time = time;
        this.sendername = sendername;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSendername() {
        return sendername;
    }

    public void setSendername(String sendername) {
        this.sendername = sendername;
    }
}
