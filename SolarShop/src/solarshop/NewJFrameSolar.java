/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package solarshop;
// Defines the package name for the project
import java.text.DecimalFormat;
// Imports the DecimalFormat class for formatting decimal numbers
import java.util.Vector;
// Imports the Vector class for creating a dynamic array that can grow and shrink in size
import javax.swing.table.DefaultTableModel;
// Imports the DefaultTableModel class for managing data in a table model, commonly used in GUIs
import java.util.Stack; 
// Imports the Stack class for creating a stack data structure
import javax.swing.JOptionPane;
// Imports the JOptionPane class for creating standard dialog boxes for user interaction (e.g., messages, input dialogs)
/**
 *
 * @author ADMIN
 */
// Defines a JFrame class for the Solar Shop application, 
//initializing a table model and implementing undo and redo functionality using stacks to manage the state of the data.
public class NewJFrameSolar extends javax.swing.JFrame {
    
    private DefaultTableModel dt; 
    private Stack<Vector> undoStack = new Stack<>(); 
    private Stack<Vector> redoStack = new Stack<>();
  
    // Constructor for the JFrame class which initializes components, sets up the table model, 
    //and configures the preferred widths for the first column of the JTable in the Solar Shop application.
    public NewJFrameSolar() {
        initComponents();
           
    dt = (DefaultTableModel) jTable1.getModel();   
    jTable1.getColumnModel().getColumn(0).setPreferredWidth(30);
    jTable1.getColumnModel().getColumn(0).setPreferredWidth(200);
    
  
}
    // Adds a new entry to the table with the given ID, Name, Quantity, and Celestial Currency, 
    //calculates the total value of the Celestial Currency formatted to two decimal places, and 
    //removes any existing row with the same name from the table in the Solar Shop application.
    public void addtable(int id ,String Name, int Qty ,Double CelestialCurrency){
        
        
    
    DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
    
  
    DecimalFormat df = new DecimalFormat("00.00") ;
    double totCelestialCurrency = CelestialCurrency * Double.valueOf(Qty);
    
    String TotalCelestialCurrency = df.format(totCelestialCurrency);
    
    
    for (int row = 0; row < jTable1.getRowCount(); row++){
    
    if (Name ==jTable1.getValueAt(row, 1)) {
        
        dt.removeRow(jTable1.convertRowIndexToModel(row));
        } 
    }
    
    // Creates a new Vector to hold the entry data, adds the entry to the table and the undo stack, 
    //and clears the redo stack to reset the redo history in the Solar Shop application.
    Vector v = new Vector ();
    v.add(id);
    v.add(Name);
    v.add(Qty);
    v.add(TotalCelestialCurrency);
    
    dt.addRow(v);
    undoStack.push(v);
    redoStack.clear();
   
    }
    // Provides undo and redo functionality for the table: 
    // undo() removes the last action from the table and moves it to the redo stack; 
    // redo() restores the last undone action to the table and moves it back to the undo stack.
    public void undo() { if (!undoStack.isEmpty()) 
    { Vector lastAction = undoStack.pop(); redoStack.push(lastAction); for (int row = 0; row < dt.getRowCount(); row++) 
    { if (lastAction.get(1).equals(dt.getValueAt(row, 1))) { dt.removeRow(row); return; } } } } public void redo() 
    { if (!redoStack.isEmpty()) { Vector lastUndone = redoStack.pop(); dt.addRow(lastUndone); 
    undoStack.push(lastUndone); 
    } 
    }
    
