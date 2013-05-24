grammar MapGrammar;

@parser::header {
    package tk3.labyrinth.map.grammar;
}
@lexer::header {
    package tk3.labyrinth.map.grammar;
}

field : 'field' name door+ button* room+ ;
name : NAME'='STRING ;

door : 'door' id door_goal ;
door_goal : 'goal='STRING ;

button : 'button' id activate ;
activate : 'activate='STRING ;

room : 'room' name room_attr? doors buttons? ; 
doors : 'doors='list ;
buttons : 'buttons='list ;
list : STRING (','STRING)* ;
room_attr : (type | max_player) ;
type : TYPE'=' (start | finish) ;
start : START ;
finish : FINISH ;
max_player : 'max='STRING ;
id : ID'='STRING ;

TYPE : 'type' ;
NAME : 'name' ;
ID : 'id' ;
START : 'start' ;
FINISH : 'finish' ;
STRING : [a-z|0-9]+ ;

WS : [ \t\n\r]+ -> skip ;