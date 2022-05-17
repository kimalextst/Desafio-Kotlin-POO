package desafio.produtos

class Refrigerante(
    produto : String = "REFRIGERANTE",
    private var quantidade : Int = 0,
    private var valor : Double = 8.0
) : Produto(produto, quantidade, valor), Bebida {
    override fun modificarQuantidade(quantidade: Int): Int {
        this.quantidade = quantidade
        return this.quantidade
    }

    override fun valorTotal(): Double {
        return quantidade * valor
    }
}