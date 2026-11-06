package ht.fds.mbds.elanjery.tp2tests;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;

public class Test1 {

    public static void main(String[] args) {
        String cle = System.getenv("GEMINI_KEY");
        // Création du modèle avec un builder
        ChatModel modele = GoogleGenAiChatModel.builder()
                .apiKey(cle)
                .modelName("gemini-3.5-flash-lite")
                .temperature(0.7)
                .build();
        // Pose une question au modèle
        String reponse =
                modele.chat("Traduis 'bonjour' en anglais");
        // Affiche réponse du modèle (hello)
        System.out.println(reponse);
        String reponse2 =
                modele.chat("Quelle heure est-il actuellement ?");
        System.out.println(reponse2);
        String reponse3 =
                modele.chat("Bonjour, je m'appelle Halima.");
        System.out.println(reponse3);

        String reponse4 =
                modele.chat("Quel est mon nom ?");
        System.out.println(reponse4);
    }
}