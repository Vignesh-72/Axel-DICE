package axel;
import com.axel.Core;
import org.junit.Test;
import org.junit.Assert;

public class CoreTest {
    
    public Core core = new Core();
    String langArr[] = new String[]{"Python", "Java", "C", "C++", "C#", "Go", "Lua", "PHP", "Rust", "Dart", "Ruby", "Perl", "Cobol", "HTML", "Scala", "Haskel", "Swift", "MATLAB", "Kotlin", "Fortran", "JavaScript", "Objective-C", "Shell (Bash)", "TypeScript", "Visual Basic", "Assembly language" };
    String extensions[] = new String[]{".py",".java",".c",".cpp",".cs",".go",".lua",".php",".rs",".dart",".rb",".pl",".cobol",".html",".scala",".hs",".swift",".m",".kt",".f90",".js",".ob",".sh",".ts",".vb",".asm"};
    public CoreTest() {
        testLangDetector();
    }

   @Test
    public void testLangDetector() {

        for(int i = 0 ; i < langArr.length ; i++){
            System.out.println("Lang :"+langArr[i]+" Extension : "+extensions[i]);
            core.lang = langArr[i];
            core.languageDetector("Test Case");
            Assert.assertEquals(extensions[i], core.fileType);
        }
    }
    public static void main(String args[]){
        Core core = new Core();
        core.lang = "Go";
        core.languageDetector("Test Case");
        System.out.println("Extension : "+core.fileType);

    }

}
