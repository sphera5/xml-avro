# xml-avro
This project provides Converter to convert generic xsd/xml to asvc/avro files.
Avro schema and avro file are generated from xsd schema and xml file.

Additionally it includes simple schemaless converter that converts xml to avro and avro to xml.

### Cambios en la version 0.0.2-SNAPSHOT
- Se convierte de maven a gradle
- Se retira compatibilidad con java 1.7
- Se refactoriza el proyecto para definir los sourceSets ["src/main/java","src/main/resources","src/test/java","src/test/resources"]
- Se incorporan comentarios de clase
- Se incorporan javadocs de metodos
- Se incorpora el bloque finally en el metodo avroToXml de la clase ly.stealth.xmlavro.simple.Converter para realizar el close del DataFileReader
- Se corrigen @SuppressWarnings en los metodos de la clase DatumBuilder
- Se corrige el switch en el metodo setFieldFromNode de la clase DatumBuilder
- Se actualiza Apache Avro a la version 1.7.7
- Se actualiza SLF4J a la version 1.7.7

## Running Project
1. git clone;
2. mvn package;
3. java -jar target/xml-avro*.jar <xsdFile> <xmlFile> {<avscFile>} {<avroFile>} // converts specified xml+xsd to avro+asvc files
4. java -cp target/xml-avro*.jar ly.stealth.xmlavro.simple.Converter avro <xmlFile> <avroFile> // convert xml to avro
5. java -cp target/xml-avro*.jar ly.stealth.xmlavro.simple.Converter xml <avroFile> <xmlFile> // convert avro to xml

## Schema-based converter
Usage:
```
XML Avro converter.
Usage: "{-d|--debug} {-b|--baseDir <baseDir>} <xsdFile> <xmlFile> {<avscFile>} {<avroFile>}"
```
## Restrictions
Schema-based converter currently only supports conversion in one direction: from xml to avro.

Converter has following restriction:
- xml docs with multiple namespaces are not supported;
- complex type extensions are not supported;

## Simple converter
Usage:
```
{avro|xml} <inFile> <outFile>
```
Note: simple converter uses predefined general avro schema located at src/ly/stealth/xmlavro/simple/xml.avsc