#!/usr/bin/perl

$num1 = 15;
$num2 = 22;
$num3 = 35;

$soma1 = $num1 + $num2;
$soma2 = $num2 + $num3;
$soma3 = $num1 + $num3;
$soma4 = ($num1 + $num2) + $num3;
$soma5 = $num1 + ($num2 + $num3);

print "Resultado da soma 1: $soma1 \n";
print "Resultado da soma 2: $soma2 \n";
print "Resultado da soma 3: $soma3 \n";
print "Resultado da soma 4 (comutatividade): $soma4 \n";
print "Resultado da soma 5 (comutativiadde): $soma5 \n";
