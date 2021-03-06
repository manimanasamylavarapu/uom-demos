/**
 *  Unit-API - Units of Measurement API for Java
 *  Copyright 2013-2014, Jean-Marie Dautelle, Werner Keil, V2COM and individual
 *  contributors by the @author tag.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *  http://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package tec.uom.demo.health.se;

import static tec.uom.se.spi.SI.KILOGRAM;
import static tec.uom.se.spi.SI.METRE;

import javax.measure.Quantity;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;

import tec.uom.se.quantity.Quantities;

/**
 * This is a simple BMI (Body Mass Index) calculator
 * @version 0.4
 * @author Werner
 *
 */
public class BMIDemoSE {

	public static void main(String[] args) {
		Double dHeight;
		Double dWeight;
		if(args.length > 0) {
			dHeight = Double.parseDouble(args[0]);
			dWeight = Double.parseDouble(args[1]);
		} else {
			dHeight = 1.85d;
			dWeight = 85d;
		}

		Quantity<Length> height = Quantities.getQuantity(dHeight, METRE);
		Quantity<Mass> mass = Quantities.getQuantity(dWeight, KILOGRAM);
		
		Quantity<Area> squareHeight = height.multiply(height).asType(Area.class);
//		Quantity<?> squareHeight2 = height.multiply(height);
		Quantity<?> bmi = mass.divide(squareHeight);
		System.out.println(bmi);
	}

}
