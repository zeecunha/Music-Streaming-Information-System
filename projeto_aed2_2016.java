/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_1;

import edu.princeton.cs.algs4.DirectedEdge;
import edu.princeton.cs.algs4.Edge;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdOut;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;




/**
 *
 * @author a8pin
 * @Edited By José Cunha
 * 
 */
public abstract class projeto_aed2_2016 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /*
         * St's Principais 
         */
        
        // red-black trees
        RedBlackBST_Projecto<String, Genero> generosST = new RedBlackBST_Projecto<>();
        RedBlackBST_Projecto<String, Musica> musicasST = new RedBlackBST_Projecto<>();
        RedBlackBST_Projecto<String, Playlist> playlistsST = new RedBlackBST_Projecto<>();

        //hashing trees
        SeparateChainingHashST1<String, Artista> artistasST = new SeparateChainingHashST1<>();
        SeparateChainingHashST1<String, Utilizador> utilizadoresST = new SeparateChainingHashST1<>();



        /*
         *  Inicialização das St's
         */
        loadFromFileGenerosST(generosST, "C:\\Users\\ZeeCunha\\Desktop\\UFP\\3º ANO\\2SEMESTRE\\AED2\\aed2_1516\\src\\projeto_1\\generos.txt");
        loadFromFileArtistasST(artistasST, "C:\\Users\\ZeeCunha\\Desktop\\UFP\\3º ANO\\2SEMESTRE\\AED2\\aed2_1516\\src\\projeto_1\\artista.txt");
        loadFromFileUtilizadoresST(utilizadoresST, "C:\\Users\\ZeeCunha\\Desktop\\UFP\\3º ANO\\2SEMESTRE\\AED2\\aed2_1516\\src\\projeto_1\\pessoas.txt");
        loadFromFileMusicasST(musicasST, generosST, artistasST, playlistsST, utilizadoresST, "C:\\Users\\ZeeCunha\\Desktop\\UFP\\3º ANO\\2SEMESTRE\\AED2\\aed2_1516\\src\\projeto_1\\musicas.txt");
        loadFromFilePlaylistST(playlistsST, musicasST, "C:\\Users\\ZeeCunha\\Desktop\\UFP\\3º ANO\\2SEMESTRE\\AED2\\aed2_1516\\src\\projeto_1\\playlists.txt");
        loadFromFileHistory(utilizadoresST, "C:\\Users\\ZeeCunha\\Desktop\\UFP\\3º ANO\\2SEMESTRE\\AED2\\aed2_1516\\src\\projeto_1\\historico.txt");
        
        /**
         * carregar txt da 2 parte do projeto
         */
        
        loadFromFileUsersLikesMusics(utilizadoresST, "C:\\Users\\ZeeCunha\\Desktop\\UFP\\3º ANO\\2SEMESTRE\\AED2\\aed2_1516\\src\\projeto_1\\LikesMusics.txt");
       //loadFromFileUsersLikesPlaylists(utilizadoresST, "C:\\Users\\ZeeCunha\\Desktop\\UFP\\3º ANO\\2SEMESTRE\\AED2\\aed2_1516\\src\\projeto_1\\LikesPlaylists.txt");
        loadFromFileUsersLikesArtists(utilizadoresST, "C:\\Users\\ZeeCunha\\Desktop\\UFP\\3º ANO\\2SEMESTRE\\AED2\\aed2_1516\\src\\projeto_1\\LikesArtists.txt");
        
        //Symbol Weighted Graphs
        
        SymbolWeightedDigraph FollowUsers = new SymbolWeightedDigraph("C:\\Users\\ZeeCunha\\Desktop\\UFP\\3º ANO\\2SEMESTRE\\AED2\\aed2_1516\\src\\projeto_1\\FollowUsers.txt", ";");
        SymbolWeightedGraph FriendshipsGraph = new SymbolWeightedGraph("C:\\Users\\ZeeCunha\\Desktop\\UFP\\3º ANO\\2SEMESTRE\\AED2\\aed2_1516\\src\\projeto_1\\FriendshipsGraph.txt", ";");

        
        /* 
         *  Menu com as respectivas funcionalidades
         *  Nota: Nem todas as funcoes sao chamadas no menu;
         */
        
        System.out.println("-------- Projeto AED2 --------\n");
        System.out.println("Escolha uma das seguintes opcoes:\n 1-Imprimir Musicas por generos\n 2-Imprimir musicas por artistas\n 3-imprimir musicas por playlists\n 4-Criar Genero\n 5-Criar artista\n 6-Criar Musica\n 7-Editar musica\n 8-Apagar Musica\n 9-Criar user\n 10-Procurar Musica em playlist\n 11- Histórico \n 2ª PARTE DO PROJETO \n 12- Imprimir likes utilizadores em artistas \n 13- Imprimir likes utilizadores em playlists \n 14- Imprimir likes utilizadores em musicas \n 15- Fazer like num artista\n 16- Fazer like numa musica \n17- Fazer like numa playlist\n18- Imprimir Seguidores\n 19- Imprimir amizades \n\n99-Imprimir tudo");
                    String opcao;
                    Scanner sca = new Scanner(System.in);
                    opcao = sca.nextLine();
                    switch (opcao) {
                        case "1": {
                             printMusicByGenres(generosST); 
                            return;
                        }
                        case "2": {
                            printMusicByArtist(artistasST); 
                            return;
                        }
                        case "3": {
                            printMusicByPlaylist(playlistsST); 
                            return;
                        }
                        case "4":{
                            criarGenero(generosST);
                            saveGenero(generosST, "C:\\Users\\ZeeCunha\\Desktop\\UFP\\3º ANO\\2SEMESTRE\\AED2\\aed2_1516\\src\\projeto_1\\generos.txt");
                            return;
                        }
                        case "5":{
                             criarArtista(artistasST, generosST);
                             saveArtista(artistasST, "C:\\Users\\ZeeCunha\\Desktop\\UFP\\3º ANO\\2SEMESTRE\\AED2\\aed2_1516\\src\\projeto_1\\artista.txt");
                              return;
                        }
                         case "6":{
                              criarMusica(musicasST, generosST, artistasST); 
                              saveMusica(musicasST, "C:\\Users\\ZeeCunha\\Desktop\\UFP\\3º ANO\\2SEMESTRE\\AED2\\aed2_1516\\src\\projeto_1\\musicas.txt");
                             return;
                        }
                         case "7":{
                              updateMusica(musicasST, artistasST, generosST); 
                              saveMusica(musicasST, "C:\\Users\\ZeeCunha\\Desktop\\UFP\\3º ANO\\2SEMESTRE\\AED2\\aed2_1516\\src\\projeto_1\\musicas.txt");
                              return;
                        }
                        case "8":{
                              deleteMusica(musicasST, artistasST, generosST);
                              saveMusica(musicasST, "C:\\Users\\ZeeCunha\\Desktop\\UFP\\3º ANO\\2SEMESTRE\\AED2\\aed2_1516\\src\\projeto_1\\musicas.txt");
                              return;
                        }
                        case "9":{
                              criarUtilizador(utilizadoresST);
                              saveUtilizador(utilizadoresST, "C:\\Users\\ZeeCunha\\Desktop\\UFP\\3º ANO\\2SEMESTRE\\AED2\\aed2_1516\\src\\projeto_1\\pessoas.txt");
                              return;
                        }
                        case "10":{
                             findMusicaPlaylist(playlistsST, musicasST);
                             return;
                        }
                        case "11":{
                             playMusic(musicasST, utilizadoresST, "jtorres");
                             savePlayedMusics(utilizadoresST, "C:\\Users\\ZeeCunha\\Desktop\\UFP\\3º ANO\\2SEMESTRE\\AED2\\aed2_1516\\src\\projeto_1\\historico.txt");
                             return;
                        }
                        
                        case "12":{
                             printLikesArtistas(utilizadoresST,"jtorres");
                             return;
                        }
                        case "13":{
                             printLikesPlaylists(utilizadoresST,"jtorres");
                             return;
                        }
                         case "14":{
                             printLikesMusicas(utilizadoresST, "jtorres");
                             return;
                        }
                          case "15":{
                             UserArtistLike(utilizadoresST, artistasST, "jtorres");
                             saveLikesArtists(utilizadoresST, "C:\\Users\\ZeeCunha\\Desktop\\UFP\\3º ANO\\2SEMESTRE\\AED2\\aed2_1516\\src\\projeto_1\\LikesArtists.txt");
                             return;
                        }
                        case "16":{
                             UserMusicasLike(utilizadoresST, musicasST, "jtorres");
                             saveLikesMusics(utilizadoresST, "C:\\Users\\ZeeCunha\\Desktop\\UFP\\3º ANO\\2SEMESTRE\\AED2\\aed2_1516\\src\\projeto_1\\LikesMusics.txt");
                             return;
                        }
                        case "17":{
                             UserPlaylistsLike(utilizadoresST, playlistsST, "jtorres");
                            saveLikesPlaylists(utilizadoresST, "C:\\Users\\ZeeCunha\\Desktop\\UFP\\3º ANO\\2SEMESTRE\\AED2\\aed2_1516\\src\\projeto_1\\LikesPlaylists.txt"); // a funcionar                        }
                            return;
                        }
                        
                        case "18":{
                             printFollowUsers(FollowUsers, true);
                            return;
                        }
                        
                         case "19":{
                          printFriendshipsGraph(FriendshipsGraph, true);                            
                          return;
                        }

                        case "99":{
                              imprimirTeste(musicasST, generosST, artistasST, playlistsST, utilizadoresST);
                             return;
                        }
    }
    }
    /*
     *   Carregar ficheiros
     */
    
    /**
     *
     * @param playlistsST
     * @param musicasST
     * @param path
     */
    
