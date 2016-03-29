package appliSimu;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;

import javax.swing.JFrame;

import DomaineVoiture.Route;
import DomaineVoiture.Voiture;

public class IHMVoiture extends JFrame implements Observer{

	private double paramatreConversionMetresPixels = 0.5;
	private Voiture maVoiture;

	private CommandeVoiture maCommandeVoiture;
    public Vector<Route> routes;

	
	private void initGraphique() {
		this.setTitle("Simulateur de Voiture");
		this.setSize(505, 505);

		this.maCommandeVoiture = new CommandeVoiture(this, maVoiture);

		this.setVisible(true);
	}
	
	public IHMVoiture(Voiture maVoiture, Vector<Route> routes) {
		super();
		this.maVoiture = maVoiture;
        this.routes = routes;
		maVoiture.addObserver(this);
		initGraphique();
	}

	public IHMVoiture() {
		super();
		initGraphique();
		this.maVoiture = null;
	}
	
	public int calculerPositionPixels(int xMetres) {
		return (int) (paramatreConversionMetresPixels * xMetres);	
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.repaint();
	}

	@Override
	public void paint(Graphics contexteGraphique) {
		super.paint(contexteGraphique);
		contexteGraphique.setColor(Color.red);

        dessinerVoiture(contexteGraphique);
        contexteGraphique.setColor(Color.black);
        dessinerRoutes(contexteGraphique);

		/*dessinerVoiture(contexteGraphique);
        contexteGraphique.setColor(Color.black);
        dessinerRoute(contexteGraphique);
        dessinerRouteBis(contexteGraphique);*/
	}

    private void dessinerRoutes(Graphics contexteGraphique){
        for(Route r : routes)
        {
            contexteGraphique.drawLine(r.getLine1xDeb(),r.getLine1yDeb(),r.getLine1xFin(),r.getLine1yFin());
            contexteGraphique.drawLine(r.getLine2xDeb(),r.getLine2yDeb(),r.getLine2xFin(),r.getLine2yFin());

            for(int i = r.getInterLinexDeb(); i< r.getInterLinexFin(); i+=35)
                contexteGraphique.drawLine(i,r.getInterLineyDeb(),i+15,r.getInterLineyFin());
        }
    }

    private void dessinerRoute(Graphics contexteGraphique) {
        contexteGraphique.drawLine(0,280,280,280);
        contexteGraphique.drawLine(320,280,505,280);

        for(int i =0; i< 505; i+=35)
            contexteGraphique.drawLine(i,300,i+15,300);

        contexteGraphique.drawLine(0,320,280,320);
        contexteGraphique.drawLine(320,320,505,320);
    }

    private void dessinerRouteBis(Graphics contexteGraphique) {
        contexteGraphique.drawLine(280,0,280,280);
        contexteGraphique.drawLine(280,320,280,505);

        for(int i =0; i< 505; i+=35)
            contexteGraphique.drawLine(300,i,300,i+15);

        contexteGraphique.drawLine(320,0,320,280);
        contexteGraphique.drawLine(320,320,320,505);
    }


    private void dessinerVoiture(Graphics contexteGraphique) {
        int xPixel = maVoiture.getX();
        //int xPixel = calculerPositionPixels(xMetres);

        int yPixel = maVoiture.getY();
        //int yPixel = calculerPositionPixels(yMetres);

        if ((maVoiture.getDirectionEnDegres() == 0) || (maVoiture.getDirectionEnDegres() == 180)) {
            contexteGraphique.setColor(Color.red);
            contexteGraphique.fillRect(xPixel, yPixel, 30, 15);
            contexteGraphique.setColor(Color.black);

            if (maVoiture.getDirectionEnDegres() == 0) {
                contexteGraphique.fillRect(xPixel + 25, yPixel, 5, 15);

            }
            else if (maVoiture.getDirectionEnDegres() == 180)
            {
                contexteGraphique.fillRect(xPixel, yPixel, 5, 15);
            }
        } else if ((maVoiture.getDirectionEnDegres() == 90) || (maVoiture.getDirectionEnDegres() == 270)) {
            contexteGraphique.setColor(Color.red);
            contexteGraphique.fillRect(xPixel, yPixel, 15, 30);
            contexteGraphique.setColor(Color.black);

            if (maVoiture.getDirectionEnDegres() == 90) {
                contexteGraphique.fillRect(xPixel, yPixel + 25, 15, 5);

            } else if (maVoiture.getDirectionEnDegres() == 270) {
                contexteGraphique.fillRect(xPixel, yPixel, 15, 5);
            }
        }
    }

}

