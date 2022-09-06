# LocalDate

LocalDate is a class for handling dates.  It was introduced in Java 8.  Generally, it is better to use LocalDate than the older Java classes for dates.

This document only refers to Java 8 and later.

`LocalDate` has two related classes called `LocalTime` and `LocalDateTime.`

Once you understand the basic functioning of LocalDate it is fairly easy to extend your knowledge to the related classes.

## ISO 8601 date format

The ISO Date format is a standardized way to handle dates.  

Different parts of the world represent dates differently.  This can cause confusion.  For example 9/5/2022 would mean September 5, 2022 in the US, but many parts of Europe would interpret this as 9 May, 2022.

Another problem with the date format is sorting.  It is difficult to sort dates in the traditional format because they must be split into their component parts.

The ISO 8601 standard attempts to rectify these problems as well as a few other minor issues.

The ISO8601 Uses Year-Month-Day format.  This allows dates to be sorted as ordinary strings.  The year must be 4 digits.  The month and date must be 2 digits, with the leading 0 included for values less than 10.  A dash must be used between the fields.

An example would be 2022-09-05.   Dates may also be included in a standard format, but that is not discussed in this document.

## The LocalDate class

Reference: [https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/class-use/LocalDate.html](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/class-use/LocalDate.html)

## A super-simple example

This is a very simple example.  Notices that this example does not use a normal constructor.

```java
import java.time.LocalDate;

public class SimpleDate {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        System.out.println(today);
    }
}
```

This program was run on September 5, 2022.  On that date it produced the following output:

```text
2022-09-05
```

## Making instances of LocalDate

Instances of LocalTime are not usually created with normal constructors.  Instead,there are several methods that are similar to "factory methods."  

Most of these methods are ***static*** which means they are usually called using the name of the class. These are only a few examples.  There are several variations of most of them.

Method|Example|Notes
:---|:---|:---
now()|`LocalDate today = LocalDate.now();`| returns the current date at the geographic location specified by the computer's settings.
of(year, month, date)|`LocalDate d = LocalDate.of(2022,9,5);`|Takes 3 integers representing the year, month, and day number
parse(date as a String)|`LocalDate d = LocalDate.parse("2022-09-05");`|Other formats are possible by specifying a DateTimeFormatter. 

## Formatting date output

### DateTimeFormatter 

The [`format()`](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/LocalDate.html#format(java.time.format.DateTimeFormatter)) is used to format output.  It takes a `DateTimeFormatter` as an argument. 

[DateTimeFormatter](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html) has many predefined formats.  It also allows the programmer to create custom output formats.

### Stardard formats

FormatStyle is an ***enumerated*** data type.  It creates four predefined values.  These values may be used as specified formats.

The four values are capitalized because they are constants.

Constants|Sample Output
:---|:---
FULL|Monday, September 5, 2022
LONG|September 5, 2022
MEDIUM|Sep 5, 2022
SHORT|9/5/22

```java
System.out.println(today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL)));
        System.out.println(today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG)));
        System.out.println(today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)));
        System.out.println(today.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT)));
```

The above produces the following output

```text
Monday, September 5, 2022
September 5, 2022
Sep 5, 2022
9/5/22
```