public static void loadFromFilePlaylistST(RedBlackBST_Projecto<String, Playlist> playlistsST, RedBlackBST_Projecto<String, Musica> musicasST, String path) {
        In in = new In(path);

        while (!in.isEmpty()) {
            String[] texto = in.readLine().split(";");
            String nome = texto[0]; //posicao do nome no txt
            String username = texto[1]; //posicao do username no txt
            int numMusics = texto.length - 2;
            Playlist p = new Playlist(nome, username);
            playlistsST.put(username, p);
            for (int i = 0; i < numMusics; i++) {
                Musica m = (Musica) musicasST.get(texto[i + 2]);
                p.getPlaylistSt().put(texto[i + 2], m);
            }
        }

    }

    /**
     *
     * @param generoST
     * @param path
     */
    public static void loadFromFileGenerosST(RedBlackBST_Projecto<String, Genero> generoST, String path) {
        In in = new In(path); // abertura do ficheiro/stream de entrada
        while (!in.isEmpty()) {
            String[] texto = in.readLine().split(";");
            String genero = texto[0];   //posicao do genero no txt
            String descricao = texto[1];    //posicao da descricao no txt

            Genero g = new Genero(genero, descricao);
            generoST.put(genero, g);
        }
    }

    /**
     *
     * @param musicaST
     * @param generoST
     * @param artistaST
     * @param playlistST
     * @param utilizadoresST
     * @param path
     */
    public static void loadFromFileMusicasST(RedBlackBST_Projecto<String, Musica> musicaST, RedBlackBST_Projecto<String, Genero> generoST, SeparateChainingHashST1<String, Artista> artistaST, RedBlackBST_Projecto<String, Playlist> playlistST, SeparateChainingHashST1<String, Utilizador> utilizadoresST, String path) {
        In in = new In(path); // abertura do ficheiro/stream de entrada
        while (!in.isEmpty()) {
            String[] texto = in.readLine().split(";");
            String ISRC = texto[0]; //posicao do ISRC no txt
            String nome = texto[1]; //posicao do nome no txt
            Float duracao = Float.parseFloat(texto[2]); //posicao da duracao no txt
            String artista = texto[3];  //posicao do artista no txt
            String genero = texto[4];   //posicao do genero no txt

            Musica m = new Musica(ISRC, nome, duracao, artista, genero);
            musicaST.put(ISRC, m);

            Genero g = generoST.get(genero);
            g.getGeneroMusicsST().put(ISRC, m);

            Artista a = artistaST.get(artista);
            a.getArtistMusicSt().put(ISRC, m);

        }
    }

    /**
     *
     * @param artistasST
     * @param path
     */
    public static void loadFromFileArtistasST(SeparateChainingHashST1<String, Artista> artistasST, String path) {
        In in = new In(path); // abertura do ficheiro/stream de entrada
        while (!in.isEmpty()) {
            String[] texto = in.readLine().split(";");
            String username = texto[1]; //posicao do username no txt
            String nome = texto[0]; //posicao do nome no txt
            String generomusical = texto[2];    //posicao do genero no txt

            Artista a = new Artista(username, nome, generomusical);
            artistasST.put(username, a);
        }
    }

    /**
     *
     * @param utilizadoresST
     * @param path
     */
    public static void loadFromFileUtilizadoresST(SeparateChainingHashST1<String, Utilizador> utilizadoresST, String path) {
        In in = new In(path); // abertura do ficheiro/stream de entrada
        while (!in.isEmpty()) {
            String[] texto = in.readLine().split(";");
            String nome = texto[0]; //posicao do nome no txt
            String username = texto[1]; //posicao do username no txt
            String email = texto[2];    //posicao do email no txt

            Utilizador u = new Utilizador(nome, username, email);
            utilizadoresST.put(username, u);
        }
    }

    /**
    * carregar o historico
     * @param utilizadorST
     * @param path
    */
   
    public static void loadFromFileHistory(SeparateChainingHashST1<String, Utilizador> utilizadorST, String path) {
        In in = new In(path);
        while (!in.isEmpty()) {
            String[] texto = in.readLine().split(";");
            String username = texto[0];
            String date = texto[1];
            String isrc = texto[2];
            Utilizador u = utilizadorST.get(username);
            u.getHistoricoST().put(date, isrc);

        }
    }
    
    
    /*
     *  Validações
     */
    
    /**
     * Validar se o IRSC existe;
     *
     * @param musicaST
     * @param isrc
     * @return
     */
    public static boolean isrcValidation(RedBlackBST_Projecto<String, Musica> musicaST, String isrc) {
        for (String key : musicaST.keys()) {
            Musica m = musicaST.get(key);
            if (m.getISRC().equals(isrc)) { //compare
                return true;
            }
        }
        return false;
    }

    /**
     * Validar se o genero existe;
     *
     * 
     * @param generosST
     * @param genero
     * @return
     */
    public static boolean genreValidation(RedBlackBST_Projecto<String, Genero> generosST, String genero) {
        for (String key : generosST.keys()) {
            Genero g = (Genero) generosST.get(key);
            if (g.getGenero().equals(genero)) { //compare
                return true;
            }
        }
        return false;
    }

    /**
     * Validar se o artista existe;
     *
     * @param artistaST
     * @param artista
     * @return
     */
    public static boolean artistValidation(SeparateChainingHashST1<String, Artista> artistaST, String artista) {
        for (String username : artistaST.keys()) {
            Artista a = (Artista) artistaST.get(username);
            if (a.getNome().equals(artista)) {  //compare
                return true;
            }
        }
        return false;
    }

    /**
     * Validar se o utilizador existe;
     *
     * @param utilizadorST
     * @param utilizador
     * @return
     */
    
    public static boolean userValidation(SeparateChainingHashST1<String, Utilizador> utilizadorST, String utilizador) {
        for (String username : utilizadorST.keys()) {
            Utilizador u = (Utilizador) utilizadorST.get(username);
            if (u.getUsername().equals(utilizador)) {   //compare
                return true;
            }
        }
        return false;
    }

    /*
     *  Genero
     */
    
    /**
     * Criar novo genero.
     * Verifica se já existe na BD.
     *
     * @param generoST
     */
    
    public static void criarGenero(RedBlackBST_Projecto<String, Genero> generoST) {
        
        
        String genero, desc;

        Scanner sca = new Scanner(System.in);

        System.out.print("-> Insira o novo genero: ");
        genero = sca.nextLine();
        while (genreValidation(generoST, genero) == true) {
            System.out.println("Genero já se encontra na base de dados");
            System.out.print("\n-> Insira o novo genero: ");
            sca.nextLine();
            genero = sca.nextLine();
        }
        System.out.print("\n-> Descreva o genero: ");
        desc = sca.nextLine();
        Genero g = new Genero(genero, desc);
        generoST.put(genero, g);
    }

    /**
     * Grava no ficheiro generos.txt;
     *
     * @param generoST
     * @param path
     */
    public static void saveGenero(RedBlackBST_Projecto<String, Genero> generoST, String path) {
        Out o = new Out(path);
        for (String genero : generoST.keys()) {
            Genero g = (Genero) generoST.get(genero);
            o.println(g.getGenero() + ";" + g.getDescricao());
        }

    }

    /*
     * Artista
     */
    
    /**
     * Faz a validação se artista existe.
     * Se ele não existir, é criado.
     *
     * @param artistasST
     * @param generosST
     */
    public static void criarArtista(SeparateChainingHashST1<String, Artista> artistasST, RedBlackBST_Projecto<String, Genero> generosST) {
        String artista, username, genero;

        Scanner sca = new Scanner(System.in);

        System.out.print("-> Insira o nome do artista: ");
        artista = sca.nextLine();
        System.out.println("-> Insira o username do artista: ");
        username = sca.nextLine();
        while (artistValidation(artistasST, username) == true) {
            System.out.println("O artista pretendido já existe na BD!");
            System.out.print("-> Insira o nome do artista: ");
            artista = sca.nextLine();
            System.out.println("\n-> Insira o username do artista: ");
            username = sca.nextLine();
        }
        System.out.print("\n-> Insira o genero do artista: ");
        genero = sca.nextLine();
        while (genreValidation(generosST, genero) == false) {
            System.out.println("O genero pretendido não se econtra na BD!");
            System.out.print("-> Insira o genero do artista: ");
            genero = sca.nextLine();
        }
        Artista a = new Artista(artista, username, genero);
        artistasST.put(username, a);

    }

    /**
     * Remove do ficheiro artista.txt.
     * O metodo não se encontra no menu.
     * Inserir a key com o artista pretendido
     *
     * @param generoST
     * @param key
     * @return
     */
    public static SeparateChainingHashST1 deleteArtistSt(SeparateChainingHashST1 generoST, Integer key) {
        generoST.delete(key);
        return generoST;
    }

    /**
     * Grava no ficheiro artista.txt
     *
     * @param artistasST
     * @param path
     */
    public static void saveArtista(SeparateChainingHashST1<String, Artista> artistasST, String path) {
        Out o = new Out(path);
        for (String username : artistasST.keys()) {
            Artista a = (Artista) artistasST.get(username);
            o.println(a.getNome() + ";" + a.getUsername() + ";" + a.getGeneromusical());
        }

    }
    
  
    /*
     * Musica
     */
    
    /**
     * Criar  musicas.
     * Verifica se genero e artista se encontram na BD.
     *
     * @param musicaST
     * @param generoST
     * @param artistaST
     */
    public static void criarMusica(RedBlackBST_Projecto<String, Musica> musicaST, RedBlackBST_Projecto<String, Genero> generoST,
            SeparateChainingHashST1<String, Artista> artistaST) {
        String isrc, nome, artista, genero;
        String duracao;
        float daux;
        Scanner sca = new Scanner(System.in);
        System.out.print("-> Insira o ISRC: ");
        isrc = sca.nextLine();
        System.out.print("\n-> Insira o nome da musica: ");
        nome = sca.nextLine();
        System.out.print("\n-> Insira uma duração(mm.ss): ");
        duracao = sca.nextLine();
        daux = Float.parseFloat(duracao);
        System.out.print("\n-> Insira o nome do artista: ");
        artista = sca.nextLine();
        //Verifica se o artista existe na BD
        while (artistValidation(artistaST, artista) == false) {
            System.out.println("O artista pretendido não se encontra na BD!");
            System.out.print("\n-> Insira o nome do artista: ");
            artista = sca.nextLine();
        }
        System.out.print("\n-> Insira o genero: ");
        genero = sca.nextLine();
        //Verifica se o genero existe na BD
        while (genreValidation(generoST, genero) == false) {
            System.out.println(" O genero pretendido não se encontra na BD!");
            System.out.print("\n-> Insira o genero: ");
            genero = sca.nextLine();
        }

        Musica m = new Musica(isrc, nome, daux, artista, genero);
        musicaST.put(isrc, m);
        Genero g = generoST.get(genero);
        g.getGeneroMusicsST().put(isrc, m);
        Artista a = artistaST.get(artista);
        a.getArtistMusicSt().put(isrc, m);

    }

    /**
     * Imprime musicas;
     *
     * @param musicaST
     */
    public static void printMusicST(RedBlackBST_Projecto<String, Musica> musicaST) {
        long tempoInicio = System.currentTimeMillis();

        int i = 1;
        for (String isrc : musicaST.keys()) {
            Musica m = musicaST.get(isrc);
            StdOut.println(m.getISRC() + " " + m.getNome() + " " + m.getDuracao()
                    + " " + m.getArtista() + " " + m.getGenero() + "\n");

            i++;

        }
        System.out.println("Tempo Total: "+(System.currentTimeMillis()-tempoInicio));

    }

     /**
     * Verifica se a musica (ISRC) existe na Base de dados.
     * Se já existir, "aceita" fazer o update.
     *
     * @param musicaST
     * @param artistaST
     * @param generoST
     */
    public static void updateMusica(RedBlackBST_Projecto<String, Musica> musicaST, SeparateChainingHashST1<String, Artista> artistaST,
            RedBlackBST_Projecto<String, Genero> generoST) {
        Scanner sca = new Scanner(System.in);
        String isrc, opcao, editar;
        printMusicST(musicaST);

        System.out.print("\nInsira o ISRC da musica que pretende editar: ");
        isrc = sca.nextLine();
        if (isrcValidation(musicaST, isrc) == true) {
            System.out.println(isrc);
            Musica m = musicaST.get(isrc);
            if (m.getISRC().equals(isrc)) {
                do {
                    System.out.println("O que pretende editar:\n  1-ISRC\n, 2-Nome\n, 3-Duração\n, 4-Artista\n, 5-Genero\n");
                    opcao = sca.nextLine();
                    switch (opcao) {
                        case "1": {
                            System.out.println("-> Insira o novo ISRC: ");
                            editar = sca.nextLine();
                            m.setISRC(editar);
                            return;
                        }
                        case "2": {
                            System.out.println("-> Insira o novo nome: ");
                            editar = sca.nextLine();
                            m.setNome(editar);
                            Artista a = artistaST.get(m.getArtista());
                            a.getArtistMusicSt().get(isrc).setNome(editar);
                            Genero g = generoST.get(m.getGenero());
                            g.getGeneroMusicsST().get(isrc);
                            return;
                        }
                        case "3": {
                            System.out.println("-> Insira a nova duração: ");
                            editar = sca.nextLine();
                            m.setDuracao(Float.parseFloat(editar));
                            return;
                        }
                        case "4": {
                            System.out.println("-> Insira o novo artista: ");
                            editar = sca.nextLine();

                            if (artistValidation(artistaST, editar) == true) {
                                m.setArtista(editar);
                                Artista a = artistaST.get(m.getArtista());
                                a.getArtistMusicSt().delete(isrc);
                                Artista aaux = artistaST.get(editar);
                                aaux.getArtistMusicSt().put(isrc, m);

                            } else {
                                System.out.println("O artista pretendido não se encontra na BD!");
                            }

                            return;
                        }

                        case "5": {
                            System.out.println("-> Insira o novo genero: ");
                            editar = sca.nextLine();

                            if (genreValidation(generoST, editar) == true) {
                                m.setGenero(editar);
                                Genero g = generoST.get(m.getGenero());
                                g.getGeneroMusicsST().delete(isrc);
                                Genero gaux = generoST.get(editar);
                                gaux.getGeneroMusicsST().put(isrc, m);

                            } else {
                                System.out.println("O genero pretendido não se encontra na BD!");
                            }
                            return;
                        }

                    }
                } while (opcao.equals("isrc") || opcao.equals("nome") || opcao.equals("duracao") || opcao.equals("genero") || opcao.equals("artista"));
            }
        } else {
            System.out.println("A musica pretendida não se encontra numa playlist");
        }

    }

    /**
     * Remove musica do ficheiro musicas.txt;
     *
     * @param musicaST
     * @param artistaST
     * @param generoST
     */
    public static void deleteMusica(RedBlackBST_Projecto<String, Musica> musicaST,
            SeparateChainingHashST1<String, Artista> artistaST, RedBlackBST_Projecto<String, Genero> generoST) {
        Scanner sca = new Scanner(System.in);
        String delete;
        printMusicST(musicaST);
        System.out.print("\n-> Insira o ISRC da musica que pretende eliminar: ");
        delete = sca.nextLine();
        for (String isrc : musicaST.keys()) {
            Musica m = (Musica) musicaST.get(isrc); //recebe isrc
            if (m.getNome().equals(delete)) {
                musicaST.delete(isrc);
                Artista a = artistaST.get(m.getArtista());
                a.getArtistMusicSt().delete(isrc);
                Genero g = generoST.get(m.getGenero());
                g.getGeneroMusicsST().delete(isrc);
            }

        }
        System.out.println("A Musica selecionada foi removida com sucesso");

    }

    /**
     * Grava no ficheiro musicas.txt;
     *
     * @param musicaST
     * @param path
     */
    public static void saveMusica(RedBlackBST_Projecto<String, Musica> musicaST, String path) {
        Out o = new Out(path);
        for (String isrc : musicaST.keys()) {
            Musica m = (Musica) musicaST.get(isrc);
            o.println(m.getISRC() + ";" + m.getNome() + ";" + m.getDuracao() + ";" + m.getArtista() + ";" + m.getGenero());
        }

    }

    /*
     * Utilizador
     */
    
    /**
     * Cria utilizador no ficheiro pessoas.txt;
     *
     * @param utilizadorST
     * @return
     */
    public static SeparateChainingHashST1 criarUtilizador(SeparateChainingHashST1 utilizadorST) {

        In in = new In("C:\\Users\\ZeeCunha\\Desktop\\UFP\\3º ANO\\2SEMESTRE\\AED2\\aed2_1516\\src\\projeto_1//pessoas.txt"); // abertura do ficheiro/stream de entrada

        while (!in.isEmpty()) {
            String[] texto = in.readLine().split(";");
            String nome = texto[0]; //posicao do nome no txt
            String username = texto[1]; //posicao do username no txt
            String email = texto[2];    //posicao do email no txt

            Utilizador u = new Utilizador(nome, username, email);
            utilizadorST.put(username, u);
        }

        return utilizadorST;
    }

    /**
     * Remove do ficheiro pessoas.txt
     * Metodo não implementado no menu
     * Para remover, necessario inserir uma key    
     *
     * @param utilizadorST
     * @param key
     * @return
     */
    public static SeparateChainingHashST1 deleteUserSt(SeparateChainingHashST1 utilizadorST, Integer key) {
        utilizadorST.delete(key);   //elimina o utilizador com a key pretendida
        return utilizadorST;
    }

    /**
     * Grava no ficheiro pessoas.txt;
     *
     * @param utilizadoresST
     * @param path
     */
    public static void saveUtilizador(SeparateChainingHashST1<String, Utilizador> utilizadoresST, String path) {
        Out o = new Out(path);
        for (String username : utilizadoresST.keys()) {
            Utilizador u = (Utilizador) utilizadoresST.get(username);
            o.println(u.getNome() + ";" + u.getUsername() + ";" + u.getMail());
        }

    }

    /**
     * Histórico
     * @param musicasST
     * @param utilizadoresST
     * @param user
     */
    
    public static void playMusic(RedBlackBST_Projecto<String, Musica> musicasST, SeparateChainingHashST1<String, Utilizador> utilizadoresST, String user) {

        Scanner sca = new Scanner(System.in);
        Date d = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddhhmmss");
        String param;
        printMusicST(musicasST);
        System.out.println("\n\nQual é a musica que o utilizador esta a ouvir: ");
        param = sca.nextLine();
        for (String key : musicasST.keys()) {
            Musica m = musicasST.get(key);
            if (m.getISRC().equals(param)) {
                Utilizador u = utilizadoresST.get(user);
                u.getHistoricoST().put(ft.format(d), param);

            }
        }
    }
    
    /**
     * Guarda o histórico num txt
     * @param utilizadoresST
     * @param path
     */
    
    public static void savePlayedMusics(SeparateChainingHashST1<String, Utilizador> utilizadoresST, String path) {
        Out o = new Out(path);
        for (String u : utilizadoresST.keys()) {
            Utilizador utilizador = utilizadoresST.get(u);
            RedBlackBST_Projecto<String, String> h = utilizador.getHistoricoST();
            for (String key : h.keys()) {
                o.println(utilizador.getUsername() + ";" + key + ";" + h.get(key));

            }
        }

    }
    
    
    /*
     *  Testes e Listagens
     */
    
    /**
     * Listar Musicas por generos
     *
     * @param generoST
     */
    public static void printMusicByGenres(RedBlackBST_Projecto<String, Genero> generoST) {
        
        long tempoInicio = System.currentTimeMillis();

        
        StdOut.print("\n\nLista de Musica por Generos:\n\n");
        for (String g : generoST.inOrder()) {
            StdOut.println("-> Género: " + g);

            RedBlackBST_Projecto<String, Musica> musicas = generoST.get(g).getGeneroMusicsST();

            for (String isrc : musicas.keys()) {
                Musica m = (Musica) musicas.get(isrc);
                StdOut.println("      *Musica: " + m.getNome());
            }
        }
        System.out.println("Tempo Total: "+(System.currentTimeMillis()-tempoInicio));

    }

    /**
     * Listar musicas por artistas
     *
     * @param artistaST
     */
    public static void printMusicByArtist(SeparateChainingHashST1<String, Artista> artistaST) {
       long tempoInicio = System.currentTimeMillis();

        
        StdOut.print("\n\nLista de Musica por Artistas:\n\n");
        for (String a : artistaST.keys()) {
            StdOut.println("-> Artista: " + a);

            RedBlackBST_Projecto<String, Musica> musicas = artistaST.get(a).getArtistMusicSt();

            for (String isrc : musicas.keys()) {
                Musica m = (Musica) musicas.get(isrc);
                StdOut.println("    *Musica: " + m.getNome());
            }
        }
       System.out.println("Tempo Total: "+(System.currentTimeMillis()-tempoInicio));
 
    }

    /**
     * Listar musicas por playlists
     *
     * @param playlistST
     */
    public static void printMusicByPlaylist(RedBlackBST_Projecto<String, Playlist> playlistST) {
        
        long tempoInicio = System.currentTimeMillis();

        StdOut.print("\n\nLista de Playlists por Utilizadores:\n\n");
        for (String username : playlistST.keys()) {
            Playlist p = (Playlist) playlistST.get(username);
            System.out.println(p.getNome() + " de " + p.getUsername());
            RedBlackBST_Projecto<String, Musica> musicas = playlistST.get(username).getPlaylistSt();

            for (String isrc : musicas.keys()) {
                Musica m = (Musica) musicas.get(isrc);
                StdOut.println("   *Musicas: " + m.getNome());
            }
        }
       System.out.println("Tempo Total: "+(System.currentTimeMillis()-tempoInicio));
 
    }
    
    /**
     * Procura se a musica existe em alguma playlist;
     *
     * @param playlistsST
     * @param musicasST
     */
    public static void findMusicaPlaylist(RedBlackBST_Projecto<String, Playlist> playlistsST, RedBlackBST_Projecto<String, Musica> musicasST) {
        long tempoInicio = System.currentTimeMillis();

        Scanner sca = new Scanner(System.in);
        String musica;
        System.out.print("-> Insira a musica a procurar: ");
        musica = sca.nextLine();
        if (isrcValidation(musicasST, musica) == true) {
            for (String username : playlistsST.keys()) {
                Playlist pl = (Playlist) playlistsST.get(username);
                RedBlackBST_Projecto<String, Musica> musicas = playlistsST.get(username).getPlaylistSt();
                for (String isrc : musicas.keys()) {
                    Musica m = (Musica) musicas.get(isrc);
                    Playlist p = (Playlist) playlistsST.get(username);
                    if (p.getPlaylistSt().get(isrc).getISRC().equals(musica)) {
                        System.out.println("A musica pretendida encontra-se na seguinte playlist: " + p.getNome());
                    }
                }

            }
        } else {
            System.out.println("A musica pretendida não se encontra na BD!");
        }
        System.out.println("Tempo Total: "+(System.currentTimeMillis()-tempoInicio));

    }

    /**
     * Teste com todas as ST's funcionais do projeto
     *
     * @param musicaST
     * @param generoST
     * @param artistasST
     * @param playlistST
     * @param utilizadorST
     */
    
    public static void imprimirTeste(RedBlackBST_Projecto<String, Musica> musicaST, RedBlackBST_Projecto<String, Genero> generoST,
            
            SeparateChainingHashST1<String, Artista> artistasST, RedBlackBST_Projecto<String, Playlist> playlistST,
            SeparateChainingHashST1<String, Utilizador> utilizadorST) {
                 
        long tempoInicio = System.currentTimeMillis();

        System.out.println("\n-> Listagem de musicas:");
        for (String isrc : musicaST.keys()) {
            Musica m = (Musica) musicaST.get(isrc);
            System.out.println("- " + m.getNome());
        }

        System.out.println("\n-> Listagem de artistas:");
        for (String username : artistasST.keys()) {
            Artista a = (Artista) artistasST.get(username);
            System.out.println("- " + a.getNome());
        }

        System.out.println("\n-> Listagem de generos:");
        for (String genre : generoST.keys()) {
            Genero g = (Genero) generoST.get(genre);
            System.out.println("- " + g.getGenero());
        }

        System.out.println("\n-> Listagem de utilizadores:");
        for (String user : utilizadorST.keys()) {
            Utilizador u = (Utilizador) utilizadorST.get(user);
            System.out.println("- " + u.getNome());
        }

        System.out.println("\n-> Listagem de playlists:");
        for (String playlist : playlistST.keys()) {
            Playlist p = (Playlist) playlistST.get(playlist);
            System.out.println("- " + p.getNome());
        }
     System.out.println("Tempo Total: "+(System.currentTimeMillis()-tempoInicio));   
    } 


