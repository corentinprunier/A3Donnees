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

all: $(BIN_DIR) $(EXEC)

$(EXEC): %: $(BIN_DIR)/%

$(BIN_DIR)/%: $(LIB_DIR)/*.o $(OBJ_DIR)/%.o
	@echo "[Link]"
	$(CC) -o $@ $^ $(LDFLAGS)

$(LIB_DIR)/%.o:
	@echo "[Build libs]"
	$(MAKE) -C src/libcomplexe all

$(OBJ_DIR)/%.o: $(SRC_DIR)/%.c $(OBJ_DIR)
	@echo "[Compile & Build]"
	$(CC) $(CFLAGS) -o $@ -c $< $(IFLAG)

$(OUT_DIRS):
	@echo "[Setup]"
	$(MKDIR) $@

clean:
	rm -rf $(OBJ_DIR)/*.o

mrproper : clean
	@echo "[Mrproper]"
	rm -rf $(OUT_DIRS)
	$(MAKE) -C src/libcomplexe mrproper
