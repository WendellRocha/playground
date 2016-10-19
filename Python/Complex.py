import math

class Complex(object):
    def __init__(self, real, imag):
        self._real = real
        self._imag = imag

    def getReal(self):
        return self._real

    def setReal(self, valor):
        self._real = valor
    
    def getImag(self):
        return self._imag
    
    def setImag(self, valor):
        self._imag = valor

    def getR(self):
        return math.sqrt(self._real * self._real + self._imag * self._imag)

    def setR(self, valor):
        theta = self.theta
        self._real = valor * math.cos(theta)
        self._imag = valor * math.sin(theta)

    def getTheta(self):
        return math.atan2(self._imag, self._real)

    def setTheta(self, valor):
        r = self.r
        self._real = r * math.cos(valor)
        self._imag = r * math.sin(valor)

    imag = property(fget = getImag, fset = setImag)
    real = property(fget = getReal, fset = setReal)
    r = property(fget = getR, fset = setR)
    theta = property(fget = getTheta, fset = setTheta)

    def __add__(self, c):
        return Complex(self.real + c.real, self.imag + c.imag)

    def __sub__(self, c):
        return Complex(self.real - c.real, self.imag - c.imag)

    def __mul__(self, c):
        return Complex(self.real * c.real - self.imag * c.imag * c.imag,
                       self.real * c.imag + self.imag * c.real)

    @staticmethod
    def main(*argv):
        "Teste para o Complex"
        c = Complex(0,0)
        print c
        c.real = 1
        c. real = 2
        print c
        c.theta = math.pi/2
        c.r = 50
        print c
        c = Complex(1,2)
        d = Complex(3,4)
        print c, d, c+d, c-d, c*d
        return 0

