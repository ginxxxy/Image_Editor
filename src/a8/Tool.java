package a8;

import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;
import javax.swing.event.ChangeListener;

public interface Tool extends MouseListener, MouseMotionListener,ActionListener,ChangeListener {
	String getName();
	JPanel getUI();
}
