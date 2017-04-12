using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Banco
{
    public partial class Form1 : Form
    {
        private Conta conta;

        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            this.conta = new Conta();
            conta.Numero = 1;
            Cliente cliente = new Cliente("Wendell");
            conta.Titular = cliente;
            titular.Text = conta.Titular.Nome;
            numeroConta.Text = Convert.ToString(conta.Numero);
            saldo.Text = Convert.ToString(conta.Saldo);

        }

        private void botaoDepositar_Click(object sender, EventArgs e)
        {
            string valorDigitado = this.valor.Text;
            double valor = Convert.ToDouble(valorDigitado);
            conta.Deposita(valor);
            saldo.Text = Convert.ToString(this.conta.Saldo);
        }

        private void botaoSaque_Click(object sender, EventArgs e)
        {
            string valorDigitado = this.valor.Text;
            double valor = Convert.ToDouble(valorDigitado);
            this.conta.Saca(valor);
            saldo.Text = Convert.ToString(this.conta.Saldo);
        }
    }
}
