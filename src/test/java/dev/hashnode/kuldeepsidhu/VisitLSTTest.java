package dev.hashnode.kuldeepsidhu;

import static org.openrewrite.java.Assertions.java;

import org.junit.jupiter.api.Test;
import org.openrewrite.test.RecipeSpec;
import org.openrewrite.test.RewriteTest;

class VisitLSTTest implements RewriteTest {

    @Override
    public void defaults(RecipeSpec spec) {
        spec.recipe(new VisitLST());
    }

    @Test
    void visitLST() {
        rewriteRun(
            java(
                """
                        package com.yourorg;

                        class FooBar {
                            public String hello() {
                                return "hello";
                            }
                            public String callHello() {
                                hello();
                            }
                        }
                    """
            )
        );
    }
}