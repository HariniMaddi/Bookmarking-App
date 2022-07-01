package com.semanticsquare.thrillio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.semanticsquare.thrillio.DataStore;
import com.semanticsquare.thrillio.entities.Book;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.UserBookmark;

public class BookmarkDao {
public  List<List<Bookmark>>   getBookmarks() {
	return DataStore.getBookmarks();
}

public void saveUserBookmark(UserBookmark userBookmark) {
	// TODO Auto-generated method stub
	//DataStore.add(userBookmark);
	try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jid_thrillio?useSSL=false", "root", "root");
			Statement stmt = conn.createStatement();) {
		if(userBookmark.getBookmark() instanceof Book) {
			saveUserBook(userBookmark,stmt);
		}
		else if(userBookmark.getBookmark() instanceof Movie) {
			saveUserMovie(userBookmark,stmt);
		}
		else {
			saveUserWebLink(userBookmark,stmt);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
}

private void saveUserWebLink(UserBookmark userBookmark, Statement stmt) throws SQLException {
	// TODO Auto-generated method stub
	String query="insert into User_WebLink (user_id,movie_id) values (" +
			userBookmark.getUser().getId()+" ,"+userBookmark.getBookmark().getId();
			stmt.executeUpdate(query);
			
	
}

private void saveUserMovie(UserBookmark userBookmark, Statement stmt) throws SQLException {
	// TODO Auto-generated method stub
	String query="insert into User_Movie (user_id,movie_id) values (" +
	userBookmark.getUser().getId()+" ,"+userBookmark.getBookmark().getId();
	stmt.executeUpdate(query);
			
	
}

private void saveUserBook(UserBookmark userBookmark, Statement stmt) throws SQLException {
	// TODO Auto-generated method stub
	String query="insert into User_Book (user_id,book_id) values (" +
	userBookmark.getUser().getId()+" ,"+userBookmark.getBookmark().getId();
	stmt.executeUpdate(query);
	
}
	
}
