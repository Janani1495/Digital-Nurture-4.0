package DesignPatternsAndPrinciples.FactoryMethodPatternExample;

public class PdfFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}
