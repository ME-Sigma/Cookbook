Getting Started

With the recent Java 11 release, JavaFX is no longer included in the JDK!
https://stackoverflow.com/questions/52682195/how-to-get-javafx-and-java-11-working-in-intellij-idea#:~:text=Go%20to%20File%20%2D%3E%20Project%20Structure%20%2D%3E%20Libraries%20and%20add,be%20recognized%20by%20the%20IDE.&text=Note%20that%20the%20default%20project,IntelliJ%20uses%20FXML%2C%20so%20javafx.

1. Download JavaFX in the folder ..\Download
https://gluonhq.com/products/javafx/


2. Create a JavaFX project

3. Set JDK 11
Go to File -> Project Structure -> Project, and set the project SDK to 11. You can also set the language level to 11. Set JDK 11.x.x

4. Create a library
Go to File -> Project Structure -> Libraries and add the JavaFX 11 SDK as a library (+ Java --> ..\Download\openjfx-11.0.2_windows-x64_bin-sdk\javafx-sdk-11.0.2\lib) to the project. Point to the lib folder of the JavaFX SDK.

5. Add VM options
--module-path %PATH_TO_FX% --add-modules=javafx.controls,javafx.fxml
where %PATH_TO_FX% is the path where the libraries are downloaded to
here: 
--module-path C:\Users\Benedikt\Documents\Cookbook\JavaFX\openjfx-11.0.2_windows-x64_bin-sdk\javafx-sdk-11.0.2\lib --add-modules=javafx.controls,javafx.fxml

6. Run the Project

