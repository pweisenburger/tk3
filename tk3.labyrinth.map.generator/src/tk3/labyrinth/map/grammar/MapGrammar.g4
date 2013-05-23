grammar MapGrammar;

@parser::header {
    package tk3.labyrinth.map.grammar;
}
@lexer::header {
    package tk3.labyrinth.map.grammar;
}

field : FIELD name door* button* room+ ;
name : NAME'='STRING ;
door : DOOR id door_goal ;
door_goal : GOAL'='STRING ;
button : BUTTON id activate ;
activate : ACTIVATE'='STRING ;
room : ROOM name room_attr contain_doors contain_buttons ; 
contain_doors : DOOR'='STRING (','STRING)* | '' ;
contain_buttons : BUTTON'='STRING(','STRING)* | '' ;
room_attr : type | max_player | '' ;
type : TYPE'='start|finish ;
start : START ;
finish : FINISH ;
max_player : MAXIMUM'='N ;
id : ID'='STRING ;

TYPE : 'type' ;
MAXIMUM : 'max' ;
NAME : 'name' ;
ID : 'id' ;
ACTIVATE : 'activate' ;
GOAL : 'goal' ;
FIELD : 'field' ;
DOOR : 'door' ;
BUTTON : 'button' ;
ROOM : 'room' ;
START : 'start' ;
FINISH : 'finish' ;
STRING : [a-z|0-9]+ ;
N :[1-9] [0-9]* ;
WS : [ \t\n\r]+ -> skip ;