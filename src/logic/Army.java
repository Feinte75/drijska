package logic;

import entities.Troop;
import entities.Village;
import graphic.opengl.Primitive;
import graphic.opengl.Square;
import graphic.opengl.Triangle;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by feinte on 14/01/2015.
 * Represents either a player or a bot
 * Stores units
 */
public class Army {

    private ArrayList<Troop> troops;
    private ArrayList<Primitive> troopsPrimitives;
    private ArrayList<Village> villages;
    private ArrayList<Primitive> villagePrimitives;

    private Color color;
    private final float colorValues[];

    public Army(Color color) {
        troops = new ArrayList<Troop>(50);
        troopsPrimitives = new ArrayList<Primitive>(2);
        troopsPrimitives.add(new Square(20));

        villages = new ArrayList<Village>(10);
        villagePrimitives = new ArrayList<Primitive>(2);
        villagePrimitives.add(new Triangle(20, 20));

        this.color = color;
        colorValues = color.getRGBComponents(null);
        System.out.println(colorValues[0] + " " + colorValues[1] + " " + colorValues[2] + " " + colorValues[3]);
    }

    public void buildVillage(float x, float y)
    {
        villages.add(new Village(this, x, y, villagePrimitives));
    }

    public void spawnTroop(float x, float y)
    {
        troops.add(new Troop(this, x, y, troopsPrimitives));
    }

    public float[] getColorArray() {
        return colorValues;
    }

    public Color getColor(){
        return color;
    }

    public ArrayList<Troop> getTroops() {
        return troops;
    }

    public ArrayList<Village> getVillages() {
        return villages;
    }
}
