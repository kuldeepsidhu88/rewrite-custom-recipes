package dev.hashnode.kuldeepsidhu;

import org.openrewrite.ExecutionContext;
import org.openrewrite.Recipe;
import org.openrewrite.java.JavaIsoVisitor;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
@Data
public class RenameVariableRecipe extends Recipe {

    String oldName;
    String newName;

    @JsonCreator
    public RenameVariableRecipe(@JsonProperty("oldName")String oldName, @JsonProperty("newName") String newName) {
        this.oldName = oldName;
        this.newName = newName;
    }

    @Override
    public String getDisplayName() {
        return "RenameVariable Recipe";
    }

    @Override
    public String getDescription() {
        return "RenameVariable Recipe.";
    }

    public JavaIsoVisitor<ExecutionContext> getVisitor() {
        return new RenameVariableVisitor(oldName, newName);
    }
}
