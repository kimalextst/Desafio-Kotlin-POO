package desafio.produtos

abstract class Produto (
    val produto : String,
    private val quantidade : Int,
    private val valor : Double
        ) {
    open fun mostrarProduto(){
        println("---------------------------------------------")
        println("Produto: $produto")
        println("Quantidade: $quantidade")
        println("Valor unitário: R$$valor")
        println("Valor total: R$${valor * quantidade}")
        println("---------------------------------------------")
    }

    fun quantidade(): Int {
        var quantidade = 0
        try {
            println("---------------------------------------------")

            println("Qual a quantidade desejada?")
            quantidade = readln().toInt()
            println("---------------------------------------------")

        } catch (ex : Exception){
            println("---------------------------------------------")
            println("Formato inválido, você deve informar um número")
            println("---------------------------------------------")

            quantidade()
        }
        return quantidade
    }

    abstract fun modificarQuantidade(quantidade: Int): Int
    abstract fun valorTotal(): Double
}