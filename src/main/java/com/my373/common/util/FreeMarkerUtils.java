package com.my373.common.util;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerUtils {

	private FreeMarkerConfigurer freeMarkerConfigurer;

	public void setFreeMarkerConfigurer(FreeMarkerConfigurer freeMarkerConfigurer) {
		this.freeMarkerConfigurer = freeMarkerConfigurer;
	}

	public Template getTemplate(String templateName) throws IOException, TemplateException {
		return freeMarkerConfigurer.getConfiguration().getTemplate(templateName);
	}

	public String getContent(String templateName, Map<String, Object> model) throws IOException,
			TemplateException {
		Template t = freeMarkerConfigurer.getConfiguration().getTemplate(templateName);
		return FreeMarkerTemplateUtils.processTemplateIntoString(t, model);
	}

	public void createHtmlFlie(String templatePath, Map<String, Object> rootMap, String filePath)
			throws IOException, TemplateException {
		Template t = freeMarkerConfigurer.getConfiguration().getTemplate(templatePath);
		Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath),
				"UTF-8"));
		t.process(rootMap, out);
		out.close();
	}
}
