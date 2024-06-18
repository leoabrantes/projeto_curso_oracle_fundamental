import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class Robo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Robo extends Actor
{
    private GreenfootImage robotimage1;
    private GreenfootImage robotimage2;
    private GreenfootImage currentImage;
    private GreenfootImage gameoverImage;

    private int animationDelay;
    private int lives;
    private int score;
    private PaineldePontuacao painel;
    private int pizzaEaten;
    
    public void showStatus(){
        if (painel != null) {
            painel.mostrarStatus(lives, score);
            }
             //criar painel com pontuação
            World mundo = getWorld();
            /* O código abaixo verifica se a lista "paineis" contém algum elemento.
             * Se o tamanho da lista for maior que zero, a variável painel é iniciada com o primeiro elemento da lista paineis. Isso garante que "paineis
             */
            List<PaineldePontuacao> paineis = mundo.getObjects(PaineldePontuacao.class);
            mundo.getObjects(PaineldePontuacao.class);
            if (!paineis.isEmpty()) {
                painel = paineis.get(0);
            
            }
        
    
    }
    
    
    
    
    
    public Robo(){
        robotimage1 = new GreenfootImage("man01.png");
        robotimage2 = new GreenfootImage("man02.png");
        currentImage = robotimage1;
        gameoverImage = new GreenfootImage("gameover.png");
        animationDelay = 5; //inicializando o atraso da animação com 5 atos.
        lives = 3;
        score = 0;
        pizzaEaten = 0;
        
    }
    
        
    
   public void animate(){
        animationDelay--; // decrementando o atraso da animação
        if(animationDelay == 0) {
            if(currentImage.equals(robotimage1)) {
                currentImage = robotimage2;
                setImage(currentImage);
            }
            else {
                currentImage = robotimage1;
                setImage(currentImage);
            }
            animationDelay = 5; // reiniciar o valor do atraso da animação.
        }
        
        
    }
    
       
    
    public void act()
    {
        showStatus();
        robotMoviment();
        detectWallCollision();
        detectBlockCollision();
        detectHomeCollision();
        eatPizza();
    }
    
    //Esse método faz com que o Robo, ande para todos os lados com velocidade = 1
    public void robotMoviment(){
        int X = getX();
        int Y = getY();
       
              
        if (Greenfoot.isKeyDown("up")){
            Y = Y - 1;
        }
        if (Greenfoot.isKeyDown("down")){
            Y = Y + 1;
        }
        if (Greenfoot.isKeyDown("left")){
            X = X - 1;
        }
        if (Greenfoot.isKeyDown("right")){
            X = X + 1;
        }
        setLocation(X,Y);
        if (Greenfoot.isKeyDown("right")){
            animate();
        }
        if (Greenfoot.isKeyDown("left")){
            animate();
        }
         if (Greenfoot.isKeyDown("up")){
            animate();
        }
        if (Greenfoot.isKeyDown("down")){
            animate();
        }
    }
    
    public void detectWallCollision() {
        if (isTouching(Parede.class)){
            setLocation(48, 50);
            Greenfoot.playSound("eat.wav");
            removeLife();
        }
    }
    
     public void detectBlockCollision() {
        if (isTouching(Bloco.class)){
            setLocation(48, 50);
            removeLife();
            Greenfoot.playSound("hurt.wav");
        }
    }
    
     public void detectHomeCollision() {
        if (isTouching(Casa.class)){
            if(getWorld().getObjects(Pizza.class).isEmpty()){
            setLocation(48, 50);
            Greenfoot.playSound("yipee.wav");
            increaseScore();
            }
            
        }
    }
    
    public void eatPizza() {
        if (isTouching(Pizza.class)){
            removeTouching(Pizza.class);
            Greenfoot.playSound("eat.wav");
            increaseScore();
        }
    }
    
    public int increaseScore(){
        score++;
        showStatus();
        return score;
    }
    
    private void removeLife() {
        if (lives>0) {
            lives--;
            showStatus();
            testEndGame();
        }
    }
    
    public void testEndGame(){
        if (lives <= 0) {
            setImage(gameoverImage);
            Greenfoot.playSound("game-over.wav");
            Greenfoot.stop();
           
        }
    }
}
