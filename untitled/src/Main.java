;Cliente	           |

        (deftemplate Cliente
        (slot problema_motor)
        (slot tem_criancas)
        (slot tem_preparacao)
        (slot quer_desafio)

        (deftemplate Trilha
        (slot tri))


        (defrule GetProblemaMotor
        (declare (salience 9))
        =>
        (printout t "Voce tem algum problema motor? (yes/no)" crlf)
        (bind ?resposta (read))
        (assert (Cliente (problema_motor ?resposta))))

        (defrule GetCrianças
        (declare (salience 9))
        =>
        (printout t "Voce vai levar crianças?(yes/no)")
        (bind ?resposta (read))
        (assert (Cliente (tem_criancas ?resposta))))


        (defrule GetPreparaçao
        (declare (salience 9))
        =>
        (printout t "Voce tem preparação fisica?(yes/no)")
        (bind ?resposta (read))
        (assert (Cliente (tem_preparacao ?resposta))))

        (defrule GetDesafio
        (declare (salience 9))
        =>
        (printout t "Voce quer um desafio?(yes/no)")
        (bind ?resposta (read))
        (assert (Cliente (quer_desafio ?resposta))))


        ;Regras pra escolher a trilha


        (defrule Carteiro
        (and(Cliente (tem_criancas no))
        (Cliente (problema_motor no))(Cliente (tem_preparacao yes))
        (Cliente (quer_desafio no)))
        =>
        (assert(Restaurante(rest mal_passada )))
        (printout t "Trilha Sugerida: Trilha do Carteio" crlf ))


        (defrule Ascensao_piquinho
        (and(Cliente (tem_criancas no))
        (Cliente (problema_motor no))(Cliente (tem_preparacao yes))
        (Cliente (quer_desafio yes)))
        =>
        (assert(Restaurante(rest mal_passada )))
        (printout t "Trilha Sugerida: Trilha da Ascenção ao Piquinho" crlf ))


        (defrule Aldeia_magica
        (and(Cliente (tem_criancas yes))
        (Cliente (problema_motor yes))(Cliente (tem_preparacao no))
        (Cliente (quer_desafio no)))
        =>
        (assert(Restaurante(rest mal_passada )))
        (printout t "Trilha Sugerida: Trilha da Aldeia Magica" crlf ))


        (defrule vales_suspensos
        (and(Cliente (tem_criancas yes))
        (Cliente (problema_motor yes))(Cliente (tem_preparacao yes))
        (Cliente (quer_desafio no)))
        =>
        (assert(Restaurante(rest mal_passada )))
        (printout t "Trilha Sugerida: Trilha dos 7 Vales Suspensos" crlf ))


        (defrule Aldeia_magica
        (and(Cliente (tem_criancas yes))
        (Cliente (problema_motor no))(Cliente (tem_preparacao yes))
        (Cliente (quer_desafio yes)))
        =>
        (assert(Restaurante(rest mal_passada )))
        (printout t "Trilha Sugerida: Trilha das Escarpas da Maceira" crlf ))
