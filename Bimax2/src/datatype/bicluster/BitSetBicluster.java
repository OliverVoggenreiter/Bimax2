/* Bimax 2 - A biclustering algorithm based on the Bron-Kerbosch
 * Maximal Clique Enumeration Algorithm.
 * Copyright (C) 2014 Oliver Voggenreiter
 *
 * This program is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/>.
 */

package datatype.bicluster;

import java.util.Collection;

import datatype.vector.BitSetBinaryVector;

public class BitSetBicluster implements Bicluster {

	private static final long serialVersionUID = 1L;
	private BitSetBinaryVector rows;
	private BitSetBinaryVector columns;

	public BitSetBicluster() {
		rows = new BitSetBinaryVector();
		columns = new BitSetBinaryVector();
	}

	@Override
	public Collection<Integer> getRows() {
		return rows.toIntegerCollection();
	}

	@Override
	public Collection<Integer> getColumns() {
		return columns.toIntegerCollection();
	}

	@Override
	public int getNumberOfRows() {
		return rows.cardinality();
	}

	@Override
	public int getNumberOfColumns() {
		return columns.cardinality();
	}

	@Override
	public void addRow(int rowIndex) {
		rows.set(rowIndex, true);
	}

	@Override
	public void addColumn(int columnIndex) {
		columns.set(columnIndex, true);
	}

	@Override
	public void addRows(Collection<Integer> rowsToAdd) {
		for (Integer row : rowsToAdd) {
			rows.set(row, true);
		}
	}

	@Override
	public void addColumns(Collection<Integer> columnsToAdd) {
		for (Integer column : columnsToAdd) {
			columns.set(column, true);
		}
	}

	@Override
	public boolean contains(int rowIndex, int columnIndex) {
		return (rows.get(rowIndex) && columns.get(columnIndex));
	}

	@Override
	public boolean containsRow(int rowIndex) {
		return rows.get(rowIndex);
	}

	@Override
	public boolean containsColumn(int columnIndex) {
		return columns.get(columnIndex);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result =
				prime
				* result
				+ ((columns == null) ? 0 : columns
						.hashCode());
		result =
				prime * result
				+ ((rows == null) ? 0 : rows.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BitSetBicluster other = (BitSetBicluster) obj;
		if (columns == null) {
			if (other.columns != null)
				return false;
		} else if (!columns.equals(other.columns))
			return false;
		if (rows == null) {
			if (other.rows != null)
				return false;
		} else if (!rows.equals(other.rows))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BitSetBicluster [rows=" + rows + ", columns="
				+ columns + "]";
	}

}
