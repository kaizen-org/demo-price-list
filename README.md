# Aplicacion Spring Boot demo que expone endpoint GET /api/price?brandId=<brandId>&productId=<productId>&date=<date> para la consulta de precios
(ejemplo GET /api/price?brandId=35455&productId=1&date=2020-12-30 23:58:58)

-- Hay dos posibles implementaciones para la persistencia, con sus PROS y CONTRAS.

Amblas implmentaciones devoleran un Optional que contendrá el precio (en caso de haberlo con los paremetros obtenidos)

Como la consulta peude devolver varios registros y solo nos interesa la información del primero, hay una aproximacióm sencilla en la rama main

https://github.com/kaizen-org/demo-price-list/blob/787911d74778fce48df73db8e05854117cd2cfc5/src/main/java/com/zara/prices/repository/PriceRepository.java#L32

PROS: Todo queda en la interfaz de repository y es de fail mantenidmiento

CONTRAS: Todos los registros que se han obtenido de la consulta se han instanciado como una entity Java aunque solo se vaya a usar el primero (problemas de rendimiento si son muchos)


La segunda aproximación mitiga el efecto no deseado de la primera

https://github.com/kaizen-org/demo-price-list/blob/c038fb4a268f12d3fd6a7166c4c2b3db204eb7ff/src/main/java/com/zara/prices/repository/PriceRepositoryCustomImpl.java#L138

PROS: Solo se instancia la entity que se usará 

CONTRAS: El código es mas complejo, en caso de que no supongo un problema de rendicmiento esta solución pueder ser sobreingenieria

  
  ![image](https://user-images.githubusercontent.com/924807/119991972-52e57300-bfca-11eb-8602-db3e130a091f.png)
