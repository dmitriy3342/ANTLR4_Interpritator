grammar Expression;

//Parser Rules
start: exprBlock ;

exprBlock:
     exprLine
     | SEP*  exprLine  ( SEP* NEWLINE SEP*   exprLine  SEP*)* (NEWLINE | SEP)*
     ;

exprLine:
        expr ';'*
    ;

expr:
    |   SEP exprCenter = expr
    |   exprCenter = expr SEP

//    |   arrayCreate
    |   arrayAssignedItem
    |   arrayGet

    |   inicialClass
    |   initaialFunction
    |   objectAssignment
    |   callFunction
    |   objectValue
    |   getElementWithClass
    |   callMethod
    |   ifalse
    |   forel
    |   whileblock



//    |   expr (NEWLINE expr)+
	|   left = expr op = ('*'|'/') right = expr
    |	left = expr op = ('+'|'-') right = expr
    |	left = expr op = ('=='|'<'|'>') right = expr
    |	str = expr '[' SEP* startSubstring = NUMBER SEP*',' SEP* finishSubstring = NUMBER SEP* ']'
    |   LPAM exprCenter = expr RPAM

    |   print
    |	atom



//    |   nocl = expr cl =';'
    ;

print:
        'print(' expr ')' ;




objectAssignment : //Create element
            SEP* arrayCreate SEP*
        |   SEP* identificator SEP*  '=' expr
        ;

objectValue : // Get element
        SEP* identificator SEP*

    ;



initaialFunction :  ( SEP | NEWLINE)* functionName = identificator '(' SEP* ( params SEP*)* ( ',' params SEP*)*    ')'   '{' ( SEP | NEWLINE)*
                    (( ( SEP | NEWLINE)* expr ';' ( SEP | NEWLINE)*) |
                    ( ( SEP | NEWLINE)* ifalse ( SEP | NEWLINE)*)  |
                     ( ( SEP | NEWLINE)* forel ( SEP | NEWLINE)*))*
                    ( SEP | NEWLINE)* 'return' SEP+  myreturn ';'
                     ( SEP | NEWLINE)* '}'
;

myreturn : expr;

callFunction :  identificator '('  (SEP* params SEP*)* ( ',' params SEP*)?    ')'
;


params :
            identificator
        |   atom
;


ifalse :    'if' SEP* '(' SEP* condition SEP* ')' SEP* NEWLINE* SEP*
            '{' ( SEP | NEWLINE)*
             ( SEP* ifblock ';' ( SEP | NEWLINE)*)*
             ( SEP | NEWLINE)* '}'( SEP | NEWLINE)*

             ('else'  ( SEP | NEWLINE)*
                         '{' ( SEP | NEWLINE)*
                          ( SEP* elseblock ';'( SEP | NEWLINE)*)*
                          ( SEP | NEWLINE)* '}')?

;

ifblock : expr;

elseblock: expr;

condition : expr;


arrayGet : identificator '[' SEP* expr SEP* ']';

arrayCreate : identificator SEP* '=' SEP* 'new' SEP+ 'List('(SEP* params SEP*)* ( ',' params SEP*)* ')';
arrayAssignedItem : identificator '[' SEP* index = expr SEP* ']'SEP* '=' SEP* value = expr;



forel : ( SEP | NEWLINE)* 'forearch' SEP* '('  ( SEP | NEWLINE)* var = params ( SEP | NEWLINE)* ':' ( SEP | NEWLINE)* vars = params  ( SEP | NEWLINE)* ')'( SEP | NEWLINE)*
            '{'( SEP | NEWLINE)*
              ( forelBody )*
              ( SEP | NEWLINE)*
            '}' SEP*
            ;

forelBody :
            ( SEP | NEWLINE)* expr SEP* ';' ( SEP | NEWLINE)*
       |    ( SEP | NEWLINE)* forel SEP*
       ;


whileblock : 'while' SEP* '(' SEP* condition SEP* ')' SEP* NEWLINE* SEP*
                         '{' ( SEP | NEWLINE)*
                          ( SEP* expr ';' ( SEP | NEWLINE)*)*
                          ( SEP | NEWLINE)* '}'( SEP | NEWLINE)*

;

inicialClass :  ( SEP | NEWLINE)* 'class' ( SEP | NEWLINE)* className = identificator ( SEP | NEWLINE)*
                '{' ( SEP | NEWLINE)*
                    (( SEP | NEWLINE)* bodyClass ( SEP | NEWLINE)*)* ( SEP | NEWLINE)*
                '}'
;

bodyClass : objectAssignment SEP* ';'
        |    initaialFunction

;


getElementWithClass : className = identificator '.'  var = identificator ;


callMethod : className = identificator '.' method = identificator '(' +  (SEP* params SEP*)* ( ',' params SEP*)?    ')'
                                           ;


identificator : IDENTIFIER;

atom :
        CHAR
    |   NUMBER
    |   STRING
    |   BOOLEAN

;



//Lexer Rules



IDENTIFIER : [a-zA-Z_]+[a-zA-Z0-9_]*;

STRING : '"'.*?'"';
CHAR : '<<'.?'>>';

BOOLEAN : 'true' |  'false';


PLUS  : '+';
MINUS : '-';
DEL   : '/';
MUL   : '*';

LPAM : '(';
RPAM : ')';

NUMBER :
    INT'.'INT EXP? //1.35,1.35E-9,0.3,-4.5
	|  INT EXP //1e10-3e4
	|  INT //-3,45
	;


fragment EXP: [Ee][+\-]? INT;//\-since-means"range"inside[...]

fragment INT: [0-9]+;

//CUSTOMSEP : [\r\n \t]+?;

NEWLINE : [\r\n]+? ;
SEP : [ \t]+? ;





WS  :  [ \t\r\n\u000C]+ -> skip
    ;


//REP : '  ' -> VARCHAR ;

COMMENT
    :   '/*' .*? '*/' -> skip
    ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> skip
    ;