    // Calculates the total of values in the third column of the table, formats the total to two decimal places, 
    //and updates the 'total' field with the formatted result in the Solar Shop application.
    public void cal(){
    
    int numOfRow = jTable1.getRowCount() ;
    double tot = 0.0 ;
    
        for (int i = 0; i < numOfRow; i++)
        {
            double value = Double.parseDouble(jTable1.getValueAt(i, 3).toString());
            tot += value ;
            
        }
        DecimalFormat df = new DecimalFormat("00.00") ;
        total.setText(df.format(tot));
        
       
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1Mercury = new javax.swing.JButton();
        jButton2Venus = new javax.swing.JButton();
        q01 = new javax.swing.JLabel();
        jButton5Jupiter = new javax.swing.JButton();
        q03 = new javax.swing.JLabel();
        jButton3Earth = new javax.swing.JButton();
        q04 = new javax.swing.JLabel();
        jButton4Mars = new javax.swing.JButton();
        jButton6Saturn = new javax.swing.JButton();
        q6 = new javax.swing.JLabel();
        jButton9Pluto = new javax.swing.JButton();
        q07 = new javax.swing.JLabel();
        jButton11Moon = new javax.swing.JButton();
        jButton8Neptune = new javax.swing.JButton();
        q9 = new javax.swing.JLabel();
        jButton7Uranus = new javax.swing.JButton();
        q10 = new javax.swing.JLabel();
        jButton10Sun = new javax.swing.JButton();
        q11 = new javax.swing.JLabel();
        q08 = new javax.swing.JLabel();
        q5 = new javax.swing.JLabel();
        q02 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        b = new javax.swing.JTextArea();
        total = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pay = new javax.swing.JTextField();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonUndo = new javax.swing.JButton();
        jButtonRedo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1Mercury.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mercury (1).png"))); // NOI18N
        jButton1Mercury.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1MercuryActionPerformed(evt);
            }
        });

        jButton2Venus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/venus (1).png"))); // NOI18N
        jButton2Venus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2VenusActionPerformed(evt);
            }
        });

        q01.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        q01.setText("0");

        jButton5Jupiter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/jupiter (1).png"))); // NOI18N
        jButton5Jupiter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5JupiterActionPerformed(evt);
            }
        });

        q03.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        q03.setText("0");

        jButton3Earth.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/earth (2).png"))); // NOI18N
        jButton3Earth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3EarthActionPerformed(evt);
            }
        });

        q04.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        q04.setText("0");

        jButton4Mars.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mars (1).png"))); // NOI18N
        jButton4Mars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4MarsActionPerformed(evt);
            }
        });

        jButton6Saturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/saturn (1).png"))); // NOI18N
        jButton6Saturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6SaturnActionPerformed(evt);
            }
        });

        q6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        q6.setText("0");

        jButton9Pluto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pluto (1).png"))); // NOI18N
        jButton9Pluto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9PlutoActionPerformed(evt);
            }
        });

        q07.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        q07.setText("0");

        jButton11Moon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/moon (1).png"))); // NOI18N
        jButton11Moon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11MoonActionPerformed(evt);
            }
        });

        jButton8Neptune.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/neptune (1).png"))); // NOI18N
        jButton8Neptune.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8NeptuneActionPerformed(evt);
            }
        });

        q9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        q9.setText("0");

        jButton7Uranus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/uranus (1).png"))); // NOI18N
        jButton7Uranus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7UranusActionPerformed(evt);
            }
        });

        q10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        q10.setText("0");

        jButton10Sun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/sun (1).png"))); // NOI18N
        jButton10Sun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10SunActionPerformed(evt);
            }
        });

        q11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        q11.setText("0");

        q08.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        q08.setText("0");

        q5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        q5.setText("0");

        q02.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        q02.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1Mercury, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2Venus, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(q01, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(q02, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(q03, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton3Earth, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(23, 23, 23))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton4Mars, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5Jupiter, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6Saturn, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(q04, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(q5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(q6, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(q10, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(q11, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton10Sun, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton11Moon, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(q07, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(q08, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton7Uranus, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton8Neptune, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton9Pluto, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                                    .addComponent(q9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1Mercury, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2Venus, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3Earth, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(q01)
                            .addComponent(q03)
                            .addComponent(q02))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5Jupiter, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4Mars, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton6Saturn, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(q04)
                    .addComponent(q6)
                    .addComponent(q5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7Uranus, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8Neptune, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9Pluto, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(q07)
                    .addComponent(q9)
                    .addComponent(q08))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton11Moon, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10Sun, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(q10)
                    .addComponent(q11))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTable1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Celestial", "Qty", "CelestialCurrency"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        b.setColumns(20);
        b.setRows(5);
        jScrollPane2.setViewportView(b);

        total.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        total.setText("00");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Change :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Bal :");

        bal.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        bal.setText("00");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setText("Total :");

        pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton12.setText("Print");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton13.setText("Pay");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButtonDelete.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonUndo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButtonUndo.setText("Undo");
        jButtonUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUndoActionPerformed(evt);
            }
        });

        jButtonRedo.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButtonRedo.setText("Redo");
        jButtonRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRedoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pay, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bal, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButtonUndo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonRedo))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 15, Short.MAX_VALUE))))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonUndo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonRedo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(pay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(bal)))
                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Handles the action performed when a Celestial body button is clicked, increments the quantity, 
    //updates the table and total calculation, and displays information about it in a dialog box.
    private void jButton1MercuryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1MercuryActionPerformed
        int i = Integer.valueOf(q01.getText());
        ++i;
        q01.setText(String.valueOf(i));
        
        addtable(1, "Mercury", i, 4879.00);
        
        cal();
        String planetName = "Mercury"; String description = "Mercury is the smallest and innermost planet in the Solar System."; 
        JOptionPane.showMessageDialog(this, description, planetName, JOptionPane.INFORMATION_MESSAGE);
        

    }//GEN-LAST:event_jButton1MercuryActionPerformed

    private void jButton2VenusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2VenusActionPerformed
        int i = Integer.valueOf(q02.getText());
        ++i;
        q02.setText(String.valueOf(i));
        
        addtable(2, "Venus", i, 12104.00);
        
        cal();
        
        String planetNameVenus = "Venus";
