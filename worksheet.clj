;; clojinc
;; Steps toward clojure, starting from zero.
;; by Lee Spector <lspector@hampshire.edu>, 2011-2012
;; Version (date): 20120825

;; This file is a saved, re-executable Clojure REPL (Read Eval Print Loop) 
;; session, with minimal comments and occasional problem sets. It is intended
;; to serve as the starting-point for semi-independent learning of the Clojure
;; programming language, for people who have at least some minimal experience
;; with at least one (any) programming language. No help is provided here for
;; getting a Clojure implementation/REPL up and running; consult the online
;; resources listed below, or search the web, if you need help with that.

;; The format of this file is alternating Clojure expressions with 
;; commented-out output (including both the output produced by explicit print  
;; statements and the values returned by the evaluated expressions). You should 
;; be able to proceed through the file, evaluating an expression at a time, and   
;; if you do this you should get the same output (or similar output, in cases 
;; that involve nondeterminism). In many cases later expressions rely on having
;; evaluated earlier expressions in the file.

;; The material in this file is informal and idiosyncratic in its coverage, 
;; leaving out many things that other Clojure introductions include and revealing 
;; the Lisp-oriented bias of the author. The intention is just to lead beginners
;; deeply enough into Clojure territory for them to proceed in other directions
;; on their own.

;; More specifically, we begin with simple expressions for arithmetic and list
;; manipulation, introduce facilities for defining functions and macros, and give
;; progressively more complex examples of definitions that involve many of
;; Clojure's data structures including lists, vectors, maps, and sets. Among the
;; applications used for examples and problem sets are grammar-driven text
;; generation, genetic programming, and simple graphics. We also demonstrate
;; alternatives for defining iterative and recursive algorithms and briefly touch
;; upon topics ranging from debugging and profiling to file I/O and concurrency. 

;; Many things are introduced here without explanation. My suggestion is that 
;; you observe the output that is provided here, look things up in online resources 
;; and in documentation that may be available in your Clojure environment, and, 
;; most crucially, experiment with variations of the expressions presented here. 
;; The problem sets are prods for further experimentation but it is best to  
;; experiment continuously. Some of the problems provided here are easy, some are 
;; quite hard, and many could be completed/varied/extended in several different
;; ways.

;; Potentially useful online resources include:

;; http://clojure.org
;; http://dev.clojure.org/display/doc/Getting+Started
;; http://groups.google.com/group/clojure
;; http://4clojure.com
;; http://clojuredocs.org
;; http://www.clojure-toolbox.com
;; http://www.clojureatlas.com
;; http://alexott.net/en/clojure/video.html
;; http://planet.clojure.in/

