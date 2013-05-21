grammar MapGrammar;

@parser::header {
    package tk3.labyrinth.map.generator.grammar;
}
@lexer::header {
    package tk3.labyrinth.map.generator.grammar;
}

field : 'field' 'name='ID door* button* room (',' room)* ;
room : 'room' 'id='ID ('start' | 'finish' | 'max='N | '') ('door='ID (','ID)* | '') ('button='ID(','ID)* | '');
door : 'door' 'id='ID 'goal='ID ;
button : 'button' 'id='ID 'activate='ID ;
ID : [a-z|0-9]+ ;
N :[1-9] [0-9]* ;
WS : [ \t\n\r]+ -> skip ;