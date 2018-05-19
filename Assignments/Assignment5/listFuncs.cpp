// Name: Yutao Ren
// USC NetID: yutaoren
// CSCI 455 PA5
// Fall 2017


#include <iostream>

#include <cassert>

#include "listFuncs.h"

using namespace std;

Node::Node(const string &theKey, int theValue) {
  key = theKey;
  value = theValue;
  next = NULL;
}

Node::Node(const string &theKey, int theValue, Node *n) {
  key = theKey;
  value = theValue;
  next = n;
}




//*************************************************************************
// put the function definitions for your list functions below


//remove the target entry from the list
//return true iff the entry was removed successfully
bool listRemove(ListType & list, string target) {

    if(list == NULL) {
        return false;
    }

    ListType p = list;

    //if the target is the first one of the list
    if(target == p->key) {
         list = p->next;
         delete p;
         return true;
    }

    //if the target is after the first one of the list
    while(p->next != NULL) {
        if(target == p->next->key) {
            ListType temp = p->next;
            p->next = p->next->next;
            delete temp;
            return true;
        }
        p = p->next;
    }

    return false;

}


//insert the entry to the front of the list
//PRE: list is a well-formed list
void insertFront(ListType & list, const string & theKey, int theValue) {

        list = new Node(theKey, theValue, list);

}


//print out all the entries in the list
void listPrint(ListType & list) {
    
    if(list == NULL) {
        return;
    }

    ListType p = list;

    while(p != NULL) {
        cout << p->key << " " << p->value <<endl;
        p = p->next;
    }

}


//look up the list and find the key
//return the address of the value or NULL if key is not present
int * listLookup(ListType & list, const string & theKey) {

    ListType p = list;

    while(p != NULL) {
        if(p->key == theKey) {
            return & p->value;
        }
        p = p->next;
    }

    return NULL;
}


//return the number of entries in the list
int listCount(ListType & list) {

    ListType p = list;

    int count = 0;

    while(p != NULL) {
        count++;
        p = p->next;
    }

    return count;

}
