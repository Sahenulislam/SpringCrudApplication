package com.example.demo.responses;

import com.example.demo.entity.Nodes;

import java.util.List;

public class ResponseDto {
    private String message;
    private List<Nodes> body;
    private int status;

    public ResponseDto() {
    }

    public ResponseDto(String message, List<Nodes> body, int status) {
        this.message = message;
        this.body = body;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Nodes> getBody() {
        return body;
    }

    public void setBody(List<Nodes> body) {
        this.body = body;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
