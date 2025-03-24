package com.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BlazeReport implements ITestListener{
	 private static ExtentReports report;
	 private static ExtentTest test;
	 static {
		 ExtentSparkReporter sparkReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
	     report = new ExtentReports();
	     report.attachReporter(sparkReporter);
	 }
	 @Override
	 public void onTestStart(ITestResult result) {
	     test = report.createTest(result.getMethod().getMethodName());
	 }
	 @Override
	 public void onTestSuccess(ITestResult result) {
	     test.pass("Test Passed");
	 }

	 @Override
	 public void onTestFailure(ITestResult result) {
	     test.fail("Test Failed: " + result.getThrowable());
	 }

	 @Override
	 public void onFinish(ITestContext context) {
	     report.flush(); 
	 }

}
