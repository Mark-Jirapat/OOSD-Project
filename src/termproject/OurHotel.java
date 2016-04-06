
public class OurHotel 
{

	public static void main(String[] args) 
	{
		Sample ourhotel = new Sample();
		HotelDB  hdb = new HotelDB();
		ourhotel.setDB(hdb);
		ourhotel.setSample();
		//System.out.println(hdb.db.disconnect());
	}

}
