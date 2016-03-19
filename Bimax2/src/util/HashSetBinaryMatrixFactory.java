package util;

import datatype.matrix.BinaryMatrix;
import datatype.matrix.HashBinaryMatrix;

public class HashSetBinaryMatrixFactory implements BinaryMatrixFactory {

	@Override
	public BinaryMatrix createBinaryMatrix(int numRows, int numColumns) {
		return new HashBinaryMatrix();
	}

}
