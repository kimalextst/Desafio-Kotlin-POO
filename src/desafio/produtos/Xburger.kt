package desafio.produtos

class Xburger(
    produto : String = "X-BURGER",
    private var quantidade : Int = 0,
    private var valor : Double = 10.0
) : Produto(produto, quantidade, valor), Lanche {
    override fun modificarQuantidade(quantidade: Int): Int {
        this.quantidade = quantidade
        return this.quantidade
    }

    override fun valorTotal(): Double {
        return quantidade * valor
    }
}