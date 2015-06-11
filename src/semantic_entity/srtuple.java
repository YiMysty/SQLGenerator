package semantic_entity;
/*
 * -Author: Di Tian
 * -Email: ditian2014@u.northwestern.edu
 * */
public class srtuple
{
	public int first;
	public int second;
	public double sr;	//sr for semantic relatedness
	
	public srtuple(int _first, int _second, double _sr)
	{
		this.first = _first;
		this.second = _second;
		this.sr = _sr;
	}
}
