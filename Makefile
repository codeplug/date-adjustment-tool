VERSION=0.0.1
BUILDER=date-adjustment-tool-builder
OUTPUT=date-adjustment-tool-${VERSION}-jar-with-dependencies.jar

build:
	rm -rf output/*
	docker build -t ${BUILDER} . 
	docker create -it --name ${BUILDER} ${BUILDER} bash
	docker cp ${BUILDER}:/usr/src/app/target/${OUTPUT} .
	mv ${OUTPUT} output/date-adjustment-tool.jar
	docker rm -f ${BUILDER}

test:
	docker run -it --rm ${BUILDER} -T 1C -o test

.PHONY: build test 
