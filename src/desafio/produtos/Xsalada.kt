package desafio.produtos

class Xsalada(
    produto : String = "X-SALADA",
    private var quantidade : Int = 0,
    private var valor : Double = 12.0
) : Produto(produto, quantidade, valor), Lanche {
    override fun modificarQuantidade(quantidade: Int): Int {
        this.quantidade = quantidade
        return this.quantidade
    }

    override fun valorTotal(): Double {
        return quantidade * valor
    }
}