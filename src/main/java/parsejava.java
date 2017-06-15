import com.github.javaparser.*;
import com.github.javaparser.ast.*;
import com.github.javaparser.ast.body.*;
import java.io.*;
import java.util.*;

public class parsejava {
  private static String getClass(String filename) throws Exception {
    try (FileInputStream fin = new FileInputStream(new File(filename))) {
      CompilationUnit cu = JavaParser.parse(fin);
      for (TypeDeclaration type : cu.getTypes()) {
        if (type instanceof ClassOrInterfaceDeclaration) {
          return type.getName();
        }
      }

    }

    return null;
  }

  public static void main(final String[] args) throws Exception {
    System.out.println(getClass(args[0]));
  }
}
