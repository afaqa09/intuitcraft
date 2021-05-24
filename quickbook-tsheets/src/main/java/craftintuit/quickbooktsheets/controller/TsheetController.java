package craftintuit.quickbooktsheets.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import craftintuit.intuitservice.entity.Response;

@RestController
@RequestMapping("/tsheets")
public class TsheetController {
	
	@GetMapping("/validate/{id}")
	public ResponseEntity<Response> validateBP(@PathVariable String id) {
		int i = id.charAt(0) - '0';
		System.out.println("TSHEET");
		if(i%2!=0)
			return new ResponseEntity<Response>( new Response(true,"PAYMENT"), HttpStatus.OK);
		return new ResponseEntity<Response>(new Response(false,"PAYMENT"),HttpStatus.NOT_ACCEPTABLE);
		
	}
	
}