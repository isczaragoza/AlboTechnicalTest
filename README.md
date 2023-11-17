# AlboTechnicalTest
Albo Technical Test

Prueba Técnica para entrevista Albo.
Creada por: David Zaragoza Garcia

Preguntas Teóricas:

1.- Explique los principios de la arquitectura MVVM. ¿Por qué es preferible sobre MVC en
desarrollo Android?
La arquitectura MVVM es una forma de organizar el código de la aplicación. En terminos generales
MVVM es un patrón de diseño que ayuda a organizar nuestro código en 3 modulos.

View: Se encarga de mostrar la información y recibir las acciones que realiza el usuario a 
través de la interfaz(UI) para notificar al ViewModel de estas acciones.

ViewModel: Establece la conexión entre la Vista y el Modelo. Recibe las acciones por parte de la UI
las gestiona y las comunica al módelo para solicitar datos, de la misma manera el modelo entrega la data al ViewModel 
para comunicarla a la vista, todo esto se puede implementar a través del patrón observador con multiples
herramientas, por ejemplo LiveData. Una caracteristica importante del ViewModel es que sobrevive a los
cambios de configuración por ejemplo rotación de pantalla, cambio de idioma, etc. También tiene un 
alcance de ciclo de vida diferente al ciclo de vida de los activity o fragments.

Model: El Modelo de datos son las clases encargadas de proveer los datos de las diferentes 
fuentes (Local(Room, SharedPrefs, DataStore), Remoto(Retrofit, Volley)).

La principal Ventaja de la Arquitectura MVVM sobre la MVC es que Android en su documentación oficial
la establece como la Arquitectura recomendada, brindando un soporte documentado de manera oficial
por los propios ingenieros de Android, además el framework de Android brinda las herramientas
necesarias para la implementación del MVVM como la propia clase ViewModel(), LiveData, Flows. 
Y estas herramientasson totalmente compatibles con los 2 tipos de vistas de Android XML o JetPack Compose. 
Tambien facilita la gestión de la capa de datos (Model).

Una desventaja de MVC podría ser la manera en la que se gestionan las vistas y el controlador en esta arquitectura,
siendo que las Actities contienen lógica de negocio en su cumplimiento de Controller esto puede generar multiples 
responsabilidades y problemas de gestión al momento en que la aplicación vaya creciendo. Problema que no presenta
MVVM porque la vista no conoce de todas estas implementaciones y responsabilidades.


2.- Describa cómo Koin facilita la inyección de dependencia en aplicaciones Android.

3.- Compare Retrofit y Volley para realizar llamadas de red en Android. ¿Cuáles son las
ventajas de usar uno sobre el otro?

Ambas librerias nos permiten realizar la fácil implementación de peticiones REST.
Ambas libreiras nos permiten el uso de OkHttp

--------------------------------------------------------------------------------------------

Preguntas de Resolución de Problemas:

1.- Dada una situación donde una aplicación Android se enfrenta a problemas de
memoria debido al manejo incorrecto de contextos, ¿cómo lo solucionaría?

2.- Si una aplicación experimenta retardos debido a operaciones de red en el hilo
principal, ¿cómo optimizaría el código?
