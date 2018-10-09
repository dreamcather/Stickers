package VisualGame;

import Game.StickGame;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class GameScene {
    private int  height;
    private int widht;
    private int fieldWidth;
    private int xStart;
    private int yStart;
    private final int borderWidth = 5;
    private int count;
    private GameBackground sceneBackground;
    private GameBorder sceneBorder;
    private PointModel[][] pointArray;
    private ArrayList<EdgeModel> edgesList;
    private Pane anchorPane;
    StickGame stickGame;
    private int firstClickedPoint=-1;
    private int secondClickedPoint=-1;

    public GameScene(int xStart, int yStart,int width,int height, int squareCount, Pane anchorPane) {
        this.xStart = xStart;
        this.yStart = yStart;
        this.count = squareCount+1;
        this.height= height;
        this.widht = width;
        fieldWidth = width/(count+1);
        stickGame = new StickGame(squareCount);
        this.anchorPane = anchorPane;
        sceneBackground = new GameBackground(xStart+ borderWidth,yStart+ borderWidth,
                width- borderWidth,height - borderWidth);
        sceneBorder = new GameBorder(xStart,yStart,width,height, borderWidth);
        edgesList = new ArrayList<>();
        pointArray = new PointModel[count][count];
        for( int i =0;i< count;i++){
            for(int j=0;j<count;j++){
                pointArray[i][j] = new PointModel(xStart+borderWidth+(i+1)* fieldWidth,yStart+borderWidth+(j+1)* fieldWidth,
                        fieldWidth/5);
            }
        }

    }

    public void addEdge(int first, int second){
        PointModel start = pointArray[first%count][first/count];
        PointModel end = pointArray[second%count][second/count];
        EdgeModel edgeModel = new EdgeModel(start.getCenter(),end.getCenter(),fieldWidth/10);
        edgeModel.show(anchorPane);
        edgesList.add(edgeModel);
        start.refresh();
        end.refresh();

    }
    public void show() {
        sceneBackground.show(anchorPane);
        sceneBorder.show(anchorPane);
        for( int i =0;i< count;i++) {
            for (int j = 0; j < count; j++) {
                pointArray[i][j].show(anchorPane);
            }
        }
    }
    public void hide() {

    }

    public int findClickedPoint(Point2D point){
        int res =-1;
        for(int i=0;i<count;i++)
            for (int j =0;j<count;j++)
                if(pointArray[i][j].isNear(point)){
                    res = j*count+i;
                    if(firstClickedPoint==-1){
                        firstClickedPoint =res;
                        active(res);
                        return res;
                    }
                    if(firstClickedPoint==res){
                        firstClickedPoint =-1;
                        disactive(res);
                        return res;
                    }
                    if(secondClickedPoint==-1){
                        if(stickGame.getStickNumber(firstClickedPoint,res)!=-1) {
                            secondClickedPoint = res;
                            active(res);
                            if (stickGame.getStickNumber(firstClickedPoint, secondClickedPoint) != -1) {
                                addEdge(firstClickedPoint, secondClickedPoint);
                                firstClickedPoint =-1;
                                secondClickedPoint=-1;
                            }
                            return res;
                        }
                    }
                }
                return res;
    }

    public void active(int number){
        pointArray[number%count][number/count].active();
    }

    public void disactive(int number){
        pointArray[number%count][number/count].disactive();
    }
}
