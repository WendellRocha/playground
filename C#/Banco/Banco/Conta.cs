using System;
using System.Windows.Forms;

namespace Banco
{
    public class Conta
    {
        public Conta()
        {
        }

        public int Numero { get; set; }
        public double Saldo { get; private set; }
        public Cliente Titular { get; internal set; }

        public void Deposita(double valorOperacao)
        {
            if(valorOperacao <= 0)
            {
                MessageBox.Show("Erro: Quantia inválida!");
            } else {
                this.Saldo += valorOperacao;
                MessageBox.Show("Sucesso");
            }
        }

        public void Saca(double valorOperacao)
        {
            if(valorOperacao <= Saldo) {
                this.Saldo -= valorOperacao;
                MessageBox.Show("Sucesso");
            } else {
                MessageBox.Show("Erro: Saldo inválido!");
            }
        }
    }
}