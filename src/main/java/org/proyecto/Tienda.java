package org.proyecto;

import javax.swing.*;
import java.awt.*;

public class Tienda {
    private boolean avisarSiHayLeche = false;
    private boolean voyATienda = false;
    private int contadorLeche = 0;
    private JTextArea texto;

    public Tienda(JTextArea tA) {
        this.texto = tA;
    }

    public synchronized void comprarLecheSincronizado(String persona) {
        String mensaje = "";

        //Color de texto verde
        if (!avisarSiHayLeche) {
            voyATienda = true;
        }
        if (voyATienda && contadorLeche == 0) {
            mensaje = persona + ": ve que no hay leche en la nevera";
            texto.append(mensaje + "\n");

            mensaje = persona + ": avisa que va a comprar leche!!";
            texto.append(mensaje + "\n");

            mensaje = persona + ": va a la tienda a comprar leche";
            texto.append(mensaje + "\n");

            mensaje = persona + ": compra leche en la tienda.";
            texto.append(mensaje + "\n");
            avisarSiHayLeche = true;
            contadorLeche++;

        } else if (avisarSiHayLeche && contadorLeche >= 1) {
            mensaje = persona + ": ve el aviso se queda en casa";
            texto.append(mensaje + "\n");
        }
        if (voyATienda && contadorLeche > 1) {
            mensaje = persona + ": comprueba la nevera y OH OH!!";
            texto.append(mensaje + "\n");
        }
    }

    public void comprarLeche(String persona) {
        String mensaje = "";
        //limpiar texto para imprimir el nuevo texto

        voyATienda = true;

        if (voyATienda) {
            mensaje = persona + ": ve que no hay leche en la nevera";
            texto.append(mensaje + "\n");

            mensaje = persona + ": va a la tienda a comprar leche";
            texto.append(mensaje + "\n");

            mensaje = persona + ": compra leche en la tienda.";
            texto.append(mensaje + "\n");

            contadorLeche++;
        }
        if (voyATienda && contadorLeche >= 2) {
            mensaje = persona + ": comprueba la nevera y OH OH!!";
            texto.append(mensaje + "\n");
        }
    }
}