package AppliSimu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Timer;

import DomaineVoiture.Route;
import DomaineVoiture.Voiture;

public class ProtoSimu {

	public static final int dureeUneSecondeEnMilliSecondes = 1000;

	public static void main(String[] args) {

		final Voiture maVoiture = new Voiture (100, 0, 10);
		IHMVoiture monTriangle = new IHMVoiture(maVoiture);

        Vector routes = new Vector<Route>();
        routes.add(new Route(0, 280, 40, 500,false));

		
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
