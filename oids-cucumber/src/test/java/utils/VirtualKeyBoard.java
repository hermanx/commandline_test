package utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class VirtualKeyBoard extends Robot
{

    public VirtualKeyBoard() throws AWTException
    {
        super();
    }

    public void pressKeys(String keysCombination) throws IllegalArgumentException
    {
            for (String key : keysCombination.split("\\+"))
            {
                try
                {   System.out.println(key);
                    this.keyPress((int) KeyEvent.class.getField("VK_" + key.toUpperCase()).getInt(null));

                } catch (IllegalAccessException e)
                {
                    e.printStackTrace();

                }catch(NoSuchFieldException e )
                {
                    throw new IllegalArgumentException(key.toUpperCase()+" is invalid key\n"+"VK_"+key.toUpperCase() + " is not defined in java.awt.event.KeyEvent");
                }


            }


    }


    public void releaseKeys(String keysConbination) throws IllegalArgumentException
    {

            for (String key : keysConbination.split("\\+"))
            {
                try
                { // KeyRelease method inherited from java.awt.Robot
                    this.keyRelease((int) KeyEvent.class.getField("VK_" + key.toUpperCase()).getInt(null));
                } catch (IllegalAccessException e)
                {
                    e.printStackTrace();
                }catch(NoSuchFieldException e )
                {
                    throw new IllegalArgumentException(key.toUpperCase()+" is invalid key\n"+"VK_"+key.toUpperCase() + " is not defined in java.awt.event.KeyEvent");
                }
            }
    }
    
    private void type(String s)
    {
      byte[] bytes = s.getBytes();
      for (byte b : bytes)
      {
        int code = b;
        // keycode only handles [A-Z] (which is ASCII decimal [65-90])
        if (code > 96 && code < 123) code = code - 32;
        robot.delay(40);
        robot.keyPress(code);
        robot.keyRelease(code);
      }
}