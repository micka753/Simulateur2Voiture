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

public int getLargeur()
{
    return largeur;
}

public int getLine1xDeb(){
    return x;
}
public int getLine1yDeb(){
    return y;
}
public int getLine1xFin(){
    if(sens)
        return x;
    else
        return x + longeur;
}
public int getLine1yFin(){
    if(sens)
        return y + longeur;
    else
        return y;
}

public int getLine2xDeb(){
    if(sens)
        return x + largeur;
    else
        return x;
}
public int getLine2yDeb(){
    if(sens)
        return y;
    else
        return y + largeur;
}
public int getLine2xFin(){
    if(sens)
        return x + largeur;
    else
        return x + longeur;
}
public int getLine2yFin(){
    if(sens)
        return y + longeur;
    else
        return y + largeur;
}

public int getInterLinexDeb(){
    if(sens)
        return x + largeur/2;
    else
        return x;
}
public int getInterLineyDeb(){
    if(sens)
        return y;
    else
        return y + largeur/2;
}
public int getInterLinexFin(){
    if(sens)
        return x + largeur/2;
    else
        return x + longeur;
}
public int getInterLineyFin(){
    if(sens)
        return y + longeur;
    else
        return y + largeur/2;
}

public Route(int x,int y,int largeur,int  longeur,boolean sens) {
        this.x = x;
        this.y = y;
        this.largeur = largeur;
        this.longeur = longeur;
        this.sens = sens;
}

}
