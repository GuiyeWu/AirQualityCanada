package airQC;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

//check exists of city in region
public class input {
	public static boolean exists(String city_name,String region){
		if(region.indexOf(city_name) >= 0)
			return true;
		else{
			//System.out.println("City not exists,check city name again");
			return false;
		}
		}
	
//select proper file to calculate
public static String folder(String city){
	final String ATL = "AAEOU,AASOD,ABEFS,ABFQA,ABYRK,BAARG,BADSZ,BAEMV,CAORH,CASWE,CBDPK,CBELL,CBLGX,CBUCG,DADHJ,DAEGW,DAFMJ,DAFQX,DAHEI,DALZZ,DBEDJ";
	final String ON = "FAFFD,FALIF,FALJI,FAMXK,FAYJG,FAYVQ,FAZKI,,FBKKK,FBLJL,FBLKS,FCAEN,FCCOT,FCFUU,FCGKZ,FCIBD,FCKTB,FCNJT,FCTOV,FCWFX,FCWOV,FCWYG,FDATE,FDCHU,FDEGT,FDGED,FDGEJ,FDGJS,FDJFN,FDMOP,FDQBU,FDQBX,FDSUS,FDZCP,FEAKO,FEARV,FEBWC,FEUTC,FEUZB,FEVJR,FEVJS,FEVJV,FEVNS,FEVNT";
	final String PNR = "GADMZ,GBEIN,HAHJJ,HAIMP,HAPKT,HAPNV,IABOA,IACMP,IADGP,IAEFD,IAEJS,IAFEW,IAFFF,IAFFI,IAFFM,IAHMM,IAIUC,IAKID,IAKRM,LAILN,LALNA,LBAMG";
	final String PVR = "JABNO,JAFNW,JAFUV,JAGPB,JAHJY,JAQAL,JAZBU,JBBWA,JBHJG,JBLVS,JBLXS,JBNTS,JBOAP,JBOBQ,JBRIK,JBTMB,JBXCK,JBXHZ,JCAAC,JCJHI,JCUYZ,JCVCC,JCVCJ,JDATF,KAHFT";
	String file_name = null;
	if(exists(city,ATL)){
		file_name = "\201702_MONTHLY_AQHI_ATL_SiteObs_BACKFILLED.csv";
	}
	else if(exists(city,ON)){
		file_name = "\201702_MONTHLY_AQHI_ON_SiteObs_BACKFILLED.csv";

	}
	else if(exists(city,PNR)){
		file_name = "\201702_MONTHLY_AQHI_PNR_SiteObs_BACKFILLED.csv";

	}
	else if(exists(city,PVR)){
		file_name = "\201702_MONTHLY_AQHI_PYR_SiteObs_BACKFILLED.csv";
	}
	return file_name;
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub		
		Scanner reader = new Scanner(System.in);  // reading and getting city name from user
		System.out.println("Enter a city name: ");
		String city = reader.next();
		reader.close();
		
		File file = new File(folder(city));
		FileInputStream myfile = new FileInputStream(file);
		String thisLine; 
		DataInputStream myInput = new DataInputStream(myfile);
		BufferedReader data = new BufferedReader(new InputStreamReader(myInput));
		
		List<String[]> lines = new ArrayList<String[]>();  //array of a list of string 
		while ((thisLine = data.readLine()) != null) {
		     lines.add(thisLine.split(",,"));
		}

		// convert list to a String array.
		String[][] array = new String[lines.size()][0];
		lines.toArray(array);
		
		//test case printout columnS in file
		System.out.println(Arrays.toString(array[5])); 

	}

}
