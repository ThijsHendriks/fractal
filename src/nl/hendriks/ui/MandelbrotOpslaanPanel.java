package nl.hendriks.ui;

import java.awt.Button;
import java.awt.Panel;

public class MandelbrotOpslaanPanel extends Panel  {


	/**
	 * 
	 */
	private static final long serialVersionUID = 5762135105271331274L;
	
	public MandelbrotOpslaanPanel() {
		super();
		Button opslaanKnop = new Button("opslaan");
		opslaanKnop.addActionListener(new OpslaanListener());
		add(opslaanKnop);
	}
	
	

}
