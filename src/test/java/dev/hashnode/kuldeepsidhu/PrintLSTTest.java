package dev.hashnode.kuldeepsidhu;

import static org.openrewrite.java.Assertions.java;

import org.junit.jupiter.api.Test;
import org.openrewrite.test.RecipeSpec;
import org.openrewrite.test.RewriteTest;

class PrintLSTTest implements RewriteTest {

    @Override
    public void defaults(RecipeSpec spec) {
        spec.recipe(new PrintLST());
    }

    @Test
    void printLSTEmptyClass() {
        rewriteRun(
            java(
                """
                        package com.yourorg;

                        class FooBar {
                        }
                    """
            )
        );
    }

    @Test
    void printLSTWithMethodDeclaration() {
        rewriteRun(
            java(
                """
                        package com.yourorg;

                        class FooBar {
                            public String hello() {
                                return "hello";
                            }
                        }
                    """
            )
        );
    }

    @Test
    void printLSTWithMethodInvocation() {
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