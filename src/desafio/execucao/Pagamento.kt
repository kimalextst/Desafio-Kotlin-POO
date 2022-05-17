package desafio.execucao

class Pagamento(private val objetoCarrinho : Carrinho) {

    fun pagamentoEmDinheiro(){
        println("---------------------------------------------")
        println("Qual será o valor usado?")
        println("---------------------------------------------")
        print("R$")
        val valor =  readln().toDouble()

        if (valor < objetoCarrinho.acessarValorTotal()) {
            println("---------------------------------------------")
            println("{Valor menor que o total}")
            println("{Por favor, insira um valor maior}")
            println("---------------------------------------------")
            pagamentoEmDinheiro()
        } else if (valor > objetoCarrinho.acessarValorTotal()){
            println("---------------------------------------------")
            println("Valor do troco: R$${valor - objetoCarrinho.acessarValorTotal()}")
            println("---------------------------------------------")
        }
    }
}