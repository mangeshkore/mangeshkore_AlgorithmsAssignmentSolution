package com.assignment.two.service;

import com.assignment.two.model.Company;

import static com.assignment.two.utils.Constants.ASC;
import static com.assignment.two.utils.Constants.DSC;

public class StockServices {
    public void displayStockPricesAsc(Company[] companyArray) {
        mergeSort(companyArray, ASC);
        System.out.println("Stock prices in ascending order are :");
        displayCompanies(companyArray);
    }

    public void displayStockPricesDsc(Company[] companyArray) {
        mergeSort(companyArray, DSC);
        System.out.println("Stock prices in descending order are :");
        displayCompanies(companyArray);
    }

    public void displayNoOfCompaniesOnARise(Company[] companyArray) {
        System.out.println("Total no of companies whose stock price rose today : " + countCompaniesForGrowth(companyArray, true));
    }

    public void displayNoOfCompaniesOnAFall(Company[] companyArray) {
        System.out.println("Total no of companies whose stock price declined today : " + countCompaniesForGrowth(companyArray, false));
    }

    private int countCompaniesForGrowth(Company[] companyArray, boolean b) {
        int count = 0;
        for (Company company : companyArray) {
            if ((b && company.isStockVariation()) || (!b && !company.isStockVariation()))
                count++;
        }
        return count;
    }

    public void searchStockPrice(Company[] companyArray, double value) {
        mergeSort(companyArray, ASC);
        int l, r, mid;
        l = 0;
        r = companyArray.length - 1;
        mid = l + (r - l) / 2;
        while (l <= r) {
            if (value < companyArray[mid].getStockPrice()) {
                // range is l to mid-1
                r = mid - 1;
            } else if (value > companyArray[mid].getStockPrice()) {
                // range is mid+1 to r
                l = mid + 1;
            } else {
                System.out.println("Stock of value " + value + " is present");
                break;
            }
            mid = l + (r - l) / 2;
        }
        if (l > r) {
            System.out.println("Value not found");
        }
    }


    /**
     * Dedicated function to display companies stock prices.
     *
     * @param companyArray array containing company objects
     */
    private void displayCompanies(Company[] companyArray) {
        for (Company company : companyArray) {
            System.out.println(company.getStockPrice());
        }
    }

    /**
     * @param companyArray array containing company objects
     * @param order ascending/descending order
     */
    private void mergeSort(Company[] companyArray, String order) {
        if (order.equalsIgnoreCase(DSC))
            sortArray(companyArray, 0, companyArray.length - 1, DSC);
        else
            sortArray(companyArray, 0, companyArray.length - 1, ASC);
    }

    public void sortArray(Company[] array, int left, int right, String order) {
        if (left < right) {
            int m = left + (right - left) / 2;
            sortArray(array, left, m, order);
            sortArray(array, m + 1, right, order);
            merge(array, left, m, right, order);
        }
    }

    public void merge(Company[] array, int l, int m, int r, String order) {
        int n1 = m - l + 1;
        int n2 = r - m;
        Company[] L = new Company[n1];
        Company[] R = new Company[n2];
        for (int i = 0; i < n1; ++i) {
            L[i] = array[l + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = array[m + 1 + j];
        }
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (order.equalsIgnoreCase(ASC)) {
                if (L[i].getStockPrice() <= R[j].getStockPrice()) {
                    array[k] = L[i];
                    i++;
                } else {
                    array[k] = R[j];
                    j++;
                }
                k++;
            }
            if (order.equalsIgnoreCase(DSC)) {
                if (L[i].getStockPrice() >= R[j].getStockPrice()) {
                    array[k] = L[i];
                    i++;
                } else {
                    array[k] = R[j];
                    j++;
                }
                k++;
            }
        }
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }
}
