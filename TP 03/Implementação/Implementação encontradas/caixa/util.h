#ifndef CAIXA_UTIL_H
#define CAIXA_UTIL_H

#include <string>
#include <iostream>
using namespace std;

string escape(const string& s);

istream& unescape(istream &is, string &str);

istream& word(istream &is, const string &str);


#endif //CAIXA_UTIL_H
