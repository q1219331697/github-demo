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

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;

/**
 * 标签名称 BaseDirective
 * <p>
 * example:<br>
 * 
 * {@code <@cms_xxx_list>} <br>
 * {@code <#list list as a>} <br>
 * {@code a.id,a.title,...} <br>
 * {@code </#list>} <br>
 * {@code </@cms_xxx_list>}
 * 
 * @author QQ:1219331697
 *
 */
public abstract class BaseDirective implements TemplateDirectiveModel {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@SuppressWarnings("rawtypes")
	public abstract void execute(Environment env, Map params, TemplateModel[] loopVars,
			TemplateDirectiveBody body) throws TemplateException, IOException;

}
