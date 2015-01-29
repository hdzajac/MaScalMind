/**
 * Created by Hubert on 2015-01-28.
 */

import java.awt.{Font, Dimension, Color}
import scala.swing.event.ButtonClicked
import swing._


object Appl extends SimpleSwingApplication {

  val buttonDimension = new Dimension(100, 50)
  val boxDimension = new Dimension(200, 100)
  val windowDimension = new Dimension(300,125)

  val startButton = new Button("Start") {
    minimumSize = buttonDimension
    maximumSize = buttonDimension
    preferredSize = buttonDimension
    background = new Color(168, 168, 179)
    reactions += {
      case ButtonClicked(b) => initialize()
    }
  }

  val endButton = new Button("End"){
    minimumSize = buttonDimension
    maximumSize = buttonDimension
    preferredSize = buttonDimension
    background = new Color(168, 168, 179)
    reactions += {
      case ButtonClicked(b) => quit()
    }
  }

  val menuBox = new FlowPanel{
    contents += startButton
    contents += endButton
    minimumSize = boxDimension
    maximumSize = boxDimension
    preferredSize = boxDimension
  }

  val startPanel = new MainFrame {
    minimumSize = windowDimension
    maximumSize = windowDimension
    preferredSize = windowDimension
    title = "MaScalMind"
    contents = new BorderPanel {
    add(menuBox,BorderPanel.Position.Center)
    }
    visible = true
  }

  override def top = startPanel

  def initialize():Unit = {
    val window = new GameWindow()
  }


}
