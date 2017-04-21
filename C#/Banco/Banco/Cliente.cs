namespace Banco
{
    public class Cliente
    {

        public Cliente(string nome, string cpf, string rg, string data)
        {
            this.Nome = nome;
            this.CPF = cpf;
            this.RG = rg;
            this.Data = data;
        }

        public string Nome { get; set; }
        public object CPF { get; set; }
        public object RG { get; set; }
        public object Data { get; set; }
    }
}