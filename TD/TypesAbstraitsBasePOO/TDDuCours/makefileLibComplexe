CC=gcc
MKDIR=mkdir -p
COPY=cp
CFLAGS=-Wall -std=c90 -pedantic -g
LDFLAGS=-lm
OBJ_DIR=../../lib
HEADER_DIR=../../include
SRC_DIR=.
HEADER= $(wildcard $(SRC_DIR)/*.h)
SRC= $(wildcard $(SRC_DIR)/*.c)
OBJ=$(patsubst $(SRC_DIR)/%.c,$(OBJ_DIR)/%.o,$(SRC))
OUT_DIRS = $(OBJ_DIR) $(HEADER_DIR)

.PHONY: all

all: $(OBJ)

$(OBJ_DIR)/%.o: $(SRC_DIR)/%.c $(OUT_DIRS)
	@echo "[Compile & Build]"
	$(CC) $(CFLAGS) -o $@ -c $<
	$(COPY) $(HEADER) $(HEADER_DIR)/.

$(OUT_DIRS):
	@echo "[Setup]"
	$(MKDIR) $@

clean:
	rm -rf $(OBJ_DIR)/*.*

mrproper : clean
	@echo "[Mrproper]"
	rm -rf $(OUT_DIRS)
