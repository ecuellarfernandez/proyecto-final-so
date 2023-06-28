package org.proyecto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SincronizacionFrame extends JFrame {
    private JTextArea textArea;

    public SincronizacionFrame() {
        setTitle("Programa de Sincronización");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Botón para ejecutar el programa sin sincronización
        JButton btnEjecutar = new JButton("Ejecutar");
        btnEjecutar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutarPrograma();
            }
        });

        // Botón para ejecutar el programa con sincronización
        JButton btnEjecutarSincronizado = new JButton("Ejecutar Sincronizado");
        btnEjecutarSincronizado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutarProgramaSincronizado();
            }
        });

        // Área de texto para mostrar la ejecución del programa
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnEjecutar);
        buttonPanel.add(btnEjecutarSincronizado);

        add(buttonPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void ejecutarPrograma() {
        textArea.setText("");
        Tienda tienda = new Tienda(textArea);

        Persona compa = new Persona("Pepito", false, tienda);
        Persona yo = new Persona("Juanito", false, tienda);

        Thread hiloCompa = new Thread(compa);
        Thread hiloYo = new Thread(yo);

        hiloCompa.start();
        hiloYo.start();

    }

    public void ejecutarProgramaSincronizado() {
        textArea.setText("");
        Tienda tienda = new Tienda(textArea);

        Persona compa = new Persona("Pepe", true, tienda);
        Persona yo = new Persona("Juan", true, tienda);

        Thread hiloCompa = new Thread(compa);
        Thread hiloYo = new Thread(yo);

        hiloCompa.start();
        hiloYo.start();
    }
}