/**
 * projeto2
 *   
 **/
    
    //LOADS

/**
     * load de likes de artistas
     * @param utilizadorST
     * @param path 
     */
    public static void loadFromFileUsersLikesMusics(SeparateChainingHashST1<String, Utilizador> utilizadorST, String path) {
        In in = new In(path);

        while (!in.isEmpty()) {
            String line = in.readLine();
            String[] split = line.split(";");
            Utilizador s = (Utilizador) utilizadorST.get(split[0]);
            // array de likesMusica
            for (int i = 1; i < split.length; i++) {
                s.getLikesMusics().add(split[i]);
            }
        }
    }
/**
 * load de likes de playlist
 * @param utilizadorST
 * @param path 
 */
    public static void loadFromFileUsersLikesPlaylists(SeparateChainingHashST1<String, Utilizador> utilizadorST, String path) {
        In in = new In(path);

        while (!in.isEmpty()) {
            String line = in.readLine();
            String[] split = line.split(";");
            Utilizador s = (Utilizador) utilizadorST.get(split[0]);
            // array de Likeslaylists
            for (int i = 1; i < split.length; i++) {
                s.getLikesPlaylists().add(split[i]);
            }
        }
    }
/**
 * load de likes de artistas
 * @param utilizadorST
 * @param path 
 */
    public static void loadFromFileUsersLikesArtists(SeparateChainingHashST1<String, Utilizador> utilizadorST, String path) {
        In in = new In(path);

        while (!in.isEmpty()) {
            String line = in.readLine();
            String[] split = line.split(";");
            Utilizador s = (Utilizador) utilizadorST.get(split[0]);
            //array de likeartistas
            for (int i = 1; i < split.length; i++) {
                s.getLikesArtists().add(split[i]);
            }
        }
    }

