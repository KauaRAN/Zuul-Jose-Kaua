/**
 *  Esta é a interface de nosso jogo, baseada no projeto zuu_bad. Fizemos algumas alterações,
 *  como adicionar novas salas e traduzir o nome dos elementos de inglês para português, de modo que fique mais prático trabalhar.
 *  Trata-se de uma aventura em um mundo pós-apocalíptico onde o jogador deve seguir diferentes caminhos e tomar diferentes caminhos para sobreviver.
 *  Como optamos por fazer o jogo em português, houve uma pequena alteração na classe CommandWords, onde no lugar de 'go', 'quit' e 'help' deve ser colocado 'ir', 'sair' e 'ajuda', respectivamente.
 * @author  José Cerqueira e Kauã Nascimento
 * @version 2023.08.17
 */

public class Game
{
    private Parser parser;
    private Room currentRoom;

    /**
     * Cria o jogo e inicializa funcionalidades.
     */
    public Game()
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Método onde alteramos as salas para se adequar ao nosso jogo.
     */
    private void createRooms()
    {
        Room casa,casaDoVizinho,parque,igreja,escola,hospital,restaurante,supermercado,postoDeGasolina,lojaDeArmas, aeroporto, baseMilitar,abrigoMilitar, foraDaCidade,campoDeSobreviventes,acimaHospital,alaMedica,deposito;

        // create the rooms
        casa = new Room("na sua casa, sozinho, precisa tomar uma atitude.");
        casaDoVizinho = new Room("na casa do vizinho, parece vazia...Parece ter saído há um tempo.");
        parque = new Room("no parque da cidade...Um amontoado de meras lembranças de um local antes movimentado. Você escuta grunhidos à distância...");
        igreja = new Room("na igreja local. Parece que as pessoas de fé também fugiram. Os grunhidos parecem te seguir, como um vento simbilante incansável...");
        escola = new Room("na escola onde crianças muito alegres estudavam. Uma placa acima da porta diz 'Aulas suspensas por conta do alerta, fechado e trancado por tempo indeterminado'.\nBarulhos estranhos soam do outro lado das portas, arranhões e grunhidos de coisas pequenas, como se fossem crianças....Mãos parecem sair de buracos na construção, como se buscassem algo vorazmente. ");
        hospital = new Room("no hospital da cidade. Agora está abandonado, já foi um local de cura e esperança.\nVocê avista vultos de pessoas dentro da sombria instalação, parecem cambalear e andar sem direção determinada, como se não tivessem controle dos próprios movimentos.");
        restaurante = new Room("no restaurante local mais requisitado, talvez por buscar comida para matar a fome, ou apenas lembrar do vívido cheiro de comidas exóticas preparadas pelos chefes.\nPorém, toda a comida está estragada, além do pútrido cheiro e som de passos tão destoados e divagantes quanto seus movimentos assustadores.");
        supermercado = new Room("no supermercado. Em busca de matimentos, você coleta comida enlatada e bebidas ainda conservadas e coloca tudo em sua mochila.\nNos vidros que jazem outras instalações do local, há silhuetas humanas arranhando e se forçando sem controle...Não parece que são clientes e, se forem, não parecem muito satisfeitos...");
        postoDeGasolina = new Room("no posto de gasolina da rodovia. Toda a gasolina parece ter sido levada, além de carros que sofrem com a lamentável solidão do abandono.");
        lojaDeArmas = new Room("em uma loja de armas que não possui mais seu gerente. Após perceber que há algo errado, você decide priorizar sua segurança, buscando algo para que possa se defender.");
        aeroporto = new Room("no aeroporto após uma longa caminhada. Os voos parecem ter sido cancelados, o que não impediu de haver pessoas dando passos errantes de um lado a outro,\nsem destino, sem expressão em seus rostos, sem preocupação com o alerta, sem vida em seus olhos...");
        baseMilitar = new Room("em uma base militar fortemente protegida. Ao alto dos muros, soldados parecem se alertar com sua presença.\nLogo após, um soldado diz: 'Este é um lugar proibido para civis! O abrigo militar ao leste está sob jurisdição. Busque um abrigo alternativo.'");
        abrigoMilitar = new Room("no abrigo militar, contrariando as recomendações dos soldados. Ao chegar lá, você ouve sirenes e um movimento grande em sua direção. Luzes permeiam seus olhos, passos estremecem seus ouvidos, um grupo está a sua frente...\nNão estão receptivos, não estão planejando deixá-lo ir, não planejam dar-lhe nem mais um pingo de liberdade. Aqui sua aventura acaba, com um ousado desejo de contrariar as regras. (digite sair)");
        foraDaCidade = new Room("fora dos limites da cidade. Seguindo os conselhos dos militares, você segue as ruas disformes em busca de abrigo e um mínimo resquício de presença humana agradável. Chegando ao limite do cansaço, você avista luzes em uma colina adiante.\nNão parece ser uma base militar, nem algo fortemente protegido, mas o bastante para proteger as pessoas que buscam salvar a si mesmas e a seus entes queridos.");
        campoDeSobreviventes = new Room("no campo de sobreviventes. As pessoas te recepcionam, lhe dão assistência, lhe tratam como realmente merece, porém, sobretudo, parecem aliviadas por seu novo visitante não ser um errante misterioso ou um soldado ranzinza.\nSão gente como você, em busca de segurança, de conforto, e de respostas. Aqui sua aventura acaba. (digite 'sair')");
        acimaHospital = new Room("no primeiro andar do hospital. Está decrépito, macas por toda parte e aparelhos médicos espalhados.");
        alaMedica = new Room("na ala médica onde eram realizadas cirurgias, há o que parecem ser pessoas imóveis presas em macas, um aviso escrito na parede diz: 'Cuidado, pacientes agressivos'");
        deposito = new Room("no depósito de utensílios utilizados para manter o hospital em funcionamento, nada que possa ser utilizado por civis.");

        // initialise room exits
        casa.setExit("sul", parque);
        casa.setExit("oeste", casaDoVizinho);

        casaDoVizinho.setExit("leste", casa);

        parque.setExit("norte", casa);
        parque.setExit("leste", igreja);
        parque.setExit("sul", postoDeGasolina);

        igreja.setExit("leste", escola);
        igreja.setExit("sul", hospital);
        igreja.setExit("oeste", parque);

        escola.setExit("sul", restaurante);
        escola.setExit("oeste", igreja);

        hospital.setExit("norte", igreja);
        hospital.setExit("leste", restaurante);
        hospital.setExit("sul", lojaDeArmas);
        hospital.setExit("acima",acimaHospital);
        acimaHospital.setExit("norte",alaMedica);
        acimaHospital.setExit("leste",deposito);
        acimaHospital.setExit("abaixo",hospital);
        alaMedica.setExit("sul",acimaHospital);
        deposito.setExit("oeste",acimaHospital);

        restaurante.setExit("norte", escola);
        restaurante.setExit("sul", baseMilitar);
        restaurante.setExit("oeste", hospital);

        supermercado.setExit("leste", postoDeGasolina);

        postoDeGasolina.setExit("norte", parque);
        postoDeGasolina.setExit("sul", aeroporto);
        postoDeGasolina.setExit("oeste", supermercado);

        lojaDeArmas.setExit("norte", hospital);
        lojaDeArmas.setExit("leste", baseMilitar);
        lojaDeArmas.setExit("oeste", aeroporto);

        aeroporto.setExit("norte", postoDeGasolina);
        aeroporto.setExit("leste", lojaDeArmas);

        baseMilitar.setExit("norte", restaurante);
        baseMilitar.setExit("leste", abrigoMilitar);
        baseMilitar.setExit("sul", foraDaCidade);

        foraDaCidade.setExit("norte", baseMilitar);
        foraDaCidade.setExit("sul", campoDeSobreviventes);

        currentRoom = casa;
    }


