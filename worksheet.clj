;; gorilla-repl.fileformat = 1

;; **
;;; # Clojinc
;;; 
;; **

;; @@
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
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
0
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>0</span>","value":"0"}
;; <=

;; @@
(inc 0)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>1</span>","value":"1"}
;; <=

;; @@
(inc (inc 0))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>2</span>","value":"2"}
;; <=

;; @@
(dec 2)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>1</span>","value":"1"}
;; <=

;; @@
(dec 0)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>-1</span>","value":"-1"}
;; <=

;; @@
(+ 1 1)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>2</span>","value":"2"}
;; <=

;; @@
+
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>#function[clojure.core/+]</span>","value":"#function[clojure.core/+]"}
;; <=

;; @@
(* 23 13)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>299</span>","value":"299"}
;; <=

;; @@
(+ 1 (* 23 13))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>300</span>","value":"300"}
;; <=

;; @@
(+ (* 2 2) (- 10 9))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>5</span>","value":"5"}
;; <=

;; @@
(* 2 2 2 2)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>16</span>","value":"16"}
;; <=

;; @@
(/ 25 5)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>5</span>","value":"5"}
;; <=

;; @@
(/ 38 4)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-ratio'>19/2</span>","value":"19/2"}
;; <=

;; @@
(+ 1/3 1/3)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-ratio'>2/3</span>","value":"2/3"}
;; <=

;; @@
(+ (/ 1.0 3.0)
   (/ 1.0 3.0))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-double'>0.6666666666666666</span>","value":"0.6666666666666666"}
;; <=

;; @@
(/ 23 0) ;; nope
;; @@

;; @@
(* 123456789 987654321 999999999 12345678987654321)
;; @@

;; @@
(* 123456789M 987654321 999999999 12345678987654321)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-bigdecimal'>1505341120331325629973976373036705875152651M</span>","value":"1505341120331325629973976373036705875152651M"}
;; <=

;; @@
(sqrt (* 2 2 2 2))
;; @@

;; @@
(Math/sqrt (* 2 2 2 2))  ;; from java.lang.Math
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-double'>4.0</span>","value":"4.0"}
;; <=

;; @@
(Math/sqrt -4) ;; nope
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-double'>NaN</span>","value":"NaN"}
;; <=

;; @@
(Math/log 2)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-double'>0.6931471805599453</span>","value":"0.6931471805599453"}
;; <=

;; @@
(Math/sqrt 1000000)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-double'>1000.0</span>","value":"1000.0"}
;; <=

;; @@
Math/PI  ;; this is a java interop form, for the PI static field of the Math class
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-double'>3.141592653589793</span>","value":"3.141592653589793"}
;; <=

;; @@
(def my-favorite-number 23)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/my-favorite-number</span>","value":"#'clojinc.core/my-favorite-number"}
;; <=

;; @@
my-favorite-number
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>23</span>","value":"23"}
;; <=

;; @@
(* my-favorite-number Math/PI)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-double'>72.25663103256524</span>","value":"72.25663103256524"}
;; <=

