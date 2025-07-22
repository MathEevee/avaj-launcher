SRC_DIR := ./src/main/java
OUT_DIR := out

# Fichiers source Java (explicitement listés)
SOURCES := \
	$(SRC_DIR)/fr/mathilde/Aircraft/Aircraft.java \
	$(SRC_DIR)/fr/mathilde/Aircraft/AircraftFactory.java \
	$(SRC_DIR)/fr/mathilde/Aircraft/Balloon.java \
	$(SRC_DIR)/fr/mathilde/Aircraft/Coordinates.java \
	$(SRC_DIR)/fr/mathilde/Aircraft/Flyable.java \
	$(SRC_DIR)/fr/mathilde/Aircraft/Helicopter.java \
	$(SRC_DIR)/fr/mathilde/Aircraft/JetPlane.java \
	$(SRC_DIR)/fr/mathilde/Exception/InvalidAircraft.java \
	$(SRC_DIR)/fr/mathilde/Exception/InvalidLessHeight.java \
	$(SRC_DIR)/fr/mathilde/Exception/InvalidValue.java \
	$(SRC_DIR)/fr/mathilde/Main.java \
	$(SRC_DIR)/fr/mathilde/Tower/Tower.java \
	$(SRC_DIR)/fr/mathilde/Tower/WeatherProvider.java \
	$(SRC_DIR)/fr/mathilde/Tower/WeatherTower.java

# Classe principale à exécuter
MAIN_CLASS := fr.mathilde.Main

# Argument du programme
SCENARIO := scenario.txt

all:
	mkdir -p $(OUT_DIR)
	javac -d $(OUT_DIR) $(SOURCES)

run: all
	java -cp $(OUT_DIR) $(MAIN_CLASS) $(SCENARIO)

clean:
	rm -rf $(OUT_DIR)

fclean: clean
	rm -f simulation.txt

.PHONY: all, clean, fclean