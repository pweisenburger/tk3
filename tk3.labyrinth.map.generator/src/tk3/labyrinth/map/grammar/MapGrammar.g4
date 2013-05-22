grammar MapGrammar;

@parser::header {
    package tk3.labyrinth.map.generator.grammar;
}
@lexer::header {
    package tk3.labyrinth.map.generator.grammar;
}

field : FIELD name door* button* room+ ;
name : NAME'='STRING ;
door : DOOR id door_goal ;
door_goal : GOAL'='id ;
button : BUTTON id activate ;
activate : ACTIVATE'='id ;
room : ROOM id type contain_doors contain_buttons; 
contain_doors : DOOR'='id (','id)* | '' ;
contain_buttons : BUTTON'='id(','id)* | '' ;
type : ( TYPE'='(START|FINISH) | max_player | '') ;
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