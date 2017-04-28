La aplicacion es un web service Rest, ingresando en un browser la siguientes direcciones se ejecutan distintas funcionalidades

_ http://localhost:8080/galaxia/rest/climaWS/informeClima?cantidadAnios=1
Ingresando como parametro la cantidad de Años se retorna un objeto JSON con las cantidades acumuladas 
por cada condición climatica y los dias de maxima precipitación dentro de esa cantidad de años

_ http://localhost:8080/galaxia/rest/climaWS/clima?dia=1
 Ingresando un dia particular se devuelve un objeto JSON con el clima de ese dia
 
 
_ http://localhost:8080/galaxia/rest/climaWS/proyeccion?anios=1
para los años ingresados se calcula y se persiste en base de datos el clima de cada dia de esa cantidad de años ingresada


Al 28/04/2017 este web service esta publicado en AZURE las direcciones correspondientes son

http://galaxiaws.azurewebsites.net/galaxia/rest/climaWS/clima?dia=1
http://galaxiaws.azurewebsites.net/galaxia/rest/climaWS/proyeccion?anios=1
http://galaxiaws.azurewebsites.net/galaxia/rest/climaWS/informeClima?cantidadAnios=1
