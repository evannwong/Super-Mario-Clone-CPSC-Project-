import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;


public class Graphics{
  /**
  *  An ImageView is created in order to pull in the specific image to use for the character.
  *  The width, height, x coord, and y coord are set inside of Game.java.
  */
  Image temp = new Image("/Images/alejandro-1.png");
  ImageView player = new ImageView(temp);

  /**
  *  Node created to pull in the image to use for the enemy.
  *  The dimensions and coordinates for the image are set inside of this method.
  */
  public ImageView createEnemy(int x, int y){
    Image temp = new Image("/Images/goombaFIX.png");
    ImageView entity = new ImageView(temp);
    entity.setTranslateX(x);
    entity.setTranslateY(y);
    entity.setFitWidth(28);
    entity.setFitHeight(30);
    return entity;
  }

  /**
  *  Node created to set hit boxes and boundaries for the level.
  */
  public Node createEntity(int x, int y, int w, int h, Color color){
    Rectangle entity = new Rectangle(w, h);
    entity.setTranslateX(x);
    entity.setTranslateY(y);
    entity.setFill(color);
    return entity;
  }

  /**
  *  Node created to pull in the image to use for the brick.
  *  The dimensions and coordinates for the image are set inside of this method.
  */
  public Node createBrick(int x, int y, int w, int h){
    Image temp = new Image("/Images/brick.png");
    ImageView entity = new ImageView(temp);
    entity.setX(x);
    entity.setY(y);
    entity.setFitHeight(h);
    entity.setFitWidth(w);
    return entity;
  }

  /**
  *  Node created to pull in the image to use for the brick.
  *  The dimensions and coordinates for the image are set inside of this method.
  */
  public Node createFinalBrick(int x, int y, int w, int h){
    Image temp = new Image("/Images/bowserPlatform.png");
    ImageView Fentity = new ImageView(temp);
    Fentity.setX(x);
    Fentity.setY(y);
    Fentity.setFitHeight(h);
    Fentity.setFitWidth(w);
    return Fentity;
  }

  /** Node created to pull in the image to use for the coin. The dimensions and coordinates for the image are set inside of this method */
  public Node createCoin(int x, int y, int w, int h){
    Image temp = new Image("/Images/frame1-sky3.png");
    ImageView coin = new ImageView(temp);
    coin.setX(x);
    coin.setY(y);
    coin.setFitWidth(w);
    coin.setFitHeight(h);
    return coin;
  }

  /**
  *  Node created to pull in the image to use for the coin.
  *  The dimensions and coordinates for the image are set inside of this method.
  */
  public Node createSpecialCoin(int x, int y, int w, int h){
    Image temp = new Image("/Images/specialCoin.png");
    ImageView Scoin = new ImageView(temp);
    Scoin.setX(x);
    Scoin.setY(y);
    Scoin.setFitWidth(w);
    Scoin.setFitHeight(h);
    return Scoin;
  }

  /**
  *  Node created to pull in the image to use for the ground.
  *  The dimensions and coordinates for the image are set inside of this method.
  */
  public Node createGround(int x, int y, int w, int h){
    Image temp = new Image("/Images/ground64by64.png");
    ImageView ground = new ImageView(temp);
    ground.setX(x);
    ground.setY(y);
    ground.setFitWidth(w);
    ground.setFitHeight(h);
    return ground;
  }

  /**
  *  Node created to pull in the image to use for the ground.
  *  The dimensions and coordinates for the image are set inside of this method.
  */
  public Node createFinalGround(int x, int y, int w, int h){
    Image temp = new Image("/Images/bowserBrick.png");
    ImageView Fground = new ImageView(temp);
    Fground.setX(x);
    Fground.setY(y);
    Fground.setFitWidth(w);
    Fground.setFitHeight(h);
    return Fground;
  }

  /**
  *  Node created to pull in the image to use for the cloud.
  *  The dimensions and coordinates for the image are set inside of this method.
  */
  public Node createCloud(int x, int y, int w, int h){
    Image temp = new Image("/Images/cloud32by64.png");
    ImageView cloud = new ImageView(temp);
    cloud.setX(x);
    cloud.setY(y);
    cloud.setFitWidth(w);
    cloud.setFitHeight(h);
    return cloud;
  }

  /**
  *  Node created to pull in the image to use for the background.
  *  The dimensions and coordinates for the image are set inside of this method.
  */
  public Node createBack(int x, int y, int w, int h){
    Image temp = new Image("/Images/background-sky3.png");
    ImageView back = new ImageView(temp);
    back.setX(x);
    back.setY(y);
    back.setFitWidth(w);
    back.setFitHeight(h);
    return back;
  }

  /**
  *  Node created to pull in the image to use for the enemy.
  *  The dimensions and coordinates for the image are set inside of this method.
  */
  public ImageView createBowser(int x, int y){
    Image temp = new Image("/Images/bowser.png");
    ImageView bowser = new ImageView(temp);
    bowser.setTranslateX(x);
    bowser.setTranslateY(y);
    bowser.setFitWidth(252);
    bowser.setFitHeight(270);
    return bowser;
  }

  /**
  *  Node created to pull in the image to use for the background.
  *  The dimensions and coordinates for the image are set inside of this method.
  */
  public Node createFinalBack(int x, int y, int w, int h){
    Image temp = new Image("/Images/wallUpdated.png");
    ImageView Fback = new ImageView(temp);
    Fback.setX(x);
    Fback.setY(y);
    Fback.setFitWidth(w);
    Fback.setFitHeight(h);
    return Fback;
  }

  /**
  *  Node created to pull in the image to use for the middle of the pipe.
  *  The dimensions and coordinates for the image are set inside of this method.
  */
  public Node createPipeMain(int x, int y, int w, int h){
    Image temp = new Image("/Images/pipemain.png");
    ImageView pipeM = new ImageView(temp);
    pipeM.setX(x);
    pipeM.setY(y);
    pipeM.setFitWidth(w);
    pipeM.setFitHeight(h);
    return pipeM;
  }

  /**
  *  Node created to pull in the image to use for the top of the pipe.
  *  The dimensions and coordinates for the image are set inside of this method.
  */
  public Node createPipeTop(int x, int y, int w, int h){
    Image temp = new Image("/Images/pipetop.png");
    ImageView pipeT = new ImageView(temp);
    pipeT.setX(x);
    pipeT.setY(y);
    pipeT.setFitWidth(w);
    pipeT.setFitHeight(h);
    return pipeT;
  }

  /**
  *  Node created to pull in the image to use for the flag pole.
  *  The dimensions and coordinates for the image are set inside of this method.
  */
  public Node createFlagPole(int x, int y, int w, int h){
    Image temp = new Image("/Images/flagpole.png");
    ImageView pole = new ImageView(temp);
    pole.setX(x);
    pole.setY(y);
    pole.setFitWidth(w);
    pole.setFitHeight(h);
    return pole;
  }
}
