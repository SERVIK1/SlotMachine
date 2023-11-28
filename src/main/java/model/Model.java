package model;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import objects.Cell;

public class Model
{
    public static Model instance;
    private Model() { }

    private Cell[] finalCells;


    public static Model getInstance()
    {
        if (instance == null)
        {
            instance = new Model();
        }
        return instance;
    }

    public void generateCells(HBox cells)
    {
        finalCells = new Cell[3];

        for (int i = 0; i < cells.getChildren().toArray().length; i++)
        {
            var box = (VBox) cells.getChildren().get(i);
            for (int j = 0; j < box.getChildren().toArray().length - 1; j++)
            {
                Cell cell = Cell.random();

                if (j == 0)
                {
                    ((ImageView)box.getChildren().get(box.getChildren().toArray().length - 1)).setImage(((ImageView)box.getChildren().get(0)).getImage());
                }

                ((ImageView)box.getChildren().get(j)).setImage(cell.getImage());
                if (j == 0)
                    finalCells[i] = cell;
            }
        }
    }

    public boolean isWin()
    {
        return (finalCells[0].getType() == finalCells[1].getType()) && (finalCells[1].getType() == finalCells[2].getType());
    }
}
