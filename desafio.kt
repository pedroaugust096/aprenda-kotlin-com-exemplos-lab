enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val matricula: String)

data class ConteudoEducacional(val nome: String, val duracao: Int)

data class Formacao(val nome: String, var conteudos: MutableList<ConteudoEducacional>, val dificuldade: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        
    	inscritos.add(usuario)
    }
}

fun main() {
    
    // Cadastrando os usuários na classe:
    
    val aluno1 = Usuario("Aluno_1", "1")
    val aluno2 = Usuario("Aluno_2", "2")
    val aluno3 = Usuario("Aluno_3", "3")
    val aluno4 = Usuario("Aluno_4", "4")
    
    // Inserindo o catálogo de conteúdos nos conteúdos educacionais:
    
    val catalogoConteudos1 = mutableListOf<ConteudoEducacional>()
    val catalogoConteudos2 = mutableListOf<ConteudoEducacional>()
    
    val conteudo_1 = ConteudoEducacional("Aprendendo Kotlin na Prática em sua Documentação Oficial", 13)
    val conteudo_2 = ConteudoEducacional("Praticando sua Lógica de Programação com Kotlin", 6)
   
    val conteudo_3 = ConteudoEducacional("Explorando Padrões de Projeto em Kotlin", 5)
    val conteudo_4 = ConteudoEducacional("Kotlin no Backend com Spring Boot 3", 10)
    
    catalogoConteudos1.add(conteudo_1)
    catalogoConteudos1.add(conteudo_2)
    catalogoConteudos2.add(conteudo_3)
    catalogoConteudos2.add(conteudo_4)
    
    // Adicionando as formações educacionais e matriculando os alunos nas mesmas:
    
    val formacao_1 = Formacao("Kotlin Básico", catalogoConteudos1, Nivel.BASICO)
    val formacao_2 = Formacao("Kotlin Avançado", catalogoConteudos2, Nivel.AVANCADO)
    
    formacao_1.matricular(aluno1)
    formacao_1.matricular(aluno4)
    
    formacao_2.matricular(aluno2)
    formacao_2.matricular(aluno3)
    
    // Exibindo informações:
    
    println("Alunos matriculados:")
    println()
    println("Formação 1: \n")
    
    for (aluno in formacao_1.inscritos) {
        println("Nome: ${aluno.nome} --- Matricula: ${aluno.matricula}")
    }
    
    println()
    println("Nome_formação: ${formacao_1.nome} --- Dificuldade: ${formacao_1.dificuldade}")
    
    println()
    for (conteudo in formacao_1.conteudos) {
        println("Conteúdo: ${conteudo.nome} --- Duração: ${conteudo.duracao}h")
    }
    
    println()
    println("Formação 2: \n")
    
    for (aluno in formacao_2.inscritos) {
        println("Nome: ${aluno.nome} --- Matricula: ${aluno.matricula}")
    }
    
    println()
    println("Nome_formação: ${formacao_2.nome} --- Dificuldade: ${formacao_2.dificuldade}")
    
    println()
    for (conteudo in formacao_2.conteudos) {
        println("Conteúdo: ${conteudo.nome} --- Duração: ${conteudo.duracao}h")
    }    
}