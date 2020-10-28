# Bitacora
- Se estudia el codigo y la estrategia elegida es: se aplicara el patron Estrategia pero con una variacion que es que en la clase concreta, se definira el algoritmo que corresponda al item. Esto ultimo se hara para no tocar el comportamiento de los test.
- Se ve necesario refactorizar la definicion de la clase concreta para el item especifico. Se crea un nuevo metodo que define la clase concreta a utilizar para el item.
- Una vez terminado de implementar la clase concreta para el nuevo item "Conjured Mana Cake": cuando se habilitan las pruebas comentadas, saltan 3 errores. Se ve que son errores por no controlar el tema por cero o alguna validacion al respecto: 
  - testConjuredAlternativeQualityWhenSellInZero
  - testConjuredNonZeroQuality
  - testConjuredAlternativeNonZeroQuality
- Revisando el codigo se ve que no se estaba controlando cuando Quality bajaba a menor a cero. Se agrego lo siguiente al final del codigo para este tipo de item y se resolvio el problema, todas las pruebas salen ok:
if (item.getQuality()<0)
            item.setQuality(0);
