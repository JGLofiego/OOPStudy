from Endereco import Endereco
from Imovel import Imovel
from typing import List

class Proprietario:
    __nome: str = None
    __cpf: int = None
    __rg: int = None
    __endereco: Endereco = None
    __listaImoveis: List[Imovel] = None
    
    def __init__(self, nome: str, cpf: int, rg: int, rua: str, numero: int, cep: int, cidade: str = 'Salvador', estado: str = 'BA'):
        self.__nome = nome
        self.__cpf = cpf
        self.__rg = rg
        self.__endereco = Endereco(rua, numero, cidade, estado, cep)
        self.__listaImoveis = []
        
    def addImovel(self, imovel: Imovel) -> bool:
        if imovel.getEndereco().__eq__(self.__endereco):
            return False
        self.__listaImoveis.append(imovel)
        return True
    
    def printImoveis(self, tipo:str = None) -> None:
        if tipo is None:
            print("Lista de Imóveis\n")
            for i in self.__listaImoveis:
                print(str(i) + '\n')
        else:
            print(f"Lista de Imóveis do tipo {tipo}\n")
            for i in self.__listaImoveis:
                if(i.getTipo() == tipo):
                    print(str(i) + '\n')
        
    def getNome(self) -> str:
        return self.__nome
    
    def getCpf(self) -> int:
        return self.__cpf
    
    def getRg(self) -> int:
        return self.__rg
    
    def getEndereco(self) -> Endereco:
        return self.__endereco
    
    def getListaImoveis(self) -> List[Imovel]:
        return self.__listaImoveis
    
    def setNome(self, nome: str) -> None:
        self.__nome = nome
        
    def setCpf(self, cpf: int) -> None:
        self.__cpf = cpf
        
    def setRg(self, rg: int) -> None:
        self.__rg = rg
        
    def setEndereco(self, rua: str, numero: int, cep: int, estado: str, cidade: str) -> None:
        self.__endereco.setRua(rua)
        self.__endereco.setNumero(numero)
        self.__endereco.setCep(cep)
        self.__endereco.setEstado(estado)
        self.__endereco.setCidade(cidade)
        
#teste com proprietario        
if __name__ == '__main__':
    prop = Proprietario('JG', 21331342, 4234234, 'a', 8, 798786, 'salvador')
    
    im1 = Imovel(8098, 'casa', 'de praia', 'a', 8, 798786, 'salvador')
    im2 = Imovel(8098, 'casa', 'de praia', 'alguma ai', 4, 798786, 'salvador')
    im3 = Imovel(8098, 'apartamento', 'de praia', 'algumas ai', 8, 798786, 'salvador')
    
    prop.addImovel(im1)
    prop.addImovel(im2)
    prop.addImovel(im3)
    
    prop.printImoveis('casa')