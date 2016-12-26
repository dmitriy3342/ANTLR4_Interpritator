package SIB301.lib.expressions;


import SIB301.lib.atoms.None;

public abstract class Expression {
   public  Expression interpreter(){
      return new None();
   }
}
