package objects;
import javafx.scene.image.Image;
import objects.cellEnum.CellType;

import java.io.File;
import java.io.FileInputStream;
import java.util.Random;

public class Cell
{
    private final CellType type;
    private final Image image;

    private Cell(CellType type, Image image)
    {
        this.type = type;
        this.image = image;
    }

    public static Cell random()
    {
        CellType[] types = CellType.values();

        switch (types[new Random().nextInt(CellType.values().length)])
        {
            case Seven -> {
                return seven();
            }
            case Apple -> {
                return apple();
            }
            case Cherry -> {
                return cherry();
            }
            case Coin -> {
                return coin();
            }
            case Crown -> {
                return crown();
            }
            case Lemon -> {
                return lemon();
            }
        }
        return null;
    }

    // -----types of cells-----
    public static Cell seven()
    {
        Image img;
        try
        {
            img =  new Image(new FileInputStream(createPathToImage("seven.png")));
        }
        catch (Exception e)
        {
            img = null;
        }
        return new Cell(CellType.Seven, img);
    }
    public static Cell apple()
    {
        Image img;
        try
        {
            img =  new Image(new FileInputStream(createPathToImage("apple.png")));
        }
        catch (Exception e)
        {
            img = null;
        }
        return new Cell(CellType.Apple, img);
    }
    public static Cell cherry()
    {
        Image img;
        try
        {
            img =  new Image(new FileInputStream(createPathToImage("cherry.png")));
        }
        catch (Exception e)
        {
            img = null;
        }
        return new Cell(CellType.Cherry, img);
    }
    public static Cell coin()
    {
        Image img;
        try
        {
            img =  new Image(new FileInputStream(createPathToImage("coin.png")));
        }
        catch (Exception e)
        {
            img = null;
        }
        return new Cell(CellType.Coin, img);
    }
    public static Cell crown()
    {
        Image img;
        try
        {
            img =  new Image(new FileInputStream(createPathToImage("crown.png")));
        }
        catch (Exception e)
        {
            img = null;
        }
        return new Cell(CellType.Crown, img);
    }
    public static Cell lemon()
    {
        Image img;
        try
        {
            img =  new Image(new FileInputStream(createPathToImage("lemon.png")));
        }
        catch (Exception e)
        {
            img = null;
        }
        return new Cell(CellType.Lemon, img);
    }
    // ------------------------

    public static String createPathToImage(String imgName){
        return String.format("%s\\src\\main\\resources\\images\\%s", new File("").getAbsolutePath(), imgName);
    }

    public CellType getType()
    {
        return type;
    }

    public Image getImage() {
        return image;
    }
}
