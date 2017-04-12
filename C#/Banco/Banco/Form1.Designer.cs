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
            this.valor = new System.Windows.Forms.TextBox();
            this.botaoDepositar = new System.Windows.Forms.Button();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.botaoSaque = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // titular
            // 
            this.titular.Enabled = false;
            this.titular.Location = new System.Drawing.Point(147, 31);
            this.titular.Name = "titular";
            this.titular.Size = new System.Drawing.Size(100, 20);
            this.titular.TabIndex = 0;
            // 
            // numeroConta
            // 
            this.numeroConta.Enabled = false;
            this.numeroConta.Location = new System.Drawing.Point(147, 57);
            this.numeroConta.Name = "numeroConta";
            this.numeroConta.Size = new System.Drawing.Size(100, 20);
            this.numeroConta.TabIndex = 1;
            // 
            // saldo
            // 
            this.saldo.Enabled = false;
            this.saldo.Location = new System.Drawing.Point(147, 83);
            this.saldo.Name = "saldo";
            this.saldo.Size = new System.Drawing.Size(100, 20);
            this.saldo.TabIndex = 2;
            // 
            // valor
            // 
            this.valor.Location = new System.Drawing.Point(147, 109);
            this.valor.Name = "valor";
            this.valor.Size = new System.Drawing.Size(100, 20);
            this.valor.TabIndex = 3;
            // 
            // botaoDepositar
            // 
            this.botaoDepositar.Location = new System.Drawing.Point(172, 148);
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
            this.label1.Location = new System.Drawing.Point(48, 34);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(81, 13);
            this.label1.TabIndex = 5;
            this.label1.Text = "Nome do titular:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(37, 60);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(92, 13);
            this.label2.TabIndex = 6;
            this.label2.Text = "Número da conta:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(40, 86);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(89, 13);
            this.label3.TabIndex = 7;
            this.label3.Text = "Saldo disponível:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(95, 112);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(34, 13);
            this.label4.TabIndex = 8;
            this.label4.Text = "Valor:";
            // 
            // botaoSaque
            // 
            this.botaoSaque.Location = new System.Drawing.Point(40, 148);
            this.botaoSaque.Name = "botaoSaque";
            this.botaoSaque.Size = new System.Drawing.Size(75, 23);
            this.botaoSaque.TabIndex = 9;
            this.botaoSaque.Text = "Sacar";
            this.botaoSaque.UseVisualStyleBackColor = true;
            this.botaoSaque.Click += new System.EventHandler(this.botaoSaque_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(284, 183);
            this.Controls.Add(this.botaoSaque);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.label3);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.botaoDepositar);
            this.Controls.Add(this.valor);
            this.Controls.Add(this.saldo);
            this.Controls.Add(this.numeroConta);
            this.Controls.Add(this.titular);
            this.Name = "Form1";
            this.Text = "Banco";
            this.Load += new System.EventHandler(this.Form1_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox titular;
        private System.Windows.Forms.TextBox numeroConta;
        private System.Windows.Forms.TextBox saldo;
        private System.Windows.Forms.TextBox valor;
        private System.Windows.Forms.Button botaoDepositar;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.Button botaoSaque;
    }
}

