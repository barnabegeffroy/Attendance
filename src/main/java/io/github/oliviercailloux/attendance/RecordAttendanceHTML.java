package io.github.oliviercailloux.attendance;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@javax.ws.rs.Path("listAttendance")
public class RecordAttendanceHTML {

	@GET
	@Produces(MediaType.TEXT_HTML)
	public File asHTML() throws IOException {
		StudentsList l = new StudentsList();
		JsonArray data = l.asJson();
		Charset charset = StandardCharsets.UTF_8;
		java.nio.file.Path path = Paths.get("src/main/webapp/templateCheck.html");
		java.nio.file.Path pathEnd = Paths.get("src/main/webapp/tableCheck.html");
		String content = new String(Files.readAllBytes(path), charset);
		content = content.replace("$students", data.toString());
		Files.write(pathEnd, content.getBytes(charset));
		File f = new File("src/main/webapp/tableCheck.html");
		return f;
	}
	
}
