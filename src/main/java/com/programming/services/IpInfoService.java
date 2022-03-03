package com.programming.services;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.FileSystems;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


@Service
public class IpInfoService {

    //Get Public Ip Address from https://www.myip.com/
    public String getIp() throws IOException {
        Document doc = Jsoup.connect("https://www.myip.com/").get();
        //System.out.println(doc.getElementById("ip"));
        return doc.getElementById("ip").text();
    }

    //Get Ip Information From https://ipinfo.io/
    public String getData(String ip){
        String response = "";
        URL url;

        try{
            String a = "https://ipinfo.io/"+ip+"/json";
            url = new URL(a);
            URLConnection con = url.openConnection();
            BufferedReader br =  new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = br.readLine())!=null){
                response = response + inputLine;
            }
            br.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        return response;
    }


    //Get Country Image
    public String getCountryImage(String country) {

        ClassLoader classLoader = getClass().getClassLoader();

        JsonElement root = null;

        try{


            //root = new JsonParser().parse(new FileReader("your absolute or relative path"));
            //Or
            root = new JsonParser().parse("{\n" +
                    "  \"AF\": \"Afghanistan\",\n" +
                    "  \"AX\": \"Aland Islands\",\n" +
                    "  \"AL\": \"Albania\",\n" +
                    "  \"DZ\": \"Algeria\",\n" +
                    "  \"AS\": \"American Samoa\",\n" +
                    "  \"AD\": \"Andorra\",\n" +
                    "  \"AO\": \"Angola\",\n" +
                    "  \"AI\": \"Anguilla\",\n" +
                    "  \"AQ\": \"Antarctica\",\n" +
                    "  \"AG\": \"Antigua And Barbuda\",\n" +
                    "  \"AR\": \"Argentina\",\n" +
                    "  \"AM\": \"Armenia\",\n" +
                    "  \"AW\": \"Aruba\",\n" +
                    "  \"AU\": \"Australia\",\n" +
                    "  \"AT\": \"Austria\",\n" +
                    "  \"AZ\": \"Azerbaijan\",\n" +
                    "  \"BS\": \"Bahamas\",\n" +
                    "  \"BH\": \"Bahrain\",\n" +
                    "  \"BD\": \"Bangladesh\",\n" +
                    "  \"BB\": \"Barbados\",\n" +
                    "  \"BY\": \"Belarus\",\n" +
                    "  \"BE\": \"Belgium\",\n" +
                    "  \"BZ\": \"Belize\",\n" +
                    "  \"BJ\": \"Benin\",\n" +
                    "  \"BM\": \"Bermuda\",\n" +
                    "  \"BT\": \"Bhutan\",\n" +
                    "  \"BO\": \"Bolivia\",\n" +
                    "  \"BA\": \"Bosnia And Herzegovina\",\n" +
                    "  \"BW\": \"Botswana\",\n" +
                    "  \"BV\": \"Bouvet Island\",\n" +
                    "  \"BR\": \"Brazil\",\n" +
                    "  \"IO\": \"British Indian Ocean Territory\",\n" +
                    "  \"BN\": \"Brunei Darussalam\",\n" +
                    "  \"BG\": \"Bulgaria\",\n" +
                    "  \"BF\": \"Burkina Faso\",\n" +
                    "  \"BI\": \"Burundi\",\n" +
                    "  \"KH\": \"Cambodia\",\n" +
                    "  \"CM\": \"Cameroon\",\n" +
                    "  \"CA\": \"Canada\",\n" +
                    "  \"CV\": \"Cape Verde\",\n" +
                    "  \"KY\": \"Cayman Islands\",\n" +
                    "  \"CF\": \"Central African Republic\",\n" +
                    "  \"TD\": \"Chad\",\n" +
                    "  \"CL\": \"Chile\",\n" +
                    "  \"CN\": \"China\",\n" +
                    "  \"CX\": \"Christmas Island\",\n" +
                    "  \"CC\": \"Cocos (Keeling) Islands\",\n" +
                    "  \"CO\": \"Colombia\",\n" +
                    "  \"KM\": \"Comoros\",\n" +
                    "  \"CG\": \"Congo\",\n" +
                    "  \"CD\": \"Congo, Democratic Republic\",\n" +
                    "  \"CK\": \"Cook Islands\",\n" +
                    "  \"CR\": \"Costa Rica\",\n" +
                    "  \"CI\": \"Cote D\\\"Ivoire\",\n" +
                    "  \"HR\": \"Croatia\",\n" +
                    "  \"CU\": \"Cuba\",\n" +
                    "  \"CY\": \"Cyprus\",\n" +
                    "  \"CZ\": \"Czech Republic\",\n" +
                    "  \"DK\": \"Denmark\",\n" +
                    "  \"DJ\": \"Djibouti\",\n" +
                    "  \"DM\": \"Dominica\",\n" +
                    "  \"DO\": \"Dominican Republic\",\n" +
                    "  \"EC\": \"Ecuador\",\n" +
                    "  \"EG\": \"Egypt\",\n" +
                    "  \"SV\": \"El Salvador\",\n" +
                    "  \"GQ\": \"Equatorial Guinea\",\n" +
                    "  \"ER\": \"Eritrea\",\n" +
                    "  \"EE\": \"Estonia\",\n" +
                    "  \"ET\": \"Ethiopia\",\n" +
                    "  \"FK\": \"Falkland Islands (Malvinas)\",\n" +
                    "  \"FO\": \"Faroe Islands\",\n" +
                    "  \"FJ\": \"Fiji\",\n" +
                    "  \"FI\": \"Finland\",\n" +
                    "  \"FR\": \"France\",\n" +
                    "  \"GF\": \"French Guiana\",\n" +
                    "  \"PF\": \"French Polynesia\",\n" +
                    "  \"TF\": \"French Southern Territories\",\n" +
                    "  \"GA\": \"Gabon\",\n" +
                    "  \"GM\": \"Gambia\",\n" +
                    "  \"GE\": \"Georgia\",\n" +
                    "  \"DE\": \"Germany\",\n" +
                    "  \"GH\": \"Ghana\",\n" +
                    "  \"GI\": \"Gibraltar\",\n" +
                    "  \"GR\": \"Greece\",\n" +
                    "  \"GL\": \"Greenland\",\n" +
                    "  \"GD\": \"Grenada\",\n" +
                    "  \"GP\": \"Guadeloupe\",\n" +
                    "  \"GU\": \"Guam\",\n" +
                    "  \"GT\": \"Guatemala\",\n" +
                    "  \"GG\": \"Guernsey\",\n" +
                    "  \"GN\": \"Guinea\",\n" +
                    "  \"GW\": \"Guinea-Bissau\",\n" +
                    "  \"GY\": \"Guyana\",\n" +
                    "  \"HT\": \"Haiti\",\n" +
                    "  \"HM\": \"Heard Island & Mcdonald Islands\",\n" +
                    "  \"VA\": \"Holy See (Vatican City State)\",\n" +
                    "  \"HN\": \"Honduras\",\n" +
                    "  \"HK\": \"Hong Kong\",\n" +
                    "  \"HU\": \"Hungary\",\n" +
                    "  \"IS\": \"Iceland\",\n" +
                    "  \"IN\": \"India\",\n" +
                    "  \"ID\": \"Indonesia\",\n" +
                    "  \"IR\": \"Iran, Islamic Republic Of\",\n" +
                    "  \"IQ\": \"Iraq\",\n" +
                    "  \"IE\": \"Ireland\",\n" +
                    "  \"IM\": \"Isle Of Man\",\n" +
                    "  \"IL\": \"Israel\",\n" +
                    "  \"IT\": \"Italy\",\n" +
                    "  \"JM\": \"Jamaica\",\n" +
                    "  \"JP\": \"Japan\",\n" +
                    "  \"JE\": \"Jersey\",\n" +
                    "  \"JO\": \"Jordan\",\n" +
                    "  \"KZ\": \"Kazakhstan\",\n" +
                    "  \"KE\": \"Kenya\",\n" +
                    "  \"KI\": \"Kiribati\",\n" +
                    "  \"KR\": \"Korea\",\n" +
                    "  \"KP\": \"North Korea\",\n" +
                    "  \"KW\": \"Kuwait\",\n" +
                    "  \"KG\": \"Kyrgyzstan\",\n" +
                    "  \"LA\": \"Lao People\\\"s Democratic Republic\",\n" +
                    "  \"LV\": \"Latvia\",\n" +
                    "  \"LB\": \"Lebanon\",\n" +
                    "  \"LS\": \"Lesotho\",\n" +
                    "  \"LR\": \"Liberia\",\n" +
                    "  \"LY\": \"Libyan Arab Jamahiriya\",\n" +
                    "  \"LI\": \"Liechtenstein\",\n" +
                    "  \"LT\": \"Lithuania\",\n" +
                    "  \"LU\": \"Luxembourg\",\n" +
                    "  \"MO\": \"Macao\",\n" +
                    "  \"MK\": \"Macedonia\",\n" +
                    "  \"MG\": \"Madagascar\",\n" +
                    "  \"MW\": \"Malawi\",\n" +
                    "  \"MY\": \"Malaysia\",\n" +
                    "  \"MV\": \"Maldives\",\n" +
                    "  \"ML\": \"Mali\",\n" +
                    "  \"MT\": \"Malta\",\n" +
                    "  \"MH\": \"Marshall Islands\",\n" +
                    "  \"MQ\": \"Martinique\",\n" +
                    "  \"MR\": \"Mauritania\",\n" +
                    "  \"MU\": \"Mauritius\",\n" +
                    "  \"YT\": \"Mayotte\",\n" +
                    "  \"MX\": \"Mexico\",\n" +
                    "  \"FM\": \"Micronesia, Federated States Of\",\n" +
                    "  \"MD\": \"Moldova\",\n" +
                    "  \"MC\": \"Monaco\",\n" +
                    "  \"MN\": \"Mongolia\",\n" +
                    "  \"ME\": \"Montenegro\",\n" +
                    "  \"MS\": \"Montserrat\",\n" +
                    "  \"MA\": \"Morocco\",\n" +
                    "  \"MZ\": \"Mozambique\",\n" +
                    "  \"MM\": \"Myanmar\",\n" +
                    "  \"NA\": \"Namibia\",\n" +
                    "  \"NR\": \"Nauru\",\n" +
                    "  \"NP\": \"Nepal\",\n" +
                    "  \"NL\": \"Netherlands\",\n" +
                    "  \"AN\": \"Netherlands Antilles\",\n" +
                    "  \"NC\": \"New Caledonia\",\n" +
                    "  \"NZ\": \"New Zealand\",\n" +
                    "  \"NI\": \"Nicaragua\",\n" +
                    "  \"NE\": \"Niger\",\n" +
                    "  \"NG\": \"Nigeria\",\n" +
                    "  \"NU\": \"Niue\",\n" +
                    "  \"NF\": \"Norfolk Island\",\n" +
                    "  \"MP\": \"Northern Mariana Islands\",\n" +
                    "  \"NO\": \"Norway\",\n" +
                    "  \"OM\": \"Oman\",\n" +
                    "  \"PK\": \"Pakistan\",\n" +
                    "  \"PW\": \"Palau\",\n" +
                    "  \"PS\": \"Palestinian Territory, Occupied\",\n" +
                    "  \"PA\": \"Panama\",\n" +
                    "  \"PG\": \"Papua New Guinea\",\n" +
                    "  \"PY\": \"Paraguay\",\n" +
                    "  \"PE\": \"Peru\",\n" +
                    "  \"PH\": \"Philippines\",\n" +
                    "  \"PN\": \"Pitcairn\",\n" +
                    "  \"PL\": \"Poland\",\n" +
                    "  \"PT\": \"Portugal\",\n" +
                    "  \"PR\": \"Puerto Rico\",\n" +
                    "  \"QA\": \"Qatar\",\n" +
                    "  \"RE\": \"Reunion\",\n" +
                    "  \"RO\": \"Romania\",\n" +
                    "  \"RU\": \"Russian Federation\",\n" +
                    "  \"RW\": \"Rwanda\",\n" +
                    "  \"BL\": \"Saint Barthelemy\",\n" +
                    "  \"SH\": \"Saint Helena\",\n" +
                    "  \"KN\": \"Saint Kitts And Nevis\",\n" +
                    "  \"LC\": \"Saint Lucia\",\n" +
                    "  \"MF\": \"Saint Martin\",\n" +
                    "  \"PM\": \"Saint Pierre And Miquelon\",\n" +
                    "  \"VC\": \"Saint Vincent And Grenadines\",\n" +
                    "  \"WS\": \"Samoa\",\n" +
                    "  \"SM\": \"San Marino\",\n" +
                    "  \"ST\": \"Sao Tome And Principe\",\n" +
                    "  \"SA\": \"Saudi Arabia\",\n" +
                    "  \"SN\": \"Senegal\",\n" +
                    "  \"RS\": \"Serbia\",\n" +
                    "  \"SC\": \"Seychelles\",\n" +
                    "  \"SL\": \"Sierra Leone\",\n" +
                    "  \"SG\": \"Singapore\",\n" +
                    "  \"SK\": \"Slovakia\",\n" +
                    "  \"SI\": \"Slovenia\",\n" +
                    "  \"SB\": \"Solomon Islands\",\n" +
                    "  \"SO\": \"Somalia\",\n" +
                    "  \"ZA\": \"South Africa\",\n" +
                    "  \"GS\": \"South Georgia And Sandwich Isl.\",\n" +
                    "  \"ES\": \"Spain\",\n" +
                    "  \"LK\": \"Sri Lanka\",\n" +
                    "  \"SD\": \"Sudan\",\n" +
                    "  \"SR\": \"Suriname\",\n" +
                    "  \"SJ\": \"Svalbard And Jan Mayen\",\n" +
                    "  \"SZ\": \"Swaziland\",\n" +
                    "  \"SE\": \"Sweden\",\n" +
                    "  \"CH\": \"Switzerland\",\n" +
                    "  \"SY\": \"Syrian Arab Republic\",\n" +
                    "  \"TW\": \"Taiwan\",\n" +
                    "  \"TJ\": \"Tajikistan\",\n" +
                    "  \"TZ\": \"Tanzania\",\n" +
                    "  \"TH\": \"Thailand\",\n" +
                    "  \"TL\": \"Timor-Leste\",\n" +
                    "  \"TG\": \"Togo\",\n" +
                    "  \"TK\": \"Tokelau\",\n" +
                    "  \"TO\": \"Tonga\",\n" +
                    "  \"TT\": \"Trinidad And Tobago\",\n" +
                    "  \"TN\": \"Tunisia\",\n" +
                    "  \"TR\": \"Turkey\",\n" +
                    "  \"TM\": \"Turkmenistan\",\n" +
                    "  \"TC\": \"Turks And Caicos Islands\",\n" +
                    "  \"TV\": \"Tuvalu\",\n" +
                    "  \"UG\": \"Uganda\",\n" +
                    "  \"UA\": \"Ukraine\",\n" +
                    "  \"AE\": \"United Arab Emirates\",\n" +
                    "  \"GB\": \"United Kingdom\",\n" +
                    "  \"US\": \"United States\",\n" +
                    "  \"UM\": \"United States Outlying Islands\",\n" +
                    "  \"UY\": \"Uruguay\",\n" +
                    "  \"UZ\": \"Uzbekistan\",\n" +
                    "  \"VU\": \"Vanuatu\",\n" +
                    "  \"VE\": \"Venezuela\",\n" +
                    "  \"VN\": \"Vietnam\",\n" +
                    "  \"VG\": \"Virgin Islands, British\",\n" +
                    "  \"VI\": \"Virgin Islands, U.S.\",\n" +
                    "  \"WF\": \"Wallis And Futuna\",\n" +
                    "  \"EH\": \"Western Sahara\",\n" +
                    "  \"YE\": \"Yemen\",\n" +
                    "  \"ZM\": \"Zambia\",\n" +
                    "  \"ZW\": \"Zimbabwe\"\n" +
                    "}");

            //System.out.println(root.getAsJsonObject().get("AF"));

        }
        catch (Exception e){
            e.printStackTrace();
        }



        return "https://countryflagsapi.com/png/"+root.getAsJsonObject().get(country).toString().replace("\"","");
    }
}