;; Most of the outputs in clojinc were created using clojure version 1.3 in a
;; REPL started with Leiningen 1.7.1 (https://github.com/technomancy/leiningen)
;; and using Java 1.6.0_33. (A few were left from an earlier version, for which
;; Clooj (https://github.com/arthuredelstein/clooj) was used.

;; create the namespace within which we'll work

(ns clojinc.core)
0
(inc 0)
(inc (inc 0))
(dec 2)
(dec 0)
(+ 1 1)
+
(* 23 13)
(+ 1 (* 23 13))
(+ (* 2 2) (- 10 9))
(* 2 2 2 2)
(/ 25 5)
(/ 38 4)
(+ 1/3 1/3)
(+ (/ 1.0 3.0)
   (/ 1.0 3.0))
(/ 23 0) ;; nope
(* 123456789 987654321 999999999 12345678987654321)
(* 123456789M 987654321 999999999 12345678987654321)
(sqrt (* 2 2 2 2))
(Math/sqrt (* 2 2 2 2))  ;; from java.lang.Math
(Math/sqrt -4) ;; nope
(Math/log 2)
(Math/sqrt 1000000)
Math/PI  ;; this is a java interop form, for the PI static field of the Math class
(def my-favorite-number 23)
my-favorite-number
(* my-favorite-number Math/PI)
(use 'clojure.inspector)
(inspect my-favorite-number)

; < window opens in the clojure.main application>
;; Problem Set 1: 
;; - Write an expression that calculates the number of seconds in a year.
;; - Define diameter to be some number and write expression that calculates the area
;;   of a circle with that diameter.
;; - Write arithmetic expressions for other formulas that you remember from high school
;;   (or look some up if you don't remember any!).

woof
;; a single quote inhibits evaluation

'woof
(cons 'woof '(bow wow))
(cons '(howl) '(at the moon))
(def my-favorite-list '(fe fi fo fum))
my-favorite-list
(first my-favorite-list)
(rest my-favorite-list)
(cons 'he (cons 'said my-favorite-list))
my-favorite-list
(first (rest (rest (first
                     '((deep
                         (in the (nested) structure)
                         lies
                         truth))))))
(inspect-tree '((deep
                  (in the (nested) structure)
                  lies
                  truth)))

; < window opens in the clojure.main application >
(second '(a b c d e))
(third '(a b c d e)) ;; nope
(nth '(a b c d e) 2)
(concat '(I like to eat) '(apples and bananas))
(rand-nth '(a b c d e f g))
(flatten '(a (b (c d) (((e))) f (g))))
;; This returns a vector rather than a list:

(shuffle '(a b c d e f g))
;; We'll see more about vectors later, but both are "sequences" and many functions work
;; on either without change.



(count '(a b c d e f g))
;; Problem Set 2:
;; - Create a complicated nested list using only cons, quoted symbols, and ().
;; - Pull out various parts of your list with nested calls to nth.
;; - Pull out random parts of your list with nested calls to rand-nth.
;; - Write an expression that produces a semi-random haiku.
(defn my-function
  "Takes two arguments and returns a list with those arguments and
some other stuff."
  [a b]
  (list 'some a 'other b 'stuff))
(my-function 'nice 'stuffy)
(defn random-element
  "Returns a randomly selected element of the given sequence."
  [s]
  (nth s (rand-int (count s))))
(random-element '(a b c d e f g))
(= (+ 22 33 44) (* 33 3))
(= (my-function 'nice 'stuffy) (my-function 'nice 'stuffy))
(identical? (my-function 'nice 'stuffy) (my-function 'nice 'stuffy))
(def x 23)
(def y 5)
(if (< x y)
  (list x 'is 'smaller 'than y)
  (list x 'is 'not 'smaller 'than y))
(cond 
  (< x y) (concat (list x) '(is smaller than) (list y))
  (= x y) (concat (list x) '(is equal to) (list y))
  :else (concat (list x) '(is greater than) (list y)))
(defn add-20
  "returns n + 20"
  [n]
  (+ n 20))
(add-20 15)
(use 'clojure.repl) ;; need to do this to have access to the "doc" function below
(doc add-20)
;; Problem Set 3:
;; - Write functions that calculate, given reasonable numeric inputs, the values 
;;   of the aritmetic/geometric formulae that you provided for Problem Set 1.
;; - Write a function that takes a list of one-syllable words, a list of 
;;   two-syllable words, and a list of three-syllable words, and returns a haiku
;;   constructed from the provided words.
(defn article
  "Generates and returns an article as a symbol in a list."
  []
  (list (random-element '(the a))))
(defn noun
  "Generates and returns a noun as a symbol in a list."
  []
  (list (random-element '(walrus steamboat pedestrian columnist pineapple contingency))))
(defn verb
  "Generates and returns a verb as a symbol in a list."
  []
  (list (random-element '(acquired apprehended loved liked loathed caressed confounded))))
(defn noun-phrase
  "Generates and returns a noun-phrase as a list."
  []
  (concat (article) (noun)))
(defn verb-phrase
  "Generates and returns a verb-phrase as a list."
  []
  (concat (verb) (noun-phrase)))
(defn sentence
  "Generates and returns a sentence as a list."
  []
  (concat (noun-phrase) (verb-phrase)))
(sentence)
;; again:

(sentence)
;; again:

(sentence)
;; again:

(sentence)
;; again:

(sentence)
(noun-phrase)
(verb-phrase)
(noun)
(verb)
(let [my-sentence (sentence)]
  (concat my-sentence (reverse my-sentence)))
(let [my-sentence (sentence)
      your-sentence (sentence)]
  (concat  '(I said that) my-sentence '(and you said that) 
    your-sentence '(to which I replied that)
    my-sentence '(and you said finally that) 
    your-sentence))
(let [x 0
      x (+ x 1)
      x (* x 100)
      x (/ x 20)]
  x)
(defn print-sentence
  "Prints a sentence (symbols in a list) followed by a newline."
  [s]
  (doseq [word s] (print word) (print " "))
  (println))
(print-sentence (sentence))
;; again:

(print-sentence (sentence))
(do (cons 'this '(will happen but you will not see it))
    (cons 'because '(all that gets returned from a "do" form))
    (cons 'is '(the value of the last form within it)))
;; Problem Set 4:
;; - Generate random blues song lyrics. They should include repeated lines.
;; - Generate random melodies that include repeated lines.
;; this is a set:

#{:tree :mushroom :aardvark} 
(:tree #{:tree :mushroom :aardvark})
(:tree #{:free :mushroom :aardvark})
(#{:tree :mushroom :aardvark} :tree)
(contains? #{:free :mushroom :aardvark} :free)
(some #{:free} #{:free :mushroom :aardvark})
(some even? #{9 3 4 1 11 8})
(use 'clojure.set)
(select even? #{9 3 4 1 11 8})
(conj #{:tree :mushroom :aardvark} :poppy)
(disj #{:tree :mushroom :aardvark} :tree)
;; more ways of making sets:

(hash-set :tomato :cucumber :basil)
(sorted-set :tomato :cucumber :basil)
(set '(apples bananas))
(into #{} '(apples bananas))
(set (str 123))
(defn member? 
  "Returns true if item is in lst, false otherwise."
  [item lst]
  (if (some #{item} lst) true false))
(member? \b (set "Eggbert"))
(member? 1 '(2 3 1 5))
(member? \1 (set (str 2315)))
(member? \6 (set (str 2315)))
(intersection #{:free :mushroom :aardvark}
              #{:tree :mushroom :aardvark})
(union #{:free :mushroom :aardvark}
       #{:tree :mushroom :aardvark})
(difference #{:free :mushroom :aardvark}
            #{:tree :mushroom :aardvark})
(subset? #{:mushroom :aardvark}
         #{:tree :mushroom :aardvark})
(superset? #{:tree :mushroom :aardvark}
           #{:mushroom :aardvark})
(let [my-sentence (sentence)]
  (if (some #{'walrus} my-sentence)
    (println 'pussycat)
    (print-sentence my-sentence)))
;; again:

(let [my-sentence (sentence)]
  (if (some #{'walrus} my-sentence)
    (println 'pussycat)
    (print-sentence my-sentence)))
;; Problem Set 5:
;; - Create a list of your favorite things.
;; - Write a function that creates two random subsets of your favorite things
;;   and prints out their intersection and differences.
;; - Enhance the function above to print a special message if the two subsets are equal.
(dotimes [i 10] (println i))
;; the name "_" is idiomatic for "generic name, I won't refer to it"

(dotimes [_ 5] (print-sentence (sentence)))
(time (dotimes [i 1000000] (/ i 23)))
(range 10)
(range 100 110)
(range 100 110 2)
(inc 1)
(map inc (range 10))
(map (fn [x] (* x 2)) (range 10))
(map #(* % 2) (range 10))
;; this makes an infinite lazy sequence of random numbers (don't try to print it all!):

(def rands (repeatedly rand))
(take 2 rands)
(take 3 rands)
(defn slowmult
  [n m]
  (dotimes [i 1000000] (/ i 23))  ;; just wasting time here
  (* n m))
(time (slowmult 5 5))
(time (doall (map #(slowmult % 2) (range 10))))
;; pmap uses a thread pool

(time (doall (pmap #(slowmult % 2) (range 10))))
(filter even? (range 10))
;; Problem Set 6:
;; - Generate a set of even numbers between 1 and 101.
;; - Generate a set of odd numbers between 1 and 101.
;; - Show that the union of these sets is all of the numbers between 1 and 101.
;; - Write a function that tests if a number is prime.
;; - Create an infinite lazy sequence of prime numbers.
;; - Generate a set of all of the prime numbers less than 1001 that contain the digit 3.
;; - How many prime numbers less than 1001 don't contain a 3 or a 7?

