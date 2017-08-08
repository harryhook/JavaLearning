package com.algorithm.sort;

public class MergeSort {

    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
	aux = new Comparable[a.length];
	sort_1(a, 0, a.length - 1);
    }

    private static void sort_1(Comparable[] a, int lo, int hi) {
	if (hi <= lo)
	    return;
	int mid = lo + (hi - lo) / 2;
	sort_1(a, lo, mid);
	sort_1(a, mid + 1, hi);
	merge_2(a, lo, mid, hi);
    }

    private static void sort_2(Comparable[] a) {
	int N = a.length;
	aux = new Comparable[N];
	for (int sz = 1; sz < N; sz += sz) {
	    for (int lo = 0; lo < N - sz; lo += sz + sz) {
		merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
	    }
	}
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
	int i = lo, j = mid + 1;
	for (int k = lo; k <= hi; k++) {
	    aux[k] = a[k];
	}
	for (int k = lo; k <= hi; k++) {
	    if (i > mid)
		a[k] = aux[j++];
	    else if (j > hi)
		a[k] = aux[i++];
	    else if (less(aux[j], aux[i]))
		a[k] = aux[j++];
	    else
		a[k] = aux[i++];
	}
    }
    public static void merge_2(Comparable[] a, int lo, int mid, int hi) {
	int i= lo;
	int j = mid+1;
	int k=0; 
	while(i<=mid && j <= hi) {
	    if(less(a[i], a[j])){
		aux[k++] = a[i++];
	    } else {
		aux[k++] = a[j++];
	    }
	}
	while(i<=mid) {
	    aux[k++] = a[i++];
	}
	while(j<=hi) {
	    aux[j++] = a[j++];
	}
	for(i=0; i<k; i++) {
	    a[lo+i] = aux[i];
	}
    }

    public static boolean less(Comparable v, Comparable w) {
	return v.compareTo(w) < 0;
    }

    public static void exch(Comparable[] a, int i, int j) {
	Comparable t = a[i];
	a[i] = a[j];
	a[j] = t;
    }

    public static void show(Comparable[] a) {
	for (int i = 0; i < a.length; i++) {
	    System.out.print(a[i] + " ");
	}
	System.out.println("");
    }

    public static void main(String[] args) {
	Comparable[] a = { 'M', 'E', 'R', 'G', 'E', 'S', 'O', 'R', 'T', 'E', 'X', 'A', 'M', 'P', 'L', 'E' };
	sort(a);
//	sort_2(a);
	show(a);
    }

}