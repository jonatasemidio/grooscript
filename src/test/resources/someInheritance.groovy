/**
 * JFL 04/09/12
 */
class MotorizedVehicle extends Vehicle {

    def company
    def backVehicles

    MotorizedVehicle(name,seats,wheels) {
        super(name)
        this.seats = seats
        this.wheels = wheels
        this.backVehicles = []
    }

    def putVehicleBack(vehicle) {
        backVehicles << vehicle
    }

    def String toString() {
        return "MotorizedVehicle(${name}).wheels(${wheels}).seats(${seats}).company($company).back(${backVehicles.size()})"
    }
}

class Vehicle {

    def wheels
    def seats
    def name

    Vehicle(name) {
        this.name = name
        wheels = 0
        seats = 0
    }

    def String toString() {
        return "Vehicle(${name}).wheels(${wheels}).seats(${seats})"
    }
}

def bike = new Vehicle('Bike')
bike.seats = 1
bike.wheels = 2

//We add a try test
def error = false
try {
    bike.company.gol
} catch (e) {
    error = true
}
assert error

def car = new MotorizedVehicle('Car',4,4)
car.company = 'Opel'
assert car.toString() == 'MotorizedVehicle(Car).wheels(4).seats(4).company(Opel).back(0)'

car.putVehicleBack(bike)
assert car.toString() == 'MotorizedVehicle(Car).wheels(4).seats(4).company(Opel).back(1)'