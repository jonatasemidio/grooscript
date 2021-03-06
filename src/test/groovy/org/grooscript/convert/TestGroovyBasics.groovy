package org.grooscript.convert

import org.grooscript.test.ConversionMixin
import org.grooscript.test.JavascriptEngine
import org.grooscript.test.JsTestResult
import spock.lang.Specification

/**
 * First tests for converts groovy code to javascript code
 * JFL 27/08/12
 */
@Mixin([ConversionMixin])
class TestGroovyBasics extends Specification {

    def 'assert function'() {

        when:
        def jsScript = converter.toJs('assert true')
        def result =  JavascriptEngine.jsEval(jsScript)

        then:
        !result.assertFails

        when:
        jsScript = converter.toJs('assert false')
        result =  JavascriptEngine.jsEval(jsScript)

        then:
        result.assertFails
    }

    def 'test Web Main example' () {
        expect:
        convertAndEvaluate('webMainExample')
    }

    def 'variables and expressions'() {
        when:
        JsTestResult result = convertAndEvaluateWithJsEngine('variablesAndExpressions')

        then:
        !result.assertFails
        result.bind.b == 3.2
        result.bind.a == 5
        result.bind.c == 'Hello!'
    }

    def 'initial class'() {
        expect:
        convertAndEvaluate('initialClass')
    }

    def 'starting class stuff'() {
        when:
        JsTestResult result = convertAndEvaluateWithJsEngine('startingClass')

        then:
        !result.assertFails
        result.console == 'Fan: GroovyRocks'
    }

    def 'starting closure stuff'() {
        expect:
        convertAndEvaluate('startingClosuresWithClasses')
    }

    def 'starting converting lists'() {
        expect:
        convertAndEvaluate('startingWorkOnLists')
    }

    def 'list functions'() {
        expect:
        convertAndEvaluate('listFunctions')
    }

    def 'some inheritance class'() {
        expect:
        convertAndEvaluate('someInheritance')
    }

    def 'maps and more closures'() {
        expect:
        convertAndEvaluate('mappingAndClosuring')
    }

    def 'control structures'() {
        expect:
        convertAndEvaluate('controlStructures')
    }

    def 'regular expressions'() {
        expect:
        convertAndEvaluate('regularExpressionsBegin')
    }

    def 'working with strings'() {
        expect:
        convertAndEvaluate('workingWithStrings')
    }

    def 'working with enums'() {
        expect:
        convertAndEvaluate('enums')
    }

    def 'static stuff in classes'() {
        expect:
        convertAndEvaluate('staticRealm')
    }

    def 'sets'() {
        expect:
        convertAndEvaluate('sets')
    }

    def 'functions and closures'() {
        expect:
        convertAndEvaluate('functions')
    }

    def 'interfaces'() {
        expect:
        convertAndEvaluate('interfaces')
    }

    def 'test arithmetic'() {
        expect:
        convertAndEvaluate('arithmetic')
    }
}
