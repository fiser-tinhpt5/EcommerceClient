package com.tinhpt5;

import javax.faces.bean.ManagedBean;
import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

@ManagedBean
public class HelloController {
	
	public String getHello() {
		Client client = Client.create();
		WebResource webResource = client
				   .resource("http://localhost:8080");
		ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON)
                .get(ClientResponse.class);
		if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
		}
		Product output = response.getEntity(Product.class);
		String out = response.toString();
		return output.toString();
	}

}
