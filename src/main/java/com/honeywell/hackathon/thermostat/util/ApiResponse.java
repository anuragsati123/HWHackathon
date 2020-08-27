package com.honeywell.hackathon.thermostat.util;

public class ApiResponse {

    private String status;
    private String message;
    
    public ApiResponse(String status, String message) {
        super();
        this.status = status;
        this.message = message;
    }
    
    public ApiResponse() {
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    
     public ApiResponse success(Object responseObject){
            this.status = "success";
            return this;
        }
        
        public ApiResponse success(String responseMessage){
            this.status =  "success";
            this.message = responseMessage;
            return this;
        }
    
}

