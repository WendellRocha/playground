using System.Windows.Forms;

namespace Banco {
    class Poupanca : Conta {

        public override void Saca(double valorOperacao) {
            if (valorOperacao - Saldo < 0) {
                MessageBox.Show("Erro: Saldo insuficiente");
            }
            base.Saca(valorOperacao + 0.10);
        }
    }
}
