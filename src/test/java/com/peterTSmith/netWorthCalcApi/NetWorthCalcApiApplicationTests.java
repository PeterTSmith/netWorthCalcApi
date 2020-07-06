package com.peterTSmith.netWorthCalcApi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

import com.peterTSmith.netWorthCalcApi.objects.BalanceSheet.BalanceSheet;
import com.peterTSmith.netWorthCalcApi.objects.BalanceSheet.BalanceSheetContent;
import com.peterTSmith.netWorthCalcApi.objects.BalanceSheet.BalanceSheetField;
import com.peterTSmith.netWorthCalcApi.objects.BalanceValue.BalanceValue;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class NetWorthCalcApiApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void assetValuesGet() {
		BalanceValue[] balanceValues = new BalanceValue[1];
		balanceValues[0] = new BalanceValue(0, 0, 44, "asset", 0);

		BalanceValue[] returnedValues = this.restTemplate.getForObject("http://localhost:"+ port +"/assetValues?docId=0", BalanceValue[].class);

		assertThat(returnedValues[0].getDocId()).isEqualTo(balanceValues[0].getDocId());
		assertThat(returnedValues[0].getFieldId()).isEqualTo(balanceValues[0].getFieldId());
		assertThat(returnedValues[0].getValue()).isEqualTo(balanceValues[0].getValue());
		assertThat(returnedValues[0].getValueType()).isEqualTo(balanceValues[0].getValueType());
		assertThat(returnedValues[0].getDateModified()).isEqualTo(balanceValues[0].getDateModified());
	}

	@Test
	void totalAssetValueGet() {
		long balanceValue = 99;

		this.restTemplate.postForObject("http://localhost:"+ port +"/assetValues?docId=0", new BalanceValue(0, 5, 55, "asset", 0), Object.class );

		long returnedValue = this.restTemplate.getForObject("http://localhost:"+ port +"/totalAssetValue?docId=0", Long.class);

		assertThat(returnedValue).isEqualTo(balanceValue);
	}

	@Test
	void assetValuesPost() {
		this.restTemplate.postForObject("http://localhost:"+ port +"/assetValues?docId=0", new BalanceValue(0, 5, 55, "asset", 0), Object.class );
		assertThat(this.restTemplate.getForObject("http://localhost:"+ port +"/netWorthValue?docId=0", Integer.class)).isEqualTo(-5645);
	}

	@Test
	void liabilityValuesGet() {
		BalanceValue[] balanceValues = new BalanceValue[1];
		balanceValues[0] = new BalanceValue(0, 17, 5744, "liability", 0);

		BalanceValue[] returnedValues = this.restTemplate.getForObject("http://localhost:"+ port +"/liabilityValues?docId=0", BalanceValue[].class);

		assertThat(returnedValues[0].getDocId()).isEqualTo(balanceValues[0].getDocId());
		assertThat(returnedValues[0].getFieldId()).isEqualTo(balanceValues[0].getFieldId());
		assertThat(returnedValues[0].getValue()).isEqualTo(balanceValues[0].getValue());
		assertThat(returnedValues[0].getValueType()).isEqualTo(balanceValues[0].getValueType());
		assertThat(returnedValues[0].getDateModified()).isEqualTo(balanceValues[0].getDateModified());
	}

	@Test
	void totalLiabilityValueGet() {
		long balanceValue = 5799;

		this.restTemplate.postForObject("http://localhost:"+ port +"/liabilityValues?docId=0", new BalanceValue(0, 5, 55, "liability", 0), Object.class );

		long returnedValue = this.restTemplate.getForObject("http://localhost:"+ port +"/totalLiabilityValue?docId=0", Long.class);

		assertThat(returnedValue).isEqualTo(balanceValue);
	}

	@Test
	void liabilityValuesPost() {
		this.restTemplate.postForObject("http://localhost:"+ port +"/liabilityValues?docId=0", new BalanceValue(0, 5, 55, "liability", 0), Object.class );
		assertThat(this.restTemplate.getForObject("http://localhost:"+ port +"/netWorthValue?docId=0", Integer.class)).isEqualTo(-5755);
	}

	@Test
	void assetsSheetControllerGet() {
		BalanceSheetField[] cashAndInvestmentsFields = new BalanceSheetField[11];
        cashAndInvestmentsFields[0] = new BalanceSheetField(0, "Chequing");
        cashAndInvestmentsFields[1] = new BalanceSheetField(1, "Savings For Taxes");
        cashAndInvestmentsFields[2] = new BalanceSheetField(2, "Rainy Day Fund");
        cashAndInvestmentsFields[3] = new BalanceSheetField(3, "Savings For Fun");
        cashAndInvestmentsFields[4] = new BalanceSheetField(4, "Savings For Travel");
        cashAndInvestmentsFields[5] = new BalanceSheetField(5, "Savings For Personal Development");
        cashAndInvestmentsFields[6] = new BalanceSheetField(6, "Investment 1");
        cashAndInvestmentsFields[7] = new BalanceSheetField(7, "Investment 2");
        cashAndInvestmentsFields[8] = new BalanceSheetField(8, "Investment 3");
        cashAndInvestmentsFields[9] = new BalanceSheetField(9, "Investment 4");
        cashAndInvestmentsFields[10] = new BalanceSheetField(10, "Investment 5");

        BalanceSheetField[] longTermInvestmentsFields = new BalanceSheetField[3];
        longTermInvestmentsFields[0] = new BalanceSheetField(11, "Primary Home");
        longTermInvestmentsFields[1] = new BalanceSheetField(12, "Second Home");
        longTermInvestmentsFields[2] = new BalanceSheetField(13, "Other");

        BalanceSheetContent[] assetsSheetContent = new BalanceSheetContent[2];
        assetsSheetContent[0] = new BalanceSheetContent("Cash and Investments", cashAndInvestmentsFields);
        assetsSheetContent[1] = new BalanceSheetContent("Long Term Investments", longTermInvestmentsFields);

        BalanceSheet assetsSheet = new BalanceSheet("Assets", assetsSheetContent, 0);
		BalanceSheet returnedValue = this.restTemplate.getForObject("http://localhost:"+ port +"/assetsSheet?docId=0", BalanceSheet.class );

		assertThat(returnedValue.getTitle()).isEqualTo(assetsSheet.getTitle());
		for(int i = 0; i < returnedValue.getContent().length; i++) {
			assertThat(returnedValue.getContent()[i].getTitle()).isEqualTo(assetsSheet.getContent()[i].getTitle());
			for(int j = 0; j < returnedValue.getContent()[i].getFields().length; j++) {
				assertThat(returnedValue.getContent()[i].getFields()[j].getId()).isEqualTo(assetsSheet.getContent()[i].getFields()[j].getId());
				assertThat(returnedValue.getContent()[i].getFields()[j].getName()).isEqualTo(assetsSheet.getContent()[i].getFields()[j].getName());
			}
		}
	}

	@Test
	void liabilitiesSheetControllerGet() {
		BalanceSheetField[] shortTermLiabilities = new BalanceSheetField[3];
        shortTermLiabilities[0] = new BalanceSheetField(14, "Chequing");
        shortTermLiabilities[1] = new BalanceSheetField(15, "Savings For Taxes");
        shortTermLiabilities[2] = new BalanceSheetField(16, "(others...)");

        BalanceSheetField[] longTermDebt = new BalanceSheetField[6];
        longTermDebt[0] = new BalanceSheetField(17, "Mortgage 1");
        longTermDebt[1] = new BalanceSheetField(18, "Mortgage 2");
        longTermDebt[2] = new BalanceSheetField(19, "Line of Credit");
        longTermDebt[3] = new BalanceSheetField(20, "Investment Loan");
        longTermDebt[4] = new BalanceSheetField(21, "Student Loan");
        longTermDebt[5] = new BalanceSheetField(22, "Car Loan");

        BalanceSheetContent[] liabilitiesSheetContent = new BalanceSheetContent[2];
        liabilitiesSheetContent[0] = new BalanceSheetContent("Short Term Liabilities", shortTermLiabilities);
        liabilitiesSheetContent[1] = new BalanceSheetContent("Long Term Debt", longTermDebt);

        BalanceSheet liabilitiesSheet = new BalanceSheet("Liabilities", liabilitiesSheetContent, 0);
		BalanceSheet returnedValue = this.restTemplate.getForObject("http://localhost:"+ port +"/liabilitiesSheet?docId=0", BalanceSheet.class );

		assertThat(returnedValue.getTitle()).isEqualTo(liabilitiesSheet.getTitle());
		for(int i = 0; i < returnedValue.getContent().length; i++) {
			assertThat(returnedValue.getContent()[i].getTitle()).isEqualTo(liabilitiesSheet.getContent()[i].getTitle());
			for(int j = 0; j < returnedValue.getContent()[i].getFields().length; j++) {
				assertThat(returnedValue.getContent()[i].getFields()[j].getId()).isEqualTo(liabilitiesSheet.getContent()[i].getFields()[j].getId());
				assertThat(returnedValue.getContent()[i].getFields()[j].getName()).isEqualTo(liabilitiesSheet.getContent()[i].getFields()[j].getName());
			}
		}
	}

	@Test
	void netWorthValueGet() {
		assertThat(this.restTemplate.getForObject("http://localhost:"+ port +"/netWorthValue?docId=0", Long.class)).isEqualTo(-5755);
	}

}
