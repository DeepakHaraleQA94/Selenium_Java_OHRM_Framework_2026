package com.ohrm.qa.utility;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.ohrm.qa.parent.TestBase;

public class TransFormerAnnotation extends TestBase implements IAnnotationTransformer {

    public TransFormerAnnotation() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
    public void transform(
            ITestAnnotation annotation,
            Class testClass,
            Constructor testConstructor,
            Method testMethod) {

        annotation.setRetryAnalyzer(RetryAnalyzer.class);
    }
}

