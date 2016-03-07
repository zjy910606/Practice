package Calculator.src;


import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class CalculatorController extends javax.swing.JDialog {

    private final CalculatorModel calculatorModel;

    private final DigitAction[] digitActions;

    private final OperationAction[] operationActions;

    private final DefaultListModel<String> commandHistory = new DefaultListModel<>();

    /**
     * Creates new form CalculatorController
     * @param parent enclosing frame
     * @param modal 
     */
    public CalculatorController(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        calculatorModel = new CalculatorModel();

        digitActions = new DigitAction[10];
        for (int i = 0; i < 10; i++) {
            digitActions[i] = new DigitAction(i);
            this.getRootPane().registerKeyboardAction(digitActions[i],
                    KeyStroke.getKeyStroke(KeyEvent.VK_0 + i, 0),
                    JComponent.WHEN_IN_FOCUSED_WINDOW);

        }

        operationActions = new OperationAction[CalculatorModel.Operation.values().length];
        for (CalculatorModel.Operation op : CalculatorModel.Operation.values()) {
            operationActions[op.ordinal()] = new OperationAction(op);

            if (op.toString().length() > 0) {
                this.getRootPane().registerKeyboardAction(operationActions[op.ordinal()],
                        KeyStroke.getKeyStroke(op.toString().charAt(0)),
                        JComponent.WHEN_IN_FOCUSED_WINDOW);
            }
        }

        this.getRootPane().registerKeyboardAction(operationActions[CalculatorModel.Operation.EQUALS.ordinal()],
                KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
                JComponent.WHEN_IN_FOCUSED_WINDOW);

        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        screen = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        keyHistory = new javax.swing.JList();
        jLabel2 = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jButton2.setAction(digitActions[0]);
        jButton2.setFont(new java.awt.Font("Andale Mono", 0, 18)); // NOI18N
        jButton2.setText("0");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton2.setFocusTraversalKeysEnabled(false);
        jButton2.setFocusable(false);

        jButton3.setAction(operationActions[CalculatorModel.Operation.EQUALS.ordinal()]);
        jButton3.setFont(new java.awt.Font("Andale Mono", 0, 18)); // NOI18N
        jButton3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton3.setFocusTraversalKeysEnabled(false);
        jButton3.setFocusable(false);

        screen.setBackground(new java.awt.Color(255, 255, 255));
        screen.setFont(new java.awt.Font("Andale Mono", 0, 18)); // NOI18N
        screen.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        screen.setText("0");
        screen.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        screen.setFocusTraversalKeysEnabled(false);
        screen.setFocusable(false);

        jButton4.setAction(digitActions[2]);
        jButton4.setFont(new java.awt.Font("Andale Mono", 0, 18)); // NOI18N
        jButton4.setText("2");
        jButton4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton4.setFocusTraversalKeysEnabled(false);
        jButton4.setFocusable(false);

        jButton5.setAction(digitActions[1]);
        jButton5.setFont(new java.awt.Font("Andale Mono", 0, 18)); // NOI18N
        jButton5.setText("1");
        jButton5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton5.setFocusTraversalKeysEnabled(false);
        jButton5.setFocusable(false);

        jButton6.setAction(digitActions[3]);
        jButton6.setFont(new java.awt.Font("Andale Mono", 0, 18)); // NOI18N
        jButton6.setText("3");
        jButton6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton6.setFocusTraversalKeysEnabled(false);
        jButton6.setFocusable(false);

        jButton7.setAction(digitActions[6]);
        jButton7.setFont(new java.awt.Font("Andale Mono", 0, 18)); // NOI18N
        jButton7.setText("6");
        jButton7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton7.setFocusTraversalKeysEnabled(false);
        jButton7.setFocusable(false);

        jButton8.setAction(digitActions[5]);
        jButton8.setFont(new java.awt.Font("Andale Mono", 0, 18)); // NOI18N
        jButton8.setText("5");
        jButton8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton8.setFocusTraversalKeysEnabled(false);
        jButton8.setFocusable(false);

        jButton9.setAction(digitActions[4]);
        jButton9.setFont(new java.awt.Font("Andale Mono", 0, 18)); // NOI18N
        jButton9.setText("4");
        jButton9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton9.setFocusTraversalKeysEnabled(false);
        jButton9.setFocusable(false);

        jButton10.setAction(digitActions[9]);
        jButton10.setFont(new java.awt.Font("Andale Mono", 0, 18)); // NOI18N
        jButton10.setText("9");
        jButton10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton10.setFocusTraversalKeysEnabled(false);
        jButton10.setFocusable(false);

        jButton11.setAction(digitActions[8]);
        jButton11.setFont(new java.awt.Font("Andale Mono", 0, 18)); // NOI18N
        jButton11.setText("8");
        jButton11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton11.setFocusTraversalKeysEnabled(false);
        jButton11.setFocusable(false);

        jButton12.setAction(digitActions[7]);
        jButton12.setFont(new java.awt.Font("Andale Mono", 0, 18)); // NOI18N
        jButton12.setText("7");
        jButton12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton12.setFocusTraversalKeysEnabled(false);
        jButton12.setFocusable(false);

        jButton13.setFont(new java.awt.Font("Andale Mono", 0, 18)); // NOI18N
        jButton13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton13.setBorderPainted(false);
        jButton13.setContentAreaFilled(false);
        jButton13.setEnabled(false);
        jButton13.setFocusTraversalKeysEnabled(false);
        jButton13.setFocusable(false);

        jButton14.setFont(new java.awt.Font("Andale Mono", 0, 18)); // NOI18N
        jButton14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton14.setBorderPainted(false);
        jButton14.setContentAreaFilled(false);
        jButton14.setEnabled(false);
        jButton14.setFocusTraversalKeysEnabled(false);
        jButton14.setFocusable(false);

        jButton16.setAction(operationActions[CalculatorModel.Operation.ADD.ordinal()]);
        jButton16.setFont(new java.awt.Font("Andale Mono", 0, 18)); // NOI18N
        jButton16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton16.setFocusTraversalKeysEnabled(false);
        jButton16.setFocusable(false);

        jButton18.setAction(operationActions[CalculatorModel.Operation.SUB.ordinal()]);
        jButton18.setFont(new java.awt.Font("Andale Mono", 0, 18)); // NOI18N
        jButton18.setText("-");
        jButton18.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton18.setFocusTraversalKeysEnabled(false);
        jButton18.setFocusable(false);

        jButton17.setAction(operationActions[CalculatorModel.Operation.DIV.ordinal()]);
        jButton17.setFont(new java.awt.Font("Andale Mono", 0, 18)); // NOI18N
        jButton17.setText("/");
        jButton17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton17.setFocusTraversalKeysEnabled(false);
        jButton17.setFocusable(false);

        jButton19.setAction(operationActions[CalculatorModel.Operation.MUL.ordinal()]);
        jButton19.setFont(new java.awt.Font("Andale Mono", 0, 18)); // NOI18N
        jButton19.setText("*");
        jButton19.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton19.setFocusTraversalKeysEnabled(false);
        jButton19.setFocusable(false);

        jButton15.setAction(operationActions[CalculatorModel.Operation.CLEAR.ordinal()]);
        jButton15.setFont(new java.awt.Font("Andale Mono", 0, 18)); // NOI18N
        jButton15.setText("c");
        jButton15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton15.setFocusTraversalKeysEnabled(false);
        jButton15.setFocusable(false);

        keyHistory.setModel(commandHistory);
        keyHistory.setFocusTraversalKeysEnabled(false);
        keyHistory.setFocusable(false);
        jScrollPane1.setViewportView(keyHistory);

        jLabel2.setText("Key History");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(screen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(screen, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                CalculatorController dialog = new CalculatorController(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList keyHistory;
    private javax.swing.JLabel screen;
    // End of variables declaration//GEN-END:variables

    private void updateHistory(String newItem) {
        commandHistory.addElement(newItem);
        keyHistory.ensureIndexIsVisible(commandHistory.getSize()-1);
    }
    
    // Digit Action:  These objects will trigger a method call on the Model
    class DigitAction extends AbstractAction {

        private final int value;

        public DigitAction(int value) {
            super("" + value, null);
            this.value = value;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            calculatorModel.digitKey(value);
            updateHistory(""+value);
            screen.setText(calculatorModel.getScreen());
        }
    }

    // Operation Action: These objects will trigger a method call on the Model
    class OperationAction extends AbstractAction {

        private final CalculatorModel.Operation operation;

        public OperationAction(CalculatorModel.Operation operation) {
            super("" + operation, null);
            this.operation = operation;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            calculatorModel.operationKey(operation);
            updateHistory(operation.toString());
            screen.setText(calculatorModel.getScreen());
        }
    }
}
