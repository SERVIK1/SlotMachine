package controllers;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.util.Duration;
import model.Model;

import java.io.File;
import java.io.FileInputStream;

public class ViewController
{
    @FXML
    private HBox cellsBox;
    @FXML
    private Button startButton;
    @FXML
    private ImageView resultImage;

    private Double shiftImages = null;

    public void onButtonPressed()
    {
        if (shiftImages == null)
        {
            shiftImages = cellsBox.getTranslateY();
        }

        startButton.setDisable(true);
        Model.getInstance().generateCells(cellsBox);
        roll();
    }

    private void roll()
    {
        resultImage.setImage(null);
        cellsBox.setTranslateY(shiftImages);

        double ANIM_TIME = 2000;
        TranslateTransition tt = new TranslateTransition(Duration.millis(ANIM_TIME), cellsBox);
        tt.setByY(shiftImages * (-1));
        tt.setOnFinished((finish) -> endRoll());
        tt.play();
    }
    private void endRoll()
    {
        if (Model.getInstance().isWin())
        {
            try
            {
                resultImage.setImage(new Image(new FileInputStream(String.format("%s\\src\\main\\resources\\images\\%s", new File("").getAbsolutePath(), "celebrant.png"))));
            }
            catch (Exception e)
            {
                resultImage.setImage(null);
            }
        }
        else
        {
            try
            {
                resultImage.setImage(new Image(new FileInputStream(String.format("%s\\src\\main\\resources\\images\\%s", new File("").getAbsolutePath(), "lose.png"))));
            }
            catch (Exception e)
            {
                resultImage.setImage(null);
            }
        }
        startButton.setDisable(false);
    }
}