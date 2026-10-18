package Tarea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Modelos extends JFrame implements ActionListener {
    JMenuBar bm;
    JMenu mArchivo, mBD;
    JMenuItem mBD_c, mBD_R, mBD_E, mBD_A;
    
    JLabel lbl, lbId, lbMarca, lbModelo, lbDescripcion, lbStatus;
    JTextField txtId, txtMarca, txtModelo, txtDescripcion, txtStatus;
    JButton enviar, agregar, actualizar, eliminar;
    DefaultTableModel modeloTabla;
    JTable tabla;
    JScrollPane scrollTabla;
    
    Modelo objModelo = new Modelo();
    
    Modelos(){
        this.setBounds(150, 50, 800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        
        bm = new JMenuBar();
        this.setJMenuBar(bm);
        
        mArchivo = new JMenu("Archivo");
        bm.add(mArchivo);
        
        mBD = new JMenu("Base de Datos");
        bm.add(mBD);
        
        this.mBD_c = new JMenuItem("Crear");
        this.mBD_c.addActionListener(e -> {
            agregar();
            consultar();
        });
        mBD.add(mBD_c);
        
        this.mBD_R = new JMenuItem("Consultar");
        this.mBD_R.addActionListener(e -> {
            JOptionPane.showMessageDialog(rootPane, "Evento capturado");
            consultar();
        });
        mBD.add(mBD_R);
        
        this.mBD_E = new JMenuItem("Eliminar");
        this.mBD_E.addActionListener(e -> {
            eliminar();
            consultar();
        });
        mBD.add(mBD_E);
        
        this.mBD_A = new JMenuItem("Actualizar");
        this.mBD_A.addActionListener(e -> {
            actualizar();
            consultar();
        });
        mBD.add(mBD_A);
        
        this.lbl = new JLabel();
        this.lbl.setBounds(350, 20, 250, 30);
        this.lbl.setText("CRUD de Modelos...");
        this.add(lbl);
        
        this.lbId = new JLabel("ID"); 
        this.lbId.setBounds(150, 75, 100, 30);
        this.add(lbId);
        txtId = new JTextField("");
        txtId.setBounds(255, 75, 150, 30);
        this.add(txtId);

        this.lbMarca = new JLabel("Marca"); 
        this.lbMarca.setBounds(150, 110, 100, 30);
        this.add(lbMarca);
        txtMarca = new JTextField("");
        txtMarca.setBounds(255, 110, 150, 30);
        this.add(txtMarca);
        
        this.lbModelo = new JLabel("Modelo"); 
        this.lbModelo.setBounds(150, 145, 100, 30);
        this.add(lbModelo);
        txtModelo = new JTextField("");
        txtModelo.setBounds(255, 145, 150, 30);
        this.add(txtModelo);

        this.lbDescripcion = new JLabel("Descripción"); 
        this.lbDescripcion.setBounds(150, 180, 100, 30);
        this.add(lbDescripcion);
        txtDescripcion = new JTextField("");
        txtDescripcion.setBounds(255, 180, 150, 30);
        this.add(txtDescripcion);

        this.lbStatus = new JLabel("Status"); 
        this.lbStatus.setBounds(150, 215, 100, 30);
        this.add(lbStatus);
        txtStatus = new JTextField("");
        txtStatus.setBounds(255, 215, 150, 30);
        this.add(txtStatus);
        
       
        this.enviar = new JButton("Consultar");
        this.enviar.setBounds(255, 260, 150, 30);
        this.add(enviar);
        this.enviar.addActionListener(this);
        
        this.agregar = new JButton("Agregar");
        this.agregar.setBounds(415, 260, 150, 30);
        this.add(agregar);
        this.agregar.addActionListener(this);
        
        this.actualizar = new JButton("Actualizar");
        this.actualizar.setBounds(575, 260, 150, 30);
        this.add(actualizar);
        this.actualizar.addActionListener(this);
        
        this.eliminar = new JButton("Eliminar");
        this.eliminar.setBounds(415, 300, 150, 30);
        this.add(eliminar);
        this.eliminar.addActionListener(this);
        
       
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Marca");
        modeloTabla.addColumn("Modelo");
        modeloTabla.addColumn("Descripción");
        modeloTabla.addColumn("Status");

        tabla = new JTable(modeloTabla);
        scrollTabla = new JScrollPane(tabla);
        scrollTabla.setBounds(150, 350, 575, 20);
        this.add(scrollTabla);
        
        this.setVisible(true);
        consultar();
    }
    
    public static void main(String[] args){
        Modelos modelosApp = new Modelos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.enviar){
            consultar();
        }
        if (e.getSource() == this.agregar) {
            System.out.println("Se agrego");
            this.agregar();
            consultar(); 
        }
        if (e.getSource() == this.actualizar) {
            System.out.println("Se actualizo");
            this.actualizar();
            consultar(); 
        }
        if (e.getSource() == this.eliminar) {
            System.out.println("Se elimino");
            this.eliminar();
            consultar();
        }
    }
    
    public void agregar() {
        if(txtId.getText().isEmpty()){
            System.out.println("Por favor, escriba un ID manual.");
            return;
        }
        objModelo.agregar(txtId.getText().trim(), txtMarca.getText().trim(), 
        txtModelo.getText().trim(), txtDescripcion.getText().trim(), 
        txtStatus.getText().trim());
    }
    
    public void eliminar() {
        objModelo.eliminar(txtId.getText().trim(), txtMarca.getText().trim());
    }
    
    public void consultar(){
        objModelo.consultar(modeloTabla);
        ajustarTamanoTabla();
    }
    
    public void actualizar(){
        objModelo.actualizar(txtId.getText().trim(), txtMarca.getText().trim(), 
        txtModelo.getText().trim(), txtDescripcion.getText().trim(), 
        txtStatus.getText().trim());
    }
    
    public void ajustarTamanoTabla() {
        int filas = modeloTabla.getRowCount();
        int altoFila = tabla.getRowHeight(); 
        int altoCabecera = tabla.getTableHeader().getPreferredSize().height;

        int altoCalculado = altoCabecera + (filas * altoFila) + 5;

        int altoMinimo = 60; 
        int altoMaximo = 150; 

        int altoFinal = Math.max(altoMinimo, Math.min(altoCalculado, altoMaximo));

        scrollTabla.setBounds(150, 350, 575, altoFinal);

        this.revalidate();
        this.repaint();
    }
}
