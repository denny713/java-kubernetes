#!/bin/bash

kubectl apply -f namespace.yaml
kubectl apply -f postgresql.yaml
kubectl apply -f kafka.yaml
kubectl apply -f producers.yaml
kubectl apply -f consumers.yaml