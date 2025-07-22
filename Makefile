SRC_DIR := src
OUT_DIR := out

SOURCES := $(shell find $(SRC_DIR) -name "*.java")

MAIN_CLASS := fr.mathilde.Main

SCENARIO := scenario.txt

.PHONY: all run clean

all:
	mkdir -p $(OUT_DIR)
	javac -d $(OUT_DIR) $(SOURCES)

run: all
	java -cp $(OUT_DIR) $(MAIN_CLASS) $(SCENARIO)

clean:
	rm -rf $(OUT_DIR)