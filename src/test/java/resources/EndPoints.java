package resources;

public enum EndPoints {

	Post("/api/users"), 
	Get("/api/users/2"), 
	Delete("/api/users/2");

	String method;

	EndPoints(String method) {
		this.method = method;
	}

	public String getEndPoints() {
		return method;
	}

}
