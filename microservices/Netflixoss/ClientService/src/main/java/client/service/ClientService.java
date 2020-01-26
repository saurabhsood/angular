package client.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import client.model.Client;

@RestController
@RequestMapping("/client")
public class ClientService {

	@GetMapping("/add")
	public ResponseEntity<HttpStatus> add(Client client)
	{
		System.out.println("hiii");
		return new ResponseEntity(HttpStatus.OK);
	}
	
	 @GetMapping("/inquire/{clntnum}")
	public ResponseEntity<Client> getClientByClntnum(@PathVariable("clntnum") String clntnum) 
	                                                    {
	       Client cl = new Client();
	       cl.setClntnum(clntnum);
	       cl.setClntName("A");
	        return new ResponseEntity<Client>(cl, new HttpHeaders(), HttpStatus.OK);
	    }
	
}
