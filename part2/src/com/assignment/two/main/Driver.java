package com.assignment.two.main;

import com.assignment.two.model.Company;
import com.assignment.two.service.StockServices;

import java.util.*;

/**
 * You are working as a software engineer in a Financial Company, Stockers.
 * Stockers is a leading MNC that specializes in analyzing a company’s shares and consulting
 * investors/traders.
 * Till today the company is working manually and wants to be digital. As a Software Engineer, you
 * are required to code user stories and create the first version of the application.
 * <p>
 * The Application will accept the no of companies N, that the user wants to store records of.
 * a) Users will enter the share price(double format) of N companies.
 * b) Users will enter a boolean value(TRUE, FALSE) of each company, to keep track of the
 * company’s share price compared to yesterday.
 * <p>
 * The user will enter value through the console.
 * <p>
 * Insight: If today the share price of the company is greater than that of yesterday then the user
 * will input TRUE, else the user will input FALSE. In the given test cases true, false values are
 * entered randomly. You can also input values TRUE/FALSE on your own.
 * <p>
 * USER can perform the following operations in the application:
 * 1. Display the companies stock prices in ascending order
 * 2. Display the companies stock prices in descending order
 * 3. Display the total no of companies for which stock prices rose today
 * 4. Display the total no of companies for which stock prices declined today
 * 5. Search a specific stock price //it will only display whether the stock price is present or not.
 * <p>
 * Note: The time complexity(average, best, worst) of the sorting function used should not be more
 * than O(nlogn).
 */

public class Driver {
    public static void main(String[] args) {
        StockServices stockService = new StockServices();


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no of companies");
        int companiesSize = sc.nextInt();
        Company[] companyArray = new Company[companiesSize];
        double value;
        for (int i = 0; i < companiesSize; i++) {
            Company company = new Company();
            System.out.println("Enter current stock price of the company : " + (i + 1));
            company.setStockPrice(sc.nextDouble());
            System.out.println("Whether company's stock price rose today compare to yesterday?");
            company.setStockVariation(sc.nextBoolean());
            companyArray[i] = company;
        }


        int option;
        do {
            System.out.println("-----------------------------------------------");
            System.out.println("Enter the operation that you want to perform");
            System.out.println("1. Display the companies stock prices in ascending order");
            System.out.println("2. Display the companies stock prices in descending order");
            System.out.println("3. Display the total no of companies for which stock prices rose today");
            System.out.println("4. Display the total no of companies for which stock prices declined today");
            System.out.println("5. Search a specific stock price");
            System.out.println("6. press 0 to exit");
            System.out.println("-----------------------------------------------");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    option = 1;
                    stockService.displayStockPricesAsc(companyArray);
                    break;
                case 2:
                    option = 2;
                    stockService.displayStockPricesDsc(companyArray);
                    break;
                case 3:
                    option = 3;
                    stockService.displayNoOfCompaniesOnARise(companyArray);
                    break;
                case 4:
                    option = 4;
                    stockService.displayNoOfCompaniesOnAFall(companyArray);
                    break;
                case 5:
                    option = 5;
                    System.out.println("enter the key value");
                    value = sc.nextDouble();
                    stockService.searchStockPrice(companyArray, value);
                    break;
            }

        } while (option != 0);
    }

}
