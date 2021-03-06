package classes

/**
 * User: jorgefrancoleza
 * Date: 13/07/14
 */

class WithStaticMethods {
    static list = ['me', 'groovy']
    static closures = ['one': {
        go 'goOne'
    }]

    static sayHello() {
        def result = []
        list.each {
            result << clone(it)
        }
    }

    static clone(item) {
        item
    }
}

def list = []
WithStaticMethods.sayHello().each {
    list << it.toUpperCase()
}

assert list == ['ME', 'GROOVY']

class Go {
    def go(value) {
        value
    }

    def processClosure(cl) {
        cl.delegate = this
        cl()
    }
}

assert new Go().processClosure(WithStaticMethods.closures['one']) == 'goOne'

class MyGo {

    def map = [a: 3]
    def two() {
        2
    }

    static start() {
        MyGo map = new MyGo()
        [launch: { ->
            map.map.a * map.two()
        }]
    }
}

assert MyGo.start().launch() == 6