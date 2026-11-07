
package ht.fds.mbds.elanjery.tp2tests;

import dev.langchain4j.model.input.Prompt;
import dev.langchain4j.model.input.PromptTemplate;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;

import java.util.Map;

public class Test3Traducteur {

    public static void main(String[] args) {

        String cle = System.getenv("GEMINI_KEY");

        ChatModel modele = GoogleGenAiChatModel.builder()
                .apiKey(cle)
                .modelName("gemini-3.5-flash-lite")
                .temperature(0.7)
                .build();

        // Première partie : template avec une variable
        PromptTemplate template = PromptTemplate.from(
                "Traduis le texte suivant en anglais : {{texte}}"
        );

        Prompt prompt = template.apply(
                Map.of("texte", "Bonjour, comment allez-vous ?")
        );

        String reponse = modele.chat(prompt.text());

        System.out.println("Première traduction :");
        System.out.println(reponse);
        // Deuxième partie : template avec deux variables
        PromptTemplate template2 = PromptTemplate.from(
                "Traduis le texte suivant en {{langue}} : {{texte}}"
        );

        Prompt prompt2 = template2.apply(
                Map.of(
                        "langue", "espagnol",
                        "texte", "Bonjour, comment allez-vous ?"
                )
        );

        String reponse2 = modele.chat(prompt2.text());

        System.out.println("\nDeuxième traduction :");
        System.out.println(reponse2);
    }
}
