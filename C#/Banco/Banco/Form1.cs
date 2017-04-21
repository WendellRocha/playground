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
        private int Numero = 0;

        public Form1()
        {
            InitializeComponent();
        }

        private void botaoDepositar_Click(object sender, EventArgs e)
        {
            if(string.IsNullOrEmpty(quantia.Text)) {
                MessageBox.Show("Erro: Quantia inválida!");
            } else {
                string valorDigitado = this.quantia.Text;
                double valor = Convert.ToDouble(valorDigitado);
                conta.Deposita(valor);
                saldo.Text = Convert.ToString(this.conta.Saldo);
            }
        }

        private void botaoSaque_Click(object sender, EventArgs e)
        {
            if(string.IsNullOrEmpty(quantia.Text)) {
                MessageBox.Show("Erro: Quantia inválida!");
            } else {
                string valorDigitado = this.quantia.Text;
                double valor = Convert.ToDouble(valorDigitado);
                this.conta.Saca(valor);
                saldo.Text = Convert.ToString(this.conta.Saldo);
            }
        }

        private void botaoCriar_Click(object sender, EventArgs e) {
            if (string.IsNullOrEmpty(clienteNome.Text)) {
                MessageBox.Show("Erro: Nome inválido!");
            } else if (Convert.ToDecimal(dataDeNascimento.Text) < 18 && (tipoDeConta.Text.Equals("Corrente")))  {
                MessageBox.Show("Erro: Idade insuficiente para abrir uma conta corrente");
            } else if (tipoDeConta.Text.Equals("Corrente")) {
                Cliente novoCliente = new Cliente(clienteNome.Text, clienteCPF.Text, clienteRG.Text, dataDeNascimento.Text);
                conta = new Corrente();
                conta.Titular = Convert.ToString(clienteNome.Text);
                this.conta.Numero = Numero++;
                titular.Text = novoCliente.Nome;
                numeroConta.Text = Convert.ToString(this.conta.Numero);
                saldo.Text = Convert.ToString(this.conta.Saldo);
            } else {
                Cliente novoCliente = new Cliente(clienteNome.Text, clienteCPF.Text, clienteRG.Text, dataDeNascimento.Text);
                conta = new Poupanca();
                conta.Titular = Convert.ToString(clienteNome.Text);
                this.conta.Numero = Numero++;
                titular.Text = novoCliente.Nome;
                numeroConta.Text = Convert.ToString(this.conta.Numero);
                saldo.Text = Convert.ToString(this.conta.Saldo);
            }
        }
    }
}
