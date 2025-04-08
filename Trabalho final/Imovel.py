from Endereco import Endereco

class Imovel:
    
    __iptu : int = None
    __tipo: str = None
    __util: str = None
    __endereco: Endereco = None
    
    def __init__(self, iptu: int, tipo: str, util: str, rua: str, numero: int, cep: int, cidade: str = 'Salvador', estado: str = 'BA'):
        self.__iptu = iptu
        self.__tipo = tipo
        self.__util = util
        self.__endereco = Endereco(rua, numero, cidade, estado, cep)
        
    def __str__(self) -> str:
        string = ''
        string += '=' * 30
        string += f'\nIPTU: {self.__iptu}'
        string += f'\nTipo: {self.__tipo}'
        string += f'\nUtil: {self.__util}'
        string +=  '\n' + str(self.__endereco)
        string += '\n' + '=' * 30
        return string
        
    def getIptu(self) -> int:
        return  self.__iptu
    
    def getTipo(self) -> str:
        return  self.__tipo
    
    def getUtil(self) -> str:
        return  self.__util
    
    def getEndereco(self) -> Endereco:
        return self.__endereco
    
    def setIptu(self, iptu: int) -> None:
        self.__iptu = iptu
        
    def setTipo(self, tipo: int) -> None:
        self.__tipo = tipo
        
    def setUtil(self, util: int) -> None:
        self.__util = util
        
    def setEnderecoFull(self, rua: str, numero: int, cep: int, cidade: str, estado: str):
        self.__endereco.setRua(rua)
        self.__endereco.setNumero(numero)
        self.__endereco.setCep(cep)
        self.__endereco.setEstado(estado)
        self.__endereco.setCidade(cidade)
        
    def setEndereco(self, rua: str, numero: int, cep: int):
        self.__endereco.setRua(rua)
        self.__endereco.setNumero(numero)
        self.__endereco.setCep(cep)

#Teste Imovel    
if __name__ == '__main__':
    im = Imovel(342, 'casa', 'de praia', 'alguma ai', 12, 45032010)
    
    print(im)
    
    im.setEndereco('talvez', 90, 490940)
    
    print(im)