#include <stdexcept>

using namespace std;

class DividirZeroExcecao: public runtime_error
 {
    public:
        DividirZeroExcecao() : runtime_error("Dividir por zero") { }
};