;; @@
(use 'clojure.inspector)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(inspect my-favorite-number)

; < window opens in the clojure.main application>
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>#object[javax.swing.JFrame 0x78df83 &quot;javax.swing.JFrame[frame0,0,23,400x400,invalid,layout=java.awt.BorderLayout,title=Clojure Inspector,resizable,normal,defaultCloseOperation=HIDE_ON_CLOSE,rootPane=javax.swing.JRootPane[,0,22,400x378,invalid,layout=javax.swing.JRootPane$RootLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=16777673,maximumSize=,minimumSize=,preferredSize=],rootPaneCheckingEnabled=true]&quot;]</span>","value":"#object[javax.swing.JFrame 0x78df83 \"javax.swing.JFrame[frame0,0,23,400x400,invalid,layout=java.awt.BorderLayout,title=Clojure Inspector,resizable,normal,defaultCloseOperation=HIDE_ON_CLOSE,rootPane=javax.swing.JRootPane[,0,22,400x378,invalid,layout=javax.swing.JRootPane$RootLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=16777673,maximumSize=,minimumSize=,preferredSize=],rootPaneCheckingEnabled=true]\"]"}
;; <=

;; @@
;; Problem Set 1: 
;; - Write an expression that calculates the number of seconds in a year.
;; - Define diameter to be some number and write expression that calculates the area
;;   of a circle with that diameter.
;; - Write arithmetic expressions for other formulas that you remember from high school
;;   (or look some up if you don't remember any!).

;; @@

;; @@
woof
;; @@

;; @@
;; a single quote inhibits evaluation

'woof
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-symbol'>woof</span>","value":"woof"}
;; <=

;; @@
(cons 'woof '(bow wow))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>woof</span>","value":"woof"},{"type":"html","content":"<span class='clj-symbol'>bow</span>","value":"bow"},{"type":"html","content":"<span class='clj-symbol'>wow</span>","value":"wow"}],"value":"(woof bow wow)"}
;; <=

;; @@
(cons '(howl) '(at the moon))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>howl</span>","value":"howl"}],"value":"(howl)"},{"type":"html","content":"<span class='clj-symbol'>at</span>","value":"at"},{"type":"html","content":"<span class='clj-symbol'>the</span>","value":"the"},{"type":"html","content":"<span class='clj-symbol'>moon</span>","value":"moon"}],"value":"((howl) at the moon)"}
;; <=

;; @@
(def my-favorite-list '(fe fi fo fum))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/my-favorite-list</span>","value":"#'clojinc.core/my-favorite-list"}
;; <=

;; @@
my-favorite-list
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>fe</span>","value":"fe"},{"type":"html","content":"<span class='clj-symbol'>fi</span>","value":"fi"},{"type":"html","content":"<span class='clj-symbol'>fo</span>","value":"fo"},{"type":"html","content":"<span class='clj-symbol'>fum</span>","value":"fum"}],"value":"(fe fi fo fum)"}
;; <=

;; @@
(first my-favorite-list)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-symbol'>fe</span>","value":"fe"}
;; <=

;; @@
(rest my-favorite-list)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>fi</span>","value":"fi"},{"type":"html","content":"<span class='clj-symbol'>fo</span>","value":"fo"},{"type":"html","content":"<span class='clj-symbol'>fum</span>","value":"fum"}],"value":"(fi fo fum)"}
;; <=

;; @@
(cons 'he (cons 'said my-favorite-list))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>he</span>","value":"he"},{"type":"html","content":"<span class='clj-symbol'>said</span>","value":"said"},{"type":"html","content":"<span class='clj-symbol'>fe</span>","value":"fe"},{"type":"html","content":"<span class='clj-symbol'>fi</span>","value":"fi"},{"type":"html","content":"<span class='clj-symbol'>fo</span>","value":"fo"},{"type":"html","content":"<span class='clj-symbol'>fum</span>","value":"fum"}],"value":"(he said fe fi fo fum)"}
;; <=

;; @@
my-favorite-list
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>fe</span>","value":"fe"},{"type":"html","content":"<span class='clj-symbol'>fi</span>","value":"fi"},{"type":"html","content":"<span class='clj-symbol'>fo</span>","value":"fo"},{"type":"html","content":"<span class='clj-symbol'>fum</span>","value":"fum"}],"value":"(fe fi fo fum)"}
;; <=

;; @@
(first (rest (rest (first
                     '((deep
                         (in the (nested) structure)
                         lies
                         truth))))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-symbol'>lies</span>","value":"lies"}
;; <=

;; @@
(inspect-tree '((deep
                  (in the (nested) structure)
                  lies
                  truth)))

; < window opens in the clojure.main application >
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>#object[javax.swing.JFrame 0x266ed37a &quot;javax.swing.JFrame[frame1,0,23,400x600,layout=java.awt.BorderLayout,title=Clojure Inspector,resizable,normal,defaultCloseOperation=HIDE_ON_CLOSE,rootPane=javax.swing.JRootPane[,0,22,400x578,layout=javax.swing.JRootPane$RootLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=16777673,maximumSize=,minimumSize=,preferredSize=],rootPaneCheckingEnabled=true]&quot;]</span>","value":"#object[javax.swing.JFrame 0x266ed37a \"javax.swing.JFrame[frame1,0,23,400x600,invalid,layout=java.awt.BorderLayout,title=Clojure Inspector,resizable,normal,defaultCloseOperation=HIDE_ON_CLOSE,rootPane=javax.swing.JRootPane[,0,22,400x578,invalid,layout=javax.swing.JRootPane$RootLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=16777673,maximumSize=,minimumSize=,preferredSize=],rootPaneCheckingEnabled=true]\"]"}
;; <=

