package pojo;

public class Payload {
	
	public Json jsonPayload(String name, String job) {
		Json js=new Json();
		js.setName(name);
		js.setJob(job);
		return js;
		
	}

}
