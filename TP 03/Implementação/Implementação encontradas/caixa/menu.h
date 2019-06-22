#ifndef CONTA_MENU_H
#define CONTA__MENU_H

#include <string>
#include <vector>
#include <utility> // pair
#include <functional>

using namespace std;

void menu(string titulo, vector<pair<string,function<void()>>> itens);

#endif
