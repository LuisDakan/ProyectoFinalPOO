# -*- coding: utf-8 -*-
import random

l=["Aventuras","Ciencia Ficcion","Policiaca","Terror","Romantica","Humor","Poesia","Mitologia","Teatro","Cuento"]

copy=[]
with open("Biblioteca.csv","r",encoding="utf-8") as file:
    for read in file:
        copy.append(read)

with open("Biblioteca.csv","w",encoding="utf-8")as file:
    for read in copy:
        read=read.replace("\n","")
        file.write(read+","+l[random.randint(0,len(l)-1)]+","+str(random.randint(1,5))+","+str(random.randint(1000000,9999999))+"\n")

