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
        public String Titular { get; set; }

        public virtual void Deposita(double valorOperacao)
        {
            if(valorOperacao <= 0)
            {
                MessageBox.Show("Erro: Quantia inválida!");
            } else {
                this.Saldo += valorOperacao;
                MessageBox.Show("Sucesso! Você depositou R$" + Convert.ToString(valorOperacao)+ ".\n"
                    + "Saldo disponível: R$" + Convert.ToString(this.Saldo)+ ".");
            }
        }

        public virtual void Saca(double valorOperacao)
        {
            if(valorOperacao <= 0) {
                MessageBox.Show("Erro: Saldo inválido!");
            } else {
                this.Saldo -= valorOperacao;
                MessageBox.Show("Sucesso! Você sacou R$" + Convert.ToString(valorOperacao) + ".\n"
                    + "Saldo disponível: R$" + Convert.ToString(this.Saldo) + ".");
            }
        }
    }
}