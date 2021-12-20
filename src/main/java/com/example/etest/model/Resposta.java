package com.example.etest.model;

import javax.persistence.*;

@Entity
public class Resposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Questao questao;

    private int correta;

    public Resposta(Long id, Questao questao, int correta) {
        this.id = id;
        this.questao = questao;
        this.correta = correta;
    }

    public Resposta(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public int getCorreta() {
        return correta;
    }

    public void setCorreta(int correta) {
        this.correta = correta;
    }

    public int verificarQuestao(){
        if(this.questao.retornaPosicaoCorreta() == this.correta){
            switch (this.questao.getNivel()){
                case 1: return 1;
                case 2: return 2;
                case 3: return 3;
            }
        }
        return 0;
    }
}
