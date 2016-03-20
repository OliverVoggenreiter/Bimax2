package datatype.matrix;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashBinaryMatrix implements BinaryMatrix {

	private static final long serialVersionUID = 1L;
	private Map<Integer, Set<Integer>> data;
	private Map<Integer, Integer> columnCounts;

	public HashBinaryMatrix() {
		data = new HashMap<>();
		columnCounts = new HashMap<>();
	}

	@Override
	public int getNumRows() {
		return data.size();
	}

	@Override
	public int getNumColumns() {
		return columnCounts.size();
	}

	@Override
	public boolean get(int rowIndex, int columnIndex) {
		return data.containsKey(rowIndex) && data.get(rowIndex).contains(columnIndex);
	}

	@Override
	public void set(int rowIndex, int columnIndex, boolean value) {
		if (value) {
			set(rowIndex, columnIndex);
		} else {
			if (get(rowIndex, columnIndex)) {
				data.get(rowIndex).remove(columnIndex);
				if (data.get(rowIndex).size() == 0) {
					data.remove(rowIndex);
				}
				columnCounts.put(columnIndex, columnCounts.get(columnIndex) - 1);
				if (columnCounts.get(columnIndex) == 0) {
					columnCounts.remove(columnIndex);
				}
			}
		}
	}

	@Override
	public void set(int rowIndex, int columnIndex) {
		if (!get(rowIndex, columnIndex)) {
			if (!data.containsKey(rowIndex)) {
				data.put(rowIndex, new HashSet<>());
			}
			data.get(rowIndex).add(columnIndex);
			if (!columnCounts.containsKey(columnIndex)) {
				columnCounts.put(columnIndex, 0);
			}
			columnCounts.put(columnIndex, columnCounts.get(columnIndex) + 1);
		}
	}

	@Override
	public float getDensity() {
		int count = 0;
		for (Integer columnCount : columnCounts.values()) {
			count += columnCount;
		}
		return count / ((float) getNumRows() * getNumColumns());
	}

	@Override
	// TODO: Can we do this more efficiently?
	public BinaryMatrix getSubMatrix(Collection<Integer> rows, Collection<Integer> columns) {
		BinaryMatrix subMatrix = new HashBinaryMatrix();
		for (int row : rows) {
			for (int column : columns) {
				if (get(row, column)) {
					subMatrix.set(row, column);
				}
			}
		}
		return subMatrix;
	}

	@Override
	public BinaryMatrix getSubRows(Collection<Integer> rows) {
		return getSubMatrix(rows, columnCounts.keySet());
	}

	@Override
	public BinaryMatrix getSubColumns(Collection<Integer> columns) {
		return getSubMatrix(data.keySet(), columns);
	}

	@Override
	public String toString() {
		String output = "";
		Set<Integer> rows = data.keySet();
		Set<Integer> columns = columnCounts.keySet();
		int maxCol = 0;
		for (Integer column : columns) {
			if (column > maxCol) {
				maxCol = column;
			}
		}
		ArrayList<Integer> list = new ArrayList<>(rows);
		Collections.sort(list);
		int currentRow = 0;
		while (currentRow <= list.get(list.size() - 1)) {
			String printRow = "";
			if (!list.contains(currentRow)) {
				for (int i = 0; i <= maxCol; i++) {
					printRow += "0 ";
				}
			} else {
				for (int i = 0; i <= maxCol; i++) {
					printRow += this.get(currentRow, i) ? "1 " : "0 ";
				}
			}
			currentRow++;
			output += printRow + "\n";
		}
		return output;
	}

}
