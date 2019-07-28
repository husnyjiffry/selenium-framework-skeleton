package com.gui.automation.utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListeners extends TestBase implements ITestListener {

    static int totalTests;
    static int successTests;
    static int failureTests;
    static int skippedTests;


    public TestListeners() {
        totalTests = 0;
        successTests = 0;
        failureTests = 0;
        skippedTests = 0;
    }

    public static int getTotalTests() {
        return totalTests;
    }

    public static int getSuccessTests() {
        return successTests;
    }

    public static int getFailureTests() {
        return failureTests;
    }

    public static int getSkippedTests() {
        return skippedTests;
    }

    public void onTestStart(ITestResult iTestResult) {
        System.out.println(iTestResult.getName() + " Test Case Started");
        totalTests += 1;

    }

    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println(iTestResult.getName() + " Test Case Passed");
        successTests += 1;
    }

    public void onTestFailure(ITestResult iTestResult) {
        System.out.println(iTestResult.getName() + " Test Case Failed");
        failureTests += 1;
        SeleniumUtils.captureScreenShot("src/test/resources/screenshots/" + SeleniumUtils.generateRandomNameWithTimestamp() + ".png");

    }

    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println(iTestResult.getName() + " Test Case Skipped");
        skippedTests += 1;
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {
        System.out.println("Total Test Cases Executed : " + getTotalTests());
        System.out.println("Total Test Cases Passed : " + getSuccessTests());
        System.out.println("Total Test Cases Failed : " + getFailureTests());
        System.out.println("Total Test Cases Skipped : " + getSkippedTests());
    }
}
