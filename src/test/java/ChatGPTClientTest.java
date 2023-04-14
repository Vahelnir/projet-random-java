import chatgpt.ChatGPTClient;

import java.io.IOException;

public class ChatGPTClientTest {

    public static void main(String[] args) {
        String apiKey = "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"; // Remplacez par votre clé API
        ChatGPTClient chatGPTClient = new ChatGPTClient(apiKey);

        // Test 1: Réunion sans date alternative
        String email1 = "Bonjour, j'aimerais organiser une réunion le 20 avril à 14h pour discuter du projet Y. Merci.";
        String type1 = "reunion";
        Boolean isConfirmed1 = true;
        String alternativeDate1 = null;
        testResponse(chatGPTClient, email1, type1, isConfirmed1, alternativeDate1);

        // Test 2: E-mail simple
        String email2 = "Bonjour, j'ai une question concernant le projet Y. Pouvez-vous me donner plus d'informations sur la phase de conception ?";
        String type2 = "email";
        Boolean isConfirmed2 = null;
        String alternativeDate2 = null;
        testResponse(chatGPTClient, email2, type2, isConfirmed2, alternativeDate2);

        // Test 3: Réunion avec date alternative
        String email3 = "Bonjour, j'aimerais organiser une réunion le 20 avril à 14h pour discuter du projet Y. Merci.";
        String type3 = "reunion";
        Boolean isConfirmed3 = true;
        String alternativeDate3 = "le 21 avril à 15h";
        testResponse(chatGPTClient, email3, type3, isConfirmed3, alternativeDate3);
    }

    private static void testResponse(ChatGPTClient gptClient, String email, String type, Boolean isConfirmed, String alternativeDate) {
        try {
            String generatedResponse = gptClient.generateResponse(email, type, isConfirmed, alternativeDate);
            System.out.println("E-mail: " + email);
            System.out.println("Generated Response: " + generatedResponse);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("An error occurred while generating the response.");
        }
        System.out.println("\n---\n");
    }
}