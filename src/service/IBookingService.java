package service;

import model.Booking;

public interface IBookingService extends Service<Booking>{
	void createNewContract();      // Tạo hợp đồng mới
    void displayContracts();        // Hiển thị danh sách hợp đồng
    void editContract(String contractId); // Chỉnh sửa hợp đồng
	

}
