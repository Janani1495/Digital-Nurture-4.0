package DesignPatternsAndPrinciples.FactoryMethodPatternExample;

public class WordFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}
