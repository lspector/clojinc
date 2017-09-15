;; gorilla-repl.fileformat = 1

;; **
;;; # Clojinc (The Gorilla REPL worksheet version)
;;; 
;; **

;; @@
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
(defn article
  "Generates and returns an article as a symbol in a list."
  []
  (list (random-element '(the a))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/article</span>","value":"#'clojinc.core/article"}
;; <=

;; @@
(defn noun
  "Generates and returns a noun as a symbol in a list."
  []
  (list (random-element '(walrus steamboat pedestrian columnist pineapple contingency))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/noun</span>","value":"#'clojinc.core/noun"}
;; <=

;; @@
(defn verb
  "Generates and returns a verb as a symbol in a list."
  []
  (list (random-element '(acquired apprehended loved liked loathed caressed confounded))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/verb</span>","value":"#'clojinc.core/verb"}
;; <=

;; @@
(defn noun-phrase
  "Generates and returns a noun-phrase as a list."
  []
  (concat (article) (noun)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/noun-phrase</span>","value":"#'clojinc.core/noun-phrase"}
;; <=

;; @@
(defn verb-phrase
  "Generates and returns a verb-phrase as a list."
  []
  (concat (verb) (noun-phrase)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/verb-phrase</span>","value":"#'clojinc.core/verb-phrase"}
;; <=

;; @@
(defn sentence
  "Generates and returns a sentence as a list."
  []
  (concat (noun-phrase) (verb-phrase)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/sentence</span>","value":"#'clojinc.core/sentence"}
;; <=

;; @@
(sentence)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>a</span>","value":"a"},{"type":"html","content":"<span class='clj-symbol'>pedestrian</span>","value":"pedestrian"},{"type":"html","content":"<span class='clj-symbol'>loathed</span>","value":"loathed"},{"type":"html","content":"<span class='clj-symbol'>the</span>","value":"the"},{"type":"html","content":"<span class='clj-symbol'>contingency</span>","value":"contingency"}],"value":"(a pedestrian loathed the contingency)"}
;; <=

;; @@
;; again:

(sentence)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>the</span>","value":"the"},{"type":"html","content":"<span class='clj-symbol'>contingency</span>","value":"contingency"},{"type":"html","content":"<span class='clj-symbol'>liked</span>","value":"liked"},{"type":"html","content":"<span class='clj-symbol'>the</span>","value":"the"},{"type":"html","content":"<span class='clj-symbol'>walrus</span>","value":"walrus"}],"value":"(the contingency liked the walrus)"}
;; <=

;; @@
;; again:

(sentence)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>the</span>","value":"the"},{"type":"html","content":"<span class='clj-symbol'>steamboat</span>","value":"steamboat"},{"type":"html","content":"<span class='clj-symbol'>loved</span>","value":"loved"},{"type":"html","content":"<span class='clj-symbol'>the</span>","value":"the"},{"type":"html","content":"<span class='clj-symbol'>contingency</span>","value":"contingency"}],"value":"(the steamboat loved the contingency)"}
;; <=

;; @@
;; again:

(sentence)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>the</span>","value":"the"},{"type":"html","content":"<span class='clj-symbol'>columnist</span>","value":"columnist"},{"type":"html","content":"<span class='clj-symbol'>confounded</span>","value":"confounded"},{"type":"html","content":"<span class='clj-symbol'>the</span>","value":"the"},{"type":"html","content":"<span class='clj-symbol'>columnist</span>","value":"columnist"}],"value":"(the columnist confounded the columnist)"}
;; <=

;; @@
;; again:

(sentence)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>a</span>","value":"a"},{"type":"html","content":"<span class='clj-symbol'>walrus</span>","value":"walrus"},{"type":"html","content":"<span class='clj-symbol'>apprehended</span>","value":"apprehended"},{"type":"html","content":"<span class='clj-symbol'>a</span>","value":"a"},{"type":"html","content":"<span class='clj-symbol'>steamboat</span>","value":"steamboat"}],"value":"(a walrus apprehended a steamboat)"}
;; <=

;; @@
(noun-phrase)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>a</span>","value":"a"},{"type":"html","content":"<span class='clj-symbol'>pedestrian</span>","value":"pedestrian"}],"value":"(a pedestrian)"}
;; <=

;; @@
(verb-phrase)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>acquired</span>","value":"acquired"},{"type":"html","content":"<span class='clj-symbol'>a</span>","value":"a"},{"type":"html","content":"<span class='clj-symbol'>pedestrian</span>","value":"pedestrian"}],"value":"(acquired a pedestrian)"}
;; <=

;; @@
(noun)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>columnist</span>","value":"columnist"}],"value":"(columnist)"}
;; <=

;; @@
(verb)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>liked</span>","value":"liked"}],"value":"(liked)"}
;; <=

;; @@
(let [my-sentence (sentence)]
  (concat my-sentence (reverse my-sentence)))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>the</span>","value":"the"},{"type":"html","content":"<span class='clj-symbol'>walrus</span>","value":"walrus"},{"type":"html","content":"<span class='clj-symbol'>liked</span>","value":"liked"},{"type":"html","content":"<span class='clj-symbol'>a</span>","value":"a"},{"type":"html","content":"<span class='clj-symbol'>columnist</span>","value":"columnist"},{"type":"html","content":"<span class='clj-symbol'>columnist</span>","value":"columnist"},{"type":"html","content":"<span class='clj-symbol'>a</span>","value":"a"},{"type":"html","content":"<span class='clj-symbol'>liked</span>","value":"liked"},{"type":"html","content":"<span class='clj-symbol'>walrus</span>","value":"walrus"},{"type":"html","content":"<span class='clj-symbol'>the</span>","value":"the"}],"value":"(the walrus liked a columnist columnist a liked walrus the)"}
;; <=

;; @@
(let [my-sentence (sentence)
      your-sentence (sentence)]
  (concat  '(I said that) my-sentence '(and you said that) 
    your-sentence '(to which I replied that)
    my-sentence '(and you said finally that) 
    your-sentence))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>I</span>","value":"I"},{"type":"html","content":"<span class='clj-symbol'>said</span>","value":"said"},{"type":"html","content":"<span class='clj-symbol'>that</span>","value":"that"},{"type":"html","content":"<span class='clj-symbol'>the</span>","value":"the"},{"type":"html","content":"<span class='clj-symbol'>walrus</span>","value":"walrus"},{"type":"html","content":"<span class='clj-symbol'>apprehended</span>","value":"apprehended"},{"type":"html","content":"<span class='clj-symbol'>a</span>","value":"a"},{"type":"html","content":"<span class='clj-symbol'>walrus</span>","value":"walrus"},{"type":"html","content":"<span class='clj-symbol'>and</span>","value":"and"},{"type":"html","content":"<span class='clj-symbol'>you</span>","value":"you"},{"type":"html","content":"<span class='clj-symbol'>said</span>","value":"said"},{"type":"html","content":"<span class='clj-symbol'>that</span>","value":"that"},{"type":"html","content":"<span class='clj-symbol'>the</span>","value":"the"},{"type":"html","content":"<span class='clj-symbol'>pineapple</span>","value":"pineapple"},{"type":"html","content":"<span class='clj-symbol'>loathed</span>","value":"loathed"},{"type":"html","content":"<span class='clj-symbol'>the</span>","value":"the"},{"type":"html","content":"<span class='clj-symbol'>pedestrian</span>","value":"pedestrian"},{"type":"html","content":"<span class='clj-symbol'>to</span>","value":"to"},{"type":"html","content":"<span class='clj-symbol'>which</span>","value":"which"},{"type":"html","content":"<span class='clj-symbol'>I</span>","value":"I"},{"type":"html","content":"<span class='clj-symbol'>replied</span>","value":"replied"},{"type":"html","content":"<span class='clj-symbol'>that</span>","value":"that"},{"type":"html","content":"<span class='clj-symbol'>the</span>","value":"the"},{"type":"html","content":"<span class='clj-symbol'>walrus</span>","value":"walrus"},{"type":"html","content":"<span class='clj-symbol'>apprehended</span>","value":"apprehended"},{"type":"html","content":"<span class='clj-symbol'>a</span>","value":"a"},{"type":"html","content":"<span class='clj-symbol'>walrus</span>","value":"walrus"},{"type":"html","content":"<span class='clj-symbol'>and</span>","value":"and"},{"type":"html","content":"<span class='clj-symbol'>you</span>","value":"you"},{"type":"html","content":"<span class='clj-symbol'>said</span>","value":"said"},{"type":"html","content":"<span class='clj-symbol'>finally</span>","value":"finally"},{"type":"html","content":"<span class='clj-symbol'>that</span>","value":"that"},{"type":"html","content":"<span class='clj-symbol'>the</span>","value":"the"},{"type":"html","content":"<span class='clj-symbol'>pineapple</span>","value":"pineapple"},{"type":"html","content":"<span class='clj-symbol'>loathed</span>","value":"loathed"},{"type":"html","content":"<span class='clj-symbol'>the</span>","value":"the"},{"type":"html","content":"<span class='clj-symbol'>pedestrian</span>","value":"pedestrian"}],"value":"(I said that the walrus apprehended a walrus and you said that the pineapple loathed the pedestrian to which I replied that the walrus apprehended a walrus and you said finally that the pineapple loathed the pedestrian)"}
;; <=

;; @@
(let [x 0
      x (+ x 1)
      x (* x 100)
      x (/ x 20)]
  x)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>5</span>","value":"5"}
;; <=

;; @@
(defn print-sentence
  "Prints a sentence (symbols in a list) followed by a newline."
  [s]
  (doseq [word s] (print word) (print " "))
  (println))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/print-sentence</span>","value":"#'clojinc.core/print-sentence"}
;; <=

;; @@
(print-sentence (sentence))
;; @@
;; ->
;;; a walrus loathed a contingency 
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
;; again:

(print-sentence (sentence))
;; @@
;; ->
;;; a walrus acquired a pineapple 
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(do (cons 'this '(will happen but you will not see it))
    (cons 'because '(all that gets returned from a "do" form))
    (cons 'is '(the value of the last form within it)))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>is</span>","value":"is"},{"type":"html","content":"<span class='clj-symbol'>the</span>","value":"the"},{"type":"html","content":"<span class='clj-symbol'>value</span>","value":"value"},{"type":"html","content":"<span class='clj-symbol'>of</span>","value":"of"},{"type":"html","content":"<span class='clj-symbol'>the</span>","value":"the"},{"type":"html","content":"<span class='clj-symbol'>last</span>","value":"last"},{"type":"html","content":"<span class='clj-symbol'>form</span>","value":"form"},{"type":"html","content":"<span class='clj-symbol'>within</span>","value":"within"},{"type":"html","content":"<span class='clj-symbol'>it</span>","value":"it"}],"value":"(is the value of the last form within it)"}
;; <=

;; @@
;; Problem Set 4:
;; - Generate random blues song lyrics. They should include repeated lines.
;; - Generate random melodies that include repeated lines.
;; @@

;; @@
;; this is a set:

#{:tree :mushroom :aardvark} 
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-set'>#{</span>","close":"<span class='clj-set'>}</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:tree</span>","value":":tree"},{"type":"html","content":"<span class='clj-keyword'>:aardvark</span>","value":":aardvark"},{"type":"html","content":"<span class='clj-keyword'>:mushroom</span>","value":":mushroom"}],"value":"#{:tree :aardvark :mushroom}"}
;; <=

;; @@
(:tree #{:tree :mushroom :aardvark})
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-keyword'>:tree</span>","value":":tree"}
;; <=

;; @@
(:tree #{:free :mushroom :aardvark})
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(#{:tree :mushroom :aardvark} :tree)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-keyword'>:tree</span>","value":":tree"}
;; <=

;; @@
(contains? #{:free :mushroom :aardvark} :free)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
(some #{:free} #{:free :mushroom :aardvark})
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-keyword'>:free</span>","value":":free"}
;; <=

;; @@
(some even? #{9 3 4 1 11 8})
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
(use 'clojure.set)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(select even? #{9 3 4 1 11 8})
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-set'>#{</span>","close":"<span class='clj-set'>}</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-long'>8</span>","value":"8"}],"value":"#{4 8}"}
;; <=

;; @@
(conj #{:tree :mushroom :aardvark} :poppy)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-set'>#{</span>","close":"<span class='clj-set'>}</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:tree</span>","value":":tree"},{"type":"html","content":"<span class='clj-keyword'>:aardvark</span>","value":":aardvark"},{"type":"html","content":"<span class='clj-keyword'>:mushroom</span>","value":":mushroom"},{"type":"html","content":"<span class='clj-keyword'>:poppy</span>","value":":poppy"}],"value":"#{:tree :aardvark :mushroom :poppy}"}
;; <=

;; @@
(disj #{:tree :mushroom :aardvark} :tree)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-set'>#{</span>","close":"<span class='clj-set'>}</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:aardvark</span>","value":":aardvark"},{"type":"html","content":"<span class='clj-keyword'>:mushroom</span>","value":":mushroom"}],"value":"#{:aardvark :mushroom}"}
;; <=

;; @@
;; more ways of making sets:

(hash-set :tomato :cucumber :basil)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-set'>#{</span>","close":"<span class='clj-set'>}</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:cucumber</span>","value":":cucumber"},{"type":"html","content":"<span class='clj-keyword'>:basil</span>","value":":basil"},{"type":"html","content":"<span class='clj-keyword'>:tomato</span>","value":":tomato"}],"value":"#{:cucumber :basil :tomato}"}
;; <=

;; @@
(sorted-set :tomato :cucumber :basil)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-set'>#{</span>","close":"<span class='clj-set'>}</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:basil</span>","value":":basil"},{"type":"html","content":"<span class='clj-keyword'>:cucumber</span>","value":":cucumber"},{"type":"html","content":"<span class='clj-keyword'>:tomato</span>","value":":tomato"}],"value":"#{:basil :cucumber :tomato}"}
;; <=

;; @@
(set '(apples bananas))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-set'>#{</span>","close":"<span class='clj-set'>}</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>apples</span>","value":"apples"},{"type":"html","content":"<span class='clj-symbol'>bananas</span>","value":"bananas"}],"value":"#{apples bananas}"}
;; <=

;; @@
(into #{} '(apples bananas))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-set'>#{</span>","close":"<span class='clj-set'>}</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>apples</span>","value":"apples"},{"type":"html","content":"<span class='clj-symbol'>bananas</span>","value":"bananas"}],"value":"#{apples bananas}"}
;; <=

;; @@
(set (str 123))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-set'>#{</span>","close":"<span class='clj-set'>}</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-char'>\\1</span>","value":"\\1"},{"type":"html","content":"<span class='clj-char'>\\2</span>","value":"\\2"},{"type":"html","content":"<span class='clj-char'>\\3</span>","value":"\\3"}],"value":"#{\\1 \\2 \\3}"}
;; <=

;; @@
(defn member? 
  "Returns true if item is in lst, false otherwise."
  [item lst]
  (if (some #{item} lst) true false))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/member?</span>","value":"#'clojinc.core/member?"}
;; <=

;; @@
(member? \b (set "Eggbert"))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
(member? 1 '(2 3 1 5))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
(member? \1 (set (str 2315)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
(member? \6 (set (str 2315)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>false</span>","value":"false"}
;; <=

;; @@
(intersection #{:free :mushroom :aardvark}
              #{:tree :mushroom :aardvark})
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-set'>#{</span>","close":"<span class='clj-set'>}</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:aardvark</span>","value":":aardvark"},{"type":"html","content":"<span class='clj-keyword'>:mushroom</span>","value":":mushroom"}],"value":"#{:aardvark :mushroom}"}
;; <=

;; @@
(union #{:free :mushroom :aardvark}
       #{:tree :mushroom :aardvark})
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-set'>#{</span>","close":"<span class='clj-set'>}</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:tree</span>","value":":tree"},{"type":"html","content":"<span class='clj-keyword'>:aardvark</span>","value":":aardvark"},{"type":"html","content":"<span class='clj-keyword'>:free</span>","value":":free"},{"type":"html","content":"<span class='clj-keyword'>:mushroom</span>","value":":mushroom"}],"value":"#{:tree :aardvark :free :mushroom}"}
;; <=

;; @@
(difference #{:free :mushroom :aardvark}
            #{:tree :mushroom :aardvark})
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-set'>#{</span>","close":"<span class='clj-set'>}</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:free</span>","value":":free"}],"value":"#{:free}"}
;; <=

;; @@
(subset? #{:mushroom :aardvark}
         #{:tree :mushroom :aardvark})
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
(superset? #{:tree :mushroom :aardvark}
           #{:mushroom :aardvark})
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
(let [my-sentence (sentence)]
  (if (some #{'walrus} my-sentence)
    (println 'pussycat)
    (print-sentence my-sentence)))
;; @@
;; ->
;;; pussycat
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
;; again:

(let [my-sentence (sentence)]
  (if (some #{'walrus} my-sentence)
    (println 'pussycat)
    (print-sentence my-sentence)))
;; @@
;; ->
;;; the pedestrian confounded the pineapple 
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
;; Problem Set 5:
;; - Create a list of your favorite things.
;; - Write a function that creates two random subsets of your favorite things
;;   and prints out their intersection and differences.
;; - Enhance the function above to print a special message if the two subsets are equal.
;; @@

;; @@
(dotimes [i 10] (println i))
;; @@
;; ->
;;; 0
;;; 1
;;; 2
;;; 3
;;; 4
;;; 5
;;; 6
;;; 7
;;; 8
;;; 9
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
;; the name "_" is idiomatic for "generic name, I won't refer to it"

(dotimes [_ 5] (print-sentence (sentence)))
;; @@
;; ->
;;; a steamboat apprehended a columnist 
;;; the pineapple loathed a pedestrian 
;;; a columnist apprehended the contingency 
;;; a steamboat apprehended the steamboat 
;;; a pineapple loathed a walrus 
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(time (dotimes [i 1000000] (/ i 23)))
;; @@
;; ->
;;; &quot;Elapsed time: 400.240206 msecs&quot;
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(range 10)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>(0 1 2 3 4 5 6 7 8 9)</span>","value":"(0 1 2 3 4 5 6 7 8 9)"}
;; <=

;; @@
(range 100 110)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>(100 101 102 103 104 105 106 107 108 109)</span>","value":"(100 101 102 103 104 105 106 107 108 109)"}
;; <=

;; @@
(range 100 110 2)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>(100 102 104 106 108)</span>","value":"(100 102 104 106 108)"}
;; <=

;; @@
(inc 1)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>2</span>","value":"2"}
;; <=

;; @@
(map inc (range 10))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-long'>6</span>","value":"6"},{"type":"html","content":"<span class='clj-long'>7</span>","value":"7"},{"type":"html","content":"<span class='clj-long'>8</span>","value":"8"},{"type":"html","content":"<span class='clj-long'>9</span>","value":"9"},{"type":"html","content":"<span class='clj-long'>10</span>","value":"10"}],"value":"(1 2 3 4 5 6 7 8 9 10)"}
;; <=

;; @@
(map (fn [x] (* x 2)) (range 10))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>0</span>","value":"0"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-long'>6</span>","value":"6"},{"type":"html","content":"<span class='clj-long'>8</span>","value":"8"},{"type":"html","content":"<span class='clj-long'>10</span>","value":"10"},{"type":"html","content":"<span class='clj-long'>12</span>","value":"12"},{"type":"html","content":"<span class='clj-long'>14</span>","value":"14"},{"type":"html","content":"<span class='clj-long'>16</span>","value":"16"},{"type":"html","content":"<span class='clj-long'>18</span>","value":"18"}],"value":"(0 2 4 6 8 10 12 14 16 18)"}
;; <=

;; @@
(map #(* % 2) (range 10))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>0</span>","value":"0"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-long'>6</span>","value":"6"},{"type":"html","content":"<span class='clj-long'>8</span>","value":"8"},{"type":"html","content":"<span class='clj-long'>10</span>","value":"10"},{"type":"html","content":"<span class='clj-long'>12</span>","value":"12"},{"type":"html","content":"<span class='clj-long'>14</span>","value":"14"},{"type":"html","content":"<span class='clj-long'>16</span>","value":"16"},{"type":"html","content":"<span class='clj-long'>18</span>","value":"18"}],"value":"(0 2 4 6 8 10 12 14 16 18)"}
;; <=

;; @@
;; this makes an infinite lazy sequence of random numbers (don't try to print it all!):

(def rands (repeatedly rand))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/rands</span>","value":"#'clojinc.core/rands"}
;; <=

;; @@
(take 2 rands)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-double'>0.45313160948201425</span>","value":"0.45313160948201425"},{"type":"html","content":"<span class='clj-double'>0.9443898092870535</span>","value":"0.9443898092870535"}],"value":"(0.45313160948201425 0.9443898092870535)"}
;; <=

;; @@
(take 3 rands)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-double'>0.45313160948201425</span>","value":"0.45313160948201425"},{"type":"html","content":"<span class='clj-double'>0.9443898092870535</span>","value":"0.9443898092870535"},{"type":"html","content":"<span class='clj-double'>0.0022828248142596763</span>","value":"0.0022828248142596763"}],"value":"(0.45313160948201425 0.9443898092870535 0.0022828248142596763)"}
;; <=

;; @@
(defn slowmult
  [n m]
  (dotimes [i 1000000] (/ i 23))  ;; just wasting time here
  (* n m))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/slowmult</span>","value":"#'clojinc.core/slowmult"}
;; <=

;; @@
(time (slowmult 5 5))
;; @@
;; ->
;;; &quot;Elapsed time: 520.186726 msecs&quot;
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-long'>25</span>","value":"25"}
;; <=

;; @@
(time (doall (map #(slowmult % 2) (range 10))))
;; @@
;; ->
;;; &quot;Elapsed time: 1229.739047 msecs&quot;
;;; 
;; <-
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>0</span>","value":"0"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-long'>6</span>","value":"6"},{"type":"html","content":"<span class='clj-long'>8</span>","value":"8"},{"type":"html","content":"<span class='clj-long'>10</span>","value":"10"},{"type":"html","content":"<span class='clj-long'>12</span>","value":"12"},{"type":"html","content":"<span class='clj-long'>14</span>","value":"14"},{"type":"html","content":"<span class='clj-long'>16</span>","value":"16"},{"type":"html","content":"<span class='clj-long'>18</span>","value":"18"}],"value":"(0 2 4 6 8 10 12 14 16 18)"}
;; <=

;; @@
;; pmap uses a thread pool

(time (doall (pmap #(slowmult % 2) (range 10))))
;; @@
;; ->
;;; &quot;Elapsed time: 299.986282 msecs&quot;
;;; 
;; <-
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>0</span>","value":"0"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-long'>6</span>","value":"6"},{"type":"html","content":"<span class='clj-long'>8</span>","value":"8"},{"type":"html","content":"<span class='clj-long'>10</span>","value":"10"},{"type":"html","content":"<span class='clj-long'>12</span>","value":"12"},{"type":"html","content":"<span class='clj-long'>14</span>","value":"14"},{"type":"html","content":"<span class='clj-long'>16</span>","value":"16"},{"type":"html","content":"<span class='clj-long'>18</span>","value":"18"}],"value":"(0 2 4 6 8 10 12 14 16 18)"}
;; <=

;; @@
(filter even? (range 10))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>0</span>","value":"0"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-long'>6</span>","value":"6"},{"type":"html","content":"<span class='clj-long'>8</span>","value":"8"}],"value":"(0 2 4 6 8)"}
;; <=

;; @@
;; Problem Set 6:
;; - Generate a set of even numbers between 1 and 101.
;; - Generate a set of odd numbers between 1 and 101.
;; - Show that the union of these sets is all of the numbers between 1 and 101.
;; - Write a function that tests if a number is prime.
;; - Create an infinite lazy sequence of prime numbers.
;; - Generate a set of all of the prime numbers less than 1001 that contain the digit 3.
;; - How many prime numbers less than 1001 don't contain a 3 or a 7?
;; @@

;; @@
[1 2 3 4]  ;; that's a vector
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"}],"value":"[1 2 3 4]"}
;; <=

;; @@
(1 2 3 4)
;; @@

;; @@
'(1 2 3 4)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"}],"value":"(1 2 3 4)"}
;; <=

;; @@
'(a b c d)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>a</span>","value":"a"},{"type":"html","content":"<span class='clj-symbol'>b</span>","value":"b"},{"type":"html","content":"<span class='clj-symbol'>c</span>","value":"c"},{"type":"html","content":"<span class='clj-symbol'>d</span>","value":"d"}],"value":"(a b c d)"}
;; <=

;; @@
[a b c d]
;; @@

;; @@
[a b c d]
;; @@

;; @@
;; this is a keyword, which evaluates to itself:

:hi 
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-keyword'>:hi</span>","value":":hi"}
;; <=

;; @@
:i-am-a-keyword
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-keyword'>:i-am-a-keyword</span>","value":":i-am-a-keyword"}
;; <=

;; @@
;; this is a vector of keywords:

[:biff :bam :blotto :blink :blorg]
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:biff</span>","value":":biff"},{"type":"html","content":"<span class='clj-keyword'>:bam</span>","value":":bam"},{"type":"html","content":"<span class='clj-keyword'>:blotto</span>","value":":blotto"},{"type":"html","content":"<span class='clj-keyword'>:blink</span>","value":":blink"},{"type":"html","content":"<span class='clj-keyword'>:blorg</span>","value":":blorg"}],"value":"[:biff :bam :blotto :blink :blorg]"}
;; <=

;; @@
(nth [:biff :bam :blotto :blink :blorg] 3)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-keyword'>:blink</span>","value":":blink"}
;; <=

;; @@
(nth [:biff :bam :blotto :blink :blorg] 0)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-keyword'>:biff</span>","value":":biff"}
;; <=

;; @@
(subvec [:biff :bam :blotto :blink :blorg] 1 3)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:bam</span>","value":":bam"},{"type":"html","content":"<span class='clj-keyword'>:blotto</span>","value":":blotto"}],"value":"[:bam :blotto]"}
;; <=

;; @@
(into () [:biff :bam :blotto :blink :blorg]) ;; ends up reversed
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:blorg</span>","value":":blorg"},{"type":"html","content":"<span class='clj-keyword'>:blink</span>","value":":blink"},{"type":"html","content":"<span class='clj-keyword'>:blotto</span>","value":":blotto"},{"type":"html","content":"<span class='clj-keyword'>:bam</span>","value":":bam"},{"type":"html","content":"<span class='clj-keyword'>:biff</span>","value":":biff"}],"value":"(:blorg :blink :blotto :bam :biff)"}
;; <=

;; @@
(into [] '(:biff :bam :blotto :blink :blorg))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:biff</span>","value":":biff"},{"type":"html","content":"<span class='clj-keyword'>:bam</span>","value":":bam"},{"type":"html","content":"<span class='clj-keyword'>:blotto</span>","value":":blotto"},{"type":"html","content":"<span class='clj-keyword'>:blink</span>","value":":blink"},{"type":"html","content":"<span class='clj-keyword'>:blorg</span>","value":":blorg"}],"value":"[:biff :bam :blotto :blink :blorg]"}
;; <=

;; @@
(def lots-of-numbers (take 10000 (iterate inc 0)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/lots-of-numbers</span>","value":"#'clojinc.core/lots-of-numbers"}
;; <=

;; @@
(take 20 lots-of-numbers)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>0</span>","value":"0"},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-long'>6</span>","value":"6"},{"type":"html","content":"<span class='clj-long'>7</span>","value":"7"},{"type":"html","content":"<span class='clj-long'>8</span>","value":"8"},{"type":"html","content":"<span class='clj-long'>9</span>","value":"9"},{"type":"html","content":"<span class='clj-long'>10</span>","value":"10"},{"type":"html","content":"<span class='clj-long'>11</span>","value":"11"},{"type":"html","content":"<span class='clj-long'>12</span>","value":"12"},{"type":"html","content":"<span class='clj-long'>13</span>","value":"13"},{"type":"html","content":"<span class='clj-long'>14</span>","value":"14"},{"type":"html","content":"<span class='clj-long'>15</span>","value":"15"},{"type":"html","content":"<span class='clj-long'>16</span>","value":"16"},{"type":"html","content":"<span class='clj-long'>17</span>","value":"17"},{"type":"html","content":"<span class='clj-long'>18</span>","value":"18"},{"type":"html","content":"<span class='clj-long'>19</span>","value":"19"}],"value":"(0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19)"}
;; <=

;; @@
(take-last 5 lots-of-numbers)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>9995</span>","value":"9995"},{"type":"html","content":"<span class='clj-long'>9996</span>","value":"9996"},{"type":"html","content":"<span class='clj-long'>9997</span>","value":"9997"},{"type":"html","content":"<span class='clj-long'>9998</span>","value":"9998"},{"type":"html","content":"<span class='clj-long'>9999</span>","value":"9999"}],"value":"(9995 9996 9997 9998 9999)"}
;; <=

;; @@
(take-while #(< % 8) lots-of-numbers)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>0</span>","value":"0"},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-long'>6</span>","value":"6"},{"type":"html","content":"<span class='clj-long'>7</span>","value":"7"}],"value":"(0 1 2 3 4 5 6 7)"}
;; <=

;; @@
(take 10 (take-nth 3 lots-of-numbers))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>0</span>","value":"0"},{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-long'>6</span>","value":"6"},{"type":"html","content":"<span class='clj-long'>9</span>","value":"9"},{"type":"html","content":"<span class='clj-long'>12</span>","value":"12"},{"type":"html","content":"<span class='clj-long'>15</span>","value":"15"},{"type":"html","content":"<span class='clj-long'>18</span>","value":"18"},{"type":"html","content":"<span class='clj-long'>21</span>","value":"21"},{"type":"html","content":"<span class='clj-long'>24</span>","value":"24"},{"type":"html","content":"<span class='clj-long'>27</span>","value":"27"}],"value":"(0 3 6 9 12 15 18 21 24 27)"}
;; <=

;; @@
(def longlist (into () lots-of-numbers))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/longlist</span>","value":"#'clojinc.core/longlist"}
;; <=

;; @@
(def longvec (into [] lots-of-numbers))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/longvec</span>","value":"#'clojinc.core/longvec"}
;; <=

;; @@
(time (nth longlist 9000))
;; @@
;; ->
;;; &quot;Elapsed time: 0.190496 msecs&quot;
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-long'>999</span>","value":"999"}
;; <=

;; @@
(time (nth longvec 9000))
;; @@
;; ->
;;; &quot;Elapsed time: 0.033385 msecs&quot;
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-long'>9000</span>","value":"9000"}
;; <=

;; @@
(defn shuffle-deep
  [nested-list]
  (if (not (seq? nested-list))
    nested-list
    (shuffle (map shuffle-deep nested-list))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/shuffle-deep</span>","value":"#'clojinc.core/shuffle-deep"}
;; <=

;; @@
(shuffle-deep '(peas (carrots celery) ((scallops shrimp) (cheddar havarti))))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>peas</span>","value":"peas"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>celery</span>","value":"celery"},{"type":"html","content":"<span class='clj-symbol'>carrots</span>","value":"carrots"}],"value":"[celery carrots]"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>cheddar</span>","value":"cheddar"},{"type":"html","content":"<span class='clj-symbol'>havarti</span>","value":"havarti"}],"value":"[cheddar havarti]"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>scallops</span>","value":"scallops"},{"type":"html","content":"<span class='clj-symbol'>shrimp</span>","value":"shrimp"}],"value":"[scallops shrimp]"}],"value":"[[cheddar havarti] [scallops shrimp]]"}],"value":"[peas [celery carrots] [[cheddar havarti] [scallops shrimp]]]"}
;; <=

;; @@
(assoc [0 0 0 0 0 0 0] 3 1)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>0</span>","value":"0"},{"type":"html","content":"<span class='clj-long'>0</span>","value":"0"},{"type":"html","content":"<span class='clj-long'>0</span>","value":"0"},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>0</span>","value":"0"},{"type":"html","content":"<span class='clj-long'>0</span>","value":"0"},{"type":"html","content":"<span class='clj-long'>0</span>","value":"0"}],"value":"[0 0 0 1 0 0 0]"}
;; <=

;; @@
;; Problem Set 7:
;; - Write a function that produces a shuffled deck of cards, where the deck is a vector
;;   and each card is a vector like [7 :spades] or [:king :hearts].
;; - Deal five cards to each of two players and determine who has a better poker hand.
;;   This is complicated to do completely, but start by defining functions to detect
;;   pairs, three-of-a-kind, four-of-a-kind, fluses, straights, etc. Then combine them 
;;   to define the full function to determine a winner.
;; @@

;; @@
(defn sandwich
  [main-ingredient]
  (concat '(a) (list main-ingredient) '(sandwich with a pickle, please)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/sandwich</span>","value":"#'clojinc.core/sandwich"}
;; <=

;; @@
(sandwich 'pastrami)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>a</span>","value":"a"},{"type":"html","content":"<span class='clj-symbol'>pastrami</span>","value":"pastrami"},{"type":"html","content":"<span class='clj-symbol'>sandwich</span>","value":"sandwich"},{"type":"html","content":"<span class='clj-symbol'>with</span>","value":"with"},{"type":"html","content":"<span class='clj-symbol'>a</span>","value":"a"},{"type":"html","content":"<span class='clj-symbol'>pickle</span>","value":"pickle"},{"type":"html","content":"<span class='clj-symbol'>please</span>","value":"please"}],"value":"(a pastrami sandwich with a pickle please)"}
;; <=

;; @@
(sandwich 'pastrami 'cheese)
;; @@

;; @@
;; two implementations, one for each of two argument lists:

(defn sandwich
  ([main-ingredient]
    (concat '(a) (list main-ingredient) '(sandwich with a pickle, please)))
  ([main-ingredient second-ingredient]
    (concat '(a) (list main-ingredient) '(and) (list second-ingredient) '(sandwich with a pickle))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/sandwich</span>","value":"#'clojinc.core/sandwich"}
;; <=

;; @@
(sandwich 'pastrami)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>a</span>","value":"a"},{"type":"html","content":"<span class='clj-symbol'>pastrami</span>","value":"pastrami"},{"type":"html","content":"<span class='clj-symbol'>sandwich</span>","value":"sandwich"},{"type":"html","content":"<span class='clj-symbol'>with</span>","value":"with"},{"type":"html","content":"<span class='clj-symbol'>a</span>","value":"a"},{"type":"html","content":"<span class='clj-symbol'>pickle</span>","value":"pickle"},{"type":"html","content":"<span class='clj-symbol'>please</span>","value":"please"}],"value":"(a pastrami sandwich with a pickle please)"}
;; <=

;; @@
(sandwich 'pastrami 'cheese)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>a</span>","value":"a"},{"type":"html","content":"<span class='clj-symbol'>pastrami</span>","value":"pastrami"},{"type":"html","content":"<span class='clj-symbol'>and</span>","value":"and"},{"type":"html","content":"<span class='clj-symbol'>cheese</span>","value":"cheese"},{"type":"html","content":"<span class='clj-symbol'>sandwich</span>","value":"sandwich"},{"type":"html","content":"<span class='clj-symbol'>with</span>","value":"with"},{"type":"html","content":"<span class='clj-symbol'>a</span>","value":"a"},{"type":"html","content":"<span class='clj-symbol'>pickle</span>","value":"pickle"}],"value":"(a pastrami and cheese sandwich with a pickle)"}
;; <=

;; @@
(defn assume-cheese
  "calls with one arg use a default of cheese for second"
  ([main-ingredient]
    (assume-cheese main-ingredient 'cheese))
  ([main-ingredient second-ingredient]
    (concat '(a) (list main-ingredient) '(and) (list second-ingredient) '(sandwich with a pickle))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/assume-cheese</span>","value":"#'clojinc.core/assume-cheese"}
;; <=

;; @@
(assume-cheese 'ham)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>a</span>","value":"a"},{"type":"html","content":"<span class='clj-symbol'>ham</span>","value":"ham"},{"type":"html","content":"<span class='clj-symbol'>and</span>","value":"and"},{"type":"html","content":"<span class='clj-symbol'>cheese</span>","value":"cheese"},{"type":"html","content":"<span class='clj-symbol'>sandwich</span>","value":"sandwich"},{"type":"html","content":"<span class='clj-symbol'>with</span>","value":"with"},{"type":"html","content":"<span class='clj-symbol'>a</span>","value":"a"},{"type":"html","content":"<span class='clj-symbol'>pickle</span>","value":"pickle"}],"value":"(a ham and cheese sandwich with a pickle)"}
;; <=

;; @@
(assume-cheese 'spam 'rutabaga)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>a</span>","value":"a"},{"type":"html","content":"<span class='clj-symbol'>spam</span>","value":"spam"},{"type":"html","content":"<span class='clj-symbol'>and</span>","value":"and"},{"type":"html","content":"<span class='clj-symbol'>rutabaga</span>","value":"rutabaga"},{"type":"html","content":"<span class='clj-symbol'>sandwich</span>","value":"sandwich"},{"type":"html","content":"<span class='clj-symbol'>with</span>","value":"with"},{"type":"html","content":"<span class='clj-symbol'>a</span>","value":"a"},{"type":"html","content":"<span class='clj-symbol'>pickle</span>","value":"pickle"}],"value":"(a spam and rutabaga sandwich with a pickle)"}
;; <=

;; @@
;; this is a map:

{:name "Edgar Allen Poe" :born 1809 :birthplace "Boston, MA" :residence "Baltimore, MD"} 
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:name</span>","value":":name"},{"type":"html","content":"<span class='clj-string'>&quot;Edgar Allen Poe&quot;</span>","value":"\"Edgar Allen Poe\""}],"value":"[:name \"Edgar Allen Poe\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:born</span>","value":":born"},{"type":"html","content":"<span class='clj-long'>1809</span>","value":"1809"}],"value":"[:born 1809]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:birthplace</span>","value":":birthplace"},{"type":"html","content":"<span class='clj-string'>&quot;Boston, MA&quot;</span>","value":"\"Boston, MA\""}],"value":"[:birthplace \"Boston, MA\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:residence</span>","value":":residence"},{"type":"html","content":"<span class='clj-string'>&quot;Baltimore, MD&quot;</span>","value":"\"Baltimore, MD\""}],"value":"[:residence \"Baltimore, MD\"]"}],"value":"{:name \"Edgar Allen Poe\", :born 1809, :birthplace \"Boston, MA\", :residence \"Baltimore, MD\"}"}
;; <=

;; @@
;; commas are whitespace:

(+ , 2 ,,,,, ,,,,, 3)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>5</span>","value":"5"}
;; <=

;; @@
(def eddie {:name "Edgar Allen Poe", :born 1809, :birthplace "Boston, MA", :residence "Baltimore, MD"})
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/eddie</span>","value":"#'clojinc.core/eddie"}
;; <=

;; @@
(:born eddie)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>1809</span>","value":"1809"}
;; <=

;; @@
(eddie :born)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>1809</span>","value":"1809"}
;; <=

;; @@
(get eddie :born)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>1809</span>","value":"1809"}
;; <=

;; @@
(get eddie :died)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(get eddie :died :never)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-keyword'>:never</span>","value":":never"}
;; <=

;; @@
(keys eddie)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>(:name :born :birthplace :residence)</span>","value":"(:name :born :birthplace :residence)"}
;; <=

;; @@
(vals eddie)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>(&quot;Edgar Allen Poe&quot; 1809 &quot;Boston, MA&quot; &quot;Baltimore, MD&quot;)</span>","value":"(\"Edgar Allen Poe\" 1809 \"Boston, MA\" \"Baltimore, MD\")"}
;; <=

;; @@
(assoc eddie :died 1849)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:name</span>","value":":name"},{"type":"html","content":"<span class='clj-string'>&quot;Edgar Allen Poe&quot;</span>","value":"\"Edgar Allen Poe\""}],"value":"[:name \"Edgar Allen Poe\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:born</span>","value":":born"},{"type":"html","content":"<span class='clj-long'>1809</span>","value":"1809"}],"value":"[:born 1809]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:birthplace</span>","value":":birthplace"},{"type":"html","content":"<span class='clj-string'>&quot;Boston, MA&quot;</span>","value":"\"Boston, MA\""}],"value":"[:birthplace \"Boston, MA\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:residence</span>","value":":residence"},{"type":"html","content":"<span class='clj-string'>&quot;Baltimore, MD&quot;</span>","value":"\"Baltimore, MD\""}],"value":"[:residence \"Baltimore, MD\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:died</span>","value":":died"},{"type":"html","content":"<span class='clj-long'>1849</span>","value":"1849"}],"value":"[:died 1849]"}],"value":"{:name \"Edgar Allen Poe\", :born 1809, :birthplace \"Boston, MA\", :residence \"Baltimore, MD\", :died 1849}"}
;; <=

;; @@
eddie
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:name</span>","value":":name"},{"type":"html","content":"<span class='clj-string'>&quot;Edgar Allen Poe&quot;</span>","value":"\"Edgar Allen Poe\""}],"value":"[:name \"Edgar Allen Poe\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:born</span>","value":":born"},{"type":"html","content":"<span class='clj-long'>1809</span>","value":"1809"}],"value":"[:born 1809]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:birthplace</span>","value":":birthplace"},{"type":"html","content":"<span class='clj-string'>&quot;Boston, MA&quot;</span>","value":"\"Boston, MA\""}],"value":"[:birthplace \"Boston, MA\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:residence</span>","value":":residence"},{"type":"html","content":"<span class='clj-string'>&quot;Baltimore, MD&quot;</span>","value":"\"Baltimore, MD\""}],"value":"[:residence \"Baltimore, MD\"]"}],"value":"{:name \"Edgar Allen Poe\", :born 1809, :birthplace \"Boston, MA\", :residence \"Baltimore, MD\"}"}
;; <=

;; @@
(inspect eddie)

; < window opens >
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>#object[javax.swing.JFrame 0x7c961f93 &quot;javax.swing.JFrame[frame3,0,23,400x400,invalid,layout=java.awt.BorderLayout,title=Clojure Inspector,resizable,normal,defaultCloseOperation=HIDE_ON_CLOSE,rootPane=javax.swing.JRootPane[,0,22,400x378,invalid,layout=javax.swing.JRootPane$RootLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=16777673,maximumSize=,minimumSize=,preferredSize=],rootPaneCheckingEnabled=true]&quot;]</span>","value":"#object[javax.swing.JFrame 0x7c961f93 \"javax.swing.JFrame[frame3,0,23,400x400,invalid,layout=java.awt.BorderLayout,title=Clojure Inspector,resizable,normal,defaultCloseOperation=HIDE_ON_CLOSE,rootPane=javax.swing.JRootPane[,0,22,400x378,invalid,layout=javax.swing.JRootPane$RootLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=16777673,maximumSize=,minimumSize=,preferredSize=],rootPaneCheckingEnabled=true]\"]"}
;; <=

;; @@
(merge eddie {:wife "Virginia Clemm"})
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:name</span>","value":":name"},{"type":"html","content":"<span class='clj-string'>&quot;Edgar Allen Poe&quot;</span>","value":"\"Edgar Allen Poe\""}],"value":"[:name \"Edgar Allen Poe\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:born</span>","value":":born"},{"type":"html","content":"<span class='clj-long'>1809</span>","value":"1809"}],"value":"[:born 1809]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:birthplace</span>","value":":birthplace"},{"type":"html","content":"<span class='clj-string'>&quot;Boston, MA&quot;</span>","value":"\"Boston, MA\""}],"value":"[:birthplace \"Boston, MA\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:residence</span>","value":":residence"},{"type":"html","content":"<span class='clj-string'>&quot;Baltimore, MD&quot;</span>","value":"\"Baltimore, MD\""}],"value":"[:residence \"Baltimore, MD\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:wife</span>","value":":wife"},{"type":"html","content":"<span class='clj-string'>&quot;Virginia Clemm&quot;</span>","value":"\"Virginia Clemm\""}],"value":"[:wife \"Virginia Clemm\"]"}],"value":"{:name \"Edgar Allen Poe\", :born 1809, :birthplace \"Boston, MA\", :residence \"Baltimore, MD\", :wife \"Virginia Clemm\"}"}
;; <=

;; @@
(dissoc eddie :born)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:name</span>","value":":name"},{"type":"html","content":"<span class='clj-string'>&quot;Edgar Allen Poe&quot;</span>","value":"\"Edgar Allen Poe\""}],"value":"[:name \"Edgar Allen Poe\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:birthplace</span>","value":":birthplace"},{"type":"html","content":"<span class='clj-string'>&quot;Boston, MA&quot;</span>","value":"\"Boston, MA\""}],"value":"[:birthplace \"Boston, MA\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:residence</span>","value":":residence"},{"type":"html","content":"<span class='clj-string'>&quot;Baltimore, MD&quot;</span>","value":"\"Baltimore, MD\""}],"value":"[:residence \"Baltimore, MD\"]"}],"value":"{:name \"Edgar Allen Poe\", :birthplace \"Boston, MA\", :residence \"Baltimore, MD\"}"}
;; <=

