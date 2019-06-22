package br.com.genius.action;

import br.com.genius.controller.MainController;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.AbstractButton;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author fernandopucci
 */
public class MainAction implements MouseListener {

    private MainController mainController;

    public MainAction(MainController mainController) {
        this.mainController = mainController;

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            Object source = e.getSource();
            if (source instanceof AbstractButton) {

                mainController.acaoControle((AbstractButton) source);

            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            Object source = e.getSource();
            if (source instanceof AbstractButton) {
                mainController.acao((AbstractButton) source);
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            Object source = e.getSource();

            if (source instanceof AbstractButton) {
                mainController.acaoRelease((AbstractButton) source);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
