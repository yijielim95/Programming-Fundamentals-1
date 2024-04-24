int   points  = 0;
float ball_x  = 100;
float ball_y  = 50;
float speed_x = 10;
float speed_y = 5;
boolean gameStart = false;

void setup() {
  size(800,800);
}

void draw() {
  if(gameStart == false) {
    miracleBackground();
    textSize(70);
    textAlign(CENTER);
    fill(random(255),random(255),random(255));
    text("Welcome to YJ's World!!!!", width/2 , height/2);
    
    if(mousePressed) {
    gameStart = true;
    }
 } 
   else {
   background(90);
   yjTruck();
   strokeWeight(3);
    if(ball_x < 0 || ball_x > 800)
    {
      speed_x = -speed_x;
    }  
    if(ball_y > 800)
    {
      speed_y = -speed_y; 
    float distance = abs(mouseX - ball_x);
       if (distance < 100)
       {
       points += 1;
       }
       if (distance < 100)
       {
       textSize(500);
       fill(random(255),random(255),random(255));
       text("+1",450,600);
       }
    } 
     else{ 
     speed_y += 1;  
     }
     ball_x = ball_x + speed_x;
     ball_y = ball_y + speed_y;  
  
     textSize(30);
     fill(0,0,255);
     rect(mouseX-50,790,100,100);
     fill(random(255),random(255),random(255));
     ellipse(ball_x, ball_y,30,30 );
     fill(0,0,255);
     text("points: " + points, 60, 40);
   
   
   if(points == 5)
   { 
     textSize(30);
     fill(random(255),random(255),random(255));
     text("Great and Continue!!!", 450, 50);
   }
   if(points == 10) 
   {
     fill(random(255),random(255),random(255));
     text("By the way is my truck beautiful?", 450,50);
   }    
   if(points == 15) 
   {
     fill(random(255),random(255),random(255));
     text("I love my truck!!",450,50);
   }
   if(points == 20) 
   {
     fill(random(255),random(255),random(255));
     text("GOOD JOB!!!You can sleep now",450,70);
   } 
   if (points >= 25) 
   {
     fill(random(255),random(255),random(255));
     textSize(25);
     text("YOU WIN! You're the best and turn off the machine!!!Stop Playing!!",450,70);
   }    
  
  }
} 

void miracleBackground(){ 
   int count = 0;
       for (int i=0; i < 100; i++){
         for(int j=0; j < 100; j++){
           if (count % 2 == 1)
           fill(9,57,9);
           else
           fill(26,5,113);
           rect(j*50,i*50,50,50);
           count++;
    }
           count++;
  }
}

void yjTruck(){ 
    strokeWeight(5);
    fill(55);
    triangle(20,400,50,440,20,500); 
    triangle(140,440,175,500,175,400);
    fill(90);
    ellipse(96,493,120,120);
    fill(150);
    triangle(43,520,97,438,149,520);  
    
    fill(2,2,52);
    rect(20,400,155,40); 
    
    fill(255); 
    rect(175,500,440,10); 
  
    fill(3,2,28);
    rect(175,400,170,100); 
    rect(320,400,230,100); 
    rect(550,400,65,100); 
    
    fill(55);
    triangle(615,400,645,440,615,500); 
    triangle(770,400,745,440,770,500);
    fill(90);
    ellipse(695,493,120,120);
    fill(150);
    triangle(642,520,695,438,748,520);
    
    fill(2,2,52);
    rect(615,400,155,40); 
    
    fill(255,0,0);
    rect(20,390,750,10); 
    
    fill(113,11,11);
    rect(20,390,80,10); 
    
    fill(113,11,11);
    rect(690,390,80,10); 
  
    fill(175,164,214);
    triangle(20,390,175,390,175,220); 
  
    fill(35,57,175);
    rect(175,220,145,170); 
    fill(94,117,245);
    rect(185,235,125,140);
    
    fill(35,57,175);
    rect(320,220,230,170); 
    fill(94,117,245);
    rect(331,235,208,140);
  
    fill(26,32,62);
    rect(550,220,220,170); 
    strokeWeight(0);
    fill(26,32,62);
    rect(561,235,195,140);
    fill(57,67,121);
    rect(581,255,155,100);
    fill(85,97,160);
    rect(601,275,115,60);
    fill(85,97,160);
    rect(621,295,75,20);
}
