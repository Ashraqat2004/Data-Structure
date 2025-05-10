package com.mycompany.dstracture_project;

import java.util.Iterator;

public interface ContainerOps {

    void Addlate(int element);//T

    public boolean isEmpty();//

    public void pointsContainer(int cap);//F

    public void deleteData(int data); //T

    Iterator iterator();

    void insert(int element, int index);//T

    int lastData();//

    public void Frontdisplay();

    void deleteAt(int index);//T

    int indexOf(int data);//T

    int get(int index);//T

    int size();//

    void sort();//T

    boolean search(int element);//T

    void growCapacity(int newCapacity);//F

    int lastIndexOf(int data);//T

    void DisPlayInfo();
}
