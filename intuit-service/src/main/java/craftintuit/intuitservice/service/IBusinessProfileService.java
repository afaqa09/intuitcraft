package craftintuit.intuitservice.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import craftintuit.intuitservice.entity.BusinessProfile;
import craftintuit.intuitservice.entity.Response;

public interface IBusinessProfileService {

	public ResponseEntity<List<String>> getProfile(String ln) ;
	
	public ResponseEntity<Response> updateProfile(String ln, BusinessProfile bp);

	public ResponseEntity<Response> createProfile(String prodstring, BusinessProfile bp);
}
