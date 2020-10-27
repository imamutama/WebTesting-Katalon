package com.information

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class informationDetail {

	@Keyword
	def UsernameNull(){
		TestData value = findTestData("dataInformation");
		int row = value.getRowNumbers();
		WebUI.setText( findTestObject('LoginObject/inputEmail'),value.getValue("Email", row))
		WebUI.setText( findTestObject('LoginObject/inputPhone'),value.getValue("Phone", row))
		WebUI.setText(findTestObject('LoginObject/inputCompany'),value.getValue("Company", row))
		WebUI.click(findTestObject('LoginObject/buttonRequest'))
		def alertUsername = WebUI.verifyElementText(findTestObject("LoginObject/nameRequired"), 'The full name field is required.')
		if(alertUsername){
			println("Data Username harus di isi")
		}else{
			return false;
		}
	}

	@Keyword
	def EmailNull(){
		TestData value = findTestData("dataInformation");
		int row = value.getRowNumbers();
		WebUI.delay(5)
		WebUI.refresh()

		WebUI.setText(findTestObject('LoginObject/inputUsername'),value.getValue("Username", row))
		WebUI.setText(findTestObject('LoginObject/inputPhone'),value.getValue("Phone", row))
		WebUI.setText(findTestObject('LoginObject/inputCompany'),value.getValue("Company", row))
		WebUI.click(findTestObject('LoginObject/buttonRequest'))
		def alertEmail = WebUI.verifyElementText(findTestObject("LoginObject/emailRequired"), 'The email field is required.')
		if(alertEmail){
			println("Data Email harus di isi")
		}else{
			return false;
		}
	}

	@Keyword
	def PhoneNull(){
		TestData value = findTestData("dataInformation");
		int row = value.getRowNumbers();
		WebUI.delay(5)
		WebUI.refresh()

		WebUI.setText(findTestObject('LoginObject/inputUsername'),value.getValue("Username", row))
		WebUI.setText(findTestObject('LoginObject/inputEmail'),value.getValue("Email", row))
		WebUI.setText(findTestObject('LoginObject/inputCompany'),value.getValue("Company", row))
		WebUI.click(findTestObject('LoginObject/buttonRequest'))
		def alertPhone = WebUI.verifyElementText(findTestObject("LoginObject/phoneRequired"), 'The phone field is required.')
		if(alertPhone){
			println("Data Phone Number harus di isi")
		}else{
			return false;
		}
	}

	@Keyword
	def CompanyNull(){
		TestData value = findTestData("dataInformation");
		int row = value.getRowNumbers();
		WebUI.refresh()
		WebUI.delay(4)
		WebUI.setText(findTestObject('LoginObject/inputUsername'),value.getValue("Username", row))
		WebUI.setText( findTestObject('LoginObject/inputEmail'),value.getValue("Email", row))
		WebUI.setText(findTestObject('LoginObject/inputPhone'),value.getValue("Phone", row))
		WebUI.click(findTestObject('LoginObject/buttonRequest'))
		def alertCompany = WebUI.verifyElementText(findTestObject("LoginObject/companyRequired"), 'The organization name field is required.')
		if(alertCompany){
			println("Data Company harus di isi")
		}else{
			return false;
		}
	}
}
