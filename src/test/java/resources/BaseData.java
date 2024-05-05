package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseData {
	RequestSpecification req;
	

	public String url() throws IOException  {
		Properties pro = new Properties();
		FileInputStream fis = new FileInputStream(
				"/Users/basitzameer/Tools/eclipse-workspace/ReqRes.in/src/test/java/resources/base_url.properties");
		pro.load(fis);
		return pro.getProperty("base_url");
	}

	public RequestSpecification requestBuilder() throws IOException {
		PrintStream log=new PrintStream(new FileOutputStream("Logging.txt"));
		RequestSpecBuilder request = new RequestSpecBuilder();
		req = request.setBaseUri(url()).addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON)
				.build();
		return req;
	}

}
