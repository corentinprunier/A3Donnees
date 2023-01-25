CC=gcc
MKDIR=mkdir -p
CFLAGS=-Wall -std=c90 -pedantic -g
LDFLAGS=-lm
OBJ_DIR=.obj
SRC_DIR=src
BIN_DIR=bin
SRC= $(wildcard $(SRC_DIR)/*.c)
OBJ=$(patsubst $(SRC_DIR)/%.c,$(OBJ_DIR)/%.o,$(SRC))
EXEC=$(patsubst $(SRC_DIR)/%.c,%,$(SRC))
OUT_DIRS = $(OBJ_DIR) $(BIN_DIR)

.SECONDARY:

.PHONY: all

all: $(EXEC)

$(EXEC): %: $(BIN_DIR)/%

$(BIN_DIR)/%: $(OBJ_DIR)/%.o $(BIN_DIR)
	@echo "[Link]"
	$(CC) -o $@ $< $(LDFLAGS)

$(OBJ_DIR)/%.o: $(SRC_DIR)/%.c $(OBJ_DIR)
	@echo "[Compile & Build]"
	$(CC) $(CFLAGS) -o $@ -c $<

$(OUT_DIRS):
	@echo "[Setup]"
	$(MKDIR) $@

clean:
	@echo "[Suppr. Obj files]"
	rm -rf $(OBJ_DIR)/*.o

mrproper : clean
	@echo "[Suppr. Exec files]"
	rm -rf $(OUT_DIRS)
