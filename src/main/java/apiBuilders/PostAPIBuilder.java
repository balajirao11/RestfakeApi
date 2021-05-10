package apiBuilders;

import java.util.HashMap;
import java.util.Map;

public class PostAPIBuilder {
	
	
	public Map<String, String> postRequestBody( String userid,String id, String title, String desc){
		Map<String, String> body = new HashMap<String, String>();
		body.put("UseId", userid);
		body.put("Id", id);
		body.put("Title", title);
		body.put("Desc", desc);
		
		
		return body;
		
	}
	
	public Map<String, String> postComRequestBody(String postid, String id, String name, String email){
		Map<String, String> body = new HashMap<String, String>();
		body.put("PostId", postid);
		body.put("id", id);
		body.put("Name", name);
		body.put("Email", email);
		
		
		return body;
		
	}
	
	public Map<String, String> postUsresRequestBody(String id,String fName, String lName, String subjId){
		Map<String, String> body = new HashMap<String, String>();
		body.put("id", id);
		body.put("First_Name", fName);
		body.put("Last_Name", lName);
		body.put("Subject_Id", subjId);
		
		
		return body;
		
	}
	
	
	
}
