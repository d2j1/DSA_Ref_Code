what is a factor - 

 If N  is a natural number, A factor is a no that divides N without leaving a remainder.
 
 N =12, factors = 1, 2, 3, 4, 6, 12
 
 Count no of factors of a given no N, N >0.
 
N % f == 0 then f is the factor of no N.

The minimum value of the factor is 1.

and the maximum value of the factor will be N.

Q. Count the number of factors in N.

 code - 
 
 N=12;
 
  cnt = 0
  
  for( int i =1; i <= n; i++){
  
  if( N % i == 0 ) 
  cnt++;
  }
  
What is iteration? It is the number of times the for loop will run.
  
in this case, no of iterations will be N as the loop is starting from the 1.
  
Assumption - every server is capable of running 10^8 iterations in 1 Sec.
 
if a * b = N then we can say that a and b both can be the factors of N.
 
for N = 24 
 
a	b
1	24
2	12
3	8
4	6

6	4
8	3
12	2
24	1

after a becomes greater than b then factors start repeating.

so we will count the no of factors till a <= b.

so instead of iterating from 1 to N, lets iterate till a <= b.

so we can say at some point b will be equal to a.

a <= N/a

a * a <= N
 
 code - 
 
 cnt =0;
 
 for( a=1; a*a <= n ; a++) {
 
 if( n % a == 0) {
 
 b = n/a;

if( a ==b){
cnt++;
}else{
 cnt = cnt+2;
 }
}
}

no of iterations in the above code is sqrt of N.

What is prime no - 

  Given N, check if N is prime or not.
 Prime no  - this no has the count of factors == 2 and the prime number is a natural no.
 
Note - In problem-solving when we are finding out the definition of something we have to think about all the corner cases, everything that’s possible.
 
prime no is a no divisible by 1 and itself only.
 
1) 1 and itself as a factor
2) no of factors > 2
3) no of factors == 2
 
 
from definition no 1, one is a prime no but one is not a prime no.
 
definition 3 works for all cases including one, so we will go with the 3rd definition.
 
 
Q. write a code to check whether no is prime or not.
 
 
cnt=0;
 
for(int i =1; i <= n; i++){
 
if( n%i == 0)
cnt++; // counting no of factors.
}
 
if( cnt == 2)
print("no is prime no");
else
print("No is not prime no");
 
 
Time complexity analysis of the above brute force -
 
Note - 10^8 iterations happen in 1 second. and for time analysis only loops are considered as other statements take constant time.
 
For value N above, the loop runs for N times ( i.e. N Iterations).
 
so for input 10^9, 10^9 iterations are performed so the time taken to solve this question for provided input is 10^9 / 10^8  seconds.
 
so it will take 10 seconds to solve for the above input.
 

 
 
if input is 10^18 then 10^18 iterations will occure and time taken by it is 10^18 / 10^8 = 10^10 seconds which is approximately 317 years.
 
factors always occur in pairs-
for n =16
 
1 * 16
2 * 8
4 * 4
8 * 2
16 * 1
 
after sqrt(n) factor starts repeating. 
 

 ![alt text](image.png)
 
we get all the factors in part 1 where A <= B only, there is no need to search for factors in the second part where A > B.
 
for part 1  a <= b
 
for the above condition to become true, the max value of a will be b.
 
a * b = n
at the maximum value - b * b = n = b^2 = n.
value of b will become sqrt(n).
 
part 1 is going to end at a = sqrt(n).
 
Code - 

 
 cnt =0;
 
 for( a=1; a*a <= n ; a++) {
 
 if( n % a == 0) {
 
 b = n/a;

if( a ==b){
cnt++;
}else{
 cnt = cnt+2;
 }
}
}

if ( cnt ==2 ) 
print("Yes no is prime no");
else
print("No no is not prime");

no of iterations = sqrt(n)


 
Defination of prime no -
 
1 to n - no of factors == 2
 
1 to sqrt(n) - no of factors == 1
 
2 to sqrt(n) - no of factors == 0
 
for(int i =2 ; i * i <= n ; i++){
if( n% i ==0)
{
return false; // no is not prime
}
}
return true; // It is prime no.
 
above code runs for sqrt(n) times.
 
if our input is 10^10 then sqrt(10^10 ) iterations will occure and it will take 10^5/10^8 = 10^-3 = 1 milli seconds to find the ans.
 
 
and for 10^18, 10^9 iterations will occure, which will take 10^9/10^8 = 10 seconds to get the output.
 
We have to have great observation to solve problems. by using observations we can solve them in an optimised way.
 
Sum of first n natural nos = n * ( n +1) / 2
 
gauss derived the above formula
 
Q. Given n, how many times do we need to divide by 2 to make it 1 ?
 
15/2 -> 7/2 -> 3/2 -> -> 1  3 times we have to divide by 2.
 
how many times you will have to divide 2^n by 2 to make it 1 -. n times.
 
for any no n,
2^x = n
x = logn to the base 2.
 
a^x = n -> x = logn to the base a.
  
so given n, how many times do we need to divide by 2 to make it 1?
 
 ans = floor( logn to the base 2)
 
Interview question -
Q. find the Square root of a no (perfect square).
 
for n =100, the square root can be from 1 to 100.
 
for( int i =1; i <=n;i++){
 
// check if i is a square root
if( i* i == n)
{ print( i) ;
break;
}
}
 
above loop runs sqrt(n) times.
 
there fore no of iterations = sqrt(n).
 
n = 10^10 iterations = 10^5, time taken will be 10^5/10^8 = 1 mili seconds.
 
n=10^18, iterations = 10^9, time taken = 10 second.
 
 Optimized - 

code -
 
l=1
r=n
 
while( l <= r){
 
mid = l+r /2;
 
if(mid * mid == n){
// found sqrt of n
print(mid);
break;
}
else if( mid * mid > n){
// search in left side
r=mid-1;
}
else {
 
// search in right side
l= mid+1;
}
}
 
TC - log(n)
SC - o(1)
 
conclusion -
 
reduce the no of iterations to optimize the solution.
 
by using observations we can reduce the no of iterations and dry run the code to understand  it completely.
