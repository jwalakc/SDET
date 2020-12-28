package GroovyPackage

class API_Project_Groovy_Activity1b {
	static void main(def args) {
		File file1 = new File ("./src/GroovyPackage/GroovyFile.txt")
		file1.createNewFile()
		
		file1.write "A quick brown Fox jumped over the lazy Cow\n"
		file1.append "John Jimbo jingeled happily ever after\n"
		file1 << 'Th1$ 1$ v3ry c0nfus1ng' //' ' to not treat $ as template string
		// another way: file1 << "Th1\$ 1\$ v3ry c0nfus1ng"
		
		println "The file created has the text: \n${file1.getText()}"
		println "\nMatch Results: "
		
		// Print the line that has Cow at the end of the line
		file1.eachLine { line -> 
			if (line ==~ /.*Cow$/)
				println "\nLine that ends with Cow: \n$line"
		
		// Print the line that start with capital letter 'J'
			if (line ==~ /^J.*/)
				println "\nLine that starts with J: \n$line"
		
		// Print the line that has two numbers one after the other
			if (line ==~ /.*\d.*\d.*/) 
				println "\nLine that has two numbers in the line: \n$line"
					}
		// Print the string(s) that match the pattern '\S+er'
		//=> string(s) with 1 or more non-whitespace character followed by "er"
		def text1 = file1.getText() =~ /\S+er/
		println "\nString(s) that match the pattern '\\S+er': \n${text1.findAll()}"
		
		// Print the string(s) that match the pattern '\S*\d\W'
		//=> string(s) with 0 or more non-whitespace character followed by a digit, followed by a non-word character
		def text2 = file1.getText() =~ /\S*\d\W/
		println "\nString(s) that match the pattern '\\S+er': \n${text2.findAll()}"
		}
}	