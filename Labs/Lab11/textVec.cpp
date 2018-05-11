//
//  textVec.cpp
//  myCProgram
//
//  Created by 任雨涛 on 11/8/17.
//  Copyright © 2017 Yutao Ren. All rights reserved.
//

#include "textVec.hpp"
#include <iostream>
#include <vector>
using namespace std;

vector<int> readVals()
{
    vector<int> v;
    int value;
    while(cin >> value)
    {
        v.push_back(value);
    }
    return v;
}

void printVals(vector<int> v)
{
    for(int i = 0; i < v.size(); i++)
    {
        cout << v[i];
        if(i != v.size() - 1)
        {
           cout << " ";
        }
    }
    cout << endl;
}

vector<int> valsGT0(vector<int> v)
{
    vector<int> v2;
    for(int i = 0; i < v.size(); i++)
    {
        if(v[i] > 0)
        {
            v2.push_back(v[i]);
        }
    }
    return v2;
}

int findLast(vector<int> v, int target)
{
    int temp = INT_MIN;
    int last = INT_MIN;
    for(int i = 0; i < v.size(); i++)
    {
        if(target == v[i])
        {
            temp = i;
        }
        if(temp > last)
        {
            last = temp;
        }
    }
    if(temp == INT_MIN)
    {
        return -1;
    }
    else
    {
        return last;
    }
}

void testFindLast(vector<int> v, int target)
{
    cout << "finds the last instance of " << target << ": " << findLast(v, target) << endl;
}

int main()
{
    vector<int> v = readVals();
    cout << "Vector: ";
    printVals(v);
    vector<int> v2 = valsGT0(v);
    cout << "Filtered Vector: ";
    printVals(v2);
    cout << "Original vector:";
    printVals(v);
    testFindLast(v, 4);
    testFindLast(v2, 0);

}

