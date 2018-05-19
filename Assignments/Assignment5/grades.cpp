// Name: Yutao Ren
// USC NetID: yutaoren
// CSCI 455 PA5
// Fall 2017

/*
 * grades.cpp
 * A program to test the Table class.
 * How to run it:
 *      grades [hashSize]
 * 
 * the optional argument hashSize is the size of hash table to use.
 * if it's not given, the program uses default size (Table::HASH_SIZE)
 *
 */

#include "Table.h"

// cstdlib needed for call to atoi
#include <cstdlib>


void readInput(Table * grades);
void insert(Table * grades, const string & theKey, int theScore);
void change(Table * grades, const string & theKey, int theScore);
void lookup(Table * grades, const string & theKey);
void remove(Table * grades, const string & theKey);
void help();



int main(int argc, char * argv[]) {

    // gets the hash table size from the command line

    int hashSize = Table::HASH_SIZE;

    Table * grades;  // Table is dynamically allocated below, so we can call
                     // different constructors depending on input from the user.

    if (argc > 1) {
        hashSize = atoi(argv[1]);  // atoi converts c-string to int

        if (hashSize < 1) {
            cout << "Command line argument (hashSize) must be a positive number" 
               << endl;
            return 1;
        }

        grades = new Table(hashSize);

    }
    else {   // no command line args given -- use default table size
        grades = new Table();
    }


    grades->hashStats(cout);

  // add more code here
  // Reminder: use -> when calling Table methods, since grades is type Table*


    readInput(grades);


    return 0;
}


//read the input command from user
void readInput(Table * grades) {

    string command;
    string name;
    int score;

    cout << "cmd> ";
    
    while (cin >> command) {
       
        if(command == "insert") {
            cin >> name >> score;
            insert(grades, name, score);
        }
        else if (command == "change") {
            cin >> name >> score;
            change(grades, name, score);
        }
        else if(command == "lookup") {
            cin >> name;
            lookup(grades, name);
        }
        else if(command == "remove") {
            cin >> name;
            remove(grades, name);
        }
        else if(command == "print") {
            grades->printAll();
        }
        else if(command == "size") {
            cout << grades->numEntries() << endl;
        }
        else if(command == "stats") {
            grades->hashStats(cout);
        }
        else if(command == "help") {
            help();
        }
        else if(command == "quit") {
            return;
        }
        else {
            cout << "ERROR: invalid command" << endl;
            help();
        }
        cout << "cmd> ";
    }

}


//Insert this name and score in the grade table. 
//If this name was already present, print a message to that effect, and don't do the insert. 
void insert(Table * grades, const string & theKey, int theScore) {

    bool insert = grades->insert(theKey, theScore);

    if(!insert) {
        cout << "The name is already in the grade table." << endl;
    }
}


//Change the score for name. 
void change(Table * grades, const string & theKey, int theScore) {

    if(grades->lookup(theKey) == NULL) {
        cout << "The name is not present in the grade table." << endl;
    }
    else {
        int * value = grades->lookup(theKey);
        * value = theScore;
    }

}


//Lookup the name, and print out his or her score
//or a message indicating that student is not in the table. 
void lookup(Table * grades, const string & theKey) {

    if(grades->lookup(theKey) == NULL) {
        cout << "The name is not present in the grade table." << endl;
    }
    else {
        int * value = grades->lookup(theKey);
        cout << * value << endl;
    }

}


//Remove this student. If this student wasn't in the grade table, print a message to that effect.
void remove(Table * grades, const string & theKey) {

    bool remove = grades->remove(theKey);

    if(!remove){
        cout << "The name is not present in the grade table." << endl;
    }

}


//print out a brief command summary
void help() {

    cout << "Command Summary: " << endl;
    cout << "There are nine commands that you can use : insert, change, lookup, remove, print, size, stats, help and quit." << endl;
    cout << "1. insert name score : inserts the pair name and score if they were not already present in the table" << endl;
    cout << "2. change name newscre : changes the score for a name that was already there in the table" << endl;
    cout << "3. lookup name : lookup the name, and print out his or her score." << endl;
    cout << "4. remove name: removes the name and score assciacted with it from the table." << endl;
    cout << "5. print : prints all the values of the table" << endl;
    cout << "6. size : prints the number of entries in the table" << endl;
    cout << "7. stats : prints out the statistics about the table" << endl;
    cout << "8. help : prints out the commands that are acceptable"<< endl;
    cout << "9. quit : exits the program" << endl;

}
