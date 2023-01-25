CC=gcc
MKDIR=mkdir -p
CFLAGS=-Wall -std=c90 -pedantic -g
LDFLAGS=-lm
OBJ_DIR=.obj
SRC_DIR=src
BIN_DIR=bin
HEADER_DIR=include
LIB_DIR=lib
IFLAG=-I $(HEADER_DIR)
SRC=$(wildcard $(SRC_DIR)/*.c)
OBJ=$(patsubst $(SRC_DIR)/%.c,$(OBJ_DIR)/%.o,$(SRC))
EXEC=$(patsubst $(SRC_DIR)/%.c,%,$(SRC))
OUT_DIRS = $(OBJ_DIR) $(BIN_DIR) $(HEADER_DIR) $(LIB_DIR)

.SECONDARY:

.PHONY: all

all: $(EXEC)

$(EXEC): %: $(BIN_DIR) $(BIN_DIR)/%

$(BIN_DIR)/test_deque: $(LIB_DIR)/libdeque.o $(OBJ_DIR)/test_deque.o
	@echo "[Link]"
	$(CC) -o $@ $^ $(LDFLAGS)

$(BIN_DIR)/test_pile: $(LIB_DIR)/libpile.o $(LIB_DIR)/libdeque.o $(OBJ_DIR)/test_pile.o
	@echo "[Link]"
	$(CC) -o $@ $^ $(LDFLAGS)

$(BIN_DIR)/test_file: $(LIB_DIR)/libfile.o $(LIB_DIR)/libdeque.o $(OBJ_DIR)/test_file.o
	@echo "[Link]"
	$(CC) -o $@ $^ $(LDFLAGS)

$(BIN_DIR)/test_liste: $(LIB_DIR)/libliste.o $(OBJ_DIR)/test_liste.o
	@echo "[Link]"
	$(CC) -o $@ $^ $(LDFLAGS)

$(LIB_DIR)/%.o:
	@echo "[Build libs]"
	$(MAKE) -C src/$(subst .o,,$(subst $(LIB_DIR)/,,$@)) all

$(OBJ_DIR)/%.o: $(SRC_DIR)/%.c $(OBJ_DIR)
	@echo "[Compile & Build]"
	$(CC) $(CFLAGS) -o $@ -c $< $(IFLAG)

$(OUT_DIRS):
	@echo "[Setup]"
	$(MKDIR) $@

clean:
	rm -rf $(OBJ_DIR)/*.o
	$(MAKE) -C src/libdeque clean
	$(MAKE) -C src/libpile clean
	$(MAKE) -C src/libfile clean
	$(MAKE) -C src/libliste clean

mrproper : clean
	@echo "[Mrproper]"
	rm -rf $(OUT_DIRS)
