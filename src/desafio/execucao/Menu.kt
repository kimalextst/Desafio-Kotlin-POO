package desafio.execucao

import desafio.produtos.*
import kotlin.system.exitProcess

class Menu {
    private lateinit var objetoProduto : Produto
    private val objetoCarrinho = Carrinho()

    fun menuInicial(){
        try {
            println("---------------------------------------------")
            println("O que deseja adicionar ao carrinho?")
            println("---------------------------------------------")
            println("[1] Lanche")
            println("[2] Bebida")
            println("[0] Sair do sistema")
            println("---------------------------------------------")

            when(readln().toInt()){
                1 -> menuLanche()
                2 -> menuBebida()
                0 -> exitProcess(0)
                else -> {
                    println("---------------------------------------------")
                    println("Opção inválida, tente novamente")
                    println("---------------------------------------------")
                    menuInicial()
                }
            }
        } catch (ex : Exception){
            println("------------------------------------------------------------------------")
            println("Formato inválido, para escolher o item, você deve informar o número dele")
            println("------------------------------------------------------------------------")
            menuInicial()
        }
    }

    private fun menuLanche(){
        try {
            println("---------------------------------------------")
            println("Qual lanche?")
            println("---------------------------------------------")
            println("[1] X-Burger")
            println("[2] X-Salada")
            println("[0] Sair do sistema")
            println("---------------------------------------------")

            when(readln().toInt()){
                1 -> {
                    objetoProduto = Xburger()
                    val quantidade = objetoProduto.modificarQuantidade(objetoProduto.quantidade())
                    objetoProduto = Xburger(quantidade = quantidade)
                    println("---------------------------------------------")
                    println("O codigo do pedido é ${objetoCarrinho.adicionarProduto(objetoProduto)}")
                    println("---------------------------------------------")
                    menuPosPrimeiraEscolha()
                }
                2 -> {
                    objetoProduto = Xsalada()
                    val quantidade = objetoProduto.modificarQuantidade(objetoProduto.quantidade())
                    objetoProduto = Xsalada(quantidade = quantidade)
                    println("---------------------------------------------")
                    println("O codigo do pedido é ${objetoCarrinho.adicionarProduto(objetoProduto)}")
                    println("---------------------------------------------")
                    menuPosPrimeiraEscolha()
                }
                0 -> {
                    exitProcess(0)
                }
                else -> {
                    println("---------------------------------------------")
                    println("Opção inválida, tente novamente")
                    println("---------------------------------------------")
                    menuLanche()
                }
            }
        } catch (ex : Exception){
            println("------------------------------------------------------------------------")
            println("Formato inválido, para escolher o item, você deve informar o número dele")
            println("------------------------------------------------------------------------")
            menuLanche()
        }
    }

    private fun menuBebida(){
        try {
            println("---------------------------------------------")
            println("Qual bebida?")
            println("---------------------------------------------")
            println("[1] Refrigerante")
            println("[2] Suco")
            println("[0] Sair do sistema")
            println("---------------------------------------------")

            when(readln().toInt()){
                1 -> {
                    objetoProduto = Refrigerante()
                    val quantidade = objetoProduto.modificarQuantidade(objetoProduto.quantidade())
                    objetoProduto = Refrigerante(quantidade = quantidade)
                    println("---------------------------------------------")
                    println("O codigo do pedido é ${objetoCarrinho.adicionarProduto(objetoProduto)}")
                    println("---------------------------------------------")
                    menuPosPrimeiraEscolha()
                }
                2 -> {
                    objetoProduto = Suco()
                    val quantidade = objetoProduto.modificarQuantidade(objetoProduto.quantidade())
                    objetoProduto = Suco(quantidade = quantidade)
                    println("---------------------------------------------")
                    println("O codigo do pedido é ${objetoCarrinho.adicionarProduto(objetoProduto)}")
                    println("---------------------------------------------")
                    menuPosPrimeiraEscolha()
                }
                0 -> {
                    exitProcess(0)
                }
                else -> {
                    println("---------------------------------------------")
                    println("Opção inválida, tente novamente")
                    println("---------------------------------------------")
                    menuBebida()
                }
            }
        } catch (ex : Exception){
            println("------------------------------------------------------------------------")
            println("Formato inválido, para escolher o item, você deve informar o número dele")
            println("------------------------------------------------------------------------")
            menuBebida()
        }
    }

    private fun menuPosPrimeiraEscolha(){
        try {
            println("---------------------------------------------")
            println("O que deseja fazer agora?")
            println("---------------------------------------------")
            println("[1] Adicionar novo item ao carrinho")
            println("[2] Remover item do carrinho")
            println("[3] Ver itens do carrinho")
            println("[4] Editar um item no carrinho")
            println("[5] Pagar")
            println("[0] Sair")
            println("---------------------------------------------")

            when(readln().toInt()){
                1 -> {
                    menuInicial()
                }
                2 -> {
                    objetoCarrinho.mostrarProdutos()
                    objetoCarrinho.removerProduto()
                    menuPosPrimeiraEscolha()
                }
                3 -> {
                    objetoCarrinho.mostrarProdutos()
                    menuPosPrimeiraEscolha()
                }
                4 -> {
                    objetoCarrinho.mostrarProdutos()
                    objetoCarrinho.editarCarrinho(objetoProduto)
                    menuPosPrimeiraEscolha()
                }
                5 -> {
                    objetoCarrinho.mostrarProdutos()
                    menuPagamento()
                }
                0 -> {
                    exitProcess(0)
                }
                else -> {
                    println("---------------------------------------------")
                    println("Opção inválida, tente novamente")
                    println("---------------------------------------------")
                    menuPosPrimeiraEscolha()
                }
            }
        } catch (ex : Exception){
            println("---------------------------------------------")
            println("Formato inválido, você deve informar um número")
            println("---------------------------------------------")

            menuPosPrimeiraEscolha()
        }
    }

    private fun menuPagamento(){
        try {
            println("---------------------------------------------")
            println("Qual a forma de pagamento?")
            println("---------------------------------------------")
            println("[1] Cartão de Crédito")
            println("[2] Cartão de Débito")
            println("[3] Vale-Refeição")
            println("[4] Dinheiro")
            println("[0] Sair")
            println("---------------------------------------------")

            when(readln().toInt()){
                1, 2, 3 -> {
                    println("---------------------------------------------")
                    println("Compra finalizada com sucesso! Boa refeição")
                    println("---------------------------------------------")
                }
                4 -> {
                    val objetoPagamento = Pagamento(objetoCarrinho)
                    objetoPagamento.pagamentoEmDinheiro()
                    println("---------------------------------------------")
                    println("Compra finalizada com sucesso! Boa refeição")
                    println("---------------------------------------------")

                }
                0 -> exitProcess(0)
                else -> {
                    println("---------------------------------------------")
                    println("Opção inválida, tente novamente")
                    println("---------------------------------------------")
                    menuPagamento()
                }
            }
        } catch (ex : Exception){
            println("---------------------------------------------")
            println("Formato inválido, você deve informar um número")
            println("---------------------------------------------")

            menuPagamento()
        }
    }
}