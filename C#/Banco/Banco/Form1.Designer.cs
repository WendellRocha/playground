namespace Banco
{
    partial class Form1
    {
        /// <summary>
        /// Variável de designer necessária.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpar os recursos que estão sendo usados.
        /// </summary>
        /// <param name="disposing">true se for necessário descartar os recursos gerenciados; caso contrário, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código gerado pelo Windows Form Designer

        /// <summary>
        /// Método necessário para suporte ao Designer - não modifique 
        /// o conteúdo deste método com o editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.titular = new System.Windows.Forms.TextBox();
            this.numeroConta = new System.Windows.Forms.TextBox();
            this.saldo = new System.Windows.Forms.TextBox();
            this.quantia = new System.Windows.Forms.TextBox();
            this.botaoDepositar = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.botaoSaque = new System.Windows.Forms.Button();
            this.groupBox1 = new System.Windows.Forms.GroupBox();
            this.groupBox2 = new System.Windows.Forms.GroupBox();
            this.label9 = new System.Windows.Forms.Label();
            this.tipoDeConta = new System.Windows.Forms.ComboBox();
            this.botaoCriar = new System.Windows.Forms.Button();
            this.label8 = new System.Windows.Forms.Label();
            this.label7 = new System.Windows.Forms.Label();
            this.label6 = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.dataDeNascimento = new System.Windows.Forms.TextBox();
            this.clienteRG = new System.Windows.Forms.TextBox();
            this.clienteCPF = new System.Windows.Forms.TextBox();
            this.clienteNome = new System.Windows.Forms.TextBox();
            this.groupBox1.SuspendLayout();
            this.groupBox2.SuspendLayout();
            this.SuspendLayout();
            // 
            // titular
            // 
            this.titular.Location = new System.Drawing.Point(158, 22);
            this.titular.Name = "titular";
            this.titular.ReadOnly = true;
            this.titular.Size = new System.Drawing.Size(100, 20);
            this.titular.TabIndex = 0;
            // 
            // numeroConta
            // 
            this.numeroConta.Location = new System.Drawing.Point(158, 48);
            this.numeroConta.Name = "numeroConta";
            this.numeroConta.ReadOnly = true;
            this.numeroConta.Size = new System.Drawing.Size(100, 20);
            this.numeroConta.TabIndex = 1;
            // 
            // saldo
            // 
            this.saldo.Location = new System.Drawing.Point(158, 74);
            this.saldo.Name = "saldo";
            this.saldo.ReadOnly = true;
            this.saldo.Size = new System.Drawing.Size(100, 20);
            this.saldo.TabIndex = 2;
            // 
            // quantia
            // 
            this.quantia.Location = new System.Drawing.Point(158, 100);
            this.quantia.Name = "quantia";
            this.quantia.Size = new System.Drawing.Size(100, 20);
            this.quantia.TabIndex = 3;
            // 
            // botaoDepositar
            // 
            this.botaoDepositar.Location = new System.Drawing.Point(183, 139);
            this.botaoDepositar.Name = "botaoDepositar";
            this.botaoDepositar.Size = new System.Drawing.Size(75, 23);
            this.botaoDepositar.TabIndex = 4;
            this.botaoDepositar.Text = "Depositar";
            this.botaoDepositar.UseVisualStyleBackColor = true;
            this.botaoDepositar.Click += new System.EventHandler(this.botaoDepositar_Click);
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(59, 22);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(81, 13);
            this.label1.TabIndex = 5;
            this.label1.Text = "Nome do titular:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(48, 51);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(92, 13);
            this.label2.TabIndex = 6;
            this.label2.Text = "Número da conta:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(51, 77);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(89, 13);
            this.label3.TabIndex = 7;
            this.label3.Text = "Saldo disponível:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(106, 103);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(34, 13);
            this.label4.TabIndex = 8;
            this.label4.Text = "Valor:";
            // 
            // botaoSaque
            // 
            this.botaoSaque.Location = new System.Drawing.Point(51, 139);
            this.botaoSaque.Name = "botaoSaque";
            this.botaoSaque.Size = new System.Drawing.Size(75, 23);
            this.botaoSaque.TabIndex = 9;
            this.botaoSaque.Text = "Sacar";
            this.botaoSaque.UseVisualStyleBackColor = true;
            this.botaoSaque.Click += new System.EventHandler(this.botaoSaque_Click);
            // 
            // groupBox1
            // 
            this.groupBox1.Controls.Add(this.label2);
            this.groupBox1.Controls.Add(this.botaoSaque);
            this.groupBox1.Controls.Add(this.titular);
            this.groupBox1.Controls.Add(this.label4);
            this.groupBox1.Controls.Add(this.numeroConta);
            this.groupBox1.Controls.Add(this.label3);
            this.groupBox1.Controls.Add(this.saldo);
            this.groupBox1.Controls.Add(this.quantia);
            this.groupBox1.Controls.Add(this.label1);
            this.groupBox1.Controls.Add(this.botaoDepositar);
            this.groupBox1.Location = new System.Drawing.Point(7, 210);
            this.groupBox1.Name = "groupBox1";
            this.groupBox1.Size = new System.Drawing.Size(316, 179);
            this.groupBox1.TabIndex = 10;
            this.groupBox1.TabStop = false;
            this.groupBox1.Text = "Conta";
            // 
            // groupBox2
            // 
            this.groupBox2.Controls.Add(this.label9);
            this.groupBox2.Controls.Add(this.tipoDeConta);
            this.groupBox2.Controls.Add(this.botaoCriar);
            this.groupBox2.Controls.Add(this.label8);
            this.groupBox2.Controls.Add(this.label7);
            this.groupBox2.Controls.Add(this.label6);
            this.groupBox2.Controls.Add(this.label5);
            this.groupBox2.Controls.Add(this.dataDeNascimento);
            this.groupBox2.Controls.Add(this.clienteRG);
            this.groupBox2.Controls.Add(this.clienteCPF);
            this.groupBox2.Controls.Add(this.clienteNome);
            this.groupBox2.Location = new System.Drawing.Point(7, 12);
            this.groupBox2.Name = "groupBox2";
            this.groupBox2.Size = new System.Drawing.Size(316, 192);
            this.groupBox2.TabIndex = 11;
            this.groupBox2.TabStop = false;
            this.groupBox2.Text = "Criar conta";
            // 
            // label9
            // 
            this.label9.AutoSize = true;
            this.label9.Location = new System.Drawing.Point(75, 19);
            this.label9.Name = "label9";
            this.label9.Size = new System.Drawing.Size(76, 13);
            this.label9.TabIndex = 10;
            this.label9.Text = "Tipo de conta:";
            // 
            // tipoDeConta
            // 
            this.tipoDeConta.FormattingEnabled = true;
            this.tipoDeConta.Items.AddRange(new object[] {
            "Corrente",
            "Poupança"});
            this.tipoDeConta.Location = new System.Drawing.Point(157, 16);
            this.tipoDeConta.Name = "tipoDeConta";
            this.tipoDeConta.Size = new System.Drawing.Size(101, 21);
            this.tipoDeConta.TabIndex = 9;
            // 
            // botaoCriar
            // 
            this.botaoCriar.Location = new System.Drawing.Point(182, 155);
            this.botaoCriar.Name = "botaoCriar";
            this.botaoCriar.Size = new System.Drawing.Size(75, 23);
            this.botaoCriar.TabIndex = 8;
            this.botaoCriar.Text = "Criar";
            this.botaoCriar.UseVisualStyleBackColor = true;
            this.botaoCriar.Click += new System.EventHandler(this.botaoCriar_Click);
            // 
            // label8
            // 
            this.label8.AutoSize = true;
            this.label8.Location = new System.Drawing.Point(39, 122);
            this.label8.Name = "label8";
            this.label8.Size = new System.Drawing.Size(101, 13);
            this.label8.TabIndex = 7;
            this.label8.Text = "Ano de nascimento:";
            // 
            // label7
            // 
            this.label7.AutoSize = true;
            this.label7.Location = new System.Drawing.Point(114, 96);
            this.label7.Name = "label7";
            this.label7.Size = new System.Drawing.Size(26, 13);
            this.label7.TabIndex = 6;
            this.label7.Text = "RG:";
            // 
            // label6
            // 
            this.label6.AutoSize = true;
            this.label6.Location = new System.Drawing.Point(114, 73);
            this.label6.Name = "label6";
            this.label6.Size = new System.Drawing.Size(30, 13);
            this.label6.TabIndex = 5;
            this.label6.Text = "CPF:";
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(110, 47);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(38, 13);
            this.label5.TabIndex = 4;
            this.label5.Text = "Nome:";
            // 
            // dataDeNascimento
            // 
            this.dataDeNascimento.Location = new System.Drawing.Point(157, 122);
            this.dataDeNascimento.Name = "dataDeNascimento";
            this.dataDeNascimento.Size = new System.Drawing.Size(100, 20);
            this.dataDeNascimento.TabIndex = 3;
            // 
            // clienteRG
            // 
            this.clienteRG.Location = new System.Drawing.Point(157, 96);
            this.clienteRG.Name = "clienteRG";
            this.clienteRG.Size = new System.Drawing.Size(100, 20);
            this.clienteRG.TabIndex = 2;
            // 
            // clienteCPF
            // 
            this.clienteCPF.Location = new System.Drawing.Point(157, 70);
            this.clienteCPF.Name = "clienteCPF";
            this.clienteCPF.Size = new System.Drawing.Size(100, 20);
            this.clienteCPF.TabIndex = 1;
            // 
            // clienteNome
            // 
            this.clienteNome.Location = new System.Drawing.Point(158, 44);
            this.clienteNome.Name = "clienteNome";
            this.clienteNome.Size = new System.Drawing.Size(100, 20);
            this.clienteNome.TabIndex = 0;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(329, 401);
            this.Controls.Add(this.groupBox2);
            this.Controls.Add(this.groupBox1);
            this.Name = "Form1";
            this.Text = "Banco";
            this.groupBox1.ResumeLayout(false);
            this.groupBox1.PerformLayout();
            this.groupBox2.ResumeLayout(false);
            this.groupBox2.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.TextBox titular;
        private System.Windows.Forms.TextBox numeroConta;
        private System.Windows.Forms.TextBox saldo;
        private System.Windows.Forms.TextBox quantia;
        private System.Windows.Forms.Button botaoDepositar;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Button botaoSaque;
        private System.Windows.Forms.GroupBox groupBox1;
        private System.Windows.Forms.GroupBox groupBox2;
        private System.Windows.Forms.Label label8;
        private System.Windows.Forms.Label label7;
        private System.Windows.Forms.Label label6;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.TextBox dataDeNascimento;
        private System.Windows.Forms.TextBox clienteRG;
        private System.Windows.Forms.TextBox clienteCPF;
        private System.Windows.Forms.TextBox clienteNome;
        private System.Windows.Forms.Button botaoCriar;
        private System.Windows.Forms.ComboBox tipoDeConta;
        private System.Windows.Forms.Label label9;
    }
}