;; @@
;; -> and ->> are called "threading" operators
;; They provide an alternative syntax for passing a value through a sequence of calls.
;; -> threads each result into the first argument position of the next form
;; So (-> foo (bar baz) (bingo bonkers)) evaluates foo to produce (let's say) X, then
;; evaluates (bar X baz) to produce (let's say) Y, and then (bingo Y bonkers).

(-> 0 
    (- 10)
    (/ 2)
    (cons '(is the answer)))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>-5</span>","value":"-5"},{"type":"html","content":"<span class='clj-symbol'>is</span>","value":"is"},{"type":"html","content":"<span class='clj-symbol'>the</span>","value":"the"},{"type":"html","content":"<span class='clj-symbol'>answer</span>","value":"answer"}],"value":"(-5 is the answer)"}
;; <=

;; @@
;; in non-threaded form that would be:

(cons (/ (- 0 10) 2) '(is the answer))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>-5</span>","value":"-5"},{"type":"html","content":"<span class='clj-symbol'>is</span>","value":"is"},{"type":"html","content":"<span class='clj-symbol'>the</span>","value":"the"},{"type":"html","content":"<span class='clj-symbol'>answer</span>","value":"answer"}],"value":"(-5 is the answer)"}
;; <=

;; @@
;; ->> threads into the last argument position, rather than the first


(->> 0 
     (- 10)
     (/ 2))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-ratio'>1/5</span>","value":"1/5"}
;; <=

;; @@
(-> eddie
    (assoc :died 1849)
    (assoc :wife "Virginia Clemm")
    (dissoc :born)
    (dissoc :birthplace))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-map'>{</span>","close":"<span class='clj-map'>}</span>","separator":", ","items":[{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:name</span>","value":":name"},{"type":"html","content":"<span class='clj-string'>&quot;Edgar Allen Poe&quot;</span>","value":"\"Edgar Allen Poe\""}],"value":"[:name \"Edgar Allen Poe\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:residence</span>","value":":residence"},{"type":"html","content":"<span class='clj-string'>&quot;Baltimore, MD&quot;</span>","value":"\"Baltimore, MD\""}],"value":"[:residence \"Baltimore, MD\"]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:died</span>","value":":died"},{"type":"html","content":"<span class='clj-long'>1849</span>","value":"1849"}],"value":"[:died 1849]"},{"type":"list-like","open":"","close":"","separator":" ","items":[{"type":"html","content":"<span class='clj-keyword'>:wife</span>","value":":wife"},{"type":"html","content":"<span class='clj-string'>&quot;Virginia Clemm&quot;</span>","value":"\"Virginia Clemm\""}],"value":"[:wife \"Virginia Clemm\"]"}],"value":"{:name \"Edgar Allen Poe\", :residence \"Baltimore, MD\", :died 1849, :wife \"Virginia Clemm\"}"}
;; <=

;; @@
(def grammar
  {:sentence [:noun-phrase :verb-phrase]
   :noun-phrase [:article :noun]
   :verb-phrase [:verb :noun-phrase]
   :article #{'the 'a}
   :noun #{'walrus 'steamboat 'pedestrian 'columnist 'pineapple 'contingency}
   :verb #{'acquired 'apprehended 'loved 'liked 'loathed 'caressed 'confounded}})
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/grammar</span>","value":"#'clojinc.core/grammar"}
;; <=

;; @@
(defn generate
  [phrase]
  (cond (set? phrase) (generate (rand-nth (vec phrase)))
        (vector? phrase) (apply concat (map generate phrase))
        (= phrase ()) ()
        :else (let [expansion (phrase grammar)]
                (if expansion
                  (generate expansion)
                  (list phrase)))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/generate</span>","value":"#'clojinc.core/generate"}
;; <=

;; @@
(generate :sentence)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>a</span>","value":"a"},{"type":"html","content":"<span class='clj-symbol'>columnist</span>","value":"columnist"},{"type":"html","content":"<span class='clj-symbol'>liked</span>","value":"liked"},{"type":"html","content":"<span class='clj-symbol'>the</span>","value":"the"},{"type":"html","content":"<span class='clj-symbol'>steamboat</span>","value":"steamboat"}],"value":"(a columnist liked the steamboat)"}
;; <=

;; @@
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
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/grammar</span>","value":"#'clojinc.core/grammar"}
;; <=

;; @@
(generate :sentence)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>a</span>","value":"a"},{"type":"html","content":"<span class='clj-symbol'>green</span>","value":"green"},{"type":"html","content":"<span class='clj-symbol'>pineapple</span>","value":"pineapple"},{"type":"html","content":"<span class='clj-symbol'>loathed</span>","value":"loathed"},{"type":"html","content":"<span class='clj-symbol'>penelope</span>","value":"penelope"}],"value":"(a green pineapple loathed penelope)"}
;; <=

;; @@
(generate :sentence)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>a</span>","value":"a"},{"type":"html","content":"<span class='clj-symbol'>contingency</span>","value":"contingency"},{"type":"html","content":"<span class='clj-symbol'>loathed</span>","value":"loathed"},{"type":"html","content":"<span class='clj-symbol'>a</span>","value":"a"},{"type":"html","content":"<span class='clj-symbol'>awesome</span>","value":"awesome"},{"type":"html","content":"<span class='clj-symbol'>little</span>","value":"little"},{"type":"html","content":"<span class='clj-symbol'>awesome</span>","value":"awesome"},{"type":"html","content":"<span class='clj-symbol'>blue</span>","value":"blue"},{"type":"html","content":"<span class='clj-symbol'>steamboat</span>","value":"steamboat"}],"value":"(a contingency loathed a awesome little awesome blue steamboat)"}
;; <=

;; @@
(generate :sentence)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>it</span>","value":"it"},{"type":"html","content":"<span class='clj-symbol'>caressed</span>","value":"caressed"},{"type":"html","content":"<span class='clj-symbol'>that</span>","value":"that"}],"value":"(it caressed that)"}
;; <=

;; @@
(generate :sentence)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>gerald</span>","value":"gerald"},{"type":"html","content":"<span class='clj-symbol'>confounded</span>","value":"confounded"},{"type":"html","content":"<span class='clj-symbol'>gerald</span>","value":"gerald"},{"type":"html","content":"<span class='clj-symbol'>by</span>","value":"by"},{"type":"html","content":"<span class='clj-symbol'>a</span>","value":"a"},{"type":"html","content":"<span class='clj-symbol'>contingency</span>","value":"contingency"},{"type":"html","content":"<span class='clj-symbol'>to</span>","value":"to"},{"type":"html","content":"<span class='clj-symbol'>gertrude</span>","value":"gertrude"}],"value":"(gerald confounded gerald by a contingency to gertrude)"}
;; <=

;; @@
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
;; @@

;; @@
(defn average
  [numbers]
  (float
    (/ (apply + numbers)
       (count numbers))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/average</span>","value":"#'clojinc.core/average"}
;; <=

;; @@
(average (range 10))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>4.5</span>","value":"4.5"}
;; <=

;; @@
(defn average
  [& numbers]
  (float
    (/ (apply + numbers)
       (count numbers))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/average</span>","value":"#'clojinc.core/average"}
;; <=

;; @@
(average 0 1 2 3 4 5 6 7 8 9)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>4.5</span>","value":"4.5"}
;; <=

;; @@
(apply average (range 10))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>4.5</span>","value":"4.5"}
;; <=

;; @@
(reduce average (range 10))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>8.001953</span>","value":"8.001953"}
;; <=

;; @@
(reduce list (range 10))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>0</span>","value":"0"},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"}],"value":"(0 1)"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"}],"value":"((0 1) 2)"},{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"}],"value":"(((0 1) 2) 3)"},{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"}],"value":"((((0 1) 2) 3) 4)"},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"}],"value":"(((((0 1) 2) 3) 4) 5)"},{"type":"html","content":"<span class='clj-long'>6</span>","value":"6"}],"value":"((((((0 1) 2) 3) 4) 5) 6)"},{"type":"html","content":"<span class='clj-long'>7</span>","value":"7"}],"value":"(((((((0 1) 2) 3) 4) 5) 6) 7)"},{"type":"html","content":"<span class='clj-long'>8</span>","value":"8"}],"value":"((((((((0 1) 2) 3) 4) 5) 6) 7) 8)"},{"type":"html","content":"<span class='clj-long'>9</span>","value":"9"}],"value":"(((((((((0 1) 2) 3) 4) 5) 6) 7) 8) 9)"}
;; <=

