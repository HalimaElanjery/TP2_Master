package ht.fds.mbds.elanjery.tp2tests;

import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.chat.response.ChatResponse;
import dev.langchain4j.model.google.genai.GoogleGenAiChatModel;

public class Test2Couts {

    // Tarifs du modèle en dollars par million de tokens
    // (à vérifier sur la page de tarification officielle de Google)
    private static final double PRIX_ENTREE_PAR_MILLION = 0.10;
    private static final double PRIX_SORTIE_PAR_MILLION = 0.40;

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
        int tokensEntree = reponse.tokenUsage().inputTokenCount();
        int tokensSortie = reponse.tokenUsage().outputTokenCount();
        int tokensTotaux = reponse.tokenUsage().totalTokenCount();

        System.out.println("\nInformations sur les tokens :");
        System.out.println("Tokens d'entrée : " + tokensEntree);
        System.out.println("Tokens de sortie : " + tokensSortie);
        System.out.println("Tokens totaux : " + tokensTotaux);

        // Calcul du coût d'une requête (en dollars)
        double coutRequete = (tokensEntree * PRIX_ENTREE_PAR_MILLION
                + tokensSortie * PRIX_SORTIE_PAR_MILLION) / 1_000_000.0;

        // Calcul du nombre de requêtes pour dépenser 1 $
        long nombreRequetes = (long) (1.0 / coutRequete);

        System.out.println("\nCalcul des coûts :");
        System.out.printf("Coût d'une requête : %.8f $%n", coutRequete);
        System.out.println("Nombre de requêtes pour dépenser 1 $ : " + nombreRequetes);
    }
}