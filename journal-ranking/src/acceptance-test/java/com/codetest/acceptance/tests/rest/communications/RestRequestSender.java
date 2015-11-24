package com.codetest.acceptance.tests.rest.communications;

import javax.inject.Named;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.WebResource.Builder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

@Named
public class RestRequestSender {

    private String host = "http://localhost:9090";

    private String acceptMediaType = MediaType.APPLICATION_JSON;

    private String applicationType = MediaType.APPLICATION_JSON;

    private ClientConfig config = new DefaultClientConfig();

    public <T> ClientResponse<T> invoke(RestMethod method, String url, Class<T> expectedResponse, Headers... headers) {
	    Builder builder = createBuilder(url,headers);
		
		com.sun.jersey.api.client.ClientResponse clienteResponse = null;
		switch (method) {
		case GET:
		    clienteResponse = builder.get(com.sun.jersey.api.client.ClientResponse.class);
		    break;
		case DELETE:
		    clienteResponse = builder.delete(com.sun.jersey.api.client.ClientResponse.class);
		    break;
		default:
		    throw new UnsupportedOperationException();
	}

	return new ClientResponse<T>(clienteResponse, expectedResponse);
    }

    
    public <T> ClientResponse<T> invoke(RestMethod method, String url, GenericType<T> genericType, Headers... headers) {
    Builder builder = createBuilder(url,headers);

	com.sun.jersey.api.client.ClientResponse clienteResponse = null;
	switch (method) {
	case GET:
	    clienteResponse = builder.get(com.sun.jersey.api.client.ClientResponse.class);
	    break;
	case DELETE:
	    clienteResponse = builder.delete(com.sun.jersey.api.client.ClientResponse.class);
	    break;
	default:
	    throw new UnsupportedOperationException();
	}

	return new ClientResponse<T>(clienteResponse, genericType);
    }

    
    public <T> ClientResponse<T> invoke(RestMethod method, String url, Object requestEntity, Class<T> expectedResponse, Headers... headers) {
    Builder builder = createBuilder(url,headers);

	com.sun.jersey.api.client.ClientResponse clienteResponse = null;
	switch (method) {
	case POST:
	    clienteResponse = builder.post(com.sun.jersey.api.client.ClientResponse.class, requestEntity);
	    break;
	case PUT:
	    clienteResponse = builder.put(com.sun.jersey.api.client.ClientResponse.class, requestEntity);
	    break;
	case DELETE:
	    clienteResponse = builder.delete(com.sun.jersey.api.client.ClientResponse.class, requestEntity);
	    break;
	default:
	    throw new UnsupportedOperationException();
	}

	return new ClientResponse<T>(clienteResponse, expectedResponse);
    }

    public <T> ClientResponse<T> invoke(RestMethod method, String url, Object requestEntity, GenericType<T> genericType, Headers... headers) {
	Builder builder = createBuilder(url,headers);

	com.sun.jersey.api.client.ClientResponse clienteResponse = null;
	switch (method) {
	case POST:
	    clienteResponse = builder.post(com.sun.jersey.api.client.ClientResponse.class, requestEntity);
	    break;
	case PUT:
	    clienteResponse = builder.put(com.sun.jersey.api.client.ClientResponse.class, requestEntity);
	    break;
	case DELETE:
	    clienteResponse = builder.delete(com.sun.jersey.api.client.ClientResponse.class, requestEntity);
	    break;
	default:
	    throw new UnsupportedOperationException();
	}

	return new ClientResponse<T>(clienteResponse, genericType);
    }

    public SimpleClientResponse invoke(RestMethod method, String url, Object requestEntity, Headers... headers) {
    Builder builder = createBuilder(url,headers);

	com.sun.jersey.api.client.ClientResponse clienteResponse = null;
	switch (method) {
	case POST:
	    clienteResponse = builder.post(com.sun.jersey.api.client.ClientResponse.class, requestEntity);
	    break;
	case PUT:
	    clienteResponse = builder.put(com.sun.jersey.api.client.ClientResponse.class, requestEntity);
	    break;
	case DELETE:
	    clienteResponse = builder.delete(com.sun.jersey.api.client.ClientResponse.class, requestEntity);
	    break;
	default:
	    throw new UnsupportedOperationException();
	}

	return new SimpleClientResponse(clienteResponse.getClientResponseStatus());
    }

    public SimpleClientResponse invoke(RestMethod method, String url, Headers... headers) {

    Builder builder = createBuilder(url,headers);

	com.sun.jersey.api.client.ClientResponse clienteResponse = null;
	switch (method) {
	case GET:
	    clienteResponse = builder.get(com.sun.jersey.api.client.ClientResponse.class);
	    break;
	case DELETE:
	    clienteResponse = builder.delete(com.sun.jersey.api.client.ClientResponse.class);
	    break;
	case POST:
		clienteResponse = builder.post(com.sun.jersey.api.client.ClientResponse.class);
		break;
	default:
	    throw new UnsupportedOperationException();
	}

	return new SimpleClientResponse(clienteResponse.getClientResponseStatus());
    }

    private Builder createBuilder(String url , Headers[] headers) {
	WebResource resource = Client.create(config).resource(host+ url);
	Builder builder = resource.accept(acceptMediaType).type(applicationType);
	for(Headers h: headers){
		builder.header(h.getKey(), h.getValue());
	}
	return builder;
    }
    
}
