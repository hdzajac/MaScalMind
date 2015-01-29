

import scala.swing._
import scala.swing.event.ButtonClicked

/**
 * Created by Hubert on 2015-01-29.
 */
class ClosingWindow(name:String,motherWindow: MainFrame){

  val windowDimension = new Dimension(400,300)
  val buttonDimnesion = new Dimension(400, 100)


  val backBox = new FlowPanel{
    contents += new Button("Back"){
      minimumSize = buttonDimnesion
      maximumSize = buttonDimnesion
      preferredSize = buttonDimnesion
      background = new Color(168, 168, 179)
      reactions +={
        case ButtonClicked(b) => back()
      }
    }
  }

  val mainPanel = new BorderPanel{
    background = new Color(185, 173, 168)
    add(new Label("Hubert Zając & Marcin Zaręba"),BorderPanel.Position.Center)
    add(backBox,BorderPanel.Position.South)
  }

  val mainFrame = new MainFrame{
    minimumSize = windowDimension
    maximumSize = windowDimension
    preferredSize = windowDimension
    background = new Color(185, 173, 168)
    title = name
    contents = mainPanel
    visible = true
  }

  def back():Unit = {
    motherWindow.dispose()
    mainFrame.dispose()
  }

}
