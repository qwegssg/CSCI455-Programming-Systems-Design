// Name: Yutao Ren
// USC NetID: yutaoren
// CSCI 455 PA5
// Fall 2017

// Table.cpp  Table class implementation


/*
 * Modified 11/22/11 by CMB
 *   changed name of constructor formal parameter to match .h file
 */

#include "Table.h"

#include <iostream>
#include <string>
#include <cassert>


// listFuncs.h has the definition of Node and its methods.  -- when
// you complete it it will also have the function prototypes for your
// list functions.  With this #include, you can use Node type (and
// Node*, and ListType), and call those list functions from inside
// your Table methods, below.

#include "listFuncs.h"


//*************************************************************************


Table::Table() {

    hashSize = HASH_SIZE;
    table = new ListType[hashSize];

    //initialize the dynamic array
    for(int i = 0; i < hashSize; i++) {
        table[i] = NULL;
    }

}


Table::Table(unsigned int hSize) {

    hashSize = hSize;
    table = new ListType[hashSize];

    //initialize the dynamic array
    for(int i = 0; i < hashSize; i++) {
        table[i] = NULL;
    }

}


//look up the entry of the table
//return the address of the entry
int * Table::lookup(const string &key) {

    int * theKey = NULL;

    //check all the lists in the hash table
    for(int i = 0; i < hashSize; i++) {
        theKey = listLookup(table[i], key);
        if(theKey != NULL) {
            return theKey;
        }
    }

    return theKey;  

}


//remove one entry from the table
//return true if the entry was removed successfully
bool Table::remove(const string &key) {

    //check all the lists in the hash table
    for(int i = 0; i < hashSize; i++) {
        if(listRemove(table[i], key)) {
            return true;
        }
    }

    return false;

}


//insert an entry of the table iff the key is not present
//return true iff insertion is successful
bool Table::insert(const string &key, int value) {

    //if the key is not present in the table, then add the entry
    if(lookup(key) == NULL) {
        int index = hashCode(key);
        insertFront(table[index], key, value);
        return true;
    }

    return false; 

}


//count the number of entries of the table
//return the number of entries
int Table::numEntries() const { 

    int count = 0;

    //check all the lists in the hash table
    for(int i = 0; i < hashSize; i++) {
        count += listCount(table[i]);
    }

    return count;     

}


//print all the entries of the table
void Table::printAll() const {

    //check all the lists in the hash table
    for(int i = 0; i < hashSize; i++) {
        listPrint(table[i]);
    }
}


//show the current hash state of the table
void Table::hashStats(ostream &out) const {

    cout << "number of buckets: " << hashSize << endl;
    cout << "number of entries: " << numEntries() << endl;
    cout << "number of non-empty buckets: " << numNonEmptyBuckets() << endl;
    cout << "longest chain: " << getLongestChain() << endl;
    
}


// add definitions for your private methods here


//count the number of non-empty buckets in the table
//return the number of non-empty buckets
int Table::numNonEmptyBuckets() const {

    int count = 0;

    for(int i = 0; i < hashSize; i++) {
        if(table[i] != NULL) {
            count++;
        }
    }

    return count;

}


//get the longest chain from the table
//return the longest chain
int Table::getLongestChain() const {

    int longestChain = 0;

    for(int i = 0; i < hashSize; i++) {
        int chain  = listCount(table[i]);
        longestChain = chain > longestChain ? chain : longestChain;
    }

    return longestChain;

}
