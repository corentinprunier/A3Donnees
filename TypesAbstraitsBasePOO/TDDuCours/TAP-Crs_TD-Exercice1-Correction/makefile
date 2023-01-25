CC=gcc
MKDIR=mkdir -p
CFLAGS=-Wall -std=c90 -pedantic -g
LDFLAGS=-lm
OBJ_DIR=.obj
SRC_DIR=src
EXEC_DIR=bin
SRC= $(wildcard $(SRC_DIR)/*.c)
#OBJ= $(SRC:.c=.o)
OBJ=$(patsubst $(SRC_DIR)/%.c,$(OBJ_DIR)/%.o,$(SRC))
#EXEC= $(SRC:.c=)
EXEC=$(patsubst $(SRC_DIR)/%.c,%,$(SRC))
OUT_DIRS = $(OBJ_DIR) $(EXEC_DIR)

.PHONY: all

all: $(EXEC)

#$(EXEC): %: %.o
$(EXEC): %: $(OBJ_DIR)/%.o $(EXEC_DIR)
	@echo "[Link]"
	$(CC) -o $(EXEC_DIR)/$@ $< $(LDFLAGS)

$(OBJ_DIR)/%.o: $(SRC_DIR)/%.c $(OBJ_DIR)
	@echo "[Compile & Build]"
	$(CC) $(CFLAGS) -o $@ -c $<

$(OUT_DIRS):
	@echo "[Setup]"
	$(MKDIR) $@

clean:
	rm -rf $(OBJ_DIR)/*.o

mrproper : clean
	@echo "[Mrproper]"
	rm -rf $(OUT_DIRS)
