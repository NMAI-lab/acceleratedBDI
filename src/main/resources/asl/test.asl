/*
 * Simple agent behaviour for the BDI acceleration testing project
 * @author	Patrick Gavigan
 * @date	2 July 2019
 */

// Initial Goals
!respond.

// Main Plans

+!respond
	:	fact(X)
	<-	reply(X);
		!respond.

+!respond
	:	not fact(X)
	<-	noFacts;
		!respond.
