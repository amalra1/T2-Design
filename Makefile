JC = javac
TARGET = Main

all: $(TARGET)
	java Main

$(TARGET): models controllers views
	$(JC) Main.java

models: 
	$(JC) javac models/*.java

controllers:
	$(JC) javac controllers/*.java

views:
	$(JC) javac views/*.java

clean: 
	rm */*.class