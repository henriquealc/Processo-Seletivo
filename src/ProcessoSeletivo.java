import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        // selecaoCandidatos(); // Chama o método para selecionar candidatos ao iniciar o programa.
        
        imprimirSelecionados();       
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUSGUSTO"};
        
        // Itera sobre cada candidato e tenta entrar em contato com eles
        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }
    }
     // Método para tentar entrar em contato com um candidato
    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1; // Inicializa o contador de tentativas
        boolean continuarTentando = true; // Indica se devemos continuar tentando entrar em contato
        boolean atendeu = false; // Indica se o candidato atendeu a ligação

        // Loop para tentar entrar em contato até que o candidato atenda ou o número máximo de tentativas seja alcançado
        do { 
            atendeu = atender(); // Tenta fazer uma ligação
            continuarTentando = ! atendeu; // Continua tentando se o candidato não atender
            if (continuarTentando)
                tentativasRealizadas++; // Incrementa o contador de tentativas
            else
                System.out.println("CONTATO REALIZADO COM SUCESSO");

        } while (continuarTentando && tentativasRealizadas < 3); // Continua o loop enquanto devemos continuar tentando e não exceder o número máximo de tentativas
        
        // Mensagem de resultado do contato com o candidato    
        if (atendeu)
                System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVA");
            else
                System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + " , NUMERO PROXIMO DE TENTATIVAS " + tentativasRealizadas);     
        }

        // Método para simular se o candidato atende ou não a ligação
        static boolean atender(){
            return new Random().nextInt(3)==1;
        }

    static void imprimirSelecionados(){
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUSGUSTO"};
        System .out.println("Imprimindo a lista de candidatos:");

        // Itera sobre a lista de candidatos e imprime cada um com seu respectivo número.
        for (int indice= 0; indice < candidatos.length; indice++){
            System.out.println("O candidato de nº " + (indice+1) + " e o candidato " + candidatos[indice]);
        }
        
        // System.out.println("");
        // System.out.println("Forma abreviada de interar for each");
        
        // // Desta forma não consigo obter o indice
        // for (String candidato : candidatos){
        //     System.out.println("O candidato selecionado foi " + candidato);
        // }
    }

    public static void selecaoCandidatos(){
        // Lista de candidatos
        String [] candidatos = {"FELIPE","MARCIA","JULIA","PAULO","AUGUSTO","MONICA","FABRICIO","MIRELA","DANIELA","JORGE"};
        
        int candidatosSelecionados = 0; // inicia o contador de candidatos selecionados.
        int candidatosAtual = 0; // Realiza o índice do candidato atual
        double salarioBase = 2000.0; // salario base para comparação
         
        // Enquanto houver candidatos por avaliar e não tiverem sido selecionados mais de 5
        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length){
            String candidato = candidatos[candidatosAtual]; // obtém o nome do candidato atual
            double salarioPretendido = valorPretendido(); // obtém o salario pretendido do candidato
            
            System.out.println("O candidato " + candidato + " foi selecionado para vaga."); // Informa que o candidato foi selecionado
            
            // Se o salario base for maior ou igual ao salario pretendido do candidato
            if (salarioBase >= salarioPretendido){
                 System.out.println("O canditado " + candidato + " foi selecionado para vaga"); // Informa que o candidato foi selecionado
                 candidatosSelecionados++; // Incrementa o contador de candidatos selecionados
            }
            candidatosAtual++; // Incrementa o indice do candidato atual
        }
    }
    // Metodo que gera um valor aleatório para o salário pretendido
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    // Metodo para analisar o salario pretendido de um candidato
    public static void analisarCandidato (double salarioPretendido) {
        double salarioBase = 2000.0;
        // compara o salario base com o salario pretendido do candidato e exibe uma mensagem apropriada
        if (salarioBase > salarioPretendido){
            System.out.println("LIGAR PARA CANDIDATO");
        }else if (salarioBase == salarioPretendido)
            System.out.println("LIGAR PARA CANDIDATO");
        else {
            System.out.println("AGUARDANDO RESULTADO DOS DEMAIS CANDIDATOS");
        }

    }
}