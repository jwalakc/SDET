package GroovyPackage

class API_Project_Groovy_Activity1a {
	static void main(def args) {
		def inputList = [11, 2, 19, 5, "Mango", "Apple", "Watermelon"]
		
		def stringList = inputList.minus([11, 2, 19, 5])
		println ("The sorted string list is: ${stringList.sort()}")
		
		def intList = inputList.minus(["Mango", "Apple", "Watermelon"])
		println ("The sorted int list is: ${intList.sort()}")
	}
}	
// minus doesn't care about the order of the list
// so works the same even when inputList is not sorted 