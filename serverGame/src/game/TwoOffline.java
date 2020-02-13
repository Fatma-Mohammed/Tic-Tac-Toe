/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author safaa
 */
public class TwoOffline {
    char []arr;
    char player='x';
    char win;
    boolean flag;
    int count;
    int[] Database_order;
    TwoOffline()
    {
        count = 0;
        win = 0;
        player = 'x';
        flag=false;
        arr = new char[9];
        for(int i=0; i<9 ; i++)
        {
            arr[i]=0;
        }
        Database_order = new int[9];
    }
    
    public boolean start(int i)
    {
        flag=false;
        if (count<9)
        {
            if(arr[i]!=0)
            {
                System.out.println("this block is already used, enter again");
            }
            else
            {
                arr[i] = player;
                Database_order[count] = i;
                changPlayer();
                count++;
                flag = true;
            }
        }
        return flag;
    }
    
    public char whoWon()
    {
        winGame();
        if(win!=0)
        {
            System.out.println("Game ended "+win+" won");
        }
        else if(win==0 && count==9)
        {
            System.out.println("No one won");
            win = 't';
        }
        return win;
    }
    
    public void winGame()
    {
        /***********************check horizontal*******************************/
        if(arr[0]==arr[1] && arr[0]==arr[2] && arr[0]!=0) win = arr[0];         
        else if (arr[3]==arr[4] && arr[3]==arr[5] && arr[3]!=0) win = arr[3];   
        else if (arr[6]==arr[7] && arr[6]==arr[8] && arr[6]!=0) win = arr[6];   
        /************************check diagonal********************************/
        else if (arr[0]==arr[4] && arr[0]==arr[8] && arr[0]!=0) win = arr[0];   
        else if (arr[2]==arr[4] && arr[2]==arr[6] && arr[2]!=0) win = arr[2];
        /***********************check vertical*******************************/
        else if (arr[0]==arr[3] && arr[0]==arr[6] && arr[0]!=0) win = arr[0];    
        else if (arr[1]==arr[4] && arr[1]==arr[7] && arr[1]!=0) win = arr[1];
        else if (arr[2]==arr[5] && arr[2]==arr[8] && arr[2]!=0) win = arr[2];
        
    }
    void changPlayer()
    {
        if (player =='x')
        {
            player = 'o';
        }
        else if (player =='o')
        {
            player = 'x';
        }
    }
}
