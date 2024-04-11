package com.eviden.kiosko.services;

import java.awt.Component;

import javax.swing.JTabbedPane;

public class Utils {
	
	public static boolean ifExistTabb(JTabbedPane jTabbedPane, String tabbName) {
		boolean encontrado = false;
		Component[] c = jTabbedPane.getComponents();
		if (c != null) {						
			int i=0;						
			while (i< c.length && !encontrado) {
				if(tabbName.equalsIgnoreCase(c[i].getName())){
					encontrado = true;
				}
				i++;
			}
		}
		return encontrado;
	}

}
