package com.codetest.acceptance.tests.rest.communications;

import com.sun.jersey.api.client.GenericType;

public class ClientResponse<T> extends SimpleClientResponse {

	private T entity;

	public ClientResponse(com.sun.jersey.api.client.ClientResponse response,
			Class<T> theClass) {
		super(response.getClientResponseStatus());
				
		try {
			entity = response.getEntity(theClass);
		} catch (Exception e) {
			entity = null;
		}
	}

	public ClientResponse(com.sun.jersey.api.client.ClientResponse response,
			GenericType<T> genericType) {
		super(response.getClientResponseStatus());

		try {
			entity = response.getEntity(genericType);
		} catch (Exception e) {
			entity = null;
		}

	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

}
