import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RobotWorld here.
 * 
 * @author Leonardo Abrantes Melo
 * @version 14/06/2024
 */
public class RobotWorld extends World
{
    
    
    /**
     * Constructor for objects of class RobotWorld.
     * 
     */
    public RobotWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        prepare();
    }
    
    
    private void prepare(){
        Robo player = new Robo();
        addObject(player, 48, 50);
        
        Parede parede = new Parede();
        addObject(parede, 48, 147);
        Parede parede2 = new Parede();
        addObject(parede2, 52, 147);
        Parede parede3 = new Parede();
        addObject(parede3, 159, 147);
        Parede parede4 = new Parede();
        addObject(parede4, 266, 147);
        Parede parede5 = new Parede();
        addObject(parede5, 587, 147);
        Parede parede6 = new Parede();
        addObject(parede6, 692, 147);
        Parede parede7 = new Parede();
        addObject(parede7, 791, 147);
        Parede parede8 = new Parede();
        addObject(parede8, 585, 255);
        
        Bloco bloco = new Bloco ();
        addObject(bloco, 427, 145);
        Bloco bloco2 = new Bloco ();
        addObject(bloco2, 579, 435);
        
        Casa casa = new Casa();
        addObject(casa, 751, 552);
        
        PaineldePontuacao painel = new PaineldePontuacao();
        addObject(painel, 71, 554);
        
        Pizza pizza = new Pizza();
        addObject(pizza, 720, 46);
        Pizza pizza1 = new Pizza();
        addObject(pizza1, 443, 38);
        Pizza pizza2 = new Pizza();
        addObject(pizza2, 183, 302);
        Pizza pizza3 = new Pizza();
        addObject(pizza3, 682, 312);
        Pizza pizza4 = new Pizza();
        addObject(pizza4, 417, 537);
        
        
    }



}
