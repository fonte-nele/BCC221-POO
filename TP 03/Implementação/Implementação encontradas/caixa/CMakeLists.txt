cmake_minimum_required(VERSION 3.1)
project(caixa)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp)
add_executable(caixa ${SOURCE_FILES} cliente.cpp cliente.h util.h util.cpp conta.cpp conta.h banco.cpp banco.h menu.h menu.cpp)