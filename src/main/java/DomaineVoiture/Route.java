package DomaineVoiture;

/**
 * Created by 21508418 on 23/03/2016.
 */
public class Route {

private int x;
private int y;
private int largeur;
private int longeur;
private boolean sens;

public int getLine1xDeb(){
    return x;
}
public int getLine1yDeb(){
    return y;
}
public int getLine1xFin(){
    return x + longeur;
}
public int getLine1yFin(){
    return y + longeur;
}

public int getLine2xDeb(){
    return x + largeur;
}
public int getLine2yDeb(){
    return y + largeur;
}
public int getLine2xFin(){
    return x + longeur + largeur;
}
public int getLine2yFin(){
    return y + longeur + largeur;
}

public int getInterLinexDeb(){
    return x + largeur/2;
}
public int getInterLineyDeb(){
    return y + largeur/2;
}
public int getInterLinexFin(){
    return x + longeur + largeur/2;
}
public int getInterLineyFin(){
    return y + longeur + largeur/2;
}

public Route(int x,int y,int largeur,int  longeur,boolean sens){
    this.x =x;
    this.y =y;
    this.largeur = largeur;
    this.longeur = longeur;
    this.sens = sens;
}

}
