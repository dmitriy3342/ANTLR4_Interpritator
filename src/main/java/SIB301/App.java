package SIB301;

import SIB301.lib.scaner.ExpressionLexer;
import SIB301.lib.scaner.ExpressionParser;
import SIB301.lib.scaner.ExpressionVisitor;
import SIB301.lib.scaner.ExpressionVisitorImpl;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.*;

public class App {

    private static String getSourceInFile(File file){
        String source = "";
        FileInputStream fis = null;
        try {
            fis  = new FileInputStream(file);


            InputStreamReader isr = new InputStreamReader(fis,"utf-8");
            StringBuilder sb = new StringBuilder();
            int c;
            while((c=isr.read())!=-1){

                sb.append((char)c);
            }
            isr.close();
            source = sb.toString();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if( fis!= null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return source;
    }

    private static void start(String source){

        //Оптимизация ))
        while (source.contains("  ")) {
            source = source.replace("  ", " ");
        }
        while (source.contains("\t\t")) {
            source = source.replace("\t\t", "\t");
        }
        source = source.replace("\\n", "\n");
        source = source.replace("\\t", "\t");


        //Инициализация ядра и запуск
        ANTLRInputStream in = new ANTLRInputStream(source);
        ExpressionLexer lexer = new ExpressionLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExpressionParser parser = new ExpressionParser(tokens);

        ExpressionParser.StartContext progeContext = parser.start();

        ExpressionVisitor visitor = new ExpressionVisitorImpl();

        visitor.visit(progeContext);
    }

    public static void main(String[] args) {
        //   String expression = getExp1();



//        final String FILE_NAME = "test1.universal";
//        final String FILE_NAME = "test2.universal";
        final String FILE_NAME = "test3.universal";
        String source = getSourceInFile(new File("code" + File.separator + FILE_NAME));
        if(!source.isEmpty())
            start(source);
    }
}
