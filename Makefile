# Makefile untuk Team Assignment 1 - Sistem Perpustakaan
# Java Library Management System

# Variabel
JAVA_SRC_DIR = src
JAVA_BUILD_DIR = build
MAIN_CLASS = Perpustakaan
JAVA_FILES = $(wildcard $(JAVA_SRC_DIR)/*.java)
CLASS_FILES = $(JAVA_FILES:$(JAVA_SRC_DIR)/%.java=$(JAVA_BUILD_DIR)/%.class)

# Target default
all: compile

# Membuat direktori build
$(JAVA_BUILD_DIR):
	mkdir -p $(JAVA_BUILD_DIR)

# Kompilasi semua file Java
compile: $(JAVA_BUILD_DIR) $(CLASS_FILES)
	@echo "Kompilasi selesai!"

# Kompilasi file Java individual
$(JAVA_BUILD_DIR)/%.class: $(JAVA_SRC_DIR)/%.java
	javac -d $(JAVA_BUILD_DIR) -cp $(JAVA_SRC_DIR) $<

# Menjalankan program
run: compile
	@echo "Menjalankan Sistem Perpustakaan..."
	java -cp $(JAVA_BUILD_DIR) $(MAIN_CLASS)

# Membersihkan file build
clean:
	rm -rf $(JAVA_BUILD_DIR)
	rm -f $(JAVA_SRC_DIR)/*.class
	@echo "File build telah dibersihkan!"

# Kompilasi dan langsung jalankan
start: clean compile run

# Menampilkan bantuan
help:
	@echo "Makefile untuk Sistem Perpustakaan"
	@echo ""
	@echo "Target yang tersedia:"
	@echo "  all      - Kompilasi semua file Java (default)"
	@echo "  compile  - Kompilasi semua file Java"
	@echo "  run      - Menjalankan program"
	@echo "  start    - Bersihkan, kompilasi, dan jalankan program"
	@echo "  clean    - Hapus file build"
	@echo "  help     - Tampilkan bantuan ini"

# Target yang tidak menghasilkan file
.PHONY: all compile run clean start help 