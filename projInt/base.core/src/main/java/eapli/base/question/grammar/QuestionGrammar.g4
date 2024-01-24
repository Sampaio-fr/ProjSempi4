grammar QuestionGrammar;
options { caseInsensitive=true;}

start: question EOF;

question: ( matching_question
          | multiple_choice_question
          | open_question
          | missing_words_question
          | true_false_question);

question_header: SENTENCE
                 END_SYMBOL;

question_grade: QUESTION_DEFINITION_SYMBOL
                INT
                END_SYMBOL;

matching_question: matching_question_definition
                   question_grade
                   question_header
                   matching_answers;

multiple_choice_question: multiple_choice_definition
                          question_grade
                          question_header
                          answer_list;

open_question: open_questions_definition
               question_grade
               question_header
               open_questions_answer_list;

missing_words_question: missing_words_definition
                        question_grade
                        question_header
                        (subquestion answer_list)+;

true_false_question: true_false_definition
                     question_grade
                     question_header
                     (subquestion true_false_answer)+;

matching_question_definition: QUESTION_DEFINITION_SYMBOL
                              'matching'
                              END_SYMBOL;

multiple_choice_definition: QUESTION_DEFINITION_SYMBOL
                            'multiple choice'
                            END_SYMBOL;

open_questions_definition: QUESTION_DEFINITION_SYMBOL
                           ('short'
                           | 'numerical')
                           END_SYMBOL;

missing_words_definition: QUESTION_DEFINITION_SYMBOL
                          'missing words'
                          END_SYMBOL;

true_false_definition: QUESTION_DEFINITION_SYMBOL
                       'true/false'
                       END_SYMBOL;

subquestion: SENTENCE ANSWER_SPACING WHITESPACE*;

wrong_answer: WRONG_ANSWER_SYMBOL SENTENCE END_SYMBOL feedback?;

correct_answer: CORRECT_ANSWER_SYMBOL SENTENCE END_SYMBOL feedback?;

answer_list: OPEN_BRACKET
             ( wrong_answer
             | correct_answer)+
             CLOSING_BRACKET
             NEWLINE*?;

open_questions_answer: CORRECT_ANSWER_SYMBOL
                       PERCENTAGE
                       INT
                       PERCENTAGE
                       SENTENCE
                       END_SYMBOL
                       feedback?;

open_questions_answer_list: OPEN_BRACKET
                            open_questions_answer+
                            CLOSING_BRACKET
                            NEWLINE*?;

matching_answers: OPEN_BRACKET
                  (SENTENCE END_SYMBOL
                  CORRECT_ANSWER_SYMBOL
                  SENTENCE END_SYMBOL
                  feedback?)+
                  CLOSING_BRACKET
                  NEWLINE*?;

true_false_answer: OPEN_BRACKET
                   true_false
                   feedback?
                   CLOSING_BRACKET
                   NEWLINE*?;

true_false: CORRECT_ANSWER_SYMBOL ('T' | 'F' | 'TRUE' | 'FALSE') END_SYMBOL;

feedback: FEEDBACK_SYMBOL (SENTENCE NEWLINE*)+ END_SYMBOL;

fragment DIGIT: [0-9];
fragment LOWERCASE: [a-z];
fragment UPPERCASE: [A-Z];

QUESTION_DEFINITION_SYMBOL: '#' (WHITESPACE | NEWLINE)*;
PERCENTAGE: '%' (WHITESPACE | NEWLINE)*;
OPEN_BRACKET: '{' (WHITESPACE | NEWLINE)*;
CLOSING_BRACKET: '}';
ANSWER_SPACING: '___';
CORRECT_ANSWER_SYMBOL: '=' (WHITESPACE | NEWLINE)*;
WRONG_ANSWER_SYMBOL: '~' (WHITESPACE | NEWLINE)*;
FEEDBACK_SYMBOL: '>' (WHITESPACE | NEWLINE)*;
END_SYMBOL: ';' (WHITESPACE | NEWLINE)*;
INT: DIGIT+;
PUNCTUATION: [.,:!?];
OPERATIONS: [+*/=>];
SENTENCE: (WORD | INT) (WORD | WHITESPACE | INT | PUNCTUATION | OPERATIONS)+;
WORD: (LOWERCASE | UPPERCASE)+;
WHITESPACE: (' ' | '\t') -> skip;
NEWLINE: ('\n' | '\r');