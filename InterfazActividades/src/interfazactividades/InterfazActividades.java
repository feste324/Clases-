/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package interfazactividades;

import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Usuario
 */
public class InterfazActividades {
// Creacion de variables 
    public int espaciosYoga = 30;
    public int espaciosBaile = 30;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfazActividades().crearInterfaz());
    }

    public void crearInterfaz() {
        // Se construye la ventana Principal 
        JFrame ventana = new JFrame("Gestión de clases : Yoga / Baile ");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(500, 300);
        ventana.setLayout(new GridBagLayout());

        // Crear el panel principal
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Etiquetas para mostrar los espacios disponibles
        JLabel etiquetaYoga = new JLabel("Espacios disponibles para la clase de Yoga: " + espaciosYoga);
        JLabel etiquetaBaile = new JLabel("Espacios disponibles para la clase de  Baile: " + espaciosBaile);

        // Botones para añadir y liberar espacios
        JButton botonAñadirYoga = new JButton("Añadir usuario a la clase de  Yoga");
        JButton botonAñadirBaile = new JButton("Añadir usuario a la clase de Baile");
        JButton botonLiberarYoga = new JButton("Liberar espacio en la clase de  Yoga");
        JButton botonLiberarBaile = new JButton("Liberar espacio en la clase de Baile");

        // Colocar los componentes en el panel  gbc nos permite ubicarlo en forma de cuadricula indicando con un numnero el numero de fila y columna 
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(etiquetaYoga, gbc);

        gbc.gridx = 1;
        panel.add(botonAñadirYoga, gbc);

        gbc.gridx = 2;
        panel.add(botonLiberarYoga, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(etiquetaBaile, gbc);

        gbc.gridx = 1;
        panel.add(botonAñadirBaile, gbc);

        gbc.gridx = 2;
        panel.add(botonLiberarBaile, gbc);

        // Agregar el panel a la ventana
        ventana.add(panel);

        // Acciones de los botones  el action listener nos permitira que detecte si ya se utilizaron todos los espacios disponibles para que mustre un mensaje que no se puede realizar la accion 
        botonAñadirYoga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (espaciosYoga > 0) {
                    espaciosYoga--;
                    etiquetaYoga.setText("Espacios disponibles para Yoga: " + espaciosYoga);
                } else {
                    JOptionPane.showMessageDialog(ventana, "No hay más espacios disponibles para Yoga.");
                }
            }
        });

        botonAñadirBaile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (espaciosBaile > 0) {
                    espaciosBaile--;
                    etiquetaBaile.setText("Espacios disponibles para Baile: " + espaciosBaile);
                } else {
                    JOptionPane.showMessageDialog(ventana, "No hay más espacios disponibles para Baile.");
                }
            }
        });

        botonLiberarYoga.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (espaciosYoga < 30) {
                    espaciosYoga++;
                    etiquetaYoga.setText("Espacios disponibles para Yoga: " + espaciosYoga);
                } else {
                    JOptionPane.showMessageDialog(ventana, "Todos los espacios para Yoga ya están libres.");
                }
            }
        });

        botonLiberarBaile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (espaciosBaile < 30) {
                    espaciosBaile++;
                    etiquetaBaile.setText("Espacios disponibles para Baile: " + espaciosBaile);
                } else {
                    JOptionPane.showMessageDialog(ventana, "Todos los espacios para Baile ya están libres.");
                }
            }
        });

        // Mostrar la ventana
        ventana.setVisible(true);
    }
}

// TODO code application logic here