;; @@
(second '(a b c d e))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-symbol'>b</span>","value":"b"}
;; <=

;; @@
(third '(a b c d e)) ;; nope
;; @@

;; @@
(nth '(a b c d e) 2)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-symbol'>c</span>","value":"c"}
;; <=

;; @@
(concat '(I like to eat) '(apples and bananas))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>I</span>","value":"I"},{"type":"html","content":"<span class='clj-symbol'>like</span>","value":"like"},{"type":"html","content":"<span class='clj-symbol'>to</span>","value":"to"},{"type":"html","content":"<span class='clj-symbol'>eat</span>","value":"eat"},{"type":"html","content":"<span class='clj-symbol'>apples</span>","value":"apples"},{"type":"html","content":"<span class='clj-symbol'>and</span>","value":"and"},{"type":"html","content":"<span class='clj-symbol'>bananas</span>","value":"bananas"}],"value":"(I like to eat apples and bananas)"}
;; <=

;; @@
(rand-nth '(a b c d e f g))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-symbol'>c</span>","value":"c"}
;; <=

;; @@
(flatten '(a (b (c d) (((e))) f (g))))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>a</span>","value":"a"},{"type":"html","content":"<span class='clj-symbol'>b</span>","value":"b"},{"type":"html","content":"<span class='clj-symbol'>c</span>","value":"c"},{"type":"html","content":"<span class='clj-symbol'>d</span>","value":"d"},{"type":"html","content":"<span class='clj-symbol'>e</span>","value":"e"},{"type":"html","content":"<span class='clj-symbol'>f</span>","value":"f"},{"type":"html","content":"<span class='clj-symbol'>g</span>","value":"g"}],"value":"(a b c d e f g)"}
;; <=

;; @@
;; This returns a vector rather than a list:

(shuffle '(a b c d e f g))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>c</span>","value":"c"},{"type":"html","content":"<span class='clj-symbol'>a</span>","value":"a"},{"type":"html","content":"<span class='clj-symbol'>g</span>","value":"g"},{"type":"html","content":"<span class='clj-symbol'>e</span>","value":"e"},{"type":"html","content":"<span class='clj-symbol'>d</span>","value":"d"},{"type":"html","content":"<span class='clj-symbol'>b</span>","value":"b"},{"type":"html","content":"<span class='clj-symbol'>f</span>","value":"f"}],"value":"[c a g e d b f]"}
;; <=

;; @@
;; We'll see more about vectors later, but both are "sequences" and many functions work
;; on either without change.



(count '(a b c d e f g))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>7</span>","value":"7"}
;; <=

;; @@
;; Problem Set 2:
;; - Create a complicated nested list using only cons, quoted symbols, and ().
;; - Pull out various parts of your list with nested calls to nth.
;; - Pull out random parts of your list with nested calls to rand-nth.
;; - Write an expression that produces a semi-random haiku.
;; @@

;; @@
(defn my-function
  "Takes two arguments and returns a list with those arguments and
some other stuff."
  [a b]
  (list 'some a 'other b 'stuff))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/my-function</span>","value":"#'clojinc.core/my-function"}
;; <=

;; @@
(my-function 'nice 'stuffy)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>some</span>","value":"some"},{"type":"html","content":"<span class='clj-symbol'>nice</span>","value":"nice"},{"type":"html","content":"<span class='clj-symbol'>other</span>","value":"other"},{"type":"html","content":"<span class='clj-symbol'>stuffy</span>","value":"stuffy"},{"type":"html","content":"<span class='clj-symbol'>stuff</span>","value":"stuff"}],"value":"(some nice other stuffy stuff)"}
;; <=

;; @@
(defn random-element
  "Returns a randomly selected element of the given sequence."
  [s]
  (nth s (rand-int (count s))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/random-element</span>","value":"#'clojinc.core/random-element"}
;; <=

;; @@
(random-element '(a b c d e f g))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-symbol'>c</span>","value":"c"}
;; <=

;; @@
(= (+ 22 33 44) (* 33 3))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
(= (my-function 'nice 'stuffy) (my-function 'nice 'stuffy))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
(identical? (my-function 'nice 'stuffy) (my-function 'nice 'stuffy))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>false</span>","value":"false"}
;; <=

;; @@
(def x 23)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/x</span>","value":"#'clojinc.core/x"}
;; <=

;; @@
(def y 5)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/y</span>","value":"#'clojinc.core/y"}
;; <=

;; @@
(if (< x y)
  (list x 'is 'smaller 'than y)
  (list x 'is 'not 'smaller 'than y))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>23</span>","value":"23"},{"type":"html","content":"<span class='clj-symbol'>is</span>","value":"is"},{"type":"html","content":"<span class='clj-symbol'>not</span>","value":"not"},{"type":"html","content":"<span class='clj-symbol'>smaller</span>","value":"smaller"},{"type":"html","content":"<span class='clj-symbol'>than</span>","value":"than"},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"}],"value":"(23 is not smaller than 5)"}
;; <=

;; @@
(cond 
  (< x y) (concat (list x) '(is smaller than) (list y))
  (= x y) (concat (list x) '(is equal to) (list y))
  :else (concat (list x) '(is greater than) (list y)))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>23</span>","value":"23"},{"type":"html","content":"<span class='clj-symbol'>is</span>","value":"is"},{"type":"html","content":"<span class='clj-symbol'>greater</span>","value":"greater"},{"type":"html","content":"<span class='clj-symbol'>than</span>","value":"than"},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"}],"value":"(23 is greater than 5)"}
;; <=

;; @@
(defn add-20
  "returns n + 20"
  [n]
  (+ n 20))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/add-20</span>","value":"#'clojinc.core/add-20"}
;; <=

;; @@
(add-20 15)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>35</span>","value":"35"}
;; <=

;; @@
(use 'clojure.repl) ;; need to do this to have access to the "doc" function below
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(doc add-20)
;; @@
;; ->
;;; -------------------------
;;; clojinc.core/add-20
;;; ([n])
;;;   returns n + 20
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
;; Problem Set 3:
;; - Write functions that calculate, given reasonable numeric inputs, the values 
;;   of the aritmetic/geometric formulae that you provided for Problem Set 1.
;; - Write a function that takes a list of one-syllable words, a list of 
;;   two-syllable words, and a list of three-syllable words, and returns a haiku
;;   constructed from the provided words.
;; @@

;; @@

;; @@
