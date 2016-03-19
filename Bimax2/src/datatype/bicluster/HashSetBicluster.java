package datatype.bicluster;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class HashSetBicluster implements Bicluster {

	private static final long serialVersionUID = 1L;
	private Set<Integer> rows;
	private Set<Integer> columns;
	
	public HashSetBicluster() {
		rows = new HashSet<>();
		columns = new HashSet<>();
	}
	
	@Override
	public Collection<Integer> getRows() {
		return rows;
	}

	@Override
	public Collection<Integer> getColumns() {
		return columns;
	}

	@Override
	public int getNumberOfRows() {
		return rows.size();
	}

	@Override
	public int getNumberOfColumns() {
		return columns.size();
	}

	@Override
	public boolean contains(int rowIndex, int columnIndex) {
		return containsRow(rowIndex) && containsColumn(columnIndex);
	}

	@Override
	public boolean containsRow(int rowIndex) {
		return rows.contains(rowIndex);
	}

	@Override
	public boolean containsColumn(int columnIndex) {
		return columns.contains(columnIndex);
	}

	@Override
	public void addRow(int rowIndex) {
		rows.add(rowIndex);
	}

	@Override
	public void addColumn(int columnIndex) {
		columns.add(columnIndex);
	}

	@Override
	public void addRows(Collection<Integer> rows) {
		this.rows.addAll(rows);
	}

	@Override
	public void addColumns(Collection<Integer> columns) {
		this.columns.addAll(columns);
	}

}
