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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.my373.core.AppForm;

/**
 * restful 接口 参考 struts2 REST plugin 约定优于配置
 * <p>
 * 
 * <table class="confluenceTable">
 * <tbody>
 * <tr>
 * <th colspan="1" rowspan="1" class="confluenceTh">HTTP method</th>
 * <th colspan="1" rowspan="1" class="confluenceTh">URI</th>
 * <th colspan="1" rowspan="1" class="confluenceTh">Class.method</th>
 * <th colspan="1" rowspan="1" class="confluenceTh">parameters</th>
 * </tr>
 * <tr>
 * <td colspan="1" rowspan="1" class="confluenceTd">GET</td>
 * <td colspan="1" rowspan="1" class="confluenceTd">/movie</td>
 * <td colspan="1" rowspan="1" class="confluenceTd">Movie.index</td>
 * <td colspan="1" rowspan="1" class="confluenceTd">&nbsp;</td>
 * </tr>
 * <tr>
 * <td colspan="1" rowspan="1" class="confluenceTd">GET</td>
 * <td colspan="1" rowspan="1" class="confluenceTd">/movie/new</td>
 * <td colspan="1" rowspan="1" class="confluenceTd">Movie.editNew</td>
 * <td colspan="1" rowspan="1" class="confluenceTd">&nbsp;</td>
 * </tr>
 * <tr>
 * <td colspan="1" rowspan="1" class="confluenceTd">POST</td>
 * <td colspan="1" rowspan="1" class="confluenceTd">/movie</td>
 * <td colspan="1" rowspan="1" class="confluenceTd">Movie.create</td>
 * <td colspan="1" rowspan="1" class="confluenceTd">&nbsp;</td>
 * </tr>
 * <tr>
 * <td colspan="1" rowspan="1" class="confluenceTd">GET</td>
 * <td colspan="1" rowspan="1" class="confluenceTd">/movie/Thrillers</td>
 * <td colspan="1" rowspan="1" class="confluenceTd">Movie.show</td>
 * <td colspan="1" rowspan="1" class="confluenceTd">id="Thrillers"</td>
 * </tr>
 * <tr>
 * <td colspan="1" rowspan="1" class="confluenceTd">GET</td>
 * <td colspan="1" rowspan="1" class="confluenceTd">/movie/Thrillers/edit</td>
 * <td colspan="1" rowspan="1" class="confluenceTd">Movie.edit</td>
 * <td colspan="1" rowspan="1" class="confluenceTd">id="Thrillers"</td>
 * </tr>
 * <tr>
 * <td colspan="1" rowspan="1" class="confluenceTd">PUT</td>
 * <td colspan="1" rowspan="1" class="confluenceTd">/movie/Thrillers</td>
 * <td colspan="1" rowspan="1" class="confluenceTd">Movie.update</td>
 * <td colspan="1" rowspan="1" class="confluenceTd">id="Thrillers"</td>
 * </tr>
 * <tr>
 * <td colspan="1" rowspan="1" class="confluenceTd">DELETE</td>
 * <td colspan="1" rowspan="1" class="confluenceTd">/movie/Thrillers</td>
 * <td colspan="1" rowspan="1" class="confluenceTd">Movie.destroy</td>
 * <td colspan="1" rowspan="1" class="confluenceTd">id="Thrillers"</td>
 * </tr>
 * </tbody>
 * </table>
 * 
 * @author QQ:1219331697
 *
 * @see <a
 *      href="http://struts.apache.org/docs/rest-plugin.html#RESTPlugin-RESTfulURLMappingLogic">http://struts.apache.org/docs/rest-plugin.html#RESTPlugin-RESTfulURLMappingLogic</a>
 * 
 */
public interface BaseRestful<ID> {

	/**
	 * 处理不带 id 请求参数的 GET 请求。 <br>
	 * /book
	 */
	public String index(AppForm form, Model model, HttpServletRequest request, HttpServletResponse response);

	/**
	 * 处理带 id 请求参数的 GET 请求。 <br>
	 * /book/2
	 */
	public String show(ID id, Model model, HttpServletRequest request, HttpServletResponse response);

	/**
	 * 处理不带 id 请求参数，且指定操作 edit 资源的 GET 请求。 <br>
	 * /book/new
	 */
	public String editNew(Model model, HttpServletRequest request, HttpServletResponse response);

	/**
	 * 处理不带 id 请求参数的 POST 请求。 <br>
	 * /book
	 */
	public String create(AppForm form, Model model, HttpServletRequest request, HttpServletResponse response);

	/**
	 * 处理带 id 请求参数，且指定操作 edit 资源的 GET 请求。 <br>
	 * /book/2/edit
	 */
	public String edit(ID id, Model model, HttpServletRequest request, HttpServletResponse response);

	/**
	 * 处理带 id 请求参数的 PUT 请求。 <br>
	 * /book/2
	 */
	public String update(ID id, AppForm form, Model model, HttpServletRequest request,
			HttpServletResponse response);

	/**
	 * 处理带 id 请求参数的 DELETE 请求。 <br>
	 * /book/2
	 */
	public String destroy(ID id, Model model, HttpServletRequest request, HttpServletResponse response);

}
