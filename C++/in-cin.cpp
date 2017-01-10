#include <iostream>

using std::cout;
using std::cin;

int main(void) {
    int idade;
    float salario;
    char nome[128];

    cout << "Digite seu nome, sua idade e seu salário: ";
    cin >> nome >> idade >> salario;
    cout << nome << " " << idade << " " << salario << "\n";
    return 0;
}