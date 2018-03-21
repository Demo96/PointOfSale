package mypackage;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ LcdDisplayTest.class, PrinterTest.class, ProductDaoTest.class, SimplePointOfSaleTest.class })
public class AllTests {

}
