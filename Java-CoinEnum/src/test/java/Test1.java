
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author smi1e
 * Date 2019/11/24 15:14
 * Description
 */
public class Test1 {
    public static void main(String[] args) throws ParseException {
        File file = new File("C:\\Users\\Administrator\\Desktop\\JavaSpecification\\Java-CoinEnum\\src\\test\\java\\测长-GCLT0623-1检验记录.xls");
        List<Map<String, String>> maps = ExcelUtil.readExcel(file);
        System.out.println(maps.toString());
    }
}
