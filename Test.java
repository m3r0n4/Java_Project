public class Test {
    public static void main(String[] args){
        APIExamTTS mp3File = new APIExamTTS();
        String correct = "맞췄습니다!";
        mp3File.makeTTS(correct, "Correct");
        mp3File.makeTTS("틀렸습니다.", "Incorrect");        
    }
    
}
