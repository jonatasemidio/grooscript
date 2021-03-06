package org.grooscript.convert

import org.grooscript.test.ConversionMixin
import org.grooscript.test.JsTestResult
import spock.lang.Specification
import spock.lang.Unroll

/**
 * JFL 27/08/12
 */
@Mixin([ConversionMixin])
class TestContributors extends Specification {

    def 'test jochen' () {
        expect:
        convertAndEvaluate('contribution/JochenTheodorou')
    }

    @Unroll('Testing MrHaki #file')
    def 'test MrHaki' () {
        expect:
        convertAndEvaluate(file)

        where:
        file                                    |_
        'contribution/MrHakiClosureReturn'      |_
        'contribution/MrHakiFirstLast'          |_
        'contribution/MrHakiSum'                |_
        'contribution/MrHakiLooping'            |_
        'contribution/MrHakiInject'             |_
        'contribution/MrHakiGrep'               |_
        'contribution/MrHakiGetSetProperties'   |_
        'contribution/MrHakiSpread'             |_
        'contribution/MrHakiCategories'         |_
        'contribution/MrHakiTraits1'            |_
        'contribution/MrHakiTraits2'            |_
    }

    def 'test alex anderson' () {
        expect:
        convertAndEvaluate('contribution/AlexAnderson')
    }

    def 'test mario garcia' () {
        expect:
        convertAndEvaluate('contribution/MarioGarcia')
    }

    @Unroll('Testing anonymous web #file')
    def 'test anonymous contributions in web' () {
        expect:
        JsTestResult result = convertAndEvaluateWithJsEngine(file)
        !result.assertFails
        result.console.contains(text)

        where:
        file                       | text
        'contribution/Anonymous0'  | 'FizzBuzz\n91'
        'contribution/Anonymous1'  | 'fizzbuzz\n91'
        'contribution/Anonymous2'  | 'fizZbuzZ\n16'
    }

    def 'bugs coming from monkfish'() {
        when:
        def result = convertAndEvaluateWithJsEngine('contribution/MonkFish',false,null,
                'gSobject.value = 0;',
                'gSobject.value = 0;gSobject.two = function() {return 2;};')

        then:
        !result.assertFails
    }

    def 'testing more web' () {
        expect:
        convertAndEvaluate('contribution/Anonymous3')
        convertAndEvaluate('contribution/Anonymous4')
        convertAndEvaluate('contribution/Anonymous5')
    }

    def 'testing mario extends'() {
        expect:
        convertAndEvaluate('contribution/MarioGarcia2')
    }

    def 'testing mario maps'() {
        expect:
        convertAndEvaluate('contribution/MarioGarcia3')
    }

    def 'twitter code found scoping closures'() {
        expect:
        convertAndEvaluate('contribution/Twitter1')
    }

    @Unroll('Testing mySelf #file')
    def 'myself'() {
        expect:
        convertAndEvaluate(file)

        where:
        file                       | _
        'contribution/MySelf1'     | _
        'contribution/MySelf2'     | _
        'contribution/MySelf3'     | _
        'contribution/MySelf4'     | _
        'contribution/MySelf5'     | _
        'contribution/MySelf6'     | _
        'contribution/MySelf7'     | _
        'contribution/MySelf8'     | _
        'contribution/MySelf9'     | _
    }

    def 'guillaume examples from talks'() {
        expect:
        convertAndEvaluate('contribution/Guillaume')
        convertAndEvaluate('contribution/GuillaumeClosuresComposition')
    }

    def 'ronny is'() {
        expect:
        convertAndEvaluate('contribution/Ronny')
    }

    def 'mscharhag closure composition'() {
        expect:
        convertAndEvaluate('contribution/Mscharhag')
    }

    def 'jason winnebeck interface safe'() {
        expect:
        convertAndEvaluate('contribution/JasonWinnebeck')
    }

    def 'dinko assignation returns value assigned'() {
        expect:
        convertAndEvaluate('contribution/Dinko')
    }

    def 'menehtbeo found big bug'() {
        expect:
        convertAndEvaluate('contribution/Menehtbeo')
    }
}
