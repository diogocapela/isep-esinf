
package PL;

/**
 *
 * @author DEI-ESINF
 */
public class TextWord implements Comparable<TextWord>{
    
    private String word;
    private int ocorrences;
    
    public TextWord(String word, int ocorrences){
        setWord(word,ocorrences);
    }
    
    public void setWord(String word, int ocorrences){
        this.word=word;
        this.ocorrences=ocorrences;
    }
    public void incOcorrences(){
        this.ocorrences++;
    }
    public String getWord(){
        return word;
    }
    public int getOcorrences(){
        return ocorrences;
    }

    @Override
    public int compareTo(TextWord o) {
        return word.compareTo(o.getWord());
    }
    
    public String toString(){
    return "<"+word+">:"+ocorrences;
}
}
