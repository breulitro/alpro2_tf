/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * TmdbCadastro.java
 *
 * Created on Nov 20, 2010, 3:41:06 PM
 */

package cadastrofilmes;

import java.awt.event.KeyEvent;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import net.sf.jtmdb.CastInfo;
import net.sf.jtmdb.Movie;
import net.sf.jtmdb.MoviePoster;
import org.json.JSONException;
import pucrs.imdb.ArquivoFilmes;
import pucrs.imdb.Filme;
import pucrs.imdb.ListaFilmes;
import tf.tmdb.CadastroFilmes;
import tf.tmdb.FilmeTMDB;
import tf.tmdb.Midia.Arquivo;
import tf.tmdb.Midia.CODEC;
import tf.tmdb.Midia.DB;
import tf.tmdb.Midia.DBRegiao;
import tf.tmdb.Midia.DVD;
import tf.tmdb.Midia.Midia;

/**
 *
 * @author foo
 */
public class TmdbCadastro extends javax.swing.JFrame {
	public CadastroFilmes cad;
	private ListaFilmes listaFilmes;
	private JList list;

    /** Creates new form TmdbCadastro */            

	public TmdbCadastro(final CadastroFilmes cad, final JList list) {
		this.cad = cad;
		this.list = list;
		listaFilmes = new ListaFilmes();
		initComponents();
		// LEITURA DO IMDB Top 250
		ArquivoFilmes arqFilmes = new ArquivoFilmes();
        arqFilmes.preencherPorArquivo("imdb-short20102.txt");
        listaFilmes = arqFilmes.getListaFilmes();
	}


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jTextFieldTmdbid = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldAno = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldNota = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldVotos = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldTitulo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldTraduzido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldDiretor = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldPoster = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldUrl = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaComentario = new javax.swing.JTextArea();
        jTabbedPaneMidia = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jComboBoxDBRegiao = new javax.swing.JComboBox();
        jLabel12 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldDVDQtd = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jComboBoxDVDRegiao = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jComboBoxArquivoCodec = new javax.swing.JComboBox();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldArquivoTamanho = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextFieldArquivoNome = new javax.swing.JTextField();
        jButtonArquivoChooseFile = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButtonCadastrar = new javax.swing.JButton();
        jTextFieldPesquisa = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        jComboBoxWheretoSearch = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel4.setText("TMDB ID:");

        jTextFieldTmdbid.setEditable(false);
        jTextFieldTmdbid.setEnabled(false);
        jTextFieldTmdbid.setFocusable(false);

        jLabel5.setText("Ano:");

        jTextFieldAno.setEditable(false);
        jTextFieldAno.setEnabled(false);
        jTextFieldAno.setFocusable(false);

        jLabel6.setText("Nota:");

        jTextFieldNota.setEditable(false);
        jTextFieldNota.setEnabled(false);
        jTextFieldNota.setFocusable(false);

        jLabel7.setText("Votos:");

        jTextFieldVotos.setEditable(false);
        jTextFieldVotos.setEnabled(false);
        jTextFieldVotos.setFocusable(false);

        jLabel1.setText("Titulo:");

        jTextFieldTitulo.setEditable(false);
        jTextFieldTitulo.setEnabled(false);
        jTextFieldTitulo.setFocusable(false);

        jLabel2.setText("Traduzido:");

        jLabel3.setText("Diretor:");

        jTextFieldDiretor.setEditable(false);
        jTextFieldDiretor.setEnabled(false);
        jTextFieldDiretor.setFocusable(false);

        jLabel8.setText("Poster:");

        jTextFieldPoster.setEditable(false);
        jTextFieldPoster.setEnabled(false);
        jTextFieldPoster.setFocusable(false);

        jLabel9.setText("URL:");

        jTextFieldUrl.setEditable(false);
        jTextFieldUrl.setEnabled(false);
        jTextFieldUrl.setFocusable(false);

        jLabel10.setText("Comentário:");

        jTextAreaComentario.setColumns(20);
        jTextAreaComentario.setRows(5);
        jScrollPane1.setViewportView(jTextAreaComentario);

        jComboBoxDBRegiao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Free", "A", "B", "C" }));

