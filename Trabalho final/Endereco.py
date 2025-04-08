class Endereco:
    __rua: str = None
    __numero: int = None
    __cidade: str = None
    __estado: str = None
    __cep: int = None
    
    def __init__(self, rua: str, numero: int, cidade: str, estado: str, cep: int) -> None:
        self.__rua = rua
        self.__numero = numero
        self.__cidade = cidade
        self.__estado = estado
        self.__cep = cep
        
    def __str__(self) -> str:
        string = ''
        string += f'\nRua: {self.__rua}'
        string += f'\nNumero: {self.__numero}'
        string += f'\nCidade: {self.__cidade}'
        string += f'\nEstado: {self.__estado}'
        string += f'\nCEP: {self.__cep}'
        return string
    
    def __eq__(self, __value: object) -> bool:
        resultRua = __value.getRua() == self.__rua
        resultNumero = __value.getNumero() == self.__numero
        resultCidade = __value.getCidade() == self.__cidade
        resultEstado = __value.getEstado() == self.__estado
        resultCep = __value.getCep() == self.__cep
                
        return resultRua and resultNumero and resultCidade and resultEstado and resultCep
    
    def __ne__(self, __value: object) -> bool:
        return not self.__eq__(__value)
        
    def getRua(self) -> str:
        return self.__rua
    
    def getNumero(self) -> int:
        return self.__numero
    
    def getCidade(self) -> str:
        return self.__cidade
    
    def getEstado(self) -> str:
        return self.__estado
    
    def getCep(self) -> int:
        return self.__cep
    
    def setRua(self, rua: str) -> None:
        self.__rua = rua
    
    def setNumero(self, numero: int) -> None:
        self.__numero = numero
    
    def setCidade(self, cidade: str) -> None:
        self.__cidade = cidade
    
    def setEstado(self, estado: str) -> None:
        self.__estado = estado
    
    def setCep(self, cep: int) -> None:
        self.__cep = cep
    
#Teste Endereço
if __name__ == '__main__':
    endereco = Endereco('alguma', 10, 'salvador', 'BA', 423423)
    
    print(endereco)