/**
 * Imprime os likes dos utilizadores em artistas
 * @param utilizadorST
 * @param username 
 */
    public static void printLikesArtistas(SeparateChainingHashST1<String, Utilizador> utilizadorST, String username) {
        long tempoInicio = System.currentTimeMillis();
        Utilizador s = utilizadorST.get(username);
        System.out.println("Estes sao os artistas em que o/a " + username + " gosta:\n");
        for (String name : s.getLikesArtists()) {
            System.out.println(name);
        }
        System.out.println("Tempo Total: "+(System.currentTimeMillis()-tempoInicio));
    }
/**
 * Imprime os likes dos utilizadores em Playlists
 * @param utilizadorST
 * @param username 
 */
    public static void printLikesPlaylists(SeparateChainingHashST1<String, Utilizador> utilizadorST, String username) {
        
        long tempoInicio = System.currentTimeMillis();
        Utilizador s = utilizadorST.get(username);
        System.out.println("\nEstas sao as playlists em que o/a " + username + " gosta:\n");
        for (String name : s.getLikesPlaylists()) {
            System.out.println(name);
        }
        System.out.println("Tempo Total: "+(System.currentTimeMillis()-tempoInicio));
    }
/**
 * Imprime os likes dos utilizadores em musicas
 * @param utilizadorST
 * @param username 
 */
    public static void printLikesMusicas(SeparateChainingHashST1<String, Utilizador> utilizadorST, String username) {
        
        long tempoInicio = System.currentTimeMillis();
        Utilizador s = utilizadorST.get(username);
        System.out.println("\nEstas sao as musicas em que o/a " + username + " gosta:\n");
        for (String music : s.getLikesMusics()) {
            System.out.println(music);
        }
       System.out.println("Tempo Total: "+(System.currentTimeMillis()-tempoInicio));
    }


