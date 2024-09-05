/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyecto;

import java.awt.Color;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author aaraya
 */
public class FMenuPrincipal extends javax.swing.JFrame {

    public FMenuPrincipal() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menu = new javax.swing.JPanel();
        btnChoferes = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();
        btnMaquinaria = new javax.swing.JButton();
        btnLogistica = new javax.swing.JButton();
        btnAdministrador = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btncCerrar = new javax.swing.JButton();
        btnAyuda = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Menu.setBackground(new java.awt.Color(255, 255, 255));
        Menu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        Menu.setForeground(new java.awt.Color(108, 188, 56));

        btnChoferes.setText("Choferes");
        btnChoferes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChoferesActionPerformed(evt);
            }
        });

        btnClientes.setText("Clientes");
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });

        btnInventario.setText("Inventario");
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });

        btnMaquinaria.setText("Maquinaria");
        btnMaquinaria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaquinariaActionPerformed(evt);
            }
        });

        btnLogistica.setText("Logistica");
        btnLogistica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogisticaActionPerformed(evt);
            }
        });

        btnAdministrador.setText("Administrador");
        btnAdministrador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministradorActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), null));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("Bienvenidos a SGA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(160, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        btncCerrar.setText("Cerrar Sesión");
        btncCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncCerrarActionPerformed(evt);
            }
        });

        btnAyuda.setText("Ayuda");
        btnAyuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAyudaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAdministrador)
                .addGap(159, 159, 159)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLogistica, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addComponent(btnChoferes, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btncCerrar)
                        .addGap(22, 22, 22))
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addComponent(btnMaquinaria, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnChoferes, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btncCerrar)
                            .addComponent(btnAdministrador))))
                .addGap(18, 18, 18)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addComponent(btnClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLogistica, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnMaquinaria, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnChoferesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChoferesActionPerformed
        Clases.Login objeLogin = new Clases.Login();
        String usuario = LPrincipal.usuario;
        boolean respuesta = objeLogin.validarAcceso(usuario, "vendedor");

        if (respuesta) {

            FChoferes chofer = new FChoferes(this);
            chofer.setVisible(true);
            setVisible(false);

        } else {

            JOptionPane.showMessageDialog(null, "No tienes los permisos suficientes", "Error", JOptionPane.ERROR_MESSAGE);

        }


    }//GEN-LAST:event_btnChoferesActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        Clases.Login objeLogin = new Clases.Login();
        String usuario = LPrincipal.usuario;
        boolean respuesta = objeLogin.validarAcceso(usuario, "vendedor");

        if (respuesta) {

            FClientes cliente = new FClientes(this);
            cliente.setVisible(true);
            setVisible(false);

        } else {

            JOptionPane.showMessageDialog(null, "No tienes los permisos suficientes", "Error", JOptionPane.ERROR_MESSAGE);

        }


    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
        Clases.Login objeLogin = new Clases.Login();
        String usuario = LPrincipal.usuario;
        boolean respuesta = objeLogin.validarAcceso(usuario, "cliente");

        if (respuesta) {

            FInventario inven = new FInventario(this);
            inven.setVisible(true);
            setVisible(false);

        } else {

            JOptionPane.showMessageDialog(null, "No tienes los permisos suficientes", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_btnInventarioActionPerformed

    private void btnMaquinariaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaquinariaActionPerformed
        Clases.Login objeLogin = new Clases.Login();
        String usuario = LPrincipal.usuario;
        boolean respuesta = objeLogin.validarAcceso(usuario, "vendedor");

        if (respuesta) {

            FMaquinaria maqui = new FMaquinaria(this);
            maqui.setVisible(true);
            setVisible(false);

        } else {

            JOptionPane.showMessageDialog(null, "No tienes los permisos suficientes", "Error", JOptionPane.ERROR_MESSAGE);

        }


    }//GEN-LAST:event_btnMaquinariaActionPerformed

    private void btnLogisticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogisticaActionPerformed
        Clases.Login objeLogin = new Clases.Login();
        String usuario = LPrincipal.usuario;
        boolean respuesta = objeLogin.validarAcceso(usuario, "vendedor");

        if (respuesta) {

            FLogistica logi = new FLogistica(this);
            logi.setVisible(true);
            setVisible(false);

        } else {

            JOptionPane.showMessageDialog(null, "No tienes los permisos suficientes", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_btnLogisticaActionPerformed

    private void btnAdministradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministradorActionPerformed

        Clases.Login objeLogin = new Clases.Login();
        String usuario = LPrincipal.usuario;
        boolean respuesta = objeLogin.validarAcceso(usuario, "admin");

        if (respuesta) {

            FAdministrador admin = new FAdministrador(this);
            admin.setVisible(true);
            setVisible(false);

        } else {

            JOptionPane.showMessageDialog(null, "No tienes los permisos suficientes", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_btnAdministradorActionPerformed

    private void btncCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncCerrarActionPerformed
            
    int opcion = JOptionPane.showConfirmDialog(this, "¿Estás seguro de que deseas cerrar sesión?", "Confirmación", JOptionPane.YES_NO_OPTION);
    
    if (opcion == JOptionPane.YES_OPTION) {
        dispose(); 
    }
    
    new LPrincipal().setVisible(true);
    setVisible(false);
    }//GEN-LAST:event_btncCerrarActionPerformed

    private void btnAyudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAyudaActionPerformed

         try {
       
        Socket info = new Socket("127.0.0.1", 9090);
        
        JOptionPane.showMessageDialog(null, "Si necesita ayuda con : \nusuarios y contraseña"
                + "\ninformación de productos\nLogística\nInventario\nU otra consulta"
                + "\nPuede contactarse por medio de nuestro correo electrónico info@sga.com. "
                + "\nO a los teléfono 2451-2020/2451-2022 o por medio de WhatsApp 8741-2635. " );
        
        
        
        info.close();
     } catch (IOException ex) {
        JOptionPane.showMessageDialog(null,
                "Error con la conexion del servidor",
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
        System.out.println("Error: " + ex.getMessage());
    }
        
    }//GEN-LAST:event_btnAyudaActionPerformed


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Menu;
    private javax.swing.JButton btnAdministrador;
    private javax.swing.JButton btnAyuda;
    private javax.swing.JButton btnChoferes;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnInventario;
    private javax.swing.JButton btnLogistica;
    private javax.swing.JButton btnMaquinaria;
    private javax.swing.JButton btncCerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
