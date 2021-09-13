package com.example.etest.controller.form;

public class RemoverQuestaoAvaliacaoForm {

    private Long idAvaliacao;
    private Long idQuestao;

    public RemoverQuestaoAvaliacaoForm(Long idAvaliacao, Long idQuestao) {
        this.idAvaliacao = idAvaliacao;
        this.idQuestao = idQuestao;
    }

    public Long getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(Long idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public Long getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(Long idQuestao) {
        this.idQuestao = idQuestao;
    }
}
