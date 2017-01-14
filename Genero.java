/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_1;


/**
 *
 * @author José Cunha
 */
public class Genero {

    private String genero; // chave unica
    private String descricao; // chave unica
    private RedBlackBST_Projecto<String, Musica> generoMusicsSt = new RedBlackBST_Projecto<>(); // musicas deste genero

    /**
     *
     * @param genero
     * @param descricao
     */
    public Genero(String genero, String descricao) {
        this.genero = genero;
        this.descricao = descricao;
    }

    /**
     *
     * @return
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     *
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Get  genero
     *
     * @return the value of genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Set genero
     *
     * @param genero new value of genero
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Get  generoMusicsSt
     *
     * @return the value of generoMusicsSt
     */
    public RedBlackBST_Projecto getGeneroMusicsST() {
        return generoMusicsSt;
    }

    /**
     * Set generoMusicsSt
     *
     * @param generoMusicsST new value of generoMusicsSt
     */
    public void setGeneroMusicsSt(RedBlackBST_Projecto generoMusicsST) {
        this.generoMusicsSt = generoMusicsST;
    }

}
