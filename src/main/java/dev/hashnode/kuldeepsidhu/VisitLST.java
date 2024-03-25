package dev.hashnode.kuldeepsidhu;

import org.openrewrite.ExecutionContext;
import org.openrewrite.Recipe;
import org.openrewrite.java.JavaIsoVisitor;
import org.openrewrite.java.tree.J;
import org.openrewrite.java.tree.J.ClassDeclaration;
import org.openrewrite.java.tree.J.MethodDeclaration;
import org.openrewrite.java.tree.J.MethodInvocation;

public class VisitLST extends Recipe {

    @Override
    public String getDisplayName() {
        return "Visit LST";
    }

    @Override
    public String getDescription() {
        return "Visit LST.";
    }

    public JavaIsoVisitor<ExecutionContext> getVisitor() {
        return new JavaIsoVisitor<ExecutionContext>() {
            @Override
            public J.CompilationUnit visitCompilationUnit(J.CompilationUnit compUnit, ExecutionContext executionContext) {
                System.out.println("Compilation Unit: " + compUnit.getSourcePath());
                return super.visitCompilationUnit(compUnit, executionContext);
            }

            @Override
            public ClassDeclaration visitClassDeclaration(ClassDeclaration classDecl, ExecutionContext executionContext) {
                System.out.println("Class Declaration: " + classDecl.getSimpleName());
                return super.visitClassDeclaration(classDecl, executionContext);
            }

            @Override
            public MethodDeclaration visitMethodDeclaration(MethodDeclaration method, ExecutionContext executionContext) {
                System.out.println("Method Declaration: " + method.getSimpleName());
                return super.visitMethodDeclaration(method, executionContext);
            }

            @Override
            public MethodInvocation visitMethodInvocation(MethodInvocation method, ExecutionContext executionContext) {
                System.out.println("Method Invocation: " + method.getSimpleName());
                return super.visitMethodInvocation(method, executionContext);
            }
        };
    }
}
