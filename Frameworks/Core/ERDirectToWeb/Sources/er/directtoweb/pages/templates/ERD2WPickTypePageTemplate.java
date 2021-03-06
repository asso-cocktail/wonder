/*
 * Copyright (C) NetStruxr, Inc. All rights reserved.
 *
 * This software is published under the terms of the NetStruxr
 * Public Software License version 0.5, a copy of which has been
 * included with this distribution in the LICENSE.NPL file.  */
package er.directtoweb.pages.templates;
import com.webobjects.appserver.WOContext;

import er.directtoweb.pages.ERD2WPickTypePage;

/**
 * Useful for picking the type of something.  A type being a string description and either radio buttons or checkboxes  displayed to the left.<br />
 * @d2wKey formEncoding
 * @d2wKey uiStyle
 * @d2wKey explanationComponentName
 * @d2wKey explanationString
 * @d2wKey noSelectionString
 * @d2wKey pageWrapperName
 */
//DELETEME This looks like a select page? Except for the popup, which I can't imagine makes sense?

public class ERD2WPickTypePageTemplate extends ERD2WPickTypePage {

    public ERD2WPickTypePageTemplate(WOContext context) {super(context);}
}
