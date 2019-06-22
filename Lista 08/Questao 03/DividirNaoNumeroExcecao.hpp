#include <stdexcept>

using namespace std;

class CounterClassException : public runtime_error
{
    public:
        CounterClassException() : runtime_error("Parametros invalidos") { }
};

