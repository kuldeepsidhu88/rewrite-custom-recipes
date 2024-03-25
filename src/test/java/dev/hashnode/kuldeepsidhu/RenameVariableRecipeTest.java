package dev.hashnode.kuldeepsidhu;

import static org.openrewrite.java.Assertions.java;

import org.junit.jupiter.api.Test;
import org.openrewrite.test.RecipeSpec;
import org.openrewrite.test.RewriteTest;

class RenameVariableRecipeTest implements RewriteTest {

    @Override
    public void defaults(RecipeSpec spec) {
        spec.recipe(new RenameVariableRecipe("first","firstOperand"));
    }

    @Test
    void visitLST() {
        rewriteRun(
            java(
                """
                        package com.yourorg;

                        class FooBar {
                            public int add(int first, int second) {
                                return first + second;
                            }
                        }
                    """,
                """
                        package com.yourorg;

                        class FooBar {
                            public int add(int firstOperand, int second) {
                                return firstOperand + second;
                            }
                        }
                    """
            )
        );
    }
}