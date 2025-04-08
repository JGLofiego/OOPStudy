class SistemaEstrutural:
    def __init__(self):
        self.vigas = []
        self.lajes = []
        self.pilares = []
        self.alvenaria = []

    def adicionar_viga(self, comprimento, largura, altura):
        self.vigas.append({'comprimento': comprimento, 'largura': largura, 'altura': altura})

    def adicionar_laje(self, comprimento, largura, espessura):
        self.lajes.append({'comprimento': comprimento, 'largura': largura, 'espessura': espessura})

    def adicionar_pilar(self, altura, largura):
        self.pilares.append({'altura': altura, 'largura': largura})

    def adicionar_alvenaria(self, altura, largura, comprimento):
        self.alvenaria.append({'altura': altura, 'largura': largura, 'comprimento': comprimento})

    def calcular_peso_total(self):
        peso_total = 0
        for viga in self.vigas:
            peso_total += viga['comprimento'] * viga['largura'] * viga['altura'] * densidade_concreto
        for laje in self.lajes:
            peso_total += laje['comprimento'] * laje['largura'] * laje['espessura'] * densidade_concreto
        for pilar in self.pilares:
            peso_total += pilar['altura'] * pilar['largura'] * densidade_concreto
        for alvenaria in self.alvenaria:
            peso_total += alvenaria['altura'] * alvenaria['largura'] * alvenaria['comprimento'] * densidade_alvenaria
        return peso_total

# Densidades típicas em kg/m³
densidade_concreto = 2400  # Densidade do concreto
densidade_alvenaria = 1800  # Densidade da alvenaria

# Exemplo de uso
comprViga = int(input("Comprimento da viga em metros: "))
larguraViga = int(input("Largura da viga em metros: "))
alturaViga = int(input("Altura da viga em metros: "))

comprLaje = int(input("\nComprimento da Laje em metros: "))
larguraLaje = int(input("Largura da Laje em metros: "))
alturaLaje = int(input("Altura da Laje em metros: "))

larguraPilar = int(input("\nLargura da Pilar em metros: "))
alturaPilar = int(input("Altura da Pilar em metros: "))

comprAlvenaria = int(input("\nComprimento da Alvenaria em metros: "))
larguraAlvenaria = int(input("Largura da Alvenaria em metros: "))
alturaAlvenaria = int(input("Altura da Alvenaria em metros: "))

sistema = SistemaEstrutural()
sistema.adicionar_viga(comprViga, larguraViga, alturaViga)
sistema.adicionar_laje(comprLaje, larguraLaje, alturaLaje)
sistema.adicionar_pilar(larguraPilar, alturaPilar)
sistema.adicionar_alvenaria(comprAlvenaria, larguraAlvenaria, alturaAlvenaria)

peso_total = sistema.calcular_peso_total()
print(f'\nO peso total do sistema estrutural é de {peso_total} kg')