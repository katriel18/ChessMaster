package osti.katriel;
import java.awt.*;
import javax.swing.*;

import osti.katriel.logs.ConsoleLog;
import osti.katriel.logs.FileLog;
import osti.katriel.logs.Log;
// -------------------------------------------------------------------------
/**
 * The main panel of the Chess game.
 * 
 * @author Ben Katz (bakatz)
 * @author Myles David II (davidmm2)
 * @author Danielle Bushrow (dbushrow)
 * @version 2010.11.17
 */
public class ChessPanel
    extends JPanel{
    private ChessMenuBar    menuBar;
    private ChessGameBoard  gameBoard;
    private Log gameLog;
    private ChessGraveyard  playerOneGraveyard;
    private ChessGraveyard  playerTwoGraveyard;
    private ChessGameEngine gameEngine;
    // ----------------------------------------------------------
    /**
     * Create a new ChessPanel object.
     */
    public ChessPanel(){
        this.setLayout( new BorderLayout() );
        menuBar = new ChessMenuBar();
        gameBoard = new ChessGameBoard();
        
        playerOneGraveyard = new ChessGraveyard( "Player 1's graveyard" );
        playerTwoGraveyard = new ChessGraveyard( "Player 2's graveyard" );
        this.add( menuBar, BorderLayout.NORTH );
        this.add( gameBoard, BorderLayout.CENTER );

        strategyLogger();
        
        this.add( playerOneGraveyard, BorderLayout.WEST );
        this.add( playerTwoGraveyard, BorderLayout.EAST );
        this.setPreferredSize( new Dimension( 800, 600 ) );
        gameEngine = new ChessGameEngine( gameBoard ); // start the game


        
    }
    // ----------------------------------------------------------
    /**
     * Gets the logger object for use in other classes.
     * 
     * @return ChessGameLog the ChessGameLog object
     */
    public Log getGameLog(){
        return gameLog;
    }
    // ----------------------------------------------------------
    /**
     * Gets the board object for use in other classes.
     * 
     * @return ChessGameBoard the ChessGameBoard object
     */
    public ChessGameBoard getGameBoard(){
        return gameBoard;
    }
    // ----------------------------------------------------------
    /**
     * Gets the game engine object for use in other classes
     * 
     * @return ChessGameEngine the ChessGameEngine object
     */
    public ChessGameEngine getGameEngine(){
        return gameEngine;
    }
    // ----------------------------------------------------------
    /**
     * Gets the appropriate graveyard object for use in other classes.
     * 
     * @param whichPlayer
     *            the number of the player (1 or 2)
     * @return ChessGraveyard the graveyard requested
     */
    public ChessGraveyard getGraveyard( int whichPlayer ){
        if ( whichPlayer == 1 ){
            return playerOneGraveyard;
        }
        else if ( whichPlayer == 2 ){
            return playerTwoGraveyard;
        }
        else
        {
            return null;
        }
    }

    public void strategyLogger(){

        int  i=0;
        do{
            
        i= Integer.parseInt( JOptionPane.showInputDialog(null, "Tipo de Logger"));
       
        if(i==0){
            gameLog=new ChessGameLog();
            this.add((ChessGameLog)gameLog, BorderLayout.SOUTH );
        }else if(i==1){
            gameLog=new ConsoleLog();
            this.add((ConsoleLog)gameLog, BorderLayout.SOUTH );
        }else if(i==2){
            gameLog=new FileLog();
            this.add((FileLog)gameLog, BorderLayout.SOUTH );
        }else{
            JOptionPane.showMessageDialog(null, "Logger no valido!");
        }

    }while(i!= 0 && i!=1 && i!=2);

    }

}
