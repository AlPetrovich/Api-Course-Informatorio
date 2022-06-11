API REST - INFORMATORIO - 
Java - Maven - Spring Boot MVC - Spring Data - Spring Security - DTO - Hibernate - MySQL

![informatorioPORTADA](https://user-images.githubusercontent.com/86859904/160525245-34772f4d-35d8-4e1a-9078-81b64033e0d6.PNG)

Descripción de la aplicación (API)

El Informatorio planea lanzar en varias plataformas (Web, iOS y Android) una aplicación donde se publicaran varios proyectos startup (emprendimientos). Donde los emprendedores podrán publicar sus ideas y de esa forma conseguir votos e inclusive recaudar fondos.
Los emprendimientos podrán ser de diferentes rubros (apps, desarrollo de productos, etc).
Se podrán conseguir votos y aportes en cualquier momento. Pero también existirá la posibilidad de suscribirse a eventos en donde el ganador recibirá el premio del evento.

De las siguientes entidades se necesita conocer y registrar

USUARIO: id (autogenerado)-nombre - apellido -email (unico) -password (se almacenará pero no deberá ser mostrado) -fecha de creación (o alta) -ciudad -provincia -país -tipo: USUARIO | COLABORADOR | OWNER

EMPRENDIMIENTO: id (autogenerado) -nombre -descripción -contenido (cuerpo de la publicación) -fecha de creación (o alta) -Objetivo: $ (recaudacion) -publicado (true o false) -URL (capturas) - puede tener 0 o varias -Tags (ejemplo: #salud, #diversion, etc. Obs: el “#” es decorado)

VOTO: id (autogenerado) -generado por (mobile, web, servicio) -Usuario (username) -fecha de creación (o alta) -Observación: Se asume que los votos son LIKES (no hay negativos)

EVENTO: id (autogenerado) -Detalles del evento (Descripción, info de auspiciantes, premio) -fecha de creación (o alta) -fecha de cierre (o alta) -Estado: ABIERTO | EN CURSO | FINALIZADO -suscriptores (Emprendimientos que se registraron) -premio: $



![operacioonesUsuario](https://user-images.githubusercontent.com/86859904/160526295-b85d152f-fb14-43de-8b36-5bb70346ef5e.PNG)
![operacionesEmprendimiento](https://user-images.githubusercontent.com/86859904/160526362-162bdfe2-b938-4bf2-83a0-89210e122fdd.PNG)
![operacionesVOTO](https://user-images.githubusercontent.com/86859904/160526387-8a7cf12f-62f4-4c31-bac1-5f3889f156c6.PNG)
![operacionesEvento](https://user-images.githubusercontent.com/86859904/160526412-58d52947-eeac-413d-8a13-e27e9a08321f.PNG)
![apiInfoCap1](https://user-images.githubusercontent.com/86859904/160526505-39dfe603-ab03-4169-ae5a-4227cf2bc5ce.PNG)
![apiInfoCap2](https://user-images.githubusercontent.com/86859904/160526524-b7d7470c-cf77-4c5b-9bb5-67e63f767cb1.PNG)
![apiInfoCap3](https://user-images.githubusercontent.com/86859904/160526528-69d39976-470b-48f5-b55c-c515cd7c649f.PNG)
