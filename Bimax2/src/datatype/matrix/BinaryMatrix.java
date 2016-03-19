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

package datatype.matrix;

import java.io.Serializable;
import java.util.Collection;

/**
 * A fixed-size binary matrix.
 */
public interface BinaryMatrix extends Cloneable, Serializable {

	public int getNumRows();

	public int getNumColumns();

	public boolean get(int rowIndex, int columnIndex);

	public void set(int rowIndex, int columnIndex, boolean value);

	public void set(int rowIndex, int columnIndex);

	public float getDensity();

	public BinaryMatrix getSubMatrix(Collection<Integer> rows,
			Collection<Integer> columns);

	public BinaryMatrix getSubRows(Collection<Integer> rows);

	public BinaryMatrix getSubColumns(Collection<Integer> columns);

}
