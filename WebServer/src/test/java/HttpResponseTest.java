import org.example.HttpResponse;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import static org.junit.Assert.assertEquals;

public class HttpResponseTest {
    private static final String TEST_HTML_CONTENT = "<html><body><h1>Hello, Test!</h1></body></html>";
    private static final String TEST_JSON_CONTENT = "{\"key\": \"value\"}";

    @Test
    public void testSendHtmlResponse() throws IOException {
        Path tempHtmlFile = createTempFileWithContent(TEST_HTML_CONTENT);

        try (StringWriter writer = new StringWriter()) {
            HttpResponse.sendHtmlResponse(new BufferedWriter(writer), tempHtmlFile.toString());
            assertEquals("HTTP/1.1 200 OK\r\nContent-Type: text/html\r\n\r\n" + TEST_HTML_CONTENT, writer.toString());
        } finally {
            Files.deleteIfExists(tempHtmlFile);
        }
    }

    @Test
    public void testSendJsonResponse() throws IOException {
        Path tempJsonFile = createTempFileWithContent(TEST_JSON_CONTENT);

        try (StringWriter writer = new StringWriter()) {
            HttpResponse.sendJsonResponse(new BufferedWriter(writer), tempJsonFile.toString());
            assertEquals("HTTP/1.1 200 OK\r\nContent-Type: application/json\r\n\r\n" + TEST_JSON_CONTENT, writer.toString());
        } finally {
            Files.deleteIfExists(tempJsonFile);
        }
    }

    @Test
    public void testSendNotFoundResponse() throws IOException {
        try (StringWriter writer = new StringWriter()) {
            HttpResponse.sendNotFoundResponse(new BufferedWriter(writer));
            assertEquals("HTTP/1.1 404 Not Found\r\n\r\n", writer.toString());
        }
    }

    @Test
    public void testSendTextResponse() throws IOException {
        try (StringWriter writer = new StringWriter()) {
            HttpResponse.sendTextResponse(new BufferedWriter(writer), "Test response");
            assertEquals("HTTP/1.1 200 OK\r\nContent-Type: text/plain\r\n\r\nTest response", writer.toString());
        }
    }

    private Path createTempFileWithContent(String content) throws IOException {
        Path tempFile = Files.createTempFile("test", ".txt");
        Files.write(tempFile, content.getBytes(), StandardOpenOption.WRITE);
        return tempFile;
    }
}
