CC=gcc
MKDIR=mkdir -p
COPY=cp
CFLAGS=-Wall -std=c90 -pedantic -g
LDFLAGS=-lm
OBJ_DIR=../../lib
HEADER_DIR=../../include
IFLAGS=-I $(HEADER_DIR)
SRC_DIR=.
HEADER= $(wildcard $(SRC_DIR)/*.h)
SRC= $(wildcard $(SRC_DIR)/*.c)
OBJ=$(patsubst $(SRC_DIR)/%.c,$(OBJ_DIR)/%.o,$(SRC))
OUT_DIRS = $(OBJ_DIR) $(HEADER_DIR)

.PHONY: all

all: $(OBJ)

$(OBJ_DIR)/%.o: $(SRC_DIR)/%.c $(OUT_DIRS)
	@echo "[Compile & Build]"
	$(CC) $(CFLAGS) -o $@ -c $< $(IFLAGS)
	$(COPY) $(HEADER) $(HEADER_DIR)/.

$(OUT_DIRS):
	@echo "[Setup]"
	$(MKDIR) $@

clean:
	rm -rf $(OBJ)
	rm -rf $(HEADER_DIR)/$(HEADER)