/**
 * Dar like num artista
 * @param utilizadorST
 * @param artistaST
 * @param username 
 */
    public static void UserArtistLike(SeparateChainingHashST1<String, Utilizador> utilizadorST, SeparateChainingHashST1<String, Artista> artistaST, String username) {
        String artista;
        System.out.println("Qual é o artista que pretende fazer like: ");
        Scanner sca = new Scanner(System.in);
        Utilizador user = utilizadorST.get(username);
        artista = sca.nextLine();
        for (String s : user.getLikesArtists()) {
            if (artista.compareTo(s) == 0) {
                return;
            }
        }
        user.getLikesArtists().add(artista);
    }
    
    
    /**
 * guardar os likes em artistas
 * @param utilizadorST
 * @param path 
 */
    public static void saveLikesArtists(SeparateChainingHashST1<String, Utilizador> utilizadorST, String path) {
        Out o = new Out(path);

        for (String username : utilizadorST.keys()) {
            Utilizador s = utilizadorST.get(username);
            if (s.getLikesArtists().isEmpty()) {
                continue;
            }
            int aux = 1;
            StringBuilder sb = new StringBuilder();
            sb.append(s.getUsername()).append(";");
            for (String name : s.getLikesArtists()) {
                if (aux == s.getLikesArtists().size()) {
                    sb.append(name);
                } else {
                    sb.append(name).append(";");
                }
                aux++;
            }
            o.println(sb.toString());
        }
    }

