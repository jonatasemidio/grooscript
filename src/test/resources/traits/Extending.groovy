package traits

/**
 * Created by jorge on 17/04/14.
 */

trait WithName {
    String traitName = 'WithName'
    String name
    int count = 0
    String getName() {
        count = count + 1
        name
    }
}
trait Friendly extends WithName {
    String traitName = 'Friendly'
    String introduce() { "Hello, I am $name" }
}
class Guy implements Friendly {}
def g = new Guy(name: 'Groovy')
assert g.introduce() == 'Hello, I am Groovy'
assert g instanceof Friendly, 'Instance Friendly'
assert g instanceof Guy, 'Instance Guy'
assert g instanceof WithName, 'Instance WithName'
assert g.traitName == 'Friendly', 'Friendly'
assert g.count == 1, 'Count'
