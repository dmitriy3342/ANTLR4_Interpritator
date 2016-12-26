grammar Expression;


//Parser Rules
start: exprBlock ;

exprBlock:
     exprLine
     | SEP*  exprLine  ( SEP* NEWLINE SEP*   exprLine  SEP*)+
     ;

exprLine:
        expr ';'*
    ;

expr:
    |   SEP exprCenter = expr
    |   exprCenter = expr SEP

    |   inicialClass
    |   initaialFunction
    |   objectAssignment
    |   callFunction
    |   objectValue
    |   ifalse



//    |   expr (NEWLINE expr)+
	|   left = expr op = ('*'|'/') right = expr
    |	left = expr op = ('+'|'-') right = expr
    |	left = expr op = ('=='|'<'|'>') right = expr
    |	str = expr SEP* '[' SEP* startSubstring = NUMBER SEP*',' SEP* finishSubstring = NUMBER SEP* ']'
    |   LPAM exprCenter = expr RPAM

    |   print
    |	atom


//    |   nocl = expr cl =';'
    ;

print:
        'print(' expr ')' ;




objectAssignment : //Create element
        SEP* identificator SEP*  '=' expr
        ;

objectValue : // Get element
        SEP* identificator SEP*
    ;



initaialFunction :  SEP* functionName = identificator '(' SEP* ( params SEP*)* ( ',' params SEP*)*    ')'   '{' ( SEP  NEWLINE)*
                    ( SEP* expr ';' SEP* NEWLINE*)*
                    SEP* 'return' SEP+  myreturn ';'  NEWLINE*
                     SEP* NEWLINE* SEP* '}'
;

myreturn : expr;

callFunction :  identificator '(' +  (SEP* params SEP*)* ( ',' params SEP*)?    ')'
;


params :
            identificator
;


ifalse :    'if' SEP* '(' SEP* condition SEP* ')' SEP* NEWLINE* SEP*
            '{' SEP* NEWLINE* SEP*
             ( SEP* ifblock ';' SEP* NEWLINE*)*
             SEP* NEWLINE* SEP* '}'SEP* NEWLINE* SEP*

             ('else'  SEP* NEWLINE* SEP*
                         '{' SEP* NEWLINE* SEP*
                          ( SEP* elseblock ';' SEP* NEWLINE*)*
                          SEP* NEWLINE* SEP* '}')?

;

ifblock : expr;

elseblock: expr;

condition : expr;



inicialClass :  SEP* 'class' SEP+ className = identificator SEP+ NEWLINE*
                '{' NEWLINE*
                    (SEP* bodyClass NEWLINE*  SEP*)*
                '}'
;

bodyClass : objectAssignment SEP* ';'
        |    initaialFunction

;

identificator : IDENTIFIER;

atom :
        NUMBER
    |   STRING
    |   BOOLEAN
;



//Lexer Rules



IDENTIFIER : [a-zA-Z_]+[a-zA-Z0-9_]*;

STRING : '"'.*?'"';

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

CUSTOM : NEWLINE | SEP;

NEWLINE : [\r\n]+ ;
SEP : [ \t\r\n]+? ;





//WS  :  [ \t\r\n\u000C]+ -> skip
//    ;



COMMENT
    :   '/*' .*? '*/' -> skip
    ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> skip
    ;