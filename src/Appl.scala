/**
 * Created by Hubert on 2015-01-28.
 */

import java.awt.{Dimension, Color}
import scala.swing.event.ButtonClicked
import swing._


object Appl extends SimpleSwingApplication{

  val buttonDimension = new Dimension(75,75)
  val inputLabelDimension = new Dimension(50,50)
  val resultLabelDimension = new Dimension(25,25)
  val masterMind = new MasterMind
  var result = new Array[Int](2)
  var inputList = new Array[Int](4)
  var rowNmbr = 11


  val colorArray = new Array[Color](6)
  colorArray(0) = new Color(123,174,50)//zielony
  colorArray(1) = new Color(70,76,149)//niebieski
  colorArray(2) = new Color(225,213,66)//zolty
  colorArray(3) = new Color(191,44,32)//czerwony
  colorArray(4) = new Color(132,22,119)//fioletowy
  colorArray(5) = new Color(136,59,0)//brazowy

  val inputButtonArray = new Array[Button](4)
    for ( i <- 0 to 3){
      inputButtonArray(i) = new Button(){
        inputList(i) = 0
        background = new Color(215,195,180)
        minimumSize = buttonDimension
        maximumSize = buttonDimension
        preferredSize = buttonDimension
        reactions += {
          case ButtonClicked(b) => inputList(i) += 1
            if(inputList(i) == 6) inputList(i) = 0
            background = colorArray(inputList(i)% 6)
        }
      }
    }

  val confirmButton = new Button("Confirm"){
    var confirmColor = new Color(168,168,179)
    background = confirmColor
    reactions += {
      case ButtonClicked(b) => afterConfirm()
    }
  }

  var labelsInputTable =  Array.ofDim[Label](12,4)
  for (i <- 0 to 11){
    for (j <- 0 to 3){
        labelsInputTable(i)(j)= new Label(){
            minimumSize = inputLabelDimension
            maximumSize = inputLabelDimension
            preferredSize = inputLabelDimension
            background =  new Color(139,111,100)
            opaque = true
        }
    }
  }

  var labelsResultTable = Array.ofDim[Label](12,4)
    for(i <- 0 to 11){
      for(j <- 0 to 3){
        labelsResultTable(i)(j) = new Label() {
          minimumSize = resultLabelDimension
          maximumSize = resultLabelDimension
          preferredSize = resultLabelDimension
          background =  new Color(185,173,168)
          opaque = true
        }
      }
    }

  val inputPanel = new FlowPanel{
    for(i <- 0 to 3)
    contents += inputButtonArray(i)
  }

  val gameGrid =  new GridPanel(12,5){
    vGap = 5
    hGap = 5
    for( i <- 0 to 11){
      for(j <- 0 to 4){
        if( j == 4){
          contents += getResultGrid(i)
        }
        else contents += labelsInputTable(i)(j)
      }
    }
  }

  val gamePanel = new BorderPanel{
    add(gameGrid,BorderPanel.Position.Center)
    add(inputPanel,BorderPanel.Position.South)
  }

  val ui  = new BorderPanel{
    add(gamePanel, BorderPanel.Position.Center)
    add(confirmButton, BorderPanel.Position.South)
  }

  override def top = new MainFrame{
    title = "MaScalMind"
    contents = ui
    visible = true
    masterMind.newGame()
  }

  def getResultGrid (row :Int): GridPanel ={
    val tmpGrid = new GridPanel(2,2) {
      vGap = 2
      hGap = 2
      for (i <- 0 to 3) {
        contents += labelsResultTable(row)(i)
      }
    }
    tmpGrid
  }

  def afterConfirm(): Unit = {
    paintInput(rowNmbr)
    result = masterMind.check(inputList)
    paintResult(result,rowNmbr)
    if(result(0) == 4){
      victory()
    }
    else if(rowNmbr == 0){
      defeat()
    }
    rowNmbr -= 1
  }

  def paintResult( arr: Array[Int], r:Int ): Unit = {

      for(i <- 0 to arr(0)  - 1){
        labelsResultTable(r)(i).background = new Color(63,50,59)
      }

      for(i <- arr(0) to arr(1) - 1 + arr(0)){
        labelsResultTable(r)(i).background = new Color(250,254,245)
      }
  }

  def paintInput(r:Int):Unit = {
      for(i <- 0 to 3){
        labelsInputTable(r)(i).background = colorArray(inputList(i))
      }
  }

  def victory():Unit = {

  }

  def defeat():Unit = {

  }

}



//                                                Niedoszly przycisk start
//  val startButton = new Button("Start"){
//    val tmp = new Dimension(200,100)
//    minimumSize = tmp
//    maximumSize = tmp
//    preferredSize = tmp
//    background = new Color(139,111,100)
//    reactions += {
//      case ButtonClicked(b) => top.close()
//        val top = new MainFrame{
//        title = "MaScalMind"
//        contents = ui
//        visible = true
//      }
//    }
//  }
//
//  val startPanel = new BorderPanel{
//    var tmpdim = new Dimension(800,400)
//    add(startButton,BorderPanel.Position.Center)
//    minimumSize = tmpdim
//    maximumSize = tmpdim
//    preferredSize = tmpdim
//  }




//
//  val inputButton1 = new Button(){
//    var colorNmbr1 = 0
//    minimumSize = buttonDimension
//    maximumSize = buttonDimension
//    preferredSize = buttonDimension
//    var buttonColor1 = new Color(215,195,180)
//    background = buttonColor1
//    reactions += {
//      case ButtonClicked(b) => colorNmbr1 += 1
//        if(colorNmbr1 == 6) colorNmbr1 = 0
//        background = colorArray(colorNmbr1 % 6)
//    }
//  }
//  val inputButton2 = new Button(){
//    var colorNmbr2 = 0
//    minimumSize = buttonDimension
//    maximumSize = buttonDimension
//    preferredSize = buttonDimension
//    var buttonColor2 = new Color(215,195,180)
//    background = buttonColor2
//    reactions += {
//      case ButtonClicked(b) => colorNmbr2 += 1
//        if(colorNmbr2 == 6) colorNmbr2 = 0
//        background = colorArray(colorNmbr2 % 6)
//    }
//  }
//  val inputButton3 = new Button(){
//    var colorNmbr3 = 0
//    minimumSize = buttonDimension
//    maximumSize = buttonDimension
//    preferredSize = buttonDimension
//    var buttonColor3 = new Color(215,195,180)
//    background = buttonColor3
//    reactions += {
//      case ButtonClicked(b) => colorNmbr3 += 1
//        if(colorNmbr3 == 6) colorNmbr3 = 0
//        background = colorArray(colorNmbr3 % 6)
//    }
//  }
//  val inputButton4 = new Button(){
//    var colorNmbr4 = 0
//    minimumSize = buttonDimension
//    maximumSize = buttonDimension
//    preferredSize = buttonDimension
//    var buttonColor4 = new Color(215,195,180)
//    background = buttonColor4
//    reactions += {
//      case ButtonClicked(b) => colorNmbr4 += 1
//        if(colorNmbr4 == 6) colorNmbr4 = 0
//        background = colorArray(colorNmbr4 % 6)
//    }
//  }
