#include <iostream>
#include <fstream>

void print(int* arr, size_t size) {
	std::cout << "[";
	for (size_t i = 0; i < size - 1; i++) {
		std::cout << arr[i] << ", ";
	}
	std::cout << arr[size - 1] << "]" << std::endl;
}

int* readArray(size_t size) {
	int* arr = new int[size];
	for (size_t i = 0; i < size; i++) {
		std::cin >> arr[i];
	}
	return arr;
}

void writeIntoBinaryFile(int* arr, size_t size, const char* fileName) {
	if (arr == nullptr || fileName == nullptr) {
		return;
	}
	std::ofstream outputFile(fileName, std::ios::binary);
	if (!outputFile) {
		return;
	}
	outputFile.write((const char*)&size, sizeof(size_t));
	outputFile.write((const char*) arr, size);
	outputFile.close();
}

int* readFromBinaryFile(size_t size, const char* fileName){
	if (fileName == nullptr) {
		return;
	}
	int* arr = new int[size];
	std::ifstream inputFile(fileName, std::ios::binary);
	if (!inputFile) {
		return nullptr;
	}
	inputFile.read((char*)&size, sizeof(size_t));
	for (size_t i = 0; i < size; i++) {
		inputFile.read((char*) arr[i], size);
	}
	inputFile.close();
	return arr;
}

void freeMemo(int* arr) {
	delete[] arr;
}

size_t strLen(char* arr) {
	size_t size = 0;
	while (arr[size++]);
	return size - 1;
}

void append(char* str, size_t& index, char* toAppend, size_t MAX_SIZE = 256) {
	size_t len = strLen(toAppend);
	for(index; i)
}

struct StudentC {
	int id;
	char name[50];
	double grade;
};

char* toString(StudentC st) {
	char* str = new char[256];
	size_t index = 0;
	append(str, index, std::to_string(st.id + "");
	append(str, index, st.name);
	append(str, index, st.grade + "");
}

void writeIntoBinaryFile(StudentC st1, const char* fileName) {

}

int main()
{
	//ex1
	size_t size;
	std::cin >> size;
	int* arr1 = readArray(size);
	writeIntoBinaryFile(arr1, size, "data.dat");
	int* arr2 = readFromBinaryFile(size, "data.dat");
	print(arr2, size);
	freeMemo(arr1);
	freeMemo(arr2);

	//ex2
	StudentC st1 = { 1, "ivan1", 5 };
	StudentC st2 = { 2, "ivan2", 5.1 };
	StudentC st3 = { 3, "ivan3", 5.2 };
	writeIntoBinaryFile(st1, "students.dat");
	writeIntoBinaryFile(st2, "students.dat");
	writeIntoBinaryFile(st3, "students.dat");
}