/**
 * Dar like numa musica
 * @param utilizadorST
 * @param musicasST
 * @param ISRC 
 */
    public static void UserMusicasLike(SeparateChainingHashST1<String, Utilizador> utilizadorST, RedBlackBST_Projecto<String, Musica> musicasST, String ISRC) {
        String musica;
        System.out.println("Qual é o IRSC da musica  que pretende fazer like: ");
        Scanner sca = new Scanner(System.in);
        Utilizador user = utilizadorST.get(ISRC);
        musica = sca.nextLine();
        for (String s : user.getLikesMusics()) {
            if (musica.compareTo(s) == 0) {
                return;
            }
        }
        user.getLikesMusics().add(musica);
    }

/**
 * gravar os likes do utilizador no ficheiro
 * @param utilizadorST
 * @param path 
 */
    public static void saveLikesMusics(SeparateChainingHashST1<String, Utilizador> utilizadorST, String path) {
        Out o = new Out(path);

        for (String username : utilizadorST.keys()) {
            Utilizador s = utilizadorST.get(username);
            if (s.getLikesMusics().isEmpty()) {
                continue;
            }
            int aux = 1;
            StringBuilder sb = new StringBuilder();
            sb.append(s.getUsername()).append(";");
            for (String music : s.getLikesMusics()) {
                if (aux == s.getLikesMusics().size()) {
                    sb.append(music);
                } else {
                    sb.append(music).append(";");
                }
                aux++;
            }
            o.println(sb.toString());
        }
    }


