package io.github.oliviercailloux.attendance;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.JsonArray;
import javax.ws.rs.GET;

@javax.ws.rs.Path("list")
@RequestScoped
public class ListHTML {

	@Inject
	StudentsList list;

	@GET
	public File asHTML() throws IOException {
		StudentsList l = new StudentsList();
		JsonArray data = l.asJson();
		Charset charset = StandardCharsets.UTF_8;
		java.nio.file.Path path = Paths.get("src/main/webapp/template.html");
		java.nio.file.Path pathEnd = Paths.get("src/main/webapp/table.html");
		String content = new String(Files.readAllBytes(path), charset);
		content = content.replace("$students", data.toString());
		Files.write(pathEnd, content.getBytes(charset));
		File f = new File("src/main/webapp/table.html");
		return f;
	}
}
