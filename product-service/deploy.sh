#!/bin/bash

gradle clean build
scp -O -r build/libs/product-service-1.0.0.jar kaplan:/home/newton/soa/product/
ssh kaplan 'cd /home/newton/soa/product; sh ~/soa/product/deploy.sh'