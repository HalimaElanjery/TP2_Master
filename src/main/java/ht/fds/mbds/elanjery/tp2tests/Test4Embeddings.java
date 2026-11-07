package ht.fds.mbds.elanjery.tp2tests;

import dev.langchain4j.data.embedding.Embedding;
import dev.langchain4j.model.embedding.EmbeddingModel;
// BGE mis en commentaire à cause du conflit avec easy-rag (Test 5)
// import dev.langchain4j.model.embedding.onnx.bgesmallenv15.BgeSmallEnV15EmbeddingModel;
import dev.langchain4j.model.google.genai.GoogleGenAiEmbeddingModel;
import dev.langchain4j.store.embedding.CosineSimilarity;

import java.time.Duration;

public class Test4Embeddings {

    public static void main(String[] args) {

        String cle = System.getenv("GEMINI_KEY");

        // Modèle 1 : intégré à LangChain4j (mis en commentaire, voir Test 5)
        // EmbeddingModel modeleLocal = new BgeSmallEnV15EmbeddingModel();

        // Modèle 2 : externe (Google)
        EmbeddingModel modeleGoogle = GoogleGenAiEmbeddingModel.builder()
                .apiKey(cle)
                .modelName("gemini-embedding-001")
                .taskType(GoogleGenAiEmbeddingModel.TaskTypeEnum.SEMANTIC_SIMILARITY)
                .timeout(Duration.ofSeconds(10))
                .build();

        String[][] couples = {
                {"Le chat dort sur le canapé.", "Un félin fait la sieste sur le sofa."},
                {"J'adore ce film.", "Je déteste ce film."},
                {"Il fait très chaud aujourd'hui.", "La température est élevée en ce moment."},
                {"Je mange une pomme.", "Le moteur de la voiture est en panne."},
                {"Paris est la capitale de la France.", "La capitale française est Paris."},
                {"Le football est un sport populaire.", "La cuisine italienne est délicieuse."}
        };

        for (String[] couple : couples) {
            System.out.println("Phrase 1 : " + couple[0]);
            System.out.println("Phrase 2 : " + couple[1]);
            // System.out.printf("  BGE intégré : %.4f%n", similarite(modeleLocal, couple[0], couple[1]));
            System.out.printf("  Google      : %.4f%n%n", similarite(modeleGoogle, couple[0], couple[1]));
        }
    }

    private static double similarite(EmbeddingModel modele, String s1, String s2) {
        Embedding e1 = modele.embed(s1).content();
        Embedding e2 = modele.embed(s2).content();
        return CosineSimilarity.between(e1, e2);
    }
}