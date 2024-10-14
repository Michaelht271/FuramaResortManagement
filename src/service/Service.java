package service;
import java.util.ArrayList;

public interface Service<T> {
	void add(T t); // Thêm mới đối tượng

	ArrayList<T> getAll(); // Lấy danh sách tất cả đối tượng

	void update(T t); // Cập nhật đối tượng

	T findById(String id); // Tìm đối tượng theo ID

	void deleteById(String id); // Xóa đối tượng theo ID
	public void display();

}
