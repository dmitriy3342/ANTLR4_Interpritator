package SIB301;

import SIB301.lib.atoms.EInt;
import SIB301.lib.atoms.EString;
import SIB301.lib.expressions.Expression;
import SIB301.lib.expressions.Plus;
import SIB301.lib.scaner.ExpressionLexer;
import SIB301.lib.scaner.ExpressionParser;
import SIB301.lib.scaner.ExpressionVisitor;
import SIB301.lib.scaner.ExpressionVisitorImpl;
import SIB301.table_ids.TableIDsWithScope;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.lang.reflect.Type;

/**
 * Hello world!
 *
 */
public class App 
{

    public static String getExp1(){
        String expression = "" +

                // ВЕТВЛЕНИЕ
                "  fun(a){       \n"+
                "  if(a<5){      \n"+
                "  print(5);     \n"+
                "  }else{        \n"+
                "  print(6);     \n" +
                "}               \n" +
                "  return 0;              \n" +
                "}                 \n" +
                "t = 3;           \n"+
                "fun(t);             \n"+



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
                "                                                                           \n" ;
        return expression;
    }
    public static void main( String[] args )
    {
        String expression =getExp1();

        String e = "" +


"              arr1 = new List(10,15,20);                                                                                                     \n"+
"              arr1[1];                                                                                                     \n"+
"              print(arr1[2]);                                                                                                     \n"+
"              arr = arr1;                                                                                                     \n"+
"              class mylib{                                                                                                     \n"+
"              arr = new List();                                                                                                     \n"+
"              min(arr){                                                                                                     \n" +
"              tmp1 = arr[0];                                                                                                     \n" +
"                                                                                                                   \n" +
"                                                                                                                   \n" +"                                                                                                                   \n"+
"              return tmp1;                                                                                                     \n"+
"              }                                                                                                     \n"+
"              }                                                                                                     \n"+
"              print(mylib.min(arr1));                                                                                                     \n"+
"                                                                                                                   \n" +
"                                                                                                                   \n" +
"                                                                                                                   \n" +
"                                                                                                                   \n" +"                                                                                                                   \n"+
"                                                                                                                   \n"+
"                                                                                                                   \n"+
"                                                                                                                   \n"+
"                                                                                                                   \n" +
"                                                                                                                   \n" +
"                                                                                                                   \n" +
"                                                                                                                   \n" +"                                                                                                                   \n"+
"                                                                                                                   \n"+
"                                                                                                                   \n"+
"                                                                                                                   \n"+
"                                                                                                                   \n" +
"                                                                                                                   \n" +
"                                                                                                                   \n" +
"                                                                                                                   \n" +"                                                                                                                   \n"+
"                                                                                                                   \n"+
"                                                                                                                   \n"+
"                                                                                                                   \n"+
"                                                                                                                   \n" +
"                                                                                                                   \n" +
"                                                                                                                   \n" +
"                                                                                                                   \n" +"                                                                                                                   \n"+
"                                                                                                                   \n"+
"                                                                                                                   \n"+
"                                                                                                                   \n"+
"                                                                                                                   \n" +
"                                                                                                                   \n" +
"                                                                                                                   \n" +
"                                                                                                                   \n" +"                                                                                                                   \n"+
"                                                                                                                   \n"+
"                                                                                                                   \n"+
"                                                                                                                   \n"+
"                                                                                                                   \n" +
"                                                                                                                   \n" +
"                                                                                                                   \n" +
"                                                                                                                   \n" +"                                                                                                                   \n"+
"                                                                                                                   \n"+
"                                                                                                                   \n"+
"                                                                                                                   \n"+
"                                                                                                                   \n" +
"                                                                                                                   \n" +
"                                                                                                                   \n" +
"                                                                                                                   \n" +
"                                                                                                                   \n"+
"                                                                                                                   \n"+
"\n" ;

                //Оптимизация ))
                while (expression.contains("  ")){
                    expression = expression.replace("  "," ");
                }

                ANTLRInputStream in = new ANTLRInputStream(expression);
        ExpressionLexer lexer = new ExpressionLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExpressionParser parser = new ExpressionParser(tokens);

        ExpressionParser.StartContext progeContext = parser.start();

        ExpressionVisitor visitor = new ExpressionVisitorImpl();

        visitor.visit(progeContext);







//        TableIDsWithScope<Expression> tableIDWithScope = new TableIDsWithScope<>(100);
//
//
//        tableIDWithScope.put("name1", new EInt(10));
//        tableIDWithScope.put("scope::scope2::name2", new EInt(20));
//        tableIDWithScope.put("scope::scope2::name1",  new EInt(30));
//
//        System.out.println("name1 : " + tableIDWithScope.get("name1"));
//        System.out.println("scope::scope2::name2 : " + tableIDWithScope.get("scope::scope2::name2"));
//        System.out.println("scope::scope2::name1 : " + tableIDWithScope.get("scope::scope2::name1"));
//
//        System.out.println("");
//        System.out.println("remove : " + "scope::scope2::name1");
//        tableIDWithScope.remove("scope::scope2::name1");
//        System.out.println("");
//
//        System.out.println("name1 : " + tableIDWithScope.get("name1"));
//        System.out.println("scope::scope2::name2 : " + tableIDWithScope.get("scope::scope2::name2"));
//        System.out.println("scope::scope2::name1 : " + tableIDWithScope.get("scope::scope2::name1"));
//
//        System.out.println("");
//        System.out.println("remove : " + "name1");
//        tableIDWithScope.remove("name1");
//        System.out.println("");
//
//        System.out.println("name1 : " + tableIDWithScope.get("name1"));
//        System.out.println("scope::scope2::name2 : " + tableIDWithScope.get("scope::scope2::name2"));
//        System.out.println("scope::scope2::name1 : " + tableIDWithScope.get("scope::scope2::name1"));

    }


}