/**
 * Dar like numa playlist
 * @param utilizadorST 
 * @param playlistsST 
 * @param nome 
 */
    public static void UserPlaylistsLike(SeparateChainingHashST1<String, Utilizador> utilizadorST, RedBlackBST_Projecto<String, Playlist> playlistsST, String nome) {
        String playlist;
        System.out.println("Qual é o nome da playlist  que pretende fazer like: ");
        Scanner sca = new Scanner(System.in);
        Utilizador user = utilizadorST.get(nome);
        playlist = sca.nextLine();
        for (String s : user.getLikesPlaylists()) {
            if (playlist.compareTo(s) == 0) {
                return;
            }
        }
        user.getLikesMusics().add(playlist);
    }

/**
 * GUARDAR likes dos utilizadores em playslsts
 * @param utilizadorST
 * @param path 
 */
    public static void saveLikesPlaylists(SeparateChainingHashST1<String, Utilizador> utilizadorST, String path) {
        Out o = new Out(path);

        for (String username : utilizadorST.keys()) {
            Utilizador s = utilizadorST.get(username);
            if (s.getLikesPlaylists().isEmpty()) {
                continue;
            }
            int aux = 1;
            StringBuilder sb = new StringBuilder();
            sb.append(s.getUsername()).append(";");
            for (String name : s.getLikesPlaylists()) {
                if (aux == s.getLikesPlaylists().size()) {
                    sb.append(name);
                } else {
                    sb.append(name).append(";");
                }
                aux++;
            }
            o.println(sb.toString());
        }
    }
    
 /**
 * imprimir o SymbolWDigraph de seguidores
 * @param g
 * @param type 
 */
    public static void printFollowUsers(SymbolWeightedDigraph g, boolean type) {
        
        long tempoInicio = System.currentTimeMillis();
        String[] keys = g.getKeys();
        String NEWLINE = System.getProperty("line.separator");
        StringBuilder s = new StringBuilder();
        for (int v = 0; v < g.G().V(); v++) {
            for (DirectedEdge e : g.G().adj(v)) {
                s.append(keys[e.from()]).append(" -> ").append(keys[e.to()]).append(" ").append(String.format("%5.2f ", e.weight()));
            }
            s.append(NEWLINE);
        }
        System.out.println(s);
        System.out.println("Tempo Total: "+(System.currentTimeMillis()-tempoInicio));

    }   
    
    /**
 * imprimir os amigos
 * @param g
 * @param type 
 */
    public static void printFriendshipsGraph(SymbolWeightedGraph g, boolean type) {
        
        long tempoInicio = System.currentTimeMillis();
        String[] keys = g.getKeys();
        String NEWLINE = System.getProperty("line.separator");
        StringBuilder s = new StringBuilder();
        for (int v = 0; v < g.G().V(); v++) {
            for (Edge e : g.G().adj(v)) {
                s.append(keys[e.either()]).append(" -> ").append(keys[e.other(e.either())]).append(" ").append(String.format("%5.2f ", e.weight()));
            }
            s.append(NEWLINE);
        }
        System.out.println(s);

        if (type) {
            g.printSymbolGraph();
        }
               System.out.println("Tempo Total: "+(System.currentTimeMillis()-tempoInicio));

    }
 
}