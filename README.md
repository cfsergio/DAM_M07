# M07-UF1-Practica_02-Editor_de_text

##Creació d'un editor de textos
##Treballar amb controls de menú

- Els elements principals per constriui menús amb JavaFX són:

    MenuBar: barra de menú
    Menu: un menú dins la barra de manús
    MenuItem: un element d'un menú

- En arrossegar i deixar anar una barra de menú del panell Library fins al panell de contingut, conté per defecte elements de 3 menús que s'etiqueten File, Edit i Help. Per defecte, cada un d'aquests menús també conté un item del menú. Evidentment tot això ho podem modificar segons ens convingui.

- Els elements de menú i d'ítem de menú no tenen representacions gràfiques visibles en el panell de contingut, de manera que només poden utilitzar el panell de jerarquia per seleccionar i gestionar aquests elements.

- Podeu canviar l'ordre de com es mostren els elements de menú a la barra de menú, seleccionant l'element de menú del panell Jerarquia i arrossegant a una nova ubicació dins del menú en què voleu que aparegui.

- Podeu afegir altres articles relacionats amb el menú, com un altre element del menú o un separador d'element de menú, arrossegant l'element des del panell Library fins la ubicació del menú desitjat en el panell de la Jerarquia.

- Per crear un menú de segon nivell, arrossega un element de menú dins d'un element de menú ja existent en el panell de la Jerarquia.

- Utilitzeu el menú Preview per veure la barra de menú en acció.


Més informació sobre aquests i altres controls relacionats amb els menús a la documentació oficial.


##Exercici: editor de textos

Es tracta de que creeu un editor de textos bàsic:

- Per implementar l'àrea d'edició podeu usar el control TextArea

- Creareu els següents menús i elements de menú:

Fitxer: Sortir

Editar: Copiar, Tallar, Enganxar, Desfer

Opcions: Font, Tamany

Ajuda: Sobre l'Editor

- Per sortir de l'aplicació podeu cridar a Platform.exit();

- Per implementar les accions del menú Editar podeu usar diferents mètodes de la classe TextArea

- Per implementar les accions del menú Opcions podeu usar diferents mètodes de la classe TextArea. Les opcions Font i Tamany són submenús (poseu-hi 3 opcions a cada un).

- Afegir a l'editor una barra d'eines usant l'element ToolBar. Crear tres botons a la barra d'eines: tallar, copiar i enganxar.

- Deshabilitar les opcions copiar i enganxar del menú Editar quan no hi hagi cap text seleccionat. Això ho podrem controlar quan es desplegui el menú per exemple.

- La opció "Sobre l'Editor" del menú Ajuda ha de mostrar un diàleg modal amb informació sobre l'aplicació. Useu la classe Alert per crear-lo.

- Modifiqueu els menú Opcions per a que els items siguin amb checkbox i aparegui marcada la font i tamany actuals. Useu RadioMenuItem.

- Creeu un menú contextual amb les opcions del menú Editar. Useu ContextMenu.


##Ampliació
Afegeix a l'editor de text que hem fet a classe les següents funcionalitats:

    Obrir un fitxer i carregar-ne el seu contingut.
    Guardar el text editat a un fitxer.
    El nom del fitxer que s'està editant ha d'aparèixer al títol de la finestra de l'editor.

Useu la classe FileChooser per a crear els diàlegs dels fitxers.

Per accedir, llegir i escriure als fitxers recordeu les classes treballades a 1er (File, FileReader, FileWriter).
