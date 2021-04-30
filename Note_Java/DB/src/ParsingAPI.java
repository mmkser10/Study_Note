import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParsingAPI {

    private static String getTagValue(String tag, Element element) {
        NodeList nlList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node nValue = (Node) nlList.item(0);
        if (nValue == null)
            return null;
        return nValue.getNodeValue();
    }

    public static LocalDateTime valueToLocalDateTime(String beforeData){
        DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime afterData = LocalDateTime.parse(beforeData, DTF);
        return afterData;
    }

    public static Document parsingAPIUrl(String serviceKey, String numOfRows) throws ParserConfigurationException, IOException, SAXException {
        String url = "http://openapi.onbid.co.kr/openapi/services/" +
                        "KamcoPblsalThingInquireSvc/getKamcoPbctCltrList?serviceKey=" +
                        serviceKey + "&numOfRows=" + numOfRows;

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        return documentBuilder.parse(url);
    }

    public static void approachAPIJSON(Document doc, DBConnect dbConnect){
        doc.getDocumentElement().normalize();
        System.out.println("Root element : " + doc.getDocumentElement().getNodeName()); //XML의 최상위 노드를 리턴
        NodeList nodeList = doc.getElementsByTagName("item");
        System.out.println("Parsing List = " + nodeList.getLength()); //item노드의 개수를 리턴, 즉 한 페이지당 리턴되는 item의 개수
        for (int temp = 0; temp < nodeList.getLength(); temp++) {
            Node node = nodeList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                dbConnect.insertOnbidTable(
                        Integer.parseInt(getTagValue("PLNM_NO", element)),
                        Integer.parseInt(getTagValue("PBCT_NO", element)),
                        Integer.parseInt(getTagValue("PBCT_CDTN_NO", element)),
                        Integer.parseInt(getTagValue("CLTR_NO", element)),
                        Integer.parseInt(getTagValue("CLTR_HSTR_NO", element)),
                        getTagValue("SCRN_GRP_CD", element),
                        getTagValue("CTGR_FULL_NM", element),
                        getTagValue("BID_MNMT_NO", element),
                        getTagValue("CLTR_NM", element),
                        getTagValue("CLTR_MNMT_NO", element),
                        getTagValue("LDNM_ADRS", element),
                        getTagValue("NMRD_ADRS", element),
                        getTagValue("DPSL_MTD_CD", element),
                        getTagValue("DPSL_MTD_NM", element),
                        getTagValue("BID_MTD_NM", element),
                        getTagValue("MIN_BID_PRC", element),
                        getTagValue("APSL_ASES_AVG_AMT", element),
                        getTagValue("FEE_RATE", element),
                        valueToLocalDateTime(getTagValue("PBCT_BEGN_DTM", element)),
                        valueToLocalDateTime(getTagValue("PBCT_CLS_DTM", element)),
                        getTagValue("PBCT_CLTR_STAT_NM", element),
                        getTagValue("USCBD_CNT", element)
                );
            }
        }
    }

    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException, ParserConfigurationException, SAXException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String driver; String url; String user;
        while(true) {
            System.out.println("현재 사용하시는 DB가 H2 embedded입니까 ? (Y/N)");
            String isValidH2 = br.readLine();
            if (isValidH2.equals("Y")) {
                driver="org.h2.driver";
                url="jdbc:h2:tcp://localhost/~/test";
                user="sa";
                break;
            }
            else if (isValidH2.equals("N")) {
                System.out.println("DB driver 입 : ");
                driver = br.readLine();
                System.out.println("DB url 입력 : ");
                url = br.readLine();
                System.out.println("DB user 입력 : ");
                user = br.readLine();
                break;
            }
            else {
                System.out.println("올바른 입력을 하시기 바랍니다.");
            }
        }

        DBConnect dbConnect = new DBConnect(driver, url, user, "");
        if(dbConnect.activateConnectDB()){
            dbConnect.deleteOnbidTable();
            System.out.println("API serviceKey 입력 : ");
            String serviceKey = br.readLine();
            System.out.println("API 페이지당 데이터 개수 입력 : ");
            String numOfRows = br.readLine();
            Document doc = parsingAPIUrl(serviceKey, numOfRows);
            approachAPIJSON(doc, dbConnect);
        }
    }
}