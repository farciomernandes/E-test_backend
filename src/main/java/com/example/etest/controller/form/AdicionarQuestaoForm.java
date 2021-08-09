package com.example.etest.controller.form;


public class AdicionarQuestaoForm {

    private Long idQuestao;
    private Long idAvaliacao;

    public AdicionarQuestaoForm(Long idQuestao, Long idAvaliacao) {
        this.idQuestao = idQuestao;
        this.idAvaliacao = idAvaliacao;
    }

    public Long getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(Long idQuestao) {
        this.idQuestao = idQuestao;
    }

    public Long getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(Long idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }
}
