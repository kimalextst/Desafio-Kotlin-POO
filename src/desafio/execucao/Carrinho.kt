package desafio.execucao

import desafio.produtos.*

class Carrinho {
    private val carrinho : HashMap <Int, Produto> = HashMap()
    private var codigo = 0
    private var valorTotalCarrinho = 0.0

    fun acessarValorTotal(): Double {
        return valorTotalCarrinho
    }

    fun adicionarProduto(produto: Produto): Int {
        codigo += 111
        valorTotalCarrinho += produto.valorTotal()
        carrinho[codigo] = produto
        return codigo
    }

    fun removerProduto(){
        try {
            println("---------------------------------------------")
            println("Qual o código do produto?")
            println("---------------------------------------------")
            val codigo = readln().toInt()
            if (carrinho.containsKey(codigo)){
                valorTotalCarrinho -= carrinho[codigo]?.valorTotal()!!
                carrinho.remove(codigo)
                println("---------------------------------------------")
                println("Produto removido com sucesso")
                println("---------------------------------------------")
                mostrarProdutos()
            } else {
                println("---------------------------------------------")
                println("Código não encontrado")
                println("---------------------------------------------")
            }
        } catch (ex : Exception){
            println("---------------------------------------------")
            println("Formato inválido, você deve informar um número")
            println("---------------------------------------------")

            removerProduto()
        }
    }

    fun mostrarProdutos(){
        println("---------------------------------------------")
        valorTotalCarrinho = 0.0
        carrinho.forEach{ map ->
            valorTotalCarrinho += map.value.valorTotal()
            println("Código: ${map.key}")
            println("${map.value.mostrarProduto()}")
        }
        println("---------------------------------------------")
        println("Valor total no carrinho: R$$valorTotalCarrinho")
        println("---------------------------------------------")
    }

    fun editarCarrinho(objetoProdutoParametro: Produto){
        var objetoProduto = objetoProdutoParametro

        try {
            println("---------------------------------------------")
            println("Qual o código do produto?")
            println("---------------------------------------------")
            val codigo = readln().toInt()

            if (carrinho.containsKey(codigo)){
                valorTotalCarrinho -= carrinho[codigo]?.valorTotal()!!
                val quantidade = carrinho[codigo]?.quantidade()
                if (quantidade != null) {
                    val qntd = carrinho[codigo]?.modificarQuantidade(quantidade)
                    when(carrinho[codigo]?.produto){
                        "X-BURGER" -> objetoProduto = Xburger(quantidade = qntd!!)
                        "X-SALADA" -> objetoProduto = Xsalada(quantidade = qntd!!)
                        "REFRIGERANTE" -> objetoProduto = Refrigerante(quantidade = qntd!!)
                        "SUCO" -> objetoProduto = Suco(quantidade = qntd!!)
                    }

                    carrinho[codigo] = objetoProduto
                }

                valorTotalCarrinho += carrinho[codigo]?.valorTotal()!!
                mostrarProdutos()
            } else {
                println("---------------------------------------------")
                println("Código não encontrado")
                println("---------------------------------------------")
            }
        } catch (ex : Exception){
            println("---------------------------------------------")
            println("Formato inválido, você deve informar um número")
            println("---------------------------------------------")

            editarCarrinho(objetoProduto)
        }
    }
}

