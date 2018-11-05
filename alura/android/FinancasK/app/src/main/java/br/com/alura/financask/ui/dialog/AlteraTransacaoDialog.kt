package br.com.alura.financask.ui.dialog

import android.content.Context
import android.view.ViewGroup
import br.com.alura.financask.R
import br.com.alura.financask.extension.formataParaBrasileiro
import br.com.alura.financask.model.Tipo
import br.com.alura.financask.model.Transacao

class AlteraTransacaoDialog(viewGroup: ViewGroup,
                            private val context: Context) : FormularioTransacaoDialog(context, viewGroup) {
    override val tituloBotaoPositivo: String
        get() = "Alterar"

    override fun tituloPor(tipo: Tipo): Int {
        if (tipo == Tipo.RECEITA) {
            return R.string.altera_receita
        }
        return R.string.altera_despesa
    }

    fun chama(transacao: Transacao, delegate: (transacao: Transacao) -> Unit) {
        super.chama(transacao.tipo, delegate)
        inicializaCampos(transacao)
    }

    private fun inicializaCampos(transacao: Transacao) {
        inicializaCampoValor(transacao)
        inicializaCampoData(transacao)
        inicializaCampoCategoria(transacao)
    }

    private fun inicializaCampoCategoria(transacao: Transacao) {
        val categoriasRetornadas = context.resources.getStringArray(categoriasPor(transacao.tipo))
        val posicaoCategoria = categoriasRetornadas.indexOf(transacao.categoria)
        campoCategoria.setSelection(posicaoCategoria, true)
    }

    private fun inicializaCampoData(transacao: Transacao) {
        campoData.setText(transacao.data.formataParaBrasileiro())
    }

    private fun inicializaCampoValor(transacao: Transacao) {
        campoValor.setText(transacao.valor.toString())
    }

}