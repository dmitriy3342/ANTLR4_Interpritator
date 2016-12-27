package SIB301;

import SIB301.lib.scaner.ExpressionLexer;
import SIB301.lib.scaner.ExpressionParser;
import SIB301.lib.scaner.ExpressionVisitor;
import SIB301.lib.scaner.ExpressionVisitorImpl;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class App {

    private static String getExp1() {
        String expression = "" +

                // ВЕТВЛЕНИЕ
                "  fun(a){       \n" +
                "  if(a<5){      \n" +
                "  print(5);     \n" +
                "  }else{        \n" +
                "  print(6);     \n" +
                "}               \n" +
                "  return 0;              \n" +
                "}                 \n" +
                "t = 3;           \n" +
                "fun(t);             \n" +


                "          print(\" Старт программы \");                                                                 \n" +
                "          class mailclass {                                                                 \n" +
                "                                                                           \n" +
                "                  a = 10;                                                         \n" +
                "                  b = 30;                                                         \n" +
                "               method1(){                                                            \n" +
                "                                                                           \n" +
                "                   return a+b;                                                        \n" +
                "                                                                           \n" +
                "               }                                                            \n" +
                "          }                                                                 \n" +
                "          print(mailclass.method1());                                                                 \n" +
                "          print(mailclass.b);                                                                 \n" +
                "          s1 = \"s\";                                                                 \n" +
                "          s2 = \"asdfg\";                                                                 \n" +
                "          forearch( s1 : s2 ) {                                                                 \n" +
                "          print(s1);                                                                 \n" +
                "          }                                                                 \n" +
//                "      СОЗДАНИЕ КЛАССА                                                                     \n" +
                "           class mylib{                                                                        \n" +
                "             sort(str){                                                                   \n" +
                "                tmp =  \" GG \";                                                             \n" +
                "                return str + tmp;                                                               \n" +
                "              }                                                                 \n" +
                "                                                                               \n" +
                "            }                                                            \n" +
                "             temp = \"Простая строчка\";                                                           \n" +
                "            print(mylib.sort(temp));                                                               \n" +
                "                                                                         \n" +
                "             arr1 = new List(10,30);                                                            \n" +
                "              print(arr1[0] + arr1[1]);                                                           \n" +
//                "         Вложенный массив                                  \n" +
                "               i = 0;                                                          \n" +
                "               forearch(i:5){                                                          \n" +
                "                                                                       \n" +
                "                  jj=i;                                                       \n" +
                "                  forearch(jj:7){                                                       \n" +
                "                                                                       \n" +
                "                       print(i + \" : \" + jj);                                                  \n" +
                "                 }                                                      \n" +
                "                                                                       \n" +
                "                }                                                         \n" +
                "                                                                         \n" +
                "                                                                         \n" +
                "                                                                         \n" +
                "                                                                         \n" +
                "                                                                         \n" +
                "                                                                         \n" +
                "                                                                         \n" +
                "                                                                           \n";
        return expression;
    }

    public static void main(String[] args) {
        String expression = getExp1();

        String ex = "" +
                "                                                                                                   \n" +
                "       a=10;                                                                                            \n" +
                "       print(a);                                                                                            \n" +
                "                                                                                                   \n" +
                "       fun1(param){                                                                                            \n" +
                "           forearch(0:p){                                                                                               \n" +
                "                                                                                                          \n" +
                "           print(\"*\");                                                                                               \n" +
                "           }                                                                                              \n" +
                "       return 0;                                                                                            \n" +
                "       }                                                                                            \n" +
                "        p=4;                                                                                          \n" +
                "       fun1(p);                                                                                            \n" +
                "           p=10;                                                                                          \n" +
                "       fun1(p);                                                                                          \n" +
                "                                                                                                   \n" +
                "       if(p<5){                                                                                            \n" +
                "       print(\"Выводим информацию о событии p<5\");                                                                                            \n" +
                "       }else{                                                                                            \n" +
                "         print(\"Выводим информацию о событии p>5\");                                                                                           \n" +
                "        }                                                                                           \n" +
                "                                                                                                   \n" +
                "                                                                                                   \n" +
                "                                                                                                   \n" +
                "          class myClass{                                                                                       \n" +
                "                                                                                                 \n" +
                "            sumStr(str1,str2){                                                                                       \n" +
                "                                                                                             \n" +
                "               return str1 + str2;                                                                             \n" +
                "             }                                                                                               \n" +
                "                                                                                                             \n" +
                "           }                                                                                                 \n" +
                "                                                                                                   \n" +
                "            str1 = \"Hello \";                                                                                       \n" +
                "            str2 = \"World \";                                                                                       \n" +
                "            print(myClass.sumStr(str1,str2));                                                                                       \n" +
                "                                                                                                   \n" +
                "                                                                                                   \n" +
                "                                                                                                   \n" +
                "                                                                                                   \n" +
                "                                                                                                   \n" +
                "                                                                                                   \n" +
                "                                                                                                   \n" +
                "                                                                                                 \n" +
                "\n";

        //Оптимизация ))
        while (expression.contains("  ")) {
            expression = expression.replace("  ", " ");
        }

        ANTLRInputStream in = new ANTLRInputStream(expression);
        ExpressionLexer lexer = new ExpressionLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExpressionParser parser = new ExpressionParser(tokens);

        ExpressionParser.StartContext progeContext = parser.start();

        ExpressionVisitor visitor = new ExpressionVisitorImpl();

        visitor.visit(progeContext);
    }
}
