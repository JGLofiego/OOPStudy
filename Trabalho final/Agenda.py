from datetime import datetime
from typing import List

class Agenda:
    __listaBloqueado: List[datetime] = None
    __listaAlugado: List[datetime] = None
    __listaDisponivel: List[datetime] = None
    
    def __init__(self):
        self.__listaBloqueado = []
        self.__listaAlugado = []
        self.__listaDisponivel = []
    
    def getBloqueados(self) -> list[datetime]:
        return self.__listaBloqueado
    
    def getAlugados(self) -> list[datetime]:
        return self.__listaAlugado
    
    def getDisponivel(self) -> list[datetime]:
        return self.__listaDisponivel
    
    #Checa se existe a data na lista de alugados
    def checkAlugado(self, date: datetime) -> bool:
        if date in self.__listaAlugado:
            return True
        return False
    
    #Checa se existe a data na lista de bloqueados
    def checkBloqueado(self, date: datetime) -> bool:
        if date in self.__listaBloqueado:
            return True
        return False
    
    #Checa se existe a data na lista de disponíveis
    def checkDisponivel(self, date: datetime) -> bool:
        if date in self.__listaBloqueado:
            return True
        return False
    
    def addAlugadoInst(self, date: datetime) -> bool:
        result = self.checkAlugado(date)
        result |= self.checkBloqueado(date)
        result |= self.checkDisponivel(date)
        
        if result:
            return False
        
        self.__listaAlugado.append(date)
        return True
        
    def addAlugado(self, dia: int, mes: int, ano: int) -> bool:
        date = datetime(ano, mes, dia)
        return self.addAlugadoInst(date)
        
    def addBloqueadoInst(self, date: datetime) -> bool:
        result = self.checkBloqueado(date)
        result |= self.checkAlugado(date)
        result |= self.checkDisponivel(date)
        
        if result:
            return False
        
        self.__listaBloqueado.append(date)
        return True
        
    def addBloqueado(self, dia: int, mes: int, ano: int) -> bool:
        date = datetime(ano, mes, dia)
        return self.addBloqueadoInst(date)
    
    def addDisponivelInst(self, date: datetime) -> bool:
        result = self.checkDisponivel(date)
        result |= self.checkAlugado(date)
        result |= self.checkBloqueado(date)
        
        if result:
            return False
        
        self.__listaDisponivel.append(date)
        return True
        
    def addDisponivel(self, dia: int, mes: int, ano: int) -> bool:
        date = datetime(ano, mes, dia)
        return self.addDisponivelInst(date)
    
#Testes com a agenda
if __name__ == '__main__':
    agenda = Agenda()
    
    agenda.addAlugado(3, 10, 2002)
    agenda.addBloqueado(4, 10, 2002)
    agenda.addDisponivel(5, 10, 2002)
    
    agenda.addAlugado(3, 10, 2002)
    agenda.addBloqueado(3, 10, 2002)
    agenda.addDisponivel(3, 10, 2002)
    
    
    print(agenda.getAlugados())
    print(agenda.getBloqueados())
    print(agenda.getDisponivel())