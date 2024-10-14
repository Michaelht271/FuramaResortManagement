package repository;

import java.util.ArrayList;



public interface Respository<T> {
	  void saveToFile();  // Lưu danh sách đối tượng xuống file
	   void loadFromFile();          // Đọc dữ liệu từ file và trả về danh sách đối tượng
	    T findById(String id);           // Tìm đối tượng theo ID
	    void deleteById(String id);      // Xóa đối tượng theo ID
	    void add(T t);                   // Thêm mới đối tượng
	    void update(T t);                // Cập nhật đối tượng
	    void display(ArrayList<T> list);
		
	

}
