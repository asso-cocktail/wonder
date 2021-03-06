/*
 * Copyright (C) NetStruxr, Inc. All rights reserved.
 *
 * This software is published under the terms of the NetStruxr
 * Public Software License version 0.5, a copy of which has been
 * included with this distribution in the LICENSE.NPL file.  */
package er.directtoweb.components.dates;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WORequest;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSValidation;

import er.directtoweb.components.ERDCustomEditComponent;
import er.extensions.eof.ERXConstant;

/**
 * Used to edit a number as if it where a number of years and a number of months.<br />
 * 
 */

public class ERDEditYearsMonths extends ERDCustomEditComponent {

    public ERDEditYearsMonths(WOContext context) { super(context); }

    public boolean isStateless() { return true; }
    public boolean synchronizesVariablesWithBindings() { return false; }

    public final static NSMutableArray _yearList=new NSMutableArray();
    static {
        for(int i = 0; i <100; i++){
            _yearList.addObject(ERXConstant.integerForInt(i));
        }
    }
    public NSArray yearList(){ return (NSArray)_yearList; }

    public final static NSMutableArray _monthList=new NSMutableArray();
    static {
        for(int i = 0; i <12; i++){
            _monthList.addObject(ERXConstant.integerForInt(i));
        }
    }
    public NSArray monthList() { return (NSArray)_monthList; }

    public Number totalNumberOfMonths() {
        return objectPropertyValue()!=null ?(Number)objectPropertyValue(): ERXConstant.ZeroInteger;
    }
    protected Integer numberOfYears;
    public Integer numberOfYears() {
        numberOfYears=(Integer)yearList().objectAtIndex((int)totalNumberOfMonths().intValue()/12);
        return numberOfYears;
    }

    protected Integer numberOfMonths;
    public Integer numberOfMonths() {
        numberOfMonths=(Integer)monthList().objectAtIndex(totalNumberOfMonths().intValue() % 12);
        return numberOfMonths;
    }

    public void takeValuesFromRequest(WORequest q, WOContext c) throws NSValidation.ValidationException {
        super.takeValuesFromRequest(q,c);
        int yearMonths = numberOfMonths != null ? numberOfMonths.intValue() : 0;
        yearMonths += numberOfYears != null ? numberOfYears.intValue()*12 : 0;
        Integer months = ERXConstant.integerForInt(yearMonths);
        try {
            object().validateTakeValueForKeyPath(months,key());
        } catch(Throwable e) {
            validationFailedWithException (e, months, key());
        }
    }
}