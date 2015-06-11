package main;

import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import semantic_entity.srtuple;

/*
 * - Author: Di Tian
 * - Email: ditian2014@u.northwestern.edu
 * 
 * 
 * - The semantic relatedness generating service is provided by
 *   http://marimba.d.umn.edu/cgi-bin/similarity/similarity.cgi
 * - Generate semantic relatedness for each pair of categories above using 
 *   3 different standards: "Leacock & Chodorow", "Wu & Palmer" and "Resnik", respectively.
 * - The semantic relatedness for each pair of instances is equal to 
 *   the semantic relatedness of categories that they belong to.
 * */


public class semantic_relatedness
{
	public static void main(String[] args)
	{
		Map<Integer, String> m = new HashMap<Integer, String>();
		
		m.put(1, "coffeehouse");
		m.put(101, "Intelligentsia Coffee 1 (41.884489, -87.625928)");
		m.put(102, "HERO Coffee Bar (41.875881, -87.629079)");
		m.put(103, "Bow Truss Coffee Roasters (41.889441, -87.634248)");
		m.put(104, "Intelligentsia Coffee 2 (41.877975, -87.629570)");
		m.put(105, "La Colombe Torrefaction (41.884027, -87.651928)");
		m.put(106, "Overflow Coffee Bar (41.860482, -87.627782)");
		m.put(107, "Dollop Coffee & Tea (41.892395, -87.618815)");
		m.put(108, "The Coffee Alley (41.869604, -87.656338)");
		m.put(109, "Cafecito (41.875831, -87.626394)");
		m.put(110, "Sip Coffee House & Garden (41.890875, -87.658397)");
		m.put(111, "Starbucks 1 (41.884702, -87.637358)");
		m.put(112, "Starbucks 2 (41.900983, -87.627429)");
		m.put(113, "Starbucks 3 (41.878865, -87.636082)");
		m.put(114, "Starbucks 4 (41.882491, -87.639697)");
		m.put(115, "Starbucks 5 (41.879276, -87.624887)");
		m.put(116, "Starbucks 6 (41.885136, -87.621509)");
		m.put(117, "Starbucks 7 (41.879420, -87.640905)");
		m.put(118, "Starbucks 8 (41.899005, -87.628099)");
		m.put(119, "Starbucks 9 (41.911302, -87.635020)");
		m.put(120, "Starbucks 10 (41.879037, -87.631299)");
		
		
		
		m.put(2, "restaurant");
		m.put(201, "Girl & the Goat (41.884168, -87.647971)");
		m.put(202, "The Purple Pig (41.891116, -87.624458)");
		m.put(203, "Xoco (41.890705, -87.630871)");
		m.put(204, "Quartino (41.893421, -87.628346)");
		m.put(205, "Athena Greek Restaurant (41.878645, -87.647595)");
		
		
		
		m.put(3, "chinese");
		m.put(301, "Lao Sze Chuan-Downtown (41.891463, -87.624617)");
		m.put(302, "Shanghai Terrace at The Peninsula Chicago (41.896004, -87.625112)");
		m.put(303, "Yum Cha Dim Sum Parlor (41.885302, -87.618241)");
		m.put(304, "Wow Bao (41.897802, -87.622877)");
		m.put(305, "Joy Yee's Noodle Shop (41.864409, -87.646696)");
		
		
		
		m.put(4, "fast food");
		m.put(401, "Zeus Gyros (41.878139, -87.647724)");
		m.put(402, "Mr Greek Gyros (41.878116, -87.647442)");
		m.put(403, "Taco Burrito King (41.877784, -87.647806)");
		m.put(404, "Chick-fil-A (41.896887, -87.627050)");
		m.put(405, "Da Lobsta (41.902526, -87.627877)");
		m.put(406, "Five Guys Burgers and Fries (41.867747, -87.626252)");
		m.put(407, "Taco Bell (41.882308, -87.640513)");
		m.put(408, "Chipotle Mexican Grill (41.887289, -87.624989)");
		m.put(409, "Pizano's Pizza (41.898626, -87.628496)");
		m.put(410, "U.B. Dogs (41.885489, -87.635217)");
		m.put(411, "Urban Counter (41.867047, -87.625442)");
		m.put(412, "BIG & little's (41.898308, -87.637494)");
		
		
		
		m.put(5, "bar");
		m.put(501, "The Aberdeen Tap (41.890142, -87.654805)");
		m.put(502, "The 3rd Coast (41.905618, -87.630325)");
		m.put(503, "Fado Irish Pub & Restaurant (41.891758, -87.631340)");
		m.put(504, "The Gage (41.881315, -87.624681)");
		m.put(505, "First Draft (41.873494, -87.630315)");
		m.put(506, "Woodie's Flat (41.910198, -87.634404)");
		m.put(507, "Polk Street Pub (41.872150, -87.641383)");
		m.put(508, "Three Aces (41.869144, -87.660076)");
		m.put(509, "Celtic Crossings (41.896320, -87.630984)");
		m.put(510, "Farmhouse (41.896813, -87.635383)");
		
		
		
		m.put(6, "theater");
		m.put(601, "ShowPlace ICON (41.869558, -87.632598)");
		m.put(602, "AMC River East 21 (41.891325, -87.618996)");
		m.put(603, "Chicago Theatre (41.885499, -87.627573)");
		m.put(604, "Cadillac Palace (41.884320, -87.632780)");
		m.put(605, "Lookingglass Theatre (41.897179, -87.623771)");
		m.put(606, "Bank of America Theatre (41.880855, -87.628462)");
		
		
		
		//create look up table: the clique
		/*
		 *1 == coffeehouse
		 *2 == restaurant
		 *3 == chinese
		 *4 == fast food
		 *5 == bar
		 *6 == theater
		 */
		ArrayList<srtuple> lut = new ArrayList<srtuple>();
		
		
		/* leacock and chodorow
		srtuple tp11 = new srtuple(1, 1, 3.6889);
		lut.add(tp11);
		
		srtuple tp12 = new srtuple(1, 2, 2.9957);
		lut.add(tp12);
		
		srtuple tp13 = new srtuple(1, 3, 1.204);
		lut.add(tp13);
		
		srtuple tp14 = new srtuple(1, 4, 1.1239);
		lut.add(tp14);
		
		srtuple tp15 = new srtuple(1, 5, 1.8971);
		lut.add(tp15);
		
		srtuple tp16 = new srtuple(1, 6, 2.3026);
		lut.add(tp16);
		
		
		
		srtuple tp21 = new srtuple(2, 1, 2.9957);
		lut.add(tp21);
		
		srtuple tp22 = new srtuple(2, 2, 3.6889);
		lut.add(tp22);
		
		srtuple tp23 = new srtuple(2, 3, 1.291);
		lut.add(tp23);
		
		srtuple tp24 = new srtuple(2, 4, 1.204);
		lut.add(tp24);
		
		srtuple tp25 = new srtuple(2, 5, 2.0794);
		lut.add(tp25);
		
		srtuple tp26 = new srtuple(2, 6, 2.5903);
		lut.add(tp26);
		
		
		
		srtuple tp31 = new srtuple(3, 1, 1.204);
		lut.add(tp31);
		
		srtuple tp32 = new srtuple(3, 2, 1.291);
		lut.add(tp32);
		
		srtuple tp33 = new srtuple(3, 3, 3.6889);
		lut.add(tp33);
		
		srtuple tp34 = new srtuple(3, 4, 1.291);
		lut.add(tp34);
		
		srtuple tp35 = new srtuple(3, 5, 1.3863);
		lut.add(tp35);
		
		srtuple tp36 = new srtuple(3, 6, 1.3863);
		lut.add(tp36);
		
		
		
		srtuple tp41 = new srtuple(4, 1, 1.1239);
		lut.add(tp41);
		
		srtuple tp42 = new srtuple(4, 2, 1.204);
		lut.add(tp42);
		
		srtuple tp43 = new srtuple(4, 3, 1.291);
		lut.add(tp43);
		
		srtuple tp44 = new srtuple(4, 4, 3.6889);
		lut.add(tp44);
		
		srtuple tp45 = new srtuple(4, 5, 1.291);
		lut.add(tp45);
		
		srtuple tp46 = new srtuple(4, 6, 1.3863);
		lut.add(tp46);
		
		
		
		srtuple tp51 = new srtuple(5, 1, 1.8971);
		lut.add(tp51);
		
		srtuple tp52 = new srtuple(5, 2, 2.0794);
		lut.add(tp52);
		
		srtuple tp53 = new srtuple(5, 3, 1.3863);
		lut.add(tp53);
		
		srtuple tp54 = new srtuple(5, 4, 1.291);
		lut.add(tp54);
		
		srtuple tp55 = new srtuple(5, 5, 3.6889);
		lut.add(tp55);
		
		srtuple tp56 = new srtuple(5, 6, 2.0794);
		lut.add(tp56);
		
		
		
		srtuple tp61 = new srtuple(6, 1, 2.3026);
		lut.add(tp61);
		
		srtuple tp62 = new srtuple(6, 2, 2.5903);
		lut.add(tp62);
		
		srtuple tp63 = new srtuple(6, 3, 1.3863);
		lut.add(tp63);
		
		srtuple tp64 = new srtuple(6, 4, 1.3863);
		lut.add(tp64);
		
		srtuple tp65 = new srtuple(6, 5, 2.0794);
		lut.add(tp65);
		
		srtuple tp66 = new srtuple(6, 6, 3.6889);
		lut.add(tp66);
		*/
		
		/*wu and palmer
		srtuple tp11 = new srtuple(1, 1, 1);
		lut.add(tp11);
		
		srtuple tp12 = new srtuple(1, 2, 0.9474);
		lut.add(tp12);
		
		srtuple tp13 = new srtuple(1, 3, 0.4762);
		lut.add(tp13);
		
		srtuple tp14 = new srtuple(1, 4, 0.3333);
		lut.add(tp14);
		
		srtuple tp15 = new srtuple(1, 5, 0.7368);
		lut.add(tp15);
		
		srtuple tp16 = new srtuple(1, 6, 0.8421);
		lut.add(tp16);
		
		
		
		srtuple tp21 = new srtuple(2, 1, 0.9474);
		lut.add(tp21);
		
		srtuple tp22 = new srtuple(2, 2, 1);
		lut.add(tp22);
		
		srtuple tp23 = new srtuple(2, 3, 0.5);
		lut.add(tp23);
		
		srtuple tp24 = new srtuple(2, 4, 0.3529);
		lut.add(tp24);
		
		srtuple tp25 = new srtuple(2, 5, 0.7778);
		lut.add(tp25);
		
		srtuple tp26 = new srtuple(2, 6, 0.8889);
		lut.add(tp26);
		
		
		
		srtuple tp31 = new srtuple(3, 1, 0.4762);
		lut.add(tp31);
		
		srtuple tp32 = new srtuple(3, 2, 0.5);
		lut.add(tp32);
		
		srtuple tp33 = new srtuple(3, 3, 1);
		lut.add(tp33);
		
		srtuple tp34 = new srtuple(3, 4, 0.375);
		lut.add(tp34);
		
		srtuple tp35 = new srtuple(3, 5, 0.5263);
		lut.add(tp35);
		
		srtuple tp36 = new srtuple(3, 6, 0.5);
		lut.add(tp36);
		
		
		
		srtuple tp41 = new srtuple(4, 1, 0.3333);
		lut.add(tp41);
		
		srtuple tp42 = new srtuple(4, 2, 0.3529);
		lut.add(tp42);
		
		srtuple tp43 = new srtuple(4, 3, 0.375);
		lut.add(tp43);
		
		srtuple tp44 = new srtuple(4, 4, 1);
		lut.add(tp44);
		
		srtuple tp45 = new srtuple(4, 5, 0.375);
		lut.add(tp45);
		
		srtuple tp46 = new srtuple(4, 6, 0.4);
		lut.add(tp46);
		
		
		
		srtuple tp51 = new srtuple(5, 1, 0.7368);
		lut.add(tp51);
		
		srtuple tp52 = new srtuple(5, 2, 0.7778);
		lut.add(tp52);
		
		srtuple tp53 = new srtuple(5, 3, 0.5263);
		lut.add(tp53);
		
		srtuple tp54 = new srtuple(5, 4, 0.375);
		lut.add(tp54);
		
		srtuple tp55 = new srtuple(5, 5, 1);
		lut.add(tp55);
		
		srtuple tp56 = new srtuple(5, 6, 0.7778);
		lut.add(tp56);
		
		
		
		srtuple tp61 = new srtuple(6, 1, 0.8421);
		lut.add(tp61);
		
		srtuple tp62 = new srtuple(6, 2, 0.8889);
		lut.add(tp62);
		
		srtuple tp63 = new srtuple(6, 3, 0.5);
		lut.add(tp63);
		
		srtuple tp64 = new srtuple(6, 4, 0.4);
		lut.add(tp64);
		
		srtuple tp65 = new srtuple(6, 5, 0.7778);
		lut.add(tp65);
		
		srtuple tp66 = new srtuple(6, 6, 1);
		lut.add(tp66);
		*/
		
		
		//resnik
		srtuple tp11 = new srtuple(1, 1, 11.7658);
		lut.add(tp11);
		
		srtuple tp12 = new srtuple(1, 2, 8.3);
		lut.add(tp12);
		
		srtuple tp13 = new srtuple(1, 3, 1.3696);
		lut.add(tp13);
		
		srtuple tp14 = new srtuple(1, 4, 0.6144);
		lut.add(tp14);
		
		srtuple tp15 = new srtuple(1, 5, 3.9425);
		lut.add(tp15);
		
		srtuple tp16 = new srtuple(1, 6, 5.3823);
		lut.add(tp16);
		
		
		
		srtuple tp21 = new srtuple(2, 1, 8.3);
		lut.add(tp21);
		
		srtuple tp22 = new srtuple(2, 2, 11.7658);
		lut.add(tp22);
		
		srtuple tp23 = new srtuple(2, 3, 1.3696);
		lut.add(tp23);
		
		srtuple tp24 = new srtuple(2, 4, 0.6144);
		lut.add(tp24);
		
		srtuple tp25 = new srtuple(2, 5, 3.9425);
		lut.add(tp25);
		
		srtuple tp26 = new srtuple(2, 6, 5.3823);
		lut.add(tp26);
		
		
		
		srtuple tp31 = new srtuple(3, 1, 1.3696);
		lut.add(tp31);
		
		srtuple tp32 = new srtuple(3, 2, 1.3696);
		lut.add(tp32);
		
		srtuple tp33 = new srtuple(3, 3, 11.7658);
		lut.add(tp33);
		
		srtuple tp34 = new srtuple(3, 4, 0.6144);
		lut.add(tp34);
		
		srtuple tp35 = new srtuple(3, 5, 3.0718);
		lut.add(tp35);
		
		srtuple tp36 = new srtuple(3, 6, 1.3696);
		lut.add(tp36);
		
		
		
		srtuple tp41 = new srtuple(4, 1, 0.6144);
		lut.add(tp41);
		
		srtuple tp42 = new srtuple(4, 2, 0.6144);
		lut.add(tp42);
		
		srtuple tp43 = new srtuple(4, 3, 0.6144);
		lut.add(tp43);
		
		srtuple tp44 = new srtuple(4, 4, 11.7658);
		lut.add(tp44);
		
		srtuple tp45 = new srtuple(4, 5, 0.6144);
		lut.add(tp45);
		
		srtuple tp46 = new srtuple(4, 6, 0.6144);
		lut.add(tp46);
		
		
		
		srtuple tp51 = new srtuple(5, 1, 3.9425);
		lut.add(tp51);
		
		srtuple tp52 = new srtuple(5, 2, 3.9425);
		lut.add(tp52);
		
		srtuple tp53 = new srtuple(5, 3, 3.0718);
		lut.add(tp53);
		
		srtuple tp54 = new srtuple(5, 4, 0.6144);
		lut.add(tp54);
		
		srtuple tp55 = new srtuple(5, 5, 11.7658);
		lut.add(tp55);
		
		srtuple tp56 = new srtuple(5, 6, 3.9425);
		lut.add(tp56);
		
		
		
		srtuple tp61 = new srtuple(6, 1, 5.3823);
		lut.add(tp61);
		
		srtuple tp62 = new srtuple(6, 2, 5.3823);
		lut.add(tp62);
		
		srtuple tp63 = new srtuple(6, 3, 1.3696);
		lut.add(tp63);
		
		srtuple tp64 = new srtuple(6, 4, 0.6144);
		lut.add(tp64);
		
		srtuple tp65 = new srtuple(6, 5, 3.9425);
		lut.add(tp65);
		
		srtuple tp66 = new srtuple(6, 6, 11.7658);
		lut.add(tp66);
	
		
		
		//create index table
		int[] idxt = 
		{
		1, 2, 3, 4, 5, 6,
		101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120,
		201, 202, 203, 204, 205,
		301, 302, 303, 304, 305,
		401, 402, 403, 404, 405, 406, 407, 408, 409, 410, 411, 412,
		501, 502, 503, 504, 505, 506, 507, 508, 509, 510,
		601, 602, 603, 604, 605, 606
		};
		
		
		
		//results go here
		ArrayList<srtuple> result = new ArrayList<srtuple>();
		
		
		
		//generate semantic relatedness for instances
		int len = idxt.length;
		for (int i=0; i<len-1; ++i)
		{
			int first = idxt[i];
			
			for (int j=i+1; j<len; ++j)
			{
				int second = idxt[j];
				
				int f = (first>100) ? (first/100) : (first);
				int s = (second>100) ? (second/100) : (second);
				int lutidx = (f-1)*6 + (s-1);
				double relation = lut.get(lutidx).sr/11.7658;
				double r_round = Math.round(relation*10000)/10000.0;
				result.add(new srtuple(first, second, r_round));
			}
		}
		
		
		
		//dump to txt file
		try
		{
	    	FileWriter wt = new FileWriter("relatedness.txt", true);
	    	BufferedWriter bfwt=new BufferedWriter(wt);
	    	
	    	for(int i=0; i<result.size(); i++)
	    	{
	    		srtuple tpl = result.get(i);
	    		int first = tpl.first;
	    		int second = tpl.second;
	    		double sr = tpl.sr;
	    		
	    		//int f = (first>100) ? (first/100) : (first);
				//int s = (second>100) ? (second/100) : (second);
	    		
	    		//bfwt.write(Integer.toString(first)+" is "+m.get(f)+"    "+Integer.toString(second)+" is "+m.get(s)+"    "+Double.toString(sr));
	    		bfwt.write(m.get(first)+";"+m.get(second)+";"+Double.toString(sr));
	    		bfwt.newLine();
	    	}
	    	bfwt.close();
	    }
		catch(IOException e)
		{
	    	e.printStackTrace();
	    }
	}

}
