package com.connamara;

import java.time.LocalDate;

import com.opengamma.strata.basics.ReferenceData;
import static com.opengamma.strata.basics.date.BusinessDayConventions.MODIFIED_FOLLOWING;
import com.opengamma.strata.basics.date.BusinessDayAdjustment;
import com.opengamma.strata.basics.date.HolidayCalendarIds;
import com.opengamma.strata.basics.date.AdjustableDate;

/**
 * Example to illustrate using the engine to price a Deliverable Swap Future
 * (DSF).
 * <p>
 * This makes use of the example engine and the example market data environment.
 */
public class DateAdjustmentTool {

    /**
     * Runs the example, pricing the instruments, producing the output as an ASCII
     * table.
     * 
     * @param args start_date
     */
    public static void main(String[] args) {

        LocalDate baseDate = LocalDate.parse(args[0]);
        ReferenceData REF_DATA = ReferenceData.standard();
        BusinessDayAdjustment BDA_FOLLOW_SAT_SUN = BusinessDayAdjustment.of(MODIFIED_FOLLOWING,
                HolidayCalendarIds.SAT_SUN);

        AdjustableDate test = AdjustableDate.of(baseDate, BDA_FOLLOW_SAT_SUN);

        System.out.println(test.adjusted(REF_DATA));
    }

}
