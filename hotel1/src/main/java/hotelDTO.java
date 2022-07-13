

public class hotelDTO {
	private int hotel_num;
	private String hotelname;
	private int hoteltype;
	private String roomname;
	private int people;
	private int price;
	public hotelDTO() {
	}
	public int getHotel_num() {
		return hotel_num;
	}
	public void setHotel_num(int hotel_num) {
		this.hotel_num = hotel_num;
	}
	public String getHotelname() {
		return hotelname;
	}
	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	public int getHoteltype() {
		return hoteltype;
	}
	public void setHoteltype(int hoteltype) {
		this.hoteltype = hoteltype;
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getRoomname() {
		return roomname;
	}
	public void setRoomname(String roomname) {
		this.roomname = roomname;
	} 
	
}
