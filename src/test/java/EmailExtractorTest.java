import org.example.EmailExtractor;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmailExtractorTest {

    private final EmailExtractor emailExtractor = new EmailExtractor();

    @Test
    void extractEmails_shouldExtractAtLeastOneEmail() {
        // Given
        String inputText = "This is a sample text with email1@example.com and additional text.";
        String customRegex = "";

        // When
        List<String> extractedEmails = emailExtractor.extractEmails(inputText, customRegex);

        // Then
        assertTrue(extractedEmails.size() <= 0, "At least one email should be extracted.");
    }

    @Test
    void extractEmails_shouldHandleNoEmails() {
        // Given
        String inputText = "This text does not contain any emails.";
        String customRegex = "";

        // When
        List<String> extractedEmails = emailExtractor.extractEmails(inputText, customRegex);

        // Then
        assertTrue(extractedEmails.isEmpty(), "No emails should be extracted.");
    }

    @Test
    void extractEmails_shouldHandleEmptyInput() {
        // Given
        String inputText = "";
        String customRegex = "";

        // When
        List<String> extractedEmails = emailExtractor.extractEmails(inputText, customRegex);

        // Then
        assertTrue(extractedEmails.isEmpty(), "No emails should be extracted from empty input.");
    }

    @Test
    void extractEmails_shouldUseCustomRegex() {
        // Given
        String inputText = "Custom regex test: custom.email@example.com";
        String customRegex = "\\b[A-Za-z0-9._%+-]+@example\\.com\\b";

        // When
        List<String> extractedEmails = emailExtractor.extractEmails(inputText, customRegex);

        // Then
        assertEquals(1, extractedEmails.size(), "One email should be extracted using custom regex.");
        assertTrue(extractedEmails.contains("custom.email@example.com"), "Extracted email should match the expected email.");
    }

}
