package com.github.brunotorrao.observer;

import io.reactivex.Observable;

public class ObservableTest {
    
    public static void main(String[] args) {
        helloWorldExample();
        mapExample();
    }
    
    private static void mapExample() {
        Observable<Integer> o = Observable.create(s -> {
            s.onNext(1);
            s.onNext(2);
            s.onNext(3);
            s.onComplete();
        });
    
        o.map(i -> "Number " + i)
            .subscribe(System.out::println);
    }
    
    private static void helloWorldExample() {
        Observable.create(s -> {
           s.onNext("Hello World!");
           s.onComplete();
        })
            .doOnNext(System.out::println)
            .subscribe();
    }
}
