from Imovel import Imovel
from Proprietario import Proprietario
from typing import List

listaDeImoveis: List[Imovel] = []
listaDeProprietarios: List[Proprietario] = []

def readImovel() -> Imovel:
    print("Cadastramento de Imóvel:\n")
    iptu:int = int(input("\nIPTU: "))
    rua:str = input("\nRua: ")
    numero:int = int(input("\nNumero: "))
    cep:int = int(input("\nCEP: "))
    estado:str = input("\nEstado: ")
    cidade:str = input("\nCidade: ")
    tipo: str = input("\nTipo(Ex: Casa, Apartamento ...): ")
    util: str = input("\nUtilização(Ex: De praia, De Inverno...): ")
    
    imovel = Imovel(iptu, tipo, util, rua, numero, cep, cidade, estado)
    return imovel

def readProprietario() -> Proprietario:
    print("Cadastramento de Proprietario:\n")
    nome:str = input("\nNome: ")
    cpf:int = int(input("\nCPF: "))
    rg:int = int(input("\nRG: "))
    rua:str = input("\nRua: ")
    numero:int = int(input("\nNumero: "))
    cep:int = int(input("\nCEP: "))
    estado:str = input("\nEstado: ")
    cidade:str = input("\nCidade: ")
    
    proprietario = Proprietario(nome, cpf, rg, rua, numero, cep, cidade, estado)
    return proprietario

def addProprietario(prop: Proprietario) -> bool:
    if prop in listaDeProprietarios:
        return False
    listaDeProprietarios.append(prop)
    return True

def addImovel(im: Imovel) -> bool:
    if im in listaDeImoveis:
        return False
    listaDeImoveis.append(im)
    return True    
    
if  __name__ == '__main__':
    print(('*' * 60))
    print('\n' + ('*' * 18) +'SISTEMA DE CADASTRAMENTO' + ('*' * 18))
    print('\n' + ('*' * 60))
    
    result:str = ''
    while(result != 'n'):
        result = input("\nCadastrar Imóvel ou Proprietário('i' ou 'p'): ")
        
        if result == 'i':
            added:bool = addImovel(readImovel())
            if added:
                print("\nImóvel cadastrado com sucesso!")
            else:
                print("\nAlgum erro ocorreu, tente novamente.")
        elif result == 'p':
            added:bool = addProprietario(readProprietario())
            if added:
                print("\nProprietário cadastrado com sucesso!")
            else:
                print("\nAlgum erro ocorreu, tente novamente.")
        else:
            continue
        
        result = input("\nCadastrar mais? ('s' ou 'n')")
    
    