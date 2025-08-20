package capers;

import java.io.File;
import java.io.IOException;

/** A repository for Capers 
 * @author
 * The structure of a Capers Repository is as follows:
 *
 * .capers/ -- top level folder for all persistent data in your lab12 folder
 *    - dogs/ -- folder containing all of the persistent data for dogs
 *    - story -- file containing the current story
 *
 * TODO: change the above structure if you do something different.
 */
public class CapersRepository {
    /** Current Working Directory. */
    static final File CWD = new File(System.getProperty("user.dir"));

    /** Main metadata folder. */
    static final File CAPERS_FOLDER = capers.Utils.join(CWD.getPath(), ".capers"); // TODO Hint: look at the `join` function in Utils
    static final File STORY_FILE = Utils.join(CAPERS_FOLDER.getPath(), "story.txt");
    /**
     * Does required filesystem operations to allow for persistence.
     * (creates any necessary folders or files)
     * Remember: recommended structure (you do not have to follow):
     *
     * .capers/ -- top level folder for all persistent data in your lab12 folder
     *    - dogs/ -- folder containing all of the persistent data for dogs
     *    - story -- file containing the current story
     */
    public static void setupPersistence() {
        CAPERS_FOLDER.mkdir();
        Dog.DOG_FOLDER.mkdir();
        try {
            STORY_FILE.createNewFile();
        } catch (IOException e) {
            System.out.println("you fail");
        }

    }

    /**
     * Appends the first non-command argument in args
     * to a file called `story` in the .capers directory.
     * @param text String of the text to be appended to the story
     */
    public static void writeStory(String text) {
        String fileContents = Utils.readContentsAsString(STORY_FILE);
        Utils.writeContents(STORY_FILE, fileContents, text);
        fileContents = Utils.readContentsAsString(STORY_FILE);
        System.out.println(fileContents);
        Utils.writeContents(STORY_FILE, fileContents, System.lineSeparator());
    }

    /**
     * Creates and persistently saves a dog using the first
     * three non-command arguments of args (name, breed, age).
     * Also prints out the dog's information using toString().
     */
    public static void makeDog(String name, String breed, int age) {
        new Dog(name, breed, age);
        System.out.println(Dog.fromFile(name).toString());
    }

    /**
     * Advances a dog's age persistently and prints out a celebratory message.
     * Also prints out the dog's information using toString().
     * Chooses dog to advance based on the first non-command argument of args.
     * @param name String name of the Dog whose birthday we're celebrating.
     */
    public static void celebrateBirthday(String name) {
        Dog.fromFile(name).haveBirthday();
    }
}