String descriptionVenus = "Venus is the second planet from the Sun and is the hottest planet in the Solar System.";
JOptionPane.showMessageDialog(this, descriptionVenus, planetNameVenus, JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton2VenusActionPerformed

    private void jButton5JupiterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5JupiterActionPerformed
        int i = Integer.valueOf(q5.getText());
        ++i;
        q5.setText(String.valueOf(i));
        
        addtable(5, "Jupiter", i, 139820.00);
        
        cal();
        String planetNameJupiter = "Jupiter";
String descriptionJupiter = "Jupiter is the largest planet in the Solar System and has a Great Red Spot.";
JOptionPane.showMessageDialog(this, descriptionJupiter, planetNameJupiter, JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton5JupiterActionPerformed

    private void jButton3EarthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3EarthActionPerformed
        int i = Integer.valueOf(q03.getText());
        ++i;
        q03.setText(String.valueOf(i));
        
        addtable(3, "Earth", i, 12756.00);
        
        cal();
        String planetNameEarth = "Earth";
String descriptionEarth = "Earth is the third planet from the Sun and is the only known planet to support life.";
JOptionPane.showMessageDialog(this, descriptionEarth, planetNameEarth, JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton3EarthActionPerformed

    private void jButton4MarsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4MarsActionPerformed
        int i = Integer.valueOf(q04.getText());
        ++i;
        q04.setText(String.valueOf(i));
        
        addtable(4, "Mars", i, 6779.00);
        
        cal();
        
String planetNameMars = "Mars";
String descriptionMars = "Mars is the fourth planet from the Sun and is known as the Red Planet.";
JOptionPane.showMessageDialog(this, descriptionMars, planetNameMars, JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton4MarsActionPerformed

    private void jButton6SaturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6SaturnActionPerformed
        int i = Integer.valueOf(q6.getText());
        ++i;
        q6.setText(String.valueOf(i));
        
        addtable(6, "Saturn", i, 49244.00);
        
        cal();
        
String planetNameSaturn = "Saturn";
String descriptionSaturn = "Saturn is the sixth planet from the Sun and is known for its prominent ring system.";
JOptionPane.showMessageDialog(this, descriptionSaturn, planetNameSaturn, JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton6SaturnActionPerformed

    private void jButton9PlutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9PlutoActionPerformed
        int i = Integer.valueOf(q9.getText());
        ++i;
        q9.setText(String.valueOf(i));
        
        addtable(9, "Pluto", i, 2376.00);
        
        cal();
        String planetNamePluto = "Pluto";
String descriptionPluto = "Pluto is a dwarf planet in the Kuiper Belt, once considered the ninth planet.";
JOptionPane.showMessageDialog(this, descriptionPluto, planetNamePluto, JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton9PlutoActionPerformed

    private void jButton11MoonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11MoonActionPerformed
        int i = Integer.valueOf(q11.getText());
        ++i;
        q11.setText(String.valueOf(i));
        
        addtable(11, "Moon", i, 3474.00);
        
        cal();
       String planetNameMoon = "Moon"; String descriptionMoon = "The Moon is Earth's only natural satellite and the fifth largest moon in the Solar System."; 
       JOptionPane.showMessageDialog(this, descriptionMoon, planetNameMoon, JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton11MoonActionPerformed

    private void jButton8NeptuneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8NeptuneActionPerformed
        int i = Integer.valueOf(q08.getText());
        ++i;
        q08.setText(String.valueOf(i));
        
        addtable(8, "Neptune", i, 49244.00);
        
        cal();
        String planetNameNeptune = "Neptune";
String descriptionNeptune = "Neptune is the eighth planet from the Sun and has strong winds and storms.";
JOptionPane.showMessageDialog(this, descriptionNeptune, planetNameNeptune, JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton8NeptuneActionPerformed

    private void jButton7UranusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7UranusActionPerformed
        int i = Integer.valueOf(q07.getText());
        ++i;
        q07.setText(String.valueOf(i));
        
        addtable(7, "Uranus", i, 49244.00);
        
        cal();
        String planetNameUranus = "Uranus";
String descriptionUranus = "Uranus is the seventh planet from the Sun and rotates on its side.";
JOptionPane.showMessageDialog(this, descriptionUranus, planetNameUranus, JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton7UranusActionPerformed

    private void jButton10SunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10SunActionPerformed
        int i = Integer.valueOf(q10.getText());
        ++i;
        q10.setText(String.valueOf(i));
        
        addtable(10, "Sun", i, 1400000.00);
        
        cal();
       String starNameSun = "Sun"; String descriptionSun = "The Sun is the star at the center of the Solar System and provides energy to Earth.";
       JOptionPane.showMessageDialog(this, descriptionSun, starNameSun, JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton10SunActionPerformed

    private void payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_payActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
       // bill print
    // Handles the action of printing a bill when the button is clicked, generating a receipt that includes shop details, 
    //a list of purchased celestial items with their quantities and costs, and displays the subtotal, cash received, and balance. 
    //It also prints a thank-you message and handles any exceptions that occur during the process.
        try {{
            
            b.setText("                                                                Orion \n");
            b.setText(b.getText() + "                                                              Bataan \n");
            b.setText(b.getText() + "                                                              Philippines \n");
            b.setText(b.getText() + "                                                              +0963 \n");
            b.setText(b.getText() + "----------------------------------------------------------------------------------\n");
            b.setText(b.getText() + "Celestial \tQty \tCelestialCurrency" +"\n");
            b.setText(b.getText() + "----------------------------------------------------------------------------------\n");

            DefaultTableModel df = (DefaultTableModel) jTable1.getModel();

            for (int i = 0; i < jTable1.getRowCount(); i++) {
            
            String Name = df.getValueAt(i, 1).toString();
            String Qty = df.getValueAt(i, 2).toString();
            String CelestialCurrency = df.getValueAt(i, 3).toString();

            b.setText(b.getText() +Name +"\t                 " + Qty +"\t" + CelestialCurrency + "\n");
            }
            b.setText(b.getText() + "----------------------------------------------------------------------------------\n");
            b.setText(b.getText() + "Sub Total : " + total.getText() +"\n");
            b.setText(b.getText() + "Cash       : " + pay.getText() +"\n");
            b.setText(b.getText() + "Balance   : " + bal.getText() +"\n");
            }  
            b.setText(b.getText() + "----------------------------------------------------------------------------------\n");
            b.setText(b.getText() + "Thank you for your purchase!...\n");
            b.setText(b.getText() + "----------------------------------------------------------------------------------\n");
            
            b.print();
            b.setText(b.getText() + " By Solar Planets\n");
            } catch (Exception e) {
        System.out.println(e);
        }
    }//GEN-LAST:event_jButton12ActionPerformed
    // Handles the action of processing the payment when the "Pay" button is clicked by calculating the total amount paid, 
    //the balance after payment, and formatting the balance to two decimal places in the Solar Shop application.
    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // paybtn
        double tot = Double.valueOf(total.getText());
        double paid = Double.valueOf(pay.getText());
        double balance = paid - tot ;
        
        DecimalFormat df = new DecimalFormat("00.00") ;
    
                
                bal.setText(String.valueOf(df.format(balance)));
    }//GEN-LAST:event_jButton13ActionPerformed
    // Handles the action of deleting the selected row from the table when the "Delete" button is 
    //clicked by retrieving the selected row, then removing it from the table model in the Solar Shop application.
    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        //Delete
        
      DefaultTableModel dt = (DefaultTableModel) jTable1.getModel();
      
      String r = dt.getValueAt(jTable1.getSelectedRow(), 0).toString();
      
      //remove c
      int rw = jTable1.getSelectedRow();
      
      
      
      dt.removeRow(rw);
      
     
     // Sets the quantity of the selected item to zero based on its identifier and handles the case where the identifier is not 
     //recognized by outputting "Over" to the console in the Solar Shop application
      
      //remove qty
      System.out.println(r);
      switch(r) {
               case "1" :
              q08.setText("0"); 
              break;
               case "2" :
              q01.setText("0"); 
              break;
               case "3" :
              q03.setText("0"); 
              break;
               case "4" :
              q04.setText("0"); 
              break;
               case "5" :
              q5.setText("0"); 
              break;
               case "6" :
              q6.setText("0"); 
              break;
               case "7" :
              q07.setText("0"); 
              break;
               case "8" :
              q02.setText("0"); 
              break;
               case "9" :
              q9.setText("0"); 
              break;
               case "10" :
              q10.setText("0"); 
              break;
               case "11" :
              q11.setText("0"); 
              break;
              
               default:
                   System.out.println("Over");
              
      }
    }//GEN-LAST:event_jButtonDeleteActionPerformed
    // Handles the action of undoing and redoing the last actions when the respective buttons are clicked, 
    //then recalculates the total value in the Solar Shop application.
    private void jButtonUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUndoActionPerformed
      undo(); cal();
     
    }//GEN-LAST:event_jButtonUndoActionPerformed

    private void jButtonRedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRedoActionPerformed
       redo(); cal();
        
      
            
        
    }//GEN-LAST:event_jButtonRedoActionPerformed
    
 // The main method sets the Nimbus look and feel for the application, handles exceptions if Nimbus is unavailable,
 // and creates and displays the main JFrame for the Solar Shop application.
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrameSolar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrameSolar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrameSolar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrameSolar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrameSolar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea b;
    private javax.swing.JLabel bal;
    private javax.swing.JButton jButton10Sun;
    private javax.swing.JButton jButton11Moon;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton1Mercury;
    private javax.swing.JButton jButton2Venus;
    private javax.swing.JButton jButton3Earth;
    private javax.swing.JButton jButton4Mars;
    private javax.swing.JButton jButton5Jupiter;
    private javax.swing.JButton jButton6Saturn;
    private javax.swing.JButton jButton7Uranus;
    private javax.swing.JButton jButton8Neptune;
    private javax.swing.JButton jButton9Pluto;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonRedo;
    private javax.swing.JButton jButtonUndo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField pay;
    private javax.swing.JLabel q01;
    private javax.swing.JLabel q02;
    private javax.swing.JLabel q03;
    private javax.swing.JLabel q04;
    private javax.swing.JLabel q07;
    private javax.swing.JLabel q08;
    private javax.swing.JLabel q10;
    private javax.swing.JLabel q11;
    private javax.swing.JLabel q5;
    private javax.swing.JLabel q6;
    private javax.swing.JLabel q9;
    private javax.swing.JLabel total;
    // End of variables declaration//GEN-END:variables
}
