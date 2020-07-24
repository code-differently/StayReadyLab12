# Open/Close Checker

## Objectives

* Demonstate understanding and usage of the Stack Collection
* Unit Tests

## Part 1 - Parenthesis Checker:

Create a class with a method that accepts a string value as a parameter. This method verifies all parenthesis `()` within the string are paired. That is, if there is an opening parenthesis `(` there needs to be a corresponding closing parenthesis `)` 

**Example**

input: `"a(b)c(d)e(f)g"`

output: `true`

-

input: `")"`

output: `false`

-

input: `"a(bcd(ef))"`

output: `true`

-

input: `"a(bc(d)))"'

output: `false`


## Part 2 - Expanded Checker:

Now expand the functionality to check that all opening characters have a closing one.

Characters include `()` `{}` `[]` `<>` `""` `''`

As another example, consider the IDE and how it checks your code to make sure all your encapsulating characters are opened and closed in order