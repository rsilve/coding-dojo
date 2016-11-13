import sys
import itertools

fizzes = itertools.cycle(["","", "Fizz"])
buzzes = itertools.cycle(["","","","","Buzzes"])
numbers = itertools.count(1)

fizzbuzz = itertools.imap(
    lambda x:"%s%s" % x,
    itertools.izip(fizzes, buzzes)
)

fizzbuzz_or_numbers = itertools.imap(
    lambda (fb, n): n if fb == '' else fb,
    itertools.izip(fizzbuzz, numbers)
)


def run_fizzbuzz(n):
    for x in itertools.islice(fizzbuzz_or_numbers, n):
        print x

if __name__ == "__main__":
    run_fizzbuzz(int(sys.argv[1]))
