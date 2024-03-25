package dev.hashnode.kuldeepsidhu;

import org.openrewrite.ExecutionContext;
import org.openrewrite.Recipe;
import org.openrewrite.java.JavaIsoVisitor;
import org.openrewrite.java.TreeVisitingPrinter;
import org.openrewrite.java.tree.J;

public class PrintLST extends Recipe {

    @Override
    public String getDisplayName() {
        return "Print LST";
    }

    @Override
    public String getDescription() {
        return "Print LST.";
    }

    public JavaIsoVisitor<ExecutionContext> getVisitor() {
        return new JavaIsoVisitor<ExecutionContext>() {
            @Override
            public J.CompilationUnit visitCompilationUnit(J.CompilationUnit compUnit, ExecutionContext executionContext) {
                System.out.println(TreeVisitingPrinter.printTree(getCursor()));
                return super.visitCompilationUnit(compUnit, executionContext);
            }
        };
    }
}
