grammar MapGrammar;

@parser::header {
    package tk3.labyrinth.map.generator.grammar;
}
@lexer::header {
    package tk3.labyrinth.map.generator.grammar;
}

field : 'field' ID room+;
room : 'room' ID door+ button*;
door : 'door' ID door ;
button : 'button' ID door ;
ID : [a-z|0-9]+ ;