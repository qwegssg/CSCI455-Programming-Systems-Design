// Name: Yutao Ren
// USC NetID: yutaoren
// CSCI 455 PA5
// Fall 2017


//*************************************************************************
// Node class definition 
// and declarations for functions on ListType

// Note: we don't need Node in Table.h
// because it's used by the Table class; not by any Table client code.


#ifndef LIST_FUNCS_H
#define LIST_FUNCS_H
  
using namespace std;

struct Node {
  string key;
  int value;

  Node *next;

  Node(const string &theKey, int theValue);

  Node(const string &theKey, int theValue, Node *n);
};


typedef Node * ListType;

//*************************************************************************
//add function headers (aka, function prototypes) for your functions
//that operate on a list here (i.e., each includes a parameter of type
//ListType or ListType&).  No function definitions go in this file.


//remove the target entry from the list
//return true iff the entry was removed successfully
bool listRemove(ListType & list, string target);

//insert the entry to the front of the list
//PRE: list is a well-formed list
void insertFront(ListType & List, const string & theKey, int theValue);

//print out all the entries in the list
void listPrint(ListType & List);

//look up the list and find the key
//return the address of the value or NULL if key is not present
int * listLookup(ListType & List, const string & theKey);

//return the number of entries in the list
int listCount(ListType & list);


// keep the following line at the end of the file
#endif
