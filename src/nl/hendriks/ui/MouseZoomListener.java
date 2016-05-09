package nl.hendriks.ui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import nl.hendriks.mandelbrot.iteraties.MandelbrotInvoer;

public class MouseZoomListener implements MouseListener {
	private final MandelbrotInvoer invoer;

	public MouseZoomListener(MandelbrotInvoer invoer) {
		super();
		this.invoer = invoer;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		double zoom;
		if (e.getButton() == MouseEvent.BUTTON1) {
			zoom = 2d;
		} else {
			zoom = 1d / 2d;
		}
		double newZoomFactor = invoer.getZoomFactor() * zoom;
		double x = invoer.getX() + e.getX() / invoer.getZoomFactor()
				- invoer.getBreedte() / 2d / newZoomFactor;
		double y = invoer.getY() + e.getY() / invoer.getZoomFactor()
				- invoer.getHoogte() / 2d / newZoomFactor;
		invoer.reset(x, y, newZoomFactor, invoer.getDetail());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

}
