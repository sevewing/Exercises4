public class CashRegisterTest {
	static java.io.PrintStream orgout;
	static RecordingOutputStream record;
	@org.junit.BeforeClass
	public static void setUpStdOut() {
		orgout = System.out;
		record = new RecordingOutputStream(orgout);
		System.setOut(new java.io.PrintStream(record));
	}
	@org.junit.AfterClass
	public static void tearDownStdOut() {
		System.setOut(orgout);
		record = null;
	}
	@org.junit.Test
	public void test1() {
		record.start();
		CashRegister cashRegister = new CashRegister("input/prices.txt", "input/discounts.txt");
		cashRegister.printReceipt("bar1.txt");
		org.junit.Assert.assertEquals("\n" +
		"             * MEJERI *\n" +
		"SKUMMETMÆLK\n" +
		"  2 x 5,95                      11,90\n" +
		"\n" +
		"         * ØVR. FØDEVARER *\n" +
		"HAVREGRYN                       11,95\n" +
		"\n" +
		"-------------------------------------\n" +
		"\n" +
		"SUBTOT                          23,85\n" +
		"\n" +
		"TOTAL                           23,85\n" +
		"\n" +
		"KØBET HAR UDLØST 0 MÆRKER\n" +
		"\n" +
		"MOMS UDGØR                       4,77\n" +
		"\n", record.stop().replaceAll("\r",""));
	}
	@org.junit.Test
	public void test2() {
		record.start();
		CashRegister cashRegister = new CashRegister("input/prices.txt", "input/discounts.txt");
		cashRegister.printReceipt("bar2.txt");
		org.junit.Assert.assertEquals("\n" +
		"             * MEJERI *\n" +
		"SKUMMETMÆLK\n" +
		"  10 x 5,95                     59,50\n" +
		"\n" +
		"-------------------------------------\n" +
		"\n" +
		"SUBTOT                          59,50\n" +
		"\n" +
		"TOTAL                           59,50\n" +
		"\n" +
		"KØBET HAR UDLØST 1 MÆRKER\n" +
		"\n" +
		"MOMS UDGØR                      11,90\n" +
		"\n", record.stop().replaceAll("\r",""));
	}
	@org.junit.Test
	public void test3() {
		record.start();
		CashRegister cashRegister = new CashRegister("input/prices.txt", "input/discounts.txt");
		cashRegister.printReceipt("bar3.txt");
		org.junit.Assert.assertEquals("\n" +
		"             * MEJERI *\n" +
		"SKUMMETMÆLK\n" +
		"  2 x 5,95                      11,90\n" +
		"\n" +
		"         * ØVR. FØDEVARER *\n" +
		"HAVREGRYN\n" +
		"  3 x 11,95                     35,85\n" +
		"RABAT                            5,85-\n" +
		"\n" +
		"-------------------------------------\n" +
		"\n" +
		"SUBTOT                          47,75\n" +
		"\n" +
		"RABAT                            5,85\n" +
		"\n" +
		"TOTAL                           41,90\n" +
		"\n" +
		"KØBET HAR UDLØST 0 MÆRKER\n" +
		"\n" +
		"MOMS UDGØR                       8,38\n" +
		"\n", record.stop().replaceAll("\r",""));
	}
	@org.junit.Test
	public void test4() {
		record.start();
		CashRegister cashRegister = new CashRegister("input/prices.txt", "input/discounts.txt");
		cashRegister.printReceipt("bar4.txt");
		org.junit.Assert.assertEquals("\n" +
		"             * BOLIG *\n" +
		"JULEKORT                        29,95\n" +
		"\n" +
		"          * DRIKKEVARER *\n" +
		"BLANDET SAFT\n" +
		"  2 x 19,95                     39,90\n" +
		"RABAT                           19,90-\n" +
		"\n" +
		"           * ELEKTRONIK *\n" +
		"BATTERIER\n" +
		"  3 x 32,95                     98,85\n" +
		"RABAT                           26,85-\n" +
		"\n" +
		"         * FRUGT & GRØNT *\n" +
		"KARTOFLER OVN & MOS             18,00\n" +
		"ØKO GULERØDDER                  10,00\n" +
		"\n" +
		"             * MEJERI *\n" +
		"FRILANDSÆG                      25,95\n" +
		"KÆRGÅRDEN                       14,95\n" +
		"SKUMMETMÆLK\n" +
		"  3 x 5,95                      17,85\n" +
		"SKYR YOGHURT\n" +
		"  2 x 22,75                     45,50\n" +
		"RABAT                           19,50-\n" +
		"VORES PISKEFLØDE                16,50\n" +
		"\n" +
		"        * PLANTER/BLOMSTER *\n" +
		"LER 2 KG                         6,00\n" +
		"\n" +
		"            * SLAGTER *\n" +
		"HAMBURGERRYG                    13,95\n" +
		"RABAT                            3,95-\n" +
		"HK SVIN/KALV                    21,95\n" +
		"\n" +
		"         * ØVR. FØDEVARER *\n" +
		"BLØD NUGAT 150G                 26,25\n" +
		"BØNNEKAFFE                      55,50\n" +
		"GRØNLANGKÅL                     28,00\n" +
		"RABAT                           10,00-\n" +
		"KERNEBRØD                       20,75\n" +
		"\n" +
		"-------------------------------------\n" +
		"\n" +
		"SUBTOT                         489,85\n" +
		"\n" +
		"RABAT                           80,20\n" +
		"\n" +
		"TOTAL                          409,65\n" +
		"\n" +
		"KØBET HAR UDLØST 8 MÆRKER\n" +
		"\n" +
		"MOMS UDGØR                      81,93\n" +
		"\n", record.stop().replaceAll("\r",""));
	}
	@org.junit.Test
	public void test5() {
		record.start();
		CashRegister cashRegister = new CashRegister("input/prices.txt", "input/discounts.txt");
		cashRegister.printReceipt("bar5.txt");
		org.junit.Assert.assertEquals("\n" +
		"          * DRIKKEVARER *\n" +
		"COCA COLA 1.5L\n" +
		"  2 x 20,00                     40,00\n" +
		"RABAT                           20,00-\n" +
		"\n" +
		"         * FRUGT & GRØNT *\n" +
		"CHERRY TOMATER                   5,00\n" +
		"DK AGURK                        15,00\n" +
		"ESTRAGON I BK                   18,00\n" +
		"RØDE ÆBLER\n" +
		"  4 x 2,50                      10,00\n" +
		"SPINAT                          20,00\n" +
		"VILDMO. 2 KG                    22,00\n" +
		"RABAT                           12,00-\n" +
		"ØKO SKALOTTELØG 250G            15,00\n" +
		"\n" +
		"             * MEJERI *\n" +
		"KÆRGÅRDEN\n" +
		"  3 x 14,95                     44,85\n" +
		"RABAT                           20,85-\n" +
		"PARMIGIANO                      49,95\n" +
		"RABAT                            9,95-\n" +
		"ÆGGEHVIDER                      11,95\n" +
		"\n" +
		"         * PANT&BÆREPOSER *\n" +
		"PANT\n" +
		"  2 x 3,00                       6,00\n" +
		"\n" +
		"        * PERSONLIG PLEJE *\n" +
		"NIVEA LOTION                    50,00\n" +
		"\n" +
		"            * SLAGTER *\n" +
		"GRAVAD ØRRED                    59,95\n" +
		"RABAT                           20,95-\n" +
		"NY STRIP                        80,00\n" +
		"US RIBEYE                       80,00\n" +
		"\n" +
		"         * ØVR. FØDEVARER *\n" +
		"DANSKE MAKRONER                  6,95\n" +
		"DGR SOLSIKKE                    20,95\n" +
		"FROSNE JORDBÆR\n" +
		"  2 x 20,00                     40,00\n" +
		"RABAT                            8,00-\n" +
		"KIMS CRUNCH CUT                 22,00\n" +
		"OLIVENOLIE                      66,00\n" +
		"PINJEKERNER 28 G\n" +
		"  2 x 20,00                     40,00\n" +
		"TOBLERONE50G                     9,95\n" +
		"RABAT                            3,95-\n" +
		"ØKO HAK TOMAT                    4,95\n" +
		"\n" +
		"-------------------------------------\n" +
		"\n" +
		"SUBTOT                         738,50\n" +
		"\n" +
		"RABAT                           95,70\n" +
		"\n" +
		"TOTAL                          642,80\n" +
		"\n" +
		"KØBET HAR UDLØST 12 MÆRKER\n" +
		"\n" +
		"MOMS UDGØR                     128,56\n" +
		"\n", record.stop().replaceAll("\r",""));
	}
	@org.junit.Test
	public void test6() {
		record.start();
		CashRegister cashRegister = new CashRegister("input/prices.txt", "input/discounts.txt");
		cashRegister.printReceipt("bar6.txt");
		org.junit.Assert.assertEquals("\n" +
		"             * BOLIG *\n" +
		"GAVEPAPIR 70CM x1.5M            30,00\n" +
		"KOPIPAPIR 1-PAK                 50,95\n" +
		"\n" +
		"          * DRIKKEVARER *\n" +
		"RYNKEBY 1 L\n" +
		"  2 x 13,95                     27,90\n" +
		"SCHWEPPES LEMON 1.5L            21,00\n" +
		"RABAT                           11,00-\n" +
		"\n" +
		"         * FRUGT & GRØNT *\n" +
		"CITRONER LØSE                    5,00\n" +
		"\n" +
		"             * MEJERI *\n" +
		"RIBERHUS 1950                   65,95\n" +
		"\n" +
		"         * PANT&BÆREPOSER *\n" +
		"PANT                             3,00\n" +
		"\n" +
		"            * SLAGTER *\n" +
		"FETUCCINE                       13,95\n" +
		"RULLEPØLSE                      14,95\n" +
		"RABAT                            4,95-\n" +
		"TAGLIOLINI                      14,95\n" +
		"RABAT                            4,90-\n" +
		"WHISKY SAUCE\n" +
		"  2 x 19,50                     39,00\n" +
		"RABAT                           17,00-\n" +
		"\n" +
		"         * ØVR. FØDEVARER *\n" +
		"CLOETTA JULESKUM                16,95\n" +
		"DGR SOLSIKKE                    20,95\n" +
		"GRØNLANGKÅL                     28,00\n" +
		"RABAT                           10,00-\n" +
		"HELBL. SPINAT                   22,00\n" +
		"OVERTRÆK200G                    34,95\n" +
		"SKUMBANANER MEGASIZE            50,00\n" +
		"UNCLE BENS                      19,95\n" +
		"ØKO HAK TOMAT\n" +
		"  3 x 4,95                      14,85\n" +
		"\n" +
		"-------------------------------------\n" +
		"\n" +
		"SUBTOT                         494,30\n" +
		"\n" +
		"RABAT                           47,85\n" +
		"\n" +
		"TOTAL                          446,45\n" +
		"\n" +
		"KØBET HAR UDLØST 8 MÆRKER\n" +
		"\n" +
		"MOMS UDGØR                      89,29\n" +
		"\n", record.stop().replaceAll("\r",""));
	}
	@org.junit.Test
	public void test7() {
		record.start();
		CashRegister cashRegister = new CashRegister("input/prices.txt", "input/discounts.txt");
		cashRegister.printReceipt("bar0.txt");
		org.junit.Assert.assertEquals("\n" +
		"             * BOLIG *\n" +
		"8 JULEFRYD JULEKORT             24,95\n" +
		"DVH MINIKORT BØRN               10,00\n" +
		"DVH MINIKORT NEUTRAL            10,00\n" +
		"GAVEPAPIR 70CM x1.5M\n" +
		"  2 x 30,00                     60,00\n" +
		"JULEKORT                        29,95\n" +
		"KOPIPAPIR 1-PAK                 50,95\n" +
		"MINIKORT                        10,00\n" +
		"\n" +
		"          * DRIKKEVARER *\n" +
		"BLANDET SAFT\n" +
		"  2 x 19,95                     39,90\n" +
		"RABAT                           19,90-\n" +
		"COCA COLA 1.5L                  20,00\n" +
		"RABAT                           10,00-\n" +
		"COCA COLA ZERO 1.5L             20,00\n" +
		"RABAT                           10,00-\n" +
		"RYNKEBY 1 L                     13,95\n" +
		"RYNKEBY DRIK\n" +
		"  2 x 28,95                     57,90\n" +
		"RABAT                           27,90-\n" +
		"SCHWEPPES LEMON 1.5L            21,00\n" +
		"RABAT                           11,00-\n" +
		"\n" +
		"           * ELEKTRONIK *\n" +
		"BATTERIER\n" +
		"  3 x 32,95                     98,85\n" +
		"RABAT                           26,85-\n" +
		"\n" +
		"         * FRUGT & GRØNT *\n" +
		"BLOMMETOMATER                   16,00\n" +
		"CHERRY TOMATER\n" +
		"  2 x 5,00                      10,00\n" +
		"CITRONER LØSE                    5,00\n" +
		"DK AGURK                        15,00\n" +
		"ESTRAGON I BK                   18,00\n" +
		"KARTOFLER OVN & MOS             18,00\n" +
		"RØDE ÆBLER\n" +
		"  3 x 2,50                       7,50\n" +
		"SPINAT                          20,00\n" +
		"TOMATER I SPAND                 20,00\n" +
		"VILDMO. 2 KG                    22,00\n" +
		"RABAT                           12,00-\n" +
		"ØKO GULERØDDER                  10,00\n" +
		"ØKO SKALOTTELØG 250G            15,00\n" +
		"ØKO TOMATER I SPAND             20,00\n" +
		"\n" +
		"             * MEJERI *\n" +
		"10 ØKO ÆG                       30,95\n" +
		"FRILANDSÆG                      25,95\n" +
		"KÆRGÅRDEN\n" +
		"  3 x 14,95                     44,85\n" +
		"RABAT                           20,85-\n" +
		"PARMIGIANO                      49,95\n" +
		"RABAT                            9,95-\n" +
		"RIBERHUS 1950                   65,95\n" +
		"SKUMMETMÆLK\n" +
		"  3 x 5,95                      17,85\n" +
		"SKYR YOGHURT\n" +
		"  2 x 22,75                     45,50\n" +
		"RABAT                           19,50-\n" +
		"VORES PISKEFLØDE                16,50\n" +
		"ÆGGEHVIDER                      11,95\n" +
		"ØKO KÆRNE                        9,85\n" +
		"\n" +
		"         * PANT&BÆREPOSER *\n" +
		"PANT                             3,00\n" +
		"\n" +
		"        * PERSONLIG PLEJE *\n" +
		"NIVEA LOTION                    50,00\n" +
		"\n" +
		"        * PLANTER/BLOMSTER *\n" +
		"JULESTJERNE                     50,00\n" +
		"LER 2 KG                         6,00\n" +
		"\n" +
		"            * SLAGTER *\n" +
		"FETUCCINE                       13,95\n" +
		"GRAVAD ØRRED                    59,95\n" +
		"RABAT                           20,95-\n" +
		"HAMBURGERRYG                    13,95\n" +
		"RABAT                            3,95-\n" +
		"HAMBURGERRYG HEL                75,95\n" +
		"HK SVIN/KALV                    21,95\n" +
		"HK. OKSE 7-10%                  79,90\n" +
		"RABAT                           34,90-\n" +
		"KAMSTEG                         16,50\n" +
		"RABAT                            6,50-\n" +
		"NY STRIP                        80,00\n" +
		"ROASTBEEF\n" +
		"  2 x 15,95                     31,90\n" +
		"RABAT                            9,90-\n" +
		"RULLEPØLSE                      14,95\n" +
		"RABAT                            4,95-\n" +
		"TAGLIOLINI                      14,95\n" +
		"RABAT                            4,90-\n" +
		"US RIBEYE                       80,00\n" +
		"WHISKY SAUCE\n" +
		"  2 x 19,50                     39,00\n" +
		"RABAT                           17,00-\n" +
		"ÅRSTIDENS 3-STJERNET            19,95\n" +
		"RABAT                            9,95-\n" +
		"\n" +
		"         * ØVR. FØDEVARER *\n" +
		"BLØD NUGAT 150G                 26,25\n" +
		"BØNNEKAFFE\n" +
		"  2 x 55,50                    111,00\n" +
		"RABAT                           21,00-\n" +
		"CLOETTA JULESKUM                16,95\n" +
		"CRYSLI CHOKO\n" +
		"  2 x 36,00                     72,00\n" +
		"RABAT                           24,00-\n" +
		"DANSKE MAKRONER                  6,95\n" +
		"DGR SOLSIKKE                    20,95\n" +
		"FROSNE JORDBÆR\n" +
		"  2 x 20,00                     40,00\n" +
		"RABAT                            8,00-\n" +
		"GRØNLANGKÅL                     28,00\n" +
		"RABAT                           10,00-\n" +
		"GULDKORN                        34,00\n" +
		"RABAT                            9,00-\n" +
		"HAVREGRYN\n" +
		"  2 x 11,95                     23,90\n" +
		"RABAT                            3,90-\n" +
		"HELBL. SPINAT                   22,00\n" +
		"HONNINGSNITTER                  13,95\n" +
		"KARTOFFEL/PORRESUPPE            22,00\n" +
		"RABAT                            7,00-\n" +
		"KERNEBRØD                       20,75\n" +
		"KIM'S CHIPS                     22,00\n" +
		"KIMS CRUNCH CUT                 22,00\n" +
		"KONFEKT ABRIKOSSMAG             20,00\n" +
		"KÄRNSUND                        21,95\n" +
		"MARCIPANSNITTER                 27,95\n" +
		"MAYONAISE                       21,00\n" +
		"MOU BLOMKÅLSSUPPE               22,00\n" +
		"RABAT                            7,00-\n" +
		"NESTLE CHERR                    35,00\n" +
		"OLIVENOLIE                      66,00\n" +
		"OVERTRÆK200G                    34,95\n" +
		"PINJEKERNER 28 G                20,00\n" +
		"REMOULADE                       20,00\n" +
		"RABAT                           11,00-\n" +
		"RÅ MARCIPAN                     69,95\n" +
		"RABAT                           20,95-\n" +
		"S. C. OG DILD                   22,00\n" +
		"SKUMBANANER MEGASIZE            50,00\n" +
		"STJERNE MIX                     35,95\n" +
		"TOBLERONE50G                     9,95\n" +
		"RABAT                            3,95-\n" +
		"TOMS SNEBOLDE                   29,95\n" +
		"RABAT                            5,00-\n" +
		"TORSKEROGT\n" +
		"  2 x 17,00                     34,00\n" +
		"UNCLE BENS                      19,95\n" +
		"VIKING                          16,95\n" +
		"ØKO HAK TOMAT\n" +
		"  4 x 4,95                      19,80\n" +
		"\n" +
		"        * ØVR. HUSHOLDNING *\n" +
		"NEUTRAL FL.                     39,95\n" +
		"RABAT                           14,95-\n" +
		"\n" +
		"-------------------------------------\n" +
		"\n" +
		"SUBTOT                        2795,15\n" +
		"\n" +
		"RABAT                          426,70\n" +
		"\n" +
		"TOTAL                         2368,45\n" +
		"\n" +
		"KØBET HAR UDLØST 47 MÆRKER\n" +
		"\n" +
		"MOMS UDGØR                     473,69\n" +
		"\n", record.stop().replaceAll("\r",""));
	}
	static class RecordingOutputStream extends java.io.OutputStream {
		private final java.io.OutputStream out;
		private byte[] buffer = new byte[1 << 10];
		private int size = -1;

		public RecordingOutputStream(java.io.OutputStream out) {
			this.out = out;
		}

		@Override
		public void write(int b) throws java.io.IOException {
			if (size >= 0) {
				if (size == buffer.length) {
					buffer = java.util.Arrays.copyOf(buffer, size * 2);
				}
				buffer[size++] = (byte) b;
			} else {
				out.write(b);
			}
		}

		public void start() {
			size = 0;
		}

		public String stop() {
			String retval = new String(buffer, 0, size);
			size = -1;
			return retval;
		}
	}
	public static void main(String[] args) {
		org.junit.runner.Result result = org.junit.runner.JUnitCore.runClasses(CashRegisterTest.class);
		for (org.junit.runner.notification.Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
			break;
		}
		System.out.printf("Tests run: %d,  Failures: %d\n", result.getRunCount(), result.getFailureCount());
	}
}
