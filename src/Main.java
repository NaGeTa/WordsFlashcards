import model.Dictionary;
import service.CheckerService;
import service.DictionaryService;

public class Main {
    public static void main(String[] args) {
        DictionaryService dictionaryService = new DictionaryService();
        Dictionary dictionary = dictionaryService.getDictionary();
        CheckerService checkerService = new CheckerService();
        checkerService.startChecking(dictionary, 50);
    }

}