        jLabel12.setText("Região:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jComboBoxDBRegiao, 0, 392, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxDBRegiao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPaneMidia.addTab("DB", jPanel1);

        jLabel13.setText("Quantidade:");

        jLabel14.setText("Região:");

        jComboBoxDVDRegiao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "0", "1", "2", "3", "4", "5", "6" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDVDQtd, javax.swing.GroupLayout.DEFAULT_SIZE, 301, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxDVDRegiao, 0, 331, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jTextFieldDVDQtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jComboBoxDVDRegiao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jTabbedPaneMidia.addTab("DVD", jPanel2);

        jLabel15.setText("Codec:");

        jComboBoxArquivoCodec.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "MPEG2", "MPEG4", "H264", "DivX", "XVid", "WindowsMedia", "RealVideo" }));

        jLabel16.setText("Tamanho(MB):");

        jLabel17.setText("Nome:");

        jButtonArquivoChooseFile.setText("Choose File");
        jButtonArquivoChooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonArquivoChooseFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel17))
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jComboBoxArquivoCodec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldArquivoTamanho, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextFieldArquivoNome, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonArquivoChooseFile)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jComboBoxArquivoCodec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jTextFieldArquivoTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextFieldArquivoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonArquivoChooseFile))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jTabbedPaneMidia.addTab("Arquivo", jPanel3);

        jLabel11.setText("Tipo de Mídia:");

        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        jTextFieldPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextFieldPesquisaKeyReleased(evt);
            }
        });

        jButtonSearch.setText("Search");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        jComboBoxWheretoSearch.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "IMDB", "TBDM" }));
        jComboBoxWheretoSearch.setSelectedIndex(1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldNota, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldVotos, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jTextFieldTraduzido, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                .addComponent(jTextFieldDiretor, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                .addComponent(jTextFieldPoster, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                .addComponent(jTextFieldUrl, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                                .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)))
                        .addComponent(jLabel3)
                        .addComponent(jLabel8)
                        .addComponent(jLabel9)
                        .addComponent(jLabel10)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jTextFieldTmdbid, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButtonSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                                .addComponent(jTextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel11)
                    .addComponent(jTabbedPaneMidia, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                    .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
                    .addComponent(jComboBoxWheretoSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonCadastrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextFieldPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxWheretoSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldTmdbid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldVotos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldTraduzido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldDiretor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldPoster, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPaneMidia, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCadastrar)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
	/* Botao select file action */
	private void jButtonArquivoChooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonArquivoChooseFileActionPerformed
		//JFrame select = new SelectFile(jTextFieldArquivoNome);
		//select.setVisible(true);
		JFileChooser fc = new JFileChooser();
		int ret = fc.showOpenDialog(this);
		if (ret == JFileChooser.APPROVE_OPTION)						
			jTextFieldArquivoNome.setText(fc.getSelectedFile().getAbsolutePath());
	}//GEN-LAST:event_jButtonArquivoChooseFileActionPerformed

	/* Botão cadastrar */
	private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
		if (fieldsOk()) {
			Midia m = null;
			if (jTabbedPaneMidia.getTitleAt(jTabbedPaneMidia.getSelectedIndex()).equals("Arquivo")) {				
				System.out.println(jTextFieldArquivoNome.getText());
				//FIXME: [Duvida] Why??
				/*String[] s = jTextFieldArquivoNome.getText().split(".");
				System.out.println(s.length);
				System.out.println(jTextFieldArquivoNome.getText().split(".")[1]);*/

				String nome = "",
						extensao = "",
						s = jTextFieldArquivoNome.getText();				
				nome = s.substring(0, s.lastIndexOf('.') - 1);
				extensao = s.substring(s.lastIndexOf('.') + 1);

				m = new Arquivo(Integer.parseInt(jTextFieldArquivoTamanho.getText()),
						nome,
						extensao,
						CODEC.valueOf((String) jComboBoxArquivoCodec.getSelectedItem()));
			} else if (jTabbedPaneMidia.getTitleAt(jTabbedPaneMidia.getSelectedIndex()).equals("DB")) {
				m = new DB(DBRegiao.valueOf((String) jComboBoxDBRegiao.getSelectedItem()));
			} else {
				m = new DVD(Integer.parseInt(jTextFieldDVDQtd.getText()),
						Integer.parseInt((String) jComboBoxDVDRegiao.getSelectedItem()));
			}

			cad.add(new FilmeTMDB(Integer.parseInt(jTextFieldAno.getText()),
					jTextFieldTitulo.getText(),
					jTextFieldDiretor.getText(),
					jTextFieldUrl.getText(),
					jTextFieldTraduzido.getText(),
					jTextFieldPoster.getText(),
					Integer.parseInt(jTextFieldTmdbid.getText()),
					m,
					jTextAreaComentario.getText(),
					Float.parseFloat(jTextFieldNota.getText()),
					Integer.parseInt(jTextFieldVotos.getText())));
			JOptionPane.showMessageDialog(this, "Filme Cadastrado com Sucesso!");
			list.setListData(cad.toArray());
			list.setSelectedIndex(0);
			this.dispose();
		} else {
			JOptionPane.showMessageDialog(this, "Preencha TODOS os campos editáveis antes de cadastrar");
		}
	}//GEN-LAST:event_jButtonCadastrarActionPerformed

	private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchActionPerformed
		//if (listaFilmes.getListaTitulos().contains(jTextFieldPesquisa.getText())) {
		if (jComboBoxWheretoSearch.getSelectedIndex() == 0) {
			System.out.println("Pegando dados do IMDB top 250");
			for (Filme f: listaFilmes)
				if (f.getTitulo().equals(jTextFieldPesquisa.getText())) {
					jTextFieldTitulo.setText(f.getTitulo());
					jTextFieldAno.setText("" + f.getAno());
					jTextFieldDiretor.setText(f.getDiretor());
					jTextFieldUrl.setText(f.getUrl());
					//FIXED: [Duvida] votos e nota não existe na classe Filme, pegar do IMDB?
					//	   : [Resposta] Não, é prá pegar só o q tem no arquivo do IMDB mesmo.
					return;
				}			
			JOptionPane.showMessageDialog(this, "Filme não encontrado no IMDB");
		} else {
			try {
				System.out.println("Pegando do TMDB " + jTextFieldPesquisa.getText());
				Movie l = Movie.search(jTextFieldPesquisa.getText()).get(0);

				jTextFieldTitulo.setText(l.getName());
				l = Movie.getInfo(l.getID());
				//FIXME: [Duvida] é getID() ou getImdbId()?
				jTextFieldTmdbid.setText("" + l.getID());

				jTextFieldUrl.setText("" + l.getUrl());
				jTextFieldAno.setText("" + l.getReleasedDate().toString().split(" ")[5]);
				jTextFieldVotos.setText("" + l.getVotes());
				jTextFieldNota.setText("" + l.getRating());
				for (CastInfo c : l.getCast()) {
					if (c.getJob().equals("Director")) {
						jTextFieldDiretor.setText(c.getName());
						break;
					}
				}
				//FIXME: [Defeito?] Filme sem diretor: ex. Apple
				MoviePoster p = (MoviePoster) l.getImages().posters.toArray()[0];
				jTextFieldPoster.setText((String) p.getSmallestImage().toString());
			} catch (IOException ex) {
				ex.printStackTrace();
			} catch (JSONException ex) {
				ex.printStackTrace();
			} catch (IndexOutOfBoundsException ex) {
				JOptionPane.showMessageDialog(this, "Filme não encontrado no TMDB");
			}
		}
	}//GEN-LAST:event_jButtonSearchActionPerformed

	private void jTextFieldPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldPesquisaKeyReleased
		if (evt.getKeyCode() == KeyEvent.VK_ENTER)
			jButtonSearchActionPerformed(null);
	}//GEN-LAST:event_jTextFieldPesquisaKeyReleased

    //FIXME: [Enhancement] Acerta o tabindex prá ir do search pro titulo Traduzido
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonArquivoChooseFile;
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JComboBox jComboBoxArquivoCodec;
    private javax.swing.JComboBox jComboBoxDBRegiao;
    private javax.swing.JComboBox jComboBoxDVDRegiao;
    private javax.swing.JComboBox jComboBoxWheretoSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPaneMidia;
    private javax.swing.JTextArea jTextAreaComentario;
    private javax.swing.JTextField jTextFieldAno;
    private javax.swing.JTextField jTextFieldArquivoNome;
    private javax.swing.JTextField jTextFieldArquivoTamanho;
    private javax.swing.JTextField jTextFieldDVDQtd;
    private javax.swing.JTextField jTextFieldDiretor;
    private javax.swing.JTextField jTextFieldNota;
    private javax.swing.JTextField jTextFieldPesquisa;
    private javax.swing.JTextField jTextFieldPoster;
    private javax.swing.JTextField jTextFieldTitulo;
    private javax.swing.JTextField jTextFieldTmdbid;
    private javax.swing.JTextField jTextFieldTraduzido;
    private javax.swing.JTextField jTextFieldUrl;
    private javax.swing.JTextField jTextFieldVotos;
    // End of variables declaration//GEN-END:variables

	private boolean fieldsOk() {
		if (jTextFieldTraduzido.getText().equals(""))
			return false;
		if (jTextAreaComentario.getText().equals(""))
			return false;
		
		return true;
	}

}
