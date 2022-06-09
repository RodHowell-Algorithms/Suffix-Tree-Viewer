# Suffix Tree Viewer

**Suffix Tree Viewer** is an application for displaying suffix trees. It uses the package [**edu.ksu.cis.viewer**](https://github.com/RodHowell-Algorithms/Tree-Viewer).

## Installation

To install the application, simply download the JAR archive [`suffixTree.jar`](https://github.com/RodHowell-Algorithms/Suffix-Tree-Viewer/raw/main/suffixTree.jar). The [Java<sup>TM</sup> SE Runtime Environment (JRE)](https://java.com) is required to run the heap viewer.

## Usage

The program may be started by either opening `suffixTree.jar` or executing the following from a command line in a folder containing this archive:

<pre>
java -jar suffixTree.jar
</pre>



From the main window, enter a string. The suffix tree for that string will then be displayed.

## Compiling the Code

If you wish to modify the code, you will need to download a copy, either by cloning it with `git` or by downloading and decompressing a [ZIP archive](https://github.com/RodHowell-Algorithms/Suffix-Tree-Viewer/archive/refs/heads/main.zip). To compile the code, assuming you have the [Java Development Kit (JDK)](https://www.java.com/en/download/manual.jsp) installed, enter the following from a command line within the root folder of the project (i.e., the one containing the subfolder `edu`):

<pre>
javac -classpath one-jar/lib/viewer.jar edu/ksu/cis/suffixTree/*.java
</pre>

(Depending on your shell, you may need to replace each `/` with `\`.) To run the program after compiling it:

<pre>
java -cp .;one-jar/lib/viewer.jar edu.ksu.cis.suffixTree.Driver
</pre>

(Depending on your shell, you may need to escape the `;` or replace it with `:`, and/or you may need to replace each `/` with `\`.)

## Creating the JAR Archive

To create a JAR archive, you will first need to create an archive containing just the package **edu.ksu.cis.suffixTree**. Because the command is rather long, the files `options.txt` and `Manifest.txt` have been provided to shorten it:

<pre>
jar -c -f suffixTree-only.jar @options.txt edu/ksu/cis/suffixTree/*.class
</pre>

This creates the Jar archive `suffixTree-only.jar`. It can be run by opening it, but only if the file `viewer.jar` (found in the folder `one-jar/lib`) is in the same folder. These can be packaged together using [One-Jar<sup>TM</sup>](http://one-jar.sourceforge.net/index.php?page=getting-started&file=quickstart). First, move `suffixTree-only.jar` to the folder `one-jar/main`. Then from the `one-jar` folder:

<pre>
jar -c -f ../suffixTree.jar -m boot-manifest.mf .
</pre>

This will create the standalone JAR archive `suffixTree.jar`.