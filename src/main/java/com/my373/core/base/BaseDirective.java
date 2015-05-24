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

public abstract class BaseDirective implements TemplateDirectiveModel {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@SuppressWarnings("rawtypes")
	public abstract void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body)
			throws TemplateException, IOException;

}
