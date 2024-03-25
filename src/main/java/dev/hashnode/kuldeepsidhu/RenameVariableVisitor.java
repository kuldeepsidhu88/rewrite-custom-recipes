package dev.hashnode.kuldeepsidhu;

import org.openrewrite.ExecutionContext;
import org.openrewrite.java.JavaIsoVisitor;
import org.openrewrite.java.TreeVisitingPrinter;
import org.openrewrite.java.tree.J;
import org.openrewrite.java.tree.J.Identifier;

public class RenameVariableVisitor extends JavaIsoVisitor<ExecutionContext> {

    private final String oldName;
    private final String newName;

    public RenameVariableVisitor(String oldName, String newName) {
        this.oldName = oldName;
        this.newName = newName;
    }
    @Override
    public J.CompilationUnit visitCompilationUnit(J.CompilationUnit compUnit, ExecutionContext executionContext) {
        //System.out.println("Compilation Unit: " + compUnit.getSourcePath());
        System.out.println(TreeVisitingPrinter.printTree(getCursor()));
        return super.visitCompilationUnit(compUnit, executionContext);
    }
    @Override
    public Identifier visitIdentifier(Identifier identifier, ExecutionContext executionContext) {

        if (identifier.getSimpleName().equals(oldName)) {
            return identifier.withSimpleName(newName);
        }
        return super.visitIdentifier(identifier, executionContext);
    }
}

