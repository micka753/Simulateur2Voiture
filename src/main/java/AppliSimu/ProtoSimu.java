package appliSimu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Timer;

import DomaineVoiture.Route;
import DomaineVoiture.Voiture;

public class ProtoSimu {

	public static final int dureeUneSecondeEnMilliSecondes = 1000;

	public static void main(String[] args) {

/*        contexteGraphique.drawLine(0,280,280,280);
        contexteGraphique.drawLine(320,280,505,280);

        for(int i =0; i< 505; i+=35)
            contexteGraphique.drawLine(i,300,i+15,300);*/

        Vector<Route> routes = new Vector<Route>();
        routes.add(new Route(0, 280, 40, 500,false));
        routes.add(new Route(280, 0, 40, 500,true));

        final Voiture maVoiture = new Voiture(routes.firstElement(), 10);
        IHMVoiture monTriangle = new IHMVoiture(maVoiture, routes);

		
		Timer timerAvancer = new Timer(dureeUneSecondeEnMilliSecondes, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				maVoiture.miseAJourPosition();
			}
		});
		System.out.println("damaan");
		timerAvancer.start();
		
		while(true){
		}

	}

}
