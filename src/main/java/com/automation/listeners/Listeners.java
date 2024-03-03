package com.automation.listeners;

import com.automation.annotations.FrameworkAnnotation;
import com.automation.reports.ExtentLogger;
import com.automation.reports.ExtentReport;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class Listeners implements BeforeAllCallback, AfterAllCallback, BeforeTestExecutionCallback, AfterTestExecutionCallback {

  private static final String MESSAGE = "Test - <b>";

  @Override
  public void beforeAll(ExtensionContext context) throws Exception {
    System.out.println("I AM BEING EXECUTED");
    ExtentReport.initExtentReport();
  }

  @Override
  public void afterAll(ExtensionContext context) throws Exception {
    ExtentReport.flushExtentReport();
  }

  @Override
  public void beforeTestExecution(ExtensionContext context) throws Exception {
    String methodName = context.getRequiredTestMethod().getName();
    ExtentReport.createTest(methodName);

    // Access annotations using reflection
    FrameworkAnnotation annotation = context.getRequiredTestMethod().getAnnotation(FrameworkAnnotation.class);
    if (annotation != null) {
      ExtentLogger.addAuthors(annotation.author());
      ExtentLogger.addCategories(annotation.category());
    } else {
      System.out.println("Author and category annotations are not present for this test method.");
      // If desired, log a message to the Extent report as well
    }
    ExtentLogger.pass(MESSAGE + methodName + "</b> is started");
  }

  @Override
  public void afterTestExecution(ExtensionContext context) throws Exception {
    String methodName = context.getRequiredTestMethod().getName();
    ExtensionContext.Store store = context.getStore(ExtensionContext.Namespace.create(getClass(), methodName));
    boolean testResult = context.getExecutionException().isPresent();

    if (!testResult) {
      ExtentLogger.pass(MESSAGE + methodName + "</b> is passed");
    } else {
      ExtentLogger.fail(MESSAGE + methodName + "</b> is failed", context.getExecutionException().get());
    }
  }
}
