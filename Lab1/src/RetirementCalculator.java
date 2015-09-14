// Mayah McCutchen and Osman Sabahat 
import java.util.Scanner;

import org.apache.poi.ss.formula.functions.FinanceLib;

public class RetirementCalculator {

	private static Scanner sc;

	public static void main(String[] args) {

		// Variables for finance calculations

		double r;
		double n;
		double p;
		double y;
		double f;
		boolean t;

		// Variables for input

		sc = new Scanner(System.in);
		System.out.println("How many years do you plan to work?:  ");
		double YearsToWork = sc.nextDouble();
		System.out.println("What is your expected average return on investment?: ");
		double AnnualReturn = sc.nextDouble();
		System.out.println("How long do you want to draw after retirement?: ");
		double YearsToDraw = sc.nextDouble();
		System.out.println("What is your annual return?: ");
		double InvestmentReturn = sc.nextDouble();
		System.out.println("What is your required income?: ");
		double RequiredIncome = sc.nextDouble();
		System.out.println("What is your expected SSI?: ");
		double SSI = sc.nextDouble();

		// Finance.lib calculations

		double PV;
		r = (AnnualReturn / 12);
		n = YearsToDraw * 12;
		y = RequiredIncome - SSI;
		f = 0;
		t = false;
		
		// Prints out PV calculation based on user input.
		
		PV = FinanceLib.pv(r, n, y, f, t);
		System.out.printf("You need to save $%4.2f in total.", PV);

		double PMT;
		r = InvestmentReturn / 12;
		n = YearsToWork * 12;
		p = 0;
		f = PV;
		t = false;
		
		// Prints out PMT calculation based on user input.
		
		PMT = FinanceLib.pmt(r, n, p, f, t);
		System.out.printf(" You need to save $%4.2f each month.", PMT);
	}

}
