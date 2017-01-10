#include <iostream>
#include <iomanip>

using std::cout;
using std::setprecision;
using std::setiosflags;

int main(void) {
    float valor = 0.0012345;
    
    // for(int i = 0; i < 6; i++) {
    //     cout << setprecision(i) << valor << '\n';
    // }

    cout << std::fixed << valor << '\n';
    cout << std::scientific << valor << '\n';

    return 0;
}