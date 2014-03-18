//cette version du normographe vise à générer une trame qui est fonction du niveau de gris des pixels.

import processing.pdf.*;

PImage source;
PImage destination;
PShape trame;

String[] trames = new String[10];

void setup(){
	source = loadImage("devoitine520.jpg");
	destination = createImage(source.width, source.height, RGB);
	size(source.width,source.height, PDF, "devoitinetrame-zobzob.pdf");
	println("width:"+source.width+"px"+"height:"+source.height+"px");

	for(int x=1; x<10; x++){
		trames[x] = "yadlatrame_0"+x+".svg"; 
	}

}

void draw(){

	source.loadPixels();
	destination.loadPixels();
	int tx=8;
	int ty=8;

	for(int x=0; x<source.width; x+=tx){
		for (int y=0; y<source.height; y+=ty){
			int loc = x+y*source.width;

			float gros=brightness(source.pixels[loc])/50;
			trame = loadShape(trames[int(random(1,10))]);
			shape(trame,x,y,gros, gros);
			noLoop();


		}
	}

	exit();

}