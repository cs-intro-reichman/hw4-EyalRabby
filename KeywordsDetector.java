public class KeywordsDetector {
    public static void main(String[] args) {
        String[] sentences = {
            "Our product will transform the market",
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies",
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry",
            "The team showed great Synergy in the last project",
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift",
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "Paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }
    
    public static String lowerCase(String str) {
        String LowerCaseString = "";

        for (int i = 0; i < str.length(); i++){
                int C = str.charAt(i);

            if ( C >= 65 && C <= 90) {
                LowerCaseString += (char)(C + 32);
            } else {
                LowerCaseString += (char)C; 
            }
        }
        return LowerCaseString;        
    }
    public static boolean contains(String str1, String str2) {
        if (str2.isEmpty()) {
            return true;
        }
        for (int i = 0; i <= str1.length() - str2.length(); i++) {
            if (str1.charAt(i) == str2.charAt(0)) {
                for (int j = 0; j < str2.length(); j++) {
                    if (str1.charAt(i + j) != str2.charAt(j)) {
                        return false;
                    }
                }
                return true;  
                }
            }
        return false;
    }
    // Iterates through all the sentences.
    // If a sentence contains one or more of the kewords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
        for (int i = 0; i < sentences.length; i++) {
            String currentSentence = lowerCase(sentences[i]);
            for (int j = 0; j < keywords.length; j++){
                String currentWord = lowerCase(keywords[j]);
                if (contains(currentSentence, currentWord)) {
                System.out.println(sentences[i]);
                break;
                }
            }
        }
    }
}