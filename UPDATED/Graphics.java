import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Node;
import javafx.scene.image.ImageView;


public class Graphics{

  ImageView player = new ImageView("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/mario.png?token=ApkDjG3QpMdkdKtqJ4uwSCDIybeWTQbJks5cjg1RwA%3D%3D");

  public Node createEntity(int x, int y, int w, int h, Color color){
    Rectangle entity = new Rectangle(w, h);
    entity.setTranslateX(x);
    entity.setTranslateY(y);
    entity.setFill(color);
    return entity;
  }

  public Node createBrick(int x, int y, int w, int h){
    ImageView entity = new ImageView("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/brick.png?token=ApkDjG3QpMdkdKtqJ4uwSCDIybeWTQbJks5cjg1RwA%3D%3D");
    entity.setX(x);
    entity.setY(y);
    entity.setFitHeight(w);
    entity.setFitWidth(h);
    return entity;
  }

  public Node createCoin(int x, int y, int w, int h){
    ImageView coin = new ImageView("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/frame1-sky3.png?token=ApkDjG3QpMdkdKtqJ4uwSCDIybeWTQbJks5cjg1RwA%3D%3D");
    coin.setX(x);
    coin.setY(y);
    coin.setFitWidth(w);
    coin.setFitHeight(h);
    return coin;
  }

  public Node createGround(int x, int y, int w, int h){
    ImageView ground = new ImageView("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/ground64by64.png?token=ApkDjG3QpMdkdKtqJ4uwSCDIybeWTQbJks5cjg1RwA%3D%3D");
    ground.setX(x);
    ground.setY(y);
    ground.setFitWidth(w);
    ground.setFitHeight(h);
    return ground;
  }

  /**public Node createGoomba(int x, int y, int w, int h){
    ImageView goomba = new ImageView("https://static.giantbomb.com/uploads/original/9/93854/2438851-goomba+smb+sprite+walk+gif.gif");
    goomba.setX(x);
    goomba.setY(y);
    goomba.setFitWidth(w);
    goomba.setFitHeight(h);
    return goomba;
  }*/

  public Node createCloud(int x, int y, int w, int h){
    ImageView cloud = new ImageView("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/cloud32by64.png?token=ApkDjG3QpMdkdKtqJ4uwSCDIybeWTQbJks5cjg1RwA%3D%3D");
    cloud.setX(x);
    cloud.setY(y);
    cloud.setFitWidth(w);
    cloud.setFitHeight(h);
    return cloud;
  }

  public Node createBack(int x, int y, int w, int h){
    ImageView back = new ImageView("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/background-sky3.png?token=ApkDjG3QpMdkdKtqJ4uwSCDIybeWTQbJks5cjg1RwA%3D%3D");
    back.setX(x);
    back.setY(y);
    back.setFitWidth(w);
    back.setFitHeight(h);
    return back;
  }

  public Node createPipeMain(int x, int y, int w, int h){
    ImageView pipeM = new ImageView("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/pipemain.png?token=ApkDjG3QpMdkdKtqJ4uwSCDIybeWTQbJks5cjg1RwA%3D%3D");
    pipeM.setX(x);
    pipeM.setY(y);
    pipeM.setFitWidth(w);
    pipeM.setFitHeight(h);
    return pipeM;
  }

public Node createPipeTop(int x, int y, int w, int h){
  ImageView pipeT = new ImageView("https://raw.githubusercontent.com/RMcCurdy/TeamProjectGroup14/master/Images/pipetop.png?token=ApkDjG3QpMdkdKtqJ4uwSCDIybeWTQbJks5cjg1RwA%3D%3D");
  pipeT.setX(x);
  pipeT.setY(y);
  pipeT.setFitWidth(w);
  pipeT.setFitHeight(h);
  return pipeT;
  }
}
