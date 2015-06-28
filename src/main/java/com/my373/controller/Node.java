/**
 * Copyright qq:1219331697
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.my373.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @author QQ:1219331697
 *
 */
public class Node implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private Object v;
	private Object n;
	private Integer num;
	private List<Node> s = new ArrayList<Node>(0);

	public Node() {
	}

	public Node(Object v, Object n) {
		this.v = v;
		this.n = n;
	}

	public Node(Object v, Object n, List<Node> s) {
		this.v = v;
		this.n = n;
		this.s = s;
	}

	public Object getV() {
		return v;
	}

	public void setV(Object v) {
		this.v = v;
	}

	public Object getN() {
		return n;
	}

	public void setN(Object n) {
		this.n = n;
	}

	public List<Node> getS() {
		return s;
	}

	public void setS(List<Node> s) {
		this.s = s;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
}
