package SIB301.lib.expressions;


import SIB301.lib.atoms.None;
import SIB301.lib.expressions.array.EArray;

import java.util.ArrayList;
import java.util.List;

public abstract class Expression {
   public  Expression interpreter(){
      return new None();
   }


   public String getType(){
      String[] tmp = this.getClass().getName().replace(".", "::").split("::");
      return tmp[tmp.length - 1];
   }


   public Expression clone() {
      return new None();
   }

}
