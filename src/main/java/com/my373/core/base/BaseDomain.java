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

package com.my373.core.base;

/**
 * 实体基础类 BaseDomain
 * 
 * @author QQ:1219331697
 *
 */
public class BaseDomain implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	// OrphanRemoval 的做法很像 CascadeType.REMOVE 。
	// 不同的是，当两个实体之间失去关系是，OrphanRemoval 就会做出级联删除。
	// person.setAddress(null);
	// 例如执行以上代码，会导致原本相关的 address 实体成为孤儿，
	// 而 OrphanRemoval 则会将其级联删除。

}
