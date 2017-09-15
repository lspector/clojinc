;; clojinc
;; Steps toward clojure, starting from zero.
;; by Lee Spector <lspector@hampshire.edu>, 2011-2017
;; Version (date): 20170914

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

; nil



0

; 0



(inc 0)

; 1



(inc (inc 0))

; 2



(dec 2)

; 1



(dec 0)

; -1



(+ 1 1)

; 2



+

; #<core$_PLUS_ clojure.core$_PLUS_@50903025>



(* 23 13)

; 299



(+ 1 (* 23 13))

; 300



(+ (* 2 2) (- 10 9))

; 5



(* 2 2 2 2)

; 16



(/ 25 5)

; 5



(/ 38 4)

; 19/2



(+ 1/3 1/3)

; 2/3



(+ (/ 1.0 3.0)
   (/ 1.0 3.0))

; 0.6666666666666666



(/ 23 0) ;; nope

; ArithmeticException Divide by zero  clojure.lang.Numbers.divide (Numbers.java:156)



(* 123456789 987654321 999999999 12345678987654321)

; ArithmeticException integer overflow  clojure.lang.Numbers.throwIntOverflow (Numbers.java:1374)



(* 123456789M 987654321 999999999 12345678987654321)

; 1505341120331325629973976373036705875152651M



(sqrt (* 2 2 2 2))

; CompilerException java.lang.RuntimeException: Unable to resolve symbol: sqrt in this context, compiling:(NO_SOURCE_PATH:12) 



(Math/sqrt (* 2 2 2 2))  ;; from java.lang.Math

; 4.0



(Math/sqrt -4) ;; nope

; NaN



(Math/log 2)

; 0.6931471805599453



(Math/sqrt 1000000)

; 1000.0



Math/PI  ;; this is a java interop form, for the PI static field of the Math class

; 3.141592653589793



(def my-favorite-number 23)

; #'clojinc.core/my-favorite-number



my-favorite-number

; 23



(* my-favorite-number Math/PI)

; 72.25663103256524



(use 'clojure.inspector)

; nil



(inspect my-favorite-number)

; < window opens in the clojure.main application>
; #<JFrame javax.swing.JFrame[frame0,0,22,400x400,invalid,layout=java.awt.BorderLayout,title=Clojure Inspector,resizable,normal,defaultCloseOperation=HIDE_ON_CLOSE,rootPane=javax.swing.JRootPane[,0,22,400x378,invalid,layout=javax.swing.JRootPane$RootLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=16777673,maximumSize=,minimumSize=,preferredSize=],rootPaneCheckingEnabled=true]>


;; Problem Set 1: 
;; - Write an expression that calculates the number of seconds in a year.
;; - Define diameter to be some number and write expression that calculates the area
;;   of a circle with that diameter.
;; - Write arithmetic expressions for other formulas that you remember from high school
;;   (or look some up if you don't remember any!).



woof

; CompilerException java.lang.RuntimeException: Unable to resolve symbol: woof in this context, compiling:(NO_SOURCE_PATH:0) 



;; a single quote inhibits evaluation

'woof

; woof



(cons 'woof '(bow wow))

; (woof bow wow)



(cons '(howl) '(at the moon))

; ((howl) at the moon)



(def my-favorite-list '(fe fi fo fum))

; #'clojinc.core/my-favorite-list



my-favorite-list

; (fe fi fo fum)



(first my-favorite-list)

; fe



(rest my-favorite-list)

; (fi fo fum)



(cons 'he (cons 'said my-favorite-list))

; (he said fe fi fo fum)



my-favorite-list

; (fe fi fo fum)



(first (rest (rest (first
                     '((deep
                         (in the (nested) structure)
                         lies
                         truth))))))

; lies



(inspect-tree '((deep
                  (in the (nested) structure)
                  lies
                  truth)))

; < window opens in the clojure.main application >
; #<JFrame javax.swing.JFrame[frame0,0,22,400x600,invalid,layout=java.awt.BorderLayout,title=Clojure Inspector,resizable,normal,defaultCloseOperation=HIDE_ON_CLOSE,rootPane=javax.swing.JRootPane[,0,22,400x578,invalid,layout=javax.swing.JRootPane$RootLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=16777673,maximumSize=,minimumSize=,preferredSize=],rootPaneCheckingEnabled=true]>



