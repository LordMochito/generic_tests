package com.codetest.acceptance.tests.rest.communications;
import javax.ws.rs.core.Response.Status;

public class SimpleClientResponse {

    private Status status;

    public SimpleClientResponse() {
    }

    public SimpleClientResponse(com.sun.jersey.api.client.ClientResponse.Status clientResponseStatus) {
	status = Status.fromStatusCode(clientResponseStatus.getStatusCode());	
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}