package org.grooscript

import spock.lang.Specification
import org.grooscript.test.TestJs
import spock.lang.Unroll

/**
 * First test for converts groovy code to javascript code
 * Following GroovyInAction Book
 * Chap 2. Groovy basics
 * JFL 27/08/12
 */
class TestContributors extends Specification {

    def converter = new GsConverter()

    def readAndConvert(nameOfFile,consoleOutput) {

        def file = TestJs.getGroovyTestScript(nameOfFile)

        def jsScript = converter.toJs(file.text)

        if (consoleOutput) {
            println 'jsScript->\n'+jsScript
        }

        return TestJs.jsEval(jsScript)
    }


    def 'test jochen' () {
        when:
        def result = readAndConvert('contribution/JochenTheodorou',false)

        then:
        !result.assertFails
    }

    @Unroll('Testing MrHaki #file')
    def 'test MrHaki' () {
        expect:
        def result = readAndConvert(file,false)//file=='contribution/MrHakiGetSetProperties')
        //println 'Console->'+result.gSconsole
        !result.assertFails

        where:
        file                                    |_
        'contribution/MrHakiClosureReturn'      |_
        'contribution/MrHakiFirstLast'          |_
        'contribution/MrHakiSum'                |_
        'contribution/MrHakiLooping'            |_
        'contribution/MrHakiInject'             |_
        'contribution/MrHakiGrep'               |_
        'contribution/MrHakiGetSetProperties'   |_

    }

    def 'test alex anderson' () {
        when:
        def result = readAndConvert('contribution/AlexAnderson',false)

        then:
        //println 'Console->'+result.gSconsole
        !result.assertFails

    }

    def 'test mario garcia' () {
        when:
        def result = readAndConvert('contribution/MarioGarcia',false)

        then:
        //println 'Console->'+result.gSconsole
        !result.assertFails

    }

    @Unroll('Testing anonymous web #file')
    def 'test anonymous contributions in web' () {
        expect:
        def result = readAndConvert(file,false)
        !result.assertFails
        result.gSconsole.contains(text)
        //println result.gSconsole

        where:
        file                       | text
        'contribution/Anonymous0'  | 'FizzBuzz\n91'
        'contribution/Anonymous1'  | 'fizzbuzz\n91'
        'contribution/Anonymous2'  | 'fizZbuzZ\n16'

    }

}
