package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import javax.swing.text.Position;
import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    private static final int WIDTH = 28;
    private static final int HEIGHT = 30;

    /** add a row in start at x,y */
    private static void addrow(TETile[][] world,
                               int x, int y, int len,
                               TETile tile)
    {

        for(int j=0;j<len;j++){
            world[x+j][y] = TETile.colorVariant(tile,100,100,100,new Random());
        }
    }
    /** add a Heaxgon of specific length at position x,y */
    public static void addHeaxgon(TETile[][] world,
                           int x, int y, int len,
                           TETile tile)
    {
        /** draw top triangle of the heaxgon */
        for(int i = 0;i < len;i++){
            addrow(world,x-i,y-i,len+2*i,tile);
        }
        int x_start = x - len + 1;
        int y_start = y - len;
        int len_start = len + 2*(len-1);
        /** draw bottle triangle of the heaxgon */
        for(int i=0;i<len;i++){
            addrow(world,x_start+i,y_start-i,len_start-2*i,tile);
        }

    }

    public static void main(String[] args){
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);

        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }
        addHeaxgon(world,2,23,3,Tileset.MOUNTAIN);
        addHeaxgon(world,2,17,3,Tileset.GRASS);
        addHeaxgon(world,2,11,3,Tileset.GRASS);

        addHeaxgon(world,7,26,3,Tileset.GRASS);
        addHeaxgon(world,7,20,3,Tileset.MOUNTAIN);
        addHeaxgon(world,7,14,3,Tileset.MOUNTAIN);
        addHeaxgon(world,7,8,3,Tileset.FLOWER);

        addHeaxgon(world,12,29,3,Tileset.TREE);
        addHeaxgon(world,12,23,3,Tileset.MOUNTAIN);
        addHeaxgon(world,12,17,3,Tileset.MOUNTAIN);
        addHeaxgon(world,12,11,3,Tileset.MOUNTAIN);
        addHeaxgon(world,12,5,3,Tileset.MOUNTAIN);

        addHeaxgon(world,17,26,3,Tileset.FLOWER);
        addHeaxgon(world,17,20,3,Tileset.LOCKED_DOOR);
        addHeaxgon(world,17,14,3,Tileset.TREE);

        addHeaxgon(world,22,23,3,Tileset.FLOWER);
        addHeaxgon(world,22,17,3,Tileset.TREE);
        addHeaxgon(world,22,11,3,Tileset.LOCKED_DOOR);




        ter.renderFrame(world);
    }
}
