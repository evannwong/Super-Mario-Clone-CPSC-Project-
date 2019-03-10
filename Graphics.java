import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Node;

public class Graphics{
  public Node player = createEntity(32, 536, 32, 30, Color.BLUE);

  public Node createEntity(int x, int y, int w, int h, Color color){
    Rectangle entity = new Rectangle(w, h);
    entity.setTranslateX(x);
    entity.setTranslateY(y);
    entity.setFill(color);
    return entity;
  }
}