    public void play()
    {
        printWelcome();

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Obrigado por jogar! Adeus!");
    }

    /**
     * Printa as mensagens iniciais para o jogador
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Bem vindo(a) ao nosso jogo O Despertar!");
        System.out.println("O Despertar é um jogo que irá testar seu instinto de sobrevivência.");
        System.out.println("Digite 'ajuda' para esclarecimentos.");
        System.out.println();
        System.out.println();
        System.out.println(currentRoom.getLongerDescription());
    }

    /*
     *Método que irá processar os primeiros comandos 'ir', 'sair' e 'ajuda'.
     */

    private boolean processCommand(Command command)
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("Não entendi o que você quis dizer...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("ajuda")) {
            printHelp();
        }
        else if (commandWord.equals("ir")) {
            goRoom(command);
        }
        else if (commandWord.equals("sair")) {
            wantToQuit = quit(command);
        }
        else if(commandWord.equals("olhar")) {
            olhar();
        }
        else if(commandWord.equals("comer")) {
            comer();
        }

        return wantToQuit;
    }

    //Ajuda para o jogador.
    private void printHelp()
    {
        System.out.println("Você acorda subitamente de seu sono, ouvindo apenas o som do silêncio...Um alerta foi dado: 'A todos os vivos, procurem abrigo!'");
        System.out.println("Seu local incial é sua casa.");
        System.out.println();
        System.out.println("Os comandos são:");
        parser.getCommandList();
        System.out.println("Para 'ir' deve ser digitada em seguida a direção disponível.");
    }

    /**
     * Nesta parte está o método que dita o avanço do jogo, de acordo com a direção escolhida.
     */
    private void goRoom(Command command)
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Ir aonde?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);
        currentRoom = nextRoom;
        System.out.println(currentRoom.getLongerDescription());
    }

    /*
     * Método adicionado conforme orientação, para tornar o programa coeso e evitar repetições desnecessárias.
     * */
    private void printLocationInfo() {
        System.out.println("Você está " + currentRoom.getDescription());
        currentRoom.getExitString();
    }

    /**
     * Método que realiza a saída e finalização do jogo.
     */
    private boolean quit(Command command)
    {
        if(command.hasSecondWord()) {
            System.out.println("Sair de?");
            return false;
        }
        else {
            return true; 
        }
    }
    private void olhar()
    {
        System.out.println(currentRoom.getLongerDescription());
    }
    private void comer(){
        System.out.println("Você comeu e não está mais com fome.");
    }
}
