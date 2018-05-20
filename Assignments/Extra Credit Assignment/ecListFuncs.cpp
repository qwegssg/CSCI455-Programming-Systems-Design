/*  Name: Yutao Ren
 *  USC NetID: yutaoren
 *  CS 455 Fall 2017
 *
 *  See ecListFuncs.h for specification of each function.
 */

#include <iostream>

#include <cassert>

#include "ecListFuncs.h"

using namespace std;


int numRuns(ListType list) {

    if (list == NULL) {
        return 0;
    }

    //Use two Node pointers to compare the Node data.
    ListType currP = list;
    ListType prevP = list;

    int count = 0;
    bool findRuns = false;

    while (currP->next != NULL) {

        prevP = currP;
        currP = currP->next;

        if (prevP->data == currP->data) {

            //if the current run is not counted, then count the current run.
            if (findRuns == false) {

                count++;
                findRuns = true;

            }

        }
        else {
            findRuns = false;
        }


    }

    return count; 
}



ListType reverseCopy(ListType list) {


    ListType p = list;

    if (p == NULL) {
        return NULL;
    }

    ListType reverseList = new Node(p->data, NULL);
    
    while (p->next != NULL) {

        p = p->next;
        //point the new Node to the front of the list, then point the list pointer to that node.
        reverseList = new Node(p->data, reverseList);

    }

    return reverseList;

}



void removeMiddleElmt(ListType &list) {

    if (list == NULL) {
        return;
    }

    //if there is only one element in the list.
    if (list->next == NULL) {
        delete list;
        list = NULL;
        return;
    }

    //if there are only two elements in the list.
    if(list->next->next == NULL) {

        ListType p = list;
        list = list->next;
        delete p;
        return;

    }

    //use two pointers, one slow pointer and one fast pointer to traversal the list.
    ListType fastP = list;
    ListType slowP = list;

    //point to the element that needs to be removed.
    ListType del =  NULL;

    while (fastP->next->next != NULL) {

        fastP = fastP->next->next;

        if (fastP->next == NULL || fastP->next->next == NULL) {

            del = slowP->next;
            slowP->next = slowP->next->next;
            delete del;
            return;

        }

        slowP = slowP->next;

    }

}



void splitOn(ListType &list, int splitVal, ListType &a, ListType &b) {

    if(list == NULL) {
        return;
    }

    ListType currP = list;
    ListType del = NULL;

    //if the first element is splitVal, put the rest of elements into b.
    if(currP->data == splitVal) {

        del = currP;
        currP = currP->next;
        b = currP;
        delete del;

    }
    else {

        a = currP;

        while (currP->next != NULL) {

            //if the splitVal is found.
            if(currP->next->data == splitVal) {

                //if the last element is the splitVal.
                if(currP->next->next == NULL) {

                    del = currP->next;
                    currP->next = NULL;
                    delete del;
                    list = NULL;
                    return;

                }
                else {

                    del = currP->next;
                    b = currP->next->next;
                    currP->next = NULL;
                    delete del;
                    list = NULL;
                    return;

                }

            }

            currP = currP->next;

        }

    }

    list = NULL;


}