;; @@
(apply list (range 10))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>0</span>","value":"0"},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-long'>6</span>","value":"6"},{"type":"html","content":"<span class='clj-long'>7</span>","value":"7"},{"type":"html","content":"<span class='clj-long'>8</span>","value":"8"},{"type":"html","content":"<span class='clj-long'>9</span>","value":"9"}],"value":"(0 1 2 3 4 5 6 7 8 9)"}
;; <=

;; @@
(list '+ 1 2)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>+</span>","value":"+"},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"}],"value":"(+ 1 2)"}
;; <=

;; @@
(eval (list '+ 1 2))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>3</span>","value":"3"}
;; <=

;; @@
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
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/X</span>","value":"#'clojinc.core/X"}
;; <=

;; @@
(deref X)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>0</span>","value":"0"}
;; <=

;; @@
;; this is just (handy) shorthand for deref:

@X
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>0</span>","value":"0"}
;; <=

;; @@
(reset! X 23)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>23</span>","value":"23"}
;; <=

;; @@
@X
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>23</span>","value":"23"}
;; <=

;; @@
(eval '(* @X 2))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>46</span>","value":"46"}
;; <=

;; @@
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
;; @@

;; @@
(defn count-fns
  "Returns the number of functions (items in function position) in a symbolic 
   expression."
  [expression]
  (if (list? expression)
    (inc (reduce + (map count-fns (rest expression))))
    0))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/count-fns</span>","value":"#'clojinc.core/count-fns"}
;; <=

;; @@
(count-fns '(+ (* 2 3) 4))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>2</span>","value":"2"}
;; <=

;; @@
(defn count-subexpressions
  "Returns the number of sub-expressions in a symbolic expression, including
   the expression itself."
  [expression]
  (if (list? expression)
    (inc (reduce + (map count-subexpressions (rest expression))))
    1))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/count-subexpressions</span>","value":"#'clojinc.core/count-subexpressions"}
;; <=

;; @@
(count-subexpressions '(+ (* 2 3) 4))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>5</span>","value":"5"}
;; <=

;; @@
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
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/buckets-needed</span>","value":"#'clojinc.core/buckets-needed"}
;; <=

;; @@
(buckets-needed [3 2 4 1 2 3] 8)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>3</span>","value":"3"}
;; <=

;; @@
(buckets-needed [3 2 4 1 2 3] 9)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>3</span>","value":"3"}
;; <=

;; @@
(buckets-needed [3 2 4 1 2 3] 10)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>4</span>","value":"4"}
;; <=

;; @@
(buckets-needed [3 2 4 1 2 3] 15)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>6</span>","value":"6"}
;; <=

;; @@
(buckets-needed [3 2 4 1 2 3] 16)
;; @@

;; @@
(defn nth-fn
  "Returns the nth function in a symbolic expression. Assumes index is valid."
  [expression index]
  (if (zero? index)
    (first expression)
    (let [buckets (map count-fns (rest expression))
          arg-index (buckets-needed buckets index)]
      (nth-fn (nth expression arg-index)
              (dec (- index (reduce + (take (dec arg-index) buckets))))))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/nth-fn</span>","value":"#'clojinc.core/nth-fn"}
;; <=

;; @@
(nth-fn '(+ (* 2 3) 4) 0)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-symbol'>+</span>","value":"+"}
;; <=

;; @@
(nth-fn '(+ (* 2 3) 4) 1)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-symbol'>*</span>","value":"*"}
;; <=

;; @@
; test nth-fn more thoroughly by walking through an expression:

(let [exp '(* (+ a (- b c) d e) (- (+ f g) h))]
  (dotimes [i (count-fns exp)]
    (println (nth-fn exp i))))
;; @@
;; ->
;;; *
;;; +
;;; -
;;; -
;;; +
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
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
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/replace-fn</span>","value":"#'clojinc.core/replace-fn"}
;; <=

;; @@
;; test replace-fn by walking through an expression:

(let [exp '(* (+ a (- b c) d e) (- (+ f g) h))]
  (dotimes [i (count-fns exp)]
    (println (replace-fn exp i 'F))))
;; @@
;; ->
;;; (F (+ a (- b c) d e) (- (+ f g) h))
;;; (* (F a (- b c) d e) (- (+ f g) h))
;;; (* (+ a (F b c) d e) (- (+ f g) h))
;;; (* (+ a (- b c) d e) (F (+ f g) h))
;;; (* (+ a (- b c) d e) (- (F f g) h))
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(defn nth-subexpression
  "Returns the nth subexpression in a symbolic expression. Assumes index is valid."
  [expression index]
  (if (zero? index)
    expression
    (let [buckets (map count-subexpressions (rest expression))
          arg-index (buckets-needed buckets index)]
      (nth-subexpression (nth expression arg-index)
                         (dec (- index (reduce + (take (dec arg-index) buckets))))))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/nth-subexpression</span>","value":"#'clojinc.core/nth-subexpression"}
;; <=

;; @@
;; test nth-subexpression by walking through an expression:

(let [exp '(* (+ a (- b c) d e) (- (+ f g) h))]
  (dotimes [i (count-subexpressions exp)]
    (println (nth-subexpression exp i))))
;; @@
;; ->
;;; (* (+ a (- b c) d e) (- (+ f g) h))
;;; (+ a (- b c) d e)
;;; a
;;; (- b c)
;;; b
;;; c
;;; d
;;; e
;;; (- (+ f g) h)
;;; (+ f g)
;;; f
;;; g
;;; h
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
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
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/replace-subexpression</span>","value":"#'clojinc.core/replace-subexpression"}
;; <=

;; @@
(let [exp '(* (+ a (- b c) d e) (- (+ f g) h))]
  (dotimes [i (count-subexpressions exp)]
    (println (replace-subexpression exp i 'X))))
;; @@
;; ->
;;; X
;;; (* X (- (+ f g) h))
;;; (* (+ X (- b c) d e) (- (+ f g) h))
;;; (* (+ a X d e) (- (+ f g) h))
;;; (* (+ a (- X c) d e) (- (+ f g) h))
;;; (* (+ a (- b X) d e) (- (+ f g) h))
;;; (* (+ a (- b c) X e) (- (+ f g) h))
;;; (* (+ a (- b c) d X) (- (+ f g) h))
;;; (* (+ a (- b c) d e) X)
;;; (* (+ a (- b c) d e) (- X h))
;;; (* (+ a (- b c) d e) (- (+ X g) h))
;;; (* (+ a (- b c) d e) (- (+ f X) h))
;;; (* (+ a (- b c) d e) (- (+ f g) X))
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
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
;; @@

;; @@
(defn meal [& {:keys [food beverage] :or {food 'bread beverage 'water}}]
  (println food beverage))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/meal</span>","value":"#'clojinc.core/meal"}
;; <=

;; @@
(meal)
;; @@
;; ->
;;; bread water
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(meal :food 'truffles)
;; @@
;; ->
;;; truffles water
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(meal :beverage 'mead)
;; @@
;; ->
;;; bread mead
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(meal :food 'truffles :beverage 'mead)
;; @@
;; ->
;;; truffles mead
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(meal :beverage 'mead :food 'truffles)
;; @@
;; ->
;;; truffles mead
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(defn meal-from-map [m]
  (apply meal (apply concat m)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/meal-from-map</span>","value":"#'clojinc.core/meal-from-map"}
;; <=

;; @@
(meal-from-map {:food 'truffles :beverage 'mead})
;; @@
;; ->
;;; truffles mead
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(def twins [:tweedledee :tweedledum])
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/twins</span>","value":"#'clojinc.core/twins"}
;; <=

;; @@
;; this uses a destructuring binding form:

(defn print-twins
  [[this that]] 
  (println "the first twin is" 
           (name this)
           "and the other is" 
           (name that)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/print-twins</span>","value":"#'clojinc.core/print-twins"}
;; <=

;; @@
(print-twins twins)
;; @@
;; ->
;;; the first twin is tweedledee and the other is tweedledum
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(defn add13 [n] (+ n 13))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/add13</span>","value":"#'clojinc.core/add13"}
;; <=

;; @@
(defn increment-unluckily 
  [nums]
  (map add13 nums))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/increment-unluckily</span>","value":"#'clojinc.core/increment-unluckily"}
;; <=

;; @@
(increment-unluckily '(1 2 3 4 5))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>14</span>","value":"14"},{"type":"html","content":"<span class='clj-long'>15</span>","value":"15"},{"type":"html","content":"<span class='clj-long'>16</span>","value":"16"},{"type":"html","content":"<span class='clj-long'>17</span>","value":"17"},{"type":"html","content":"<span class='clj-long'>18</span>","value":"18"}],"value":"(14 15 16 17 18)"}
;; <=

;; @@
(increment-unluckily '(1 2 3 4 Quagmire))
;; @@

;; @@
(.printStackTrace *e) ;;; doesn't work in gorilla repl because *e is a repl-specific feature
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(System/getProperty "user.name")  ;; a call to a static method of the System class
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;leespector&quot;</span>","value":"\"leespector\""}
;; <=

;; @@
(System/currentTimeMillis)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>1505433124787</span>","value":"1505433124787"}
;; <=

;; @@
(.startsWith "Antarctica" "Ant")  ;; calling an instance member
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>true</span>","value":"true"}
;; <=

;; @@
(.startsWith "Antarctica" "Frigid")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>false</span>","value":"false"}
;; <=

;; @@
(.. System (getProperties) (get "user.name"))  ;; an alternative syntax
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;leespector&quot;</span>","value":"\"leespector\""}
;; <=

;; @@
;; simple graphics -- but not as simple as I'd like

(def max-x 500)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/max-x</span>","value":"#'clojinc.core/max-x"}
;; <=

;; @@
(def max-y 500)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/max-y</span>","value":"#'clojinc.core/max-y"}
;; <=

;; @@
(def shapes (atom ()))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/shapes</span>","value":"#'clojinc.core/shapes"}
;; <=

;; @@
;; lots of Java interop here

(defn render-shape [g [shape-name x y h w color]]
  (.setColor g color) 
  (case shape-name
    rect (.fillRect g x y h w)
    oval (.fillOval g x y h w)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/render-shape</span>","value":"#'clojinc.core/render-shape"}
;; <=

;; @@
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
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/panel</span>","value":"#'clojinc.core/panel"}
;; <=

;; @@
(defn draw-shape [shape-name x y h w color]
  (swap! shapes concat (list (list shape-name x y h w color)))
  (.paint panel (.getGraphics panel)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/draw-shape</span>","value":"#'clojinc.core/draw-shape"}
;; <=

;; @@
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
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
;; Problem Set 11:
;; - Write code to draw a face.
;; - Write a function that takes integer coordinates x and y and draws a face
;;   centered at that location.
;; - Write a version of the face-drawing function that draws the face with random
;;   sizes and colors for various components.
;; - Write a function that fills the graphics window with random faces.
;; @@

;; @@
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
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/factorial</span>","value":"#'clojinc.core/factorial"}
;; <=

;; @@
(factorial 5)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>120</span>","value":"120"}
;; <=

;; @@
(factorial 100)
;; @@

;; @@
(defn factorial
  [n]
  (loop [i 1 result 1]
    (if (> i n)
      result
      (recur (inc i) (*' result i)))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/factorial</span>","value":"#'clojinc.core/factorial"}
;; <=

;; @@
(factorial 100)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-bigint'>93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000N</span>","value":"93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000N"}
;; <=

;; @@
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
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/factorial</span>","value":"#'clojinc.core/factorial"}
;; <=

;; @@
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
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/factorial</span>","value":"#'clojinc.core/factorial"}
;; <=

;; @@
(factorial 5)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>120</span>","value":"120"}
;; <=

;; @@
;; Here is another functional-style version which is both elegant
;; and efficient in Clojure. First we produce a sequence of numbers
;; from 0 to n-1 using range. Then we map inc (which adds 1) down that
;; sequence, producing a sequence from 1 to n. Then we apply * to the
;; result, and return the result of that.

(defn factorial
  [n]
  (apply * (map inc (range n))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/factorial</span>","value":"#'clojinc.core/factorial"}
;; <=

;; @@
;; Here's a slightly different version that avoids the call to map
;; by calling range with two values to produce the right sequence in
;; the first place:

(defn factorial
  [n]
  (apply * (range 1 (inc n))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/factorial</span>","value":"#'clojinc.core/factorial"}
;; <=

;; @@
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
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/all-factorials</span>","value":"#'clojinc.core/all-factorials"}
;; <=

;; @@
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
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/factorial</span>","value":"#'clojinc.core/factorial"}
;; <=

;; @@
(factorial 5)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>120</span>","value":"120"}
;; <=

;; @@
;; Another way to pull out the right pair is to search all-factorials
;; for a pair with a first number equal to n. 

(defn factorial 
  [n]
  (second (first (filter  #(= (first %) n) all-factorials))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/factorial</span>","value":"#'clojinc.core/factorial"}
;; <=

;; @@
(factorial 5)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>120</span>","value":"120"}
;; <=

;; @@
;; Note, however, that this will loop forever if you ask for the factorial
;; of 0 or a negative number. The other versions above will either return
;; the wrong answer (since there is no right answer!) or produce an error
;; if you ask them to do this, which you shouldn't anyway. But the infinite
;; loop is perhaps the nastiest way to handle this.
;; @@

;; @@
;; Problem Set 12:
;; - Write Clojure functions for several of the recursive functions that are 
;;   listed at http://en.wikipedia.org/wiki/Recursion_(computer_science)
;;   other than factorial. Try to write versions in several of the styles
;;   that were presented above for factorial.
;; @@

;; @@
(defn print-comparison
  [x y]
  (cond 
    (< x y) (concat (list x) '(is smaller than) (list y))
    (= x y) (concat (list x) '(is equal to) (list y))
    :else (concat (list x) '(is greater than) (list y))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/print-comparison</span>","value":"#'clojinc.core/print-comparison"}
;; <=

;; @@
(print-comparison 0 1)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>0</span>","value":"0"},{"type":"html","content":"<span class='clj-symbol'>is</span>","value":"is"},{"type":"html","content":"<span class='clj-symbol'>smaller</span>","value":"smaller"},{"type":"html","content":"<span class='clj-symbol'>than</span>","value":"than"},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"}],"value":"(0 is smaller than 1)"}
;; <=

;; @@
(print-comparison 1 1)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-symbol'>is</span>","value":"is"},{"type":"html","content":"<span class='clj-symbol'>equal</span>","value":"equal"},{"type":"html","content":"<span class='clj-symbol'>to</span>","value":"to"},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"}],"value":"(1 is equal to 1)"}
;; <=

;; @@
(print-comparison 1 0)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-symbol'>is</span>","value":"is"},{"type":"html","content":"<span class='clj-symbol'>greater</span>","value":"greater"},{"type":"html","content":"<span class='clj-symbol'>than</span>","value":"than"},{"type":"html","content":"<span class='clj-long'>0</span>","value":"0"}],"value":"(1 is greater than 0)"}
;; <=

;; @@
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
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>if</span>","value":"if"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>&lt;</span>","value":"<"},{"type":"html","content":"<span class='clj-symbol'>x</span>","value":"x"},{"type":"html","content":"<span class='clj-symbol'>y</span>","value":"y"}],"value":"(< x y)"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>concat</span>","value":"concat"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>list</span>","value":"list"},{"type":"html","content":"<span class='clj-symbol'>x</span>","value":"x"}],"value":"(list x)"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>quote</span>","value":"quote"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>is</span>","value":"is"},{"type":"html","content":"<span class='clj-symbol'>smaller</span>","value":"smaller"},{"type":"html","content":"<span class='clj-symbol'>than</span>","value":"than"}],"value":"(is smaller than)"}],"value":"(quote (is smaller than))"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>list</span>","value":"list"},{"type":"html","content":"<span class='clj-symbol'>y</span>","value":"y"}],"value":"(list y)"}],"value":"(concat (list x) (quote (is smaller than)) (list y))"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>clojure.core/cond</span>","value":"clojure.core/cond"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>=</span>","value":"="},{"type":"html","content":"<span class='clj-symbol'>x</span>","value":"x"},{"type":"html","content":"<span class='clj-symbol'>y</span>","value":"y"}],"value":"(= x y)"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>concat</span>","value":"concat"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>list</span>","value":"list"},{"type":"html","content":"<span class='clj-symbol'>x</span>","value":"x"}],"value":"(list x)"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>quote</span>","value":"quote"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>is</span>","value":"is"},{"type":"html","content":"<span class='clj-symbol'>equal</span>","value":"equal"},{"type":"html","content":"<span class='clj-symbol'>to</span>","value":"to"}],"value":"(is equal to)"}],"value":"(quote (is equal to))"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>list</span>","value":"list"},{"type":"html","content":"<span class='clj-symbol'>y</span>","value":"y"}],"value":"(list y)"}],"value":"(concat (list x) (quote (is equal to)) (list y))"},{"type":"html","content":"<span class='clj-keyword'>:else</span>","value":":else"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>concat</span>","value":"concat"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>list</span>","value":"list"},{"type":"html","content":"<span class='clj-symbol'>x</span>","value":"x"}],"value":"(list x)"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>quote</span>","value":"quote"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>is</span>","value":"is"},{"type":"html","content":"<span class='clj-symbol'>greater</span>","value":"greater"},{"type":"html","content":"<span class='clj-symbol'>than</span>","value":"than"}],"value":"(is greater than)"}],"value":"(quote (is greater than))"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>list</span>","value":"list"},{"type":"html","content":"<span class='clj-symbol'>y</span>","value":"y"}],"value":"(list y)"}],"value":"(concat (list x) (quote (is greater than)) (list y))"}],"value":"(clojure.core/cond (= x y) (concat (list x) (quote (is equal to)) (list y)) :else (concat (list x) (quote (is greater than)) (list y)))"}],"value":"(if (< x y) (concat (list x) (quote (is smaller than)) (list y)) (clojure.core/cond (= x y) (concat (list x) (quote (is equal to)) (list y)) :else (concat (list x) (quote (is greater than)) (list y))))"}
;; <=

;; @@
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
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/arithmetic-if</span>","value":"#'clojinc.core/arithmetic-if"}
;; <=

;; @@
;; re-define print-comparison using the new macro:

(defn print-comparison
  [x y]
  (arithmetic-if x y 
     (concat (list x) '(is smaller than) (list y))
     (concat (list x) '(is equal to) (list y))
     (concat (list x) '(is greater than) (list y))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/print-comparison</span>","value":"#'clojinc.core/print-comparison"}
;; <=

;; @@
(print-comparison 1 2)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-lazy-seq'>(</span>","close":"<span class='clj-lazy-seq'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-symbol'>is</span>","value":"is"},{"type":"html","content":"<span class='clj-symbol'>smaller</span>","value":"smaller"},{"type":"html","content":"<span class='clj-symbol'>than</span>","value":"than"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"}],"value":"(1 is smaller than 2)"}
;; <=

;; @@
;; use it in other contexts:

(arithmetic-if 1 2 3 4 5)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>3</span>","value":"3"}
;; <=

;; @@
(macroexpand '(arithmetic-if 1 2 3 4 5))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>if</span>","value":"if"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>clojure.core/&lt;</span>","value":"clojure.core/<"},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"}],"value":"(clojure.core/< 1 2)"},{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>clojure.core/cond</span>","value":"clojure.core/cond"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>clojure.core/=</span>","value":"clojure.core/="},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"}],"value":"(clojure.core/= 1 2)"},{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-keyword'>:else</span>","value":":else"},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"}],"value":"(clojure.core/cond (clojure.core/= 1 2) 4 :else 5)"}],"value":"(if (clojure.core/< 1 2) 3 (clojure.core/cond (clojure.core/= 1 2) 4 :else 5))"}
;; <=

;; @@
(macroexpand-1 '(arithmetic-if 1 2 3 4 5))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>clojure.core/cond</span>","value":"clojure.core/cond"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>clojure.core/&lt;</span>","value":"clojure.core/<"},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"}],"value":"(clojure.core/< 1 2)"},{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>clojure.core/=</span>","value":"clojure.core/="},{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"}],"value":"(clojure.core/= 1 2)"},{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-keyword'>:else</span>","value":":else"},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"}],"value":"(clojure.core/cond (clojure.core/< 1 2) 3 (clojure.core/= 1 2) 4 :else 5)"}
;; <=

;; @@
;; The fact that this is a macro, and not a function, is
;; made clear by providing expressions that have side-effects
;; (like printing) for the "eval-if-..." clauses, and seeing 
;; that only the matching clause is executed:

(arithmetic-if 1 
               2 
               (println :less)
               (println :equal)
               (println :greater))
;; @@
;; ->
;;; :less
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
;; a lot of other things are also implemeted as macros:

(macroexpand '(dotimes [_ 4] (println (rand))))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>let*</span>","value":"let*"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>n__4940__auto__</span>","value":"n__4940__auto__"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>clojure.core/long</span>","value":"clojure.core/long"},{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"}],"value":"(clojure.core/long 4)"}],"value":"[n__4940__auto__ (clojure.core/long 4)]"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>clojure.core/loop</span>","value":"clojure.core/loop"},{"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>_</span>","value":"_"},{"type":"html","content":"<span class='clj-long'>0</span>","value":"0"}],"value":"[_ 0]"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>clojure.core/when</span>","value":"clojure.core/when"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>clojure.core/&lt;</span>","value":"clojure.core/<"},{"type":"html","content":"<span class='clj-symbol'>_</span>","value":"_"},{"type":"html","content":"<span class='clj-symbol'>n__4940__auto__</span>","value":"n__4940__auto__"}],"value":"(clojure.core/< _ n__4940__auto__)"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>println</span>","value":"println"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>rand</span>","value":"rand"}],"value":"(rand)"}],"value":"(println (rand))"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>recur</span>","value":"recur"},{"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-symbol'>clojure.core/unchecked-inc</span>","value":"clojure.core/unchecked-inc"},{"type":"html","content":"<span class='clj-symbol'>_</span>","value":"_"}],"value":"(clojure.core/unchecked-inc _)"}],"value":"(recur (clojure.core/unchecked-inc _))"}],"value":"(clojure.core/when (clojure.core/< _ n__4940__auto__) (println (rand)) (recur (clojure.core/unchecked-inc _)))"}],"value":"(clojure.core/loop [_ 0] (clojure.core/when (clojure.core/< _ n__4940__auto__) (println (rand)) (recur (clojure.core/unchecked-inc _))))"}],"value":"(let* [n__4940__auto__ (clojure.core/long 4)] (clojure.core/loop [_ 0] (clojure.core/when (clojure.core/< _ n__4940__auto__) (println (rand)) (recur (clojure.core/unchecked-inc _)))))"}
;; <=

;; @@
;; What's "splicing"? The following expressions demonstrate:

(def teens (range 10 19))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/teens</span>","value":"#'clojinc.core/teens"}
;; <=

;; @@
teens
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-unkown'>(10 11 12 13 14 15 16 17 18)</span>","value":"(10 11 12 13 14 15 16 17 18)"}
;; <=

;; @@
`(1 2 3 4 5 6 7 8 9 ~teens 20 21 22 23)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-long'>6</span>","value":"6"},{"type":"html","content":"<span class='clj-long'>7</span>","value":"7"},{"type":"html","content":"<span class='clj-long'>8</span>","value":"8"},{"type":"html","content":"<span class='clj-long'>9</span>","value":"9"},{"type":"html","content":"<span class='clj-unkown'>(10 11 12 13 14 15 16 17 18)</span>","value":"(10 11 12 13 14 15 16 17 18)"},{"type":"html","content":"<span class='clj-long'>20</span>","value":"20"},{"type":"html","content":"<span class='clj-long'>21</span>","value":"21"},{"type":"html","content":"<span class='clj-long'>22</span>","value":"22"},{"type":"html","content":"<span class='clj-long'>23</span>","value":"23"}],"value":"(1 2 3 4 5 6 7 8 9 (10 11 12 13 14 15 16 17 18) 20 21 22 23)"}
;; <=

;; @@
`(1 2 3 4 5 6 7 8 9 ~@teens 20 21 22 23)
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-list'>(</span>","close":"<span class='clj-list'>)</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-long'>1</span>","value":"1"},{"type":"html","content":"<span class='clj-long'>2</span>","value":"2"},{"type":"html","content":"<span class='clj-long'>3</span>","value":"3"},{"type":"html","content":"<span class='clj-long'>4</span>","value":"4"},{"type":"html","content":"<span class='clj-long'>5</span>","value":"5"},{"type":"html","content":"<span class='clj-long'>6</span>","value":"6"},{"type":"html","content":"<span class='clj-long'>7</span>","value":"7"},{"type":"html","content":"<span class='clj-long'>8</span>","value":"8"},{"type":"html","content":"<span class='clj-long'>9</span>","value":"9"},{"type":"html","content":"<span class='clj-long'>10</span>","value":"10"},{"type":"html","content":"<span class='clj-long'>11</span>","value":"11"},{"type":"html","content":"<span class='clj-long'>12</span>","value":"12"},{"type":"html","content":"<span class='clj-long'>13</span>","value":"13"},{"type":"html","content":"<span class='clj-long'>14</span>","value":"14"},{"type":"html","content":"<span class='clj-long'>15</span>","value":"15"},{"type":"html","content":"<span class='clj-long'>16</span>","value":"16"},{"type":"html","content":"<span class='clj-long'>17</span>","value":"17"},{"type":"html","content":"<span class='clj-long'>18</span>","value":"18"},{"type":"html","content":"<span class='clj-long'>20</span>","value":"20"},{"type":"html","content":"<span class='clj-long'>21</span>","value":"21"},{"type":"html","content":"<span class='clj-long'>22</span>","value":"22"},{"type":"html","content":"<span class='clj-long'>23</span>","value":"23"}],"value":"(1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 20 21 22 23)"}
;; <=

;; @@
;; we use splicing to write an "until" loop macro:

(defmacro until
  [test & body]
  `(loop []
     (when (not ~test)
       ~@body
       (recur))))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/until</span>","value":"#'clojinc.core/until"}
;; <=

;; @@
(until (> (rand) 0.9)
  (println "he he")
  (println "      ha!"))
;; @@
;; ->
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; he he
;;;       ha!
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(def counter (atom 0))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/counter</span>","value":"#'clojinc.core/counter"}
;; <=

;; @@
(until (> @counter 4)
  (println "the counter is now " @counter)
  (swap! counter inc))
;; @@
;; ->
;;; the counter is now  0
;;; the counter is now  1
;;; the counter is now  2
;;; the counter is now  3
;;; the counter is now  4
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(defmacro ignore-errors
  "Returns the result of evaluating e, or :error if it throws an exception."
  [e]
  `(try ~e (catch java.lang.Exception _# :error)))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-var'>#&#x27;clojinc.core/ignore-errors</span>","value":"#'clojinc.core/ignore-errors"}
;; <=

;; @@
(ignore-errors (+ 1 2))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-long'>3</span>","value":"3"}
;; <=

;; @@
(ignore-errors (/ 3 0))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-keyword'>:error</span>","value":":error"}
;; <=

;; @@
(ignore-errors (+ :peanut-butter :mustard))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-keyword'>:error</span>","value":":error"}
;; <=

;; @@
;; Problem Set 13:
;; - Write a macro that takes two unquoted expressions and randomly evaluates
;;   either one, or the other, or both (but never the same one more than once).
;; @@

;; @@
;; Reading in a text file is easy if you have a full path:
 
(slurp "/Users/leespector/Code/clojure/clojinc/Jabberwocky.txt")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;JABBERWOCKY by Lewis Carroll\\n(from Through the Looking-Glass and What Alice Found There, 1872) \\n\\n\\n`Twas brillig, and the slithy toves\\n  Did gyre and gimble in the wabe:\\nAll mimsy were the borogoves,\\n  And the mome raths outgrabe.\\n\\n\\n\\&quot;Beware the Jabberwock, my son!\\n  The jaws that bite, the claws that catch!\\nBeware the Jubjub bird, and shun\\n  The frumious Bandersnatch!\\&quot;\\n\\nHe took his vorpal sword in hand:\\n  Long time the manxome foe he sought --\\nSo rested he by the Tumtum tree,\\n  And stood awhile in thought.\\n\\nAnd, as in uffish thought he stood,\\n  The Jabberwock, with eyes of flame,\\nCame whiffling through the tulgey wood,\\n  And burbled as it came!\\n\\nOne, two! One, two! And through and through\\n  The vorpal blade went snicker-snack!\\nHe left it dead, and with its head\\n  He went galumphing back.\\n\\n\\&quot;And, has thou slain the Jabberwock?\\n  Come to my arms, my beamish boy!\\nO frabjous day! Callooh! Callay!&#x27;\\n  He chortled in his joy.\\n\\n\\n`Twas brillig, and the slithy toves\\n  Did gyre and gimble in the wabe;\\nAll mimsy were the borogoves,\\n  And the mome raths outgrabe. &quot;</span>","value":"\"JABBERWOCKY by Lewis Carroll\\n(from Through the Looking-Glass and What Alice Found There, 1872) \\n\\n\\n`Twas brillig, and the slithy toves\\n  Did gyre and gimble in the wabe:\\nAll mimsy were the borogoves,\\n  And the mome raths outgrabe.\\n\\n\\n\\\"Beware the Jabberwock, my son!\\n  The jaws that bite, the claws that catch!\\nBeware the Jubjub bird, and shun\\n  The frumious Bandersnatch!\\\"\\n\\nHe took his vorpal sword in hand:\\n  Long time the manxome foe he sought --\\nSo rested he by the Tumtum tree,\\n  And stood awhile in thought.\\n\\nAnd, as in uffish thought he stood,\\n  The Jabberwock, with eyes of flame,\\nCame whiffling through the tulgey wood,\\n  And burbled as it came!\\n\\nOne, two! One, two! And through and through\\n  The vorpal blade went snicker-snack!\\nHe left it dead, and with its head\\n  He went galumphing back.\\n\\n\\\"And, has thou slain the Jabberwock?\\n  Come to my arms, my beamish boy!\\nO frabjous day! Callooh! Callay!'\\n  He chortled in his joy.\\n\\n\\n`Twas brillig, and the slithy toves\\n  Did gyre and gimble in the wabe;\\nAll mimsy were the borogoves,\\n  And the mome raths outgrabe. \""}
;; <=

;; @@
(require '[clojure.string :as string])
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(string/split-lines (slurp "/Users/leespector/Code/clojure/clojinc/Jabberwocky.txt"))
;; @@
;; =>
;;; {"type":"list-like","open":"<span class='clj-vector'>[</span>","close":"<span class='clj-vector'>]</span>","separator":" ","items":[{"type":"html","content":"<span class='clj-string'>&quot;JABBERWOCKY by Lewis Carroll&quot;</span>","value":"\"JABBERWOCKY by Lewis Carroll\""},{"type":"html","content":"<span class='clj-string'>&quot;(from Through the Looking-Glass and What Alice Found There, 1872) &quot;</span>","value":"\"(from Through the Looking-Glass and What Alice Found There, 1872) \""},{"type":"html","content":"<span class='clj-string'>&quot;&quot;</span>","value":"\"\""},{"type":"html","content":"<span class='clj-string'>&quot;&quot;</span>","value":"\"\""},{"type":"html","content":"<span class='clj-string'>&quot;`Twas brillig, and the slithy toves&quot;</span>","value":"\"`Twas brillig, and the slithy toves\""},{"type":"html","content":"<span class='clj-string'>&quot;  Did gyre and gimble in the wabe:&quot;</span>","value":"\"  Did gyre and gimble in the wabe:\""},{"type":"html","content":"<span class='clj-string'>&quot;All mimsy were the borogoves,&quot;</span>","value":"\"All mimsy were the borogoves,\""},{"type":"html","content":"<span class='clj-string'>&quot;  And the mome raths outgrabe.&quot;</span>","value":"\"  And the mome raths outgrabe.\""},{"type":"html","content":"<span class='clj-string'>&quot;&quot;</span>","value":"\"\""},{"type":"html","content":"<span class='clj-string'>&quot;&quot;</span>","value":"\"\""},{"type":"html","content":"<span class='clj-string'>&quot;\\&quot;Beware the Jabberwock, my son!&quot;</span>","value":"\"\\\"Beware the Jabberwock, my son!\""},{"type":"html","content":"<span class='clj-string'>&quot;  The jaws that bite, the claws that catch!&quot;</span>","value":"\"  The jaws that bite, the claws that catch!\""},{"type":"html","content":"<span class='clj-string'>&quot;Beware the Jubjub bird, and shun&quot;</span>","value":"\"Beware the Jubjub bird, and shun\""},{"type":"html","content":"<span class='clj-string'>&quot;  The frumious Bandersnatch!\\&quot;&quot;</span>","value":"\"  The frumious Bandersnatch!\\\"\""},{"type":"html","content":"<span class='clj-string'>&quot;&quot;</span>","value":"\"\""},{"type":"html","content":"<span class='clj-string'>&quot;He took his vorpal sword in hand:&quot;</span>","value":"\"He took his vorpal sword in hand:\""},{"type":"html","content":"<span class='clj-string'>&quot;  Long time the manxome foe he sought --&quot;</span>","value":"\"  Long time the manxome foe he sought --\""},{"type":"html","content":"<span class='clj-string'>&quot;So rested he by the Tumtum tree,&quot;</span>","value":"\"So rested he by the Tumtum tree,\""},{"type":"html","content":"<span class='clj-string'>&quot;  And stood awhile in thought.&quot;</span>","value":"\"  And stood awhile in thought.\""},{"type":"html","content":"<span class='clj-string'>&quot;&quot;</span>","value":"\"\""},{"type":"html","content":"<span class='clj-string'>&quot;And, as in uffish thought he stood,&quot;</span>","value":"\"And, as in uffish thought he stood,\""},{"type":"html","content":"<span class='clj-string'>&quot;  The Jabberwock, with eyes of flame,&quot;</span>","value":"\"  The Jabberwock, with eyes of flame,\""},{"type":"html","content":"<span class='clj-string'>&quot;Came whiffling through the tulgey wood,&quot;</span>","value":"\"Came whiffling through the tulgey wood,\""},{"type":"html","content":"<span class='clj-string'>&quot;  And burbled as it came!&quot;</span>","value":"\"  And burbled as it came!\""},{"type":"html","content":"<span class='clj-string'>&quot;&quot;</span>","value":"\"\""},{"type":"html","content":"<span class='clj-string'>&quot;One, two! One, two! And through and through&quot;</span>","value":"\"One, two! One, two! And through and through\""},{"type":"html","content":"<span class='clj-string'>&quot;  The vorpal blade went snicker-snack!&quot;</span>","value":"\"  The vorpal blade went snicker-snack!\""},{"type":"html","content":"<span class='clj-string'>&quot;He left it dead, and with its head&quot;</span>","value":"\"He left it dead, and with its head\""},{"type":"html","content":"<span class='clj-string'>&quot;  He went galumphing back.&quot;</span>","value":"\"  He went galumphing back.\""},{"type":"html","content":"<span class='clj-string'>&quot;&quot;</span>","value":"\"\""},{"type":"html","content":"<span class='clj-string'>&quot;\\&quot;And, has thou slain the Jabberwock?&quot;</span>","value":"\"\\\"And, has thou slain the Jabberwock?\""},{"type":"html","content":"<span class='clj-string'>&quot;  Come to my arms, my beamish boy!&quot;</span>","value":"\"  Come to my arms, my beamish boy!\""},{"type":"html","content":"<span class='clj-string'>&quot;O frabjous day! Callooh! Callay!&#x27;&quot;</span>","value":"\"O frabjous day! Callooh! Callay!'\""},{"type":"html","content":"<span class='clj-string'>&quot;  He chortled in his joy.&quot;</span>","value":"\"  He chortled in his joy.\""},{"type":"html","content":"<span class='clj-string'>&quot;&quot;</span>","value":"\"\""},{"type":"html","content":"<span class='clj-string'>&quot;&quot;</span>","value":"\"\""},{"type":"html","content":"<span class='clj-string'>&quot;`Twas brillig, and the slithy toves&quot;</span>","value":"\"`Twas brillig, and the slithy toves\""},{"type":"html","content":"<span class='clj-string'>&quot;  Did gyre and gimble in the wabe;&quot;</span>","value":"\"  Did gyre and gimble in the wabe;\""},{"type":"html","content":"<span class='clj-string'>&quot;All mimsy were the borogoves,&quot;</span>","value":"\"All mimsy were the borogoves,\""},{"type":"html","content":"<span class='clj-string'>&quot;  And the mome raths outgrabe. &quot;</span>","value":"\"  And the mome raths outgrabe. \""}],"value":"[\"JABBERWOCKY by Lewis Carroll\" \"(from Through the Looking-Glass and What Alice Found There, 1872) \" \"\" \"\" \"`Twas brillig, and the slithy toves\" \"  Did gyre and gimble in the wabe:\" \"All mimsy were the borogoves,\" \"  And the mome raths outgrabe.\" \"\" \"\" \"\\\"Beware the Jabberwock, my son!\" \"  The jaws that bite, the claws that catch!\" \"Beware the Jubjub bird, and shun\" \"  The frumious Bandersnatch!\\\"\" \"\" \"He took his vorpal sword in hand:\" \"  Long time the manxome foe he sought --\" \"So rested he by the Tumtum tree,\" \"  And stood awhile in thought.\" \"\" \"And, as in uffish thought he stood,\" \"  The Jabberwock, with eyes of flame,\" \"Came whiffling through the tulgey wood,\" \"  And burbled as it came!\" \"\" \"One, two! One, two! And through and through\" \"  The vorpal blade went snicker-snack!\" \"He left it dead, and with its head\" \"  He went galumphing back.\" \"\" \"\\\"And, has thou slain the Jabberwock?\" \"  Come to my arms, my beamish boy!\" \"O frabjous day! Callooh! Callay!'\" \"  He chortled in his joy.\" \"\" \"\" \"`Twas brillig, and the slithy toves\" \"  Did gyre and gimble in the wabe;\" \"All mimsy were the borogoves,\" \"  And the mome raths outgrabe. \"]"}
;; <=

;; @@
;; you can also slurp from the web

(use 'clojure.java.io)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
(slurp (reader "https://raw.githubusercontent.com/lspector/clojinc/master/Jabberwocky.txt"))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;JABBERWOCKY by Lewis Carroll\\n(from Through the Looking-Glass and What Alice Found There, 1872) \\n\\n\\n`Twas brillig, and the slithy toves\\n  Did gyre and gimble in the wabe:\\nAll mimsy were the borogoves,\\n  And the mome raths outgrabe.\\n\\n\\n\\&quot;Beware the Jabberwock, my son!\\n  The jaws that bite, the claws that catch!\\nBeware the Jubjub bird, and shun\\n  The frumious Bandersnatch!\\&quot;\\n\\nHe took his vorpal sword in hand:\\n  Long time the manxome foe he sought --\\nSo rested he by the Tumtum tree,\\n  And stood awhile in thought.\\n\\nAnd, as in uffish thought he stood,\\n  The Jabberwock, with eyes of flame,\\nCame whiffling through the tulgey wood,\\n  And burbled as it came!\\n\\nOne, two! One, two! And through and through\\n  The vorpal blade went snicker-snack!\\nHe left it dead, and with its head\\n  He went galumphing back.\\n\\n\\&quot;And, has thou slain the Jabberwock?\\n  Come to my arms, my beamish boy!\\nO frabjous day! Callooh! Callay!&#x27;\\n  He chortled in his joy.\\n\\n\\n`Twas brillig, and the slithy toves\\n  Did gyre and gimble in the wabe;\\nAll mimsy were the borogoves,\\n  And the mome raths outgrabe. &quot;</span>","value":"\"JABBERWOCKY by Lewis Carroll\\n(from Through the Looking-Glass and What Alice Found There, 1872) \\n\\n\\n`Twas brillig, and the slithy toves\\n  Did gyre and gimble in the wabe:\\nAll mimsy were the borogoves,\\n  And the mome raths outgrabe.\\n\\n\\n\\\"Beware the Jabberwock, my son!\\n  The jaws that bite, the claws that catch!\\nBeware the Jubjub bird, and shun\\n  The frumious Bandersnatch!\\\"\\n\\nHe took his vorpal sword in hand:\\n  Long time the manxome foe he sought --\\nSo rested he by the Tumtum tree,\\n  And stood awhile in thought.\\n\\nAnd, as in uffish thought he stood,\\n  The Jabberwock, with eyes of flame,\\nCame whiffling through the tulgey wood,\\n  And burbled as it came!\\n\\nOne, two! One, two! And through and through\\n  The vorpal blade went snicker-snack!\\nHe left it dead, and with its head\\n  He went galumphing back.\\n\\n\\\"And, has thou slain the Jabberwock?\\n  Come to my arms, my beamish boy!\\nO frabjous day! Callooh! Callay!'\\n  He chortled in his joy.\\n\\n\\n`Twas brillig, and the slithy toves\\n  Did gyre and gimble in the wabe;\\nAll mimsy were the borogoves,\\n  And the mome raths outgrabe. \""}
;; <=

;; @@
(doseq [line (shuffle (string/split-lines 
                        (slurp "/Users/leespector/Code/clojure/clojinc/Jabberwocky.txt")))]
  (println line))
;; @@
;; ->
;;;   The frumious Bandersnatch!&quot;
;;; Came whiffling through the tulgey wood,
;;; And, as in uffish thought he stood,
;;;   And burbled as it came!
;;; 
;;;   Come to my arms, my beamish boy!
;;; 
;;; Beware the Jubjub bird, and shun
;;; So rested he by the Tumtum tree,
;;; 
;;; One, two! One, two! And through and through
;;; 
;;; He left it dead, and with its head
;;;   He chortled in his joy.
;;; 
;;;   And the mome raths outgrabe.
;;; O frabjous day! Callooh! Callay!&#x27;
;;; 
;;;   The vorpal blade went snicker-snack!
;;; `Twas brillig, and the slithy toves
;;; `Twas brillig, and the slithy toves
;;;   And the mome raths outgrabe. 
;;;   Long time the manxome foe he sought --
;;; All mimsy were the borogoves,
;;; 
;;;   And stood awhile in thought.
;;; &quot;Beware the Jabberwock, my son!
;;;   The jaws that bite, the claws that catch!
;;; 
;;;   Did gyre and gimble in the wabe;
;;; All mimsy were the borogoves,
;;; JABBERWOCKY by Lewis Carroll
;;;   The Jabberwock, with eyes of flame,
;;; (from Through the Looking-Glass and What Alice Found There, 1872) 
;;;   He went galumphing back.
;;; 
;;; &quot;And, has thou slain the Jabberwock?
;;; He took his vorpal sword in hand:
;;; 
;;;   Did gyre and gimble in the wabe:
;;; 
;; <-
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
;; output to a text file is also simple if you use a full path

(spit "/Users/leespector/Code/clojure/clojinc/spitoon.txt" "Testing 1 2 3")
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
;; If you want to refer to files in a project-relative way then the the details will 
;; depend on the way that you run your code. Here I use a utility by Arthur Edelstein 
;; (the author of clooj). I added [local-file "0.0.4"] to the dependencies in project.clj,
;; then ran "lein deps" from a command line in the project's directory (which requires
;; leiningen from https://github.com/technomancy/leiningen), and quit/restarted clooj.
;; Then I can do things like:

(use 'local-file)
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-nil'>nil</span>","value":"nil"}
;; <=

;; @@
; and if Jabberwocky.txt is in my project directory then I can do:

(slurp (file* "Jabberwocky.txt"))
;; @@
;; =>
;;; {"type":"html","content":"<span class='clj-string'>&quot;JABBERWOCKY by Lewis Carroll\\n(from Through the Looking-Glass and What Alice Found There, 1872) \\n\\n\\n`Twas brillig, and the slithy toves\\n  Did gyre and gimble in the wabe:\\nAll mimsy were the borogoves,\\n  And the mome raths outgrabe.\\n\\n\\n\\&quot;Beware the Jabberwock, my son!\\n  The jaws that bite, the claws that catch!\\nBeware the Jubjub bird, and shun\\n  The frumious Bandersnatch!\\&quot;\\n\\nHe took his vorpal sword in hand:\\n  Long time the manxome foe he sought --\\nSo rested he by the Tumtum tree,\\n  And stood awhile in thought.\\n\\nAnd, as in uffish thought he stood,\\n  The Jabberwock, with eyes of flame,\\nCame whiffling through the tulgey wood,\\n  And burbled as it came!\\n\\nOne, two! One, two! And through and through\\n  The vorpal blade went snicker-snack!\\nHe left it dead, and with its head\\n  He went galumphing back.\\n\\n\\&quot;And, has thou slain the Jabberwock?\\n  Come to my arms, my beamish boy!\\nO frabjous day! Callooh! Callay!&#x27;\\n  He chortled in his joy.\\n\\n\\n`Twas brillig, and the slithy toves\\n  Did gyre and gimble in the wabe;\\nAll mimsy were the borogoves,\\n  And the mome raths outgrabe. &quot;</span>","value":"\"JABBERWOCKY by Lewis Carroll\\n(from Through the Looking-Glass and What Alice Found There, 1872) \\n\\n\\n`Twas brillig, and the slithy toves\\n  Did gyre and gimble in the wabe:\\nAll mimsy were the borogoves,\\n  And the mome raths outgrabe.\\n\\n\\n\\\"Beware the Jabberwock, my son!\\n  The jaws that bite, the claws that catch!\\nBeware the Jubjub bird, and shun\\n  The frumious Bandersnatch!\\\"\\n\\nHe took his vorpal sword in hand:\\n  Long time the manxome foe he sought --\\nSo rested he by the Tumtum tree,\\n  And stood awhile in thought.\\n\\nAnd, as in uffish thought he stood,\\n  The Jabberwock, with eyes of flame,\\nCame whiffling through the tulgey wood,\\n  And burbled as it came!\\n\\nOne, two! One, two! And through and through\\n  The vorpal blade went snicker-snack!\\nHe left it dead, and with its head\\n  He went galumphing back.\\n\\n\\\"And, has thou slain the Jabberwock?\\n  Come to my arms, my beamish boy!\\nO frabjous day! Callooh! Callay!'\\n  He chortled in his joy.\\n\\n\\n`Twas brillig, and the slithy toves\\n  Did gyre and gimble in the wabe;\\nAll mimsy were the borogoves,\\n  And the mome raths outgrabe. \""}
;; <=

;; @@
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
;; @@
