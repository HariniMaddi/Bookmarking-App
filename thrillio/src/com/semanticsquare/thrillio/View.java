package com.semanticsquare.thrillio;

import java.util.List;

import com.semanticsquare.thrillio.controllers.BookmarkController;
import com.semanticsquare.thrillio.entities.Bookmark;
import com.semanticsquare.thrillio.entities.User;

public class View {
	private static boolean getBookmarkDecision(Bookmark bookmark) {
		return Math.random()<0.5 ? true:false;
	}
	public static void bookmark(User user,List<List<Bookmark>>bookmarks) {
		
		System.out.println("\n"+user.getEmail()+" is browsing items..");
		int bookmarkCount=0;
		
		for(List<Bookmark> bookmarkList : bookmarks) {
			for(Bookmark bookmark : bookmarkList) {
				boolean isBookmarked=getBookmarkDecision(bookmark);
				
				if(isBookmarked) {
					bookmarkCount++;
					
					BookmarkController.getInstance().saveUserBookmark(user, bookmark);
					System.out.println("New item Bookmarked");
				}
			}
		
		}
	}

}
