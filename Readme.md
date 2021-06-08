# Lista de cosas por hacer

1. Que se refresque la cuadricula de sistemas solares (SS) 
1. Crear las tablas de los cuerpos celestes (CC)
1. Establecer conexión y métodos pertinentes
1. Refactorizar para que las coordenadas solo se creen una vez
1. Añadir listener para botones



# Crear projecto con MAVEN

```
sudo apt install maven
```

```
mvn archetype:generate      \
    -DinteractiveMode=false \
    -DgroupId=org.andfres   \
    -DartifactId=planetas
```

```
mvn package
```

```
java -cp target/planetas-1.0-SNAPSHOT.jar org.andfres.App
```


```
mvn package && java -jar target/planetas-1.0-SNAPSHOT.jar
```


```
sqlitebrowser
```





```java


SistemaSolar {


    Planeta/CuerpoCeleste planetas[];



}

Galaxia/Universo {

    int x, y;

    SistemaSolar sistemaActual(){

        // Cargas de BD

    }

    irA(x, y){
        this.x = x; this.y = y;
    }


}

// En el main o algo global
galaxia = new GAlaxia();


// En el listener del boton
ss = galaxia.actual();
ss[0].veces_visitos++;
ss[0].save();
galaxia.irA(x+1, y);
refrescar();


// Método del panel
refrescar() {



    SistemaSolar ss = galaxia.actual();

    for( cuerpo: ss.cuerpos ){
        New JFrames/labels
    }
}










```