import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import processing.pdf.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class normographe_8 extends PApplet {

//cette version du normographe vise \u00e0 g\u00e9n\u00e9rer une trame qui est fonction du niveau de gris des pixels.



PImage source;
PImage destination;
PShape trame;

String[] trames = new String[10];

public void setup(){
	source = loadImage("devoitine520.jpg");
	destination = createImage(source.width, source.height, RGB);
	size(source.width,source.height, PDF, "devoitinetrame-zobzob.pdf");
	println("width:"+source.width+"px"+"height:"+source.height+"px");

	for(int x=1; x<10; x++){
		trames[x] = "yadlatrame_0"+x+".svg"; 
	}

}

public void draw(){

	source.loadPixels();
	destination.loadPixels();
	int tx=8;
	int ty=8;

	for(int x=0; x<source.width; x+=tx){
		for (int y=0; y<source.height; y+=ty){
			int loc = x+y*source.width;

			float gros=brightness(source.pixels[loc])/50;
			trame = loadShape(trames[PApplet.parseInt(random(1,10))]);
			shape(trame,x,y,gros, gros);
			noLoop();


		}
	}

	exit();

}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--stop-color=#cccccc", "normographe_8" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
