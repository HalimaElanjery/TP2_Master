
package ht.fds.mbds.elanjery.tp2tests;

import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;

public class Test2Couts {

    public static void main(String[] args) {

        String cle = System.getenv("GEMINI_KEY");

        ChatModel modele = GoogleGenAiChatModel.builder()
                .apiKey(cle)
                .modelName("gemini-3.5-flash-lite")
                .temperature(0.7)
                .build();

        // Même question que dans le Test 1
        String question = "Traduis 'bonjour' en anglais";

        // Envoyer un UserMessage pour récupérer un ChatResponse
        ChatResponse reponse = modele.chat(UserMessage.from(question));

        // Afficher la réponse
        System.out.println("Réponse :");
        System.out.println(reponse.aiMessage().text());

        // Récupérer les informations sur les tokens
        System.out.println("\nInformations sur les tokens :");

        System.out.println("Tokens d'entrée : "
                + reponse.tokenUsage().inputTokenCount());

        System.out.println("Tokens de sortie : "
                + reponse.tokenUsage().outputTokenCount());

        System.out.println("Tokens totaux : "
                + reponse.tokenUsage().totalTokenCount());
    }
}
