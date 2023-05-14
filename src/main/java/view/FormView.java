package view;

import java.io.IOException;
import java.net.URISyntaxException;

import controller.DatabaseController;

public class FormView extends javax.swing.JFrame {

    DatabaseController especiesControllers;

    public void setEspeciesControllers() throws URISyntaxException, IOException {
        String urlDB = "https://wildsafeapp-default-rtdb.firebaseio.com/db/1.json";
        this.especiesControllers = new DatabaseController(urlDB);
    }

    public FormView() throws URISyntaxException, IOException {
        setEspeciesControllers();
        initComponents();
    }

    private void initComponents() {

        btnSincronizar = new javax.swing.JButton();
        btnConectar = new javax.swing.JButton();
        lblFaunaFlora = new javax.swing.JLabel();
        cbxFaunaFlora = new javax.swing.JComboBox<>();
        cbxGrupo = new javax.swing.JComboBox<>();
        lblGrupo = new javax.swing.JLabel();
        lblFamilia = new javax.swing.JLabel();
        cbxFamilia = new javax.swing.JComboBox<>();
        lblCategoriaAmeaca = new javax.swing.JLabel();
        txtCategoriaAmeaca = new javax.swing.JTextField();
        lblPrincipaisAmeacas = new javax.swing.JLabel();
        txtPrincipaisAmeacas = new javax.swing.JTextField();
        btnLimpar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        txtBioma = new javax.swing.JTextField();
        lblEspecia = new javax.swing.JLabel();
        txtEspecie = new javax.swing.JTextField();
        lblBioma = new javax.swing.JLabel();
        txtNomeComum = new javax.swing.JTextField();
        lblNomeComum = new javax.swing.JLabel();
        lblEstadosOcorrencia = new javax.swing.JLabel();
        txtEstadosOcorrencia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableResultados = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnSincronizar.setText("Sincronizar");
        
        btnConectar.setText("Conectar");

        btnLimpar.setText("Limpar");
        btnLimpar.setAlignmentY(0.0F);

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setAlignmentY(0.0F);

        lblFaunaFlora.setText("Fauna/Flora");

        cbxFaunaFlora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxFaunaFlora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFaunaFloraActionPerformed(evt);
            }
        });
        
        lblGrupo.setText("Grupo");

        cbxGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxGrupoActionPerformed(evt);
            }
        });

        lblFamilia.setText("Familia");

        cbxFamilia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbxFamilia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxFamiliaActionPerformed(evt);
            }
        });

        lblCategoriaAmeaca.setText("Categoria Ameaça");

        lblPrincipaisAmeacas.setText("Principais Ameaças");

        lblEspecia.setText("Especie");

        lblBioma.setText("Bioma");

        lblNomeComum.setText("Nome Comum");

        lblEstadosOcorrencia.setText("Estados de Ocorrência");

        tableResultados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {especiesControllers.getEspecie().getBioma(), especiesControllers.getEspecie().getCategoriadeAmeaca(), especiesControllers.getEspecie().getFamilia()},
            },
            new String [] {
                "Bioma", "Categoria De Ameaça", "Especie Exclusiva do Brasil", "Especie Simplificado"
            }
        ));
        jScrollPane1.setViewportView(tableResultados);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCategoriaAmeaca, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPrincipaisAmeacas, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPrincipaisAmeacas, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnConectar)
                                .addGap(18, 18, 18)
                                .addComponent(btnSincronizar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblFaunaFlora, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbxFaunaFlora, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(txtCategoriaAmeaca, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbxFamilia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblFamilia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEspecie)
                                    .addComponent(lblEspecia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lblBioma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtBioma, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNomeComum)
                                    .addComponent(lblNomeComum, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtEstadosOcorrencia)
                                    .addComponent(lblEstadosOcorrencia, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(btnLimpar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblFamilia)
                            .addComponent(lblEspecia)
                            .addComponent(lblBioma))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbxFamilia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPesquisar)
                            .addComponent(txtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSincronizar)
                            .addComponent(btnConectar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFaunaFlora)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxFaunaFlora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblGrupo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCategoriaAmeaca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCategoriaAmeaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblNomeComum)
                                .addComponent(lblEstadosOcorrencia))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNomeComum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtEstadosOcorrencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblPrincipaisAmeacas)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtPrincipaisAmeacas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLimpar)))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }

    private void cbxFaunaFloraActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void cbxGrupoActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void cbxFamiliaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    public void inicialize() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FormView().setVisible(true);
                } catch (URISyntaxException | IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private javax.swing.JButton btnConectar;
    private javax.swing.JButton btnLimpar;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSincronizar;
    private javax.swing.JComboBox<String> cbxFaunaFlora;
    private javax.swing.JComboBox<String> cbxGrupo;
    private javax.swing.JComboBox<String> cbxFamilia;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableResultados;
    private javax.swing.JLabel lblBioma;
    private javax.swing.JLabel lblCategoriaAmeaca;
    private javax.swing.JLabel lblEspecia;
    private javax.swing.JLabel lblEstadosOcorrencia;
    private javax.swing.JLabel lblFaunaFlora;
    private javax.swing.JLabel lblGrupo;
    private javax.swing.JLabel lblFamilia;
    private javax.swing.JLabel lblNomeComum;
    private javax.swing.JLabel lblPrincipaisAmeacas;
    private javax.swing.JTextField txtBioma;
    private javax.swing.JTextField txtCategoriaAmeaca;
    private javax.swing.JTextField txtEspecie;
    private javax.swing.JTextField txtEstadosOcorrencia;
    private javax.swing.JTextField txtNomeComum;
    private javax.swing.JTextField txtPrincipaisAmeacas;
}
