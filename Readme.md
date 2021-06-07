# Lista de cosas por hacer

1. Que se refresque la cuadricula de sistemas solares (SS) 
1. Crear las tablas de los cuerpos celestes (CC)
1. Crear eventos para los botones de las flechas
1. Establecer conexión y métodos pertinentes

1. Refactorizar para que las coordenadas solo se creen una vez
1. existen clases contendoras para variables o constantes como las rutas de las imágenes?
1. 



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

