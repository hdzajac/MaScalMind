/**
 * Created by Hubert on 2015-01-28.
 */

import java.awt.Color

import swing._


object GUI extends SimpleSwingApplication{

  val buttonDimension = new Dimension(75,75)
  val inputLabelDimension = new Dimension(50,50)
  val resultLabelDimension = new Dimension(25,25)
  val inputGridBackground = Color.LIGHT_GRAY

  val inputButton1 = new Button(){
    minimumSize = buttonDimension
    maximumSize = buttonDimension
    preferredSize = buttonDimension
  }
  val inputButton2 = new Button(){
    minimumSize = buttonDimension
    maximumSize = buttonDimension
    preferredSize = buttonDimension
  }
  val inputButton3 = new Button(){
    minimumSize = buttonDimension
    maximumSize = buttonDimension
    preferredSize = buttonDimension
  }
  val inputButton4 = new Button(){
    minimumSize = buttonDimension
    maximumSize = buttonDimension
    preferredSize = buttonDimension
  }

  var labelsInputTable =  Array.ofDim[Label](12,4)
  for (i <- 0 to 11){
    for (j <- 0 to 3){
        labelsInputTable(i)(j)= new Label(Integer.toString((i+ 1) * (1 + j))){
            minimumSize = inputLabelDimension
            maximumSize = inputLabelDimension
            preferredSize = inputLabelDimension
        }
    }
  }

  var labelsResultTable = Array.ofDim[Label](12,4)
    for(i <- 0 to 11){
      for(j <- 0 to 3){
        labelsResultTable(i)(j) = new Label(Integer.toString((i+1) * (j+1))) {
          minimumSize = resultLabelDimension
          maximumSize = resultLabelDimension
          preferredSize = resultLabelDimension
        }
      }
    }


  val confirmButton = new Button("Confirm")

  val inputPanel = new BoxPanel(Orientation.Vertical){
    contents += inputButton1
    contents += inputButton2
    contents += inputButton3
    contents += inputButton4
  }

  val gameGrid =  new GridPanel(12,5){
    for( i <- 0 to 11){
      for(j <- 0 to 4){
        if( j == 4){
          contents += getResultGrid(i)
        }
        else contents += labelsInputTable(i)(j)
      }
    }
  }

  val ui  = new BorderPanel{
    add(inputPanel, BorderPanel.Position.West)
    add(gameGrid, BorderPanel.Position.Center)
    add(confirmButton, BorderPanel.Position.South)
  }

  override def top = new MainFrame{
    title = "MaScalMind"
    contents = ui
    visible = true
  }

  def getResultGrid (row :Int): GridPanel ={
    val tmpGrid = new GridPanel(2,2) {
      for (i <- 0 to 3) {
        contents += labelsResultTable(row)(i)
      }
    }
    tmpGrid
  }

}
