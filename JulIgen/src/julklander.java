import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class julklander extends PApplet {

PImage bg;
PVector snowFlake; 
PVector[] snowFlakes; 

int padding = 10;  //Space between the rects.

public void setup() {
  
  litenImage(); 
  storImage();
 
 
  //Snowflake.
  float xPos = random(0, width); 
  snowFlake = new PVector(); 
  snowFlake.x = xPos; 
  snowFlake.y = 0; 

  //Makes many Snowflakes.
  snowFlakes = new PVector[15]; 
  for(int i = 0; i < snowFlakes.length; i++){
    snowFlakes[i] = new PVector(); 
    snowFlakes[i].x =  random(0, width);   
    snowFlakes[i].y = random(0, height); 
  }
}

public void draw() {
  //Background image.
  bg = loadImage("baggrund.jpg");
  background(bg);
   
  //Draws the calendar.
  drawCalendar(230, 250);

 
  //Draw pictures that has been opened.
  int count = 0; 
  for (int j = 0; j < 4; j++) {
    for (int i = 0; i < 6; i++) {
      if(openPics[count]){
       image(litenArray[count], 210 + i * 250 + padding, 100 + j * 230 + padding, 250 - padding, 230 - padding);
      }
      count++;
    }
  }
  dayOpen();
  numbers();
  autoOpen();
  //Snow method.
  snow();
  
  
}
//This is the ClickMethod. 
//This makes it possible to open rects by clicking on them.
boolean insideRect = false; 

public void mouseClicked() {
  int count = 0;
  for (int j = 0; j < 4; j++) {
    for (int i = 0; i < 6; i++) {
      if (insideRect(210 + i * 250 + padding, 100 + j * 230 + padding, 250 - padding, 230 - padding)) {
        openPics[count] = !openPics[count];
      }
      count++;
    }
  }
}

public boolean insideRect(int rectX, int rectY, int rectWidth, int rectHeight) { //Kolla ifall muspekaren \u00e4r innanf\u00f6r ett omr\u00e5de
  if (mouseX > rectX && mouseX < rectX + rectWidth && mouseY > rectY  && mouseY < rectY + rectHeight) {
    return true;
  } else {
    return false;
  }
}
//This is all the dates on the rects.

PFont font;

public void numbers() {
  font = loadFont("Harrington-48.vlw");
  textFont(font, 60);
  fill(255, 0, 0);
  text("1", 230, 150);
  text("2", 480, 150);
  text("3", 730, 150);
  text("4", 980, 150);
  text("5", 1230, 150);
  text("6", 1480, 150);
  text("7", 230, 380);
  text("8", 480, 380);
  text("9", 730, 380);
  text("10", 980, 380);
  text("11", 1230, 380);
  text("12", 1480, 380);
  text("13", 230, 610);
  text("14", 480, 610);
  text("15", 730, 610);
  text("16", 980, 610);
  text("17", 1230, 610);
  text("18", 1480, 610);
  text("19", 230, 840);
  text("20", 480, 840);
  text("21", 730, 840);
  text("22", 980, 840);
  text("23", 1230, 840);
  text("24", 1480, 840);
}
//This is the method that draws the calender.

public void drawCalendar(int boxHeight, int boxWidth) {
  fill(139, 137, 137);
  for (int j = 0; j < 4; j++) {
    for (int i = 0; i < 6; i++) {
      rect(210 + i * boxWidth + padding, 100 + j * boxHeight + padding, boxWidth - padding, boxHeight - padding);
    }
  }
}
//The snow method.

public void snow(){
  noStroke(); 
  fill(255);
  
//Many snowflakes   
  for(int i = 0; i < snowFlakes.length; i++){
    
    snowFlake = snowFlakes[i];
    snowFlake.y = snowFlake.y + 3; 
    
//sin(2 \u03c0 x / T) * A: T = wave length A = size    
//We use snowFlake.y (x in the formula) to make the wave vertical
    
    float curve = sin((TWO_PI * snowFlake.y) / 300) * 5;
    snowFlake.x = snowFlake.x + curve; 
    
//This is the snowflake.
    ellipse(snowFlake.x, snowFlake.y, 20, 20); 
    
    if(snowFlake.y > height) {
      snowFlake.y = 0; 
      snowFlake.x = random(0, width); 
    }   
  }     
}
//This is the autoOpen method.
//Makes every rect open and close every ten minutes.

public void autoOpen(){
  if(minute() % 20 < 10){
    //image(storArray[day() - 1], 420, 250);
  }
  //image(storArray[day() - 1], 420, 250);
}
 
//This is the dayOpen method.
//Makes a new rect open each day.

public void dayOpen(){
  int count = 0;
  for (int j = 0; j < 4; j++) {
    for (int i = 0; i < 6; i++) {
      if(count < day()){
        image(litenArray[count], 210 + i * 250 + padding, 100 + j * 230 + padding, 250 - padding, 230 - padding);
      }
      count++;
    }
  }
}
//This is all the small images.

PImage p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23;
//PImage [] litenArray = new PImage [24];
PImage [] litenArray;

boolean[] openPics = new boolean [] {
  false, false, false, false, false, false,
  false, false, false, false, false, false,
  false, false, false, false, false, false,
  false, false, false, false, false, false
};

public void litenImage() {
  p0 = loadImage("liten0.jpg");
  p1 = loadImage("liten1.jpg");
  p2 = loadImage("liten2.jpg");
  p3 = loadImage("liten3.jpg");
  p4 = loadImage("liten4.jpg");
  p5 = loadImage("liten5.jpg");
  p6 = loadImage("liten6.jpg");
  p7 = loadImage("liten7.jpg");
  p8 = loadImage("liten8.jpg");
  p9 = loadImage("liten9.jpg");
  p10 = loadImage("liten10.jpg");
  p11 = loadImage("liten11.jpg");
  p12 = loadImage("liten12.jpg");
  p13 = loadImage("liten13.jpg");
  p14 = loadImage("liten14.jpg");
  p15 = loadImage("liten15.jpg");
  p16 = loadImage("liten16.jpg");
  p17 = loadImage("liten17.jpg");
  p18 = loadImage("liten18.jpg");
  p19 = loadImage("liten19.jpg");
  p20 = loadImage("liten20.jpg");
  p21 = loadImage("liten21.jpg");
  p22 = loadImage("liten22.jpg");
  p23 = loadImage("liten23.jpg"); 
  
  litenArray = new PImage[] {p0, p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20, p21, p22, p23};
}
//This is all the big images.

PImage m0, m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, m15, m16, m17, m18, m19, m20, m21, m22, m23;
PImage [] storArray;
//PImage [] storArray = new PImage [24];

public void storImage() {
  m0 = loadImage("stor0.jpg");
  m1 = loadImage("stor1.jpg");
  m2 = loadImage("stor2.jpg");
  m3 = loadImage("stor3.jpg");
  m4 = loadImage("stor4.jpg");
  m5 = loadImage("stor5.jpg");
  m6 = loadImage("stor6.jpg");
  m7 = loadImage("stor7.jpg");
  m8 = loadImage("stor8.jpg");
  m9 = loadImage("stor9.jpg");
  m10 = loadImage("stor10.jpg");
  m11 = loadImage("stor11.jpg");
  m12 = loadImage("stor12.jpg");
  m13 = loadImage("stor13.jpg");
  m14 = loadImage("stor14.jpg");
  m15 = loadImage("stor15.jpg");
  m16 = loadImage("stor16.jpg");
  m17 = loadImage("stor17.jpg");
  m18 = loadImage("stor18.jpg");
  m19 = loadImage("stor19.jpg");
  m20 = loadImage("stor20.jpg");
  m21 = loadImage("stor21.jpg");
  m22 = loadImage("stor22.jpg");
  m23 = loadImage("stor23.jpg");
  storArray = new PImage[] {m0, m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, m15, m16, m17, m18, m19, m20, m21, m22, m23};
}
  public void settings() {  size (1920, 1080); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "julklander" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
