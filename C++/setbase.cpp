#include <iostream>
#include <iomanip>

int main(void) {
    std::cout << std::setbase(8) << 255 << '\n';
    std::cout << std::setbase(10) << 255 << '\n';
    std::cout << std::setbase(16) << 255 << '\n';
    return 0;
}