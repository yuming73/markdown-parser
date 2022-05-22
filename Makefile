CLASSPATH = lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar:lib/commonmark-0.18.1.jar:.

testSnippets.class: testSnippets.java MarkdownParse.class
	javac -g -cp $(CLASSPATH) testSnippets.java

MarkdownParse.class: MarkdownParse.java
	javac -g -cp $(CLASSPATH) MarkdownParse.java

test: testSnippets.class
	java -cp $(CLASSPATH) org.junit.runner.JUnitCore testSnippets