(second '(a b c d e))

; b



(third '(a b c d e)) ;; nope

; #<CompilerException java.lang.Exception: Unable to resolve symbol: third in this context (NO_SOURCE_FILE:51)>



(nth '(a b c d e) 2)

; c



(concat '(I like to eat) '(apples and bananas))

; (I like to eat apples and bananas)



(rand-nth '(a b c d e f g))

; d



(flatten '(a (b (c d) (((e))) f (g))))

; (a b c d e f g)



;; This returns a vector rather than a list:

(shuffle '(a b c d e f g))
         
; [f a g b c d e]



;; We'll see more about vectors later, but both are "sequences" and many functions work
;; on either without change.



(count '(a b c d e f g))

; 7



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

; #'clojinc.core/my-function



(my-function 'nice 'stuffy)

; (some nice other stuffy stuff)



(defn random-element
  "Returns a randomly selected element of the given sequence."
  [s]
  (nth s (rand-int (count s))))

; #'clojinc.core/random-element



(random-element '(a b c d e f g))

; a



(= (+ 22 33 44) (* 33 3))

; true



(= (my-function 'nice 'stuffy) (my-function 'nice 'stuffy))

; true



(identical? (my-function 'nice 'stuffy) (my-function 'nice 'stuffy))

; false



(def x 23)

; #'clojinc.core/x



(def y 5)

; #'clojinc.core/y



(if (< x y)
  (list x 'is 'smaller 'than y)
  (list x 'is 'not 'smaller 'than y))

; (23 is not smaller than 5)



(cond 
  (< x y) (concat (list x) '(is smaller than) (list y))
  (= x y) (concat (list x) '(is equal to) (list y))
  :else (concat (list x) '(is greater than) (list y)))

; (23 is greater than 5)



(defn add-20
  "returns n + 20"
  [n]
  (+ n 20))

; #'clojinc.core/add-20



(add-20 15)

; 35



(use 'clojure.repl) ;; need to do this to have access to the "doc" function below

; nil



(doc add-20)

; -------------------------
; clojinc.core/add-20
; ([n])
;   returns n + 20
; nil



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

; #'clojinc.core/article



(defn noun
  "Generates and returns a noun as a symbol in a list."
  []
  (list (random-element '(walrus steamboat pedestrian columnist pineapple contingency))))

; #'clojinc.core/noun



(defn verb
  "Generates and returns a verb as a symbol in a list."
  []
  (list (random-element '(acquired apprehended loved liked loathed caressed confounded))))

; #'clojinc.core/verb



(defn noun-phrase
  "Generates and returns a noun-phrase as a list."
  []
  (concat (article) (noun)))

; #'clojinc.core/noun-phrase



(defn verb-phrase
  "Generates and returns a verb-phrase as a list."
  []
  (concat (verb) (noun-phrase)))

; #'clojinc.core/verb-phrase



(defn sentence
  "Generates and returns a sentence as a list."
  []
  (concat (noun-phrase) (verb-phrase)))

; #'clojinc.core/sentence



(sentence)

; (the contingency confounded a walrus)



;; again:

(sentence)

; (a columnist liked a pedestrian)



;; again:

(sentence)

; (the contingency loved a pineapple)



;; again:

(sentence)

; (a contingency loved the contingency)



;; again:

(sentence)

; (a pedestrian loved a columnist)



;; again:

(sentence)

; (the steamboat apprehended the pedestrian)



(noun-phrase)

; (the pineapple)



(verb-phrase)

; (liked the steamboat)



(noun)

; (steamboat)



(verb)

; (apprehended)



(let [my-sentence (sentence)]
  (concat my-sentence (reverse my-sentence)))

; (the pineapple acquired a pedestrian pedestrian a acquired pineapple the)



(let [my-sentence (sentence)
      your-sentence (sentence)]
  (concat  '(I said that) my-sentence '(and you said that) 
    your-sentence '(to which I replied that)
    my-sentence '(and you said finally that) 
    your-sentence))

; (I said that the steamboat liked a steamboat and you said that a walrus loathed the steamboat to which I replied that the steamboat liked a steamboat and you said finally that a walrus loathed the steamboat)



(let [x 0
      x (+ x 1)
      x (* x 100)
      x (/ x 20)]
  x)

; 5
  
  
  
(defn print-sentence
  "Prints a sentence (symbols in a list) followed by a newline."
  [s]
  (doseq [word s] (print word) (print " "))
  (println))

; #'clojinc.core/print-sentence



(print-sentence (sentence))

; the walrus loathed the columnist 
; nil



;; again:

(print-sentence (sentence))

; a contingency caressed the pedestrian 
; nil



(do (cons 'this '(will happen but you will not see it))
    (cons 'because '(all that gets returned from a "do" form))
    (cons 'is '(the value of the last form within it)))

; (is the value of the last form within it)



;; Problem Set 4:
;; - Generate random blues song lyrics. They should include repeated lines.
;; - Generate random melodies that include repeated lines.



;; this is a set:

#{:tree :mushroom :aardvark} 

; #{:mushroom :tree :aardvark}



(:tree #{:tree :mushroom :aardvark})

; :tree



(:tree #{:free :mushroom :aardvark})

; nil



(#{:tree :mushroom :aardvark} :tree)

; :tree



(contains? #{:free :mushroom :aardvark} :free)

; true



(some #{:free} #{:free :mushroom :aardvark})

; :free



(some even? #{9 3 4 1 11 8})

; true



(use 'clojure.set)

; nil



(select even? #{9 3 4 1 11 8})

; #{4 8}



(conj #{:tree :mushroom :aardvark} :poppy)

; #{:mushroom :tree :aardvark :poppy}



(disj #{:tree :mushroom :aardvark} :tree)

; #{:mushroom :aardvark}



;; more ways of making sets:

(hash-set :tomato :cucumber :basil)

; #{:tomato :basil :cucumber}



(sorted-set :tomato :cucumber :basil)

; #{:basil :cucumber :tomato}



(set '(apples bananas))

; #{bananas apples}



(into #{} '(apples bananas))

;#{bananas apples}



(set (str 123))

; #{\1 \2 \3}



(defn member? 
  "Returns true if item is in lst, false otherwise."
  [item lst]
  (if (some #{item} lst) true false))

; #'clojinc.core/member?



(member? \b (set "Eggbert"))

; true



(member? 1 '(2 3 1 5))

; true



(member? \1 (set (str 2315)))

; true



(member? \6 (set (str 2315)))

; false



(intersection #{:free :mushroom :aardvark}
              #{:tree :mushroom :aardvark})

; #{:mushroom :aardvark}



(union #{:free :mushroom :aardvark}
       #{:tree :mushroom :aardvark})

; #{:mushroom :free :tree :aardvark}



(difference #{:free :mushroom :aardvark}
            #{:tree :mushroom :aardvark})

; #{:free}



(subset? #{:mushroom :aardvark}
         #{:tree :mushroom :aardvark})

; true



(superset? #{:tree :mushroom :aardvark}
           #{:mushroom :aardvark})

; true



(let [my-sentence (sentence)]
  (if (some #{'walrus} my-sentence)
    (println 'pussycat)
    (print-sentence my-sentence)))

; the contingency liked the steamboat 
; nil



;; again:

(let [my-sentence (sentence)]
  (if (some #{'walrus} my-sentence)
    (println 'pussycat)
    (print-sentence my-sentence)))

; pussycat
; nil



;; Problem Set 5:
;; - Create a list of your favorite things.
;; - Write a function that creates two random subsets of your favorite things
;;   and prints out their intersection and differences.
;; - Enhance the function above to print a special message if the two subsets are equal.



(dotimes [i 10] (println i))

; 0
; 1
; 2
; 3
; 4
; 5
; 6
; 7
; 8
; 9
; nil



;; the name "_" is idiomatic for "generic name, I won't refer to it"

(dotimes [_ 5] (print-sentence (sentence)))

; a walrus apprehended the pineapple 
; the pineapple confounded the pedestrian 
; the pedestrian caressed a pineapple 
; the contingency liked a walrus 
; the steamboat acquired the steamboat 
; nil



(time (dotimes [i 1000000] (/ i 23)))

; "Elapsed time: 809.623 msecs"
; nil



(range 10)

; (0 1 2 3 4 5 6 7 8 9)



(range 100 110)

; (100 101 102 103 104 105 106 107 108 109)



(range 100 110 2)

; (100 102 104 106 108)



(inc 1)

; 2



(map inc (range 10))

; (1 2 3 4 5 6 7 8 9 10)



(map (fn [x] (* x 2)) (range 10))

; (0 2 4 6 8 10 12 14 16 18)



(map #(* % 2) (range 10))

; (0 2 4 6 8 10 12 14 16 18)



;; this makes an infinite lazy sequence of random numbers (don't try to print it all!):

(def rands (repeatedly rand))

; #'clojinc.core/rands



(take 2 rands)

; (0.3160721844830383 0.9335474744540089)



(take 3 rands)

; (0.3160721844830383 0.9335474744540089 0.48793085471945963)



(defn slowmult
  [n m]
  (dotimes [i 1000000] (/ i 23))  ;; just wasting time here
  (* n m))

; #'clojinc.core/slowmult



(time (slowmult 5 5))

; "Elapsed time: 182.648 msecs"
; 25



(time (doall (map #(slowmult % 2) (range 10))))

; "Elapsed time: 1143.98 msecs"
; (0 2 4 6 8 10 12 14 16 18)



;; pmap uses a thread pool

(time (doall (pmap #(slowmult % 2) (range 10))))

; "Elapsed time: 469.409 msecs"
; (0 2 4 6 8 10 12 14 16 18)



(filter even? (range 10))

; (0 2 4 6 8)



;; Problem Set 6:
;; - Generate a set of even numbers between 1 and 101.
;; - Generate a set of odd numbers between 1 and 101.
;; - Show that the union of these sets is all of the numbers between 1 and 101.
;; - Write a function that tests if a number is prime.
;; - Create an infinite lazy sequence of prime numbers.
;; - Generate a set of all of the prime numbers less than 1001 that contain the digit 3.
;; - How many prime numbers less than 1001 don't contain a 3 or a 7?



[1 2 3 4]  ;; that's a vector

; [1 2 3 4]



(1 2 3 4)

; #<CompilerException java.lang.ClassCastException: java.lang.Integer cannot be cast to clojure.lang.IFn (NO_SOURCE_FILE:0)>



'(1 2 3 4)

; (1 2 3 4)



'(a b c d)

; (a b c d)



[a b c d]

; CompilerException java.lang.RuntimeException: Unable to resolve symbol: a in this context, compiling:(NO_SOURCE_PATH:0) 



;; this is a keyword, which evaluates to itself:

:hi  

; :hi



:i-am-a-keyword

; :i-am-a-keyword



;; this is a vector of keywords:

[:biff :bam :blotto :blink :blorg]

; [:biff :bam :blotto :blink :blorg]



(nth [:biff :bam :blotto :blink :blorg] 3)

; :blink



(nth [:biff :bam :blotto :blink :blorg] 0)

; :biff



(subvec [:biff :bam :blotto :blink :blorg] 1 3)

; [:bam :blotto]



(into () [:biff :bam :blotto :blink :blorg]) ;; ends up reversed

; (:blorg :blink :blotto :bam :biff)



(into [] '(:biff :bam :blotto :blink :blorg))

; [:biff :bam :blotto :blink :blorg]



(def lots-of-numbers (take 10000 (iterate inc 0)))

; #'clojinc.core/lots-of-numbers



(take 20 lots-of-numbers)

; (0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19)



(take-last 5 lots-of-numbers)

; (9995 9996 9997 9998 9999)



(take-while #(< % 8) lots-of-numbers)

; (0 1 2 3 4 5 6 7)



(take 10 (take-nth 3 lots-of-numbers))

; (0 3 6 9 12 15 18 21 24 27)



(def longlist (into () lots-of-numbers))

#'clojinc.core/longlist



(def longvec (into [] lots-of-numbers))

; #'clojinc.core/longvec



(time (nth longlist 9000))

; "Elapsed time: 0.559 msecs"
; 999



(time (nth longvec 9000))

; "Elapsed time: 0.036 msecs"
; 9000



(defn shuffle-deep
  [nested-list]
  (if (not (seq? nested-list))
    nested-list
    (shuffle (map shuffle-deep nested-list))))
        
; #'clojinc.core/shuffle-deep



(shuffle-deep '(peas (carrots celery) ((scallops shrimp) (cheddar havarti))))

; [[[shrimp scallops] [cheddar havarti]] peas [carrots celery]]



(assoc [0 0 0 0 0 0 0] 3 1)

; [0 0 0 1 0 0 0]



;; Problem Set 7:
;; - Write a function that produces a shuffled deck of cards, where the deck is a vector
;;   and each card is a vector like [7 :spades] or [:king :hearts].
;; - Deal five cards to each of two players and determine who has a better poker hand.
;;   This is complicated to do completely, but start by defining functions to detect
;;   pairs, three-of-a-kind, four-of-a-kind, fluses, straights, etc. Then combine them 
;;   to define the full function to determine a winner.



(defn sandwich
  [main-ingredient]
  (concat '(a) (list main-ingredient) '(sandwich with a pickle, please)))

; #'clojinc.core/sandwich



(sandwich 'pastrami)

; (a pastrami sandwich with a pickle please)



(sandwich 'pastrami 'cheese)

; ArityException Wrong number of args (2) passed to: core$sandwich  clojure.lang.AFn.throwArity (AFn.java:437)



;; two implementations, one for each of two argument lists:

(defn sandwich
  ([main-ingredient]
    (concat '(a) (list main-ingredient) '(sandwich with a pickle, please)))
  ([main-ingredient second-ingredient]
    (concat '(a) (list main-ingredient) '(and) (list second-ingredient) '(sandwich with a pickle))))

; #'clojinc.core/sandwich



(sandwich 'pastrami)

; (a pastrami sandwich with a pickle please)



(sandwich 'pastrami 'cheese)

; (a pastrami and cheese sandwich with a pickle)



(defn assume-cheese
  "calls with one arg use a default of cheese for second"
  ([main-ingredient]
    (assume-cheese main-ingredient 'cheese))
  ([main-ingredient second-ingredient]
    (concat '(a) (list main-ingredient) '(and) (list second-ingredient) '(sandwich with a pickle))))

; #'clojinc.core/assume-cheese



(assume-cheese 'ham)

; (a ham and cheese sandwich with a pickle)



(assume-cheese 'spam 'rutabaga)

;; (a spam and rutabaga sandwich with a pickle)



;; this is a map:

{:name "Edgar Allen Poe" :born 1809 :birthplace "Boston, MA" :residence "Baltimore, MD"} 

; {:name "Edgar Allen Poe",
;  :born 1809,
;  :birthplace "Boston, MA",
;  :residence "Baltimore, MD"}



;; commas are whitespace:

(+ , 2 ,,,,, ,,,,, 3)

; 5



(def eddie {:name "Edgar Allen Poe", :born 1809, :birthplace "Boston, MA", :residence "Baltimore, MD"})

; #'clojinc.core/eddie



(:born eddie)

; 1809



(eddie :born)

; 1809



(get eddie :born)

; 1809



(get eddie :died)

; nil



(get eddie :died :never)

; :never



(keys eddie)

; (:name :born :birthplace :residence)



(vals eddie)

; ("Edgar Allen Poe" 1809 "Boston, MA" "Baltimore, MD")



(assoc eddie :died 1849)

; {:birthplace "Boston, MA", :name "Edgar Allen Poe", :died 1849, :residence "Baltimore, MD", :born 1809}



eddie

; {:birthplace "Boston, MA", :name "Edgar Allen Poe", :residence "Baltimore, MD", :born 1809}



(inspect eddie)

; < window opens >
; #<JFrame javax.swing.JFrame[frame1,0,22,400x400,invalid,layout=java.awt.BorderLayout,title=Clojure Inspector,resizable,normal,defaultCloseOperation=HIDE_ON_CLOSE,rootPane=javax.swing.JRootPane[,0,22,400x378,invalid,layout=javax.swing.JRootPane$RootLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=16777673,maximumSize=,minimumSize=,preferredSize=],rootPaneCheckingEnabled=true]>



(merge eddie {:wife "Virginia Clemm"})

; {:birthplace "Boston, MA", :wife "Virginia Clemm", :name "Edgar Allen Poe", :residence "Baltimore, MD", :born 1809}



(dissoc eddie :born)

; {:birthplace "Boston, MA", :name "Edgar Allen Poe", :residence "Baltimore, MD"}



;; -> and ->> are called "threading" operators
;; They provide an alternative syntax for passing a value through a sequence of calls.
;; -> threads each result into the first argument position of the next form
;; So (-> foo (bar baz) (bingo bonkers)) evaluates foo to produce (let's say) X, then
;; evaluates (bar X baz) to produce (let's say) Y, and then (bingo Y bonkers).

(-> 0 
    (- 10)
    (/ 2)
    (cons '(is the answer)))

; (-5 is the answer)



;; in non-threaded form that would be:

(cons (/ (- 0 10) 2) '(is the answer))

; (-5 is the answer)



;; ->> threads into the last argument position, rather than the first


(->> 0 
     (- 10)
     (/ 2))
  
; 1/5



(-> eddie
    (assoc :died 1849)
    (assoc :wife "Virginia Clemm")
    (dissoc :born)
    (dissoc :birthplace))

; {:wife "Virginia Clemm", :name "Edgar Allen Poe", :died 1849, :residence "Baltimore, MD"}



(def grammar
  {:sentence [:noun-phrase :verb-phrase]
   :noun-phrase [:article :noun]
   :verb-phrase [:verb :noun-phrase]
   :article #{'the 'a}
   :noun #{'walrus 'steamboat 'pedestrian 'columnist 'pineapple 'contingency}
   :verb #{'acquired 'apprehended 'loved 'liked 'loathed 'caressed 'confounded}})

; #'clojinc.core/grammar



(defn generate
  [phrase]
  (cond (set? phrase) (generate (rand-nth (vec phrase)))
        (vector? phrase) (apply concat (map generate phrase))
        (= phrase ()) ()
        :else (let [expansion (phrase grammar)]
                (if expansion
                  (generate expansion)
                  (list phrase)))))
                  
; #'clojinc.core/generate



(generate :sentence)

; (a contingency apprehended a steamboat)



(def grammar
  {:sentence [:noun-phrase :verb-phrase]
   :noun-phrase #{[:article :adj* :noun :pp*] 
                  :name 
                  :pronoun}
   :verb-phrase [:verb :noun-phrase :pp*]
   :pp* #{() [:pp :pp*]}
   :adj* #{() [:adj :adj*]}
   :pp [:prep :noun-phrase]
   :prep #{'to 'in 'by 'with 'on}
   :adj #{'big 'little 'blue 'green 'awesome}
   :article #{'the 'a}
   :name #{'gerald 'penelope 'gertrude 'thor}
   :noun #{'walrus 'steamboat 'pedestrian 'columnist 'pineapple 'contingency}
   :verb #{'acquired 'apprehended 'loved 'liked 'loathed 'caressed 'confounded}
   :pronoun #{'he 'she 'it 'these 'those 'that}})

; #'clojinc.core/grammar



(generate :sentence)

; (the awesome awesome walrus loved it)



(generate :sentence)

; (these liked a pineapple by penelope to he)



(generate :sentence)

; (he caressed those)



(generate :sentence)

; (the  awesome green columnist on he confounded a awesome little blue awesome columnist in she)



;; Problem Set 8:
;; - Create a grammar map, in the format presented above, for blues melodies
;;   or song lyrics or dance step sequences or band names or thesis project titles 
;;   or business concepts or anything else that interests you. Use generate to 
;;   produce items of your chosen category.
;; - Create a database (set) of music CDs (maps) each of which is something like
;;   {:title "Jherico Jerk"
;;    :artist "Pierre Henry"
;;    :year 1967
;;    :nationality "French"
;;    :genre "Psychedelia"
;;    :duration {:minutes 2, :seconds 28}
;;    :url "http://www.youtube.com/watch?v=7L7MrPMe9g8"}
;; - Write a function that returns a playlist for a particular genre.
;; - ... for a set of genres.
;; - ... for a particular length of time.
;; - ... etc.
;; - With Java interop and/or additional libraries add audio output and build a
;;   configurable jukebox.



(defn average
  [numbers]
  (float
    (/ (apply + numbers)
       (count numbers))))

; #'clojinc.core/average
  


(average (range 10))

; 4.5



(defn average
  [& numbers]
  (float
    (/ (apply + numbers)
       (count numbers))))

; #'clojinc.core/average



(average 0 1 2 3 4 5 6 7 8 9)

; 4.5



(apply average (range 10))

; 4.5



(reduce average (range 10))

; 8.001953



(reduce list (range 10))

; (((((((((0 1) 2) 3) 4) 5) 6) 7) 8) 9)



(apply list (range 10))

; (0 1 2 3 4 5 6 7 8 9)



(list '+ 1 2)

; (+ 1 2)



(eval (list '+ 1 2))
       
; 3



;; Atoms manage global items (single items) that two threads shouldn't 
;; change at the same time. This is different from global variables in most 
;; other languages, because one can only change an atom through special access 
;; functions that interact with a "software transactional memory." This ensures 
;; that each change is completed before any other starts (that is, changes are 
;; "atomic"). If you try to change an atom and it is busy then your change
;; will be retried. So the code that you use to change it should not have side
;; effects. Atoms are created with atom and altered  with swap!, reset!,
;; and compare-and-set!



(def X (atom 0))

; #'clojinc.core/X



X

; #<Atom@612438f1: 0>



(deref X)

; 0



;; this is just (handy) shorthand for deref:

@X

; 0



(reset! X 23)

; 23



@X

; 23



(eval '(* @X 2))

;; 46



;; Problem Set 9:
;; - Write a division function that returns 0 (instead of producing an error) 
;;   if it is called with a second argument of zero.
;; - Write a function that produces, prints, and then evaluates a random 
;;   arithmetic expression using basic math functions, numbers, and @X (to 
;;   get the value of an atom X).
;; - Define "data" to be a vector of [x y] data points to represent a data set 
;;   of your choosing.
;; - Write a function that takes an expression and evaluates it repeatedly, with 
;;   atom X set to each x value in the data, and returns the "error" of the
;;   results in comparison to all of the corresponding y values. For each
;;   [x y] pair the error for that pair is the square of the difference
;;   between y and the result of evaluating the expression with atom X set to
;;   x. The overall error is the sum of the errors for all of the data pairs.
;; - Print the errors of randomly generated expressions.
;; - Write a "select" function that takes a population (a vector of expressions)
;;   and returns an expression from the population. Your function should have the  
;;   property that lower-error expressions are more likely to be returned than 
;;   higher-error expressions.



(defn count-fns
  "Returns the number of functions (items in function position) in a symbolic 
   expression."
  [expression]
  (if (list? expression)
    (inc (reduce + (map count-fns (rest expression))))
    0))

; #'clojinc.core/count-fns



(count-fns '(+ (* 2 3) 4))

; 2



(defn count-subexpressions
  "Returns the number of sub-expressions in a symbolic expression, including
   the expression itself."
  [expression]
  (if (list? expression)
    (inc (reduce + (map count-subexpressions (rest expression))))
    1))

; #'clojinc.core/count-subexpressions



(count-subexpressions '(+ (* 2 3) 4))

; 5



;; This "buckets-needed" function will seem bizarre at first, but it's 
;; handy for some other functions that follow.

(defn buckets-needed
  "Takes a sequence of buckets, each of which is a non-negative integer
   representing the capacity of a bucket, and returns the number of buckets 
   that one must use, starting with the first bucket and adding them
   sequentially, to hold the provided number of items. Assumes that buckets
   with sufficient capacity are provided."
  [buckets items]
  (cond (zero? items) 0
        (<= items (first buckets)) 1
        :else (inc (buckets-needed (rest buckets) (- items (first buckets))))))

; #'clojinc.core/buckets-needed



(buckets-needed [3 2 4 1 2 3] 8)

; 3



(buckets-needed [3 2 4 1 2 3] 9)

; 3



(buckets-needed [3 2 4 1 2 3] 10)

; 4



(buckets-needed [3 2 4 1 2 3] 15)

; 6



(buckets-needed [3 2 4 1 2 3] 16)

; NullPointerException   clojure.lang.Numbers.ops (Numbers.java:942)



(defn nth-fn
  "Returns the nth function in a symbolic expression. Assumes index is valid."
  [expression index]
  (if (zero? index)
    (first expression)
    (let [buckets (map count-fns (rest expression))
          arg-index (buckets-needed buckets index)]
      (nth-fn (nth expression arg-index)
              (dec (- index (reduce + (take (dec arg-index) buckets))))))))

; #'clojinc.core/nth-fn



(nth-fn '(+ (* 2 3) 4) 0)

; +



(nth-fn '(+ (* 2 3) 4) 1)

; *



; test nth-fn more thoroughly by walking through an expression:

(let [exp '(* (+ a (- b c) d e) (- (+ f g) h))]
  (dotimes [i (count-fns exp)]
    (println (nth-fn exp i))))

; *
; +
; -
; -
; +
; nil



(defn replace-fn
  "Returns a copy of the provided expression with new-fn used in place of whatever
   was originally in the function position at the provided index. Assumes index is 
   valid."
  [expression index new-fn]
  (if (zero? index)
    (cons new-fn (rest expression))
    (let [buckets (map count-fns (rest expression))
          arg-index (buckets-needed buckets index)]
      (apply list
             (assoc (into [] expression)
                    arg-index
                    (replace-fn (nth expression arg-index)
                                (dec (- index (reduce + (take (dec arg-index) buckets))))
                                new-fn))))))

; #'clojinc.core/replace-fn



;; test replace-fn by walking through an expression:

(let [exp '(* (+ a (- b c) d e) (- (+ f g) h))]
  (dotimes [i (count-fns exp)]
    (println (replace-fn exp i 'F))))

; (F (+ a (- b c) d e) (- (+ f g) h))
; (* (F a (- b c) d e) (- (+ f g) h))
; (* (+ a (F b c) d e) (- (+ f g) h))
; (* (+ a (- b c) d e) (F (+ f g) h))
; (* (+ a (- b c) d e) (- (F f g) h))
; nil



(defn nth-subexpression
  "Returns the nth subexpression in a symbolic expression. Assumes index is valid."
  [expression index]
  (if (zero? index)
    expression
    (let [buckets (map count-subexpressions (rest expression))
          arg-index (buckets-needed buckets index)]
      (nth-subexpression (nth expression arg-index)
                         (dec (- index (reduce + (take (dec arg-index) buckets))))))))

; #'clojinc.core/nth-subexpression



;; test nth-subexpression by walking through an expression:

(let [exp '(* (+ a (- b c) d e) (- (+ f g) h))]
  (dotimes [i (count-subexpressions exp)]
    (println (nth-subexpression exp i))))

; (* (+ a (- b c) d e) (- (+ f g) h))
; (+ a (- b c) d e)
; a
; (- b c)
; b
; c
; d
; e
; (- (+ f g) h)
; (+ f g)
; f
; g
; h
; nil



(defn replace-subexpression
  "Returns a copy of the provided expression with new-subexpression used in place 
   of whatever subexpression was originally in the position at the provided index. 
   Assumes index is valid."
  [expression index new-subexpression]
  (if (zero? index)
    new-subexpression
    (let [buckets (map count-subexpressions (rest expression))
          arg-index (buckets-needed buckets index)]
      (apply list
             (assoc (into [] expression)
                    arg-index
                    (replace-subexpression (nth expression arg-index)
                                           (dec (- index (reduce + (take (dec arg-index) buckets))))
                                           new-subexpression))))))

; #'clojinc.core/replace-subexpression



; test replace-subexpression by walking through an expression:

(let [exp '(* (+ a (- b c) d e) (- (+ f g) h))]
  (dotimes [i (count-subexpressions exp)]
    (println (replace-subexpression exp i 'X))))

; X
; (* X (- (+ f g) h))
; (* (+ X (- b c) d e) (- (+ f g) h))
; (* (+ a X d e) (- (+ f g) h))
; (* (+ a (- X c) d e) (- (+ f g) h))
; (* (+ a (- b X) d e) (- (+ f g) h))
; (* (+ a (- b c) X e) (- (+ f g) h))
; (* (+ a (- b c) d X) (- (+ f g) h))
; (* (+ a (- b c) d e) X)
; (* (+ a (- b c) d e) (- X h))
; (* (+ a (- b c) d e) (- (+ X g) h))
; (* (+ a (- b c) d e) (- (+ f X) h))
; (* (+ a (- b c) d e) (- (+ f g) X))
; nil



;; Problem Set 10:
;; - Write a "mutate" function that takes an expression and returns a new expression
;;   in which one sub-expression has been replaced by a new, random sub-expression.
;; - Write a "crossover" function that takes two expressions and returns a new
;;   expression that is like the first except that one sub-expression has been 
;;   replaced by a sub-expression of the second.
;; - Using select, mutate, and crossover, write a genetic programming system that
;;   evolves an expression with low error for a vector of [x y] pairs.
;; - If your genetic programming system evaluates expressions containing @X then
;;   it will not be possible to evaluate multiple expressions simultaneously
;;   using multiple threads on a multicore machine, because the different 
;;   evaluations will fight over the value of X. Change the way that you get
;;   x values into the expressions that you evaluate in order to fix this.



(defn meal [& {:keys [food beverage] :or {food 'bread beverage 'water}}]
  (println food beverage))

; #'clojinc.core/meal



(meal)

; bread water



(meal :food 'truffles)

; truffles water



(meal :beverage 'mead)

; bread mead



(meal :food 'truffles :beverage 'mead)

; truffles mead



(meal :beverage 'mead :food 'truffles)

; truffles mead



(defn meal-from-map [m]
  (apply meal (apply concat m)))

; #'clojinc.core/meal-from-map



(meal-from-map {:food 'truffles :beverage 'mead})

; truffles mead



(def twins [:tweedledee :tweedledum])

; #'clojinc.core/twins



;; this uses a destructuring binding form:

(defn print-twins
  [[this that]] 
  (println "the first twin is" 
           (name this)
           "and the other is" 
           (name that)))

; #'clojinc.core/print-twins



(print-twins twins)

; the first twin is tweedledee and the other is tweedledum



(defn add13 [n] (+ n 13))

; #'clojinc.core/add13



(defn increment-unluckily 
  [nums]
  (map add13 nums))
    
; #'clojinc.core/increment-unluckily



(increment-unluckily '(1 2 3 4 5))

; (14 15 16 17 18)



(increment-unluckily '(1 2 3 4 Quagmire))
    
; (14 15 16 ClassCastException clojure.lang.Symbol cannot be cast to java.lang.Number  clojure.lang.Numbers.add (Numbers.java:126)



(.printStackTrace *e)

; nil
; clojinc.core=> java.lang.ClassCastException: clojure.lang.Symbol cannot be cast to java.lang.Number
; 	at clojure.lang.Numbers.add(Numbers.java:126)
;	at clojure.lang.Numbers.add(Numbers.java:3513)
;	at clojinc.core$add13.invoke(NO_SOURCE_FILE:435)
;	at clojure.core$map$fn__3811.invoke(core.clj:2432)
;	at clojure.lang.LazySeq.sval(LazySeq.java:42)
;	at clojure.lang.LazySeq.seq(LazySeq.java:60)
;	at clojure.lang.Cons.next(Cons.java:39)
;	at clojure.lang.RT.next(RT.java:580)
;	at clojure.core$next.invoke(core.clj:64)
;	at clojure.core$nthnext.invoke(core.clj:2752)
;	at clojure.core$print_sequential.invoke(core_print.clj:57)
;	at clojure.core$fn__4990.invoke(core_print.clj:140)
;	at clojure.lang.MultiFn.invoke(MultiFn.java:167)
;	at clojure.core$pr_on.invoke(core.clj:3264)
;	at clojure.core$pr.invoke(core.clj:3276)
;	at clojure.lang.AFn.applyToHelper(AFn.java:161)
;	at clojure.lang.RestFn.applyTo(RestFn.java:132)
;	at clojure.core$apply.invoke(core.clj:600)
;	at clojure.core$prn.doInvoke(core.clj:3309)
;	at clojure.lang.RestFn.invoke(RestFn.java:408)
;	at clojure.main$repl$read_eval_print__5967.invoke(main.clj:245)
;	at clojure.main$repl$fn__5972.invoke(main.clj:265)
;	at clojure.main$repl.doInvoke(main.clj:265)
;	at clojure.lang.RestFn.invoke(RestFn.java:512)
;	at user$eval27$acc__3261__auto____30$fn__32.invoke(NO_SOURCE_FILE:1)
;	at clojure.lang.AFn.run(AFn.java:24)
;	at java.lang.Thread.run(Thread.java:680)


(System/getProperty "user.name")  ;; a call to a static method of the System class

; "leespector"



(System/currentTimeMillis)

; 1346173749285



(.startsWith "Antarctica" "Ant")  ;; calling an instance member

; true



(.startsWith "Antarctica" "Frigid")

; false



(.. System (getProperties) (get "user.name"))  ;; an alternative syntax

; "leespector"



;; simple graphics -- but not as simple as I'd like

(def max-x 500)

; #'clojinc.core/max-x



(def max-y 500)

; #'clojinc.core/max-y



(def shapes (atom ()))

; #'clojinc.core/shapes



;; lots of Java interop here

(defn render-shape [g [shape-name x y h w color]]
  (.setColor g color) 
  (case shape-name
    rect (.fillRect g x y h w)
    oval (.fillOval g x y h w)))

; #'clojinc.core/render-shape



;; and even more fancy Java stuff here

(def panel 
  (let [jp (proxy [javax.swing.JPanel]
             []
             (getPreferredSize [] (java.awt.Dimension. max-x max-y))
             (paint [g] 
               (render-shape g (list 'rect 0 0 max-x max-y java.awt.Color/WHITE))
               (doall (map #(render-shape g %) @shapes))))]
    (doto (new javax.swing.JFrame "My graphics window")
      (.setSize max-x max-y)
      (.add jp)
      (.setVisible true))
    jp))

; < a window appears in the clojure.main application >
; #'clojinc.core/panel



(defn draw-shape [shape-name x y h w color]
  (swap! shapes concat (list (list shape-name x y h w color)))
  (.paint panel (.getGraphics panel)))

; #'clojinc.core/draw-shape



;; Whew. Quite a bit less simple than I would have liked! And not ideal for
;; serious use, for several reasons. But now we have a way to make simple
;; drawings. 



;; test it out by drawing a bunch of random shapes:

(dotimes [_ 20] 
  (draw-shape (rand-nth '(rect oval))
    (rand-int 400) (rand-int 200) (rand-int 400) (rand-int 400)
    (new java.awt.Color 
      (rand-int 256) (rand-int 256) (rand-int 256) (rand-int 256))))

; < shapes appear in the window >
; nil



;; Problem Set 11:
;; - Write code to draw a face.
;; - Write a function that takes integer coordinates x and y and draws a face
;;   centered at that location.
;; - Write a version of the face-drawing function that draws the face with random
;;   sizes and colors for various components.
;; - Write a function that fills the graphics window with random faces.



;; The factorial of a positive integer n is 1 * 2 * ... * n. It is
;; not defined for n = 0 or for negative n.

;; Here is an iterative version of a factorial function.
;; We start with a counter i with value 1 and a result that is
;; initially 1. We loop adding 1 to i each time, and multiplying
;; the result by i each time, until i is greater than n. You 
;; can read the call to "recur" as something like "go back to the
;; top of the loop but use (inc i) -- which is the current value
;; of i plus 1 -- as the next i and use (* result i) -- which is
;; the product of the current result and the current value of i --
;; as the next result. When we find that i is greater than n
;; we return the result that has accumulated.

(defn factorial
  [n]
  (loop [i 1 result 1]
    (if (> i n)
      result
      (recur (inc i) (* result i)))))

; #'clojinc.core/factorial



(factorial 5)

; 120



(factorial 100)

; ArithmeticException integer overflow  clojure.lang.Numbers.throwIntOverflow (Numbers.java:1374)



(defn factorial
  [n]
  (loop [i 1 result 1]
    (if (> i n)
      result
      (recur (inc i) (*' result i)))))

; #'clojinc.core/factorial



(factorial 100)
; 93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000N



;; Here is a recursive version of factorial in the style often used
;; in Scheme or Common Lisp. This nicely follows an English
;; description of the recursive algorithm: If n is less than 2 then
;; the answer is 1; otherwise the answer is n times the factorial of
;; one less than n. This is also nice in that it requires no
;; additional variables. However, because Clojure/Java does not
;; automatically convert this recursion to iteration (as many other
;; lisps will) each recursive call will consume additional memory and
;; this will run out of memory for very large values of n.

(defn factorial 
  [n]
  (if (< n 2)
    1 
    (* n (factorial (dec n)))))

; #'clojinc.core/factorial



;; Here is a recursive version that uses recur for the recursive step
;; in order to avoid the potential memory problems for large inputs.
;; The first implementation allows the user to call the function normally,
;; with just the input, but the second implementation takes a second 
;; argument into which the answer is accumulated.

(defn factorial
  ([n]
    (factorial n 1))
  ([n accumulator]
    (if (< n 2)
      accumulator
      (recur (dec n) (* n accumulator)))))

; #'clojinc.core/factorial



(factorial 5)

; 120



;; Here is another functional-style version which is both elegant
;; and efficient in Clojure. First we produce a sequence of numbers
;; from 0 to n-1 using range. Then we map inc (which adds 1) down that
;; sequence, producing a sequence from 1 to n. Then we apply * to the
;; result, and return the result of that.

(defn factorial
  [n]
  (apply * (map inc (range n))))

; #'clojinc.core/factorial



;; Here's a slightly different version that avoids the call to map
;; by calling range with two values to produce the right sequence in
;; the first place:

(defn factorial
  [n]
  (apply * (range 1 (inc n))))

; #'clojinc.core/factorial



;; Note that "apply" in the last two examples could be replaced by "reduce".
;; With "apply" each of these makes a single call to "*", with all of the 
;; arguments at once. Using "reduce" would do the same job by calling "*"
;; first on the first two numbers, then again on the result of that first
;; multiplication and the third number, etc. Both "apply" and "reduce" are
;; handy for a variety of purposes, but in this case they both happen to
;; produce the same result (because of the way that "*" works).

;; An alternative approach, which is messy in this case (at least as done
;; here!) but can sometimes be elegant is to create an infinite lazy sequence.
;; We create an infinite lazy sequence of pairs [i i!] (that is, a number
;; and its factorial). We do this by calling iterate, telling it to start
;; with [1 1], and telling it to get the next pair from the current pair by
;; making the first number one higher and the second number the result of 
;; multiplying the current second number by the new first number.

(def all-factorials (iterate 
                      (fn [[i fact]] [(inc i) (* fact (inc i))]) 
                      [1 1]))

; #'clojinc.core/all-factorials



;; We can pull out the right pair for the input n using nth. Since we only want
;; the factorial, not the pair, we call second to return just the factorial. 
;; What is the right index to pass to nth? The sequence looks like
;; this: ([1 1] [2 2] [3 6] [4 24] [5 120] [6 720] ...)
;; Since nth is zero-based we want to look at index 0 for the factorial
;; of 1, index 1 for the factorial of 2, etc., which means we want
;; to look at index (dec n). 

(defn factorial
  [n]
  (second (nth all-factorials (dec n))))

; #'clojinc.core/factorial



(factorial 5)

; 120



;; Another way to pull out the right pair is to search all-factorials
;; for a pair with a first number equal to n. 

(defn factorial 
  [n]
  (second (first (filter  #(= (first %) n) all-factorials))))

; #'clojinc.core/factorial



(factorial 5)

; 120



;; Note, however, that this will loop forever if you ask for the factorial
;; of 0 or a negative number. The other versions above will either return
;; the wrong answer (since there is no right answer!) or produce an error
;; if you ask them to do this, which you shouldn't anyway. But the infinite
;; loop is perhaps the nastiest way to handle this.



;; Problem Set 12:
;; - Write Clojure functions for several of the recursive functions that are 
;;   listed at http://en.wikipedia.org/wiki/Recursion_(computer_science)
;;   other than factorial. Try to write versions in several of the styles
;;   that were presented above for factorial.



(defn print-comparison
  [x y]
  (cond 
    (< x y) (concat (list x) '(is smaller than) (list y))
    (= x y) (concat (list x) '(is equal to) (list y))
    :else (concat (list x) '(is greater than) (list y))))

; #'clojinc.core/print-comparison



(print-comparison 0 1)

; (0 is smaller than 1)



(print-comparison 1 1)

; (1 is equal to 1)



(print-comparison 1 0)

; (1 is greater than 0)



;; Note that cond couldn't be written as a function, because we don't want 
;; it to evaluate everything that is passed to it, just the thing corresponding
;; to the matching condition. So cond is actually implemented as a macro, which
;; defines an expression that evaluates to another expression which is then
;; evaluated.

(macroexpand
  '(cond 
     (< x y) (concat (list x) '(is smaller than) (list y))
     (= x y) (concat (list x) '(is equal to) (list y))
     :else (concat (list x) '(is greater than) (list y))))

; (if (< x y) (concat (list x) (quote (is smaller than)) (list y)) (clojure.core/cond (= x y) (concat (list x) (quote (is equal to)) (list y)) :else (concat (list x) (quote (is greater than)) (list y))))



;; We can define our own macro to build an abstraction
;; of the "arithmetic if" pattern used above.

;; Macros are defined with defmacro, and they specify
;; code transformations. A macro definition should return
;; the code that you would like to be evaluated in place
;; of the macro call. The "syntax quote" (backquote: `)
;; unquote (~) and unquote-splicing (~@) reader macros
;; are particularly useful for defining macros.

(defmacro arithmetic-if
  [x y eval-if-x-less eval-if-equal eval-if-x-greater]
  `(cond 
     (< ~x ~y) ~eval-if-x-less
     (= ~x ~y) ~eval-if-equal
     :else ~eval-if-x-greater))

; #'clojinc.core/arithmetic-if



;; re-define print-comparison using the new macro:

(defn print-comparison
  [x y]
  (arithmetic-if x y 
     (concat (list x) '(is smaller than) (list y))
     (concat (list x) '(is equal to) (list y))
     (concat (list x) '(is greater than) (list y))))

; #'clojinc.core/print-comparison



(print-comparison 1 2)

; (1 is smaller than 2)



;; use it in other contexts:

(arithmetic-if 1 2 3 4 5)

; 3



(macroexpand '(arithmetic-if 1 2 3 4 5))

; (if
;  (clojure.core/< 1 2)
;  3
;  (clojure.core/cond (clojure.core/= 1 2) 4 :else 5))



(macroexpand-1 '(arithmetic-if 1 2 3 4 5))

; (if (clojure.core/< 1 2) 3 (clojure.core/cond (clojure.core/= 1 2) 4 :else 5))



;; The fact that this is a macro, and not a function, is
;; made clear by providing expressions that have side-effects
;; (like printing) for the "eval-if-..." clauses, and seeing 
;; that only the matching clause is executed:

(arithmetic-if 1 
               2 
               (println :less)
               (println :equal)
               (println :greater))

; :less
; nil



;; a lot of other things are also implemeted as macros:

(macroexpand '(dotimes [_ 4] (println (rand))))

; (let* [n__3944__auto__ (clojure.core/long 4)] (clojure.core/loop [_ 0] (clojure.core/when (clojure.core/< _ n__3944__auto__) (println (rand)) (recur (clojure.core/unchecked-inc _)))))



;; What's "splicing"? The following expressions demonstrate:

(def teens (range 10 19))

; #'clojinc.core/teens



teens

; (10 11 12 13 14 15 16 17 18)



`(1 2 3 4 5 6 7 8 9 ~teens 20 21 22 23)

; (1 2 3 4 5 6 7 8 9 (10 11 12 13 14 15 16 17 18) 20 21 22 23)



`(1 2 3 4 5 6 7 8 9 ~@teens 20 21 22 23)

; (1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 20 21 22 23)



;; we use splicing to write an "until" loop macro:

(defmacro until
  [test & body]
  `(loop []
     (when (not ~test)
       ~@body
       (recur))))

; #'clojinc.core/until



(until (> (rand) 0.9)
  (println "he he")
  (println "      ha!"))
 
; he he
;       ha!
; he he
;       ha!
; he he
;       ha!
; nil



(def counter (atom 0))

; #'clojinc.core/counter



(until (> @counter 4)
  (println "the counter is now " @counter)
  (swap! counter inc))

; the counter is now  0
; the counter is now  1
; the counter is now  2
; the counter is now  3
; the counter is now  4
; nil



(defmacro ignore-errors
  "Returns the result of evaluating e, or :error if it throws an exception."
  [e]
  `(try ~e (catch java.lang.Exception _# :error)))

; #'clojinc.core/ignore-errors



(ignore-errors (+ 1 2))

; 3



(ignore-errors (/ 3 0))

; :error



(ignore-errors (+ :peanut-butter :mustard))

; :error



;; Problem Set 13:
;; - Write a macro that takes two unquoted expressions and randomly evaluates
;;   either one, or the other, or both (but never the same one more than once).



;; Reading in a text file is easy if you have a full path:
 
(slurp "/Users/leespector/Code/clojure/clojinc/Jabberwocky.txt")

; "JABBERWOCKY by Lewis Carroll\n(from Through the Looking-Glass and What Alice Found There, 1872) \n\n\n`Twas brillig, and the slithy toves\n  Did gyre and gimble in the wabe:\nAll mimsy were the borogoves,\n  And the mome raths outgrabe.\n\n\n\"Beware the Jabberwock, my son!\n  The jaws that bite, the claws that catch!\nBeware the Jubjub bird, and shun\n  The frumious Bandersnatch!\"\n\nHe took his vorpal sword in hand:\n  Long time the manxome foe he sought --\nSo rested he by the Tumtum tree,\n  And stood awhile in thought.\n\nAnd, as in uffish thought he stood,\n  The Jabberwock, with eyes of flame,\nCame whiffling through the tulgey wood,\n  And burbled as it came!\n\nOne, two! One, two! And through and through\n  The vorpal blade went snicker-snack!\nHe left it dead, and with its head\n  He went galumphing back.\n\n\"And, has thou slain the Jabberwock?\n  Come to my arms, my beamish boy!\nO frabjous day! Callooh! Callay!'\n  He chortled in his joy.\n\n\n`Twas brillig, and the slithy toves\n  Did gyre and gimble in the wabe;\nAll mimsy were the borogoves,\n  And the mome raths outgrabe. "



(require '[clojure.string :as string])

; nil


 
(string/split-lines (slurp "/Users/leespector/Code/clojure/clojinc/Jabberwocky.txt"))

; ["JABBERWOCKY by Lewis Carroll" "(from Through the Looking-Glass and What Alice Found There, 1872) " "" "" "`Twas brillig, and the slithy toves" "  Did gyre and gimble in the wabe:" "All mimsy were the borogoves," "  And the mome raths outgrabe." "" "" "\"Beware the Jabberwock, my son!" "  The jaws that bite, the claws that catch!" "Beware the Jubjub bird, and shun" "  The frumious Bandersnatch!\"" "" "He took his vorpal sword in hand:" "  Long time the manxome foe he sought --" "So rested he by the Tumtum tree," "  And stood awhile in thought." "" "And, as in uffish thought he stood," "  The Jabberwock, with eyes of flame," "Came whiffling through the tulgey wood," "  And burbled as it came!" "" "One, two! One, two! And through and through" "  The vorpal blade went snicker-snack!" "He left it dead, and with its head" "  He went galumphing back." "" "\"And, has thou slain the Jabberwock?" "  Come to my arms, my beamish boy!" "O frabjous day! Callooh! Callay!'" "  He chortled in his joy." "" "" "`Twas brillig, and the slithy toves" "  Did gyre and gimble in the wabe;" "All mimsy were the borogoves," "  And the mome raths outgrabe. "]



;; you can also slurp from the web

(use 'clojure.java.io)

; nil



(slurp (reader "https://raw.githubusercontent.com/lspector/clojinc/master/Jabberwocky.txt"))

; "JABBERWOCKY by Lewis Carroll\n(from Through the Looking-Glass and What Alice Found There, 1872) \n\n\n`Twas brillig, and the slithy toves\n  Did gyre and gimble in the wabe:\nAll mimsy were the borogoves,\n  And the mome raths outgrabe.\n\n\n\"Beware the Jabberwock, my son!\n  The jaws that bite, the claws that catch!\nBeware the Jubjub bird, and shun\n  The frumious Bandersnatch!\"\n\nHe took his vorpal sword in hand:\n  Long time the manxome foe he sought --\nSo rested he by the Tumtum tree,\n  And stood awhile in thought.\n\nAnd, as in uffish thought he stood,\n  The Jabberwock, with eyes of flame,\nCame whiffling through the tulgey wood,\n  And burbled as it came!\n\nOne, two! One, two! And through and through\n  The vorpal blade went snicker-snack!\nHe left it dead, and with its head\n  He went galumphing back.\n\n\"And, has thou slain the Jabberwock?\n  Come to my arms, my beamish boy!\nO frabjous day! Callooh! Callay!'\n  He chortled in his joy.\n\n\n`Twas brillig, and the slithy toves\n  Did gyre and gimble in the wabe;\nAll mimsy were the borogoves,\n  And the mome raths outgrabe. "



(doseq [line (shuffle (string/split-lines 
                        (slurp "/Users/leespector/Code/clojure/clojinc/Jabberwocky.txt")))]
  (println line))

;   And the mome raths outgrabe.
; 
; "Beware the Jabberwock, my son!
;   The Jabberwock, with eyes of flame,
;   He went galumphing back.
; 
; Beware the Jubjub bird, and shun
;   And stood awhile in thought.
;   The frumious Bandersnatch!"
; He took his vorpal sword in hand:
;   Did gyre and gimble in the wabe;
; All mimsy were the borogoves,
;   He chortled in his joy.
;   Long time the manxome foe he sought --
; All mimsy were the borogoves,
;   The jaws that bite, the claws that catch!
;   And the mome raths outgrabe. 
;   Come to my arms, my beamish boy!
; One, two! One, two! And through and through
; Came whiffling through the tulgey wood,
;   The vorpal blade went snicker-snack!
; "And, has thou slain the Jabberwock?
; O frabjous day! Callooh! Callay!'
; So rested he by the Tumtum tree,
; 
;   And burbled as it came!
; 
; 
;   Did gyre and gimble in the wabe:
; He left it dead, and with its head
; 
; (from Through the Looking-Glass and What Alice Found There, 1872) 
; 
; 
; 
; And, as in uffish thought he stood,
; `Twas brillig, and the slithy toves
; JABBERWOCKY by Lewis Carroll
; `Twas brillig, and the slithy toves
; nil



;; output to a text file is also simple if you use a full path

(spit "/Users/leespector/Code/clojure/clojinc/spitoon.txt" "Testing 1 2 3")



;; If you want to refer to files in a project-relative way then the the details will 
;; depend on the way that you run your code. Here I use a utility by Arthur Edelstein 
;; (the author of clooj). I added [local-file "0.0.4"] to the dependencies in project.clj,
;; then ran "lein deps" from a command line in the project's directory (which requires
;; leiningen from https://github.com/technomancy/leiningen), and quit/restarted clooj.
;; Then I can do things like:

(use 'local-file)

; nil



; and if Jabberwocky.txt is in my project directory then I can do:

(slurp (file* "Jabberwocky.txt"))

; "JABBERWOCKY by Lewis Carroll\n(from Through the Looking-Glass and What Alice Found There, 1872) \n\n\n`Twas brillig, and the slithy toves\n  Did gyre and gimble in the wabe:\nAll mimsy were the borogoves,\n  And the mome raths outgrabe.\n\n\n\"Beware the Jabberwock, my son!\n  The jaws that bite, the claws that catch!\nBeware the Jubjub bird, and shun\n  The frumious Bandersnatch!\"\n\nHe took his vorpal sword in hand:\n  Long time the manxome foe he sought --\nSo rested he by the Tumtum tree,\n  And stood awhile in thought.\n\nAnd, as in uffish thought he stood,\n  The Jabberwock, with eyes of flame,\nCame whiffling through the tulgey wood,\n  And burbled as it came!\n\nOne, two! One, two! And through and through\n  The vorpal blade went snicker-snack!\nHe left it dead, and with its head\n  He went galumphing back.\n\n\"And, has thou slain the Jabberwock?\n  Come to my arms, my beamish boy!\nO frabjous day! Callooh! Callay!'\n  He chortled in his joy.\n\n\n`Twas brillig, and the slithy toves\n  Did gyre and gimble in the wabe;\nAll mimsy were the borogoves,\n  And the mome raths outgrabe. "



;; Problem Set 14:
;; - Write a function that reads THIS file and writes a file containing only the lines that
;;   begin with ";;".
;; - Write a function that reads THIS file and executes a randomly selected expression that
;;   it contains, printing :error if something goes wrong (e.g. because the expression relies
;;   on evaluation of something else in this file that hasn't been evaluated.
;; - Write a function that executes all of the expressions in this file and prints out the
;;   expression that returns the result containing the most characters.

;; That's it! Now you should be ready to do more interesting things of your own design in 
;; Clojure.
