import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Painel_De_Pontuação here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PaineldePontuacao extends Actor
{
    private GreenfootImage painel;
    
    public PaineldePontuacao(){
        painel = new GreenfootImage("ScorePainel.png"); //Inicia a nova propriedade
        setImage(painel);    
    }
    
    public void mostrarStatus(int vidas, int pontos){
    //criar uma cópia do painel atualizado
    GreenfootImage painelAtualizado = new GreenfootImage(painel);
    //Definido a cor do texto como Branca
    painelAtualizado.setColor(Color.WHITE);
    //Desenhando o texto das vidas e da pontuação na cópia da imagem do painel.
    painelAtualizado.drawString("Vidas: " + vidas, 30, 40);
    painelAtualizado.drawString("Pontos: " + pontos, 30, 60);
    //Mudando a imagem do objeto para a imagem atualizada
    setImage(painelAtualizado);
    
    }
    
    
    /**
     * Act - do whatever the Painel_De_Pontuação wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
}
