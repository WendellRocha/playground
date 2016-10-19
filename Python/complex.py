class Complex(object):
    def __init__(self, real, imag):
        self._real = real
        self._imag = imag

    def getReal(self):
        return self._real

    def setReal(self, valor):
        self._real = valor

    real = property(
            fget = getReal,
            fset = setReal)

    def getImag(self):
        return self._imag
    
    def setImag(self, valor):
        self._imag = valor

    imag = property(
            fget = getImag,
            fset = setImag)


c = Complex(1,0)
c.setReal(2)
print c.getReal()

