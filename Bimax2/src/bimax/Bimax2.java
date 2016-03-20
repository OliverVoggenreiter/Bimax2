package bimax;

import java.util.List;

import bipartite.BronKerboschBipartite;
import bipartite.BronKerboschBipartiteV3;
import datatype.bicluster.Bicluster;
import datatype.matrix.BinaryMatrix;
import datatype.matrix.HashBinaryMatrix;
import util.BinaryMatrixFactory;
import util.HashSetBinaryMatrixFactory;

public class Bimax2 {

	public static void main(String[] args) {
		BronKerboschBipartite algorithm = new BronKerboschBipartiteV3();
		algorithm.setMinColumns(2);
		algorithm.setMinRows(2);
		BinaryMatrixFactory factory = new HashSetBinaryMatrixFactory();
		BinaryMatrix matrix = new HashBinaryMatrix();
		matrix.set(0, 0);
		matrix.set(2, 0);
		matrix.set(0, 2);
		matrix.set(2, 2);
		System.out.println(matrix);
		List<Bicluster> biclusters = algorithm.findBiclusters(matrix, factory);
		for(Bicluster bicluster : biclusters) {
			System.out.println(bicluster);
		}
	}
	
}
